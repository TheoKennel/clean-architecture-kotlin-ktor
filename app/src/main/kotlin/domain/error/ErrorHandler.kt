package domain.error

sealed class ErrorHandler {
    data class ServerError(val code: Int): ErrorHandler()
    data class ClientError(val code: Int): ErrorHandler()
    data class UnknownError(val code: Int): ErrorHandler()
    data object NetworkError: ErrorHandler()
}