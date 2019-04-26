package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

    //FIELDS
    private MyGdxGame game;

    //What does any of this do? Unnecessary for game to run apparently
    //private OrthographicCamera gameCam;
    //private Viewport gamePort;
//    private final int LEVEL_WIDTH;
//    private final int LEVEL_HEIGHT;

    private HUD hud;
    private Highscore highscore;
    private Images images;
    private MusicMono musicmono;

    private GameData gamedata;

    //CONSTRUCTOR
    GameScreen(MyGdxGame game) {
        this.game = game;

        //gameCam = new OrthographicCamera();
        //What does gamePort do???
        //gamePort = new ExtendViewport(LEVEL_WIDTH, LEVEL_HEIGHT, gameCam);
//        LEVEL_WIDTH = MyGdxGame.V_WIDTH;
//        LEVEL_HEIGHT = MyGdxGame.V_HEIGHT;

        images = new Images(game.batch);
        highscore = new Highscore();
        hud = new HUD();
        musicmono = new MusicMono();

        gamedata = new GameData();

    }

    //METHODS
    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        update();

        //Clears Screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Allows images to be transparent
        game.batch.enableBlending();

        game.batch.begin();

        game.batch.end();
        images.stage.draw();
        hud.stage.draw();
        game.batch.begin();

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
    }

    private void update() {
        images.update();
        highscore.update();
        hud.update();
        musicmono.update();

        gamedata.update();
    }
}
