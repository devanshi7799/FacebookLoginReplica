package com.example.demo123again;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText newpass,newemail,fname,lname,byear;
    RadioButton male,female;
    RadioGroup gender;
    Button btnnew;
    TextView bday,bmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bday=(TextView)findViewById(R.id.bday);
        bmonth=(TextView)findViewById(R.id.bmonth);
        byear=(EditText)findViewById(R.id.byear);
        newpass=(EditText)findViewById(R.id.newpass);
        newemail=(EditText)findViewById(R.id.newemail);
        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        gender=(RadioGroup) findViewById(R.id.gender);
        btnnew=(Button)findViewById(R.id.btnnew);

        String month[]={"January","February","March","April","May","June","July","August","Septemper","October","November","December"};
        final String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};


        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });

        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(Register.this,bday);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        bday.setText(item.getTitle().toString());
                        return false;
                    }
                });
            }
        });

        bmonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(Register.this,bmonth);
                popupMenu.getMenuInflater().inflate(R.menu.popup2,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        bmonth.setText(item.getTitle().toString());
                        return false;
                    }
                });
            }
        });
    }

    TextWatcher textWatcher =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(newpass.getText().toString().isEmpty() || newemail.getText().toString().isEmpty() || fname.getText().toString().isEmpty() || lname.getText().toString().isEmpty())
            {
                btnnew.setEnabled(false);
            }
            else {
                btnnew.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
