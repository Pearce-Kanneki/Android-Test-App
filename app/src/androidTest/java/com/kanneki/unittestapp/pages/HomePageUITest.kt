package com.kanneki.unittestapp.pages

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kanneki.unittestapp.MainActivity
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.di.AppModule
import com.kanneki.unittestapp.presention.home.HomePage
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_VALUE
import com.kanneki.unittestapp.util.UtilTag.TAG_DIALOG_MESSAGE
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_PAGE_INDEX
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(AppModule::class)
class HomePageUITest {

    @get:Rule(order = 0)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.setContent {
            val navController = rememberNavController()

            UnitTestAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = BottomNavigationScreen.Home.rounte
                ) {
                    composable(BottomNavigationScreen.Home.rounte) {
                        HomePage(navController)
                    }
                }
            }
        }
    }

    @Test
    fun clickButton_textFiledIsNotValue_showDialog() {
        with(composeRule) {

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_PAGE_INDEX).assert(hasText("請輸入內容"))

            // 點擊Button
            onNodeWithTag(TAG_BUTTON_VALUE).performClick()
            waitForIdle()

            // 檢查是否出現Dialog提示
            onNodeWithTag(TAG_DIALOG_MESSAGE).assertIsDisplayed()
        }
    }
}