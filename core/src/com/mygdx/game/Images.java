package com.mygdx.game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.io.File;

class Images {

    //Fields
    Stage stage;
    Viewport viewport;


    Label parrot;
    Label nadeko;

    int framenumber = 0;
    int counter = 0;

    char alphabet = 'a';

    //Constructor
    Images(SpriteBatch batch) {
        viewport = new ScreenViewport(new OrthographicCamera());

        //Parrot frames
        BitmapFont ParrotFrame = new BitmapFont(
                //File.separator acts as a / for distinguishing folders within folders
                Gdx.files.internal("image" + File.separator + "RareParrot.fnt"),
                false
        );

        //Nadeko frames
        BitmapFont NadekoFrame = new BitmapFont(
                Gdx.files.internal("image" + File.separator + "Nadeko.fnt"),
                false
        );

        stage = new Stage(viewport, batch);

        //Display Table (score)
        Table displayTable = new Table();
        //.top .center and such says where certain items should be displayed on screen
        displayTable.top();
        displayTable.setFillParent(true);


        //Test says what to display on screen
        //Color choices to display item
        parrot = new Label("", new Label.LabelStyle(ParrotFrame, Color.WHITE));
        nadeko = new Label("", new Label.LabelStyle(NadekoFrame, Color.WHITE));

        //Size of text: (1-2 good)
        parrot.setFontScale(0.3f);
        nadeko.setFontScale(1f);


        //expandX makes all displayed things equidistant in certain area rather side by side
        //Value after padTop is distance from top of screen score should be (10 good)
        displayTable.add(parrot);
        displayTable.add(nadeko);

        stage.addActor(displayTable);
    }

    //Method which sets the text of the Images
    //To be used in GameScreen or update method
    void RareParrot (String frameupdate) {
        parrot.setText(frameupdate);
    }
    void NadekoGif (String frameupdate) {
        nadeko.setText(frameupdate);
    }

    //Update method
    void update () {
        //int counter for code not every frame
        counter++;


        //All for framenumber
        //resets frame to 0 after hits last frame
        if (framenumber>9) {
            framenumber=0;
        }

        //System.out.println(framenumber);
        RareParrot(Integer.toString(framenumber));

        //Happens every 2 frames
        if (counter % 2 == 0) {
            //Updates frames of parrot picture
            framenumber++;
        }


        /*
        True order of frames is:
        0, 1, 6
        2, 3, 7
        4, 5, 8
        9

        Order of char is from 48 to 57
        */


        //All for alphabet based
        if (alphabet >'o') {
            alphabet = 'a';
        }

        //System.out.println(alphabet);
        NadekoGif(Character.toString(alphabet));
        if (counter % 6 == 0) {
            alphabet++;
        }

        //You can apparently iterate though the alphabet
//        for (char alphabet = 'a'; alphabet <= 'o'; alphabet++) {
//            System.out.println(alphabet);
//        }

    }

}
