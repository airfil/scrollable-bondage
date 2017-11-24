package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Player {

    public static final int MAX_VELOCITY = 1000;

    private Sprite sprite;
    private Body body;
    private PlayerController playerController;
    private World world;
    private Fixture playerPhysicsFixture;

    private boolean isMovingRight;
    private boolean isMovingLeft;

    public Player(World world) {

        this.world = world;

        playerController = new PlayerController(this);

        sprite = new Sprite(new Texture("player 2.png"));
        sprite.setPosition(300, 300);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(), sprite.getY());

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;

        playerPhysicsFixture = body.createFixture(fixtureDef);
    }

    public void jump() {

        body.applyLinearImpulse(0, 2000, body.getWorldCenter().x, body.getWorldCenter().y, true);
        if (body.getLinearVelocity().x > 50) {

            body.applyLinearImpulse(1000, 0, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
        }
        if (body.getLinearVelocity().x < -50) {

            body.applyLinearImpulse(-1000, 0, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
        }
    }

    public void moveRight() {

        body.applyForceToCenter(200f, 0, true);
    }

    public void moveLeft() {

        body.applyForceToCenter(-200f, 0, true);
    }


    public void update() {

        if (isMovingRight && Math.abs(body.getLinearVelocity().x) < MAX_VELOCITY) {
            moveRight();
        }

        if (isMovingLeft && Math.abs(body.getLinearVelocity().x) < MAX_VELOCITY) {
            moveLeft();
        }

        sprite.setPosition(body.getPosition().x, body.getPosition().y);
        //System.out.println("mass : " + body.getMass());
    }

    public Sprite getSprite() {
        return sprite;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    private boolean isPlayerJumping() {

        return body.getLinearVelocity().y > 50 || body.getLinearVelocity().y < -50;
    }
}
