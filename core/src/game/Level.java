package game;


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
		ITEM_COIN(255, 255, 0), //YELLOW
		UPVOTE(255, 165, 0), //ORANGE
		SPEEDUP(150, 0, 255), //PURPLE
		LADDER(0, 0, 255); //BLUE
		
		private int color;
		
		private BLOCK_TYPE(int r, int g, int b)
		{
			color = r << 24 | g << 16 | b << 8 | 0xff;
		}
		
		//objects
		public 
	}
}























