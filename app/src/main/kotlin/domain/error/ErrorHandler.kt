package domain.error

sealed class ErrorHandler {
    data class ServerError(val code: Int, val message: String): ErrorHandler()
    data class ClientError(val code: Int, val message: String): ErrorHandler()
    data class UnknownError(val message: String): ErrorHandler()
    data object NetworkError: ErrorHandler()
}

