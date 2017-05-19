package com.example.tanujkulshrestha.cryptodetective;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by tanujkulshrestha on 11/03/17.
 */

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Errormain");
        Button loginbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button) findViewById(R.id.signup);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intentlog;
                intentlog = new Intent(MainActivity.this,LoginPage.class);
                MainActivity.this.startActivity(intentlog);
            }
        });
        signbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intentsign;
                intentsign = new Intent(MainActivity.this,SignUpPage.class);
                MainActivity.this.startActivity(intentsign);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*public void sendToPlay(View view) {
        // Do something in response to button
        Intent intent=new Intent(this,LevelList.class);
        startActivity(intent);
    }*/

}
