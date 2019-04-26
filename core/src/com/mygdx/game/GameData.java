//None of this was thought of by me, but someone on YouTube: ForeignGuyMike

package com.mygdx.game;

import java.io.Serializable;

public class GameData implements Serializable {

    private static final long serialVersionUID = 1;

    private static final int MAX_SCORES = 3;
    static double[] highScores;

    private double tentativeScore;


    GameData() {
        highScores = new double[MAX_SCORES];
    }

    //Sets up empty highscores array
    void presethighscore() {
        for (int i = 0; i < MAX_SCORES; i++) {
            highScores[i] = 0;
        }
    }

    private double[] getHighScores() {return highScores;}

    public double getTenatativeScore() {return tentativeScore;}
    public void setTenatativeScore(double i) {tentativeScore = i;}

    private static boolean isHighScore(double score) {
        //MAX_SCORES - 1 means that a tentative scores just has to be greater than
        //The lowest score in the highscore array. MAX_SCORES - 1 represents this
        //point in this highScores array.
        //EX: Given 3 max scores, 3 - 1 equals 2, which is lowest scores on this array
        //*Note: Array starts at 0
        return score > highScores[MAX_SCORES - 1];
    }

    //But because of this, we need to resort array every time
    //This puts highest scores toward the top to avoid being removed at bottom
    static void addHighScore(double newScore) {
        if (isHighScore(newScore)) {
            highScores[MAX_SCORES - 1] = newScore;
            sortHighScores();
        }
    }

    //Some sorting algorithm for putting highest scores on top, lowest scores on bottom of array
    private static void sortHighScores() {
        for(int i = 0; i < MAX_SCORES; i++) {
            double score = highScores[i];

            for (int j = i - 1; j >= 0 && highScores[j] < score; j--) {
                highScores[j+1] = highScores[j];
            }
        }
    }

    void update() {
        SaveHandler.load();
        highScores = SaveHandler.gamedata.getHighScores();
    }

}
