/**
 * 
 */
package com.jumpandbalance.gamedata;

import java.io.Serializable;

/**
 * @author Priya
 *
 */
public class GameStatData implements Serializable {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 2065365391745233805L;

	private int score;
	private int starCount;
	private int diamondCount;
	private int doubleDiamondCount;
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the starCount
	 */
	public int getStarCount() {
		return starCount;
	}

	/**
	 * @param starCount the starCount to set
	 */
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}

	/**
	 * @return the diamondCount
	 */
	public int getDiamondCount() {
		return diamondCount;
	}

	/**
	 * @param diamondCount the diamondCount to set
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	/**
	 * @return the doubleDiamondCount
	 */
	public int getDoubleDiamondCount() {
		return doubleDiamondCount;
	}

	/**
	 * @param doubleDiamondCount the doubleDiamondCount to set
	 */
	public void setDoubleDiamondCount(int doubleDiamondCount) {
		this.doubleDiamondCount = doubleDiamondCount;
	}
	
	
}
