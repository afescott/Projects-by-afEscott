package applicationprogramming.floodit;

import android.view.GestureDetector;

import java.util.Random;


/**
 * Created by ashleyescott on 29/01/2018.
 */

public class Game {

    private GameStatus state;
    public static int DEFAULT_WIDTH = 12;
    private static int DEFAULT_STEPS = 22;
    /**
     * The default amount of rows in the game (vertical "pixel" amount)
     */
    public static int DEFAULT_HEIGHT = 12;

    /**
     * The default amount of colours in the game. More colours is more difficult.
     */



    private final int[][] mData;

    public enum GameStatus {
        Win, Lose

    }

    public boolean boardFilled() {
        int firstSquare = getColour(0, 0);
        for (int col = 0; col < getColumn(); col++) {
            for (int row = 0; row < getRow(); col++) {
                if (mData[col][row] != firstSquare) {
                    return false;


                }
            }
        }
        return true;
    }

    public int getSteps() {
        if (boardFilled()) {
            state = GameStatus.Win;
        } else if (DEFAULT_STEPS <= 0) {
            state = GameStatus.Lose;


        }
        return DEFAULT_STEPS;

    }

    public int resetSteps() {
        DEFAULT_STEPS = 22;
        return DEFAULT_STEPS;


    }

    public int setSteps() {
        int steps = getSteps();
        steps = steps - 1;
        DEFAULT_STEPS = steps;
        return DEFAULT_STEPS;


    }

    //This piece of code would not work via my macbook due to low version of android studio but works fine
    // on the linux pc's in p235, hope it works for you
public State getState() { return state;}

    public int getColour(int col, int row) {
        return mData[col][row];

    }

    public int getColumn() {
        return DEFAULT_WIDTH;
    }


    public int getRow() {
        return DEFAULT_HEIGHT;
    }




    public Game(int col, int rows) {

        DEFAULT_HEIGHT = col;

        DEFAULT_WIDTH = rows;

        mData = new int[col][rows];

        int n;
        Random random = new Random();
        for (int row = 0; row < getRow(); row++) {
            for (int cols = 0; cols < getColumn(); cols++) {
                n = random.nextInt(5);

                mData[cols][row] = n;
            }
        }
    }


    public void playMove(int colour, int x, int y) {
        int oldColour = getColour(x, y);

        mData[x][y] = colour;

        if (x - 1 >= 0 && (mData[x - 1][y] == oldColour)) {

            playMove(colour, x - 1, y);

        }
        if (x + 1 < 12 && (mData[x + 1][y] == oldColour)) {
            // mData[x+1][y]= colour;
            playMove(colour, x + 1, y);


        }
        if (y - 1 >= 0 && (mData[x][y - 1] == oldColour)) {

            playMove(colour, x, y - 1);

        }
        if (y + 1 < 12 && (mData[x][y + 1] == oldColour)) {

            playMove(colour, x, y + 1);

        }


    }
}








































