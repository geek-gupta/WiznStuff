package com.example.gaurav.egluremoteappui

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented led_strip_fragment, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under led_strip_fragment.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.gaurav.egluremoteappui", appContext.packageName)
    }
}
