package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by codecadet on 24/11/2017.
 */
public class Coin {

    private Sprite sprite;

    public Coin(float x, float y) {

        sprite = new Sprite(new Texture("coin.png"));
        sprite.setPosition(x, y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void update() {

        sprite.setPosition(sprite.getX(), sprite.getY() -0.5f);
    }
}
