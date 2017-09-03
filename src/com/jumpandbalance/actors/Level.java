/**
 * 
 */
package com.jumpandbalance.actors;

import java.util.ArrayList;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.jumpandbalance.R;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.interfaces.Theme;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.stat.LevelGameStat;
import com.jumpandbalance.util.FontUtil;
import com.jumpandbalance.util.GameUtil;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.ThemePanel;

/**
 * @author Priya
 *
 */
public class Level {
	
	public static final String LEVEL_ONE = "";

		private String levelName;
		private String levelType;
		private Theme theme;
		private Background background;
		private Pillar srcPillar = null;
		private Pillar destPillar = null;
		private ArrayList<Pillar> pillars = null;
		private Ball ball = null;
		private GameStats gameStat;
		private Context context;
		private Bitmap pillarBitmap,ballBitmap,backgroundImageBitmap;
		private Paint newPaint, paint;  
		private Background bg1,bg2,bg3,bg4, bg5, bg6, bg7, bg8, bg9, bg10, bg11, bg12;
		
		private Bitmap undergroudPlantBitmap;
		private Bitmap underwaterFish1Bitmap, underwaterFish2Bitmap, underwaterFish3Bitmap, underwaterFish4Bitmap, underwaterFish5Bitmap, underwaterStarFish1Bitmap, underwaterShell1Bitmap, underwaterBubble1Bitmap;
		
		private int currentFrame;
		private int currentFish1Frame;
		private int fish1X, fish1Y, fish1XWhileReversing;
		private boolean isFish1MovingFront, isFish1MovingBack , isFish1Reversing, isFish1ReversingBack;
		
		private int currentFish2Frame;
		private int fish2X, fish2Y, fish2XWhileReversing;
		private boolean isFish2MovingFront, isFish2MovingBack , isFish2Reversing, isFish2ReversingBack;
		
		private int currentFish3Frame;
		private int fish3X, fish3Y, fish3XWhileReversing;
		private boolean isFish3MovingFront, isFish3MovingBack , isFish3Reversing, isFish3ReversingBack;
		
		private int currentFish4Frame;
		private int fish4X, fish4Y, fish4XWhileReversing;
		private boolean isFish4MovingFront, isFish4MovingBack , isFish4Reversing, isFish4ReversingBack;
		
		private int currentFish5Frame;
		private int fish5X, fish5Y, fish5XWhileReversing;
		private boolean isFish5MovingFront, isFish5MovingBack , isFish5Reversing, isFish5ReversingBack;
		
		
		private int currentStarFish1Frame;
		private int currentShell1Frame;
		private int currentBubble1Frame;
		
		private int rainCount, plantMoveFrameCount, fish1MoveFrameCount, fish2MoveFrameCount, fish3MoveFrameCount, fish4MoveFrameCount, fish5MoveFrameCount, starFish1MoveFrameCount, shell1MoveFrameCount, bubble1MoveFrameCount;

		private Bitmap bird1, bird2;
		private int bird1X, bird1Y , bird2X, bird2Y;
		private int currentBird1Frame, currentBird2Frame;
		private int bird1MoveFrameCount, bird2MoveFrameCount;
		
		private BallPath ballPath;
		private JumpAndBalanceGamePanel gamepanel;
		private int index;
		private ThemePanel themePanel;
		private GameOverConfirmation gameOverConfirmationPanel;
		private boolean gameOver;
		int xCor, yCor;
		private LevelClearedInfo levelClearedInfo;
		private int radius = 0;
		private PillarIndicatingCircle indicatingCircle;
		private PillarIndicatingArrow indicatingArrow;
		private IndicationInfoBox infoBox;
		private Pillar pillarLeft = null;
		private int noOfPillars;
		private int noOfPillarsCrossed;
		private int scoreForCrossingEachPillar;
		private int maxlevelPoint;
		
		
		private LevelGameStat levelGameStat;
		
		private LevelGameStat previousGameStat;
		
		private SubLevelGameStatPortion levelGameStatPortion;
		
		IncreasingCount increasingCount;
		
		public boolean pillarCrossed;
		public boolean pillarFailed;
		
		private int helpFrameY;
		
		private boolean canUpdatePillars;
		
		private int initialX;
		
		private boolean canInitialiseForReplay;
		
		private boolean isRainingTheme;
		private boolean isRaining;
		
		private boolean isStillTheme;
		
		private boolean isOngoing;

		private boolean initialisingLevel;
		private float initialisingLevelScaleCount = 0.6f;
		
		private ArrayList<LevelDiamond> diamondsInLevel;
		
		private LevelBall levelBall;
		
		
		/**
		 * @return the levelBall
		 */
		public LevelBall getLevelBall() {
			return levelBall;
		}


		/**
		 * @param levelBall the levelBall to set
		 */
		public void setLevelBall(LevelBall levelBall) {
			this.levelBall = levelBall;
		}


		/**
		 * @return the isOngoing
		 */
		public boolean isOngoing() {
			return isOngoing;
		}


		/**
		 * @param isOngoing the isOngoing to set
		 */
		public void setOngoing(boolean isOngoing) {
			this.isOngoing = isOngoing;
		}


		/**
		 * @return the isStillTheme
		 */
		public boolean isStillTheme() {
			return isStillTheme;
		}


		/**
		 * @param isStillTheme the isStillTheme to set
		 */
		public void setStillTheme(boolean isStillTheme) {
			this.isStillTheme = isStillTheme;
		}


		/**
		 * @return the noOfPillarsCrossed
		 */
		public int getNoOfPillarsCrossed() {
			return noOfPillarsCrossed;
		}


		/**
		 * @param noOfPillarsCrossed the noOfPillarsCrossed to set
		 */
		public void setNoOfPillarsCrossed(int noOfPillarsCrossed) {
			this.noOfPillarsCrossed = noOfPillarsCrossed;
		}


		/**
		 * @return the isRaining
		 */
		public boolean isRaining() {
			return isRaining;
		}


		/**
		 * @param isRaining the isRaining to set
		 */
		public void setRaining(boolean isRaining) {
			this.isRaining = isRaining;
		}


		/**
		 * @return the pillarFailed
		 */
		public boolean isPillarFailed() {
			return pillarFailed;
		}


		/**
		 * @param pillarFailed the pillarFailed to set
		 */
		public void setPillarFailed(boolean pillarFailed) {
			this.pillarFailed = pillarFailed;
		}


		/**
		 * @return the levelGameStatPortion
		 */
		public SubLevelGameStatPortion getLevelGameStatPortion() {
			return levelGameStatPortion;
		}


		/**
		 * @param levelGameStatPortion the levelGameStatPortion to set
		 */
		public void setLevelGameStatPortion(SubLevelGameStatPortion levelGameStatPortion) {
			this.levelGameStatPortion = levelGameStatPortion;
		}


		/**
		 * @return the gameOverConfirmationPanel
		 */
		public GameOverConfirmation getGameOverConfirmationPanel() {
			return gameOverConfirmationPanel;
		}


		/**
		 * @param gameOverConfirmationPanel the gameOverConfirmationPanel to set
		 */
		public void setGameOverConfirmationPanel(
				GameOverConfirmation gameOverConfirmationPanel) {
			this.gameOverConfirmationPanel = gameOverConfirmationPanel;
		}


		/**
		 * @return the gameOver
		 */
		public boolean isGameOver() {
			return gameOver;
		}


		/**
		 * @param gameOver the gameOver to set
		 */
		public void setGameOver(boolean gameOver) {
			this.gameOver = gameOver;
		}


		/**
		 * @return the canUpdatePillars
		 */
		public boolean isCanUpdatePillars() {
			return canUpdatePillars;
		}


		/**
		 * @param canUpdatePillars the canUpdatePillars to set
		 */
		public void setCanUpdatePillars(boolean canUpdatePillars) {
			this.canUpdatePillars = canUpdatePillars;
		}


		/**
		 * @return the pillarCrossed
		 */
		public boolean isPillarCrossed() {
			return pillarCrossed;
		}


		/**
		 * @param pillarCrossed the pillarCrossed to set
		 */
		public void setPillarCrossed(boolean pillarCrossed) {
			this.pillarCrossed = pillarCrossed;
		}


		/**
		 * @return the previousGameStat
		 */
		public LevelGameStat getPreviousGameStat() {
			return previousGameStat;
		}


		/**
		 * @param previousGameStat the previousGameStat to set
		 */
		public void setPreviousGameStat(LevelGameStat previousGameStat) {
			this.previousGameStat = previousGameStat;
		}


		/**
		 * @return the scoreForCrossingEachPillar
		 */
		public int getScoreForCrossingEachPillar() {
			return scoreForCrossingEachPillar;
		}


		/**
		 * @param scoreForCrossingEachPillar the scoreForCrossingEachPillar to set
		 */
		public void setScoreForCrossingEachPillar(int scoreForCrossingEachPillar) {
			this.scoreForCrossingEachPillar = scoreForCrossingEachPillar;
		}


		/**
		 * @return the maxlevelPoint
		 */
		public int getMaxlevelPoint() {
			return maxlevelPoint;
		}


		/**
		 * @param maxlevelPoint the maxlevelPoint to set
		 */
		public void setMaxlevelPoint(int maxlevelPoint) {
			this.maxlevelPoint = maxlevelPoint;
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
		 * @return the noOfPillars
		 */
		public int getNoOfPillars() {
			return noOfPillars;
		}


		/**
		 * @param noOfPillars the noOfPillars to set
		 */
		public void setNoOfPillars(int noOfPillars) {
			this.noOfPillars = noOfPillars;
			

			initializeLevel(this.gamepanel);
			
		}


		public Level(Context context, JumpAndBalanceGamePanel gamepanel) {
			this.context = context;
			this.gamepanel = gamepanel;
			
		}


		/**
		 * @param gamepanel
		 */
		@SuppressLint("NewApi")
		private void initializeLevel(JumpAndBalanceGamePanel gamepanel) {
			
			
			
			
			newPaint = FontUtil.getFontPaint(FontUtil.AIRMOLE_STRIPE, Color.BLACK, 38);
			indicatingCircle = new PillarIndicatingCircle();
			indicatingCircle.setImage(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.hand));
			this.indicatingArrow = new PillarIndicatingArrow();
			this.indicatingArrow.setBitmapImage(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.downarrow));
			this.infoBox = new IndicationInfoBox();
			
			
			
