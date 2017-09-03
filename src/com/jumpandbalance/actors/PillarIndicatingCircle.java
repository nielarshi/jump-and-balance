/**
 * 
 */
package com.jumpandbalance.actors;

import com.jumpandbalance.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author Priya
 *
 */
public class PillarIndicatingCircle {

	private int x;
	private int y;
	private int radius;
	private Paint paint, newPaint;
	private Bitmap image;
	
	public PillarIndicatingCircle() {
		// TODO Auto-generated constructor stub
		paint = new Paint();
		paint.setStrokeWidth(2.0f);
		paint.setAntiAlias(true);
		paint.setAlpha(100);
		paint.setColor(Color.GREEN);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(2.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(100);
		newPaint.setColor(Color.BLACK);
		
		
	}
	public void draw(Canvas canvas) {
		
	//	canvas.drawCircle(x, y, radius+2, newPaint);
	//	canvas.drawCircle(x, y, radius, paint);
		
		canvas.drawBitmap(image, x, y, null);
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
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
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
	/**
	 * @return the image
	 */
	public Bitmap getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Bitmap image) {
		this.image = image;
	}
	
}
