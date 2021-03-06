package com.kanneki.unittestapp.pages

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.MainActivity
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.di.AppModule
import com.kanneki.unittestapp.presention.list.ListPage
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme
import com.kanneki.unittestapp.util.UtilTag.TAG_FLOAT_ACTION_BUTTON_ADD
import com.kanneki.unittestapp.util.UtilTag.TAG_ITEMS_LIST
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class ListPageUITest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.setContent {
            val navController = rememberNavController()

            UnitTestAppTheme {
                NavHost(
                    navController = navController,
                    startDestination= BottomNavigationScreen.List.rounte
                ) {
                    composable(BottomNavigationScreen.List.rounte) {
                        ListPage()
                    }
                }
            }
        }
    }

    @Test
    fun findList_total20() {
        with(composeRule) {
            // 確認已顯示
            onNodeWithText("Title 1").assertIsDisplayed()
            onNodeWithText("Message 1").assertIsDisplayed()

            // 滑到第10項
            onNodeWithTag(TAG_ITEMS_LIST).performScrollToIndex(9)
            waitForIdle()

            // 確認第10項是否存在
            onNodeWithText("Title 10").assertIsDisplayed()
            onNodeWithText("Message 10").assertIsDisplayed()

            // 確認第11項是否不存在
            onNodeWithText("Title 11").assertDoesNotExist()
            onNodeWithText("Message 11").assertDoesNotExist()
        }
    }

    @Test
    fun list_clickAddButton_listAddItem(){
        with(composeRule) {
            // 確認已顯示
            onNodeWithText("Title 1").assertIsDisplayed()
            onNodeWithText("Message 1").assertIsDisplayed()

            // 新增項目
            onNodeWithTag(TAG_FLOAT_ACTION_BUTTON_ADD).performClick()
            waitForIdle()

            // 滑到第11項
            onNodeWithTag(TAG_ITEMS_LIST).performScrollToIndex(10)
            waitForIdle()

            // 確認新增項目
            onNodeWithText("New Title 11").assertIsDisplayed()
            onNodeWithText("Message").assertIsDisplayed()
        }
    }
}