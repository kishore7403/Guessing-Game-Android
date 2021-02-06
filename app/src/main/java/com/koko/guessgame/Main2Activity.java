package com.koko.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    TextView tv1,tv2;
    Button bt2,btn3;
    EditText edt2;
    int win=0;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt2=(Button)findViewById(R.id.button2);
        edt2=(EditText)findViewById(R.id.editText2);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView8);
        btn3=(Button)findViewById(R.id.button3);

        btn3.setVisibility(View.INVISIBLE);

        String nog=getIntent().getStringExtra("numberOfGuesses");
        String rng=getIntent().getStringExtra("Range");
        int rng1=Integer.parseInt(rng);
        final int nog1=Integer.parseInt(nog);




        final Random randy=new Random();
        final int theNumber=randy.nextInt(rng1+1);
        tv1.setText("hey "+getIntent().getStringExtra("Name")+"!!"+"\n"+"I am ready with a number between 0-"+rng+"\n"+"Make your guess");
        tv2.setText("guess left:"+Integer.toString(nog1));



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intents);

            }
        });




        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suserguess = edt2.getText().toString();
                if (suserguess.length() == 0) {
                    Toast.makeText(Main2Activity.this, "Guess a number", Toast.LENGTH_SHORT).show();
                } else if (i < nog1 && win != 1) {
                    suserguess = edt2.getText().toString();
                    int iuserguess = Integer.parseInt(suserguess);
                    if (iuserguess == theNumber) {
                        tv1.setText("your guess was right!! The number was " + Integer.toString(theNumber));
                        win = 1;
                        btn3.setVisibility(View.VISIBLE);
                    } else if (iuserguess > theNumber) {
                        tv1.setText("Guess Lower than "+suserguess);
                        edt2.getText().clear();
                    } else {
                        tv1.setText("Guess higher than "+suserguess);
                        edt2.getText().clear();
                    }
                    i++;
                    tv2.setText("guess left:" + Integer.toString(nog1 - i));
                    if (win == 0 && i == nog1) {
                        tv1.setText("game over " + "the number was " + Integer.toString(theNumber));
                        btn3.setVisibility(View.VISIBLE);
                    }
                }

            }
        });





    }
}
