package com.example.demo123again;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Forgotpass extends AppCompatActivity {

    Button btnbck;
    TextView text;
    EditText nameagain;
    ImageView bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        btnbck=(Button)findViewById(R.id.btnbck);
        text=(TextView)findViewById(R.id.text);
        nameagain=(EditText)findViewById(R.id.nameagain);
        bck=(ImageView)findViewById(R.id.bck);

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Forgotpass.this,MainActivity.class);
                startActivity(i);
            }
        });

        nameagain.addTextChangedListener(textWatcher);
        btnbck.addTextChangedListener(textWatcher);
        text.addTextChangedListener(textWatcher);

    }

    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(nameagain.getText().toString().isEmpty())
            {
                btnbck.setVisibility(View.GONE);
                text.setVisibility(View.VISIBLE);
            }
            else
            {
                btnbck.setVisibility(View.VISIBLE);
                text.setVisibility(View.GONE);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
