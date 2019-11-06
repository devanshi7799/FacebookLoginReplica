package com.example.demo123again;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView more,fpass;
    EditText name,pass;
    Button btnlog,btnreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlog=(Button)findViewById(R.id.btnlog);
        btnreg=(Button)findViewById(R.id.btnreg);
        more=(TextView)findViewById(R.id.more);
        fpass=(TextView)findViewById(R.id.fpass);
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,more);
                popupMenu.getMenuInflater().inflate(R.menu.more,popupMenu.getMenu());
                popupMenu.show();
            }
        });
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });

        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Forgotpass.class);
                startActivity(i);
            }
        });

        name.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(name.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
            {
                btnlog.setEnabled(false);
            }
            else
            {
                btnlog.setEnabled(true);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
