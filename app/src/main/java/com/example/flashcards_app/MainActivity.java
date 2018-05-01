package com.example.flashcards_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //create Buttons and TextView for UI communcation
    private Button mTButton;
    private Button mFButton;
    private Button mNButton;
    private TextView mQuestionTextView;

    //create the question bank
    private Questions[] mQuestionPool = new Questions[]{
            new Questions(R.string.q1, true),
            new Questions(R.string.q2, false),
            new Questions(R.string.q3, true),
            new Questions(R.string.q4, true),
            new Questions(R.string.q5, false),
            new Questions(R.string.q6, true),
            new Questions(R.string.q7, false),
            new Questions(R.string.q8, false),
            new Questions(R.string.q9, true),
            new Questions(R.string.q10, false),
            new Questions(R.string.q11, false),
            new Questions(R.string.q12, true),
            new Questions(R.string.q13, true),
            new Questions(R.string.q14, false),
            new Questions(R.string.q15, true),
            new Questions(R.string.q16, false),
            new Questions(R.string.q17, false),
            new Questions(R.string.q18, true),
            new Questions(R.string.q19, true),
            new Questions(R.string.q20, false)
    };
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calls to the UI (TextView)
        //displays the text
        mQuestionTextView = (TextView) findViewById(R.id.questions);
        //calls to the UI (Button)
        mTButton = (Button) findViewById(R.id.tbutton);
        mTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //will define method in a moment
                checkAnswer(true);
            }
        });
        mFButton = (Button) findViewById(R.id.fbutton);
        mFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNButton = (Button) findViewById(R.id.nbutton);
        mNButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndex = (mIndex + 1) % mQuestionPool.length;
                updateQuestion();
            }
        });
        //method declaration
        updateQuestion();
    }
    //method updateQuestion
    //void so no return
    private void updateQuestion(){
        int question = mQuestionPool[mIndex].getTextId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPress){
        boolean answerTrue = mQuestionPool[mIndex].isAnswer();
        int messageResId = 0;
        if (userPress == answerTrue){
            messageResId = R.string.correct;
        }else{
            messageResId = R.string.incorrect;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}

