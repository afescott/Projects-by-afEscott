package applicationprogramming.floodit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/*
S4908683 - Ashley Escott

Flood-It!

Submitted 19/02/2018


 */

public class FloodIt extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flood_it);


    }


    public void playGameOnClick(View view) {


        Intent intentLoadNewActivity = new Intent(FloodIt.this, ViewGameSetup.class);
        startActivity(intentLoadNewActivity);


    }

    public void ViewHowToPlay(View view) {


        Intent intentLoadNewActivity = new Intent(FloodIt.this, HowToPlay.class);
        startActivity(intentLoadNewActivity);


    }

    public void ViewSettings(View view) {


        Intent intentLoadNewActivity = new Intent(FloodIt.this, Settings.class);
        startActivity(intentLoadNewActivity);


    }


}




