package com.example.tanujkulshrestha.cryptodetective;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tanujkulshrestha on 16/03/17.
 */

public class LoginPage extends ActionBarActivity{

    DataBaseAdapter DataBaseAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        setContentView(R.layout.login_data);
        Button btn = (Button) findViewById(R.id.button);
        Button cancellogin = (Button) findViewById(R.id.button2);
        final EditText UserName = (EditText) findViewById(R.id.username);
        final EditText Password = (EditText) findViewById(R.id.pwd);
        DataBaseAdapter = new DataBaseAdapter(this);
        DataBaseAdapter = DataBaseAdapter.open();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String userName = UserName.getText().toString();
                String password = Password.getText().toString();
                System.out.println(password);
                String storedPassword = DataBaseAdapter
                        .getSinlgeEntry(userName);
                System.out.println(storedPassword);
                if (password.equals(storedPassword)) {
                    Toast.makeText(LoginPage.this,
                            "Congrats: Login Successfull", Toast.LENGTH_LONG)
                            .show();
                    Intent main = new Intent(LoginPage.this, LevelList.class);
                    startActivity(main);
                } else {
                    Toast.makeText(LoginPage.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        cancellogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent4;
                intent4 = new Intent(LoginPage.this,MainActivity.class);
                LoginPage.this.startActivity(intent4);
            }
        });




        }
        }


