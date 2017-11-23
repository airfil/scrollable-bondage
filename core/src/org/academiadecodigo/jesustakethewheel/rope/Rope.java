package org.academiadecodigo.jesustakethewheel.rope;

import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.jesustakethewheel.player.Player;

/**
 * Created by codecadet on 23/11/2017.
 */
public class Rope {

    private Player playerOne;
    private Player playerTwo;
    private Vector2 position;
    private float maxSize;

    public Rope(Player playerOne , Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void update(){

    }


}
