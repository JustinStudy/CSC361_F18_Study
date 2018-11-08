package game;

import util.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Assets implements Disposable, AssetErrorListener
{
	public static final String TAG = Assets.class.getName();
	
	public static final Assets instance = new Assets();
	
	private AssetManager assetManager;
	private Assets() {}
	
	public AssetPlayer player;
	public AssetGrass grass;
	public AssetCoin coin;
	public AssetUpvote upvote;
	public AssetDownvote downvote;
	public AssetLadder ladder;
	public AssetSpeedup speedup;
	public AssetLevelDecoration levelDecoration;
	
	public void init(AssetManager assetManager)
	{
		//set asset manager error handler
		assetManager.setErrorListener(this);
		//load texture atlas
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		//start loading assets and wait until finished
		assetManager.finishLoading();
		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for(String a : assetManager.getAssetNames())
		{
			Gdx.app.debug(TAG, "asset: " + a);
		}
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		
		//enable texture filtering for pixel smoothing
		for(Texture t : atlas.getTextures())
		{
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		//create game resource objects
		player = new AssetPlayer(atlas);
		grass = new AssetGrass(atlas);
		coin = new AssetCoin(atlas);
		upvote = new AssetUpvote(atlas);
		downvote = new AssetDownvote(atlas);
		ladder = new AssetLadder(atlas);
		speedup = new AssetSpeedup(atlas);
		levelDecoration = new AssetLevelDecoration(atlas);
	}
	
	@Override
	public void dispose()
	{
		assetManager.dispose();
	}
	
	public void error(String filename, Class type, Throwable throwable)
	{
		Gdx.app.error(TAG,  "Couldn't load asset '" + filename + "'", (Exception)throwable);
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable)
	{
		Gdx.app.error(TAG,  "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
	}
	
	public class AssetPlayer
	{
		public final AtlasRegion player;
		
		public AssetPlayer(TextureAtlas atlas)
		{
			player = atlas.findRegion("character");
		}
	}
	
	public class AssetGrass
	{
		public final AtlasRegion grass;
		
		public AssetGrass(TextureAtlas atlas)
		{
			grass = atlas.findRegion("grass");
		}
	}
	
	public class AssetCoin
	{
		public final AtlasRegion coin;
		
		public AssetCoin(TextureAtlas atlas)
		{
			coin = atlas.findRegion("coin");
		}
	}
	
	public class AssetUpvote
	{
		public final AtlasRegion upvote;
		
		public AssetUpvote(TextureAtlas atlas)
		{
			upvote = atlas.findRegion("upvote");
		}
	}
	
	public class AssetDownvote
	{
		public final AtlasRegion downvote;
		
		public AssetDownvote(TextureAtlas atlas)
		{
			downvote = atlas.findRegion("downvote");
		}
	}
	
	public class AssetLadder
	{
		public final AtlasRegion ladder;
		
		public AssetLadder(TextureAtlas atlas)
		{
			ladder = atlas.findRegion("ladder");
		}
	}
	
	public class AssetSpeedup
	{
		public final AtlasRegion speedup;
		
		public AssetSpeedup(TextureAtlas atlas)
		{
			speedup = atlas.findRegion("speedup");
		}
	}
	
	public class AssetLevelDecoration
	{
		public final AtlasRegion background;
		public final AtlasRegion foreground;
		public final AtlasRegion sky;
		
		public AssetLevelDecoration(TextureAtlas atlas)
		{
			background = atlas.findRegion("background");
			foreground = atlas.findRegion("foreground");
			sky = atlas.findRegion("sky");
		}
	}
	
	
}


































