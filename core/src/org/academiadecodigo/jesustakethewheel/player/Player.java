package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.Animation;

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
    private Animation<TextureRegion> fowardAnimation;
    private TextureAtlas atlas;
    private World world;
    private Fixture playerPhysicsFixture;
    private float time;

    private boolean isMovingRight;
    private boolean isMovingLeft;

    public Player(World world) {

        this.world = world;

        playerController = new PlayerController(this);
        atlas =  new TextureAtlas("playerOne.atlas");
        fowardAnimation = new Animation<TextureRegion>(0.5f,atlas.getRegions());
        sprite = new Sprite(new Texture("player.png"));
        sprite.setPosition(220, 200);


        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(), sprite.getY());

        body = world.createBody(bodyDef);


        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 1.0f;
        fixtureDef.restitution = 3f;

        playerPhysicsFixture = body.createFixture(fixtureDef);
    }

    public void jump() {

        time += Gdx.graphics.getDeltaTime();
        sprite.setRegion(fowardAnimation.getKeyFrame(time/0.5f,true));

        if (isPlayerJumping()) {
            return;
        }


        body.applyLinearImpulse(0, 300, body.getWorldCenter().x, body.getWorldCenter().y, true);

        if (body.getLinearVelocity().x > 50) {

            body.applyLinearImpulse(300, 0, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
        }
        if (body.getLinearVelocity().x < -50) {

            body.applyLinearImpulse(-300, 0, body.getWorldCenter().x, body.getWorldCenter().y - 20, true);
        }
    }

    public void moveRight() {
        time += Gdx.graphics.getDeltaTime();
        sprite.setRegion(fowardAnimation.getKeyFrame(time/0.5f,true));
        body.applyForceToCenter(200f, 0, true);
    }

    public void moveLeft() {
        time += Gdx.graphics.getDeltaTime();
        sprite.setRegion(fowardAnimation.getKeyFrame(time/0.5f,true));
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

        return body.getLinearVelocity().y > 20 || body.getLinearVelocity().y < -20;
    }
}
