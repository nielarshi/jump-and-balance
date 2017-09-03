/**
 * 
 */
package com.jumpandbalance.theme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jumpandbalance.R;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.interfaces.Theme;

/**
 * @author Priya
 *
 */
public class ThemeOne implements Theme {

	private Bitmap pillarBitmap, ballBitmap, backgroundImageBitmap;
	private Context context;
	private boolean isMoving, isRaining, isStill, isSnowFall, isUnderWater, isGrassLand;
	
	
	/**
	 * @return the isGrassLand
	 */
	public boolean isGrassLand() {
		return isGrassLand;
	}



	/**
	 * @param isGrassLand the isGrassLand to set
	 */
	public void setGrassLand(boolean isGrassLand) {
		this.isGrassLand = isGrassLand;
	}



	/**
	 * @return the isUnderWater
	 */
	public boolean isUnderWater() {
		return isUnderWater;
	}



	/**
	 * @param isUnderWater the isUnderWater to set
	 */
	public void setUnderWater(boolean isUnderWater) {
		this.isUnderWater = isUnderWater;
	}



	/**
	 * @return the isSnowFall
	 */
	public boolean isSnowFall() {
		return isSnowFall;
	}



	/**
	 * @param isSnowFall the isSnowFall to set
	 */
	public void setSnowFall(boolean isSnowFall) {
		this.isSnowFall = isSnowFall;
	}



	/**
	 * @return the isStill
	 */
	public boolean isStill() {
		return isStill;
	}



	/**
	 * @param isStill the isStill to set
	 */
	public void setStill(boolean isStill) {
		this.isStill = isStill;
	}



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
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	public ThemeOne(Context context) {
		this.context = context;
		this.setTheme();
	}
	
	
	
	/**
	 * @return the isMoving
	 */
	public boolean isMoving() {
		return isMoving;
	}



	/**
	 * @param isMoving the isMoving to set
	 */
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}



	/**
	 * @return the isRaining
	 */
	public boolean isRaining() {
		return isRaining;
	}



	/**
	 * @param isRaining the isRaining to set
	 */
	public void setRaining(boolean isRaining) {
		this.isRaining = isRaining;
	}



	/* (non-Javadoc)
	 * @see com.jumpandbalance.interfaces.Theme#setTheme()
	 */
	@Override
	public void setTheme() {
		this.pillarBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.PILLAR);
		this.ballBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.BALL);
		this.backgroundImageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.BACKGROUND_BUILDING);
		this.isRaining = true;
	}
	
	public Theme getTheme() {
		return this;
	}
}
