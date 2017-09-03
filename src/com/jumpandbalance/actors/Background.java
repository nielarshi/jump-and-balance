/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * @author Niel
 *
 */
public class Background {

	private int x;
	private int y;
	private int speedX, speedY;
	private Bitmap backgroundImageBitmap;
	
	public Background(Bitmap backgroundImageBitmap, int x, int y) {
		this.x = x;
		this.y = y;
		this.backgroundImageBitmap = backgroundImageBitmap;
		this.speedX = 0;
	}
	
	public void update() {
		x += speedX;

		if (x <= -1024){
			x += 2048;
		}
	}
	
	public void draw(Canvas canvas) {
		 canvas.drawBitmap(backgroundImageBitmap, x, y, null);
	}
	
	public void updateY() {
		y += speedY;

		if (y >= 270){
			y -= 550;
		}
	}
	
	public void updateYForFlowers() {
		y += speedY;

	}
	/**
	 * @return the speedY
	 */
	public int getSpeedY() {
		return speedY;
	}

	/**
	 * @param speedY the speedY to set
	 */
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
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
	 * @return the speedX
	 */
	public int getSpeedX() {
		return speedX;
	}
	/**
	 * @param speedX the speedX to set
	 */
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
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
	
	
}
