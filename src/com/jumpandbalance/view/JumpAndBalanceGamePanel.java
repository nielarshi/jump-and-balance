/**
 * 
 */
package com.jumpandbalance.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnLongClickListener;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.actors.BackButton;
import com.jumpandbalance.actors.HelpButton;
import com.jumpandbalance.actors.HelpModeButton;
import com.jumpandbalance.actors.HelpModeDone;
import com.jumpandbalance.actors.HomeButton;
import com.jumpandbalance.actors.Level;
import com.jumpandbalance.actors.MusicButton;
import com.jumpandbalance.actors.ReloadButton;
import com.jumpandbalance.actors.ThemeRequest;
import com.jumpandbalance.gamedata.GameData;
import com.jumpandbalance.gamedata.GameDataHelper;
import com.jumpandbalance.gamedata.LevelData;
import com.jumpandbalance.gamedata.LevelInfoData;
import com.jumpandbalance.helper.Speed;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.model.LevelInfo;
import com.jumpandbalance.stat.LevelGameStat;
import com.jumpandbalance.thread.JumpAndBalanceGameThread;
import com.jumpandbalance.thread.JumpAndBalanceMusicThread;

/**
 * @author TCS
 *
 */
public class JumpAndBalanceGamePanel extends SurfaceView implements SurfaceHolder.Callback,OnLongClickListener{

	private JumpAndBalanceGameThread gameThread;
	
	public static JumpAndBalanceMusicThread musicThread;
	
	private HomePanel homePanel;
	private boolean isHomePanel;
	private boolean isLevelPanel;
	private boolean isLevelSelected;
	private LevelInfo currentMainLevel;
	private LevelPanel currentLevel;
	private LevelsPanel currentLevelPanel;
	private Level ongoingLevel;
	private boolean isSubLevelSelected;
	private LevelClearedInfo levelClearedInfo;
	private static float currentTimeInAir=0;
	private static Speed speed = new Speed();
	private int x, y;
	public static Context context;
	private Point[] points;
	private long touchStartTime;
	private long touchEventDuration;
	private Paint pointPaint;
	
	public static boolean isRestored;
	
	
	private long moveEventDuration;
	private float[] pts;

	public static boolean surfaceCreated;
	
	private int alphaCount = 255;

	private RectF loadRect;

	private Paint loadPaint;
	
	
	
	/**
	 * @return the isLevelSelected
	 */
	public boolean isLevelSelected() {
		return isLevelSelected;
	}

	/**
	 * @param isLevelSelected the isLevelSelected to set
	 */
	public void setLevelSelected(boolean isLevelSelected) {
		this.isLevelSelected = isLevelSelected;
	}

	/**
	 * @return the currentMainLevel
	 */
	public LevelInfo getCurrentMainLevel() {
		return currentMainLevel;
	}

	/**
	 * @param currentMainLevel the currentMainLevel to set
	 */
	public void setCurrentMainLevel(LevelInfo currentMainLevel) {
		this.currentMainLevel = currentMainLevel;
	}

	/**
	 * @return the currentLevelPanel
	 */
	public LevelsPanel getCurrentLevelPanel() {
		return currentLevelPanel;
	}

	/**
	 * @param currentLevelPanel the currentLevelPanel to set
	 */
	public void setCurrentLevelPanel(LevelsPanel currentLevelPanel) {
		this.currentLevelPanel = currentLevelPanel;
	}

	/**
	 * @return the isLevelPanel
	 */
	public boolean isLevelPanel() {
		return isLevelPanel;
	}

	/**
	 * @param isLevelPanel the isLevelPanel to set
	 */
	public void setLevelPanel(boolean isLevelPanel) {
		this.isLevelPanel = isLevelPanel;
	}

	/**
	 * @return the ongoingLevel
	 */
	public Level getOngoingLevel() {
		return ongoingLevel;
	}

	/**
	 * @param ongoingLevel the ongoingLevel to set
	 */
	public void setOngoingLevel(Level ongoingLevel) {
		this.ongoingLevel = ongoingLevel;
	}

	/**
	 * @return the gameThread
	 */
	public JumpAndBalanceGameThread getGameThread() {
		return gameThread;
	}

	/**
	 * @param gameThread the gameThread to set
	 */
	public void setGameThread(JumpAndBalanceGameThread gameThread) {
		this.gameThread = gameThread;
	}

