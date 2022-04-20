package com.kanneki.unittestapp.end_to_end

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.MainActivity
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.data.Screen
import com.kanneki.unittestapp.di.AppModule
import com.kanneki.unittestapp.presention.detail.DetailPage
import com.kanneki.unittestapp.presention.home.HomePage
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_NOT_VALUE
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_VALUE
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_PAGE_INDEX
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class PageEndToEndTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.setContent {
            UnitTestAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = BottomNavigationScreen.Home.rounte
                ) {
                    composable(BottomNavigationScreen.Home.rounte) {
                        HomePage(navController)
                    }
                    composable("${Screen.Detail.route}/{contentString}") {
                        DetailPage(it.arguments?.getString("contentString"))
                    }
                    composable(Screen.Detail.route) {
                        DetailPage(value = null)
                    }
                }
            }
        }
    }

    @Test
    fun homePage_clickButton_change_detailPage_notValue() {
        with(composeRule) {
            val inputMessage = "Test123"

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_PAGE_INDEX).assertTextContains("請輸入內容")

            // 輸入參數值並點擊不帶值Button
            onNodeWithTag(TAG_TEXT_FIELD_PAGE_INDEX).performTextInput(inputMessage)
            onNodeWithTag(TAG_BUTTON_NOT_VALUE).performClick()
            waitForIdle()

            // 確認畫面是否顯示正確
            onNodeWithText("Not Value").assertIsDisplayed()
            onNodeWithText("Test: $inputMessage").assertDoesNotExist()
        }
    }

    @Test
    fun homePage_clickButton_change_detailPage_Value() {
        with(composeRule) {
            val inputMessage = "Test123"

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_PAGE_INDEX).assertTextContains("請輸入內容")

            // 輸入參數值並點擊帶值Button
            onNodeWithTag(TAG_TEXT_FIELD_PAGE_INDEX).performTextInput(inputMessage)
            onNodeWithTag(TAG_BUTTON_VALUE).performClick()
            waitForIdle()

            // 確認畫面是否顯示正確
            onNodeWithText("Test: $inputMessage").assertIsDisplayed()
            onNodeWithText("Not Value").assertDoesNotExist()
        }
    }
}