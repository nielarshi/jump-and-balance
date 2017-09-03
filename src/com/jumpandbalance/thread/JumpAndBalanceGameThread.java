/**
 * 
 */
package com.jumpandbalance.thread;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.SurfaceHolder;

import com.jumpandbalance.actors.HelpButton;
import com.jumpandbalance.helper.Speed;
import com.jumpandbalance.util.GameUtil;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author TCS
 *
 */
public class JumpAndBalanceGameThread extends Thread {

	private SurfaceHolder surfaceHolder;
	private JumpAndBalanceGamePanel gamePanel;
	private boolean running;
	
	
	/**
	 * @return the surfaceHolder
	 */
	public SurfaceHolder getSurfaceHolder() {
		return surfaceHolder;
	}

	/**
	 * @param surfaceHolder the surfaceHolder to set
	 */
	public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
		this.surfaceHolder = surfaceHolder;
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
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	public JumpAndBalanceGameThread(SurfaceHolder surfaceHolder, JumpAndBalanceGamePanel gamePanel) {
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//	super.run();
		System.out.println("Run called");
		long tickTime = 0L;
		Canvas canvas = null;
		while(running) {
			tickTime++;
			
			
			try {
				synchronized (surfaceHolder) {
					
					canvas = this.surfaceHolder.lockCanvas();
					/*if((this.gamePanel.getPillar().isTouchInitiated() && this.gamePanel.getPillar().getBall()!=null)) {
						System.out.println("ticktime initiated: "+tickTime);
						if(this.gamePanel.getHeight()<this.gamePanel.getBallPath().getY()) {
							this.gamePanel.getPillar().setTouchInitiated(false);
							
						}else{
							this.gamePanel.updateBallPath();
							this.gamePanel.postInvalidate();
							
						}
					}*/
					
					if(this.gamePanel.getOngoingLevel()!=null) {
						if(this.gamePanel.getOngoingLevel().getSrcPillar()!=null) {
							System.out.println("not null src");
							if(!HelpButton.clicked) {
								if(this.gamePanel.getOngoingLevel().getSrcPillar().isTouched()) {
									System.out.println("is touched src");
									this.gamePanel.update();
									this.gamePanel.postInvalidate();
								}
							}
							
						}
					}
					this.gamePanel.postInvalidate();
					
					
				}
				
			} 
			finally {
				if (canvas != null) {
					this.surfaceHolder.unlockCanvasAndPost(canvas);
				}
				
			}
			
		}
	
	}
}
