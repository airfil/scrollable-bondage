package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Platform{

    //private final float HEIGHT = 30;
    //private final float WIDHT = 50;

    private Sprite sprite;
    private World world;
    private Body body;


    public Platform(World world, float x, float y) {
        this.world = world;
        sprite = new Sprite(new Texture("platform.png"));
        sprite.setPosition(x, y);

        System.out.println(sprite.getWidth());

        init();


    }

    private void init() {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(sprite.getX() + sprite.getWidth() / 2, sprite.getY() - sprite.getHeight() / 2);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.1f;

        body.createFixture(fixtureDef);

    }


    public void update() {


    }


    public Sprite getSprite() {
        return sprite;
    }

}
