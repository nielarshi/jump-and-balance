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
public class SubLevelScore {

	private int score;
	private Bitmap imageBitmap;
	private RectF scoreRect;
	private Paint textPaint;
	
	public SubLevelScore() {
		this.imageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.BUBBLE_SKYBLUE);
		this.score = 0;
		this.scoreRect = new RectF(200, 0, 300, 100);
		this.textPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT);
		this.textPaint.setStrokeWidth(5);
		this.textPaint.setTextSize(40);
	}
	
	public void draw(Canvas canvas) {
	//	canvas.drawBitmap(imageBitmap, this.scoreRect.left - 10, this.scoreRect.top, null);
		canvas.drawText(String.valueOf(score), this.scoreRect.left, this.scoreRect.top + 30, textPaint);
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
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
	 * @return the scoreRect
	 */
	public RectF getScoreRect() {
		return scoreRect;
	}

	/**
	 * @param scoreRect the scoreRect to set
	 */
	public void setScoreRect(RectF scoreRect) {
		this.scoreRect = scoreRect;
	}
	
	
}
