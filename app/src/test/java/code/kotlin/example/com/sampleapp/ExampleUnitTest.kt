package code.kotlin.example.com.sampleapp

import code.kotlin.example.com.sampleapp.activity.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(1+1, 2)
    }

    @Test
    fun username_is_jessica(){
        assertEquals(MainActivity.printString(), "jess jessie jeje")
    }
}
