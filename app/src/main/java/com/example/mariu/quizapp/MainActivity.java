package com.example.mariu.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {
    int totalPoints;
    RadioButton q1a3,q2a1,q3aTrue,q4aFalse;
    EditText q5Edit;
    CheckBox q6a1,q6a2,q6a3,q7a4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1a3 = findViewById(R.id.questionOneAnswerThree_radio);
        q2a1 = findViewById(R.id.questionTwoAnswerOne_radio);
        q3aTrue = findViewById(R.id.questionThreeAnswerTrue_radio);
        q4aFalse = findViewById(R.id.questionFourAnswerFalse_radio);
        q5Edit = findViewById(R.id.questionFive_editText);
        q6a1 = findViewById(R.id.questionSixAnswerOne_checkbox);
        q6a2 = findViewById(R.id.questionSixAnswerTwo_checkbox);
        q6a3 = findViewById(R.id.questionSixAnswerThree_checkbox);
        q7a4 = findViewById(R.id.questionSixAnswerFour_checkbox);
        //to do marry me question

    }

    public void submitAnswers(View view) {
        totalPoints = 0;
        if (q1a3.isChecked()) {
            totalPoints++;
        }
        if (q2a1.isChecked()) {
            totalPoints++;
        }
        if (q3aTrue.isChecked()) {
            totalPoints++;
        }
        if (q4aFalse.isChecked()) {
            totalPoints++;
        }
        String q5String = q5Edit.getText().toString();
        if (q5String.equalsIgnoreCase("double")) {
            totalPoints++;
        }
        if ((q6a1.isChecked() && q7a4.isChecked()) && (!q6a2.isChecked() && !q6a3.isChecked())) {
            totalPoints++;
        }

        // 0 points
        String Zero = getResources().getString(R.string.toast0);
        //1 or 2 points
        String msgNoob = getResources().getString(R.string.toast1);
        String msgForNoob = String.format(msgNoob, totalPoints);
        // 3 or 4 points
        String msgNotAnoob = getResources().getString(R.string.toast2);
        String msgForNab = String.format(msgNotAnoob, totalPoints);
        // 5 or 6 points
        String msgPro = getResources().getString(R.string.toast3);
        String msgForPro = String.format(msgPro, totalPoints);

        if (totalPoints == 0) {
            //Toast.makeText(this, Zero,Toast.LENGTH_LONG).show();
            FancyToast.makeText(this, Zero, FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();
        } else if (totalPoints == 1 || totalPoints == 2) {
            //Toast.makeText(this, msgForNoob,Toast.LENGTH_LONG).show();
            FancyToast.makeText(this, msgForNoob, FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();
        } else if (totalPoints == 3 || totalPoints == 4) {
            //Toast.makeText(this, msgForNab,Toast.LENGTH_LONG).show();
            FancyToast.makeText(this, msgForNab, FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
        } else if (totalPoints == 5 || totalPoints == 6) {
            //Toast.makeText(this, msgForPro,Toast.LENGTH_LONG).show();
            FancyToast.makeText(this, msgForPro, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
        }
        reset(view, totalPoints);

    }

    public void reset(View view, int total) {
        total = 0;
        totalPoints = total;
        //reseting the activity of the app
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
