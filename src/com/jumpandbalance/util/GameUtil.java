/**
 * 
 */
package com.jumpandbalance.util;

import java.util.Random;

import android.graphics.Point;

/**
 * @author Niel
 *
 */
public class GameUtil {
	public static float getAngle(Point target) {
	    float angle = (float) Math.toDegrees(Math.atan2(target.x, target.y));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static int getScore(int attempts) {
		int fullScore = 0;
		
		if(attempts<20){
			fullScore = (20-attempts)*5;
		} 
		
		
		return fullScore;
	}
}
