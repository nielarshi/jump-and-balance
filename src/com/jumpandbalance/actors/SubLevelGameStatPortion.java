/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Canvas;

/**
 * @author Priya
 *
 */
public class SubLevelGameStatPortion {

	private SubLevelDiamond levelDiamond;
	private SubLevelDoubleDiamond levelDoubleDiamond;
	private SubLevelScore levelScore;
	
	public SubLevelGameStatPortion() {
		// TODO Auto-generated constructor stub
		levelDiamond = new SubLevelDiamond();
		levelDoubleDiamond = new SubLevelDoubleDiamond();
		levelScore = new SubLevelScore();
	}
	
	public void draw(Canvas canvas) {
		this.levelDiamond.draw(canvas);
	//	this.levelDoubleDiamond.draw(canvas);
		this.levelScore.draw(canvas);
	}
	
	/**
	 * @return the levelDiamond
	 */
	public SubLevelDiamond getLevelDiamond() {
		return levelDiamond;
	}
	/**
	 * @param levelDiamond the levelDiamond to set
	 */
	public void setLevelDiamond(SubLevelDiamond levelDiamond) {
		this.levelDiamond = levelDiamond;
	}
	/**
	 * @return the levelDoubleDiamond
	 */
	public SubLevelDoubleDiamond getLevelDoubleDiamond() {
		return levelDoubleDiamond;
	}
	/**
	 * @param levelDoubleDiamond the levelDoubleDiamond to set
	 */
	public void setLevelDoubleDiamond(SubLevelDoubleDiamond levelDoubleDiamond) {
		this.levelDoubleDiamond = levelDoubleDiamond;
	}
	/**
	 * @return the levelScore
	 */
	public SubLevelScore getLevelScore() {
		return levelScore;
	}
	/**
	 * @param levelScore the levelScore to set
	 */
	public void setLevelScore(SubLevelScore levelScore) {
		this.levelScore = levelScore;
	}
	
	
}
