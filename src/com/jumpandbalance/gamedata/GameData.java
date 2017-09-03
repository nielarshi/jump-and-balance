/**
 * 
 */
package com.jumpandbalance.gamedata;

import java.io.Serializable;

/**
 * @author Priya
 *
 */
public class GameData implements Serializable {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = -4435198102855472624L;
	private HomePanelData homePanelData;
	private LevelData onGoingLevelData;
	

	/**
	 * @return the homePanelData
	 */
	public HomePanelData getHomePanelData() {
		return homePanelData;
	}

	/**
	 * @param homePanelData the homePanelData to set
	 */
	public void setHomePanelData(HomePanelData homePanelData) {
		this.homePanelData = homePanelData;
	}

	/**
	 * @return the onGoingLevelData
	 */
	public LevelData getOnGoingLevelData() {
		return onGoingLevelData;
	}

	/**
	 * @param onGoingLevelData the onGoingLevelData to set
	 */
	public void setOnGoingLevelData(LevelData onGoingLevelData) {
		this.onGoingLevelData = onGoingLevelData;
	}
	
	
}
