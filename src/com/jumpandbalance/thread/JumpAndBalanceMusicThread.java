package com.jumpandbalance.thread;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.R;
import com.jumpandbalance.actors.MusicButton;
import com.jumpandbalance.media.MediaHelper;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

public class JumpAndBalanceMusicThread extends Thread{

	private JumpAndBalanceGamePanel gamePanel;
	private boolean running;
	
	
	public JumpAndBalanceMusicThread(JumpAndBalanceGamePanel gamePanel) {
		this.gamePanel = gamePanel;
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
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//	super.run();
		
		
		while(running) {
			
			
			MainActivity.mplayer = null;
			
			if(this.gamePanel.isHomePanel()) {
				if(MainActivity.mplayer==null) {
					
					MainActivity.mplayer = MediaPlayer.create(JumpAndBalanceGamePanel.context, R.raw.hiphop1);
					MainActivity.mplayer.start();
					MainActivity.mplayer.setLooping(true);
					
					running = false;
				}
				
				
			}
			
			if(this.gamePanel.isLevelPanel()) {
				if(MainActivity.mplayer==null) {
					
					MainActivity.mplayer = MediaPlayer.create(JumpAndBalanceGamePanel.context, R.raw.hiphop2);
					MainActivity.mplayer.start();
					MainActivity.mplayer.setLooping(true);
					
					running = false;
				}
			}
			
			if(this.gamePanel.isSubLevelSelected()) {
				if(MainActivity.mplayer==null) {
					
					MainActivity.mplayer = MediaPlayer.create(JumpAndBalanceGamePanel.context, R.raw.hiphop3);
					MainActivity.mplayer.start();
					MainActivity.mplayer.setLooping(true);
					
					running = false;
				}
			}
			
			
			if(MusicButton.clicked) {
				if(MainActivity.mplayer!=null) {
					   if(MainActivity.mplayer.isPlaying()) {
						   MainActivity.mplayer.setVolume(0, 0);
					   }
				   }
				  
			} else {
				if(MainActivity.mplayer!=null) {
					   if(MainActivity.mplayer.isPlaying()) {
						   MainActivity.mplayer.setVolume(0, 1);
					   }
				   }
				  
			}
			
			
			
		}
		
		
	}
}
