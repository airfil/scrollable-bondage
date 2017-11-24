package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.jesustakethewheel.Scrollable;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Platform{

    //private final float HEIGHT = 30;
    //private final float WIDHT = 50;

    private Sprite sprite;
    private float widht;


    public Platform(Sprite sprite, Vector2 position) {
        this.sprite = sprite;

        //sprite.setSize(WIDHT, HEIGHT);
        sprite.setPosition(position.x,position.y);
        //super();

    }

    private void init() {



    }


    public void update() {


    }


    public Sprite getSprite() {
        return sprite;
    }


}