			paint = new Paint();
			paint.setStrokeWidth(2.0f);
			paint.setAntiAlias(true);
			paint.setAlpha(100);
			paint.setColor(Color.argb(50, 0, 0, 0));
			
			scoreForCrossingEachPillar = 500;
			maxlevelPoint = scoreForCrossingEachPillar * (noOfPillars-1);
			
			levelGameStat = new LevelGameStat();
			previousGameStat = new LevelGameStat();
			levelGameStatPortion = new SubLevelGameStatPortion();
			
			RectF diamondRect = new RectF(gamepanel.getWidth() - 80, 20, gamepanel.getWidth() - 40, 60);
			levelGameStatPortion.getLevelDiamond().setDiamondRect(diamondRect);
			
			RectF scoreRect = new RectF(gamepanel.getWidth() - 350, 30, gamepanel.getWidth() - 220, 70);
			levelGameStatPortion.getLevelScore().setScoreRect(scoreRect);
			
			RectF doubleDiamondRect = new RectF(gamepanel.getWidth() - 170, 20, gamepanel.getWidth() - 130, 60);
			levelGameStatPortion.getLevelDoubleDiamond().setDoubleDiamondRect(doubleDiamondRect);
			
			increasingCount = new IncreasingCount(this.levelGameStat.getScore());
			pillars= new ArrayList<Pillar>();
			
			diamondsInLevel = new ArrayList<LevelDiamond>();
			
			levelBall = new LevelBall();
			
			
			pillarBitmap = this.theme.getPillarBitmap();
			srcPillar = new Pillar(pillarBitmap, pillarBitmap.getWidth(), this.gamepanel.getHeight() - pillarBitmap.getHeight());
			
			xCor = 120;
			yCor = gamepanel.getHeight()/2;
			
			initialX = xCor;
			
			srcPillar.setX(xCor);
			srcPillar.setY(yCor);
			
			ballBitmap = this.theme.getBallBitmap();
			ball = new Ball(ballBitmap, pillarBitmap.getWidth(), pillarBitmap.getHeight()-ballBitmap.getHeight());
			
			ball.setX(srcPillar.getX()-(this.ball.getWidth()/2));
			ball.setY(srcPillar.getY()-this.ball.getHeight());
			
			ball.setLevel(this);
			
			srcPillar.setBall(ball);
			srcPillar.setIndex(0);
			
			pillars.add(srcPillar);
			
			backgroundImageBitmap = this.theme.getBackgroundImageBitmap();
			
