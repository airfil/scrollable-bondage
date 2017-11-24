package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import javafx.stage.Stage;
import org.academiadecodigo.jesustakethewheel.platform.FactoryPlat;
import org.academiadecodigo.jesustakethewheel.platform.Platform;
import org.academiadecodigo.jesustakethewheel.player.Player;
import org.academiadecodigo.jesustakethewheel.rope.Rope;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameWorld {

    private Player playerOne;
    private Player playerTwo;
    private Rope rope;
    private Background background;
    private Sprite entrance;
    private Stages stage;
    private BitmapFont font;

    private World world;
    private LinkedList<Platform> platforms;

    public GameWorld() {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("PressStart2P.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;
        parameter.color = Color.PINK;
        font = generator.generateFont(parameter);
        Texture entranceTexture = new Texture(Gdx.files.internal("entry.png"));
        entrance = new Sprite(entranceTexture);
        entrance.setPosition(0, 0);
        background = new Background();
        rope = new Rope(playerOne, playerTwo);
        world = new World(new Vector2(0f, -98f), true);
        playerOne = new Player(world);
        playerTwo = new Player(world);
        platforms = new LinkedList<Platform>();
        stage = Stages.START;

        platforms.add(new Platform(world, 100, 100));
    }

    private enum Stages {
        START,
        PLAY;
    }


    public void update() {

        if(stage == Stages.START) {


            if(input.isKeyPressed(Input.Keys.ENTER)){
                stage = Stages.PLAY;
            }



            if (platforms.size() < 1000) {
                platforms.offer(FactoryPlat.platforms(platforms.peekLast(), platforms.size(), world));
            }
        }

        if(stage == Stages.PLAY) {
            Platform platform;
            ListIterator<Platform> listIterator = platforms.listIterator();
            while (listIterator.hasNext()) {
                platform = listIterator.next();
                platform.update();
                if (platform.getSprite().getY() <= 10) {
                    world.destroyBody(platform.getBody());
                    listIterator.remove();
                    listIterator.add(FactoryPlat.platforms(platforms.peekLast(), platforms.size(), world));
                    platform = null;

                }

            }
            background.update();
            entrance.setPosition(entrance.getX(), entrance.getY() - 0.5f);

            if (background.getSprite().getY() < 0) {
                background = new Background();
            }

            playerOne.update();
        }
    }


    public World getWorld() {
        return world;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public LinkedList<Platform> getPlatforms() {
        return platforms;
    }

    public Background getBackground() {
        return background;
    }

    public Sprite getEntrance() {
        return entrance;
    }

    public BitmapFont getFont() {
        return font;
    }
}
