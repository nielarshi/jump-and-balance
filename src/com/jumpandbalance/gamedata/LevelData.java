/**
 * 
 */
package com.jumpandbalance.gamedata;

import java.io.Serializable;

/**
 * @author Priya
 *
 */
public class LevelData implements Serializable {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 7885961827742227120L;

	private boolean locked;
	private String levelName;
	private String levelType;
	private int themeType;
	private int srcPillarIndex;
	private int destPillarIndex;
	private GameStatData levelStatData;
	private int noOfPillarsCrossed;
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
	 * @return the levelType
	 */
	public String getLevelType() {
		return levelType;
	}
	/**
	 * @param levelType the levelType to set
	 */
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}
	/**
	 * @return the themeType
	 */
	public int getThemeType() {
		return themeType;
	}
	/**
	 * @param themeType the themeType to set
	 */
	public void setThemeType(int themeType) {
		this.themeType = themeType;
	}
	/**
	 * @return the srcPillarIndex
	 */
	public int getSrcPillarIndex() {
		return srcPillarIndex;
	}
	/**
	 * @param srcPillarIndex the srcPillarIndex to set
	 */
	public void setSrcPillarIndex(int srcPillarIndex) {
		this.srcPillarIndex = srcPillarIndex;
	}
	/**
	 * @return the destPillarIndex
	 */
	public int getDestPillarIndex() {
		return destPillarIndex;
	}
	/**
	 * @param destPillarIndex the destPillarIndex to set
	 */
	public void setDestPillarIndex(int destPillarIndex) {
		this.destPillarIndex = destPillarIndex;
	}
	/**
	 * @return the levelStatData
	 */
	public GameStatData getLevelStatData() {
		return levelStatData;
	}
	/**
	 * @param levelStatData the levelStatData to set
	 */
	public void setLevelStatData(GameStatData levelStatData) {
		this.levelStatData = levelStatData;
	}
	/**
	 * @return the noOfPillarsCrossed
	 */
	public int getNoOfPillarsCrossed() {
		return noOfPillarsCrossed;
	}
	/**
	 * @param noOfPillarsCrossed the noOfPillarsCrossed to set
	 */
	public void setNoOfPillarsCrossed(int noOfPillarsCrossed) {
		this.noOfPillarsCrossed = noOfPillarsCrossed;
	}
	
	
}
