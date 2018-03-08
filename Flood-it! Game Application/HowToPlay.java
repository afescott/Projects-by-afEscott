package applicationprogramming.floodit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static applicationprogramming.floodit.R.id.textView2;

public class HowToPlay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);


        TextView textview = (TextView) findViewById(textView2);
        textview.setTextSize(20);
        textview.setText("Fill the Board with one colour using the colour panel without running out of turns");

    }
}
