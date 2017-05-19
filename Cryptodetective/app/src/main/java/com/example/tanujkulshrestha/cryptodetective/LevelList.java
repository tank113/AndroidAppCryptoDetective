package com.example.tanujkulshrestha.cryptodetective;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by tanujkulshrestha on 15/03/17.
 */

public class LevelList extends ListActivity {
    Context context = this;
    LevelsDataBaseAdapter LevelsDataBaseAdapter;
    static final String[] LEVELS = new String[] { "Level1", "Level2", "Level3",
    };
    static final String[] allanswers = {

            "31avenuelondon",
            "BigBen",
            "31912"



    };

    static final String[] allhints = {

            "Google Maps, conditonal Operator, A=1",
            "Famous Clock in London",
            "Think about all the numbers from starting you entered or noticed"


    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LevelsDataBaseAdapter = new LevelsDataBaseAdapter(this);
        LevelsDataBaseAdapter = LevelsDataBaseAdapter.open();

        // no more this
        // setContentView(R.layout.list_fruit);



        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_level_list,LEVELS));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        for (int i=0;i < allanswers.length; i++)
        {

            LevelsDataBaseAdapter.insertEntry(LEVELS[i], allanswers[i], allhints[i]);
        }
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                try{
                    switch(position)
                    {
                        case 0:
                            // When clicked, show a toast with the TextView text
                            /*Cursor resultSet = mydatabase.rawQuery("Select * from Answers", null);
                            resultSet.moveToFirst();
                            String check=resultSet.getString(1);*/
                            Log.e("LevelActivity", "Errormain");
                            Intent intent1;
                            intent1 = new Intent(LevelList.this,FirstLevel.class);
                            LevelList.this.startActivity(intent1);

                            //Toast.makeText(getApplicationContext(),
                                    //check, Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Intent i;
                            i = new Intent(LevelList.this,SecondLevel.class);
                            LevelList.this.startActivity(i);
                            break;
                        case 2:
                            Intent in;
                            in = new Intent(LevelList.this,ThirdLevel.class);
                            LevelList.this.startActivity(in);
                               break;
                        default:
                            System.out.println("hhhh");
                            break;
                    };
                }
                catch (Exception exception)
                {

                }

            }
        });

    }

}
