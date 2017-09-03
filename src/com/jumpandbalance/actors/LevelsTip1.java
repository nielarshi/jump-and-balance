package com.jumpandbalance.actors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.util.FontUtil;

public class LevelsTip1 {



	private Paint paint, textPaint;
	private RectF tipRect, tempTipRect;
	private boolean hasCollapsed, hasExpanded;
	
	
	public LevelsTip1() {
		paint = new Paint();
		paint.setStrokeWidth(2.0f);
		paint.setAntiAlias(true);
		paint.setAlpha(100);
		paint.setColor(Color.argb(120, 0, 0, 0));
		
		textPaint = FontUtil.getFontPaint(FontUtil.GASTBY_REGULAR, Color.YELLOW, 35);
	}
	
	public void draw(Canvas canvas) {
		canvas.drawRoundRect(tempTipRect, 30, 30, paint);
		
		
//		updateHomeTipBlock();
//		
//		if(!hasCollapsed && hasExpanded) {
//			
//			
//		}
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
	
}
