/**
 * 
 */
package com.jumpandbalance.actors;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.util.FontUtil;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author Priya
 *
 */
public class HomeTip1 {

	private Paint paint, textPaint;
	private RectF tipRect, tempTipRect;
	private boolean hasCollapsed, hasExpanded;
	
	private int starCount;
	private int doubleDiamondCount;
	
	
	public HomeTip1() {
		paint = new Paint();
		paint.setStrokeWidth(2.0f);
		paint.setAntiAlias(true);
		paint.setAlpha(100);
		paint.setColor(Color.argb(120, 0, 0, 0));
		
		textPaint = FontUtil.getFontPaint(FontUtil.GASTBY_REGULAR, Color.YELLOW, 35);
	}
	
	public void draw(Canvas canvas) {
		canvas.drawRoundRect(tempTipRect, 30, 30, paint);
		updateHomeTipBlock();
		
		if(!hasCollapsed && hasExpanded) {
			canvas.drawText("You have "+starCount+" STARS", tempTipRect.left + 20, tempTipRect.top + 80, textPaint);
			
			if(MainActivity.gamePanel.getCurrentMainLevel()!=null) {
				if(MainActivity.gamePanel.getCurrentMainLevel().getLevelName().equals(Constants.LEVEL_ONE_NAME)) {

					canvas.drawText("You need "+starCount+" STARS to unlock next level", tempTipRect.left + 20, tempTipRect.top + 140, textPaint);
					
				}
			}
			
			
		}
	}

	private void updateHomeTipBlock() {
		if(tempTipRect.left < tipRect.left) {
			tempTipRect.left = tempTipRect.left + 50;
			tempTipRect.right = tempTipRect.right - 1;
			
		} else {
			if(!hasExpanded) {
				hasCollapsed = true;
			}
			
		}
		
		if(hasCollapsed) {
			tempTipRect.left = tempTipRect.left - 60;
			hasExpanded = true;
			
		}
		
		if(hasExpanded) {
			if(hasCollapsed) {
				tempTipRect.left = tempTipRect.left +40;
				hasCollapsed = false;
			}
			
			
		}
		
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
	 * @return the tipRect
	 */
	public RectF getTipRect() {
		return tipRect;
	}

	/**
	 * @param tipRect the tipRect to set
	 */
	public void setTipRect(RectF tipRect) {
		this.tipRect = tipRect;
		
		this.tempTipRect = new RectF(-50 , this.tipRect.top, this.tipRect.right + 50, this.tipRect.bottom);
		
		
	}
	

	
	/**
	 * @return the starCount
	 */
	public int getStarCount() {
		return starCount;
	}

	/**
	 * @param starCount the starCount to set
	 */
	public void setStarCount(int starCount) {
		this.starCount = starCount;
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

}
