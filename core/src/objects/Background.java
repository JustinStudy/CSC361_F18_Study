 package objects;

import game.Assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

/**
 * class for the background object that will be one part of our background scene.
 * @author Justin Study
 */
public class Background extends AbstractGameObject
{
	private TextureRegion backImage;
	private int length;
	
	public Background(int length)
	{
		this.length = length;
		init();
	}
	
	/**
	 * initializes background and sets size
	 */
	private void init()
	{
		//height and length of background
		dimension.set(10, 5);
		
		backImage = Assets.instance.levelDecoration.background;
	}
	
	/**
	 * draws the background part of the background scene
	 * @param batch
	 * @param offsetX
	 * @param offsetY
	 * @param tintColor
	 */
	private void drawBackground(SpriteBatch batch, float offsetX, float offsetY, float tintColor)
	{
		TextureRegion reg = null;
		//gray background
		batch.setColor(tintColor, tintColor, tintColor, 1);
		float xRel = dimension.x * offsetX;
		float yRel = dimension.y * offsetY;
		
		//foreground keeps repeating until level end
		int backLength = 0;
		backLength += MathUtils.ceil(length/dimension.x);
		//draw mountains
		for(int i = 0; i < backLength; i++)
		{
			reg = backImage;
			batch.draw(reg.getTexture(), origin.x + xRel, position.y + origin.y + yRel, 
					   origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 
					   rotation, reg.getRegionX(), reg.getRegionY(),
					   reg.getRegionWidth(), reg.getRegionHeight(), false, false);
		}
	}
	
	/**
	 * Calls drawForeground to render it to the screen
	 */
	@Override
	public void render(SpriteBatch batch) 
	{
		//dark gray background
		drawBackground(batch, 0.5f, 0.5f, 0.5f);
	}
}	
	
	
	