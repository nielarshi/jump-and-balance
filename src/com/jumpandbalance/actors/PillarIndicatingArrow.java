/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author Priya
 *
 */
public class PillarIndicatingArrow {

	private int x;
	private int y;
	private Bitmap bitmapImage;
	private Paint paint;
	
	public PillarIndicatingArrow() {
		// TODO Auto-generated constructor stub
		paint = new Paint();
		paint.setStrokeWidth(2.0f);
		paint.setAntiAlias(true);
		paint.setAlpha(100);
		paint.setColor(Color.GRAY);
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmapImage, x, y, paint);
		
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
	
	
}
