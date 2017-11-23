package org.academiadecodigo.jesustakethewheel.platform;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 23/11/2017.
 */
public class PlatformFactory {

    private final static int[] xPositions  = new int[]{0,150,300,450,600};

    public static LinkedList<Platform> platformFactory(LinkedList<Platform> platformsList) {



        LinkedList<Platform> platforms = new LinkedList<>();
        int possibleX[] = new int[2];
        //int levelPlatforms =(int)Math.ceil(Math.random() * 2);

        Texture rectangleTexture = new Texture(Gdx.files.internal("rectangle.png"));
        Sprite sprite = new Sprite(rectangleTexture);
        int jumpingDistance = 100;

        /*int maxWidht = 100;
        int minWidht = 25;
        int range = (maxWidht - minWidht) + 1;
        int randomWidht = (int)(Math.random() * range) + minWidht;*/
        int randomWidht = 50;

        int randomXPosition = (int)Math.floor(Math.random() * (xPositions.length-1));
        System.out.println("First: " + randomXPosition);
        int randomYPosition = 90;


        if (platformsList.isEmpty()) {
            platforms.add(new Platform(randomWidht, new Vector2(xPositions[randomXPosition], randomYPosition), sprite));
            return platforms;
        }


        Platform lastPlatform = platformsList.peekLast();
        float lastPlatformY = lastPlatform.getPosition().y;
        float lastPlatformX = lastPlatform.getPosition().x;
        randomYPosition = (int) lastPlatformY + (90);
        int count = 0;
        for (int i : xPositions) {

            if(i == lastPlatformX){
                if(xPositions[0] == i) {
                    possibleX[0] = xPositions[1];
                    possibleX[1] = xPositions[1];
                    break;
                }
                if(i == xPositions[xPositions.length-1]) {
                    possibleX[0] = xPositions[xPositions.length- 1];
                    possibleX[1] = xPositions[xPositions.length - 1];
                    break;
                }
                possibleX[1] = xPositions[count + 1];
                possibleX[0] = xPositions[count - 1];
                break;

            }
            count++;

        }

        randomXPosition = (int)Math.floor(Math.random() * 2);



        platforms.add(new Platform(randomWidht, new Vector2(possibleX[randomXPosition], randomYPosition), sprite));
        return platforms;


    }


}
