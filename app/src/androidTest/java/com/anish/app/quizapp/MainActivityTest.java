package com.anish.app.quizapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.anish.app.quizapp.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testValidEmailSubmission() {
        ActivityScenario<MainActivity> activityScenario = activityScenarioRule.getScenario();

     /*   // Find the email EditText and enter a valid email address
        Espresso.onView(ViewMatchers.withId(R.id.email_edittext))
                .perform(ViewActions.typeText("test@example.com"));

        // Click the submit button
        Espresso.onView(ViewMatchers.withId(R.id.submit_button))
                .perform(ViewActions.click());

        // Verify that the LoginActivity is finished and the next activity is started
        // (Assuming that the next activity is MainActivity)
        Espresso.onView(ViewMatchers.withId(R.id.main_activity))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));*/
    }
}
