package data

import com.google.firebase.FirebaseException
import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult
import java.io.IOException

suspend fun <T> handleFirebaseOperationWithErrorCode(operation: suspend () -> UtilsResult<T, ErrorHandler>): UtilsResult<T, ErrorHandler> {
    return try {
        operation()
    } catch (e: IOException) {
        Result.Error(ErrorHandler.NetworkError)
    } catch (e: FirebaseException) {
        val code = e.errorCode.toString().toIntOrNull() ?: -1
        when (code) {
            in 400..499 -> Result.Error(ErrorHandler.ClientError(code))
            in 500..599 -> Result.Error(ErrorHandler.ServerError(code))
            else -> Result.Error(ErrorHandler.UnknownError(e.message))
        }
    } catch (e: Exception) {
        Result.Error(ErrorHandler.UnknownError(e.message))
    }
}
