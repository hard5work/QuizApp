package com.anish.app.quizapp.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;

import com.anish.app.quizapp.data.sp.SharedPref;

import dagger.hilt.android.AndroidEntryPoint;


public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    public SharedPref prefManager;
    private ProgressDialog progressDialog;
    private T mViewDataBinding;

    @LayoutRes
    public abstract int getLayoutId();

    protected abstract void initView(View mRootView, ViewDataBinding mViewDataBinding);


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    protected MutableLiveData<Boolean> baseLiveDataLoading = new MutableLiveData<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prefManager = new SharedPref(requireContext());
        progressDialog = new ProgressDialog(requireContext());
        progressDialog.setCancelable(false);
        initView(mViewDataBinding.getRoot(), mViewDataBinding);

    }
    public void showDialog(){
        progressDialog.show();
    }
    public void hideDialog(){
        progressDialog.dismiss();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


}

