package com.anish.app.quizapp.utils.layout;

import android.view.View;

import com.anish.app.quizapp.databinding.LayoutButtonComponentBinding;

public class ButtonComponent {
    private final LayoutButtonComponentBinding bind;

    public ButtonComponent(LayoutButtonComponentBinding bind) {
        this.bind = bind;
    }

    public void onClicked(View.OnClickListener onClickListener) {
        bind.mainContainer.setOnClickListener(onClickListener);
    }

    public void setText(String text) {
        bind.buttonText.setText(text);
    }
}
