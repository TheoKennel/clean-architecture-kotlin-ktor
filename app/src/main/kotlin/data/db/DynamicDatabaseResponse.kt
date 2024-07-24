package data.db

import com.google.firebase.FirebaseException
import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult
import java.io.IOException
import java.sql.SQLException

suspend fun <T> handleOperationWithErrorCode(operation: suspend () -> T): UtilsResult<T, ErrorHandler> {
    return try {
        Result.Success(operation())
    } catch (e: IOException) {
        Result.Error(ErrorHandler.NetworkError)
    } catch (e: Exception) {
        handleException(e)
    }
}

private fun <T> handleException(e: Exception): UtilsResult<T, ErrorHandler> {
    return when (val errorCode = extractErrorCode(e)) {
        in 400..499 -> Result.Error(ErrorHandler.ClientError(errorCode))
        in 500..599 -> Result.Error(ErrorHandler.ServerError(errorCode))
        else -> Result.Error(ErrorHandler.UnknownError(e.message))
    }
}

private fun extractErrorCode(e: Exception): Int {
    return when (e) {
        is FirebaseException -> e.errorCode.toString().toIntOrNull() ?: -1
        is SQLException -> e.errorCode
        else -> -1
    }
}

