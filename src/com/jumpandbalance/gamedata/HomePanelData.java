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
public class HomePanelData implements Serializable {

	
	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = -1707881879972386956L;
	private ArrayList<LevelInfoData> levelInfoDataList;
	private GameStatData gameStatData;
	/**
	 * @return the levelInfoDataList
	 */
	public ArrayList<LevelInfoData> getLevelInfoDataList() {
		return levelInfoDataList;
	}
	/**
	 * @param levelInfoDataList the levelInfoDataList to set
	 */
	public void setLevelInfoDataList(ArrayList<LevelInfoData> levelInfoDataList) {
		this.levelInfoDataList = levelInfoDataList;
	}
	/**
	 * @return the gameStatData
	 */
	public GameStatData getGameStatData() {
		return gameStatData;
	}
	/**
	 * @param gameStatData the gameStatData to set
	 */
	public void setGameStatData(GameStatData gameStatData) {
		this.gameStatData = gameStatData;
	}

	
	
	
}
