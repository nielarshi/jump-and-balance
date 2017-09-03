/**
 * 
 */
package com.jumpandbalance.view;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.actors.ThemeRequest;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.theme.ThemeFactory;
import com.jumpandbalance.theme.ThemeInfo;
import com.jumpandbalance.theme.ThemeTwo;
import com.jumpandbalance.util.FontUtil;

/**
 * @author Priya
 *
 */
public class ThemePanel {
	
	
	private ArrayList<ThemeInfo> themeInfoList;
	private RectF textRect, textRect2;
	private Paint newPaint;
	private JumpAndBalanceGamePanel gamePanel;
	private Bitmap bgBitmap;
	private Bitmap themeSelected;
	private RectF themeSelectedRect;
	private Bitmap playButton;
	private RectF playButtonRect;
	private int selectedThemeIndex;
	private boolean movingback;
	
	public ThemePanel(JumpAndBalanceGamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.themeInfoList = new ArrayList<ThemeInfo>();
		this.newPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT);
		initilizeThemePanel();
	}

	public void initilizeThemePanel() {
		this.themeInfoList = new ArrayList<ThemeInfo>();
		
		movingback = false;
		int themePanelLeft = 45;
		int themePanelTop = -1 * gamePanel.getHeight() + 45;
		int themePanelBottom = -45;
		int themePanelRight = gamePanel.getWidth() - 45;
		
		textRect = new RectF(themePanelLeft, themePanelTop, themePanelRight, themePanelBottom);
		
		textRect2 = new RectF(themePanelLeft + 75, themePanelTop + 80, themePanelRight, themePanelTop + 160);
		
		
		ThemeInfo themeInfo = new ThemeInfo(this.gamePanel, this, themePanelLeft + 75, themePanelTop + 100, Constants.THEME_ONE);
		themeInfo.setImageBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.THEME_1_IMAGE));
		themeInfo.setIndex(1);
		this.themeInfoList.add(themeInfo);
		
		themeInfo = new ThemeInfo(this.gamePanel, this,  themePanelLeft + 75, themePanelTop + 175, Constants.THEME_TWO);
		themeInfo.setImageBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.THEME_2_IMAGE));
		themeInfo.setIndex(2);
		this.themeInfoList.add(themeInfo);
		
		themeInfo = new ThemeInfo(this.gamePanel, this,  themePanelLeft + 75, themePanelTop + 250, Constants.THEME_THREE);
		themeInfo.setImageBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.THEME_3_IMAGE));
		themeInfo.setIndex(3);
		this.themeInfoList.add(themeInfo);
		
		themeInfo = new ThemeInfo(this.gamePanel, this,  themePanelLeft + 75, themePanelTop + 325, Constants.THEME_FOUR);
		themeInfo.setImageBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.THEME_4_IMAGE));
		themeInfo.setIndex(4);
		this.themeInfoList.add(themeInfo);
		
		this.themeSelectedRect = new RectF(themePanelLeft + 255, themePanelTop + 110, themePanelLeft + 605, themePanelTop + 370);
		this.themeSelected = ImageHelper.getInstance().getImageFor(ImageHelper.THEME_1_IMAGE_BIG);
		
		this.playButtonRect = new RectF(themePanelRight - 150, themePanelBottom - 200, themePanelRight - 90, themePanelBottom - 140);
		this.playButton = ImageHelper.getInstance().getImageFor(ImageHelper.PLAY_IMAGE);
		
		this.selectedThemeIndex = 1;
	}

	/**
	 * @return the themeInfoList
	 */
	public ArrayList<ThemeInfo> getThemeInfoList() {
		return themeInfoList;
	}

	/**
	 * @param themeInfoList the themeInfoList to set
	 */
	public void setThemeInfoList(ArrayList<ThemeInfo> themeInfoList) {
		this.themeInfoList = themeInfoList;
	}
	
	public void draw(Canvas canvas) {
		
		
	
		//canvas.drawRoundRect(textRect, 44, 44, newPaint);
		canvas.drawBitmap(bgBitmap, null, textRect, null);
		
		canvas.drawText("Select a theme for the level", textRect2.left, textRect2.top, newPaint);
	
		for(Object themeInfoObj : themeInfoList.toArray()) {
			((ThemeInfo)themeInfoObj).draw(canvas);
		}
		
		canvas.drawBitmap(themeSelected, themeSelectedRect.left, themeSelectedRect.top, null);
		
		canvas.drawBitmap(playButton, playButtonRect.left, playButtonRect.top, null);
	}
	
	public void handleActionDown(int eventX, int eventY) {
		
		for(Object themeInfoObj : themeInfoList.toArray()) {
			((ThemeInfo)themeInfoObj).handleActionDown(eventX, eventY);
		} 
		
		if(playButtonRect!=null) {
			if (eventX >= playButtonRect.left && (eventX <= playButtonRect.right)) {
				   if (eventY >= (playButtonRect.top) && (eventY <= (playButtonRect.bottom ))) {
				   
				   
					 
						this.gamePanel.getOngoingLevel().setTheme(ThemeFactory.getInstance(this.gamePanel.getContext()).getTheme(selectedThemeIndex));
						
						ThemeRequest.isRequested = false;
						
						this.gamePanel.getOngoingLevel().setOngoing(true);
						this.gamePanel.getOngoingLevel().setInitialisingLevel(true);
						this.gamePanel.getOngoingLevel().getThemePanel().updateThemePanelExit();
						this.gamePanel.getOngoingLevel().getThemePanel().initilizeThemePanel();
						
				   }
			}
		}
		
	}
	
	public void updateThemePanel() {
		
		if(textRect.top < 100 && !movingback) {
			textRect.top = textRect.top + 40;
			textRect.bottom = textRect.bottom + 40;
			
			textRect2.top = textRect2.top + 40;
			textRect2.bottom = textRect2.bottom + 40;
			
			
			themeSelectedRect.top = themeSelectedRect.top + 40;
			themeSelectedRect.bottom = themeSelectedRect.bottom + 40;
			
			playButtonRect.top = playButtonRect.top + 40;
			playButtonRect.bottom = playButtonRect.bottom + 40;
			
			for(Object themeInfoObj : themeInfoList.toArray()) {
				((ThemeInfo)themeInfoObj).getThemeInfoRect().top = ((ThemeInfo)themeInfoObj).getThemeInfoRect().top + 40;
				((ThemeInfo)themeInfoObj).getThemeInfoRect().bottom = ((ThemeInfo)themeInfoObj).getThemeInfoRect().bottom + 40;
				
			}
		} else {
			
			if(textRect.top > 45) {
				textRect.top = textRect.top - 15;
				textRect.bottom = textRect.bottom - 15;
				
				textRect2.top = textRect2.top - 15;
				textRect2.bottom = textRect2.bottom - 15;
				
				
				themeSelectedRect.top = themeSelectedRect.top - 15;
				themeSelectedRect.bottom = themeSelectedRect.bottom - 15;
				
				playButtonRect.top = playButtonRect.top - 15;
				playButtonRect.bottom = playButtonRect.bottom - 15;
				
				for(Object themeInfoObj : themeInfoList.toArray()) {
					((ThemeInfo)themeInfoObj).getThemeInfoRect().top = ((ThemeInfo)themeInfoObj).getThemeInfoRect().top -15;
					((ThemeInfo)themeInfoObj).getThemeInfoRect().bottom = ((ThemeInfo)themeInfoObj).getThemeInfoRect().bottom -15;
					
				}
				
				movingback = true;
			}
		}
		
	}
	
	public void updateThemePanelExit() {
		textRect.top = textRect.top + 40;
		textRect.bottom = textRect.bottom + 40;
		
		for(Object themeInfoObj : themeInfoList.toArray()) {
			((ThemeInfo)themeInfoObj).setY(((ThemeInfo)themeInfoObj).getY() + 40);
		}
	}

	/**
	 * @return the bgBitmap
	 */
	public Bitmap getBgBitmap() {
		return bgBitmap;
	}

	/**
	 * @param bgBitmap the bgBitmap to set
	 */
	public void setBgBitmap(Bitmap bgBitmap) {
		this.bgBitmap = bgBitmap;
	}

	/**
	 * @return the movingback
	 */
	public boolean isMovingback() {
		return movingback;
	}

	/**
	 * @param movingback the movingback to set
	 */
	public void setMovingback(boolean movingback) {
		this.movingback = movingback;
	}

	/**
	 * @return the themeSelected
	 */
	public Bitmap getThemeSelected() {
		return themeSelected;
	}

	/**
	 * @param themeSelected the themeSelected to set
	 */
	public void setThemeSelected(Bitmap themeSelected) {
		this.themeSelected = themeSelected;
	}

	/**
	 * @return the selectedThemeIndex
	 */
	public int getSelectedThemeIndex() {
		return selectedThemeIndex;
	}

	/**
	 * @param selectedThemeIndex the selectedThemeIndex to set
	 */
	public void setSelectedThemeIndex(int selectedThemeIndex) {
		this.selectedThemeIndex = selectedThemeIndex;
		
		if(selectedThemeIndex == 1) {
			this.themeSelected = ImageHelper.getInstance().getImageFor(ImageHelper.THEME_1_IMAGE_BIG);
			
		} else if(selectedThemeIndex == 2) {
			this.themeSelected = ImageHelper.getInstance().getImageFor(ImageHelper.THEME_2_IMAGE_BIG);
			
		} else if(selectedThemeIndex == 3) {
			this.themeSelected = ImageHelper.getInstance().getImageFor(ImageHelper.THEME_3_IMAGE_BIG);
			
		} else if(selectedThemeIndex == 4) {
			this.themeSelected = ImageHelper.getInstance().getImageFor(ImageHelper.THEME_4_IMAGE_BIG);
			
		}
		
	}
	
	
	
}
