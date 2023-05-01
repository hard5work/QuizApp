package com.anish.app.quizapp.ui;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import android.view.View;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.anish.app.quizapp.R;
import com.anish.app.quizapp.data.sp.SharedPref;
import com.anish.app.quizapp.databinding.FragmentLoginBinding;
import com.anish.app.quizapp.ui.login.LoginFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginFragmentTest {

    private LoginFragment loginFragment;
    private FragmentScenario<LoginFragment> fragmentScenario;
    private FragmentLoginBinding mViewDataBinding;

    @Mock
    private SharedPref prefManager;

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
}
