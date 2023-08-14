package dev.rranndt.mycomposetesting.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import dev.rranndt.mycomposetesting.R
import dev.rranndt.mycomposetesting.ui.theme.MyComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct() {
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.enter_length))
            .performTextInput("3")
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.count))
            .performClick()
        composeTestRule.onNodeWithTag(
            composeTestRule.activity.getString(R.string.count),
            useUnmergedTree = true
        )
            .assertHasNoClickAction()
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.result, 12.0))
            .assertExists()
    }

    @Test
    fun wrong_input_no_calculated() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length))
            .performTextInput("..3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 0.0))
            .assertExists()
    }
}