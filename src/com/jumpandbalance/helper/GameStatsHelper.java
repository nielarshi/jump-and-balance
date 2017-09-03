/**
 * 
 */
package com.jumpandbalance.helper;

/**
 * @author Priya
 *
 */
public class GameStatsHelper {

	public static final int EVENT_SUCCESS = 1;
	public static final int EVENT_FAILED = 0;
	public static final int MIN_LEVEL_SCORE_REQUIRED_FOR_DIAMOND = 1000;
	public static final int MIN_LEVEL_STARS_REQUIRED_FOR_UNLOCKING_SUB_LEVEL = 2;
	public static final int AVG_STARS_REQUIRED_FOR_NEXT_MAIN_LEVEL = 3;
	public static final int DEFAULT_DEDUCTION_ON_EACH_FAILED_ATTEMPT = 25;
	public static final int LEVEL_DIAMOND_INCREMENT_VALUE = 1;
	public static final int LEVEL_DOUBLE_DIAMOND_INCREMENT_VALUE = 1;
	
	public static final float FRACTION_FOR_FIVE_STARS = 1f;
	public static final float FRACTION_FOR_FOUR_STARS = 0.90f;
	public static final float FRACTION_FOR_THREE_STARS = 0.75f;
	public static final float FRACTION_FOR_TWO_STARS = 0.5f;
	public static final float FRACTION_FOR_ONE_STARS = 0.25f;
	
	
	
	public static int getScore(int scoreForCrossingOnePillar, int noOfAttempts) {
		int score = 0;
		score = scoreForCrossingOnePillar - (noOfAttempts * DEFAULT_DEDUCTION_ON_EACH_FAILED_ATTEMPT);
		return score;
	}
	
	public static int getLevelStarCount(int maxLevelPoint, int score) {
		int starCount = 0;
		
		if(score >= (FRACTION_FOR_FIVE_STARS*maxLevelPoint)) {
			starCount = 5;
		} else if(score <= (FRACTION_FOR_FIVE_STARS*maxLevelPoint) && score >= (FRACTION_FOR_FOUR_STARS*maxLevelPoint)) {
			starCount = 4;
		} else if(score < (FRACTION_FOR_FOUR_STARS*maxLevelPoint) && score > (FRACTION_FOR_THREE_STARS*maxLevelPoint)) {
			starCount = 3;
		} else if (score < (FRACTION_FOR_THREE_STARS*maxLevelPoint) && score >= (FRACTION_FOR_TWO_STARS*maxLevelPoint)) {
			starCount = 2;
		} else if (score < (FRACTION_FOR_TWO_STARS*maxLevelPoint) && score >= (FRACTION_FOR_ONE_STARS*maxLevelPoint)) {
			starCount = 1;
		} else {
			starCount = 0;
		}
		return starCount;
	}
	
	public static int getLevelDiamondCount(int prevDiamondCount, int event) {
		int levelDiamondCount = 0;
		if(event == EVENT_SUCCESS) {
			levelDiamondCount = prevDiamondCount + 1;
		} else if(event == EVENT_FAILED) {
			levelDiamondCount = prevDiamondCount - 1;
		}
		return levelDiamondCount;
	}
	
	public static int getLevelDoubleDiamondCount(int prevDoubleDiamondCount, int event) {
		int levelDoubleDiamondCount = 0;
		if(event == EVENT_SUCCESS) {
			levelDoubleDiamondCount = prevDoubleDiamondCount + 1;
		} else if(event == EVENT_FAILED) {
			levelDoubleDiamondCount = prevDoubleDiamondCount - 1;
		}
		return levelDoubleDiamondCount;
	}
}
