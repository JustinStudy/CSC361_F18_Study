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
	private TextureRegion foreImageLeft;
	private TextureRegion foreImageRight;
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
		
		foreImageLeft = Assets.instance.levelDecoration.foreground;
		foreImageRight = Assets.instance.levelDecoration.foreground;
		
		origin.x = -dimension.x * 2;
		length += dimension.x * 2;
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
		batch.setColor(tintColor, tintColor, tintColor, 1);
		float xRel = dimension.x * offsetX;
		float yRel = dimension.y * offsetY;
		
		int fgLength = 0;
		fgLength += MathUtils.ceil(length/(2*dimension.x));
		fgLength += MathUtils.ceil(0.5f + offsetX);
		for(int i = 0; i < fgLength; i++)
		{	
			//left foreground
			reg = foreImageLeft;
			batch.draw(reg.getTexture(), origin.x + xRel, position.y + origin.y +yRel, 
					origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 
					rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(),
					reg.getRegionHeight(), false, false);
			xRel += dimension.x;
			
			//right foreground
			reg = foreImageRight;
			batch.draw(reg.getTexture(), origin.x + xRel, position.y + origin.y +yRel, 
					origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 
					rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(),
					reg.getRegionHeight(), false, false);
			xRel += dimension.x;
		}
		batch.setColor(1,1,1,1);
	}
	
	/**
	 * Calls drawForeground to render it to the screen
	 */
	@Override
	public void render(SpriteBatch batch) 
	{
		//black foreground
		drawForeground(batch, 0.0f, -0.5f, 1.0f);
	}
	
}
