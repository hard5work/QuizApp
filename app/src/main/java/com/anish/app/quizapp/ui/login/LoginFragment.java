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
    public FragmentLoginBinding mViewDataBinding;

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

        checkValidation();
        buttonComponent.onClicked(v -> {
         onClickFunction();
        });
    }

    public void onClickFunction(){
        if (getText().isEmpty()) {
            mViewDataBinding.inputName.setError("Please enter name.");
        } else {
            mViewDataBinding.inputName.setError(null);
            prefManager.setUsername(getText());
            navigate();
        }
    }

    public void checkValidation() {
        if (!prefManager.getUsername().isEmpty()) {
            navigate();
        }
    }

    public void setText(String name) {
        mViewDataBinding.inputName.setText(name);
    }

    public String getText() {
        return mViewDataBinding.inputName.getText().toString().trim();
    }

    public void navigate() {
        Navigation.findNavController(mViewDataBinding.getRoot()).navigate(R.id.action_loginFragment_to_quizFragment);
    }
}
