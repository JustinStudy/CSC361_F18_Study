package objects;

import game.Assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;



/**
 * class for the foreground object that will be one part of our background scene.
 * @author Justin Study
 */
public class Foreground extends AbstractGameObject
{
	private TextureRegion foreImage;
	private int length;
	
	public Foreground(int length)
	{
		this.length = length;
		init();
	}
	
	/**
	 * initializes foreground and sets size
	 */
	private void init()
	{
		//height and length of foreground
		dimension.set(10, 5);
		
		foreImage = Assets.instance.levelDecoration.foreground;
	}
	
	/**
	 * draws the foreground part of the background scene
	 * @param batch
	 * @param offsetX
	 * @param offsetY
	 * @param tintColor
	 */
	private void drawForeground(SpriteBatch batch, float offsetX, float offsetY, float tintColor)
	{
		TextureRegion reg = null;
		//black foreground
		batch.setColor(tintColor, tintColor, tintColor, 1);
		float xRel = dimension.x * offsetX;
		float yRel = dimension.y * offsetY;
		
		//foreground keeps repeating until level end
		int foreLength = 0;
		foreLength += MathUtils.ceil(length/dimension.x);
		//draw mountains
		for(int i = 0; i < foreLength; i++)
		{
			reg = foreImage;
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
		//black foreground
		drawForeground(batch, 0.0f, 0.0f, 0.0f);
	}
	
}
