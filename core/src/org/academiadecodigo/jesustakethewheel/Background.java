package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by codecadet on 24/11/2017.
 */
public class Background {

    private Sprite spriteBackground;



    public Background() {
        Texture background = new Texture(Gdx.files.internal("building_background.png"));
        spriteBackground = new Sprite(background);
    }

    public void update(){
        spriteBackground.setPosition(spriteBackground.getX(), spriteBackground.getY() -0.5f);
    }

    public Sprite getSprite() {
        return spriteBackground;
    }
}
