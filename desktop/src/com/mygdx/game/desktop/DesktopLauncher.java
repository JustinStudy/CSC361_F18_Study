package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

import main.Main;

public class DesktopLauncher {
	private static boolean rebuildAtlas = true;
	private static boolean drawDebugOutline = true;
	
	public static void main (String[] arg) 
	{
		//rebuilds texture atlas every time the game is run on desktop
			if(rebuildAtlas)
			{
				Settings settings = new Settings();
				settings.maxWidth = 1024;
				settings.maxHeight = 1024;
				settings.debug = drawDebugOutline;
				//packs game world images like clouds and bunny head
				TexturePacker.process(settings, "assets-raw/images", "../core/assets/images",
						"Study.pack");
			}
				
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.title = "CanyonBunny";
			config.width = 800;
			config.height = 480;
				
			new LwjglApplication(new Main(), config);
	}
}
