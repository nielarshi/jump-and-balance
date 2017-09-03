/**
 * 
 */
package com.jumpandbalance.model;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;

import com.jumpandbalance.actors.HomePillar;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.view.HomePanel;

/**
 * @author Priya
 *
 */
public class HomeLevelInfoBuilder {

	private Context context;
	private HomePanel homePanel;
	private int screenHeight;
	private Bitmap homePillarBitmapImage;
	
	public HomeLevelInfoBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public HomeLevelInfoBuilder(Context context, HomePanel homePanel) {
		this.context = context;
		this.homePanel = homePanel;
		
		this.screenHeight = this.homePanel.getGamePanel().getHeight();
	}
	public ArrayList<LevelInfo> buildLevelInfoList() {
		
		ArrayList<LevelInfo> levelInfoList = new ArrayList<LevelInfo>();
		LevelInfo levelInfo = null;
		HomePillar homePillar = null;
		
		levelInfo = new LevelInfo(this.context, this.homePanel ,Constants.LEVEL_ONE_NAME);
		homePillar = new HomePillar();
		
		
		homePillarBitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.WOOD_PLANK_SHORT);
		
		homePillar.set_homePillarBitmapImage(homePillarBitmapImage);
		levelInfo.setLinkedHomePillar(homePillar);
		levelInfo.setLevelName(Constants.LEVEL_ONE_NAME);
		int pillarX = 120;
		int x = (pillarX + (homePillarBitmapImage.getWidth()/2));
		int y = (screenHeight-homePillarBitmapImage.getHeight());
		levelInfo.setX(x);
		levelInfo.setY(y);
		levelInfo.setLocked(false);
		levelInfoList.add(levelInfo);
		
		levelInfo = new LevelInfo(this.context, this.homePanel, Constants.LEVEL_TWO_NAME);
		homePillar = new HomePillar();
		
		homePillarBitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.WOOD_PLANK_LONG);
		
		homePillar.set_homePillarBitmapImage(homePillarBitmapImage);
		levelInfo.setLinkedHomePillar(homePillar);
		levelInfo.setLevelName(Constants.LEVEL_TWO_NAME);
		pillarX = 320;
		x = (pillarX + (homePillarBitmapImage.getWidth()/2));
		y = (screenHeight-homePillarBitmapImage.getHeight());
		levelInfo.setX(x);
		levelInfo.setY(y);
		levelInfo.setLocked(false);
		levelInfoList.add(levelInfo);
		
		levelInfo = new LevelInfo(this.context, this.homePanel, Constants.LEVEL_THREE_NAME);
		homePillar = new HomePillar();
		homePillarBitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.WOOD_PLANK_MEDIUM);
		homePillar.set_homePillarBitmapImage(homePillarBitmapImage);
		levelInfo.setLinkedHomePillar(homePillar);
		levelInfo.setLevelName(Constants.LEVEL_THREE_NAME);
		pillarX = 550;
		x = (pillarX + (homePillarBitmapImage.getWidth()/2));
		y = (screenHeight-homePillarBitmapImage.getHeight());
		levelInfo.setX(x);
		levelInfo.setY(y);
		levelInfo.setLocked(false);
		levelInfoList.add(levelInfo);
		
		levelInfo = new LevelInfo(this.context, this.homePanel, Constants.LEVEL_FOUR_NAME);
		homePillar = new HomePillar();
		homePillarBitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.WOOD_PLANK_LONG);
		homePillar.set_homePillarBitmapImage(homePillarBitmapImage);
		levelInfo.setLinkedHomePillar(homePillar);
		levelInfo.setLevelName(Constants.LEVEL_FOUR_NAME);
		pillarX = 800;
		x = (pillarX + (homePillarBitmapImage.getWidth()/2));
		y = (screenHeight-homePillarBitmapImage.getHeight());
		levelInfo.setX(x);
		levelInfo.setY(y);
		levelInfo.setLocked(false);
		levelInfoList.add(levelInfo);
		
		return levelInfoList;
	}
}
