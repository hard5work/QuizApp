package com.anish.app.quizapp.ui.result;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.navigation.Navigation;

import com.anish.app.quizapp.R;
import com.anish.app.quizapp.databinding.FragmentResultBinding;
import com.anish.app.quizapp.databinding.FragmentResultBinding;
import com.anish.app.quizapp.ui.base.BaseFragment;
import com.anish.app.quizapp.utils.layout.ButtonComponent;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ResultFragment extends BaseFragment<FragmentResultBinding> {
    private FragmentResultBinding mViewDataBinding;


    private ButtonComponent buttonComponent;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_result;
    }

    @Override
    protected void initView(View mRootView, ViewDataBinding mViewDataBinding) {
        this.mViewDataBinding = (FragmentResultBinding) mViewDataBinding;
        buttonComponent = new ButtonComponent(this.mViewDataBinding.takeAnotherShot);
        buttonComponent.setText("Take Another Shot");
        buttonComponent.onClicked(v -> {
            Navigation.findNavController(v).navigate(R.id.action_resultFragment_to_quizFragment);
        });
    }
}