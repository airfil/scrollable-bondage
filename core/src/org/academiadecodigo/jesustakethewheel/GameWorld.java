package org.academiadecodigo.jesustakethewheel;

import org.academiadecodigo.jesustakethewheel.platform.Platform;
import org.academiadecodigo.jesustakethewheel.player.Player;
import org.academiadecodigo.jesustakethewheel.rope.Rope;

import java.util.List;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameWorld {

    private Player playerOne;
    private Player playerTwo;
    private Rope rope;
    private List<Platform> platforms;

    public GameWorld(){

        playerOne = new Player();
        playerTwo = new Player();
        rope = new Rope(playerOne,playerTwo);

    }

    private enum Stages{
       // Stages go here
    }



    public void update() {

    }
}
