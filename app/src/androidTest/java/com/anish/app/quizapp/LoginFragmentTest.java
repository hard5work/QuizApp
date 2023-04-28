package com.anish.app.quizapp;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;

import static org.hamcrest.Matchers.is;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.anish.app.quizapp.ui.MainActivity;
import com.anish.app.quizapp.ui.login.LoginFragment;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;


import dagger.hilt.android.testing.HiltAndroidTest;

@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public class LoginFragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    private ActivityScenario<MainActivity> activityScenario;
    @Before
    public void setUp() {
        activityScenario = ActivityScenario.launch(MainActivity.class);
    }
    @Test
    public void testMessageIsDisplayed() {
       /* Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.message))
                .check(ViewAssertions.matches(ViewMatchers.withText("Hello, world!")));*/
    }

    @Test
    public void testFragment() {
        FragmentScenario<LoginFragment> scenario = FragmentScenario.launch(LoginFragment.class);
        scenario.onFragment(fragment -> {
            // Add your test code here
           /* View view = fragment.requireView();
            view.findViewById(R.id.createUser).setVisibility(View.VISIBLE);
            TextView textView = view.findViewById(R.id.buttonText);
            assertThat(textView.getText().toString(), is("Hello World!"));*/
            fragment.checkValidation();
            fragment.setText("Hello");
            fragment.checkValidation();
        });
    }

    @After
    public void tearDown() {
        activityScenario.close();
    }
}
