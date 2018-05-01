package com.example.flashcards_app;

/**
 * Created by joe_r on 19/04/2018.
 */

public class Questions {
    private int mTextId;
    private boolean mAnswer;

    //create a construtor
    public Questions(int textId, boolean answer){
        mTextId = textId;
        mAnswer = answer;
    }
    //create the getter and setters for the constructor
    //these can be autogenerate as well
    public void setTextId(int textId) {
        mTextId = textId;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }


    public int getTextId() {
        return mTextId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

}