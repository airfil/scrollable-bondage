package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    public GameRenderer(GameWorld gameWorld){

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        spriteBatch = new SpriteBatch();

        this.gameWorld = gameWorld;
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Sprite playerOneSprite = gameWorld.getPlayerOne().getSprite();

        spriteBatch.begin();
        spriteBatch.draw(playerOneSprite, playerOneSprite.getX(), playerOneSprite.getY());
        spriteBatch.end();

        gameWorld.getWorld().step(1/60f, 6, 2);
    }



}
