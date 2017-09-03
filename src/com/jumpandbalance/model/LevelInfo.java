/**
 * 
 */
package com.jumpandbalance.model;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.R;
import com.jumpandbalance.actors.HomePillar;
import com.jumpandbalance.actors.Level;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.media.MediaHelper;
import com.jumpandbalance.stat.LevelGameStat;
import com.jumpandbalance.theme.LevelTheme;
import com.jumpandbalance.util.FontUtil;
import com.jumpandbalance.view.HomePanel;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.LevelPanel;
import com.jumpandbalance.view.LevelsPanel;

/**
 * @author Priya
 *
 */
public class LevelInfo {

	private String levelName;
	private String levelDescription;
	private String levelScore;
	private int x;
	private int y;
	private boolean locked;
	private boolean levelTouched;
	private Paint levelTextPaint, levelRectPaint;
	private RectF textRect;
	private Bitmap lockImageBitmap;
	private BitmapDrawable bitmapDrawable;
	private HomePanel homepanel;
	private Context context;
	private Paint paintBorder;
	private Bitmap levelBackImage;
	private LevelsPanel associatedLevelListPanel;
	private JumpAndBalanceGamePanel gamePanel;
	private Bitmap backgroundImageBitmap;
	private Bitmap homePillarBitmapImage;
	private int screenHeight;
	private HomePillar linkedHomePillar;
	
	private LevelGameStat levelGameStat;
	
	private int scoreorDiamond;
	private int countForDiamond;
	
	
	/**
	 * @return the scoreorDiamond
	 */
	public int getScoreorDiamond() {
		return scoreorDiamond;
	}


	/**
	 * @param scoreorDiamond the scoreorDiamond to set
	 */
	public void setScoreorDiamond(int scoreorDiamond) {
		this.scoreorDiamond = scoreorDiamond;
	}


	/**
	 * @return the countForDiamond
	 */
	public int getCountForDiamond() {
		return countForDiamond;
	}


	/**
	 * @param countForDiamond the countForDiamond to set
	 */
	public void setCountForDiamond(int countForDiamond) {
		this.countForDiamond = countForDiamond;
	}


	/**
	 * @return the levelGameStat
	 */
	public LevelGameStat getLevelGameStat() {
		return levelGameStat;
	}


	/**
	 * @param levelGameStat the levelGameStat to set
	 */
	public void setLevelGameStat(LevelGameStat levelGameStat) {
		this.levelGameStat = levelGameStat;
	}

	public void updateLevelInfoGameStat() {
		int score = 0;
		int diamondCount = 0;
		int doubleDiamondCount = 0;
		int starCount = 0;
		for(LevelPanel levelPanel : associatedLevelListPanel.getLevelList()) {
			score = score + levelPanel.getAssociatedLevel().getLevelGameStat().getScore();
			diamondCount = diamondCount + levelPanel.getAssociatedLevel().getLevelGameStat().getDiamondCount();
			doubleDiamondCount = doubleDiamondCount + levelPanel.getAssociatedLevel().getLevelGameStat().getDoubleDiamondCount();
			starCount = starCount + levelPanel.getAssociatedLevel().getLevelGameStat().getStarCount();
		}
		
		System.out.println("score "+score+" "+diamondCount+" "+doubleDiamondCount+" "+starCount);
		this.levelGameStat.setScore(score);
		this.levelGameStat.setDiamondCount(diamondCount);
		this.levelGameStat.setDoubleDiamondCount(doubleDiamondCount);
		this.levelGameStat.setStarCount(starCount);
	}
	
	
	/**
	 * @return the linkedHomePillar
	 */
	public HomePillar getLinkedHomePillar() {
		return linkedHomePillar;
	}


	/**
	 * @param linkedHomePillar the linkedHomePillar to set
	 */
	public void setLinkedHomePillar(HomePillar linkedHomePillar) {
		this.linkedHomePillar = linkedHomePillar;
	}


