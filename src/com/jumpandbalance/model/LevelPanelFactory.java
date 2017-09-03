/**
 * 
 */
package com.jumpandbalance.model;

import android.content.Context;

import com.jumpandbalance.interfaces.FactoryProducer;
import com.jumpandbalance.view.HomePanel;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;
import com.jumpandbalance.view.LevelPanel;

/**
 * @author Priya
 *
 */
public class LevelPanelFactory extends FactoryProducer{

	private Context context;
	private HomePanel homePanel;
	
	
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

	public LevelPanelFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public LevelPanelFactory(Context context, HomePanel homePanel) {
		this.context = context;
		this.homePanel = homePanel;
	}
	
	@Override
	public LevelPanel getLevelPanel(String levelName) {
		// TODO Auto-generated method stub
		
		LevelPanel levelPanel = new LevelPanel(this.context, this.homePanel);
		
		levelPanel.setLevelName(levelName);
		
		return levelPanel;
		
	}
	
	
	
}
