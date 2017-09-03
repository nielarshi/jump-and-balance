/**
 * 
 */
package com.jumpandbalance.theme;

import com.jumpandbalance.interfaces.Theme;

import android.graphics.Bitmap;
import android.graphics.Paint;

/**
 * @author Priya
 *
 */
public class LevelTheme implements Theme{
	private Bitmap pillarBitmap,ballBitmap,backgroundImageBitmap;
	private Paint paint;
	/**
	 * @return the pillarBitmap
	 */
	public Bitmap getPillarBitmap() {
		return pillarBitmap;
	}
	/**
	 * @param pillarBitmap the pillarBitmap to set
	 */
	public void setPillarBitmap(Bitmap pillarBitmap) {
		this.pillarBitmap = pillarBitmap;
	}
	/**
	 * @return the ballBitmap
	 */
	public Bitmap getBallBitmap() {
		return ballBitmap;
	}
	/**
	 * @param ballBitmap the ballBitmap to set
	 */
	public void setBallBitmap(Bitmap ballBitmap) {
		this.ballBitmap = ballBitmap;
	}
	/**
	 * @return the backgroundImageBitmap
	 */
	public Bitmap getBackgroundImageBitmap() {
		return backgroundImageBitmap;
	}
	/**
	 * @param backgroundImageBitmap the backgroundImageBitmap to set
	 */
	public void setBackgroundImageBitmap(Bitmap backgroundImageBitmap) {
		this.backgroundImageBitmap = backgroundImageBitmap;
	}
	/**
	 * @return the paint
	 */
	public Paint getPaint() {
		return paint;
	}
	/**
	 * @param paint the paint to set
	 */
	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	@Override
	public void setTheme() {
		
		
	}
	@Override
	public Theme getTheme() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isRaining() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isStill() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isSnowFall() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isUnderWater() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isGrassLand() {
		// TODO Auto-generated method stub
		return false;
	}  
	
	
}
