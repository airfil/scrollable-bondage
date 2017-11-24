package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by codecadet on 24/11/2017.
 */
public class Coin {

    private Sprite sprite;
    private Animation<TextureRegion> fowardAnimation;
    private TextureAtlas atlas;
    private float time ;

    public Coin(float x, float y) {

        atlas =  new TextureAtlas("coin.atlas");
        fowardAnimation = new Animation<TextureRegion>(0.5f,atlas.getRegions());
        sprite = new Sprite(new Texture("coin.png"));
        sprite.setPosition(x, y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void update() {
        time += Gdx.graphics.getDeltaTime();
        sprite.setRegion(fowardAnimation.getKeyFrame(time/0.5f,true));
        sprite.setPosition(sprite.getX(), sprite.getY() -0.5f);
    }
}
