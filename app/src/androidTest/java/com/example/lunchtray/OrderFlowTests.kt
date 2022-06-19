package com.example.lunchtray

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OrderFlowTests {

  @get:Rule()
  val activity = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun calculate_default_meals_price() {
    onView(withId(R.id.start_order_button))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("7,00")))
    onView(withId(R.id.next_button))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("9,50")))
    onView(withId(R.id.next_button))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("10,00")))
    onView(withId(R.id.next_button))
      .perform(click())
    onView(withId(R.id.total))
      .check(matches(withSubstring("10,84")))
  }

  @Test
  fun each_meal_different_price() {
    onView(withId(R.id.start_order_button))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("7,00")))
    onView(withId(R.id.entree_1))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("4,00")))
    onView(withId(R.id.entree_2))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("3,00")))
    onView(withId(R.id.entree_3))
      .perform(click())
    onView(withId(R.id.subtotal))
      .check(matches(withSubstring("2,00")))
  }
}