package code.kotlin.example.com.sampleapp.utils

data class LceState<out T>(val status: LceStatus, val data: T?, val message: String?) {

    companion object {

        fun <T> loading(): LceState<T> {
            return LceState(LceStatus.LOADING, null, null)
        }

        fun <T> success(): LceState<T> {
            return LceState(LceStatus.SUCCESS, null, null)
        }

        fun <T> success(data: T?): LceState<T> {
            return LceState(LceStatus.SUCCESS, data, null)
        }

        fun <T> error(message: String?): LceState<T> {
            return LceState(LceStatus.ERROR, null, message)
        }
    }
}