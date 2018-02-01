package applicationprogramming.floodit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

import static java.lang.Math.floor;

/**
 * Created by ashleyescott on 26/12/2017.
 */

public class GameSetup  extends View{

    private Paint mGridPaint;
    private Paint mPlayer1Paint;
    private Paint mPlayer2Paint;
    private Paint mBGPaint;
    private  int mColumns;
    private  int mRows;
    private  int[][] mData;

    public AbstractGame mGame =  new AbstractGame(AbstractGame.DEFAULT_WIDTH,
            AbstractGame.DEFAULT_HEIGHT, AbstractGame.DEFAULT_COLOUR_COUNT);

    public void GameSetup(int columns, int rows) {
        mColumns = columns;
        mRows = rows;

        mData = new int[columns][rows];

        mData[0][0] = 1; // used to assign colours
        mData[2][2] = 2;


    }
    public GameSetup(Context context) {

        super(context);
        init();




    }

    public int getToken(int column, int row) {
        return mData[column][row];
    }

    protected  void onDraw (Canvas canvas) {
        float SEPARATOR_RATIO = (float) 0.0;
        int columnCount = mGame.getColumn();
int rowCount = mGame.getRow();
        float diameterx = (float) floor(getHeight() / (columnCount + (columnCount + 1) * SEPARATOR_RATIO));
        float diametery = (float) floor(getHeight() / (columnCount + (columnCount + 1) * SEPARATOR_RATIO));
        float separator =  (diameterx * SEPARATOR_RATIO) ;
        float availableWidth = 200;
        float availableHeight = 200;
        canvas.drawRect(0, 0, availableWidth, availableHeight, mGridPaint);



        Paint paint1 = new Paint();
        paint1.setColor(0xFFFF0000);
        paint1.setStrokeWidth(20);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setColor(0xFF00FF00 );
        paint2.setStrokeWidth(20);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        paint3.setColor(0xFF0000FF);
        paint3.setStrokeWidth(20);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint();
        paint4.setColor(0xFF000000 );
        paint4.setStrokeWidth(20);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setAntiAlias(true);
        Paint paint5 = new Paint();
        paint5.setColor(0xffffff0f);
        paint5.setStrokeWidth(20);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setAntiAlias(true);
        Paint paint6 = new Paint();
paint6.setColor(0xFF00FFFF);
        paint6.setStrokeWidth(20);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setAntiAlias(true);

        Random random = new Random(6);



float screenHeight = this.getHeight();

float screenWidth = this.getWidth();

float squareSize = screenWidth / mGame.getColumn();

        for (int row = 3; row < mGame.getRow(); row++) {
        for (int col = 0; col < mGame.getColumn(); col++) {

                int randomResult = random.nextInt(6);

               // float cx = separator + (diameterx + separator ) * col  + diameterx /9;
                //float cy = separator + (diametery + separator) * row  + diametery/9 ;

                float cx = col * squareSize ;
                float cy = row *squareSize ;

                switch (randomResult) {
                    case 0:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize, paint1);
                        break;
                    case 1:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize, paint2);
                        break;
                    case 2:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize, paint3);
                        break;
                    case 3:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize, paint4);
                        break;
                    case 4:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize,paint5);
                        break;
                    case 5:
                        canvas.drawRect(cx, cy, cx+squareSize, cy+squareSize, paint6);
                        break;
                }





            }
        }



    }


    private void init() {


        mGridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mGridPaint.setStyle(Paint.Style.FILL);
        mGridPaint.setColor(0xffffffff);

        mPlayer1Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPlayer1Paint.setStyle(Paint.Style.FILL);
        mPlayer1Paint.setColor(0xffff0000);
        mPlayer2Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPlayer2Paint.setStyle(Paint.Style.FILL);
        mPlayer2Paint.setColor(0xffffff00);
        mBGPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBGPaint.setStyle(Paint.Style.FILL);
        mBGPaint.setColor(0xffffffff);

    }



}
