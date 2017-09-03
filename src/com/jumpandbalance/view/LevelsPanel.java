package com.jumpandbalance.view;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.actors.BackButton;
import com.jumpandbalance.actors.LevelsTip1;
import com.jumpandbalance.actors.MusicButton;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.model.LevelInfo;
import com.jumpandbalance.util.FontUtil;

public class LevelsPanel {

	private ArrayList<LevelPanel> levelList;
	private LevelInfo associatedLevelInfo;
	private Bitmap backgroundBitmap;
	private Paint levelTextPaint, levelNameTextPaint;
	private Bitmap papernoteBitmap;
	
	private RectF paperNoteRect;
	
	private LevelsTip1 levelsTip1;
	
	
	private RectF starRect, diamondRect, doubleDiamondRect;
	private Bitmap starBitmap, diamondBitmap, doubleDiamondBitmap;
	
	
	/**
	 * @return the backgroundBitmap
	 */
	public Bitmap getBackgroundBitmap() {
		return backgroundBitmap;
	}

	/**
	 * @param backgroundBitmap the backgroundBitmap to set
	 */
	public void setBackgroundBitmap(Bitmap backgroundBitmap) {
		this.backgroundBitmap = backgroundBitmap;
	}

	public LevelsPanel() {
		if(this.levelList==null) {
			this.levelList = new ArrayList<LevelPanel>();
			
			
			this.levelTextPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, Color.GRAY, 38);
			this.levelNameTextPaint = FontUtil.getFontPaint(FontUtil.AIRMOLE_STRIPE, Color.DKGRAY, 55);
		}
		
		levelsTip1 = new LevelsTip1();
		this.levelsTip1.setTipRect(new RectF(-10, 450, 1200, 700));
		
		papernoteBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.PAPERNOTE_IMAGE);
		
		starBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.STAR_IMAGE);
		diamondBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.DIAMOND_IMAGE);
		//doubleDiamondBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.DOUBLE_DIAMOND_IMAGE);
		
		
		
	//	paperNoteRect = new RectF(50, 50, 500, 50);
	}
	
	/**
	 * @return the levelList
	 */
	public ArrayList<LevelPanel> getLevelList() {
		return levelList;
	}

	/**
	 * @param levelList the levelList to set
	 */
	public void setLevelList(ArrayList<LevelPanel> levelList) {
		this.levelList = levelList;
	}

	
	/**
	 * @return the associatedLevelInfo
	 */
	public LevelInfo getAssociatedLevelInfo() {
		return associatedLevelInfo;
	}

	/**
	 * @param associatedLevelInfo the associatedLevelInfo to set
	 */
	public void setAssociatedLevelInfo(LevelInfo associatedLevelInfo) {
		this.associatedLevelInfo = associatedLevelInfo;
	}

	public void draw(Canvas canvas) {
		
		canvas.drawBitmap(backgroundBitmap, 0, 0, null);
		
		canvas.rotate(-8);
		canvas.drawText(this.associatedLevelInfo.getLevelName(), 40, 140, levelNameTextPaint);
		canvas.restore();
		
		
		canvas.drawBitmap(Bitmap.createScaledBitmap(papernoteBitmap, 400, 400, true), 60, 120, null);
		
		BackButton.setHomepanel(MainActivity.gamePanel.getHomePanel());
		BackButton.draw(canvas);

		MusicButton.setHomepanel(MainActivity.gamePanel.getHomePanel());
		MusicButton.draw(canvas);

		

		canvas.drawText("Click on a level to start", 500, 70, FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, 25));
		
		
		canvas.rotate(-8);
		canvas.drawText("Score  "+String.valueOf(this.associatedLevelInfo.getLevelGameStat().getScore()), 105, 260, levelTextPaint);
		
		
		canvas.drawBitmap(starBitmap, 140, 300, null);
		canvas.drawText(String.valueOf(this.associatedLevelInfo.getLevelGameStat().getStarCount())+" / "+this.levelList.size() * 5, 220, 335, levelTextPaint);
		
		canvas.drawBitmap(diamondBitmap, 144, 370, null);
		canvas.drawText(String.valueOf(this.associatedLevelInfo.getLevelGameStat().getDiamondCount()), 224, 405, levelTextPaint);
		
//		canvas.drawBitmap(doubleDiamondBitmap, 168, 380, null);
//		canvas.drawText(String.valueOf(this.associatedLevelInfo.getLevelGameStat().getDoubleDiamondCount()), 248, 410, levelTextPaint);
//		
		canvas.rotate(+8);
		canvas.restore();
		
		
		for(Object levelpanelObj : levelList.toArray()) {
			if(((LevelPanel)levelpanelObj).isLocked()) {
				((LevelPanel)levelpanelObj).setLevelBackImage(ImageHelper.getInstance().getImageFor(ImageHelper.LOCKED_LEVEL_BACK_IMAGE));
				
			} else {
				((LevelPanel)levelpanelObj).setLevelBackImage(ImageHelper.getInstance().getImageFor(ImageHelper.LEVEL_BACK_IMAGE));
			}
			if(JumpAndBalanceGamePanel.isRestored) {
				if(associatedLevelInfo.getGamePanel().getOngoingLevel()!=null) {
					if(((LevelPanel)levelpanelObj).getAssociatedLevel().getLevelType().equals(associatedLevelInfo.getGamePanel().getOngoingLevel().getLevelType())) {
						((LevelPanel)levelpanelObj).setLevelBackImage(ImageHelper.getInstance().getImageFor(ImageHelper.ONGOING_LEVEL_BACK_IMAGE));	
					}
				}
			}
			
			((LevelPanel)levelpanelObj).draw(canvas);
		}
		
		levelsTip1.draw(canvas);
	}
	
	public void handleActionDown(int eventX, int eventY) {
		
		BackButton.clicked = true;
		
		for(Object levelpanelObj : levelList.toArray()) {
			((LevelPanel)levelpanelObj).handleActionDown(eventX, eventY);
		}
	}
	
}
