package util;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import objects.AbstractGameObject;

/**
 * Holds variables and methods that will control our camera as it follows the 
 * player around the map
 * @author Justin Study
 */
public class CameraHelper 
{
	private static final String TAG = CameraHelper.class.getName();
	
	private final float MAX_ZOOM_IN = 0.25f;
	private final float MAX_ZOOM_OUT = 10.0f;
	private final float FOLLOW_SPEED = 4.0f;
	
	private Vector2 position;
	private float zoom;
	private Sprite target;
	
	public CameraHelper ()
	{
		position = new Vector2();
		zoom = 1.0f;
	}
	
	/**
	 * moves the position of the camera every time the game udpates
	 */
	public void update(float deltaTime)
	{
		if (!hasTarget()) return;
		
		position.x = target.getX() + target.getOriginX();
		position.y = target.getY() + target.getOriginY();
	}
	
	/**
	 * sets position of camera
	 * @param x
	 * @param y
	 */
	public void setPosition (float x, float y)
	{
		this.position.set(x, y);
	}
	
	/**
	 * returns position of camera
	 * @return
	 */
	public Vector2 getPosition() 
	{
		return position;
	}
	
	public void addZoom (float amount)
	{
		setZoom(zoom + amount);
	}
	
	public void setZoom (float zoom)
	{
		this.zoom = MathUtils.clamp(zoom,  MAX_ZOOM_IN, MAX_ZOOM_OUT);
	}
	
	public float getZoom ()
	{
		return zoom;
	}
	
	public void setTarget (Sprite target)
	{
		this.target = target;
	}
	
	
	public Sprite getTarget ()
	{
		return target;
	}
	
	public boolean hasTarget ()
	{
		return target != null;
	}
	
	public boolean hasTarget (Sprite target)
	{
		return hasTarget() && this.target.equals(target);
	}
	
	/**
	 * applies changes to the camera settings
	 * @param camera
	 */
	public void applyTo (OrthographicCamera camera)
	{
		camera.position.x = position.x;
		camera.position.y = position.y;
		camera.zoom = zoom;
		camera.update();
	}
}


















