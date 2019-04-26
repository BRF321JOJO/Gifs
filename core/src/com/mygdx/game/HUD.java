package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.File;

class HUD {
    Stage stage;
    private Table displayTable;

    private Label highscore;
    private Label randomnumber;
    private Label nextrow;

    HUD() {
        stage = new Stage(new ScreenViewport(new OrthographicCamera()));
        //First Table
        displayTable = new Table();

        displayTable.top();
        displayTable.setFillParent(true);

        //Adds actors
        stage.addActor(displayTable);


        BitmapFont pixelfontlocation = new BitmapFont(
                Gdx.files.internal("font" + File.separator + "pixelOperatorHB.fnt"),
                false
        );
        BitmapFont randomnumberlocation = new BitmapFont(
                Gdx.files.internal("font" + File.separator + "pixelOperatorHB.fnt"),
                false
        );


        highscore = new Label("", new Label.LabelStyle(pixelfontlocation, Color.WHITE));
        randomnumber = new Label("", new Label.LabelStyle(pixelfontlocation, Color.WHITE));
        nextrow = new Label("", new Label.LabelStyle(pixelfontlocation, Color.WHITE));

        highscore.setFontScale(1f);
        randomnumber.setFontScale(1f);
        nextrow.setFontScale(1f);

        displayTable.add(highscore).expandX().padTop(10);
        displayTable.add(randomnumber).expandX().padTop(10);

        displayTable.row();

        displayTable.add(nextrow).expandX().padTop(10);
    }

    void update() {
        highscore.setText("Highscore: " + Highscore.stringhighscore);
        randomnumber.setText("Current value: " + Highscore.stringrandomnumber);
        nextrow.setText("Next Row Test");
    }
}
