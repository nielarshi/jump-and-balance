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
public class SubLevelDiamond {

	private int diamondCount;
	private Bitmap imageBitmap;
	private RectF diamondRect;
	private Paint textPaint;
	private Paint circlePaint;
	private RectF diamondTempRect;
	private boolean addingNewDiamond;
	
	public SubLevelDiamond() {
		this.imageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.DIAMOND_IMAGE);
		this.diamondCount = 0;
		this.diamondRect = new RectF(0, 0, 100, 100);
		this.textPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT);
		this.textPaint.setTextSize(25);
		
		this.circlePaint = new Paint();
		this.circlePaint.setColor(Color.argb(50, 0, 0, 0));
		this.circlePaint.setAntiAlias(true);
	}
	
	public void draw(Canvas canvas) {
		
	//	canvas.drawCircle(((this.diamondRect.left + this.diamondRect.right)/2 ), ((this.diamondRect.top + this.diamondRect.bottom)/2 - 5), 40, circlePaint);
		
		if(addingNewDiamond) {
			canvas.drawBitmap(imageBitmap, null, diamondTempRect, null);
			updateNewDiamond();	
		} else {
			canvas.drawBitmap(imageBitmap, null, diamondRect, null);
		}
		
		canvas.drawText(String.valueOf(diamondCount), this.diamondRect.left - 40, this.diamondRect.top + 30, textPaint);
	}
	
	public void updateNewDiamond() {
		addingNewDiamond = true;
		if(diamondTempRect.left < (diamondTempRect.right - 40)) {
			diamondTempRect.left = diamondTempRect.left + 10;
			diamondTempRect.bottom = diamondTempRect.bottom - 10;
		} else {
			addingNewDiamond = false;
			initializeSublevelDiamond();
		}
	}
	
	public void initializeSublevelDiamond() {
		setDiamondRect(diamondRect);
	}
	
	/**
	 * @return the diamondCount
	 */
	public int getDiamondCount() {
		return diamondCount;
	}
	/**
	 * @param diamondCount the diamondCount to set
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
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
	 * @return the diamondRect
	 */
	public RectF getDiamondRect() {
		return diamondRect;
	}

	/**
	 * @param diamondRect the diamondRect to set
	 */
	public void setDiamondRect(RectF diamondRect) {
		this.diamondRect = diamondRect;
		
		this.diamondTempRect = new RectF(diamondRect.left - 120, diamondRect.top, diamondRect.right, diamondRect.bottom + 120);
	}

	/**
	 * @return the addingNewDiamond
	 */
	public boolean isAddingNewDiamond() {
		return addingNewDiamond;
	}

	/**
	 * @param addingNewDiamond the addingNewDiamond to set
	 */
	public void setAddingNewDiamond(boolean addingNewDiamond) {
		this.addingNewDiamond = addingNewDiamond;
	}
	
	
	
}