			bg2 = new Background(backgroundImageBitmap,1024, 0);
			bg1 = new Background(backgroundImageBitmap,0, 0);
			bg3 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.RAIN),1024, 0);
			bg4 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.RAIN),0, 0);
			/*bg5 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.RAIN_2),1024, 0);
			bg6 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.RAIN_2),0, 0);*/
			
			
			bg7 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.SNOW_1),0, 0);
			bg8 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.SNOW_2),0, 0);
			bg9 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.SNOW_1),0, -270);
			bg10 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.SNOW_2),0, -270);
			
			
			bg11 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_1),0, 0);
			bg12 = new Background(ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_2),0, 0);
			
			undergroudPlantBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_PLANT_1);
			underwaterFish1Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_FISH_1);
			underwaterFish2Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_FISH_2);
			underwaterFish3Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_FISH_3);
			underwaterFish4Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_FISH_3);
			underwaterFish5Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_FISH_4);
			
			underwaterStarFish1Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_STAR_FISH_1);
			underwaterShell1Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_SHELL_1);
			underwaterBubble1Bitmap = ImageHelper.getInstance().getImageFor(ImageHelper.UNDERWATER_BUBBLE_1);
			
			bird1 = ImageHelper.getInstance().getImageFor(ImageHelper.BIRD_1);
			bird2 = ImageHelper.getInstance().getImageFor(ImageHelper.BIRD_2);
			
			
			gameStat = new GameStats(gamepanel);
			ballPath = new BallPath();
			//bhavana
			levelClearedInfo = new LevelClearedInfo(gamepanel);
			levelClearedInfo.setBackGroundImage(ImageHelper.getInstance().getImageFor(ImageHelper.LEVEL_OVER_BG));
			
			themePanel = new ThemePanel(gamepanel);
			
			themePanel.setBgBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.PLAIN_BG_1));
			
			gameOverConfirmationPanel = new GameOverConfirmation(gamepanel);
			gameOverConfirmationPanel.setBackGroundImage(ImageHelper.getInstance().getImageFor(ImageHelper.PLAIN_BG_1));
			gameOverConfirmationPanel.setLevelGameStat(levelGameStat);
			
			BackButton.setHomepanel(this.gamepanel.getHomePanel());
			HomeButton.setHomepanel(this.gamepanel.getHomePanel());
			
			MusicButton.setHomepanel(this.gamepanel.getHomePanel());
			MusicButton.setMusicImage(ImageHelper.getInstance().getImageFor(ImageHelper.MUSIC_ICON_IMAGE));
			
			ReloadButton.setHomepanel(this.gamepanel.getHomePanel());
			
			
			helpFrameY = -1*gamepanel.getHeight();
			
			if(Constants.LEVEL_ONE_NAME.equals(this.levelName)) {
				if(Constants.SUB_LEVEL_ONE_NAME.equals(this.levelType)) {
					initializeLevel1_1();
				} else if(Constants.SUB_LEVEL_TWO_NAME.equals(this.levelType)) {
					initializeLevel1_2();
				} else if(Constants.SUB_LEVEL_THREE_NAME.equals(this.levelType)) {
					initializeLevel1_3();
				} else if(Constants.SUB_LEVEL_FOUR_NAME.equals(this.levelType)) {
					initializeLevel1_4();
				} else if(Constants.SUB_LEVEL_FIVE_NAME.equals(this.levelType)) {
					initializeLevel1_5();
				} else if(Constants.SUB_LEVEL_SIX_NAME.equals(this.levelType)) {
					initializeLevel1_6();
				} else if(Constants.SUB_LEVEL_SEVEN_NAME.equals(this.levelType)) {
					initializeLevel1_7();
				} else if(Constants.SUB_LEVEL_EIGHT_NAME.equals(this.levelType)) {
					initializeLevel1_8();
				} else if(Constants.SUB_LEVEL_NINE_NAME.equals(this.levelType)) {
					initializeLevel1_9();
				}  else if(Constants.SUB_LEVEL_TEN_NAME.equals(this.levelType)) {
					initializeLevel1_10();
				} else if(Constants.SUB_LEVEL_ELEVEN_NAME.equals(this.levelType)) {
					initializeLevel1_11();
				} else if(Constants.SUB_LEVEL_TWELVE_NAME.equals(this.levelType)) {
					initializeLevel1_12();
				}
				
			} else if(Constants.LEVEL_TWO_NAME.equals(this.levelName)) {
				srcPillar.setX(xCor);
				srcPillar.setY(yCor);
				System.out.println("level type "+this.levelType);
				if(Constants.SUB_LEVEL_ONE_NAME.equals(this.levelType)) {
					initializeLevel2_1();
				} else if(Constants.SUB_LEVEL_TWO_NAME.equals(this.levelType)) {
					initializeLevel2_2();
				} else if(Constants.SUB_LEVEL_THREE_NAME.equals(this.levelType)) {
					initializeLevel2_3();
				} else if(Constants.SUB_LEVEL_FOUR_NAME.equals(this.levelType)) {
					initializeLevel2_4();
				} else if(Constants.SUB_LEVEL_FIVE_NAME.equals(this.levelType)) {
					initializeLevel2_5();
				} else if(Constants.SUB_LEVEL_SIX_NAME.equals(this.levelType)) {
					initializeLevel2_6();
				} else if(Constants.SUB_LEVEL_SEVEN_NAME.equals(this.levelType)) {
					initializeLevel2_7();
				} else if(Constants.SUB_LEVEL_EIGHT_NAME.equals(this.levelType)) {
					initializeLevel2_8();
				}
				

			} else if(Constants.LEVEL_THREE_NAME.equals(this.levelName)) {
			//	initializeLevel3_1();
				if(Constants.SUB_LEVEL_ONE_NAME.equals(this.levelType)) {
					initializeLevel3_1();
				} else if(Constants.SUB_LEVEL_TWO_NAME.equals(this.levelType)) {
					initializeLevel3_2();
				} else if(Constants.SUB_LEVEL_THREE_NAME.equals(this.levelType)) {
					initializeLevel3_3();
				} else if(Constants.SUB_LEVEL_FOUR_NAME.equals(this.levelType)) {
					initializeLevel3_4();
				} else if(Constants.SUB_LEVEL_FIVE_NAME.equals(this.levelType)) {
					initializeLevel3_5();
				} else if(Constants.SUB_LEVEL_SIX_NAME.equals(this.levelType)) {
					initializeLevel3_6();
				} else if(Constants.SUB_LEVEL_SEVEN_NAME.equals(this.levelType)) {
					initializeLevel3_7();
				} else if(Constants.SUB_LEVEL_EIGHT_NAME.equals(this.levelType)) {
					initializeLevel3_8();
				}
			} else if(Constants.LEVEL_FOUR_NAME.equals(this.levelName)) {
				
				System.out.println("level type is "+levelType);
				
				if(Constants.SUB_LEVEL_ONE_NAME.equals(this.levelType)) {
					initializeLevel4_1();
				} else if(Constants.SUB_LEVEL_TWO_NAME.equals(this.levelType)) {
					initializeLevel4_2();
				} else if(Constants.SUB_LEVEL_THREE_NAME.equals(this.levelType)) {
					initializeLevel4_3();
				} else if(Constants.SUB_LEVEL_FOUR_NAME.equals(this.levelType)) {
					initializeLevel4_4();
				} else if(Constants.SUB_LEVEL_FIVE_NAME.equals(this.levelType)) {
					initializeLevel4_5();
				} else if(Constants.SUB_LEVEL_SIX_NAME.equals(this.levelType)) {
					initializeLevel4_6();
				} else if(Constants.SUB_LEVEL_SEVEN_NAME.equals(this.levelType)) {
					initializeLevel4_7();
				} else if(Constants.SUB_LEVEL_EIGHT_NAME.equals(this.levelType)) {
					initializeLevel4_8();
				}  else if(Constants.SUB_LEVEL_NINE_NAME.equals(this.levelType)) {
					initializeLevel4_9();
				}

				
				
			}
			if(this.pillars.size()>1) {
				this.destPillar = this.pillars.get(1);
			}
		}


		private void initializeLevel4_9() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 550;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_7();
			addDiamondsInLevel2_8();
			addDiamondsInLevel1_9();
		}


		private void initializeLevel4_8() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 550;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_9();
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_8();
		}


		private void initializeLevel4_7() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 550;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_8();
			addDiamondsInLevel1_4();
		}


		private void initializeLevel4_6() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 550;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_9();
			addDiamondsInLevel1_2();
			addDiamondsInLevel1_8();
		}


		private void initializeLevel4_5() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_8();
			addDiamondsInLevel1_7();
		}


		private void initializeLevel4_4() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_8();
			addDiamondsInLevel1_5();
		}


		private void initializeLevel4_3() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 450;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_7();
		}


		private void initializeLevel4_2() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_5();
		}


		/**
		 * 
		 */
		private void initializeLevel4_1() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 250;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_4();
			addDiamondsInLevel1_2();
		}

		private void initializeLevel3_8() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 600;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel2_8();
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_5();
		}


		private void initializeLevel3_7() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 650;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 100;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_9();
			addDiamondsInLevel1_8();
			addDiamondsInLevel1_7();
		}


		private void initializeLevel3_6() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 450;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 100;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_2();
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_3();
			addDiamondsInLevel1_9();
		}


		private void initializeLevel3_5() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 50;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_4();
			addDiamondsInLevel1_2();
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_3();
		}


		private void initializeLevel3_4() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 350;
				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_4();
			addDiamondsInLevel1_3();
		}


		private void initializeLevel3_3() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_4();
			
		}


		private void initializeLevel3_2() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 350;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_2();
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_3();
		}



		/**
		 * 
		 */
		private void initializeLevel3_1() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 250;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_2();
			addDiamondsInLevel1_5();
		}


		/**
		 * 
		 */
		private void initializeLevel2_8() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 600;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_5();
			addDiamondsInLevel2_8();
		}
		private void addDiamondsInLevel2_8() {

			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() - 140);
			diamond.setY(pillars.get(8).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(9).getX() - 40);
			diamond.setY(pillars.get(9).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(9).getX() - 300);
			diamond.setY(pillars.get(9).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() - 210);
			diamond.setY(pillars.get(10).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() + 60);
			diamond.setY(pillars.get(10).getY() - 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() - 160);
			diamond.setY(pillars.get(11).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() - 30);
			diamond.setY(pillars.get(12).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() + 40);
			diamond.setY(pillars.get(12).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() - 140);
			diamond.setY(pillars.get(12).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(14).getX() - 10);
			diamond.setY(pillars.get(14).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(15).getX() + 140);
			diamond.setY(pillars.get(15).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(15).getX() - 140);
			diamond.setY(pillars.get(15).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(15).getX() - 10);
			diamond.setY(pillars.get(15).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(16).getX() + 100);
			diamond.setY(pillars.get(16).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(16).getX() + 240);
			diamond.setY(pillars.get(16).getY() - 250);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(17).getX() - 70);
			diamond.setY(pillars.get(17).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(17).getX() + 20);
			diamond.setY(pillars.get(17).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(18).getX() + 20);
			diamond.setY(pillars.get(18).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(19).getX() + 120);
			diamond.setY(pillars.get(19).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(19).getX() + 240);
			diamond.setY(pillars.get(19).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(19).getX() - 20);
			diamond.setY(pillars.get(19).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(20).getX() + 20);
			diamond.setY(pillars.get(20).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(21).getX() + 120);
			diamond.setY(pillars.get(21).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(22).getX() - 120);
			diamond.setY(pillars.get(22).getY() - 190);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(23).getX() + 20);
			diamond.setY(pillars.get(23).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(23).getX() + 20);
			diamond.setY(pillars.get(23).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(24).getX() - 320);
			diamond.setY(pillars.get(24).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(24).getX() - 220);
			diamond.setY(pillars.get(24).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(24).getX() - 0);
			diamond.setY(pillars.get(24).getY() - 100);
			diamondsInLevel.add(diamond);
		
		}


		/**
		 * 
		 */
		private void initializeLevel2_7() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 650;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 100;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_5();
			addDiamondsInLevel1_9();
			addDiamondsInLevel1_8();
		}
		/**
		 * 
		 */
		private void initializeLevel2_6() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 450;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 100;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			addDiamondsInLevel1_7();
			addDiamondsInLevel1_9();
		}
		/**
		 * 
		 */
		private void initializeLevel2_5() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + 50;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_8();
		}
		/**
		 * 
		 */
		private void initializeLevel2_4() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 350;
				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_7();
		}
		/**
		 * 
		 */
		private void initializeLevel2_3() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_5();
		}
		/**
		 * 
		 */
		private void initializeLevel2_2() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 350;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_4();
		}
		
		/**
		 * 
		 */
		private void initializeLevel2_1() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 250;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2 + GameUtil.randInt(-50, 50);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_2();
		}
		
		/**
		 * 
		 */
		private void initializeLevel1_12() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + GameUtil.randInt(this.gamepanel.getWidth() - 600, this.gamepanel.getWidth() - 200);

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight() - (pillarBitmap.getHeight()*3/2) + GameUtil.randInt((pillarBitmap.getHeight()/2), (pillarBitmap.getHeight()));
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
		}
		
		/**
		 * 
		 */
		private void initializeLevel1_11() {
			

			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + GameUtil.randInt(this.gamepanel.getWidth() - 600, this.gamepanel.getWidth() - 400);

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 300, this.gamepanel.getHeight() - 100);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
		}
		
		/**
		 * 
		 */
		private void initializeLevel1_10() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + this.gamepanel.getWidth() - 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 350, this.gamepanel.getHeight() - 100);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			
			
		}
		
		/**
		 * 
		 */
		private void initializeLevel1_9() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + GameUtil.randInt(400, 600);;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 350, this.gamepanel.getHeight() - 100);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_9();
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_9() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 140);
			diamond.setY(pillars.get(1).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 40);
			diamond.setY(pillars.get(1).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 300);
			diamond.setY(pillars.get(1).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 210);
			diamond.setY(pillars.get(3).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() + 60);
			diamond.setY(pillars.get(2).getY() - 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 160);
			diamond.setY(pillars.get(2).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 30);
			diamond.setY(pillars.get(4).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 40);
			diamond.setY(pillars.get(4).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 140);
			diamond.setY(pillars.get(4).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 10);
			diamond.setY(pillars.get(5).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(6).getX() + 140);
			diamond.setY(pillars.get(6).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() - 140);
			diamond.setY(pillars.get(7).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() - 10);
			diamond.setY(pillars.get(7).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 100);
			diamond.setY(pillars.get(8).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 240);
			diamond.setY(pillars.get(8).getY() - 250);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() - 70);
			diamond.setY(pillars.get(10).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() + 20);
			diamond.setY(pillars.get(10).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() + 20);
			diamond.setY(pillars.get(11).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() + 120);
			diamond.setY(pillars.get(12).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() + 240);
			diamond.setY(pillars.get(12).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(14).getX() - 20);
			diamond.setY(pillars.get(14).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(15).getX() + 20);
			diamond.setY(pillars.get(15).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(15).getX() + 120);
			diamond.setY(pillars.get(15).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(16).getX() - 120);
			diamond.setY(pillars.get(16).getY() - 190);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(17).getX() + 20);
			diamond.setY(pillars.get(17).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(17).getX() + 20);
			diamond.setY(pillars.get(17).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(18).getX() - 320);
			diamond.setY(pillars.get(18).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(19).getX() - 220);
			diamond.setY(pillars.get(19).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(19).getX() - 0);
			diamond.setY(pillars.get(19).getY() - 100);
			diamondsInLevel.add(diamond);
		}
		
		/**
		 * 
		 */
		private void initializeLevel1_8() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + GameUtil.randInt(400, 600);;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 250, this.gamepanel.getHeight() - 249);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_8();
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_8() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 140);
			diamond.setY(pillars.get(1).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 40);
			diamond.setY(pillars.get(1).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 300);
			diamond.setY(pillars.get(2).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 210);
			diamond.setY(pillars.get(2).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() + 60);
			diamond.setY(pillars.get(3).getY() - 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 160);
			diamond.setY(pillars.get(2).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 30);
			diamond.setY(pillars.get(3).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 40);
			diamond.setY(pillars.get(4).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 140);
			diamond.setY(pillars.get(4).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 10);
			diamond.setY(pillars.get(4).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 140);
			diamond.setY(pillars.get(4).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 140);
			diamond.setY(pillars.get(5).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 10);
			diamond.setY(pillars.get(5).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 100);
			diamond.setY(pillars.get(5).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 240);
			diamond.setY(pillars.get(5).getY() - 250);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() - 70);
			diamond.setY(pillars.get(7).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() + 20);
			diamond.setY(pillars.get(7).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 20);
			diamond.setY(pillars.get(8).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 120);
			diamond.setY(pillars.get(8).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 240);
			diamond.setY(pillars.get(8).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(9).getX() - 20);
			diamond.setY(pillars.get(9).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() + 20);
			diamond.setY(pillars.get(10).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() + 120);
			diamond.setY(pillars.get(10).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() - 120);
			diamond.setY(pillars.get(11).getY() - 190);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(12).getX() + 20);
			diamond.setY(pillars.get(12).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(13).getX() + 20);
			diamond.setY(pillars.get(13).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(14).getX() - 320);
			diamond.setY(pillars.get(14).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(14).getX() - 220);
			diamond.setY(pillars.get(14).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(14).getX() - 0);
			diamond.setY(pillars.get(14).getY() - 100);
			diamondsInLevel.add(diamond);
		}
		/**
		 * 
		 */
		private void initializeLevel1_7() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + GameUtil.randInt(200, 400);;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 300, this.gamepanel.getHeight() - 299);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_7();
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_7() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 140);
			diamond.setY(pillars.get(1).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 40);
			diamond.setY(pillars.get(1).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 300);
			diamond.setY(pillars.get(2).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 210);
			diamond.setY(pillars.get(2).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() + 60);
			diamond.setY(pillars.get(3).getY() - 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 160);
			diamond.setY(pillars.get(2).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 30);
			diamond.setY(pillars.get(3).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 40);
			diamond.setY(pillars.get(4).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 140);
			diamond.setY(pillars.get(4).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 10);
			diamond.setY(pillars.get(4).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 140);
			diamond.setY(pillars.get(4).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 140);
			diamond.setY(pillars.get(5).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 10);
			diamond.setY(pillars.get(5).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 100);
			diamond.setY(pillars.get(5).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 240);
			diamond.setY(pillars.get(5).getY() - 250);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() - 70);
			diamond.setY(pillars.get(7).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() + 20);
			diamond.setY(pillars.get(7).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 20);
			diamond.setY(pillars.get(8).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 120);
			diamond.setY(pillars.get(8).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 240);
			diamond.setY(pillars.get(8).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() - 20);
			diamond.setY(pillars.get(8).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 20);
			diamond.setY(pillars.get(8).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(8).getX() + 120);
			diamond.setY(pillars.get(8).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(9).getX() - 120);
			diamond.setY(pillars.get(9).getY() - 190);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(9).getX() + 20);
			diamond.setY(pillars.get(9).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(10).getX() + 20);
			diamond.setY(pillars.get(10).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() - 320);
			diamond.setY(pillars.get(11).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() - 220);
			diamond.setY(pillars.get(11).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(11).getX() - 0);
			diamond.setY(pillars.get(11).getY() - 100);
			diamondsInLevel.add(diamond);
		}
		/**
		 * 
		 */
		private void initializeLevel1_6() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 400;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = GameUtil.randInt(this.gamepanel.getHeight() - 300, this.gamepanel.getHeight() - 100);
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_5();
		}
		/**
		 * 
		 */
		private void initializeLevel1_5() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + this.gamepanel.getWidth() - 400;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_5();
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_5() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 140);
			diamond.setY(pillars.get(1).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 40);
			diamond.setY(pillars.get(1).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 300);
			diamond.setY(pillars.get(2).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 210);
			diamond.setY(pillars.get(2).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() + 60);
			diamond.setY(pillars.get(3).getY() - 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 160);
			diamond.setY(pillars.get(3).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 30);
			diamond.setY(pillars.get(3).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() + 40);
			diamond.setY(pillars.get(3).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 140);
			diamond.setY(pillars.get(4).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 10);
			diamond.setY(pillars.get(4).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 140);
			diamond.setY(pillars.get(4).getY() - 150);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 140);
			diamond.setY(pillars.get(5).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 10);
			diamond.setY(pillars.get(5).getY() - 180);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 100);
			diamond.setY(pillars.get(5).getY() - 170);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(6).getX() + 140);
			diamond.setY(pillars.get(6).getY() - 250);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() - 70);
			diamond.setY(pillars.get(7).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(7).getX() + 20);
			diamond.setY(pillars.get(7).getY() - 150);
			diamondsInLevel.add(diamond);
		}
		/**
		 * 
		 */
		private void initializeLevel1_4() {
			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + this.gamepanel.getWidth() - 500;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_4();
			
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_4() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 100);
			diamond.setY(pillars.get(1).getY() - 50);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() );
			diamond.setY(pillars.get(1).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 200);
			diamond.setY(pillars.get(2).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() + 10);
			diamond.setY(pillars.get(2).getY() + 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 160);
			diamond.setY(pillars.get(3).getY() + 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() - 60);
			diamond.setY(pillars.get(3).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 30);
			diamond.setY(pillars.get(4).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 40);
			diamond.setY(pillars.get(4).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 140);
			diamond.setY(pillars.get(4).getY() - 230);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 80);
			diamond.setY(pillars.get(5).getY() - 80);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 40);
			diamond.setY(pillars.get(5).getY() - 150);
			diamondsInLevel.add(diamond);
		}
		/**
		 * 
		 */
		private void initializeLevel1_3() {

			
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 400;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			

			addDiamondsInLevel1_3();
			
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_3() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 60);
			diamond.setY(pillars.get(1).getY() - 110);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() + 20);
			diamond.setY(pillars.get(1).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 160);
			diamond.setY(pillars.get(2).getY() - 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() + 10);
			diamond.setY(pillars.get(3).getY() + 40);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 160);
			diamond.setY(pillars.get(4).getY() + 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 40);
			diamond.setY(pillars.get(4).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 30);
			diamond.setY(pillars.get(4).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 140);
			diamond.setY(pillars.get(5).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 40);
			diamond.setY(pillars.get(5).getY() - 200);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 40);
			diamond.setY(pillars.get(5).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 240);
			diamond.setY(pillars.get(5).getY() - 150);
			diamondsInLevel.add(diamond);
		}


		/**
		 * 
		 */
		private void initializeLevel1_2() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 300;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			
			addDiamondsInLevel1_2();
			
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_2() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() - 40);
			diamond.setY(pillars.get(1).getY() - 160);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() + 100);
			diamond.setY(pillars.get(1).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 60);
			diamond.setY(pillars.get(2).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() + 10);
			diamond.setY(pillars.get(3).getY() - 140);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() - 60);
			diamond.setY(pillars.get(4).getY() + 60);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 40);
			diamond.setY(pillars.get(4).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() - 30);
			diamond.setY(pillars.get(5).getY() - 20);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 40);
			diamond.setY(pillars.get(5).getY() - 200);
			diamondsInLevel.add(diamond);
		}


		/**
		 * 
		 */
		private void initializeLevel1_1() {
			int i=1;
			int x = xCor;
			while(i<noOfPillars)	{
				x = x + 200;

				destPillar= new Pillar(pillarBitmap);
				destPillar.setIndex(i);
				yCor = this.gamepanel.getHeight()/2;
				destPillar.setX(x);
				destPillar.setY(yCor);
				pillars.add(destPillar);
				i++;
			}
			
			addDiamondsInLevel1_1();
			
		}


		/**
		 * 
		 */
		private void addDiamondsInLevel1_1() {
			LevelDiamond diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() + 40);
			diamond.setY(pillars.get(1).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(1).getX() + 140);
			diamond.setY(pillars.get(1).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(2).getX() - 20);
			diamond.setY(pillars.get(2).getY() - 100);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(3).getX() + 80);
			diamond.setY(pillars.get(3).getY() - 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(4).getX() + 120);
			diamond.setY(pillars.get(4).getY() + 120);
			diamondsInLevel.add(diamond);
			
			diamond = new LevelDiamond();
			diamond.setX(pillars.get(5).getX() + 20);
			diamond.setY(pillars.get(5).getY() - 60);
			diamondsInLevel.add(diamond);
		}
		
		public void initialiseForReplay() {
			
			System.out.println("inside can initialise or replay");
			
			
			if(((Pillar)(pillars.toArray()[0])).getX() < initialX) {
				System.out.println("inside can initialise for replay true");
				
				for(Object pillarTempObj : pillars.toArray()) {
					((Pillar)pillarTempObj).setX(((Pillar)pillarTempObj).getX() + (3*noOfPillars));
				}
				
			} else {
				
				
				System.out.println("inside can initialise for replay false");
				
				canInitialiseForReplay = false;
				setDefaultToReplayMode();
			}
		}

		
		public void setDefaultToReplayMode() {
			srcPillar = this.pillars.get(0);
			destPillar = this.pillars.get(1);
			this.ball.setNewPositionForBall();
			
			levelGameStat = new LevelGameStat();
			updateLevelGameStat();
			this.gamepanel.getCurrentMainLevel().updateLevelInfoGameStat();
		}


		public void draw(Canvas canvas) {

			
			
			drawTheme(canvas); 
			 
			
			
			
			if(this.ball.isViewUpdateFlag()){

				if(((this.getGamepanel().getWidth()/4) < this.getSrcPillar().getX())){

					for(Object pillarTempObj : pillars.toArray()) {
						((Pillar)pillarTempObj).setX(((Pillar)pillarTempObj).getX()-10);
						((Pillar)pillarTempObj).draw(canvas);

					}
					
//					for(Object diamondTempObj : diamondsInLevel.toArray()) {
//						((LevelDiamond)diamondTempObj).setX(((LevelDiamond)diamondTempObj).getX()-10);
//						((LevelDiamond)diamondTempObj).draw(canvas);
//
//					}
					
					this.ball.setX(this.ball.getX()-10);

					this.ball.draw(canvas);
					this.levelBall.draw(canvas);

				} else {
					this.ball.setViewUpdateFlag(false);
				} 
			} else {

				if(initialisingLevel) {
					canvas.save();
				    
					int yScaled = (int) ((this.gamepanel.getHeight() - (initialisingLevelScaleCount*this.gamepanel.getHeight()))/2);
					
					canvas.translate(0, yScaled);
				    
				    canvas.scale(initialisingLevelScaleCount, initialisingLevelScaleCount);
				    
				    drawLevels(canvas);
					this.ball.draw(canvas);

//					for(LevelDiamond diamond : diamondsInLevel) {
//						if(!diamond.isAlreadyAttained()) {
//							diamond.draw(canvas);
//						}
//						
//					}
					
					if(!this.levelBall.isAlreadyAttained()) {
						this.levelBall.draw(canvas);
						
					}
					initialisingLevelScaleCount += 0.005f;
					canvas.restore();
					
					if(initialisingLevelScaleCount >= 1) {
						initialisingLevel = false;
					}

				} else {
					drawLevels(canvas);
					this.ball.draw(canvas);
					
//					for(LevelDiamond diamond : diamondsInLevel) {
//						if(!diamond.isAlreadyAttained()) {
//							diamond.draw(canvas);
//						}
//						
//					}
					
					if(!this.levelBall.isAlreadyAttained()) {
						this.levelBall.draw(canvas);
						
					}
					
					
				}
				
				
			}

			if(canInitialiseForReplay) {
				System.out.println("inside can initialise");
				initialiseForReplay();
				
			}
			

			this.gameStat.setScoreX(((this.gamepanel.getWidth()/2)-60));
			this.gameStat.setScoreY(140);
		//	this.gameStat.draw(canvas);

			RectF rect = new RectF(-20, 5, 570, 85);
			canvas.drawRoundRect(rect, 20.0f, 20.0f, paint);
			
			rect = new RectF(gamepanel.getWidth() - 120, 95, gamepanel.getWidth() + 20, 175);
			canvas.drawRoundRect(rect, 20.0f, 20.0f, paint);
			
			canvas.drawText(noOfPillarsCrossed+" / "+(noOfPillars-1), gamepanel.getWidth() - 110, 150, this.newPaint);
			
			rect = new RectF(gamepanel.getWidth() - 380, 5, gamepanel.getWidth() + 20, 85);
			canvas.drawRoundRect(rect, 20.0f, 20.0f, paint);
			
			BackButton.draw(canvas);

		//	HomeButton.setHomepanel(this.gamepanel.getHomePanel());
			HomeButton.draw(canvas);
			
			MusicButton.draw(canvas);

			ThemeRequest.setHomepanel(this.gamepanel.getHomePanel());
			ThemeRequest.draw(canvas);

//			HelpButton.setGamePanel(this.gamepanel);
//			HelpButton.draw(canvas);


			HelpModeButton.setGamePanel(this.gamepanel);
			HelpModeButton.draw(canvas);

			ReloadButton.setHomepanel(this.gamepanel.getHomePanel());
			ReloadButton.draw(canvas);
			
			if(HelpModeButton.clicked) {
				canvas.drawRect(4, helpFrameY, gamepanel.getWidth()-4, gamepanel.getHeight()-4 + helpFrameY, paint);
				
				if(helpFrameY <= 0) {
					helpFrameY = helpFrameY + 20;
				} 
				
				
				indicatingCircle.setX(this.srcPillar.getX());
				indicatingCircle.setY(this.srcPillar.getY() + this.srcPillar.getBitmapImage().getHeight()/3 + radius);
				indicatingCircle.setRadius(radius);
				indicatingCircle.draw(canvas);

				indicatingArrow.setX(this.destPillar.getX()- indicatingArrow.getBitmapImage().getWidth()/2);
				indicatingArrow.setY(gamepanel.getHeight()/2 - 100 + radius);
				indicatingArrow.draw(canvas);

				radius++;

				if(radius>=40) {
					radius = 0;
				}
				HelpModeDone.setGamePanel(this.gamepanel);
				HelpModeDone.draw(canvas);

			} else {
				helpFrameY = -1* gamepanel.getHeight();
			}

			if(HelpButton.finished) {
				canvas.drawRect(4, 4, gamepanel.getWidth()-4, gamepanel.getHeight()-4, paint);
				
				indicatingCircle.setX(this.srcPillar.getX());
				indicatingCircle.setY(this.srcPillar.getY() + this.srcPillar.getBitmapImage().getHeight()/3 );
				indicatingCircle.setRadius(radius);
				indicatingCircle.draw(canvas);

				indicatingArrow.setX(this.destPillar.getX()- indicatingArrow.getBitmapImage().getWidth()/2);
				indicatingArrow.setY(this.destPillar.getY()-this.destPillar.getBitmapImage().getHeight()/2 - indicatingArrow.getBitmapImage().getHeight() - 10 + radius);
				indicatingArrow.draw(canvas);


				radius++;

				if(radius>=70) {
					radius = 0;
				}


				infoBox.setX(800);
				infoBox.setY(250);
				infoBox.draw(canvas);
				canvas.drawText("Press on the", 720, 175, newPaint);
				canvas.drawText("source", 750, 215, newPaint);
				canvas.drawText("to make the ball", 685, 255, newPaint);
				canvas.drawText("jump to", 745, 295, newPaint);
				canvas.drawText("Destination", 720, 335, newPaint);




				//			canvas.drawBitmap(indicatingArrow, this.destPillar.getX()- indicatingArrow.getWidth()/2, this.destPillar.getY()-this.destPillar.getBitmapImage().getHeight()/2 - indicatingArrow.getHeight() + 10, newPaint);


			}


			


			levelGameStatPortion.draw(canvas);
			if(pillarCrossed) {
				if(this.levelGameStat!=null && this.levelGameStat.getScore() > 0) {
					
					
					increasingCount.setFinalValue(this.levelGameStat.getScore() - this.previousGameStat.getScore());
					
					if(increasingCount.getTextPaint().getTextSize() >=70) {
						canUpdatePillars = true;
						increasingCount.setY(increasingCount.getY()-8);
						increasingCount.getTextPaint().setAlpha(increasingCount.getTextPaint().getAlpha()-8);
					} else {
						increasingCount.getTextPaint().setTextSize(increasingCount.getTextPaint().getTextSize()+3);
					}
					
					if(increasingCount.getY()<=0) {
						
						pillarCrossed = false;
						
						if(noOfPillarsCrossed == (noOfPillars-1)) {
							gameOver = true;
						}
					}
					increasingCount.draw(canvas);
					
				}
//				
			}
			
			if(pillarFailed) {
				if(this.levelGameStat!=null) {
					
					
					increasingCount.setFinalValue(this.levelGameStat.getScore() - this.previousGameStat.getScore());
					
					if(increasingCount.getTextPaint().getTextSize() >=70) {
						canUpdatePillars = true;
						increasingCount.setY(increasingCount.getY() + 8);
						increasingCount.getTextPaint().setAlpha(increasingCount.getTextPaint().getAlpha()-8);
					} else {
						increasingCount.getTextPaint().setTextSize(increasingCount.getTextPaint().getTextSize()+3);
					}
					
					if(increasingCount.getY()>=gamepanel.getHeight()) {
						
						pillarFailed = false;
					}
					increasingCount.draw(canvas);
					
				}
//				
			}
			
			if(ThemeRequest.isRequested) {
				themePanel.draw(canvas);
				themePanel.updateThemePanel();
			}
			
			if(gameOver) {
				gameOverConfirmationPanel.draw(canvas);
				gameOverConfirmationPanel.updateGameOverConfirmationPanel();
				
			} else {
				if(!isOngoing) {
					ThemeRequest.isRequested = true;
				}
			}
			

			if(LevelClearedInfo.cleared==true) {
				
				levelClearedInfo.draw(canvas);
			}
			

		}


		/**
		 * @param canvas
		 */
		private void drawTheme(Canvas canvas) {
			if(this.theme.isRaining()) {
				
				this.bg2.setSpeedX(-1);
				this.bg2.update();
				this.bg2.draw(canvas);
				this.bg1.setSpeedX(-1);
				this.bg1.update();
				this.bg1.draw(canvas);
				
				if(isRaining) {
					
					this.bg3.setSpeedX(-1);
					this.bg3.update();
					this.bg3.draw(canvas);
					this.bg4.setSpeedX(-1);
					this.bg4.update();
					this.bg4.draw(canvas);
					rainCount++;
					
					if(rainCount < 16) {
						isRaining = true;
					} else {
						isRaining = false;
					}
				} else {
	
					this.bg3.setSpeedX(-1);
					this.bg3.update();
					this.bg3.draw(canvas);
					this.bg4.setSpeedX(-1);
					this.bg4.update();
					this.bg4.draw(canvas);
					/*this.bg5.setSpeedX(-1);
					this.bg5.update();
					this.bg5.draw(canvas);
					this.bg6.setSpeedX(-1);
					this.bg6.update();
					this.bg6.draw(canvas);*/
					
					rainCount = rainCount - 2;
					
					if(rainCount > 0) {
						isRaining = false;
					} else {
						isRaining = true;
					}
				}
				
			} else if(this.theme.isStill()) {
				
				this.bg2.setSpeedX(0);
				this.bg2.update();
				this.bg2.draw(canvas);
				this.bg1.setSpeedX(0);
				this.bg1.update();
				this.bg1.draw(canvas);
				
				if(this.theme.isRaining()) {
					if(isRaining) {
						
						this.bg3.setSpeedX(-1);
						this.bg3.update();
						this.bg3.draw(canvas);
						this.bg4.setSpeedX(-1);
						this.bg4.update();
						this.bg4.draw(canvas);
						rainCount++;
						
						if(rainCount < 16) {
							isRaining = true;
						} else {
							isRaining = false;
							
						}
											
					} else {

						/*this.bg5.setSpeedX(-1);
						this.bg5.update();
						this.bg5.draw(canvas);
						this.bg6.setSpeedX(-1);
						this.bg6.update();
						this.bg6.draw(canvas);*/
						
						this.bg3.setSpeedX(-1);
						this.bg3.update();
						this.bg3.draw(canvas);
						this.bg4.setSpeedX(-1);
						this.bg4.update();
						this.bg4.draw(canvas);
						
						rainCount = rainCount - 2;
						
						if(rainCount > 0) {
							isRaining = false;
						} else {
							isRaining = true;
						}
					}
				}
				
				if(this.theme.isSnowFall()) {
						this.bg7.setSpeedY(1);
						this.bg7.updateY();
						this.bg7.draw(canvas);
						this.bg8.setSpeedY(1);
						this.bg8.updateY();
						this.bg8.draw(canvas);
						this.bg9.setSpeedY(1);
						this.bg9.updateY();
						this.bg9.draw(canvas);
						this.bg10.setSpeedY(1);
						this.bg10.updateY();
						this.bg10.draw(canvas);
						
				}
				
				if(this.theme.isGrassLand()) {
					
					
					//bird 1
					int srcBird1X = currentBird1Frame * 50;
					int srcBird1Y = 0 * 28;
					
					Rect srcBird1 = new Rect(srcBird1X, srcBird1Y, srcBird1X + 50, srcBird1Y + 28);
					Rect destBird1 = new Rect(400 + bird1X, 200 + bird1Y, 450 + bird1X, 228 + bird1Y);
					
					bird1MoveFrameCount++;
					
					if(bird1MoveFrameCount>4) {
						currentBird1Frame = ++currentBird1Frame % 4;
						bird1MoveFrameCount = 0;
						bird1X += 12;
						bird1Y -= 2;
						
						if(bird1X >= this.gamepanel.getWidth() - 400) {
							bird1X = -450;
							bird1Y = 0;
						}
						
					}
					
					canvas.drawBitmap(bird1, srcBird1, destBird1, null);
					
					//bird 2
					int srcBird2X = currentBird2Frame * 50;
					int srcBird2Y = 1 * 28;
					
					Rect srcBird2 = new Rect(srcBird2X, srcBird2Y, srcBird2X + 50, srcBird2Y + 28);
					Rect destBird2 = new Rect(160 + bird2X, 120 + bird2Y, 216 + bird2X, 148 + bird2Y);
					
					bird2MoveFrameCount++;
					
					if(bird2MoveFrameCount>30) {
						currentBird2Frame = ++currentBird2Frame % 4;
						bird2MoveFrameCount =20;
					}
					
					canvas.drawBitmap(bird2, srcBird2, destBird2, null);
					
				}
				
				
				
			} else if(this.theme.isUnderWater()){
				
				
				int srcPlantX = currentFrame * 200;
				int srcPlantY = 0 * 401;
				
				Rect srcPlant = new Rect(srcPlantX, srcPlantY, srcPlantX + 200, srcPlantY + 401);
				Rect destPlant = new Rect(0, gamepanel.getHeight() - 401, 200, gamepanel.getHeight());
				
				
				
				
				plantMoveFrameCount++;
				
				if(plantMoveFrameCount>50) {
					currentFrame = ++currentFrame % 2;
					plantMoveFrameCount = 0;
				}
				
				
				if(isRaining) {
					
					this.bg11.setSpeedX(0);
					this.bg11.update();
					this.bg11.draw(canvas);
					canvas.drawBitmap(undergroudPlantBitmap, srcPlant, destPlant, null);
					
					rainCount++;
					
					if(rainCount < 10) {
						isRaining = true;
					} else {
						isRaining = false;
							
						
					}
					
										
				} else {

					this.bg12.setSpeedX(0);
					this.bg12.update();
					this.bg12.draw(canvas);
					rainCount = rainCount - 1;
					canvas.drawBitmap(undergroudPlantBitmap, srcPlant, destPlant, null);
					
					if(rainCount > 0) {
						
						isRaining = false;
					} else {

						
						isRaining = true;
					}

				}
				
				//fish 1
				int srcFish1X = currentFish1Frame * 155;
				int srcFish1Y = 0 * 175;
				
				Rect srcFish1 = new Rect(srcFish1X, srcFish1Y, srcFish1X + 155, srcFish1Y + 175);
				Rect destFish1 = new Rect(fish1X, gamepanel.getHeight() - 231 + fish1Y, 155 + fish1XWhileReversing, gamepanel.getHeight() - 56 + fish1Y);
				
				fish1Movement();
				
				fish1MoveFrameCount++;
				if(fish1MoveFrameCount > 6) {
					currentFish1Frame = ++currentFish1Frame % 3;	
					fish1MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterFish1Bitmap, srcFish1, destFish1, null);
				
				
				//fish 2
				int srcFish2X = currentFish2Frame * 130;
				int srcFish2Y = 0 * 150;
				
				Rect srcFish2 = new Rect(srcFish2X, srcFish2Y, srcFish2X + 130, srcFish2Y + 150);
				Rect destFish2 = new Rect(fish2X, gamepanel.getHeight() - 331 + fish2Y, 130 + fish2XWhileReversing, gamepanel.getHeight() - 181 + fish2Y);
				
				fish2Movement();
				
				fish2MoveFrameCount++;
				if(fish2MoveFrameCount > 4) {
					currentFish2Frame = ++currentFish2Frame % 3;	
					fish2MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterFish2Bitmap, srcFish2, destFish2, null);
				
				
				//fish 3
				int srcFish3X = currentFish3Frame * 65;
				int srcFish3Y = 0 * 75;
				
				Rect srcFish3 = new Rect(srcFish3X, srcFish3Y, srcFish3X + 65, srcFish3Y + 75);
				Rect destFish3 = new Rect(400+fish3X, gamepanel.getHeight() - 300 + fish3Y, 465 + fish3XWhileReversing, gamepanel.getHeight() - 225 + fish3Y);
				
				fish3Movement();
				
				fish3MoveFrameCount++;
				if(fish3MoveFrameCount > 4) {
					currentFish3Frame = ++currentFish3Frame % 3;	
					fish3MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterFish3Bitmap, srcFish3, destFish3, null);
				
				//fish 4
				int srcFish4X = currentFish4Frame * 65;
				int srcFish4Y = 0 * 75;
				
				Rect srcFish4 = new Rect(srcFish4X, srcFish4Y, srcFish4X + 65, srcFish4Y + 75);
				Rect destFish4 = new Rect(300+fish4X, gamepanel.getHeight() - 250 + fish4Y, 365 + fish4XWhileReversing, gamepanel.getHeight() - 175 + fish4Y);
				
				fish4Movement();
				
				fish4MoveFrameCount++;
				if(fish4MoveFrameCount > 10) {
					currentFish4Frame = ++currentFish4Frame % 3;	
					fish4MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterFish4Bitmap, srcFish4, destFish4, null);
				
				//fish 5
				int srcFish5X = currentFish5Frame * 190;
				int srcFish5Y = 0 * 100;
				
				Rect srcFish5 = new Rect(srcFish5X, srcFish5Y, srcFish5X + 190, srcFish5Y + 100);
				Rect destFish5 = new Rect(gamepanel.getWidth() - 200 +fish5X, gamepanel.getHeight() - 380 + fish5Y, gamepanel.getWidth() - 10 + fish5XWhileReversing, gamepanel.getHeight() - 280 + fish5Y);
				
				fish5Movement();
				
				fish5MoveFrameCount++;
				if(fish5MoveFrameCount > 6) {
					currentFish5Frame = ++currentFish5Frame % 3;	
					fish5MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterFish5Bitmap, srcFish5, destFish5, null);
				
				//star fish 1
				int srcStarFish1X = currentStarFish1Frame * 140;
				int srcStarFish1Y = 0 * 75;
				
				Rect srcStarFish1 = new Rect(srcStarFish1X, srcStarFish1Y, srcStarFish1X + 140, srcStarFish1Y + 75);
				Rect destStarFish1 = new Rect(gamepanel.getWidth() - 600, gamepanel.getHeight() - 100, gamepanel.getWidth() - 460, gamepanel.getHeight() - 25);
				
				starFish1MoveFrameCount++;
				if(starFish1MoveFrameCount > 40) {
					currentStarFish1Frame = ++currentStarFish1Frame % 2;	
					starFish1MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterStarFish1Bitmap, srcStarFish1, destStarFish1, null);
				
				//shell 1
				int srcShell1X = currentShell1Frame * 124;
				int srcShell1Y = 0 * 65;
				
				Rect srcShell1 = new Rect(srcShell1X, srcShell1Y, srcShell1X + 124, srcShell1Y + 65);
				Rect destShell1 = new Rect(gamepanel.getWidth() - 124, gamepanel.getHeight() - 80, gamepanel.getWidth(), gamepanel.getHeight() - 15);
				
				shell1MoveFrameCount++;
				if(shell1MoveFrameCount > 100) {
					currentShell1Frame = ++currentShell1Frame % 2;	
					shell1MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterShell1Bitmap, srcShell1, destShell1, null);
				
				//shell 1
				int srcBubble1X = currentBubble1Frame * 130;
				int srcBubble1Y = 0 * 520;
				
				Rect srcBubble1 = new Rect(srcBubble1X, srcBubble1Y, srcBubble1X + 130, srcBubble1Y + 520);
				Rect destBubble1 = new Rect(gamepanel.getWidth() - 130, gamepanel.getHeight() - 600, gamepanel.getWidth(), gamepanel.getHeight() - 80);
				
				bubble1MoveFrameCount++;
				if(bubble1MoveFrameCount > 16) {
					currentBubble1Frame = ++currentBubble1Frame % 2;	
					bubble1MoveFrameCount = 0;
				}
				canvas.drawBitmap(underwaterBubble1Bitmap, srcBubble1, destBubble1, null);
				
				
			
			} else {
				this.bg2.setSpeedX(-1);
				this.bg2.update();
				this.bg2.draw(canvas);
				this.bg1.setSpeedX(-1);
				this.bg1.update();
				this.bg1.draw(canvas);
			}
		}

		private void fish5Movement() {
			if(!isFish5MovingFront) {
				fish5X += 2;
				fish5XWhileReversing += 2;
				
				if(fish5X >= 150) {
					isFish5MovingFront = true;
					isFish5Reversing = true;
				}
				
			} else if(isFish5Reversing) {
				fish5X += 4;
				fish5XWhileReversing -= 3;
				fish5Y -= 1;
				if(fish5X  >= (fish5XWhileReversing + 380)) {
					isFish5Reversing = false;
					isFish5MovingBack = true;
				}
				
			} else if(isFish5MovingBack) {
				fish5X -= 2;
				fish5XWhileReversing -= 2;
				
				if(fish5XWhileReversing <= -300) {
					isFish5MovingBack = false;
					isFish5ReversingBack = true;
				}
			
			} else if(isFish5ReversingBack) {
				fish5XWhileReversing += 4;
				fish5X -= 3;
				fish5Y += 1;
				
				if(fish5X <= (fish5XWhileReversing - 20)) {
					isFish5ReversingBack = false;
					isFish5MovingFront = false;
				}
			}
			
		}
		
		
		
		private void fish4Movement() {
			if(!isFish4MovingFront) {
				fish4X += 3;
				fish4XWhileReversing += 3;
				
				if(fish4X >= 500) {
					isFish4MovingFront = true;
					isFish4Reversing = true;
				}
				
			} else if(isFish4Reversing) {
				fish4X += 4;
				fish4XWhileReversing -= 1;
				fish4Y -= 1;
				if(fish4X  >= (fish4XWhileReversing + 130)) {
					isFish4Reversing = false;
					isFish4MovingBack = true;
				}
				
			} else if(isFish4MovingBack) {
				fish4X -= 3;
				fish4XWhileReversing -= 3;
				
				if(fish4XWhileReversing <= -300) {
					isFish4MovingBack = false;
					isFish4ReversingBack = true;
				}
			
			} else if(isFish4ReversingBack) {
				fish4XWhileReversing += 4;
				fish4X -= 1;
				fish4Y += 1;
				
				if(fish4X <= (fish4XWhileReversing - 20)) {
					isFish4ReversingBack = false;
					isFish4MovingFront = false;
				}
			}
			
		}
		
		
		private void fish3Movement() {
			if(!isFish3MovingFront) {
				fish3X += 4;
				fish3XWhileReversing += 4;
				
				if(fish3X >= 200) {
					isFish3MovingFront = true;
					isFish3Reversing = true;
				}
				
			} else if(isFish3Reversing) {
				fish3X += 4;
				fish3XWhileReversing -= 1;
				fish3Y -= 1;
				if(fish3X  >= (fish3XWhileReversing + 130)) {
					isFish3Reversing = false;
					isFish3MovingBack = true;
				}
				
			} else if(isFish3MovingBack) {
				fish3X -= 4;
				fish3XWhileReversing -= 4;
				
				if(fish3XWhileReversing <= -300) {
					isFish3MovingBack = false;
					isFish3ReversingBack = true;
				}
			
			} else if(isFish3ReversingBack) {
				fish3XWhileReversing += 4;
				fish3X -= 1;
				fish3Y += 1;
				
				if(fish3X <= (fish3XWhileReversing - 20)) {
					isFish3ReversingBack = false;
					isFish3MovingFront = false;
				}
			}
			
		}
		
		private void fish2Movement() {
			if(!isFish2MovingFront) {
				fish2X += 4;
				fish2XWhileReversing += 4;
				
				if(fish2X >= this.gamepanel.getWidth()) {
					isFish2MovingFront = true;
					isFish2Reversing = true;
				}
				
			} else if(isFish2Reversing) {
				fish2X += 4;
				fish2XWhileReversing -= 1;
				fish2Y -= 1;
				if(fish2X  >= (fish2XWhileReversing + 260)) {
					isFish2Reversing = false;
					isFish2MovingBack = true;
				}
				
			} else if(isFish2MovingBack) {
				fish2X -= 4;
				fish2XWhileReversing -= 4;
				
				if(fish2XWhileReversing <= -this.gamepanel.getWidth()) {
					isFish2MovingBack = false;
					isFish2ReversingBack = true;
				}
			
			} else if(isFish2ReversingBack) {
				fish2XWhileReversing += 4;
				fish2X -= 1;
				fish2Y += 1;
				
				if(fish2X <= (fish2XWhileReversing - 30)) {
					isFish2ReversingBack = false;
					isFish2MovingFront = false;
				}
			}
			
		}

		/**
		 * 
		 */
		private void fish1Movement() {
			if(!isFish1MovingFront) {
				fish1X += 2;
				fish1XWhileReversing += 2;
				
				if(fish1X >= this.gamepanel.getWidth()) {
					isFish1MovingFront = true;
					isFish1Reversing = true;
				}
				
			} else if(isFish1Reversing) {
				fish1X += 4;
				fish1XWhileReversing -= 1;
				fish1Y -= 1;
				if(fish1X  >= (fish1XWhileReversing + 310)) {
					isFish1Reversing = false;
					isFish1MovingBack = true;
				}
				
			} else if(isFish1MovingBack) {
				fish1X -= 2;
				fish1XWhileReversing -= 2;
				
				if(fish1XWhileReversing <= -this.gamepanel.getWidth()) {
					isFish1MovingBack = false;
					isFish1ReversingBack = true;
				}
			
			} else if(isFish1ReversingBack) {
				fish1XWhileReversing += 4;
				fish1X -= 1;
				fish1Y += 1;
				
				if(fish1X <= (fish1XWhileReversing - 50)) {
					isFish1ReversingBack = false;
					isFish1MovingFront = false;
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevels(Canvas canvas) {
			if(Constants.LEVEL_ONE_NAME.equals(this.levelName)) {
				drawLevel1(canvas);
			} else if(Constants.LEVEL_THREE_NAME.equals(this.levelName)) {
				
				drawLevel3(canvas);
			} else if(Constants.LEVEL_TWO_NAME.equals(this.levelName)) {
			
			drawLevel2(canvas);
			} else if(Constants.LEVEL_FOUR_NAME.equals(this.levelName)) {
			
				drawLevel4(canvas);
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel1(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				((Pillar)pillarTempObj).draw(canvas);
				
				if(this.levelType.equals(Constants.SUB_LEVEL_TEN_NAME)) {
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() - 90, this.destPillar.getY() - 30);
					pillarLeft.draw(canvas);
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() + 130, this.destPillar.getY() - 60);
					pillarLeft.draw(canvas);
					
					indicatingArrow.setX(this.destPillar.getX()- indicatingArrow.getBitmapImage().getWidth()/2);
					indicatingArrow.setY(this.destPillar.getY()-this.destPillar.getBitmapImage().getHeight()/2 + radius);
					indicatingArrow.draw(canvas);
				}
				
				if(this.levelType.equals(Constants.SUB_LEVEL_ELEVEN_NAME)) {
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() - 130, this.destPillar.getY() - 40);
					pillarLeft.draw(canvas);
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() + 90, this.destPillar.getY() - 30);
					pillarLeft.draw(canvas);
					
					indicatingArrow.setX(this.destPillar.getX()- indicatingArrow.getBitmapImage().getWidth()/2);
					indicatingArrow.setY(this.destPillar.getY()-this.destPillar.getBitmapImage().getHeight()/2  + radius);
					indicatingArrow.draw(canvas);
				}
				
				if(this.levelType.equals(Constants.SUB_LEVEL_TWELVE_NAME)) {
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() - 130, this.destPillar.getY() - 40);
					pillarLeft.draw(canvas);
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() - 130 - this.destPillar.getBitmapImage().getWidth() + 10, this.destPillar.getY() - 50);
					pillarLeft.draw(canvas);
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() + 90, this.destPillar.getY() - 30);
					pillarLeft.draw(canvas);
					pillarLeft = new Pillar(this.theme.getPillarBitmap(), this.destPillar.getX() + 90 + this.destPillar.getBitmapImage().getWidth() + 10 , this.destPillar.getY() - 40);
					pillarLeft.draw(canvas);
					
					indicatingArrow.setX(this.destPillar.getX()- indicatingArrow.getBitmapImage().getWidth()/2);
					indicatingArrow.setY(this.destPillar.getY()-this.destPillar.getBitmapImage().getHeight()/2 + radius);
					indicatingArrow.draw(canvas);
				}
				
				
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3(Canvas canvas) {
			if(this.levelType.equals(Constants.SUB_LEVEL_FOUR_NAME)) {
				drawLevel3_4(canvas);
			} else if(this.levelType.equals(Constants.SUB_LEVEL_FIVE_NAME)) {
				drawLevel3_5(canvas);
			} else if(this.levelType.equals(Constants.SUB_LEVEL_SIX_NAME)) {
				drawLevel3_6(canvas);
			}  else if(this.levelType.equals(Constants.SUB_LEVEL_SEVEN_NAME)) {
				drawLevel3_7(canvas);
			}   else if(this.levelType.equals(Constants.SUB_LEVEL_EIGHT_NAME)) {
				drawLevel3_8(canvas);
			} else {
				drawLevel3_default(canvas);
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2(Canvas canvas) {
			if(this.levelType.equals(Constants.SUB_LEVEL_FOUR_NAME)) {
				drawLevel2_4(canvas);
			} else if(this.levelType.equals(Constants.SUB_LEVEL_FIVE_NAME)) {
				drawLevel2_5(canvas);
			} else if(this.levelType.equals(Constants.SUB_LEVEL_SIX_NAME)) {
				drawLevel2_6(canvas);
			}  else if(this.levelType.equals(Constants.SUB_LEVEL_SEVEN_NAME)) {
				drawLevel2_7(canvas);
			}   else if(this.levelType.equals(Constants.SUB_LEVEL_EIGHT_NAME)) {
				drawLevel2_8(canvas);
			} else {
				drawLevel2_default(canvas);
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4(Canvas canvas) {
			if(this.levelType.equals(Constants.SUB_LEVEL_THREE_NAME)) {

				drawLevel4_3(canvas);
			
			} else if(this.levelType.equals(Constants.SUB_LEVEL_FOUR_NAME)) {

				drawLevel4_4(canvas);

			} else if(this.levelType.equals(Constants.SUB_LEVEL_FIVE_NAME)) {

				drawLevel4_5(canvas);

			} else if(this.levelType.equals(Constants.SUB_LEVEL_SIX_NAME)) {

				drawLevel4_6(canvas);

			} else if(this.levelType.equals(Constants.SUB_LEVEL_SEVEN_NAME)) {

				drawLevel4_7(canvas);

			} else if(this.levelType.equals(Constants.SUB_LEVEL_EIGHT_NAME)) {

				drawLevel4_8(canvas);

			} else {
				drawLevel4_default(canvas);
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_default(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(60, 60)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
					if (((Pillar) pillarTempObj).isMovingUp()) {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(--count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								- rand);
						((Pillar) pillarTempObj).draw(canvas);

						if (count < 0) {
							((Pillar) pillarTempObj).setMovingUp(false);
						}

						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(++count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								+ rand);
						((Pillar) pillarTempObj).draw(canvas);
						if (count > GameUtil.randInt(30, 60)) {
							((Pillar) pillarTempObj).setMovingUp(true);
						}
						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}
				}  else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_8(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 175)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					}

				} if (pillatTemp.equals(this.srcPillar)) {
					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 75)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					} 
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_7(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(50, 50)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (pillatTemp.equals(this.destPillar)) {
					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 75)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					} 
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_6(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 75)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (pillatTemp.equals(this.destPillar)) {
					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 125)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					} 
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_5(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(50, 50)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (pillatTemp.equals(this.srcPillar)) {
					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(75, 75)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					} 
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_4(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(50, 50)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (pillatTemp.equals(this.srcPillar)) {
					if(pillatTemp.isMovingBackward()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingBackward(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setX(pillatTemp.getX() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(100, 100)) {
							pillatTemp.setMovingBackward(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setX(this.ball.getX() + rand);
						}
					} 
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel4_3(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(2, 2);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(50, 50)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
					if (((Pillar) pillarTempObj).isMovingUp()) {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(--count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								- rand);
						((Pillar) pillarTempObj).draw(canvas);

						if (count < 0) {
							((Pillar) pillarTempObj).setMovingUp(false);
						}

						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(++count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								+ rand);
						((Pillar) pillarTempObj).draw(canvas);
						if (count > GameUtil.randInt(30, 60)) {
							((Pillar) pillarTempObj).setMovingUp(true);
						}
						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}
				}  else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_default(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {


					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(60, 60)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}

				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_8(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(80, 100)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_7(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(130, 130)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_6(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(150, 150)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_5(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(45, 45)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel2_4(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.destPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(1, 1);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(1, 1);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(60, 60)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_default(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
					if (((Pillar) pillarTempObj).isMovingUp()) {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(--count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								- rand);
						((Pillar) pillarTempObj).draw(canvas);

						if (count < 0) {
							((Pillar) pillarTempObj).setMovingUp(false);
						}

						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = ((Pillar) pillarTempObj).getCount();
						((Pillar) pillarTempObj).setCount(++count);

						int rand = GameUtil.randInt(1, 4);
						((Pillar) pillarTempObj)
						.setY(((Pillar) pillarTempObj).getY()
								+ rand);
						((Pillar) pillarTempObj).draw(canvas);
						if (count > GameUtil.randInt(30, 60)) {
							((Pillar) pillarTempObj).setMovingUp(true);
						}
						if (((Pillar) pillarTempObj).equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					}
				} else {
					((Pillar)pillarTempObj).draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_8(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {

					if (pillatTemp.isMovingUp()) {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(--count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY()
								- rand);
						pillatTemp.draw(canvas);

						if (count < 0) {
							pillatTemp.setMovingUp(false);
						}

						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() - rand);
						}
					} else {
						int count = pillatTemp.getCount();
						pillatTemp.setCount(++count);

						int rand = GameUtil.randInt(1, 1);
						pillatTemp.setY(pillatTemp.getY() + rand);
						pillatTemp.draw(canvas);
						if (count > GameUtil.randInt(80, 100)) {
							pillatTemp.setMovingUp(true);
						}
						if (pillatTemp.equals(this.srcPillar)) {
							this.ball.setY(this.ball.getY() + rand);
						}
					
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_7(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(130, 130)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_6(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(150, 150)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_5(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(2, 2);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(45, 45)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}


		/**
		 * @param canvas
		 */
		private void drawLevel3_4(Canvas canvas) {
			for(Object pillarTempObj : pillars.toArray()) {
				Pillar pillatTemp = ((Pillar) pillarTempObj);
				if (pillatTemp.equals(this.srcPillar)) {

						if(pillatTemp.isMovingBackward()) {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(--count);

							int rand = GameUtil.randInt(1, 1);
							pillatTemp.setX(pillatTemp.getX()
									- rand);
							pillatTemp.draw(canvas);

							if (count < 0) {
								pillatTemp.setMovingBackward(false);
							}

							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() - rand);
							}
						} else {
							int count = pillatTemp.getCount();
							pillatTemp.setCount(++count);

							int rand = GameUtil.randInt(1, 1);
							pillatTemp.setX(pillatTemp.getX() + rand);
							pillatTemp.draw(canvas);
							if (count > GameUtil.randInt(60, 60)) {
								pillatTemp.setMovingBackward(true);
							}
							if (pillatTemp.equals(this.srcPillar)) {
								this.ball.setX(this.ball.getX() + rand);
							}
						
					}
				} else {
					pillatTemp.draw(canvas);
				}
			}
		}
		
		public void update() {
			System.out.println("updating ball");
			this.ball.update();
		}
		
		public void updateLevelGameStat() {
			this.levelGameStatPortion.getLevelDiamond().setDiamondCount(levelGameStat.getDiamondCount());
			this.levelGameStatPortion.getLevelDoubleDiamond().setDoubleDiamondCount(levelGameStat.getDoubleDiamondCount());
			this.levelGameStatPortion.getLevelScore().setScore(levelGameStat.getScore());
			
			this.increasingCount.getTextPaint().setTextSize(2);
			this.increasingCount.setX(this.srcPillar.getX() - this.srcPillar.getBitmapImage().getWidth());
			this.increasingCount.setY(this.srcPillar.getY() - 50);
			this.increasingCount.getTextPaint().setAlpha(255);
		}
		
		public void updateLevelGameStatAfterRecovery() {
			this.levelGameStatPortion.getLevelDiamond().setDiamondCount(levelGameStat.getDiamondCount());
			this.levelGameStatPortion.getLevelDoubleDiamond().setDoubleDiamondCount(levelGameStat.getDoubleDiamondCount());
			this.levelGameStatPortion.getLevelScore().setScore(levelGameStat.getScore());
			
			this.gameOverConfirmationPanel.setLevelGameStat(levelGameStat);
			
		}
		
		
		public void handleActionDown(int eventX, int eventY) {
			System.out.println("inside level click");
			
			if(gameOver) {

				gameOverConfirmationPanel.handleActionDown(eventX, eventY);
			} else {
				for(Pillar pillarTemp : pillars) {
					pillarTemp.handleActionDown(eventX, eventY);
				 }
				
			}
			
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
		 * @return the theme
		 */
		public Theme getTheme() {
			return theme;
		}


		/**
		 * @param theme the theme to set
		 */
		public void setTheme(Theme theme) {
			this.theme = theme;
			
			this.backgroundImageBitmap = this.theme.getBackgroundImageBitmap();
			this.ballBitmap = this.theme.getBallBitmap();
			this.pillarBitmap = this.theme.getPillarBitmap();
			
			this.bg2 = new Background(backgroundImageBitmap,1024, 0);
			this.bg1 = new Background(backgroundImageBitmap,0, 0);

			if(this.ball!=null) {
				ball.setBitmapImage(ballBitmap);
				ball.setX(srcPillar.getX()-(ball.getWidth()/2));
				ball.setY(srcPillar.getY()-ball.getHeight());
			}
			if(pillars!=null) {
				for(Object pillarTempObj : pillars.toArray()) {
					((Pillar)pillarTempObj).setBitmapImage(pillarBitmap);
					
				}
			}
			
			
			
		}


		/**
		 * @return the background
		 */
		public Background getBackground() {
			return background;
		}
		/**
		 * @param background the background to set
		 */
		public void setBackground(Background background) {
			this.background = background;
		}
		/**
		 * @return the srcPillar
		 */
		public Pillar getSrcPillar() {
			return srcPillar;
		}
		/**
		 * @param srcPillar the srcPillar to set
		 */
		public void setSrcPillar(Pillar srcPillar) {
			this.srcPillar = srcPillar;
			
			
		}
		/**
		 * @return the destPillar
		 */
		public Pillar getDestPillar() {
			return destPillar;
		}
		/**
		 * @param destPillar the destPillar to set
		 */
		public void setDestPillar(Pillar destPillar) {
			this.destPillar = destPillar;
		}
		/**
		 * @return the pillars
		 */
		public ArrayList<Pillar> getPillars() {
			return pillars;
		}
		/**
		 * @param pillars the pillars to set
		 */
		public void setPillars(ArrayList<Pillar> pillars) {
			this.pillars = pillars;
		}
		/**
		 * @return the ball
		 */
		public Ball getBall() {
			return ball;
		}
		/**
		 * @param ball the ball to set
		 */
		public void setBall(Ball ball) {
			this.ball = ball;
		}
		/**
		 * @return the gameStat
		 */
		public GameStats getGameStat() {
			return gameStat;
		}
		/**
		 * @param gameStat the gameStat to set
		 */
		public void setGameStat(GameStats gameStat) {
			this.gameStat = gameStat;
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
		 * @return the ballPath
		 */
		public BallPath getBallPath() {
			return ballPath;
		}


		/**
		 * @param ballPath the ballPath to set
		 */
		public void setBallPath(BallPath ballPath) {
			this.ballPath = ballPath;
		}


		/**
		 * @return the gamepanel
		 */
		public JumpAndBalanceGamePanel getGamepanel() {
			return gamepanel;
		}


		/**
		 * @param gamepanel the gamepanel to set
		 */
		public void setGamepanel(JumpAndBalanceGamePanel gamepanel) {
			this.gamepanel = gamepanel;
		}


		/**
		 * @return the pillarBitmap
		 */
		public Bitmap getPillarBitmap() {
			return pillarBitmap;
		}


		/**
		 * @param pillarBitmap the pillarBitmap to set
		 */
		public void setPillarBitmap(Bitmap pillarBitmap) {
			this.pillarBitmap = pillarBitmap;
		}


		/**
		 * @return the ballBitmap
		 */
		public Bitmap getBallBitmap() {
			return ballBitmap;
		}


		/**
		 * @param ballBitmap the ballBitmap to set
		 */
		public void setBallBitmap(Bitmap ballBitmap) {
			this.ballBitmap = ballBitmap;
		}


		/**
		 * @return the levelType
		 */
		public String getLevelType() {
			return levelType;
		}


		/**
		 * @param levelType the levelType to set
		 */
		public void setLevelType(String levelType) {
			this.levelType = levelType;
		}


		/**
		 * @return the levelClearedInfo
		 */
		public LevelClearedInfo getLevelClearedInfo() {
			return levelClearedInfo;
		}


		/**
		 * @param levelClearedInfo the levelClearedInfo to set
		 */
		public void setLevelClearedInfo(LevelClearedInfo levelClearedInfo) {
			this.levelClearedInfo = levelClearedInfo;
		}


		/**
		 * @return the themePanel
		 */
		public ThemePanel getThemePanel() {
			return themePanel;
		}


		/**
		 * @param themePanel the themePanel to set
		 */
		public void setThemePanel(ThemePanel themePanel) {
			this.themePanel = themePanel;
		}


		/**
		 * @return the canInitialiseForReplay
		 */
		public boolean isCanInitialiseForReplay() {
			return canInitialiseForReplay;
		}


		/**
		 * @param canInitialiseForReplay the canInitialiseForReplay to set
		 */
		public void setCanInitialiseForReplay(boolean canInitialiseForReplay) {
			this.canInitialiseForReplay = canInitialiseForReplay;
		}


		/**
		 * @return the isRainingTheme
		 */
		public boolean isRainingTheme() {
			return isRainingTheme;
		}


		/**
		 * @param isRainingTheme the isRainingTheme to set
		 */
		public void setRainingTheme(boolean isRainingTheme) {
			this.isRainingTheme = isRainingTheme;
		}


		/**
		 * @return the initialisingLevel
		 */
		public boolean isInitialisingLevel() {
			return initialisingLevel;
		}


		/**
		 * @param initialisingLevel the initialisingLevel to set
		 */
		public void setInitialisingLevel(boolean initialisingLevel) {
			this.initialisingLevel = initialisingLevel;
		}


		/**
		 * @return the diamondsInLevel
		 */
		public ArrayList<LevelDiamond> getDiamondsInLevel() {
			return diamondsInLevel;
		}


		/**
		 * @param diamondsInLevel the diamondsInLevel to set
		 */
		public void setDiamondsInLevel(ArrayList<LevelDiamond> diamondsInLevel) {
			this.diamondsInLevel = diamondsInLevel;
		}


}