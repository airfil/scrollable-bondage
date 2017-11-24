package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import javafx.stage.Stage;
import org.academiadecodigo.jesustakethewheel.platform.FactoryPlat;
import org.academiadecodigo.jesustakethewheel.platform.Platform;
import org.academiadecodigo.jesustakethewheel.player.Player;
import org.academiadecodigo.jesustakethewheel.player.PlayerTwo;
import org.academiadecodigo.jesustakethewheel.rope.Rope;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameWorld {

    private Player playerOne;
    private PlayerTwo playerTwo;
    private Rope rope;
    private Background background;
    private Sprite entrance;
    private Stages stage;
    private BitmapFont font;
    private Sound song;
    private World world;
    private LinkedList<Platform> platforms;
    private List<Coin> coinList;
    private boolean isSongPlaying;
    private int score;

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

        world = new World(new Vector2(0f, -80f), true);
        playerOne = new Player(world);
        playerTwo = new PlayerTwo(world);
        platforms = new LinkedList<Platform>();
        stage = Stages.START;
        song = Gdx.audio.newSound(Gdx.files.internal("drake.wav"));
        coinList = new LinkedList<>();
    }

    public enum Stages {
        START,
        END,
        PLAY;
    }


    public void update() {

        if (stage == Stages.START) {


            if (input.isKeyPressed(Input.Keys.ENTER)) {
                stage = Stages.PLAY;
            }


            while(platforms.size() < 10) {
                platforms.offer(FactoryPlat.platforms(platforms.peekLast(), platforms.size(), world, coinList));
            }
        }

        if (stage == Stages.PLAY) {

            if(!isSongPlaying) {
                song.play();
                isSongPlaying = true;
            }

            Platform platform;
            ListIterator<Platform> listIterator = platforms.listIterator();
            while (listIterator.hasNext()) {
                platform = listIterator.next();
                platform.update();
                if (platform.getSprite().getY() <= -20) {
                    world.destroyBody(platform.getBody());
                    listIterator.remove();
                    listIterator.add(FactoryPlat.platforms(platforms.peekLast(), platforms.size(), world, coinList));
                    platform = null;

                }

            }
            background.update();
            entrance.setPosition(entrance.getX(), entrance.getY() - 0.5f);

            if (background.getSprite().getY() < 0) {
                background = new Background();
            }

            playerOne.update();
            playerTwo.update();

            if (playerOne.getSprite().getY() < -10 || playerTwo.getSprite().getY() < -10) {
                stage = Stages.END;
            }

            ListIterator<Coin> coinListIterator = coinList.listIterator();

            while (coinListIterator.hasNext()) {

                Coin coin = coinListIterator.next();
                coin.update();
                if((Math.abs(playerOne.getSprite().getX() - coin.getSprite().getX()) < 20 && Math.abs(playerOne.getSprite().getY() - coin.getSprite().getY()) < 20) ||
                        (Math.abs(playerTwo.getSprite().getX() - coin.getSprite().getX()) < 20 && Math.abs(playerTwo.getSprite().getY() - coin.getSprite().getY()) < 20)) {
                    score++;
                    coinListIterator.remove();
                    System.out.println(score);
                }
            }

        }

        if (input.isKeyPressed(Input.Keys.ENTER)) {
            stage = Stages.PLAY;
        }

        if (platforms.size() < 10) {
            platforms.offer(FactoryPlat.platforms(platforms.peekLast(), platforms.size(), world, coinList));
        }

    }


    public World getWorld() {
        return world;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public PlayerTwo getPlayerTwo() {
        return playerTwo;
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

    public Stages getStages(){
        return stage;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }
}
