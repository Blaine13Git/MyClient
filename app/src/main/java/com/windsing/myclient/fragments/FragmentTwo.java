package com.windsing.myclient.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.windsing.myclient.R;
import com.windsing.myclient.modules.Question;

/**
 * Created by FC on 2017/4/17.
 */

public class FragmentTwo extends Fragment {
    private Button mTrueButton;
    private Button mFalseButton;

    private ImageButton mNextButton;
    private ImageButton mLastButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;

    /**
     * onCreate(...)方法调用setContentView(...)方法时，
     * FragmentTwo使用LayoutInflater类实例化布局文件中定义的每一个View对象
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        mQuestionTextView = (TextView) view.findViewById(R.id.question_text_view);
//        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
        upDateQuestion();

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                upDateQuestion();
            }
        });


        mTrueButton = (Button) view.findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) view.findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton) view.findViewById(R.id.next_img_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
                System.out.println(">>> " + mCurrentIndex);
                upDateQuestion();
            }
        });

        mLastButton = (ImageButton) view.findViewById(R.id.last_img_button);
        mLastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex == 0) {
                    mCurrentIndex = 4;
                } else {
                    mCurrentIndex = (mCurrentIndex % mQuestionBank.length) - 1;
                }

                System.out.println(">>> " + mCurrentIndex);
                upDateQuestion();

            }
        });

        return view;
    }

    private void upDateQuestion() {
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;

        messageResId = userPressedTrue == answerIsTrue ? R.string.correct_toast : R.string.incorrect_toast;

        Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT).show();
    }
}
