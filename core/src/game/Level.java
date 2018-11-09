package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import objects.AbstractGameObject;
import objects.Background;
import objects.Foreground;
import objects.Grass;
import objects.Sky;

/**
 * class to hold level data
 * @author Justin Study
 */
public class Level 
{
	public static final String TAG = Level.class.getName();
	
	public enum BLOCK_TYPE
	{
		EMPTY(255,255,255), //WHITE
		PLAYER_SPAWNPOINT(0, 0, 0), //BLACK
		GRASS(0, 255, 0), //GREEN
		COIN(255, 255, 0), //YELLOW
		UPVOTE(255, 165, 0), //ORANGE
		SPEEDUP(150, 0, 255), //PURPLE
		LADDER(0, 0, 255); //BLUE
		
		private int color;
		
		private BLOCK_TYPE(int r, int g, int b)
		{
			color = r << 24 | g << 16 | b << 8 | 0xff;
		}
		
		public boolean sameColor(int color)
		{
			return this.color == color;
		}
		
		public int getColor()
		{
			return color;
		}
		
		//objects
		public Grass grass;
		
		//background scene
		public Sky sky;
		public Background background;
		public Foreground foreground;
		
		public void Level(String filename)
		{
			init(filename);
		}
		
		private void init(String filename) 
		{
			//load image file taht represents the level data
			Pixmap pixmap = new Pixmap(Gdx.files.internal(filename));
			
			//scan pixels from topleft to bottom right
			int lastPixel = -1;
			for(int pixelY = 0; pixelY < pixmap.getHeight(); pixelY++)
			{
				for(int pixelX = 0; pixelX< pixmap.getWidth(); pixelX++)
				{
					AbstractGameObject obj = null;
					float offsetHeight = 0;
					//height grows from bottom to top
					float baseHeight = pixmap.getHeight() - pixelY;
					//get color of current pixel as 32bit RGBA val
					int currentPixel = pixmap.getPixel(pixelX, pixelY);
					//find match color value for block type
					//creat object if there is a match
					
					//blank
					if(BLOCK_TYPE.EMPTY.sameColor(currentPixel))
					{
						//nothing
					}
					
					if(BLOCK_TYPE.GRASS.sameColor(currentPixel))
					{
						//later
					}
					
					if(BLOCK_TYPE.PLAYER_SPAWNPOINT.sameColor(currentPixel))
					{
						//later
					}
					
					if(BLOCK_TYPE.COIN.sameColor(currentPixel))
					{
						//later
					}
					
					if(BLOCK_TYPE.UPVOTE.sameColor(currentPixel))
					{
						//later
					}
					
					if(BLOCK_TYPE.SPEEDUP.sameColor(currentPixel))
					{
						//later
					}
					
					if(BLOCK_TYPE.LADDER.sameColor(currentPixel))
					{
						//later
					}
					lastPixel = currentPixel;
				}
			}
			
			//decoration
			sky = new Sky(pixmap.getWidth());
			foreground = new Foreground(pixmap.getWidth());
			background = new Background(pixmap.getWidth());
			
			//free memory
			pixmap.dispose();
			Gdx.app.debug(TAG,  "level '" + filename + " 'loaded");
		}
		
		public void render(SpriteBatch batch) 
		{
			//draw sky
			sky.render(batch);
			//draw background
			background.render(batch);
			//draw foreground
			foreground.render(batch);
		}
		
	}
	
	
}























