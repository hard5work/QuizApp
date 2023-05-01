package com.anish.app.quizapp;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.anish.app.quizapp.databinding.FragmentLoginBinding;
import com.anish.app.quizapp.ui.MainActivity;
import com.anish.app.quizapp.ui.login.LoginFragment;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;


import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.HiltTestApplication;
/*@RunWith(MockitoJUnitRunner.class)
public class LoginFragmentTest {

    private LoginFragment loginFragment;
    private FragmentScenario<LoginFragment> fragmentScenario;
    private FragmentLoginBinding mViewDataBinding;

    @Mock
    private PrefManager prefManager;

    @Before
    public void setUp() {
        loginFragment = new LoginFragment();
        fragmentScenario = FragmentScenario.launchInContainer(LoginFragment.class);
        fragmentScenario.onFragment(fragment -> {
            mViewDataBinding = fragment.mViewDataBinding;
            fragment.prefManager = prefManager;
        });
    }

    @Test
    public void testNavigate() {
        View view = mViewDataBinding.getRoot();
        NavController navController = Navigation.findNavController(view);
        int expectedDestination = R.id.action_loginFragment_to_quizFragment;

        loginFragment.navigate();

        assertEquals(expectedDestination, navController.getCurrentDestination().getId());
    }

    @Test
    public void testOnClickFunction_withEmptyText() {
        String emptyString = "";
        doReturn(emptyString).when(mViewDataBinding.inputName).getText();

        loginFragment.onClickFunction();

        verify(mViewDataBinding.inputName).setError("Please enter name.");
        verify(prefManager, never()).setUsername(emptyString);
        verify(loginFragment, never()).navigate();
    }

    @Test
    public void testOnClickFunction_withNonEmptyText() {
        String nonEmptyString = "Test User";
        doReturn(nonEmptyString).when(mViewDataBinding.inputName).getText();

        loginFragment.onClickFunction();

        verify(mViewDataBinding.inputName).setError(null);
        verify(prefManager).setUsername(nonEmptyString);
        verify(loginFragment).navigate();
    }

    @Test
    public void testCheckValidation_withEmptyUsername() {
        doReturn("").when(prefManager).getUsername();

        loginFragment.checkValidation();

        verify(loginFragment, never()).navigate();
    }

    @Test
    public void testCheckValidation_withNonEmptyUsername() {
        doReturn("Test User").when(prefManager).getUsername();

        loginFragment.checkValidation();

        verify(loginFragment).navigate();
    }
}*/
