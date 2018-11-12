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
	private TextureRegion backImageLeft;
	private TextureRegion backImageRight;
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
		
		backImageLeft = Assets.instance.levelDecoration.background;
		backImageRight = Assets.instance.levelDecoration.background;
		
		origin.x = -dimension.x * 2;
		length += dimension.x * 2;
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
		batch.setColor(tintColor, tintColor, tintColor, 1);
		float xRel = dimension.x * offsetX;
		float yRel = dimension.y * offsetY;
		
		int bgLength = 0;
		bgLength += MathUtils.ceil(length/(2*dimension.x));
		bgLength += MathUtils.ceil(0.5f + offsetX);
		for(int i = 0; i < bgLength; i++)
		{	
			//left foreground
			reg = backImageLeft;
			batch.draw(reg.getTexture(), origin.x + xRel, position.y + origin.y +yRel, 
					origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 
					rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(),
					reg.getRegionHeight(), false, false);
			xRel += dimension.x;
			
			//right foreground
			reg = backImageRight;
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
		//dark gray background
		drawBackground(batch, 0.0f, -0.4f, 1.0f);
	}
}	
	
	
	