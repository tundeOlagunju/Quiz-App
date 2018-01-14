package com.example.olagunjutunde.smartbutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.olagunjutunde.smartbutton.R.id.yes_radio_button2;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String quizScore = getIntent().getStringExtra("Result_Key");
        String quizResult = getIntent().getStringExtra("Answers_key");

        TextView resultView =(TextView) findViewById(R.id.result);
        resultView.setText(quizScore);

        TextView youransView =(TextView) findViewById(R.id.yourans);
        youransView.setText(quizResult);

        TextView correctansView =(TextView) findViewById(R.id.correctans);
        correctansView.setText("\n1.yes"+"\n2.yes"+"\n3.no"+"\n4.yes" +"\n5.yes");



    }

public void retakeQuiz(View view){
    Intent i = new Intent (this,MainActivity.class);
    startActivity(i);
}


}

