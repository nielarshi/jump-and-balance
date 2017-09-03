/**
 * 
 */
package com.jumpandbalance.interfaces;

import android.graphics.Bitmap;

/**
 * @author Priya
 *
 */
public interface Theme {
	public void setTheme();
	public Theme getTheme();
	public Bitmap getPillarBitmap();
	public Bitmap getBackgroundImageBitmap();
	public Bitmap getBallBitmap();
	public boolean isMoving();
	public boolean isStill();
	public boolean isRaining();
	public boolean isSnowFall();
	public boolean isUnderWater();
	public boolean isGrassLand();
}
