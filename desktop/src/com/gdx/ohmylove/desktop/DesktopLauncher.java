package com.gdx.ohmylove.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.ohmylove.OhmyloveGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = OhmyloveGame.WIDTH;
		config.height = OhmyloveGame.HEIGHT;
		new LwjglApplication(new OhmyloveGame(), config);
	}
}
