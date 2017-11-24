package org.academiadecodigo.jesustakethewheel.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by codecadet on 24/11/2017.
 */
public class PlayerControllerTwo implements InputProcessor {

    private PlayerTwo player;

    public PlayerControllerTwo(PlayerTwo player){

        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {

            case Input.Keys.SHIFT_LEFT:
                player.jump();
                break;

            case Input.Keys.D:
                player.setMovingRight(true);
                break;

            case Input.Keys.A:
                player.setMovingLeft(true);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode) {

            case Input.Keys.D:
                player.setMovingRight(false);
                break;

            case Input.Keys.A:
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
