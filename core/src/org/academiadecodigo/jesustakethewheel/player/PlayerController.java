package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by codecadet on 23/11/17.
 */
public class PlayerController implements InputProcessor {

    private Player player;

    public PlayerController(Player player){

        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {

            case Input.Keys.SPACE:
                player.jump();
                break;

            case Input.Keys.RIGHT:
                player.setMovingRight(true);
                break;

            case Input.Keys.LEFT:
                player.setMovingLeft(true);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode) {

            case Input.Keys.RIGHT:
                player.setMovingRight(false);
                break;

            case Input.Keys.LEFT:
                player.setMovingLeft(false);
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
