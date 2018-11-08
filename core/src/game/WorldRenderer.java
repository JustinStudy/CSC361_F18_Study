package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import util.Constants;

/**
 * class that holds information as to what is displayed to the screen
 * @author spesh
 *
 */
public class WorldRenderer implements Disposable 
{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	
	public WorldRenderer(WorldController worldController)
	{
		this.worldController = worldController;
		init();
	}
	
	/**
	 * initializes the camera and checks for sprites that need to be rendered
	 */
	private void init() 
	{
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, 
										 Constants.VIEWPORT_HEIGHT);
		camera.position.set(0,0,0);
		camera.update();
	}
	
	public void render() 
	{
		renderTestObjects();
	}
	
	private void renderTestObjects()
	{
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Sprite sprite : worldController.testSprites)
		{
			sprite.draw(batch);
		}
		batch.end();
	}
	
	/**
	 * changes size of the window displayed to the user
	 * @param width
	 * @param height
	 */
	public void resize(int width, int height) 
	{
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height) * width;
		camera.update();
	}
	
	/**
	 * rids unused items and processes from program to free space and reduce load.
	 */
	@Override public void dispose()
	{
		batch.dispose();
	}
}
