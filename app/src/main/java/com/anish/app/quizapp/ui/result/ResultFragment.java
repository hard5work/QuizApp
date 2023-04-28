package com.anish.app.quizapp.ui.result;

import android.os.Build;
import android.os.Debug;
import android.util.Log;
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

        this.mViewDataBinding.progressBar.setMax(100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.mViewDataBinding.progressBar.setMin(0);
        }
        assert getArguments() != null;
        int myArgument = getArguments().getInt("myArgument", 0);
        if (myArgument == 0) {
            this.mViewDataBinding.progressBar.setProgress(0);
        } else
            this.mViewDataBinding.progressBar.setProgress(myArgument);

        this.mViewDataBinding.progressPoint.setText(String.valueOf(myArgument));

        String pointInfo = "Your score was " + myArgument + " points.";
        this.mViewDataBinding.pointInfo.setText(pointInfo);

        String title = getRatingText(myArgument) + "  '" + prefManager.getUsername() + "' ";
        this.mViewDataBinding.playerName.setText(title);

        buttonComponent = new ButtonComponent(this.mViewDataBinding.takeAnotherShot);
        buttonComponent.setText("Take Another Shot");
        buttonComponent.onClicked(v -> {
            getArguments().clear();
            Navigation.findNavController(v).navigate(R.id.action_resultFragment_to_quizFragment);
        });
    }

    public String getRatingText(int percentageScore) {
        if (percentageScore >= 90) {
            return "Excellent";
        } else if (percentageScore >= 70) {
            return "Good";
        } else if (percentageScore >= 50) {
            return "Fair";
        } else if (percentageScore >= 30) {
            return "Poor";
        } else {
            return "Very Poor";
        }
    }
}