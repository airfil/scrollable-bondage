package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

/**
 * Created by codecadet on 24/11/2017.
 */
public class FactoryPlat {

    public static Platform platforms(Platform platform, int size) {

        Texture rectangleTexture = new Texture(Gdx.files.internal("platform.png"));
        Sprite sprite = new Sprite(rectangleTexture);
        Platform newPlatform = null;


        if (size == 0) {

            newPlatform = new Platform(sprite, new Vector2(190, 30));

            return newPlatform;
        }

        System.out.println(platform.getSprite().getX() + " X ");

        System.out.println(platform.getSprite().getY() + " Y ");

        int platformPreviousX = (int) platform.getSprite().getX();
        int platformNextX = 0;

        int random = (int) (Math.random()*2);

        if (random == 0) {
            platformNextX = platformPreviousX - 80;
        }

        if (random == 1) {
            platformNextX = platformPreviousX + 80;
        }

        if (platformPreviousX == 30) {
            platformNextX = 110;
        }

        if (platformPreviousX == 350) {
            platformNextX = 270;
        }

        newPlatform = new Platform(sprite, new Vector2(platformNextX, platform.getSprite().getY() + 60));

        return newPlatform;

    }


}
