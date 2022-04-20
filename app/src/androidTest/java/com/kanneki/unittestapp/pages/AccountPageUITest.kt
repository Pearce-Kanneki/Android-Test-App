package com.kanneki.unittestapp.pages

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.MainActivity
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.di.AppModule
import com.kanneki.unittestapp.presention.account.AccountPage
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_SEND_USER_DATA
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_USER_ACCOUNT
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_USER_PASSWORD
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_NOT_VALUE_MESSAGE
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_VALUE_MESSAGE
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class AccountPageUITest {

    @get:Rule(order = 0)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.setContent {
            val navController = rememberNavController()

            UnitTestAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = BottomNavigationScreen.Account.rounte
                ) {
                    composable(BottomNavigationScreen.Account.rounte) {
                        AccountPage()
                    }
                }
            }
        }
    }

    @Test
    fun sendUserData_clickButton_showUserData() {
        with(composeRule) {

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText("請輸入帳號"))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("請輸入密碼"))

            // 輸入資料
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT)
                .performTextInput(UserData.Root.account)
            waitForIdle()

            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD)
                .performTextInput(UserData.Root.password)
            waitForIdle()

            // 檢查輸入資料是否有輸入
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText(UserData.Root.account))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("••••••"))

            // 點擊送出按鍵
            onNodeWithTag(TAG_BUTTON_SEND_USER_DATA).performClick()
            waitForIdle()

            // 確認顯示資料是否正確
            onNodeWithTag(TAG_TEXT_VALUE_MESSAGE)
                .assertIsDisplayed()
                .assert(hasText("登入使用者: Root"))

        }
    }

    @Test
    fun sendErrorUserData_clickButton_showNotFind() {
        with(composeRule) {

            val errData = "abc123"

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText("請輸入帳號"))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("請輸入密碼"))

            // 輸入資料
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT)
                .performTextInput(errData)
            waitForIdle()

            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD)
                .performTextInput(errData)
            waitForIdle()

            // 檢查輸入資料是否有輸入
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText(errData))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("••••••"))

            // 點擊送出按鍵
            onNodeWithTag(TAG_BUTTON_SEND_USER_DATA).performClick()
            waitForIdle()

            // 確認顯示資料是否正確
            onNodeWithTag(TAG_TEXT_NOT_VALUE_MESSAGE)
                .assertIsDisplayed()
                .assert(hasText("Not Find"))

        }
    }

    @Test
    fun sendUserData_butAccountIsEmpty_clickButton_showNotAccount() {
        with(composeRule) {

            val errData = "abc123"

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText("請輸入帳號"))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("請輸入密碼"))

            // 輸入資料
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT)
                .performTextInput("")
            waitForIdle()

            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD)
                .performTextInput(errData)
            waitForIdle()

            // 檢查輸入資料是否有輸入
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText(""))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("••••••"))

            // 點擊送出按鍵
            onNodeWithTag(TAG_BUTTON_SEND_USER_DATA).performClick()
            waitForIdle()

            // 確認顯示資料是否正確
            onNodeWithTag(TAG_TEXT_NOT_VALUE_MESSAGE)
                .assertIsDisplayed()
                .assert(hasText("Not Account"))

        }
    }

    @Test
    fun sendUserData_butPasswordIsEmpty_clickButton_showNotPassword() {
        with(composeRule) {

            val errData = "abc123"

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText("請輸入帳號"))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("請輸入密碼"))

            // 輸入資料
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT)
                .performTextInput(errData)
            waitForIdle()

            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD)
                .performTextInput("")
            waitForIdle()

            // 檢查輸入資料是否有輸入
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText(errData))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText(""))

            // 點擊送出按鍵
            onNodeWithTag(TAG_BUTTON_SEND_USER_DATA).performClick()
            waitForIdle()

            // 確認顯示資料是否正確
            onNodeWithTag(TAG_TEXT_NOT_VALUE_MESSAGE)
                .assertIsDisplayed()
                .assert(hasText("Not Password"))

        }
    }

    @Test
    fun sendEmptyUserData_clickButton_showNotAccount(){
        with(composeRule) {

            // 檢查Hint
            onNodeWithTag(TAG_TEXT_FIELD_USER_ACCOUNT).assert(hasText("請輸入帳號"))
            onNodeWithTag(TAG_TEXT_FIELD_USER_PASSWORD).assert(hasText("請輸入密碼"))

            // 點擊送出按鍵
            onNodeWithTag(TAG_BUTTON_SEND_USER_DATA).performClick()
            waitForIdle()

            // 確認顯示資料是否正確
            onNodeWithTag(TAG_TEXT_NOT_VALUE_MESSAGE)
                .assertIsDisplayed()
                .assert(hasText("Not Account"))

        }
    }
}