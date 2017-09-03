/**
 * 
 */
package com.jumpandbalance.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.actors.HomeBall1;
import com.jumpandbalance.actors.HomeBall2;
import com.jumpandbalance.actors.HomeBall3;
import com.jumpandbalance.actors.HomeBall4;
import com.jumpandbalance.actors.HomeObject;
import com.jumpandbalance.actors.HomeTip1;
import com.jumpandbalance.actors.MusicButton;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.model.HomeLevelInfoBuilder;
import com.jumpandbalance.model.LevelInfo;
import com.jumpandbalance.util.FontUtil;

/**
 * @author Priya
 *
 */
public class HomePanel {

	private ArrayList<LevelInfo> levelInfoList;
	private Paint levelTextPaint;
	private Context context;
	private JumpAndBalanceGamePanel gamePanel;
	private Bitmap backgroundImageBitmap;
	private static Bitmap homePillarBitmapImage;
	private int screenHeight;
	
	private HomeObject homeObject;
	private HomeBall1 homeBall1;
	private HomeBall2 homeBall2;
	private HomeBall3 homeBall3;
	private HomeBall4 homeBall4;
	
	private HomeTip1 homeTip1;
	
	public HomePanel(Context context, JumpAndBalanceGamePanel gamePanel) {
		this.context = context;
		this.gamePanel = gamePanel;
		this.screenHeight = this.gamePanel.getHeight();
		
		
		initializeHome();
	}
	
	public HomePanel(ArrayList<LevelInfo> levelInfoList) {
		this.levelInfoList = levelInfoList;
	}
	
	private void initializeHome() {
		this.levelTextPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, 80);
		
		this.backgroundImageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.BACKGROUND_GRASS);
		
		this.levelInfoList = new HomeLevelInfoBuilder(context, this).buildLevelInfoList();
		
		this.homeObject = new HomeObject();
		
		this.homeBall1 = new HomeBall1();
		this.homeBall1.setX(30);
		this.homeBall1.setY(screenHeight - this.homeBall1.getBitmapImage().getHeight() - 10);
		
		this.homeBall2 = new HomeBall2();
		this.homeBall2.setX(160);
		this.homeBall2.setY(screenHeight - this.homeBall2.getBitmapImage().getHeight() - 10);
		
		this.homeBall3 = new HomeBall3();
		this.homeBall3.setX(260);
		this.homeBall3.setY(screenHeight - this.homeBall3.getBitmapImage().getHeight() - 10);
		
		this.homeBall4 = new HomeBall4();
		this.homeBall4.setX(380);
		this.homeBall4.setY(screenHeight - this.homeBall4.getBitmapImage().getHeight() - 10);
		
		this.homeTip1 = new HomeTip1();
		this.homeTip1.setTipRect(new RectF(this.gamePanel.getWidth()/2, this.gamePanel.getHeight()/2, this.gamePanel.getWidth() + 50, this.gamePanel.getHeight() - 30));
	
		int starSum = 0, doubleDiamondCountSum = 0;
		for(LevelInfo levelInfo : levelInfoList) {
			 starSum += levelInfo.getLevelGameStat().getStarCount();
			 doubleDiamondCountSum += levelInfo.getLevelGameStat().getDoubleDiamondCount();
		 }
		
		this.homeTip1.setStarCount(starSum);
		this.homeTip1.setDoubleDiamondCount(doubleDiamondCountSum);
	}
	public void draw(Canvas canvas) {
		System.out.println("Painting text");
		canvas.drawBitmap(backgroundImageBitmap, 0, 0, null);
		
		canvas.drawText("Levels", 65, 100, levelTextPaint);
		
		MusicButton.setHomepanel(MainActivity.gamePanel.getHomePanel());
		MusicButton.draw(canvas);
		
		this.homeBall1.draw(canvas);
		this.homeBall2.draw(canvas);
		this.homeBall3.draw(canvas);
		this.homeBall4.draw(canvas);
		
		int starSum = 0, doubleDiamondCountSum = 0;
		
		for(LevelInfo levelInfo : levelInfoList) {
			 levelInfo.draw(canvas);
			 starSum += levelInfo.getLevelGameStat().getStarCount();
			 doubleDiamondCountSum += levelInfo.getLevelGameStat().getDoubleDiamondCount();
		 }
		
		this.homeTip1.setStarCount(starSum);
		this.homeTip1.setDoubleDiamondCount(doubleDiamondCountSum);
		
		
		this.homeObject.draw(canvas);
		this.homeObject.updateObjectLocation();
		
		this.homeTip1.draw(canvas);
		
	}
	
	public void handleActionDown(int eventX, int eventY) {
		
		for(LevelInfo levelInfo : levelInfoList) {
			 levelInfo.handleActionDown(eventX, eventY);
			 
		 }
	}
	

	/**
	 * @return the levelInfoList
	 */
	public ArrayList<LevelInfo> getLevelInfoList() {
		return levelInfoList;
	}

	/**
	 * @param levelInfoList the levelInfoList to set
	 */
	public void setLevelInfoList(ArrayList<LevelInfo> levelInfoList) {
		this.levelInfoList = levelInfoList;
	}

	/**
	 * @return the levelTextPaint
	 */
	public Paint getLevelTextPaint() {
		return levelTextPaint;
	}

	/**
	 * @param levelTextPaint the levelTextPaint to set
	 */
	public void setLevelTextPaint(Paint levelTextPaint) {
		this.levelTextPaint = levelTextPaint;
	}

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * @return the gamePanel
	 */
	public JumpAndBalanceGamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * @param gamePanel the gamePanel to set
	 */
	public void setGamePanel(JumpAndBalanceGamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	
}
