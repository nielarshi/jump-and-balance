/**
 * 
 */
package com.jumpandbalance.actors;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.helper.GameStatsHelper;
import com.jumpandbalance.helper.Speed;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.util.GameUtil;

/**
 * @author TCS
 *
 */
public class Ball {

	private Bitmap bitmapImage;
	private int x;
	private int y;
	private Speed speed, speed2;
	private double theta;
	private Level level;
	private float currentTimeInAir=0;
	private boolean revert = false;
	private boolean viewUpdateFlag=false;
	private Pillar nextPillar;
	private Matrix matrix;
	private int centerX;
	private boolean badAttempt=false;
	private int noOfAttempts;
	private ArrayList<Pillar> levelPillars;
	private int scoreForDiamond;
	private int countForDiamond;
	
	private static final int BMP_ROWS = 1;
	private static final int BMP_COLUMN = 4;
	private int width, height;
	private int count;
	private int currentFrame;
	private boolean isForward;
	private boolean isMoving;
	private int deg;
	private int xCount;
	
	public Ball(Bitmap bitmapImage, int x, int y) {
		this.bitmapImage = bitmapImage;
		this.x = x;
		this.y = y;
		speed = new Speed();
		
		speed2 = new Speed();
		matrix = new Matrix();
		centerX=this.x;

		this.width = this.bitmapImage.getWidth() / BMP_COLUMN;
		this.height = this.bitmapImage.getHeight() / BMP_ROWS;
		
		System.out.println("width : "+this.bitmapImage.getWidth() + " "+this.width);
		
		deg = 1;
	}
	
	
	
	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}



	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}



	/**
	 * @return the nextPillar
	 */
	public Pillar getNextPillar() {
		return nextPillar;
	}

	/**
	 * @param nextPillar the nextPillar to set
	 */
	public void setNextPillar(Pillar nextPillar) {
		this.nextPillar = nextPillar;
	}

	/**
	 * @return the centerX
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @param centerX the centerX to set
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	/**
	 * @return the badAttempt
	 */
	public boolean isBadAttempt() {
		return badAttempt;
	}

	/**
	 * @param badAttempt the badAttempt to set
	 */
	public void setBadAttempt(boolean badAttempt) {
		this.badAttempt = badAttempt;
	}

	/**
	 * @return the noOfAttempts
	 */
	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	/**
	 * @param noOfAttempts the noOfAttempts to set
	 */
	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	/**
	 * @return the bitmapImage
	 */
	public Bitmap getBitmapImage() {
		return bitmapImage;
	}
	/**
	 * @param bitmapImage the bitmapImage to set
	 */
	public void setBitmapImage(Bitmap bitmapImage) {
		this.bitmapImage = bitmapImage;
		
		this.width = this.bitmapImage.getWidth() / BMP_COLUMN;
		this.height = this.bitmapImage.getHeight() / BMP_ROWS;
		
		System.out.println("width : "+this.bitmapImage.getWidth() + " "+this.width);
	
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
	 * @return the speed
	 */
	public Speed getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

	

	/**
	 * @return the theta
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * @param theta the theta to set
	 */
	public void setTheta(double theta) {
		this.theta = theta;
	}

	
	
	/**
	 * @return the currentTimeInAir
	 */
	public float getCurrentTimeInAir() {
		return currentTimeInAir;
	}

	
	/**
	 * @return the revert
	 */
	public boolean isRevert() {
		return revert;
	}

	/**
	 * @param revert the revert to set
	 */
	public void setRevert(boolean revert) {
		this.revert = revert;
	}

	/**
	 * @return the viewUpdateFlag
	 */
	public boolean isViewUpdateFlag() {
		return viewUpdateFlag;
	}

	/**
	 * @param viewUpdateFlag the viewUpdateFlag to set
	 */
	public void setViewUpdateFlag(boolean viewUpdateFlag) {
		this.viewUpdateFlag = viewUpdateFlag;
	}

	/**
	 * @param currentTimeInAir the currentTimeInAir to set
	 */
	public void setCurrentTimeInAir(float currentTimeInAir) {
		this.currentTimeInAir = currentTimeInAir;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}



	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}



	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}



	public void draw(Canvas canvas) {
		
		int srcX = currentFrame * width;
		int srcY = 0 * height;
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dest = new Rect(x, y+5, x + width, y + height+5);
		
		
		if(isMoving) {
			updateObjectFrameWhenMoving();
			deg += 1;
		//	canvas.rotate(deg, x+(width/2), y+(height/2));
			canvas.drawBitmap(bitmapImage, src, dest, null);
		//	canvas.restore();
		} else {
			updateObjectFrame();
			canvas.drawBitmap(bitmapImage, src, dest, null);
		}
		
	//	canvas.drawBitmap(bitmapImage, x,y+5 , null);
		
	/*	Paint paint = new Paint(); 
		paint.setStrokeWidth(2.0f);
		paint.setColor(Color.DKGRAY);
		canvas.drawLine(centerX,0,centerX, y, paint);*/
		
	//	canvas.drawBitmap(bitmapImage, x - (bitmapImage.getWidth() / 2), y - (bitmapImage.getHeight() / 2), null);
	}
	public void updateObjectFrameWhenMoving() {
		currentFrame = 3;
	}	

	public void updateObjectFrame() {
		
		count++;
		
		if(count>6) {
			
			if(!isForward) {
				currentFrame = ++currentFrame % BMP_COLUMN;
			} else {
				currentFrame = --currentFrame % BMP_COLUMN;
			}
			
			count = 0;
			
			if(currentFrame == 3) {
				isForward = true;
				count = -20;
			} else if(currentFrame == 0) {
				isForward = false;
			}
			
		}
			
		
	}
	public void update() {
		System.out.println("view update flag"+viewUpdateFlag);
		if(!this.viewUpdateFlag){
			updateBallPosition();
		}else{
			if(this.level.isCanUpdatePillars()) {
				updatePillars();
			}
			
		}
	}

	/**
	 * 
	 */
	private void updateBallPosition() {
		if(!revert){	
			this.levelPillars = this.level.getPillars();
			updateBallPositionOnPillarTouch();
		} else{
			
		//	updateReverse();
			updateNewBallOnPillar();
			
//			
			if((y+this.getHeight())>=this.level.getSrcPillar().getY()){
				this.level.getGameStat().setCurrentMoveScore("-1");
				if(!badAttempt){
					badAttempt=true;
					if(this.level.getGameStat().getScore()!=0){
			//			this.gamePanel.getGameStat().setScore(this.gamePanel.getGameStat().getScore()-1);
					}
				}
				
				System.out.println("updating");
				giveOriginalPropertiesToBall();
				setBallToParent();
				setNewPositionForBall();
				BallPath ballPath = new BallPath();
				ballPath.setBall(this);
				this.level.setBallPath(ballPath);
				this.level.getSrcPillar().setTouchOver(false);
			
				System.out.println("ball is moved to original position");

			}
		}
	}

	/**
	 * 
	 */
	private void updateBallPositionOnPillarTouch() {
		
		for(Pillar pillar : levelPillars) {
			if(!pillar.equals(this.getLevel().getSrcPillar())) { 
				if(y + this.getHeight() > pillar.getY()) {
				
					if(x + this.getWidth() > (pillar.getX()-pillar.getBitmapImage().getWidth()/2) &&
							x + this.getWidth() < (pillar.getX())) {
				
							speed.setxVelocity(speed.getxVelocity()*-1);
					} else if(x + this.getWidth() > (pillar.getX()+pillar.getBitmapImage().getWidth()/2 - 10) &&
							x  + this.getWidth() < (pillar.getX()+pillar.getBitmapImage().getWidth()/2)) {
							
							speed.setyVelocity(speed.getyVelocity()*-1);
					}
				} 
			}
		}
		
		
		updateXYonForwardMovement();

		
		
		if(this.level.getGamepanel().getHeight()<y) {
			revert=true;
			
		//	updateReverse();
			x=(this.level.getSrcPillar().getX()-(this.level.getBall().getWidth()/2));
			y=0;
			
			noOfAttempts++;
			xCount = 0;

			this.level.setPillarFailed(true);
		
			this.level.getPreviousGameStat().setScore(this.level.getLevelGameStat().getScore());
			this.level.getPreviousGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount());
			this.level.getPreviousGameStat().setDoubleDiamondCount(this.level.getLevelGameStat().getDoubleDiamondCount());
			this.level.getPreviousGameStat().setStarCount(this.level.getLevelGameStat().getStarCount());
			
			int previousScore = this.level.getLevelGameStat().getScore();
			int newScore = 1 *GameStatsHelper.DEFAULT_DEDUCTION_ON_EACH_FAILED_ATTEMPT;
			
			if(this.level.getLevelType().equals(Constants.SUB_LEVEL_ONE_NAME)) {
				if(previousScore - newScore > 0) {
					this.level.getLevelGameStat().setScore(previousScore - newScore);
				}
			} else {
				this.level.getLevelGameStat().setScore(previousScore - newScore);
			}
			
			
			this.level.updateLevelGameStat();
			
			updateNewBallOnPillar();
			
			System.out.println("Reverting");
			
			
		}
		
		
