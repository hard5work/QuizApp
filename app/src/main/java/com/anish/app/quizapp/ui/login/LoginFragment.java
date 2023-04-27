package com.anish.app.quizapp.ui.login;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.navigation.Navigation;

import com.anish.app.quizapp.R;
import com.anish.app.quizapp.databinding.FragmentLoginBinding;
import com.anish.app.quizapp.ui.base.BaseFragment;
import com.anish.app.quizapp.utils.layout.ButtonComponent;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<FragmentLoginBinding> {
    private FragmentLoginBinding mViewDataBinding;

    private ButtonComponent buttonComponent;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View mRootView, ViewDataBinding mViewDataBinding) {
        this.mViewDataBinding = (FragmentLoginBinding) mViewDataBinding;
        buttonComponent = new ButtonComponent(this.mViewDataBinding.createUser);
        buttonComponent.setText("Create User");
        buttonComponent.onClicked(v -> {
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_quizFragment);
        });
    }
}
