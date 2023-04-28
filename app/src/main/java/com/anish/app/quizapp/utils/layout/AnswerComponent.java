package com.anish.app.quizapp.utils.layout;

import android.content.Context;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.anish.app.quizapp.R;
import com.anish.app.quizapp.databinding.LayoutAnswerLayoutBinding;
import com.anish.app.quizapp.databinding.LayoutButtonComponentBinding;

public class AnswerComponent {
    private final LayoutAnswerLayoutBinding bind;

    public AnswerComponent(LayoutAnswerLayoutBinding bind) {
        this.bind = bind;
    }

    public void onClicked(View.OnClickListener onClickListener) {
        bind.mainContainer.setOnClickListener(onClickListener);
    }

    public void unSelect(Context context) {
        bind.mainContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.background_option_answer));
    }

    public void onSelect(Context context) {
        bind.mainContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.background_selected_answer));
    }

    public String getText() {
        return bind.answerText.getText().toString().trim();
    }

}
