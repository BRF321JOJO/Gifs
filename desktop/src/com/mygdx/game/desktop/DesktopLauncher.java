package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] args) {

		//Borderless Window
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

		//Configurations for Desktop Version
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.resizable=true;
		cfg.height = MyGdxGame.V_HEIGHT;
		cfg.width = MyGdxGame.V_WIDTH;
		cfg.foregroundFPS=60;
		cfg.vSyncEnabled=true;

		//Names java file when run
		//cfg.title = "Flappy Cat";
		//Makes java image SalsaCat
		//cfg.addIcon("pixelcat.jpg", Files.FileType.Internal);

        cfg.initialBackgroundColor = Color.SLATE;
        //Crashes game if audio attempted to be played
		//cfg.disableAudio = true;


        //cfg.backgroundFPS = 0;


        //cfg.preferencesDirectory = "";
        //cfg.preferencesFileType = Files.FileType.Internal;

		new LwjglApplication(new MyGdxGame(), cfg);

	}
}