	/**
	 * @return the backgroundImageBitmap
	 */
	public Bitmap getBackgroundImageBitmap() {
		return backgroundImageBitmap;
	}


	/**
	 * @param backgroundImageBitmap the backgroundImageBitmap to set
	 */
	public void setBackgroundImageBitmap(Bitmap backgroundImageBitmap) {
		this.backgroundImageBitmap = backgroundImageBitmap;
	}


	/**
	 * @return the homePillarBitmapImage
	 */
	public Bitmap getHomePillarBitmapImage() {
		return homePillarBitmapImage;
	}


	/**
	 * @param homePillarBitmapImage the homePillarBitmapImage to set
	 */
	public void setHomePillarBitmapImage(Bitmap homePillarBitmapImage) {
		this.homePillarBitmapImage = homePillarBitmapImage;
	}


	/**
	 * @return the bitmapDrawable
	 */
	public BitmapDrawable getBitmapDrawable() {
		return bitmapDrawable;
	}


	/**
	 * @param bitmapDrawable the bitmapDrawable to set
	 */
	public void setBitmapDrawable(BitmapDrawable bitmapDrawable) {
		this.bitmapDrawable = bitmapDrawable;
	}


	/**
	 * @return the paintBorder
	 */
	public Paint getPaintBorder() {
		return paintBorder;
	}


	/**
	 * @param paintBorder the paintBorder to set
	 */
	public void setPaintBorder(Paint paintBorder) {
		this.paintBorder = paintBorder;
	}


	/**
	 * @return the levelBackImage
	 */
	public Bitmap getLevelBackImage() {
		return levelBackImage;
	}


	/**
	 * @param levelBackImage the levelBackImage to set
	 */
	public void setLevelBackImage(Bitmap levelBackImage) {
		this.levelBackImage = levelBackImage;
	}


	/**
	 * @return the associatedLevelListPanel
	 */
	public LevelsPanel getAssociatedLevelListPanel() {
		return associatedLevelListPanel;
	}


	/**
	 * @param associatedLevelListPanel the associatedLevelListPanel to set
	 */
	public void setAssociatedLevelListPanel(LevelsPanel associatedLevelListPanel) {
		this.associatedLevelListPanel = associatedLevelListPanel;
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


	/**
	 * @return the screenHeight
	 */
	public int getScreenHeight() {
		return screenHeight;
	}


	/**
	 * @param screenHeight the screenHeight to set
	 */
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}


	public LevelInfo(Context context, HomePanel homepanel, String levelName) {
		this.context = context;
		this.homepanel = homepanel;
		this.levelName = levelName;
		this.gamePanel = this.homepanel.getGamePanel();
		this.lockImageBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.locked);
		this.bitmapDrawable = new BitmapDrawable(lockImageBitmap);
		this.levelTextPaint = FontUtil.getFontPaint(FontUtil.AIRMOLE_STRIPE, Color.rgb(178,255,102), 28);
		
		this.levelRectPaint = new Paint();
		
		this.levelRectPaint.setStrokeWidth(2);
		this.levelRectPaint.setShadowLayer(4.0f, 15.0f, 8.0f, Color.BLACK);
		this.levelRectPaint.setAntiAlias(true);
		
		paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
        paintBorder.setShadowLayer(4.0f, 0.0f, 2.0f, Color.BLACK);
	
        this.levelBackImage = ImageHelper.getInstance().getImageFor(ImageHelper.BOARD);
		
