package com.jumpandbalance;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jumpandbalance.actors.ThemeRequest;
import com.jumpandbalance.gamedata.GameData;
import com.jumpandbalance.gamedata.GameDataHelper;
import com.jumpandbalance.gamedata.GameStatData;
import com.jumpandbalance.gamedata.HomePanelData;
import com.jumpandbalance.gamedata.LevelData;
import com.jumpandbalance.gamedata.LevelInfoData;
import com.jumpandbalance.model.LevelInfo;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.LevelPanel;
//import com.jumpandbalance.gamedata.GameDataHelper;



public class MainActivity extends Activity {

	public static JumpAndBalanceGamePanel gamePanel;
	public static GameData restoredGameData;
	public static Context applicationContext;
	public static MediaPlayer mplayer;
	public static boolean running;
	private ProgressBar progressBar;
	
	private ImageView homeImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_main);
		applicationContext = getApplicationContext();
		gamePanel = new JumpAndBalanceGamePanel(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		System.out.println("Destroying");
		System.out.println("screen reset music called");
		MainActivity.mplayer.stop();
		MainActivity.mplayer.release();
		super.onDestroy();
	}
	
	@Override
	protected void onStop() {
		System.out.println("Stopping");
		super.onStop();
	}

	@Override
	protected void onPause() {
		System.out.println("Pausing");
		if(mplayer!=null) {
			mplayer.pause();
		}
		
		/*GameData gameData = prepareGameData();
		GameDataHelper.saveGameData(gameData, getApplicationContext());*/
		
		
		super.onPause();
	}

	/**
	 * @return
	 */
	public static GameData prepareGameData() {
		GameData gameData = new GameData();
		
		HomePanelData homePanelData = new HomePanelData();
		if(gamePanel!=null) {
			if(gamePanel.getHomePanel()!=null) {
				if(gamePanel.getHomePanel().getLevelInfoList()!=null) {
					ArrayList<LevelInfo> levelInfoList = gamePanel.getHomePanel().getLevelInfoList();
					ArrayList<LevelInfoData> levelInfoDataList = new ArrayList<LevelInfoData>();
					
					LevelInfoData levelInfoData = null;
					for(LevelInfo levelInfo : levelInfoList) {
						levelInfoData = new LevelInfoData();
						if(levelInfo!=null) {
							if(levelInfo.getLevelName()!=null) {
								levelInfoData.setLevelName(levelInfo.getLevelName());
							}
							
							levelInfoData.setLocked(levelInfo.isLocked());
							
							if(levelInfo.getAssociatedLevelListPanel()!=null) {
								if(levelInfo.getAssociatedLevelListPanel().getLevelList()!=null) {
									ArrayList<LevelPanel> levelPanels = levelInfo.getAssociatedLevelListPanel().getLevelList();
									
									ArrayList<LevelData> levelDataList = new ArrayList<LevelData>();
									
									LevelData levelData = null;
									for(LevelPanel levelPanel : levelPanels) {
										if(levelPanel!=null) {
											levelData = new LevelData();
											if(levelPanel.getAssociatedLevel()!=null) {
												if(levelPanel.getAssociatedLevel().getLevelName()!=null) {
													levelData.setLevelName(levelPanel.getAssociatedLevel().getLevelName());
												}
												if(levelPanel.getAssociatedLevel().getLevelType()!=null) {
													levelData.setLevelType(levelPanel.getAssociatedLevel().getLevelType());
													
												}
												if(levelPanel.getAssociatedLevel().getSrcPillar()!=null) {
													levelData.setSrcPillarIndex(levelPanel.getAssociatedLevel().getSrcPillar().getIndex());
												}
												if(levelPanel.getAssociatedLevel().getDestPillar()!=null) {
													levelData.setDestPillarIndex(levelPanel.getAssociatedLevel().getDestPillar().getIndex());
												}
												if(levelPanel.getAssociatedLevel().getGameStat()!=null) {
													GameStatData levelStatData = new GameStatData();
													levelStatData.setScore(levelPanel.getAssociatedLevel().getLevelGameStat().getScore());
													levelStatData.setStarCount(levelPanel.getAssociatedLevel().getLevelGameStat().getStarCount());
													levelStatData.setDiamondCount(levelPanel.getAssociatedLevel().getLevelGameStat().getDiamondCount());
													levelStatData.setDoubleDiamondCount(levelPanel.getAssociatedLevel().getLevelGameStat().getDoubleDiamondCount());
													levelData.setLevelStatData(levelStatData);
												}
												
												if(levelPanel.getAssociatedLevel().isGameOver()) {
													levelData.setNoOfPillarsCrossed(1);
												}
											}
											levelData.setLocked(levelPanel.isLocked());
											
											//to edit
											
											
											levelData.setThemeType(1);
											
											levelDataList.add(levelData);
										}
									}
									levelInfoData.setLevelDataList(levelDataList);
									
									
								}
								
								if(levelInfo.getLevelGameStat()!=null) {
									GameStatData levelStatData = new GameStatData();
									levelStatData.setScore(levelInfo.getLevelGameStat().getScore());
									levelStatData.setStarCount(levelInfo.getLevelGameStat().getStarCount());
									levelStatData.setDiamondCount(levelInfo.getLevelGameStat().getDiamondCount());
									levelStatData.setDoubleDiamondCount(levelInfo.getLevelGameStat().getDoubleDiamondCount());
									levelInfoData.setGameData(levelStatData);
								}
							}
							levelInfoDataList.add(levelInfoData);
						}
					}
					
					homePanelData.setLevelInfoDataList(levelInfoDataList);
					gameData.setHomePanelData(homePanelData);
					
				}
			}
		}
		LevelData onGoingLevelData = new LevelData();
		
		if(gamePanel.getOngoingLevel()!=null) {
			onGoingLevelData.setLevelName(gamePanel.getOngoingLevel().getLevelName());
			onGoingLevelData.setLevelType(gamePanel.getOngoingLevel().getLevelType());
			
			if(gamePanel.getCurrentLevel()!=null) {
				onGoingLevelData.setLocked(gamePanel.getCurrentLevel().isLocked());
			}
			
			//to edit
			onGoingLevelData.setNoOfPillarsCrossed(0);
			onGoingLevelData.setThemeType(1);
			
			onGoingLevelData.setSrcPillarIndex(gamePanel.getOngoingLevel().getSrcPillar().getIndex());
			onGoingLevelData.setDestPillarIndex(gamePanel.getOngoingLevel().getDestPillar().getIndex());
			
			
			gameData.setOnGoingLevelData(onGoingLevelData);
		}
		return gameData;
	}
	
	@Override
	protected void onResume() {
		System.out.println("resuming");
		
		
		
		
		super.onResume();
	}
	
	@Override
	protected void onPostResume() {
		System.out.println("On post resume");
		super.onPostResume();
	}
	
	@Override
	protected void onStart() {
		System.out.println("Starting");
		
		applicationContext = getApplicationContext();
		gamePanel = new JumpAndBalanceGamePanel(this);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		

		setContentView(R.layout.activity_main);
		homeImage = (ImageView)findViewById(R.id.imageHome);
		
		progressBar = (ProgressBar)findViewById(R.id.progressBarGreen);

		int i = 0;
		int j = 40;
		int k = 0;
    	
	//	progressBar.setProgress(30);
		
		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	progressBar.setProgress(30);
            }
        }, 1000);
		
		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	progressBar.setProgress(50);
            }
        }, 2000);
		
		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	progressBar.setProgress(80);
            }
        }, 3000);
		

    	
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		new Handler().postDelayed(new Runnable() {
			 
           
            @Override
            public void run() {
            	
            	setContentView(gamePanel);
            	
        		
            }
        }, 4000);
		
    	
		super.onStart();
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		System.out.println("On ost create");
		super.onPostCreate(savedInstanceState);
	}
	
	@Override
	protected void onRestart() {
		System.out.println("On restart");
		super.onRestart();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	//	super.onBackPressed();
		gamePanel.setAlphaCount(255);
		if(gamePanel!=null) {
			if(gamePanel.isSubLevelSelected() && !gamePanel.isHomePanel() && !gamePanel.isLevelPanel()) {
				if(ThemeRequest.isRequested) {
					ThemeRequest.isRequested = false;
					gamePanel.getOngoingLevel().getThemePanel().updateThemePanelExit();
					gamePanel.getOngoingLevel().getThemePanel().initilizeThemePanel();
					
				} else {
					gamePanel.setLevelPanel(true);
					gamePanel.setSubLevelSelected(false);
					JumpAndBalanceGamePanel.isRestored = true;
				}
				
			} else if(!gamePanel.isSubLevelSelected() && !gamePanel.isHomePanel() && gamePanel.isLevelPanel()) {
				gamePanel.setHomePanel(true);
				gamePanel.setLevelPanel(false);
			} else if(!gamePanel.isSubLevelSelected() && gamePanel.isHomePanel() && !gamePanel.isLevelPanel()) {
				super.onBackPressed();
			}
		}
		
		
	}
	
	
	
}
