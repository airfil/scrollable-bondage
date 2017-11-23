package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Player {

    private Sprite sprite;
    private BodyDef bodyDef;
    private Body body;

    public Player(World world) {
        sprite = new Sprite(new Texture("player.jpeg"));

        sprite.setPosition(300, 300);

        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(), sprite.getY());

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0f;

        Fixture fixture = body.createFixture(fixtureDef);
    }

    public void jump() {

        System.out.println("jump");
        body.setLinearVelocity(body.getLinearVelocity().x, 0 );
        body.applyForceToCenter(0, 160000f, true);
    }

    public void update(){

        listenInput();
        sprite.setPosition(body.getPosition().x, body.getPosition().y);
    }


    private void listenInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            jump();
        }
    }

    public Sprite getSprite() {
        return sprite;
    }
}