	/**
	 * @return the homePanel
	 */
	public HomePanel getHomePanel() {
		return homePanel;
	}

	/**
	 * @param homePanel the homePanel to set
	 */
	public void setHomePanel(HomePanel homePanel) {
		this.homePanel = homePanel;
	}

	/**
	 * @return the isHomePanel
	 */
	public boolean isHomePanel() {
		return isHomePanel;
	}

	/**
	 * @param isHomePanel the isHomePanel to set
	 */
	public void setHomePanel(boolean isHomePanel) {
		this.isHomePanel = isHomePanel;
	}

	
	/**
	 * @return the currentLevel
	 */
	public LevelPanel getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(LevelPanel currentLevel) {
		this.currentLevel = currentLevel;
	}

	public JumpAndBalanceGamePanel(Context context) {
		super(context);
		
		//setting the current class as the handler for the events
		getHolder().addCallback(this);
		
		//making our Game Panel focusable
		setFocusable(true);
		
		gameThread = new JumpAndBalanceGameThread(getHolder(), this);
	
		musicThread = new JumpAndBalanceMusicThread(this);
		setBackgroundColor(Color.rgb(255, 204, 153));
		
		setOnLongClickListener(this);
		//bhavana
		//levelClearedInfo = new LevelClearedInfo();
		JumpAndBalanceGamePanel.context = getContext();
		
		
		pointPaint = new Paint();
	//	pointPaint.setColor(Color.GRAY);
		pointPaint.setStrokeWidth(5);
		pointPaint.setStyle(Style.FILL);
		pointPaint.setAntiAlias(true);
		pointPaint.setColor(0xFFFF0000);
	
		loadRect =  new RectF(0, 0, 2000, 2000);
		loadPaint = new Paint();
		loadPaint.setStrokeWidth(2.0f);
		loadPaint.setAntiAlias(true);
		loadPaint.setAlpha(100);
		loadPaint.setColor(Color.argb(0, 0, 0, 0));
	}

	
	private final int SCREEN_ONE = 1;
	private final int SCREEN_TWO = 2;
	private final int SCREEN_THREE = 3;
	private int currentScreen;
	private int previousScreen = 1;
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		touchEventDuration = event.getEventTime() - touchStartTime;
		
		
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			System.out.println("Clicked at "+ event.getX()+" , "+event.getY());
			