//		for(LevelDiamond diamond : this.level.getDiamondsInLevel()) {
//			if(!diamond.isAlreadyAttained()) {
//				if(y + this.getHeight() >= diamond.getY() &&
//					y + this.getHeight() <= diamond.getY() + diamond.getHeight() &&
//					x + this.getWidth() >= diamond.getX() &&
//					x + this.getWidth() <= diamond.getX() + diamond.getWidth()) {
//					diamond.setHasBallTouched(true);
//					this.level.getLevelGameStatPortion().getLevelDiamond().setAddingNewDiamond(true);
//
//					this.level.getLevelGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount()+1);
//				
//				}
//			}	
//		}
		
		
		if(!this.level.getLevelBall().isAlreadyAttained()) {
			if(y >= this.level.getLevelBall().getY() &&
				y <= this.level.getLevelBall().getY() + this.level.getLevelBall().getHeight() &&
				x >= this.level.getLevelBall().getX() &&
				x <= this.level.getLevelBall().getX() + this.level.getLevelBall().getWidth()) {
				
				System.out.println("attained touched");
				this.level.getLevelBall().setHasBallTouched(true);
				this.bitmapImage = this.level.getLevelBall().getBitmapImage();
			}
		}
		nextPillar=this.level.getPillars().get(this.level.getSrcPillar().getIndex()+1);
		
		if((y > (nextPillar.getY()-this.getHeight())-10) &&
				(y < (nextPillar.getY()-this.getHeight()) + 10) &&
				(x > nextPillar.getX() - nextPillar.getBitmapImage().getWidth()/2 -(this.getWidth()/2)) && 
				(x < nextPillar.getX() - nextPillar.getBitmapImage().getWidth()/2 +30)) {
			System.out.println("Fell on next pillar"+noOfAttempts);
			
			if((xCount / 10) - noOfAttempts > 3)
			{
				this.level.getLevelGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount() + (xCount / 20) - noOfAttempts);	
				
			} else {
				this.level.getLevelGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount() + 1);	
				
			}
			xCount = 0;
			
			this.level.setNoOfPillarsCrossed(this.level.getNoOfPillarsCrossed()+1);
			
			if ((nextPillar.getIndex()+1)==this.level.getNoOfPillars()) {
				int levelIndex = this.level.getGamepanel().getOngoingLevel().getIndex();
				
				if(levelIndex < this.level.getGamepanel().getCurrentLevelPanel().getLevelList().size()) {
					this.level.getGamepanel().getCurrentLevelPanel().getLevelList().get(levelIndex+1).setLocked(false);
				}
				this.level.getGameStat().setCurrentMoveScore("+1");
				this.level.getGameStat().setScore(this.level.getGameStat().getScore()+GameUtil.getScore(noOfAttempts));
		
				this.level.setSrcPillar(nextPillar);
				
				this.level.getSrcPillar().setBall(this);
				
				giveOriginalPropertiesToBall();
				setNewPositionForBall();
				
		//		this.level.getGamepanel().setLevelPanel(true);
		//		this.level.getGamepanel().setSubLevelSelected(false);
		//		this.level.getGamepanel().setHomePanel(false);
				
			} else {
				this.level.setSrcPillar(nextPillar);
				
				this.level.setDestPillar(this.level.getPillars().get(this.level.getSrcPillar().getIndex()+1));
				this.level.getSrcPillar().setBall(this);
				this.level.getGameStat().setCurrentMoveScore("+1");
			//	this.gamePanel.getGameStat().setScore(this.gamePanel.getGameStat().getScore()+1);
				this.level.getGameStat().setScore(this.level.getGameStat().getScore()+GameUtil.getScore(noOfAttempts));
				giveOriginalPropertiesToBall();
			//	this.level.getGameStat().setPillarCrossed(this.level.getGameStat().getPillarCrossed()+1);
				setNewPositionForBall();
				
				
				this.level.getSrcPillar().setTouchOver(false);
				HelpButton.finished = false;
				System.out.println("ball is moved to new position");
				this.viewUpdateFlag=true;
			}
			
			this.level.getPreviousGameStat().setScore(this.level.getLevelGameStat().getScore());
			this.level.getPreviousGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount());
			this.level.getPreviousGameStat().setDoubleDiamondCount(this.level.getLevelGameStat().getDoubleDiamondCount());
			this.level.getPreviousGameStat().setStarCount(this.level.getLevelGameStat().getStarCount());
			
			int previousScore = this.level.getLevelGameStat().getScore();
			int newScore = GameStatsHelper.getScore(this.level.getScoreForCrossingEachPillar(), 0);
			
			System.out.println("score "+previousScore+" : "+newScore+" --> "+this.level.getGamepanel().getCurrentMainLevel().getScoreorDiamond());
			
			
			this.level.getLevelGameStat().setScore(previousScore + newScore);
			
			int diamondCount = this.level.getLevelGameStat().getScore()/GameStatsHelper.MIN_LEVEL_SCORE_REQUIRED_FOR_DIAMOND;
		//	this.level.getLevelGameStat().setDiamondCount(diamondCount);
			
			int mainleveldiamondCount = this.level.getGamepanel().getCurrentMainLevel().getLevelGameStat().getScore()/GameStatsHelper.MIN_LEVEL_SCORE_REQUIRED_FOR_DIAMOND;
			this.level.getGamepanel().getCurrentMainLevel().getLevelGameStat().setDiamondCount(mainleveldiamondCount);
			
			int starCount = GameStatsHelper.getLevelStarCount(this.level.getMaxlevelPoint(), this.level.getLevelGameStat().getScore());
			this.level.getLevelGameStat().setStarCount(starCount);
			
			
			this.level.getGamepanel().getCurrentMainLevel().setScoreorDiamond(this.level.getGamepanel().getCurrentMainLevel().getScoreorDiamond() + newScore);
			
			
			