        this.levelGameStat = new LevelGameStat();
        initializeLevelInfo();
	}


	private void initializeLevelInfo() {
		
		this.associatedLevelListPanel = new LevelsPanelBuilder().buildLevelsPanel(this);
		if(this.associatedLevelListPanel!=null) {
			this.associatedLevelListPanel.setAssociatedLevelInfo(this);
			this.associatedLevelListPanel.setBackgroundBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.BACKGROUND_UNDERWATER));
			
		}
		this.backgroundImageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.BACKGROUND_GRASS);
		
	}
	
	
	
	
	
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(linkedHomePillar.get_homePillarBitmapImage(), (this.x-this.linkedHomePillar.get_homePillarBitmapImage().getWidth()/2), this.y, null);
		
	//    this.y =  (y-levelBackImage.getHeight());
		
		canvas.drawBitmap(levelBackImage, (this.x-levelBackImage.getWidth()/2), (y-levelBackImage.getHeight()), null);

		if(locked) {
			this.levelRectPaint.setColor(Color.RED);
			this.bitmapDrawable.setBounds(this.x + 30,this.y -10  ,this.x + 130, this.y  + 70);
			this.bitmapDrawable.draw(canvas);
		} else {
			this.levelRectPaint.setColor(Color.WHITE);
		}
		
		float widthOfText = this.levelTextPaint.measureText(this.levelName);
		float xOfText = this.x - widthOfText/2;
		canvas.drawText(this.levelName, xOfText, (y-levelBackImage.getHeight())+45, this.levelTextPaint);
		
	}
	
	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (this.x-levelBackImage.getWidth()/2 - 20) && (eventX <= (this.x-levelBackImage.getWidth()/2 + 400))) {
			   if (eventY >= (this.y-levelBackImage.getHeight() - 10) && (eventY <= (this.y-levelBackImage.getHeight() + 60))) {
				    
				   if(!locked) {
					   
					 
					   setLevelTouched(true);
					   
					   this.gamePanel.setCurrentMainLevel(this);
					   this.gamePanel.setCurrentLevelPanel(this.associatedLevelListPanel);
					   this.gamePanel.setAlphaCount(255);
					   
				//	   JumpAndBalanceGamePanel.resetMusic();
					   
				//	   MainActivity.mplayer.stop();
				//	   MainActivity.mplayer.release();
				//	   MainActivity.mplayer = MediaHelper.getInstance(context).getSubLevelScreenBackgroundMusic();
					  
					   
					   
				   } else {
					   setLevelTouched(false);
				   }
			   } else {
				   setLevelTouched(false);
			   }
			} else {
				  setLevelTouched(false);
			}
		
	}
	
	

	/**
	 * @return the homepanel
	 */
	public HomePanel getHomepanel() {
		return homepanel;
	}


	/**
	 * @param homepanel the homepanel to set
	 */
	public void setHomepanel(HomePanel homepanel) {
		this.homepanel = homepanel;
	}


	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	/**
	 * @return the levelDescription
	 */
	public String getLevelDescription() {
		return levelDescription;
	}

	/**
	 * @param levelDescription the levelDescription to set
	 */
	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	/**
	 * @return the levelScore
	 */
	public String getLevelScore() {
		return levelScore;
	}

	/**
	 * @param levelScore the levelScore to set
	 */
	public void setLevelScore(String levelScore) {
		this.levelScore = levelScore;
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
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the levelTouched
	 */
	public boolean isLevelTouched() {
		return levelTouched;
	}
	/**
	 * @param levelTouched the levelTouched to set
	 */
	public void setLevelTouched(boolean levelTouched) {
		this.levelTouched = levelTouched;
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
	 * @return the levelRectPaint
	 */
	public Paint getLevelRectPaint() {
		return levelRectPaint;
	}


	/**
	 * @param levelRectPaint the levelRectPaint to set
	 */
	public void setLevelRectPaint(Paint levelRectPaint) {
		this.levelRectPaint = levelRectPaint;
	}


	/**
	 * @return the textRect
	 */
	public RectF getTextRect() {
		return textRect;
	}


	/**
	 * @param textRect the textRect to set
	 */
	public void setTextRect(RectF textRect) {
		this.textRect = textRect;
	}


	/**
	 * @return the lockImageBitmap
	 */
	public Bitmap getLockImageBitmap() {
		return lockImageBitmap;
	}


	/**
	 * @param lockImageBitmap the lockImageBitmap to set
	 */
	public void setLockImageBitmap(Bitmap lockImageBitmap) {
		this.lockImageBitmap = lockImageBitmap;
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
	
	
	
}
