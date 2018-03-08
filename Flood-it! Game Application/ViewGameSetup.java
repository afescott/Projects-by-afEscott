package applicationprogramming.floodit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ashleyescott on 09/02/2018.
 */

public class ViewGameSetup  extends AppCompatActivity {
    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);





    }


}
