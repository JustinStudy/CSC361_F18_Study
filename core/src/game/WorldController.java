package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Application.ApplicationType;

public class WorldController extends InputAdapter
{
	private static final String TAG = WorldController.class.getName();
	
	public WorldController() {}
	
	private void init() 
	{
		Gdx.input.setInputProcessor(this);
	}
	
	public void update(float deltaTime) 
	{
		handleDebugInput(deltaTime);
	}
	
	private void handleDebugInput(float deltaTime)
	{
		if(Gdx.app.getType() != ApplicationType.Desktop) return;
	}
	
	/**	Used as event handler
	 * @Override
	 * public boolean keyUp (int keycode) 
	 * {
	 * 		if(keycode == Keys.R)
	 * 		{
	 * 			init();
	 * 			Gdx.app.debug(TAG, "Game world reset");
	 * 		}
	 *  return false;
	 * }
	 * 
	 */
}
