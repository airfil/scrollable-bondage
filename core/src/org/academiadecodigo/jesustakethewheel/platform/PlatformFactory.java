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
/*
    private final static int[] xPositions = new int[]{0, 150, 300, 450, 600};

    public static LinkedList<Platform> platformFactory(LinkedList<Platform> platformsList) {


        LinkedList<Platform> platforms = new LinkedList<>();
        int possibleX[] = new int[2];
        int levelPlatforms =2; //(int) Math.ceil(Math.random() * 2);


        Texture rectangleTexture = new Texture(Gdx.files.internal("rectangle.png"));
        Sprite sprite = new Sprite(rectangleTexture);

        /*int maxWidht = 100;
        int minWidht = 25;
        int range = (maxWidht - minWidht) + 1;
        int randomWidht = (int)(Math.random() * range) + minWidht;

        int randomWidht = 50;

        int randomXPosition;
        int randomYPosition = 90;


        if (platformsList.isEmpty()) {
            System.out.println("Oh caralho dos level platforms: " + levelPlatforms);

            for (int i = 0; i < levelPlatforms; i++) {
                System.out.println("Este i é : " + i);
                if (i == 0) {
                    randomXPosition = (int) Math.floor(Math.random() * (xPositions.length - 1));
                    platforms.add(new Platform( sprite,new Vector2(xPositions[randomXPosition],
                            randomYPosition)));
                    continue;
                }

                possibleX = getPossiblePositions(platforms);
                System.out.println(possibleX[0] +" " + possibleX[1]);
                randomXPosition = (int) Math.floor(Math.random() * (possibleX.length - 1));
                platforms.add(new Platform(sprite,new Vector2(possibleX[randomXPosition],
                        randomYPosition)));

            }
            return platforms;
        }


        Platform lastPlatform = platformsList.peekLast();
        float lastPlatformY = lastPlatform.getSprite().getY();
        randomYPosition = (int) lastPlatformY + (90);

        for (int i = 0; i < levelPlatforms; i++) {
            if (i == 0) {
                possibleX = getPossiblePositions(platformsList);
                randomXPosition = (int) Math.floor(Math.random() * (possibleX.length));
                platforms.add(new Platform( sprite, new Vector2(possibleX[randomXPosition],
                        randomYPosition)));
                continue;
            }

            possibleX = getPossiblePositions(platforms);
            randomXPosition = (int) Math.floor(Math.random() * (possibleX.length));
            platforms.add(new Platform( sprite, new Vector2(possibleX[randomXPosition],
                    randomYPosition)));

        }






        return platforms;


    }


    private static int[] getPossiblePositions(LinkedList<Platform> platforms) {

        Platform lastPlatform = platforms.peekLast();
        float lastPlatformX = lastPlatform.getSprite().getX();
        int count = 0;
        int[] possiblePositions = new int[2];

        for (int i : xPositions) {

            if (i == lastPlatformX) {
                if (xPositions[0] == i) {
                    possiblePositions[0] = xPositions[1];
                    possiblePositions[1] = xPositions[1];
                    break;
                }
                if (i == xPositions[xPositions.length - 1]) {
                    possiblePositions[0] = xPositions[xPositions.length - 2];
                    possiblePositions[1] = xPositions[xPositions.length - 2];
                    break;
                }
                possiblePositions[1] = xPositions[count + 1];
                possiblePositions[0] = xPositions[count - 1];
                break;

            }
            count++;

        }


        return possiblePositions;
    }

*/
}
