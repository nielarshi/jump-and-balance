/**
 * 
 */
package com.jumpandbalance.actors;

import com.jumpandbalance.helper.Speed;
import com.jumpandbalance.images.ImageHelper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * @author Priya
 *
 */
public class LevelDiamond {

	private static final int BMP_ROWS = 1;
	private static final int BMP_COLUMN = 1;
	private int x,y;
	private Bitmap bitmapImage;
	private int width, height;
	private int currentFrame;
	private boolean alreadyAttained;
	private boolean hasBallTouched;
	
	public LevelDiamond() {
		
		this.x = 1;
		this.y = 100;
		this.bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.BUBBLE_PINK);
		this.alreadyAttained = false;
		this.width = bitmapImage.getWidth() / BMP_COLUMN;
		this.height = bitmapImage.getHeight() / BMP_ROWS;
	}

	public void draw(Canvas canvas) {
	
		int srcX = currentFrame * width;
		int srcY = 0 * height;
	
		if(hasBallTouched) {
			updateDiamondRectAfterBallTouch();
		}
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dest = new Rect(x, y, x + width, y + height);
	
		
		
		if(!alreadyAttained) {
			canvas.drawBitmap(bitmapImage, src, dest, null);
			updateObjectLocation();
		}
		
	}

	private void updateDiamondRectAfterBallTouch() {
		y = y - 10;
		if(y < 0) {
			alreadyAttained = true;
		}
	}

	public void updateObjectLocation() {
		currentFrame = ++currentFrame % BMP_COLUMN;
		
		
	}
	
	
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the bitmapImage
	 */
	public Bitmap getBitmapImage() {
		return bitmapImage;
	}
	/**
	 * @param bitmapImage the bitmapImage to set
	 */
	public void setBitmapImage(Bitmap bitmapImage) {
		this.bitmapImage = bitmapImage;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the currentFrame
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}
	/**
	 * @param currentFrame the currentFrame to set
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	/**
	 * @return the bmpRows
	 */
	public static int getBmpRows() {
		return BMP_ROWS;
	}
	/**
	 * @return the bmpColumn
	 */
	public static int getBmpColumn() {
		return BMP_COLUMN;
	}

	/**
	 * @return the alreadyAttained
	 */
	public boolean isAlreadyAttained() {
		return alreadyAttained;
	}

	/**
	 * @param alreadyAttained the alreadyAttained to set
	 */
	public void setAlreadyAttained(boolean alreadyAttained) {
		this.alreadyAttained = alreadyAttained;
	}

	/**
	 * @return the hasBallTouched
	 */
	public boolean isHasBallTouched() {
		return hasBallTouched;
	}

	/**
	 * @param hasBallTouched the hasBallTouched to set
	 */
	public void setHasBallTouched(boolean hasBallTouched) {
		this.hasBallTouched = hasBallTouched;
	}
	
	
	
	
	
	
}
