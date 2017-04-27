package com.windsing.myclient.modules;

/**
 * Created by FC on 2017/4/27.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    /**
     *
     * @param textResId，使用int类型，是因为textRes被放在string.xml文件中
     * @param answerTrue
     */
    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
