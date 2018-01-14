package com.example.olagunjutunde.smartbutton;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.y;
import static android.R.id.selectedIcon;
import static android.R.id.text1;
import static android.icu.text.Normalizer.YES;
import static com.example.olagunjutunde.smartbutton.R.id.yes_radio_button2;


public class MainActivity extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toTop = (Button) findViewById(R.id.back_to_top);

        toTop.setOnClickListener(
                new View.OnClickListener() {
            public void onClick(View view) {
                final ScrollView myScrollView = (ScrollView) findViewById(R.id.main_view);
                myScrollView.smoothScrollTo(0, 0);
            }
        });
    }

    public void getQuizResult(View view) {


        RadioGroup radioOne = (RadioGroup) findViewById(R.id.radio_grp_1);
        int answerOne = getSelectedButtonId(radioOne);
        RadioButton ansOne = (RadioButton) findViewById(answerOne);
       String text1 = checkRadioButtonForNull(ansOne);


        RadioGroup radioTwo = (RadioGroup) findViewById(R.id.radio_grp_2);
        int answerTwo = getSelectedButtonId(radioTwo);
        RadioButton ansTwo = (RadioButton) findViewById(answerOne);
        String text2 = checkRadioButtonForNull(ansTwo);

        RadioGroup radioThree = (RadioGroup) findViewById(R.id.radio_grp_3);
        int answerThree = getSelectedButtonId(radioThree);
        RadioButton ansThree  = (RadioButton) findViewById(answerThree);
        String text3 = checkRadioButtonForNull(ansThree);

        RadioGroup radioFour = (RadioGroup) findViewById(R.id.radio_grp_4);
        int answerFour = getSelectedButtonId(radioFour);
        RadioButton ansFour  = (RadioButton) findViewById(answerFour);
        String text4 = checkRadioButtonForNull(ansFour);

        RadioGroup radioFive = (RadioGroup) findViewById(R.id.radio_grp_5);
        int answerFive = getSelectedButtonId(radioFive);
        RadioButton ansFive = (RadioButton) findViewById(answerFive);
        String text5 = checkRadioButtonForNull(ansFive);

       if(text1 == "No answer"||text2 == "No answer"||text3 == "No answer"||text4 == "No answer"||text5 == "No answer"){
           Toast.makeText(this, "All Questions Must Be Answered", Toast.LENGTH_SHORT).show();
       }
       else{
           String quizResult = "1." + text1;
           quizResult += "\n" +"2."+ text2;
           quizResult += "\n" +"3."+text3;
           quizResult += "\n" +"4." +text4;
           quizResult += "\n" +"5." +text5;
           calculateScore(answerOne,answerTwo,answerThree,answerFour,answerFive);
           String message = createSummary(score);
           Toast.makeText(this, "Thanks For Taking This Quiz", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent (this,Main2Activity.class);
           intent.putExtra("Result_Key",message);
           intent.putExtra("Answers_key",quizResult);
           startActivity(intent);
       }



    }


    public String createSummary(int score){

        String message = "You Scored " + score + " out of 5";
        return message;
    }
   public int getSelectedButtonId(RadioGroup radio){
       int selectedId;
       selectedId = radio.getCheckedRadioButtonId();


       return selectedId;


   }
    public String checkRadioButtonForNull(RadioButton rb){
    String answer;
        if (rb != null){
           answer = rb.getText().toString();
        }
        else{
            answer = "No answer";
        }
        return  answer;
    }


    public void calculateScore(int answerOne,int answerTwo,int answerThree,int answerFour,int answerFive) {

        if (answerOne == R.id.yes_radio_button) {
            score += 1;
        }
        if (answerTwo == yes_radio_button2) {
            score += 1;
        }
        if (answerThree == R.id.no_radio_button3) {
            score += 1;
        }
        if (answerFour == R.id.yes_radio_button4) {
            score += 1;
        }
        if (answerFive == R.id.yes_radio_button5) {
            score += 1;



        }
    }
    @Override
    public  void onLowMemory(){
        System.gc();
    }
    }
