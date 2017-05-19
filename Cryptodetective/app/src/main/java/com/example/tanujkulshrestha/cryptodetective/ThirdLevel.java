package com.example.tanujkulshrestha.cryptodetective;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by tanujkulshrestha on 05/04/17.
 */

public class ThirdLevel extends ActionBarActivity{

    LevelsDataBaseAdapter LevelsDataBaseAdapter;
    private String level="Level3";
    private int count = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // no more this
        setContentView(R.layout.third_level);
        Button btn = (Button) findViewById(R.id.button);
        Button hint = (Button) findViewById(R.id.button1);
        hint.setEnabled(false);
        LevelsDataBaseAdapter = new LevelsDataBaseAdapter(this);
        LevelsDataBaseAdapter = LevelsDataBaseAdapter.open();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                EditText answer= (EditText) findViewById(R.id.editText);
                String ans= answer.getText().toString();
                String storedAnswer=LevelsDataBaseAdapter.getAnswer(level);
                if (storedAnswer.equals(ans))
                {
                    Toast.makeText(ThirdLevel.this,
                            "Right Answer!!", Toast.LENGTH_LONG)
                            .show();
                }
                else
                {
                    Toast.makeText(ThirdLevel.this,
                            "Please Try Again!!", Toast.LENGTH_LONG)
                            .show();
                     count++;
                }
                if(count==3)
                {
                    Button hint = (Button) findViewById(R.id.button1);
                    hint.setEnabled(true);
                }
            }
        });


        hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String storedHint=LevelsDataBaseAdapter.getHint(level);
                    Toast.makeText(ThirdLevel.this,
                            storedHint, Toast.LENGTH_LONG)
                            .show();

            }
        });


        }
        }