//			if(this.level.getGamepanel().getCurrentMainLevel().getScoreorDiamond()>=1000) {
//				this.level.getLevelGameStatPortion().getLevelDiamond().setAddingNewDiamond(true);
//				
//				this.level.getGamepanel().getCurrentMainLevel().setCountForDiamond(this.level.getGamepanel().getCurrentMainLevel().getCountForDiamond()+1);
//				this.level.getGamepanel().getCurrentMainLevel().setScoreorDiamond(this.level.getGamepanel().getCurrentMainLevel().getLevelGameStat().getScore() - (this.level.getGamepanel().getCurrentMainLevel().getScoreorDiamond()*this.level.getGamepanel().getCurrentMainLevel().getCountForDiamond()));
//				this.level.getLevelGameStat().setDiamondCount(this.level.getLevelGameStat().getDiamondCount()+1);
//				
//			}
			

			this.level.updateLevelGameStat();
			this.level.setPillarCrossed(true);
			
			this.level.getGamepanel().getCurrentMainLevel().updateLevelInfoGameStat();
			
			
			this.level.setCanUpdatePillars(false);
			
			
			
			
			badAttempt=false;
			noOfAttempts=0;
			
		} else {
			
		}
	}

	/**
	 * 
	 */
	private void updateXYonForwardMovement() {
		isMoving = true;
		speed.setyVelocity((float)(speed.getyVelocity()+( 0.5 * currentTimeInAir)));        // Apply gravity to vertical velocity
		x += speed.getxVelocity() * currentTimeInAir;      // Apply horizontal velocity to X position
		y += speed.getyVelocity() * currentTimeInAir;      // Apply vertical velocity to X position
		currentTimeInAir+=0.02;
		
		xCount++;
	}

	/**
	 * 
	 */
	private void setBallToParent() {
		this.level.getSrcPillar().setBall(this);
		this.level.setBall(this);
	}

	/**
	 * 
	 */
	public void setNewPositionForBall() {
		x=(this.level.getSrcPillar().getX()-(this.level.getBall().getWidth()/2));
		y=(this.level.getSrcPillar().getY()-this.level.getBall().getHeight());
	}

	/**
	 * 
	 */
	private void giveOriginalPropertiesToBall() {
		speed = new Speed();
		speed2 = new Speed();
		revert=false;
		currentTimeInAir=0;
		isMoving = false;
		
		this.level.getSrcPillar().setTouched(false);
	}

	private void updateReverse() {
		 currentTimeInAir-=0.02;
		 x -= speed.getxVelocity() * currentTimeInAir;      // Apply horizontal velocity to X position
		 y -= speed.getyVelocity() * currentTimeInAir;      // Apply vertical velocity to X position
		speed.setyVelocity((float)(speed.getyVelocity()-( 0.5 * currentTimeInAir)));        // Apply gravity to vertical velocity
	}
	
	private void updateNewBallOnPillar() {
		 
		
		 y += 10;      // Apply vertical velocity to X position
		         // Apply gravity to vertical velocity
		currentFrame = 1;
		isMoving = false;
		
	}
	
	private void updatePillars() {
		if(((this.level.getGamepanel().getWidth()/4 - 100) < this.level.getSrcPillar().getX())){
//			this.setX(this.getX()-10);
//			for(Pillar pillarTemp : this.level.getPillars()){
//				pillarTemp.setX(pillarTemp.getX()-10);
//			}
//			
//			for(Object pillarTempObj : this.level.getPillars().toArray()) {
//				((Pillar)pillarTempObj).setX(((Pillar)pillarTempObj).getX()-10);	
//			}
			BallPath ballPath = new BallPath();
			ballPath.setBall(this);
			this.level.setBallPath(ballPath);
			
			/*
			Pillar newPillar= new Pillar(this.level.getPillarBitmap());
			newPillar.setIndex(this.level.getPillars().size());
			int xCor = this.level.getPillarBitmap().getWidth();
			xCor=this.level.getPillars().get(this.level.getPillars().size()-1).getX()+GameUtil.randInt((this.level.getPillarBitmap().getWidth()*4), +(this.level.getPillarBitmap().getWidth()*5));
			int yCor = this.level.getGamepanel().getHeight() - (this.level.getPillarBitmap().getHeight()*3/2) + GameUtil.randInt((this.level.getPillarBitmap().getHeight()/2), (this.level.getPillarBitmap().getHeight()));
			newPillar.setX(xCor);
			newPillar.setY(yCor);
			this.level.getPillars().add(newPillar);*/
			
		}
		else{
			viewUpdateFlag=false;
			
		}
		
	}



	/**
	 * @return the matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}



	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}



	/**
	 * @return the levelPillars
	 */
	public ArrayList<Pillar> getLevelPillars() {
		return levelPillars;
	}



	/**
	 * @param levelPillars the levelPillars to set
	 */
	public void setLevelPillars(ArrayList<Pillar> levelPillars) {
		this.levelPillars = levelPillars;
	}
	
	
}
