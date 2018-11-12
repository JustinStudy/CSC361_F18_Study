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
	private OrthographicCamera cameraGUI;
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
		cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
		cameraGUI.position.set(0,0,0);
		cameraGUI.setToOrtho(true); //flip y axis
		cameraGUI.update();
	}
	
	public void render() 
	{
		renderWorld(batch);
	}
	
	/**
	 * makes calls to worldController to create the camera helper and render the level to the screen
	 * @param batch
	 */
	private void renderWorld(SpriteBatch batch)
	{
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		worldController.level.render(batch);
		batch.end();
	}
	
	/**
	 * draws coin score in top left of screen
	 */
	private void renderGuiScore(SpriteBatch batch)
	{
		float x = -15;
		float y = -15;
		batch.draw(Assets.instance.coin.coin, x, y, 50, 50, 100, 100, 0.35f, -0.35f, 0);
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
		cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
		cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float)height) * (float)width;
		cameraGUI.position.set(cameraGUI.viewportWidth/2, cameraGUI.viewportHeight/2, 0);
		cameraGUI.update();
	}
	
	/**
	 * rids unused items and processes from program to free space and reduce load.
	 */
	@Override public void dispose()
	{
		batch.dispose();
	}
}
















