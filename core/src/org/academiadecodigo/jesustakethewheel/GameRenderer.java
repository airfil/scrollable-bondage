package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private SpriteBatch spriteBatch;

    public GameRenderer(GameWorld gameWorld){

        this.gameWorld = gameWorld;

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }



}
