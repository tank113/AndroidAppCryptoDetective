package com.example.tanujkulshrestha.cryptodetective;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.tanujkulshrestha.cryptodetective.R.id.username;

/**
 * Created by tanujkulshrestha on 16/03/17.
 */

public class SignUpPage extends ActionBarActivity{


    Context context = this;
    DataBaseAdapter DataBaseAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // no more this
        setContentView(R.layout.signup_data);
        DataBaseAdapter = new DataBaseAdapter(this);
        DataBaseAdapter = DataBaseAdapter.open();
        Button btn = (Button) findViewById(R.id.button);
        Button cancel = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText u_name= (EditText) findViewById(username);
                EditText pwd= (EditText) findViewById(R.id.pwd);
                String uname=u_name.getText().toString();
                String pass=pwd.getText().toString();
                // Perform action on click
                DataBaseAdapter.insertEntry(uname, pass);
                Toast.makeText(getApplicationContext(),
                        "Account Successfully Created ", Toast.LENGTH_LONG)
                        .show();
                Intent i = new Intent(SignUpPage.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent3;
                intent3 = new Intent(SignUpPage.this,MainActivity.class);
                SignUpPage.this.startActivity(intent3);
            }
        });



        }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        DataBaseAdapter.close();
    }
        }


