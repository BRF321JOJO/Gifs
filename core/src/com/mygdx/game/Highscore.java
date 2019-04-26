package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;


public class Highscore {
    private static double randomnumber;
    private static double highscore;
    static String stringhighscore;
    static String stringrandomnumber;

    //Creates/specifies preferences file
    private static Preferences prefsfile = Gdx.app.getPreferences("Highscore");

    //Creates/specifies FileHandle file
    private static FileHandle highscorefile = Gdx.files.local("Highscores");

    void update() {

        //Loading using new method
        //This places the first (highest) saved as the local double highscore
        //highscore = GameData.highScores[0];

        //Random number generator
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            randomnumber = 10000 * Math.random();
        }

        //Combinations of all values
        //Prefsstylecombo();
        //FileHandlecombo();

        //From Save/Handler/GameData method of saving
        if (randomnumber > highscore) {
            highscore = randomnumber;

            //Then sets tentative score as actual highscore
            SaveHandler.gamedata.addHighScore(highscore);
        }


        //Turns numbers into Strings so can be used in HUD
        stringrandomnumber = Double.toString(randomnumber);
        stringhighscore = Double.toString(highscore);
    }




//  Combination of all prefs methods
    private void Prefsstylecombo () {
        loadHighscoreprefs();
        setHighscoreprefs();
        resetHighscorePrefs();

        //Used after every new value set (or reset) to save value
        prefsfile.flush();
    }

    //Combination of all FileHandle methods
    private void FileHandlecombo () {
        try {
            loadHighscoreFileHandle();
            setHighscoreFileHandle();
            resetHighscoreFileHandle();
        } catch (NumberFormatException e) {
            //Sets default value of 0 if highscore missing
            highscorefile.writeString("0", false);
            System.err.println("Found missing information (String) in Highscores file. Applied fix: Default value of 0 set as highscore");
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~ Load files: Methods to load highscore value from their respective files
    private void loadHighscoreprefs() {
        //Sets highscore to current value designated under "highscore" key
        //If there is no value there, default second value (0) is placed instead
        highscore = prefsfile.getInteger("Highscore", 0);
    }

    private void loadHighscoreFileHandle () {
        //For this, highscorefile.realString() reads file for highscore saved value, and then converts to double.
        highscore = Double.valueOf(highscorefile.readString());
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~Set files: Methods which would set a new highscore
    private void setHighscoreprefs () {
        if (randomnumber > highscore) {
            highscore = randomnumber;

            prefsfile.putInteger("Highscore", (int)highscore);
        }
    }

    private void setHighscoreFileHandle() {
        if (randomnumber > highscore) {
            highscore = randomnumber;

            //Append false means that values in highscore file will be overwritten
            highscorefile.writeString(Double.toString(highscore), false);
        }
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~Reset files: Methods which would reset highscore
    private void resetHighscorePrefs () {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            highscore = 0;
            randomnumber = 0;

            prefsfile.putInteger("Highscore", 0);
        }
    }

    private void resetHighscoreFileHandle() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            highscore = 0;
            randomnumber = 0;

            highscorefile.writeString("0", false);
        }
    }


}
