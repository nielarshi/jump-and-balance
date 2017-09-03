/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.jumpandbalance.images.ImageHelper;

/**
 * @author Priya
 *
 */
public class HomeBall1 {


	private static final int BMP_ROWS = 1;
	private static final int BMP_COLUMN = 4;
	private int x,y;
	private Bitmap bitmapImage;
	private int width, height;
	private int count;
	private int currentFrame;
	private boolean isForward;
	
	
	
	public HomeBall1() {
		this.x = 1;
		this.y = 100;
		this.bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_1);
		
		this.width = bitmapImage.getWidth() / BMP_COLUMN;
		this.height = bitmapImage.getHeight() / BMP_ROWS;
	}
	
	public void draw(Canvas canvas) {
		
		
		int srcX = currentFrame * width;
		int srcY = 0 * height;
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dest = new Rect(x, y, x + width, y + height);
		
		canvas.drawBitmap(bitmapImage, src, dest, null);
		updateObjectLocation();
		
		
	}
	
	public void updateObjectLocation() {
		
		count++;
		
		if(count>10) {
			
			if(!isForward) {
				currentFrame = ++currentFrame % BMP_COLUMN;
			} else {
				currentFrame = --currentFrame % BMP_COLUMN;
			}
			
			count = 0;
			
			if(currentFrame == 3) {
				isForward = true;
				count = -20;
			} else if(currentFrame == 0) {
				isForward = false;
			}
			
		}
			
		
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
		

}
