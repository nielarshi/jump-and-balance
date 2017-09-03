/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.util.FontUtil;

/**
 * @author Priya
 *
 */
public class SubLevelDoubleDiamond {

	private int doubleDiamondCount;
	private Bitmap imageBitmap;
	private RectF doubleDiamondRect;
	private Paint textPaint;
	
	private Paint circlePaint;
	
	
	public SubLevelDoubleDiamond() {
		//this.imageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.DOUBLE_DIAMOND_IMAGE);
		this.doubleDiamondCount = 0;
		this.doubleDiamondRect = new RectF(100, 0, 200, 100);
		this.textPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT);
		this.textPaint.setTextSize(25);
		
		this.circlePaint = new Paint();
		this.circlePaint.setColor(Color.argb(50, 0, 0, 0));
		this.circlePaint.setAntiAlias(true);
	}
	
	public void draw(Canvas canvas) {

	//	canvas.drawCircle(((this.doubleDiamondRect.left + this.doubleDiamondRect.right)/2 - 10), ((this.doubleDiamondRect.top + this.doubleDiamondRect.bottom)/2 - 5), 35, circlePaint);
		
		canvas.drawBitmap(imageBitmap, this.doubleDiamondRect.left, this.doubleDiamondRect.top, null);
		canvas.drawText(String.valueOf(doubleDiamondCount), this.doubleDiamondRect.left - 30, this.doubleDiamondRect.top + 30, textPaint);
	}

	/**
	 * @return the doubleDiamondCount
	 */
	public int getDoubleDiamondCount() {
		return doubleDiamondCount;
	}

	/**
	 * @param doubleDiamondCount the doubleDiamondCount to set
	 */
	public void setDoubleDiamondCount(int doubleDiamondCount) {
		this.doubleDiamondCount = doubleDiamondCount;
	}

	/**
	 * @return the imageBitmap
	 */
	public Bitmap getImageBitmap() {
		return imageBitmap;
	}

	/**
	 * @param imageBitmap the imageBitmap to set
	 */
	public void setImageBitmap(Bitmap imageBitmap) {
		this.imageBitmap = imageBitmap;
	}

	/**
	 * @return the doubleDiamondRect
	 */
	public RectF getDoubleDiamondRect() {
		return doubleDiamondRect;
	}

	/**
	 * @param doubleDiamondRect the doubleDiamondRect to set
	 */
	public void setDoubleDiamondRect(RectF doubleDiamondRect) {
		this.doubleDiamondRect = doubleDiamondRect;
	}
	
	
	
}
