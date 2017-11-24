package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by codecadet on 24/11/2017.
 */
public class Background {

    private Sprite sprite;

    public Background() {
        Texture background = new Texture(Gdx.files.internal("building_background.png"));
        sprite = new Sprite(background);
    }
}
