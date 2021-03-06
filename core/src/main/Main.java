package main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.Assets;
import game.WorldController;
import game.WorldRenderer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import game.Assets;

public class Main implements ApplicationListener 	
{
	private static final String TAG = Main.class.getName();
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	
	@Override
	public void create () 
	{
		//Set Libgdx log level to Debug
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Load Assets
		Assets.instance.init(new AssetManager());
		//Initialize controller and renderer
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
	}	
	
	@Override public void render() 
	{
		//Update game world by the time that has passed 
		//since last rendered frame
		worldController.update(Gdx.graphics.getDeltaTime());
		//Sets screen to sky blue
		Gdx.gl.glClearColor(0x64/255.0f,  0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		//clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//render game world to screen
		worldRenderer.render();
	}
	
	@Override public void resize(int width, int height) 
	{
		worldRenderer.resize(width, height);
	}

	@Override public void dispose() 
	{
		worldRenderer.dispose();
		Assets.instance.dispose();
	}

	
	/**
	 * only used for android
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub	
	}
	
	
	
	
	
	
}

