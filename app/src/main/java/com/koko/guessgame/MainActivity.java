package com.koko.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp1,sp2;
    Button bt1;
    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.editText1);
        bt1=(Button)findViewById(R.id.button1);
        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);




        final Intent intent=new Intent(MainActivity.this,Main2Activity.class);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.range,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.guess,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter1);
        sp2.setOnItemSelectedListener(this);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=edt1.getText().toString();
                String range=sp1.getSelectedItem().toString();
                String numberOfGuesses=sp2.getSelectedItem().toString();
                if(Name.length()==0)
                    {
                    Toast.makeText(MainActivity.this,"Name field empty",Toast.LENGTH_SHORT).show();
                    }
                else
                    {
                    intent.putExtra("Name", Name);
                    intent.putExtra("Range", range);
                    intent.putExtra("numberOfGuesses", numberOfGuesses);
                    startActivity(intent);
                    }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
