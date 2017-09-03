/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.helper.Speed;
import com.jumpandbalance.images.ImageHelper;

/**
 * @author Priya
 *
 */
public class HomeObject {

	private static final int BMP_ROWS = 1;
	private static final int BMP_COLUMN = 4;
	private int x,y;
	private Bitmap bitmapImage;
	private int width, height;
	private Speed speed;
	private float currentTimeInAir=0;
	private int currentFrame;
	
	
	
	public HomeObject() {
		this.x = 1;
		this.y = 100;
		this.bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_7);
		this.speed = new Speed(5, 5);
		
		this.width = bitmapImage.getWidth() / BMP_COLUMN;
		this.height = bitmapImage.getHeight() / BMP_ROWS;
	}
	
	public void draw(Canvas canvas) {
		
		
		int srcX = currentFrame * width;
		int srcY = 0 * height;
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dest = new Rect(x, y, x + width, y + height);
		
		canvas.drawBitmap(bitmapImage, src, dest, null);
	}
	
	public void updateObjectLocation() {
		speed.setyVelocity((float)(speed.getyVelocity()+( 0.5 * currentTimeInAir)));        // Apply gravity to vertical velocity
		x += speed.getxVelocity() * 1;      // Apply horizontal velocity to X position
		y += speed.getyVelocity() * 1;      // Apply vertical velocity to X position
		currentTimeInAir+=0.02;
		
		if((currentTimeInAir*20) % 2==0) {
			currentFrame = ++currentFrame % BMP_COLUMN;
		}
		
		
		if(y >= MainActivity.gamePanel.getHeight() - this.bitmapImage.getHeight()) {
			currentTimeInAir=0.02f;
			
			if(speed.getxVelocity()<0) {
				speed = new Speed((-1)*10, 10);
			} else {
				speed = new Speed(10, 10);
			}
			
			speed.setyVelocity((-1)*speed.getyVelocity());
		}
		
		if(x >= MainActivity.gamePanel.getWidth() - width) {
			speed.setxVelocity((-1)*speed.getxVelocity());
		}
		
		if(x <= 0) {
			speed.setxVelocity((-1)*speed.getxVelocity());
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