			if(isHomePanel) {
				if(this.homePanel!=null) {
					previousScreen = SCREEN_ONE;
					this.homePanel.handleActionDown((int)event.getX(), (int)event.getY());
					MusicButton.handleActionDown((int)event.getX(), (int)event.getY());
					
				}
				
			} else if(isLevelPanel) {
				if(this.currentLevelPanel!=null) {
					
					previousScreen = SCREEN_TWO;
					
					this.currentLevelPanel.handleActionDown((int)event.getX(), (int)event.getY());
					BackButton.handleActionDown((int)event.getX(), (int)event.getY());
					MusicButton.handleActionDown((int)event.getX(), (int)event.getY());
					
				}
		//		this.currentMainLevel.handleActionDown((int)event.getX(), (int)event.getY());
				
			} else if(isSubLevelSelected && this.ongoingLevel!=null) {
					previousScreen = SCREEN_THREE;
				
					System.out.println("level cleared info : "+LevelClearedInfo.cleared+", "+ThemeRequest.isRequested+", "+HelpButton.finished );
					if(LevelClearedInfo.cleared==true) {
						this.ongoingLevel.getLevelClearedInfo().handleActionDown((int)event.getX(), (int)event.getY());
					} else {
						if(ThemeRequest.isRequested) {
							this.ongoingLevel.getThemePanel().handleActionDown((int)event.getX(), (int)event.getY());
						}
						
						if(HelpButton.finished) {
							
							
							this.ongoingLevel.handleActionDown((int)event.getX(), (int)event.getY());
							
						} else {
							
							
							this.ongoingLevel.handleActionDown((int)event.getX(), (int)event.getY());
							HomeButton.handleActionDown((int)event.getX(), (int)event.getY());
							ThemeRequest.handleActionDown((int)event.getX(), (int)event.getY());
							HelpButton.handleActionDown((int)event.getX(), (int)event.getY());
							HelpModeButton.handleActionDown((int)event.getX(), (int)event.getY());
							HelpModeDone.handleActionDown((int)event.getX(), (int)event.getY());
							BackButton.handleActionDown((int)event.getX(), (int)event.getY());
							MusicButton.handleActionDown((int)event.getX(), (int)event.getY());
							ReloadButton.handleActionDown((int)event.getX(), (int)event.getY());
							touchStartTime = (long)event.getY()*10;
						}
						
					}
			} 
		} 
		if(event.getAction() == MotionEvent.ACTION_MOVE) {
			if(this.ongoingLevel!=null) {
				if(isSubLevelSelected) {
					
					if(this.ongoingLevel.getSrcPillar()!=null) {
						
						if(!this.ongoingLevel.getSrcPillar().isTouchInitiated()) {
							
						} else if(this.ongoingLevel.getSrcPillar().isTouchInitiated()) {
							moveEventDuration = (long)event.getY()*10 - touchStartTime;
							speed = new Speed();
							speed.setxVelocity(moveEventDuration/50);
							currentTimeInAir = 0;
							points = new Point[this.getWidth()];
							storePathPoints();
						} 
						
					}
				}
			}
			
		}
		if(event.getAction() == MotionEvent.ACTION_UP) {
			
			pts = new float[this.getWidth()];
			
			
			if(this.currentMainLevel!=null) {
				
				if(!isLevelPanel) {	
					if(!BackButton.homeClicked) {
						isHomePanel = false;
						isLevelPanel = true;
						
						currentScreen = SCREEN_TWO;
						
					} else {
						isHomePanel = true;
						currentScreen = SCREEN_ONE;

					}
				} else {
					
				//	isHomePanel = true;
					if(BackButton.homeClicked) {
						isLevelPanel = false;
						isHomePanel = true;
						
						currentScreen = SCREEN_ONE;
						
					}
				}
				
				System.out.println("Screen trans "+previousScreen+" --> "+currentScreen);
				if(previousScreen == 1 && currentScreen == 2) {
					resetMusic();
				}

			} else {
				System.out.println("Screen trans "+previousScreen+" --> "+currentScreen);
				if(previousScreen == 2 && currentScreen == 2) {
					resetMusic();
				}
				
				
			}
			
			if(this.ongoingLevel!=null) {
				
				currentScreen = SCREEN_THREE;
				
				if(!BackButton.clicked) {
					System.out.println("on mouse up inside back button not clicked");
					
					isLevelPanel = false;
					isSubLevelSelected = true;
					
					currentScreen = SCREEN_THREE;
					
			//		resetMusic();
				} else {
					System.out.println("on mouse up inside back button clicked");
					isLevelPanel = true;
					isSubLevelSelected = false;
					
					currentScreen = SCREEN_TWO;
			//		resetMusic();
				}
				
				System.out.println("Screen trans "+previousScreen+" --> "+currentScreen);
				if(previousScreen != currentScreen) {
					resetMusic();
				}
				
			}
			if(this.ongoingLevel!=null) {
				if(isSubLevelSelected) {
					if(this.ongoingLevel.getSrcPillar()!=null) {
						if(this.ongoingLevel.getSrcPillar().isTouchInitiated()) {
							touchEventDuration = event.getEventTime() - touchStartTime;
							
							this.ongoingLevel.getSrcPillar().setClickStartTime(event.getDownTime());
							long eventDuration = event.getEventTime() - event.getDownTime();
							System.out.println("clicked for (): "+eventDuration);
							this.ongoingLevel.getBall().setSpeed(new Speed());
							this.ongoingLevel.getBall().getSpeed().setxVelocity(moveEventDuration/50);
							this.ongoingLevel.getSrcPillar().setTouchInitiated(false);
							this.ongoingLevel.getSrcPillar().setTouchOver(true);
							if(this.ongoingLevel.getSrcPillar().isTouchOver()){
								this.ongoingLevel.getSrcPillar().setTouched(true);	
							}		
						}
					}
				}
			}
		}
		
		return super.onTouchEvent(event);
	}

	/**
	 * 
	 */
	public static void resetMusic() {
		System.out.println("screen reset music called");
		MainActivity.mplayer.stop();
		MainActivity.mplayer.release();
		
		musicThread.setRunning(true);
		musicThread.run();
	}
	
	 private void storePathPoints() {
        int i = 0;
        int j = 0;
        x = this.ongoingLevel.getBall().getX() + this.ongoingLevel.getBall().getWidth()/2;
        y = this.ongoingLevel.getBall().getY() + this.ongoingLevel.getBall().getHeight()/2;
        		
		while(y<this.getHeight()) { 
			speed.setyVelocity((float)(speed.getyVelocity()+( 0.5 * currentTimeInAir)));        // Apply gravity to vertical velocity
			x += speed.getxVelocity() * currentTimeInAir;      // Apply horizontal velocity to X position
			y += speed.getyVelocity() * currentTimeInAir;      // Apply vertical velocity to X position
 		
 		this.points[i] = new Point(x, y);
 		
 		this.pts[j++] = x;
 		this.pts[j++] = y;
 		
 		i++;
 		currentTimeInAir+=0.02;
		}
 		
     }
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		
		
		if(alphaCount>=0) {
			loadPaint.setColor(Color.argb(alphaCount, 0, 0, 0));
			
			canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), loadPaint);
			
		}
		
		if(isHomePanel) {
			
			
			homePanel.draw(canvas);
			
			this.ongoingLevel = null;
			BackButton.homeClicked = false;
		} else if(this.isLevelPanel){
			if(this.currentLevelPanel!=null) {
				System.out.println("drawing level panel");
				this.currentLevelPanel.draw(canvas);
			}
		} else if(this.isSubLevelSelected) {
			if(this.ongoingLevel!=null) {
				this.ongoingLevel.draw(canvas);
				
				if(this.ongoingLevel.getSrcPillar().isTouchInitiated()) {
					System.out.println("after drawing initiated");
					int j = 0;
					for(int x=30;x<280;x=x+2) {
						canvas.drawCircle(pts[x], pts[x+1], ((j/15)+1), pointPaint);
						j++;
						
						if(j>=100) {
							j--;
						}
					}
					
			//		canvas.drawPoints(pts, pointPaint);
				} else {
					x = this.ongoingLevel.getBall().getX();
					y = this.ongoingLevel.getBall().getY();
					currentTimeInAir = 0;
					speed = new Speed();
				}
				
				
			}
			
		}
		if(alphaCount>=0) {
			canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), loadPaint);
			loadPaint.setColor(Color.argb(alphaCount, 0, 0, 0));
			
			alphaCount -= 20;
		}
		
		
		super.onDraw(canvas);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
		System.out.println("surface : CHANGED ");
		
	//	isHomePanel = true;
		points = new Point[this.getWidth()];
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		System.out.println("surface : CREATED ");
		System.out.println(this.getHeight()+"==="+this.getWidth());
		
		homePanel = new HomePanel(getContext(), this);
		
		MainActivity.restoredGameData = GameDataHelper.restoreGameData(MainActivity.applicationContext);
		
		
		restoreGameData();
		System.out.println("surface created , game data restored");
		
		points = new Point[this.getWidth()];
		pts = new float[this.getWidth()];
		//start the thread
		gameThread.setRunning(true);
		gameThread.start();
		
		
		musicThread.setRunning(true);
		musicThread.start();
		

		surfaceCreated = true;
		
	}

	/**
	 * 
	 */
	public void restoreGameData() {
		if(MainActivity.restoredGameData!=null) {
			if(MainActivity.restoredGameData.getHomePanelData()!=null) {
				System.out.println(" surface restored game name : "+MainActivity.restoredGameData.getHomePanelData().getLevelInfoDataList().get(0).getLevelName());
				
			}
			if(MainActivity.restoredGameData.getOnGoingLevelData()!=null) {
				System.out.println("surface homepanel "+this.homePanel);
				if(this.homePanel!=null) {
					if(this.homePanel.getLevelInfoList()!=null) {
						ArrayList<LevelInfo> levelInfoList = this.homePanel.getLevelInfoList();
						
						ArrayList<LevelInfoData> levelInfoDatas = MainActivity.restoredGameData.getHomePanelData().getLevelInfoDataList(); 
						
						for(LevelInfo levelInfo : levelInfoList) {
							if(levelInfo.getAssociatedLevelListPanel()!=null) {
								
								if(levelInfo.getLevelName().equals(MainActivity.restoredGameData.getOnGoingLevelData().getLevelName())) {
									if(levelInfo.getAssociatedLevelListPanel().getLevelList()!=null) {
										ArrayList<LevelPanel> panels = levelInfo.getAssociatedLevelListPanel().getLevelList();
										for(LevelPanel levelPanel : panels) {
											if(levelPanel!=null) {
												if(levelPanel.getAssociatedLevel().getLevelType().equals(MainActivity.restoredGameData.getOnGoingLevelData().getLevelType())) {
													System.out
															.println("surface assigning level");
													this.ongoingLevel = levelPanel.getAssociatedLevel();
													
													this.currentLevel = levelPanel;
													this.currentLevelPanel = levelInfo.getAssociatedLevelListPanel();
													this.currentMainLevel = levelInfo;
													
													this.isHomePanel = false;
													this.isLevelPanel = true;
													this.isSubLevelSelected = false;
													isRestored = true;
													
													
												}
											}
											
											
										
										}
									}
								} 
								
								
								
								int index = levelInfoList.indexOf(levelInfo);
								
								if(levelInfoDatas.get(index)!=null) {
									if(levelInfoDatas.get(index).getGameData()!=null) {
										LevelGameStat levelGameStat = new LevelGameStat();
										levelGameStat.setScore(levelInfoDatas.get(index).getGameData().getScore());
										levelGameStat.setDiamondCount(levelInfoDatas.get(index).getGameData().getDiamondCount());
										levelGameStat.setStarCount(levelInfoDatas.get(index).getGameData().getStarCount());
										levelGameStat.setDoubleDiamondCount(levelInfoDatas.get(index).getGameData().getDoubleDiamondCount());
										levelInfo.setLevelGameStat(levelGameStat);
									}
									
									ArrayList<LevelData> levelDatas = levelInfoDatas.get(index).getLevelDataList();
									
									ArrayList<LevelPanel> levelPanels = levelInfo.getAssociatedLevelListPanel().getLevelList();
									
									if(levelPanels!=null) {
										
										for(LevelPanel levelPanel : levelPanels) {
											int indexOfLevelPanel = levelPanels.indexOf(levelPanel);
											if(levelPanel.getAssociatedLevel()!=null) {
												
												if(levelDatas.get(indexOfLevelPanel)!=null) {
													LevelData levelData = levelDatas.get(indexOfLevelPanel);
													LevelGameStat levelGameStat = new LevelGameStat();
													levelGameStat.setScore(levelData.getLevelStatData().getScore());
													levelGameStat.setStarCount(levelData.getLevelStatData().getStarCount());
													levelGameStat.setDiamondCount(levelData.getLevelStatData().getDiamondCount());
													levelGameStat.setDoubleDiamondCount(levelData.getLevelStatData().getDoubleDiamondCount());
													
													levelPanel.getAssociatedLevel().setLevelGameStat(levelGameStat);
													levelPanel.getAssociatedLevel().updateLevelGameStatAfterRecovery();
													
													if(levelData.getNoOfPillarsCrossed()==1) {
														levelPanel.getAssociatedLevel().setGameOver(true);
													}
													
												}
											}
										}
										
										levelInfo.updateLevelInfoGameStat();
										int scoreorDiamond = levelInfo.getLevelGameStat().getScore()%1000;
										levelInfo.setScoreorDiamond(scoreorDiamond);
										
									}
								}
							}
						}
					}
				}
			} else {
				this.isHomePanel = true;
			}
		} else {
			System.out.println("restored is null");
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasWindowFocus);
		System.out.println("surface : FOCUS "+hasWindowFocus);
		
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		System.out.println("surface : DESTROYED ");
		
	}

	public void update() {
		
		if(this.isSubLevelSelected) {
			this.ongoingLevel.update();
		}
	}
	
	public void updateBallPath() {
		System.out.println("game panel to be updated");
		
	}
	

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the isSubLevelSelected
	 */
	public boolean isSubLevelSelected() {
		return isSubLevelSelected;
	}

	/**
	 * @param isSubLevelSelected the isSubLevelSelected to set
	 */
	public void setSubLevelSelected(boolean isSubLevelSelected) {
		this.isSubLevelSelected = isSubLevelSelected;
	}

	/**
	 * @return the alphaCount
	 */
	public int getAlphaCount() {
		return alphaCount;
	}

	/**
	 * @param alphaCount the alphaCount to set
	 */
	public void setAlphaCount(int alphaCount) {
		this.alphaCount = alphaCount;
	}
	
	
}
