package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer renderer;


    public GameScreen(){

        gameWorld = new GameWorld();
        renderer = new GameRenderer(gameWorld);
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(gameWorld.getPlayerOne().getPlayerController());
        inputMultiplexer.addProcessor(gameWorld.getPlayerTwo().getPlayerControllerTwo());
        Gdx.input.setInputProcessor(inputMultiplexer);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameWorld.update();
        renderer.render(delta);
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
}
