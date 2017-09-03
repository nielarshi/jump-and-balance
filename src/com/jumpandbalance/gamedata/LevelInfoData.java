/**
 * 
 */
package com.jumpandbalance.gamedata;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Priya
 *
 */
public class LevelInfoData implements Serializable {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 3147317079093387919L;

	private String levelName;
	private GameStatData gameData;
	private boolean locked;
	private ArrayList<LevelData> levelDataList;
	
	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * @return the gameData
	 */
	public GameStatData getGameData() {
		return gameData;
	}
	/**
	 * @param gameData the gameData to set
	 */
	public void setGameData(GameStatData gameData) {
		this.gameData = gameData;
	}
	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	/**
	 * @return the levelDataList
	 */
	public ArrayList<LevelData> getLevelDataList() {
		return levelDataList;
	}
	/**
	 * @param levelDataList the levelDataList to set
	 */
	public void setLevelDataList(ArrayList<LevelData> levelDataList) {
		this.levelDataList = levelDataList;
	}
}
