/**
 * This class models a single level in the game.
 * @author William King
 */
public class Level {
	/** Holds each cell element of the level in their corresponding 
	 * positions in the list.  */
	private String[][] levelElements;
	
	/** The height of the level in cells. */
	private int levelHeight;
	
	/** The width of the level in cells. */
	private int levelWidth;
	
	/** Specifies which level this level is e.g. level 1, 2,... */
	private int levelNumber;
	
	/**
	 * Constructor for the Level class.
	 * @param levelElements Array holding each element needed to draw the level.
	 * @param levelNumber The number of the level being constructed.
	 */
	public Level(String[][] levelElements, int levelNumber) {
		this.levelElements = levelElements;
		this.levelNumber = levelNumber;
		
		// Height and width will be fixed, so this is fine.
		levelHeight = levelElements.length;
		levelWidth = levelElements[0].length; 
	}
	
	/**
	 * Gets the elements (and their position) used for the level. 
	 * @return An array of elements for the level.
	 */
	public String[][] getlevelElements() {
		return levelElements;
	}
	
	/**
	 * Get the height of the level in number of cells.
	 * @return The height of the level.
	 */
	public int getLevelHeight() {
		return levelHeight;
	}
	
	/**
	 * Get the width of the level in number of cells.
	 * @return The width of the level.
	 */
	public int getLevelWidth() {
		return levelWidth;
	}
	
	/**
	 * Get the level number of the level e.g. level 1,2,...
	 * @return The level number as an integer.
	 */
	public int getLevelNumber() {
		return levelNumber;
	}
}
