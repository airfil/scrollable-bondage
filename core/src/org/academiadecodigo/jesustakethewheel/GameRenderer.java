package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.jesustakethewheel.platform.Platform;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    public GameRenderer(GameWorld gameWorld) {

        spriteBatch = new SpriteBatch();
        this.gameWorld = gameWorld;

    }

    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Texture texture = new Texture(Gdx.files.internal("building_background.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        Sprite playerOneSprite = gameWorld.getPlayerOne().getSprite();
        Sprite playerTwoSprite = gameWorld.getPlayerTwo().getSprite();

        spriteBatch.begin();

        spriteBatch.draw(playerOneSprite, playerOneSprite.getX(), playerOneSprite.getY());
        spriteBatch.draw(playerTwoSprite, playerTwoSprite.getX(), playerTwoSprite.getY());

        spriteBatch.end();

        for (Platform platform : gameWorld.getPlatforms()) {
            spriteBatch.begin();
            platform.getSprite().draw(spriteBatch);
            spriteBatch.end();
        }



        gameWorld.getWorld().step(1 / 60f, 6, 2);
    }


}
