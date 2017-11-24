package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by codecadet on 24/11/2017.
 */
public class FactoryPlat {

    public static Platform platforms(Platform platform, int size, World world) {

        Platform newPlatform;


        if (size == 0) {

            newPlatform = new Platform(world, 190, 30);

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

        newPlatform = new Platform(world, platformNextX, platform.getSprite().getY() + 60);

        return newPlatform;

    }


}
