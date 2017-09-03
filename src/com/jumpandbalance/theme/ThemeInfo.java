/**
 * 
 */
package com.jumpandbalance.theme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.jumpandbalance.actors.ThemeRequest;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.ThemePanel;

/**
 * @author Priya
 *
 */
public class ThemeInfo {

	private String themeName;
	private int themeType;
	private int index;
	private static Paint levelTextPaint;
	private static String text;
	private static float textLength;
	private int x,y;
	private JumpAndBalanceGamePanel gamePanel;
	private RectF themeInfoRect;
	private Bitmap imageBitmap;
	private ThemePanel associatedThemePanel;
	
	public ThemeInfo(JumpAndBalanceGamePanel gamePanel, ThemePanel themePanel, int x, int y, int themeType) {
		this.gamePanel = gamePanel;
		this.associatedThemePanel = themePanel;
		this.x = x;
		this.y = y;
		this.themeType = themeType;
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.BLACK);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(1.0f);
		
		this.themeInfoRect = new RectF(x, y, x + 150, y + 150);
		
	}
	
	public void draw(Canvas canvas) {

	
	//	canvas.drawRoundRect(themeInfoRect, 10, 10, levelTextPaint);
		textLength = ((gamePanel.getWidth()/2) - (levelTextPaint.measureText(String.valueOf(this.themeType))/2));
		
		canvas.drawBitmap(imageBitmap, themeInfoRect.left, themeInfoRect.top, null);
		
		canvas.drawText(String.valueOf(this.themeType), textLength, y, levelTextPaint);
		
	}

	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= this.themeInfoRect.left
				&& (eventX <= this.themeInfoRect.right)) {
			if (eventY >= (this.themeInfoRect.top)
					&& (eventY <= (this.themeInfoRect.bottom))) {
				
				this.associatedThemePanel.setSelectedThemeIndex(index);
				

//				System.out.println("clicked theme info : true "+this.themeType);
//				
//				int type = 0;
//				if(this.themeType == Constants.THEME_ONE) {
//					type = 1;
//				} else if(this.themeType == Constants.THEME_TWO) {
//					type = 2;
//				} else if(this.themeType == Constants.THEME_THREE) {
//					type = 3;
//				} else if(this.themeType == Constants.THEME_FOUR) {
//					type = 4;
//				} 
//				this.gamePanel.getOngoingLevel().setTheme(ThemeFactory.getInstance(this.gamePanel.getContext()).getTheme(type));
//				
//				ThemeRequest.isRequested = false;
//				
//				this.gamePanel.getOngoingLevel().setOngoing(true);
//				this.gamePanel.getOngoingLevel().setInitialisingLevel(true);
//				this.gamePanel.getOngoingLevel().getThemePanel().updateThemePanelExit();
//				this.gamePanel.getOngoingLevel().getThemePanel().initilizeThemePanel();
//				
			} else {
				
			}
		} else {
			
		}
		
	}
	/**
	 * @return the themeName
	 */
	public String getThemeName() {
		return themeName;
	}
	/**
	 * @param themeName the themeName to set
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the themeType
	 */
	public int getThemeType() {
		return themeType;
	}

	/**
	 * @param themeType the themeType to set
	 */
	public void setThemeType(int themeType) {
		this.themeType = themeType;
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
	 * @return the themeInfoRect
	 */
	public RectF getThemeInfoRect() {
		return themeInfoRect;
	}

	/**
	 * @param themeInfoRect the themeInfoRect to set
	 */
	public void setThemeInfoRect(RectF themeInfoRect) {
		this.themeInfoRect = themeInfoRect;
	}
	
	
	
}
