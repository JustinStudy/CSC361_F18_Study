package objects;

import game.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * holds info and methods for the sky behind the background
 * @author Justin Study
 */
public class Sky extends AbstractGameObject
{
	private TextureRegion regSky;
	private float length;
	
	public Sky(float length)
	{
		this.length = length;
		init();
	}
	
	/**
	 * initializes sky and sets the length it will span and where it will start
	 */
	private void init()
	{
		dimension.set(length * 10, 10);
		regSky = Assets.instance.levelDecoration.sky;
		origin.x = -dimension.x/2;
	}

	/**
	 * draws the sky to the screen
	 */
	@Override
	public void render(SpriteBatch batch)
	{
		batch.begin();
		TextureRegion reg = null;
		reg = regSky;
		batch.draw(reg.getTexture(), position.x + origin.x, position.y + origin.y, 
				   origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 
				   rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(),
				   reg.getRegionHeight(), false, false);
	}
}










