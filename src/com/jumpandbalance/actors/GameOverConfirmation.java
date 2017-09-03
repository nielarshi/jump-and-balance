package com.jumpandbalance.actors;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.gamedata.GameData;
import com.jumpandbalance.gamedata.GameDataHelper;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.stat.LevelGameStat;
import com.jumpandbalance.util.FontUtil;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.LevelPanel;

public class GameOverConfirmation {

	private JumpAndBalanceGamePanel gamePanel;
	
	
	private LevelGameStat levelGameStat;
	private RectF panelRect;
	private Bitmap backGroundImage;
	
	private Paint scoreTextPaint;
	
	private RectF starRect, starRect2, starRect3, starRect4, starRect5;
	private RectF diamondRect;
	//private RectF doubleDiamondRect;
	
	
	private Bitmap starImage;
	private Bitmap diamondImage;
	//private Bitmap doubleDiamondImage;
	
	private RectF menuRect;
	private Bitmap menubackImage;
	private RectF continueRect;
	private Bitmap continueBackImage;
	private RectF replayRect;
	private Bitmap replayBackImage;

	private boolean movingback;
	private boolean canDrawScore;
	private boolean canDrawStar1, canDrawStar2, canDrawStar3, canDrawStar4, canDrawStar5;
	private boolean canDrawDiamond;
	//private boolean canDrawDoubleDiamond;
	private boolean canDrawScoreText;
	private boolean canDrawButtons;
	private boolean canDrawFlowers;
	
	private Paint scoreDetailsTextPaint;
	
	private int starCount;
	
	private Butterfly1 butterfly1;
	private Butterfly2 butterfly2;
	private Butterfly3 butterfly3;
	private Butterfly4 butterfly4;
	private Butterfly5 butterfly5;
	private Butterfly6 butterfly6;
	private Butterfly7 butterfly7;
	private Butterfly8 butterfly8;
	private Butterfly9 butterfly9;
	private Butterfly10 butterfly10;
	private Butterfly11 butterfly11;
	private Butterfly12 butterfly12;
	
	private Background fs;
	
	public GameOverConfirmation(JumpAndBalanceGamePanel gamePanel) {
		this.gamePanel = gamePanel;
		initializeGameOverScreen();
	}
	
	public void initializeGameOverScreen() {
		movingback = false;
		canDrawScore = false;
		canDrawDiamond = false;
		//canDrawDoubleDiamond = false;
		canDrawButtons = false;
		
		scoreTextPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, 70);
		scoreTextPaint.setAlpha(0);
		
		scoreDetailsTextPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, Color.DKGRAY, 25);
		scoreDetailsTextPaint.setAlpha(255);
		
		int panelLeft = 45;
		int panelTop = -1 * gamePanel.getHeight() + 45;
		int panelBottom = -45;
		int panelRight = gamePanel.getWidth() - 45;
		
		this.panelRect = new RectF(panelLeft, panelTop, panelRight, panelBottom);
		
		this.starRect = new RectF(panelLeft + 250, panelTop + 120, panelLeft + 1550, panelTop + 1420);
		this.starRect2 = new RectF(panelLeft + 300, panelTop + 120, panelLeft + 1600, panelTop + 1420);
		this.starRect3 = new RectF(panelLeft + 350, panelTop + 120, panelLeft + 1650, panelTop + 1420);
		this.starRect4 = new RectF(panelLeft + 400, panelTop + 120, panelLeft + 1700, panelTop + 1420);
		this.starRect5 = new RectF(panelLeft + 450, panelTop + 120, panelLeft + 1750, panelTop + 1420);
		
		
		
		this.starImage = ImageHelper.getInstance().getImageFor(ImageHelper.STAR_IMAGE);
		
		this.diamondRect = new RectF(panelLeft + 150, panelTop + 230, panelLeft + 1450, panelTop + 1530);
		this.diamondImage = ImageHelper.getInstance().getImageFor(ImageHelper.DIAMOND_IMAGE);
		
		/*this.doubleDiamondRect = new RectF(panelLeft + 150, panelTop + 300, panelLeft + 1450, panelTop + 1600);
		this.doubleDiamondImage = ImageHelper.getInstance().getImageFor(ImageHelper.DOUBLE_DIAMOND_IMAGE);*/
		
		this.menuRect = new RectF(panelRight - 200, panelTop + 140, panelRight - 140, panelTop + 200);
		this.menubackImage = ImageHelper.getInstance().getImageFor(ImageHelper.MENU_IMAGE);
		
		this.continueRect = new RectF(panelRight - 200, panelTop + 220, panelRight - 140, panelTop + 280);
		this.continueBackImage = ImageHelper.getInstance().getImageFor(ImageHelper.CONTINUE_IMAGE);
		
		this.replayRect = new RectF(panelRight - 200, panelTop + 300, panelRight - 140, panelTop + 360);
		this.replayBackImage = ImageHelper.getInstance().getImageFor(ImageHelper.REPLAY_IMAGE);
		
		butterfly1 = new Butterfly1(this);
		butterfly2 = new Butterfly2(this);
		butterfly3 = new Butterfly3(this);
		butterfly4 = new Butterfly4(this);
		butterfly5 = new Butterfly5(this);
		butterfly6 = new Butterfly6(this);
		butterfly7 = new Butterfly7(this);
		butterfly8 = new Butterfly8(this);
		butterfly9 = new Butterfly9(this);
		butterfly10 = new Butterfly10(this);
		butterfly11 = new Butterfly11(this);
		butterfly12 = new Butterfly12(this);
		
		this.fs = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.FIVE_STAR),45,45);
		
		
	}
	
	public void updateGameOverConfirmationPanel() {
		
		if(panelRect.top < 100 && !movingback) {
			panelRect.top = panelRect.top + 40;
			panelRect.bottom = panelRect.bottom + 40;
			
			starRect.top = starRect.top + 40;
			starRect.bottom = starRect.bottom + 40;
			
			starRect2.top = starRect2.top + 40;
			starRect2.bottom = starRect2.bottom + 40;
			
			starRect3.top = starRect3.top + 40;
			starRect3.bottom = starRect3.bottom + 40;
			
			starRect4.top = starRect4.top + 40;
			starRect4.bottom = starRect4.bottom + 40;
			
			starRect5.top = starRect5.top + 40;
			starRect5.bottom = starRect5.bottom + 40;
			
			menuRect.top = menuRect.top + 40;
			menuRect.bottom = menuRect.bottom + 40;
			
			diamondRect.top = diamondRect.top + 40;
			diamondRect.bottom = diamondRect.bottom + 40;
			
			/*doubleDiamondRect.top = doubleDiamondRect.top + 40;
			doubleDiamondRect.bottom = doubleDiamondRect.bottom + 40;*/
			
			continueRect.top = continueRect.top + 40;
			continueRect.bottom = continueRect.bottom + 40;
			
			replayRect.top = replayRect.top + 40;
			replayRect.bottom = replayRect.bottom + 40;
			
		} else {
			
			if(panelRect.top > 45) {
				panelRect.top = panelRect.top - 15;
				panelRect.bottom = panelRect.bottom - 15;
				
				starRect.top = starRect.top - 15;
				starRect.bottom = starRect.bottom - 15;
				
				starRect2.top = starRect2.top - 15;
				starRect2.bottom = starRect2.bottom - 15;
				
				starRect3.top = starRect3.top - 15;
				starRect3.bottom = starRect3.bottom - 15;
				
				starRect4.top = starRect4.top - 15;
				starRect4.bottom = starRect4.bottom - 15;
				
				starRect5.top = starRect5.top - 15;
				starRect5.bottom = starRect5.bottom - 15;
				
				menuRect.top = menuRect.top - 15;
				menuRect.bottom = menuRect.bottom - 15;
				
				diamondRect.top = diamondRect.top -15;
				diamondRect.bottom = diamondRect.bottom - 15;
				
				/*doubleDiamondRect.top = doubleDiamondRect.top -15;
				doubleDiamondRect.bottom = doubleDiamondRect.bottom -15;*/
				
				continueRect.top = continueRect.top - 15;
				continueRect.bottom = continueRect.bottom - 15;
				
				replayRect.top = replayRect.top - 15;
				replayRect.bottom = replayRect.bottom - 15;
				
				movingback = true;
				
			} else {
				canDrawScore = true;
			}
		}
		
	}
	
	public void updateScore() {
		if(canDrawScore) {
			if(scoreTextPaint.getTextSize() > 35) {
				scoreTextPaint.setTextSize(scoreTextPaint.getTextSize() - 6);
				scoreTextPaint.setAlpha(scoreTextPaint.getAlpha()+10);
			} else {
				scoreTextPaint.setAlpha(250);
				canDrawStar1 = true;
			}
			
		}
	}
	
	public void updateStar1() {
		if(canDrawStar1) {
			if(starRect.right > (starRect.left + 70)) {
				starRect.right = starRect.right - 50;
				starRect.bottom = starRect.bottom - 50;
			} else {
				starCount=1;
				if(starCount < levelGameStat.getStarCount()) {
					canDrawStar2 = true;
				} else {
					canDrawDiamond = true;
				}
				
			}
		}
	}
	
	public void updateStar2() {
		if(canDrawStar2) {
			if(starRect2.right > (starRect2.left + 70)) {
				starRect2.right = starRect2.right - 50;
				starRect2.bottom = starRect2.bottom - 50;
			} else {
				starCount=2;
				if(starCount < levelGameStat.getStarCount()) {
					canDrawStar3 = true;
				} else {
					canDrawDiamond = true;
				}
			}
		}
	}
	
	public void updateStar3() {
		if(canDrawStar3) {
			if(starRect3.right > (starRect3.left + 70)) {
				starRect3.right = starRect3.right - 50;
				starRect3.bottom = starRect3.bottom - 50;
			} else {
				starCount=3;
				if(starCount < levelGameStat.getStarCount()) {
					canDrawStar4 = true;
				} else {
					canDrawDiamond = true;
				}
			}
		}
	}
	
	public void updateStar4() {
		if(canDrawStar4) {
			if(starRect4.right > (starRect4.left + 70)) {
				starRect4.right = starRect4.right - 50;
				starRect4.bottom = starRect4.bottom - 50;
			} else {
				starCount=4;
				if(starCount < levelGameStat.getStarCount()) {
					canDrawStar5 = true;
				} else {
					canDrawDiamond = true;
				}
			}
		}
	}
	
	public void updateStar5() {
		if(canDrawStar5) {
			if(starRect5.right > (starRect5.left + 70)) {
				starRect5.right = starRect5.right - 50;
				starRect5.bottom = starRect5.bottom - 50;
			} else {
				canDrawDiamond = true;
			}
		}
	}
	
	public void updateDiamond() {
		if(canDrawDiamond) {
			if(diamondRect.right > (diamondRect.left + 70)) {
				diamondRect.right = diamondRect.right - 50;
				diamondRect.bottom = diamondRect.bottom - 50;
			} else {
				canDrawScoreText = true;
				//canDrawDoubleDiamond = true;
			}
		}
	}
	
	public void updateDoubleDiamond() {
		/*if(canDrawDiamond) {
			if(doubleDiamondRect.right > (doubleDiamondRect.left + 70)) {
				doubleDiamondRect.right = doubleDiamondRect.right - 50;
				doubleDiamondRect.bottom = doubleDiamondRect.bottom - 50;
			} else {
				canDrawScoreText = true;
			}
		}*/
	}
	
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(backGroundImage, null, panelRect, null);	
		
		if (canDrawScore) {
			
			float textLength = scoreTextPaint.measureText(("Score : " +String.valueOf(levelGameStat.getScore() +" / "+String.valueOf(gamePanel.getOngoingLevel().getMaxlevelPoint()))));
			
			canvas.drawText("Score : " +String.valueOf(levelGameStat.getScore() +" / "+String.valueOf(gamePanel.getOngoingLevel().getMaxlevelPoint())), ((panelRect.left + panelRect.right)/2 - textLength/2), panelRect.top + 100, scoreTextPaint);
			updateScore();
		}
		
		if(canDrawStar1) {
			canvas.drawBitmap(starImage, null, starRect, null);
			updateStar1();
		}
		
		if(canDrawStar2) {
			canvas.drawBitmap(starImage, null, starRect2, null);
			updateStar2();
		}
		if(canDrawStar3) {
			canvas.drawBitmap(starImage, null, starRect3, null);
			updateStar3();
		}
		if(canDrawStar4) {
			canvas.drawBitmap(starImage, null, starRect4, null);
			updateStar4();
		}
		if(canDrawStar5) {
			canvas.drawBitmap(starImage, null, starRect5, null);
			updateStar5();
				
			
		}
		if(canDrawDiamond) {
			canvas.drawBitmap(diamondImage, null, diamondRect, null);
			updateDiamond();
		}
		
		/*if(canDrawDoubleDiamond) {
			canvas.drawBitmap(doubleDiamondImage, null, doubleDiamondRect, null);
			updateDoubleDiamond();
		}*/
		
		if (canDrawScoreText) {
			
		//	canvas.drawText(levelGameStat.getStarCount()+" stars", starRect.left + 100, starRect.top + 30, scoreDetailsTextPaint);
			canvas.drawText(levelGameStat.getDiamondCount()+" diamonds", diamondRect.left + 100, diamondRect.top + 30, scoreDetailsTextPaint);
		//	canvas.drawText(levelGameStat.getDoubleDiamondCount()+" double diamonds", doubleDiamondRect.left + 100, doubleDiamondRect.top + 30, scoreDetailsTextPaint);
			
			canvas.drawBitmap(menubackImage, null, menuRect, null);
			canvas.drawBitmap(continueBackImage, null, continueRect, null);
			canvas.drawBitmap(replayBackImage, null, replayRect, null);
			
			
		}
		if(canDrawStar4) {
			
			if(levelGameStat.getStarCount() >=4) {
				butterfly1.draw(canvas);
				butterfly2.draw(canvas);
				butterfly3.draw(canvas);
				butterfly4.draw(canvas);
				butterfly5.draw(canvas);
				butterfly6.draw(canvas);
				butterfly7.draw(canvas);
				butterfly8.draw(canvas);
				butterfly9.draw(canvas);
				butterfly10.draw(canvas);
				butterfly11.draw(canvas);
				butterfly12.draw(canvas);
			}
		}
		if(butterfly1.isDrawn() &&
				butterfly2.isDrawn() &&
				butterfly3.isDrawn() &&
				butterfly4.isDrawn() &&
				butterfly5.isDrawn() &&
				butterfly6.isDrawn() &&
				butterfly7.isDrawn() &&
				butterfly8.isDrawn() &&
				butterfly9.isDrawn() &&
				butterfly10.isDrawn() &&
				butterfly11.isDrawn() &&
				butterfly12.isDrawn() &&
				levelGameStat.getStarCount()==5) {
		this.fs.setSpeedY(2);
		this.fs.updateYForFlowers();
		
		if(this.fs.getY() < panelRect.bottom - 100) {
			this.fs.draw(canvas);
		}
	}
		
	}
	
	
	public void handleActionDown(int eventX, int eventY) {
		
		if(menuRect!=null) {
			if (eventX >= menuRect.left && (eventX <= menuRect.right)) {
				   if (eventY >= (menuRect.top) && (eventY <= (menuRect.bottom ))) {
					  
					   
					   
					   int nextIndex = this.gamePanel.getCurrentLevelPanel().getLevelList().indexOf(this.gamePanel.getCurrentLevel()) + 1;
					   ArrayList<LevelPanel> levelPanelList = this.gamePanel.getCurrentMainLevel().getAssociatedLevelListPanel().getLevelList();
					   
					   if(null!=levelPanelList.get(nextIndex)) {
						   System.out.println("inside "+levelPanelList.get(nextIndex).getAssociatedLevel().getLevelType());
						   this.gamePanel.setOngoingLevel(levelPanelList.get(nextIndex).getAssociatedLevel());
					   }
					   
					   System.out.println("inside outside");
					   this.gamePanel.setLevelPanel(true);
					   this.gamePanel.setSubLevelSelected(false);
					   this.gamePanel.setHomePanel(false);
					   
					   System.out.println("Saving game data");
					   GameData gameData = MainActivity.prepareGameData();
					   GameDataHelper.saveGameData(gameData, MainActivity.applicationContext);
						
					   System.out.println("Saving game data saved");
						
					   MainActivity.restoredGameData = GameDataHelper.restoreGameData(MainActivity.applicationContext);
					   MainActivity.gamePanel.restoreGameData();
					   System.out.println("Saving game data restored");
					   
					   
					   BackButton.clicked = true;
					   
					   JumpAndBalanceGamePanel.isRestored = true;
					   
					   
				   } else {
					  
				   }
				   
			} else {
			
			}
		}
		
		if(continueRect!=null) {
			if (eventX >= continueRect.left && (eventX <= continueRect.right)) {
				   if (eventY >= (continueRect.top) && (eventY <= (continueRect.bottom ))) {
					  
					   this.gamePanel.setLevelPanel(true);
					   this.gamePanel.setSubLevelSelected(false);
					   this.gamePanel.setHomePanel(false);
					   
					   int nextIndex = this.gamePanel.getOngoingLevel().getIndex()+1;
					   ArrayList<LevelPanel> levelPanelList = this.gamePanel.getCurrentMainLevel().getAssociatedLevelListPanel().getLevelList();
					   
					   if(levelPanelList.get(nextIndex)!=null) {
						   this.gamePanel.setOngoingLevel(levelPanelList.get(nextIndex).getAssociatedLevel());
					   }
					
					   BackButton.clicked = false;
					   JumpAndBalanceGamePanel.isRestored = true;
					  
					   
				   } else {
					  
				   }
				   
			} else {
			
			}
		}
		
		if(replayRect!=null) {
			if (eventX >= replayRect.left && (eventX <= replayRect.right)) {
				   if (eventY >= (replayRect.top) && (eventY <= (replayRect.bottom ))) {
					  
					   BackButton.clicked = false;
					   
					   this.gamePanel.getOngoingLevel().setDefaultToReplayMode();
					   this.gamePanel.getOngoingLevel().setCanInitialiseForReplay(true);
					   this.gamePanel.getOngoingLevel().initialiseForReplay();
					   this.gamePanel.getOngoingLevel().setGameOver(false);
					   this.gamePanel.getOngoingLevel().setOngoing(false);
					   
					   for(LevelDiamond diamond : this.gamePanel.getOngoingLevel().getDiamondsInLevel()) {
						   diamond.setAlreadyAttained(false);
					   }
					   
					   
					   JumpAndBalanceGamePanel.isRestored = true;
						  
				   } else {
					  
				   }
				   
			} else {
			
			}
		}
		
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

	/**
	 * @return the backGroundImage
	 */
	public Bitmap getBackGroundImage() {
		return backGroundImage;
	}

	/**
	 * @param backGroundImage the backGroundImage to set
	 */
	public void setBackGroundImage(Bitmap backGroundImage) {
		this.backGroundImage = backGroundImage;
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

	public RectF getPanelRect() {
		return panelRect;
	}

	public void setPanelRect(RectF panelRect) {
		this.panelRect = panelRect;
	}

	
}
