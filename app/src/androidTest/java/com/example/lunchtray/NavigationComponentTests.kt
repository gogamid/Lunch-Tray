package com.example.lunchtray

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class NavigationComponentTests {
  lateinit var navController: TestNavHostController

  @Before
  fun setup() {
    navController = TestNavHostController(ApplicationProvider.getApplicationContext())
  }

  @Test
  fun testNavigationToEntreeScreen() {
    val startOrderScenario = launchFragmentInContainer<StartOrderFragment>()
    startOrderScenario.onFragment { fragment ->
      navController.setGraph(R.navigation.nav_graph)
      Navigation.setViewNavController(fragment.requireView(), navController)
    }
    onView(withId(R.id.start_order_button)).perform(click())
    assertEquals(navController.currentDestination?.id, R.id.entreeFragment)
  }
}