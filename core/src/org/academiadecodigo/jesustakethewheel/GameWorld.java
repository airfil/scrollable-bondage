package org.academiadecodigo.jesustakethewheel;

import org.academiadecodigo.jesustakethewheel.platform.Platform;
import org.academiadecodigo.jesustakethewheel.platform.PlatformFactory;
import org.academiadecodigo.jesustakethewheel.player.Player;
import org.academiadecodigo.jesustakethewheel.rope.Rope;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameWorld {

    private Player playerOne;
    private Player playerTwo;
    private Rope rope;
    private LinkedList<Platform> platforms;
    private Platform testPlatform;



    public GameWorld(){

        playerOne = new Player();
        playerTwo = new Player();
        platforms = new LinkedList<>();
        rope = new Rope(playerOne,playerTwo);



    }

    private enum Stages{
       // Stages go here
    }



    public void update() {
        if(platforms.size() < 10){
            platforms.addAll(PlatformFactory.platformFactory(platforms));
        }
    }


    public LinkedList<Platform> getPlatforms() {
        return platforms;
    }
}
