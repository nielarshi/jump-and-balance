/**
 * 
 */
package com.jumpandbalance.actors;

import com.jumpandbalance.util.FontUtil;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author Priya
 *
 */
public class IncreasingCount {

	private int finalValue;
	private int x;
	private int y;
	private Paint textPaint;
	private int count;
	
	public IncreasingCount(int finalValue) {
		this.finalValue = finalValue;
		this.textPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, Color.BLUE, 50);
	}
	
	public void draw(Canvas canvas) {
	//	while(count<=finalValue) {
		
		if(finalValue > 0) {
			canvas.drawText("+ "+String.valueOf(finalValue), x, y, textPaint);
		} else {
			canvas.drawText(String.valueOf(finalValue), x, y, textPaint);
		}
			
	//	}
	}

	/**
	 * @return the finalValue
	 */
	public int getFinalValue() {
		return finalValue;
	}

	/**
	 * @param finalValue the finalValue to set
	 */
	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
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
	 * @return the textPaint
	 */
	public Paint getTextPaint() {
		return textPaint;
	}

	/**
	 * @param textPaint the textPaint to set
	 */
	public void setTextPaint(Paint textPaint) {
		this.textPaint = textPaint;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
