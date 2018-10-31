package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

public class CSC361_F18_Study extends Game 
{
	/** 
	 * platform independent entry point for the game. LibGdx instructed to through 
	 * setScreen() method by Game class to change current screen. call menuscreen to 
	 * start the game
	 */
	@Override
	public void create () 
	{
		//Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		//Load Assets
		Assets.instance.init(new AssetManager());
		
		/**
		 *	PREFERENCES AND AUDIO START GOES HERE
		 */
		
		/**
		 *  GOES STRAIGHT TO GAME SCREEN NOW. GOES TO MENU SCREEN LATER 
		 */
		setScreen(new GameScreen(this));
	}	
}
