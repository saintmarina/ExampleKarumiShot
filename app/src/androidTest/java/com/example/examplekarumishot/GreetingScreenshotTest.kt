package com.example.examplekarumishot


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.examplekarumishot.ui.theme.ExampleKarumiShotTheme
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class GreetingScreenshotTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun rendersTheDefaultComponent() {
        renderComponent()
        compareScreenshot(composeRule.onRoot())
    }

    @Test
    fun rendersAGreetingWithAnEmptyText() {
        renderComponent("")
        compareScreenshot(composeRule)
    }

    @Test
    fun rendersAGreetingWithAShortText() {
        renderComponent("Hello!")
        compareScreenshot(composeRule)
    }

    private fun renderComponent(greeting: String? = null) {
        composeRule.setContent {
            if (greeting == null) {
                DefaultPreview()
            } else {
                greetingComponent(greeting)
            }
        }
    }

    @Composable
    private fun greetingComponent(greeting: String) {
        ExampleKarumiShotTheme {
            Surface(color = MaterialTheme.colors.background) {
                Greeting(greeting)
            }
        }
    }

}