package com.jumpandbalance.actors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class IndicationInfoBox {

	private String text;
	private int x;
	private int y;
	private int radius;
	private Paint paint, newPaint;
	
	public IndicationInfoBox() {
		// TODO Auto-generated constructor stub
		paint = new Paint();
		paint.setStrokeWidth(2.0f);
		paint.setAntiAlias(true);
		paint.setAlpha(100);
		paint.setColor(Color.YELLOW);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(2.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(100);
		newPaint.setColor(Color.BLACK);
		
		radius = 150;
	}
	
	public void draw(Canvas canvas) {
		
		canvas.drawCircle(x, y, radius+2, newPaint);
		canvas.drawCircle(x, y, radius, paint);
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
	 * @return the newPaint
	 */
	public Paint getNewPaint() {
		return newPaint;
	}
	/**
	 * @param newPaint the newPaint to set
	 */
	public void setNewPaint(Paint newPaint) {
		this.newPaint = newPaint;
	}
	
}
