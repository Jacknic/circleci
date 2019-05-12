package com.jacknic.circleci


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * 用户UI测试
 *<p>官方例子 googlesamples/android-testing
 * https://github.com/googlesamples/android-testing/blob/master/ui/espresso/BasicSample/app/src/androidTest/java/com/example/android/testing/espresso/BasicSample/ChangeTextBehaviorKtTest.kt
 * </p>
 */
@RunWith(AndroidJUnit4::class)
class UiTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    /**
     * 测试点击事件
     */
    @Test
    fun testClick() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val ok = context.getString(android.R.string.ok)
        onView(withId(R.id.tvHello)).perform(click())
            .check(matches(withText(ok)))
    }
}
