package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import org.academiadecodigo.jesustakethewheel.platform.Platform;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private Sprite sprite;
    private Sprite endSprite;


    public GameRenderer(GameWorld gameWorld) {

        sprite = new Sprite(new Texture("menu.png"));
        endSprite = new Sprite(new Texture("final_with_coins.png"));


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
        gameWorld.getBackground().getSprite().draw(spriteBatch);
        gameWorld.getEntrance().draw(spriteBatch);
        spriteBatch.end();

        for (Platform platform : gameWorld.getPlatforms()) {
            spriteBatch.begin();
            platform.getSprite().draw(spriteBatch);
            platform.getSpriteWindow().draw(spriteBatch);
            spriteBatch.end();
        }

        for (Coin coin : gameWorld.getCoinList()) {

            spriteBatch.begin();
            coin.getSprite().draw(spriteBatch);
            spriteBatch.end();
        }

        spriteBatch.begin();
        spriteBatch.draw(playerOneSprite, playerOneSprite.getX(), playerOneSprite.getY());
        spriteBatch.draw(playerTwoSprite, playerTwoSprite.getX(), playerTwoSprite.getY());
        spriteBatch.end();

        if(gameWorld.getStages() == GameWorld.Stages.START) {
            spriteBatch.begin();
            sprite.draw(spriteBatch);
            spriteBatch.end();
        }

        if(gameWorld.getStages() == GameWorld.Stages.END){
            spriteBatch.begin();
            endSprite.draw(spriteBatch);
            gameWorld.getFont().draw(spriteBatch,String.valueOf(gameWorld.getScore()) ,150,75);
            spriteBatch.end();
        }

        gameWorld.getWorld().step(1 / 45f, 6, 2);
    }





}
