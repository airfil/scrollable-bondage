package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Platform {

    private final float HEIGHT = 30;

    private Sprite sprite;
    private Vector2 position;
    private float widht ;


    public Platform(float widht , Vector2 position , Sprite sprite){
       this.sprite = sprite;
       this.position = position;
       this.widht = widht;

       init();
    }

    private void init(){

        sprite.setPosition(position.x,position.y);
        sprite.setSize(widht,HEIGHT);

    }


    public void update(){



    }


    public Sprite getSprite() {
        return sprite;
    }

    public Vector2 getPosition() {
        return position;
    }
}
