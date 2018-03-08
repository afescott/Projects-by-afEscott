package applicationprogramming.floodit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by ashleyescott on 26/12/2017.
 */

public class GameView extends View {


    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;
    private Paint paint5;
    private Paint paint6;

    private int[][] mData;
    private GestureDetector mGestureDetector;


    public Game mGame = new Game(Game.DEFAULT_WIDTH, Game.DEFAULT_HEIGHT);


    public boolean onTouchEvent(MotionEvent ev) {
        // The line below passes the event to the onTouchEvent method of the GestureDetector class.
        // This analyzes the event and if applicable triggers the appropriate callbacks in the
        // GestureDetector.OnSimpleGestureListener class.


        boolean touch = this.mGestureDetector.onTouchEvent(ev);

        return super.onTouchEvent(ev) || touch;
    }


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        // You should always include onDown() and it should always return true.
        // Otherwise the GestureListener may ignore other events.


        public boolean onDown(MotionEvent ev) {
            return true;
        }


        public boolean onSingleTapUp(MotionEvent ev) {
            // Get location of touch, calculate the column that has been clicked.
            // Call the playToken method of Game to make coloured piece appear.
            // Use invalidate() to cause view  be redrawn.




            int xCord = (int) ev.getX();
            int yCord = (int) ev.getY();

            if (xCord > 300 && xCord < 875 && yCord > 1367) {

                mGame.resetSteps();
                Intent intent = new Intent(getContext(), ViewGameSetup.class);
                getContext().startActivity(intent);


            }
            if (xCord > 0 && xCord < 222 && yCord > 800 && yCord < 1200) {

                mGame.playMove(0, 0, 0);
                mGame.setSteps();
                invalidate();

            } else if (xCord >= 222 && xCord < 434 && yCord > 800 && yCord < 1200) {

                mGame.playMove(1, 0, 0);
                mGame.setSteps();
                invalidate();

            } else if (xCord >= 434 && xCord < 655 && yCord > 800 && yCord < 1200) {

                mGame.playMove(2, 0, 0);
                mGame.setSteps();
                invalidate();

            } else if (xCord >= 655 && xCord < 875 && yCord > 800 && yCord < 1200) {

                mGame.playMove(3, 0, 0);
                mGame.setSteps();
                invalidate();

            } else if (xCord >= 875 && xCord < 1100 && yCord > 800 && yCord < 1200) {

                mGame.playMove(4, 0, 0);
                mGame.setSteps();
                invalidate();

                // }
            }


            return true;

        }
    }


    public GameView(Context context) {
        super(context);


        mGestureDetector = new GestureDetector(context, new MyGestureListener());

    }


    public int getToken(int column, int row) {
        return mData[column][row];
    }


    protected void onDraw(Canvas canvas) {
        float SEPARATOR_RATIO = (float) 0.0;
        int columnCount = mGame.getColumn();





        paint1 = new Paint();
        paint1.setColor(0xFFFF0000);
        paint1.setStrokeWidth(20);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint2 = new Paint();
        paint2.setColor(0xFF00FF00);
        paint2.setStrokeWidth(20);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3 = new Paint();
        paint3.setColor(0xFF0000FF);
        paint3.setStrokeWidth(20);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint4 = new Paint();
        paint4.setColor(0xFF000000);
        paint4.setStrokeWidth(20);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setAntiAlias(true);
        paint5 = new Paint();
        paint5.setColor(0xffffff0f);
        paint5.setStrokeWidth(20);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setAntiAlias(true);
        paint6 = new Paint();
        paint6.setColor(0xFF00FFFF);
        paint6.setStrokeWidth(20);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setAntiAlias(true);






        float screenWidth = this.getWidth();

        float squareSize = screenWidth / mGame.getColumn();
        canvas.drawCircle(110, 1100, 95, paint1);
        canvas.drawCircle(330, 1100, 95, paint2);
        canvas.drawCircle(550, 1100, 95, paint3);
        canvas.drawCircle(770, 1100, 95, paint4);
        canvas.drawCircle(990, 1100, 95, paint5);


        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setTextSize(90);
        int stepsLeft = mGame.getSteps();
        canvas.drawText("Steps remaining " + stepsLeft
                , 300, 1300, paint);

        canvas.drawText("RESET GAME", 300, 1450, paint);


        for (int row = 0; row < 10; row++) {

            for (int col = 0; col < mGame.getColumn(); col++) {

                //  int randomResult = random.nextInt(5);
                int randomResult = mGame.getColour(col, row);
                // float cx = separator + (diameterx + separator ) * col  + diameterx /9;
                //float cy = separator + (diametery + separator) * row  + diametery/9 ;

                float cx = col * squareSize;
                float cy = row * squareSize;

                switch (randomResult) {
                    case 0:
                        canvas.drawRect(cx, cy, cx + squareSize, cy + squareSize, paint1);

                        break;
                    case 1:
                        canvas.drawRect(cx, cy, cx + squareSize, cy + squareSize, paint2);
                        break;
                    case 2:
                        canvas.drawRect(cx, cy, cx + squareSize, cy + squareSize, paint3);
                        break;
                    case 3:
                        canvas.drawRect(cx, cy, cx + squareSize, cy + squareSize, paint4);
                        break;
                    case 4:
                        canvas.drawRect(cx, cy, cx + squareSize, cy + squareSize, paint5);
                        break;

                }

            }

        }
    }


    //This piece of code would not work via my macbook due to low version of android studio but works fine
    // on the linux pc's in p235, hope it works for you
    if (mGame.getState() == Game.GameStatus.Win ) {
     canvas.drawText("Game Won! Congratz! "
     , 0, 1300, paint);


     } else (if mGame.getState() == Game.GameStatus.Lose) {
   canvas.drawText("You Lose. Unlucky! "
    , 0, 1300, paint);


     }


}
