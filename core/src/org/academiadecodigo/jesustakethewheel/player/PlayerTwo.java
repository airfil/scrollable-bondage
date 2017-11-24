package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by codecadet on 24/11/2017.
 */
public class PlayerTwo {

    public static final int MAX_VELOCITY = 1000;

    private Sprite sprite;
    private Body body;
    private PlayerControllerTwo playerControllerTwo;

    private World world;
    private Fixture playerPhysicsFixture;

    private boolean isMovingRight;
    private boolean isMovingLeft;

    public PlayerTwo(World world) {

        this.world = world;

        playerControllerTwo = new PlayerControllerTwo(this);

        sprite = new Sprite(new Texture("player.png"));
        sprite.setPosition(200, 200);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(), sprite.getY());

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.1f;

        playerPhysicsFixture = body.createFixture(fixtureDef);
    }

    public void jump() {

        if (isPlayerJumping()) {
            return;
        }


        body.applyLinearImpulse(0, 500, body.getWorldCenter().x, body.getWorldCenter().y, true);

        if (body.getLinearVelocity().x > 50) {

            body.applyLinearImpulse(300, 150, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
        }
        if (body.getLinearVelocity().x < -50) {

            body.applyLinearImpulse(-300, 150, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
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
    }

    public Sprite getSprite() {
        return sprite;
    }

    public PlayerControllerTwo getPlayerControllerTwo() {
        return playerControllerTwo;
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    private boolean isPlayerJumping() {

        return body.getLinearVelocity().y > 5 || body.getLinearVelocity().y < -5;
    }
}
