package org.academiadecodigo.jesustakethewheel.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.jesustakethewheel.ScrollableBondageGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.height= 500;
		config.width=480;

		new LwjglApplication(new ScrollableBondageGame(), config);
	}
}
