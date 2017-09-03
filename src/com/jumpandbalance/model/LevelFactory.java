/**
 * 
 */
package com.jumpandbalance.model;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.jumpandbalance.R;
import com.jumpandbalance.actors.Level;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.interfaces.FactoryProducer;
import com.jumpandbalance.interfaces.Theme;
import com.jumpandbalance.theme.LevelTheme;
import com.jumpandbalance.theme.ThemeFactory;
import com.jumpandbalance.theme.ThemeOne;
import com.jumpandbalance.theme.ThemeThree;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Priya
 *
 */
public class LevelFactory extends FactoryProducer{

	private Context context;
	private JumpAndBalanceGamePanel gamePanel;
	private Theme defaultTheme;
	
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

	public LevelFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public LevelFactory(Context context, JumpAndBalanceGamePanel gamePanel) {
		this.context = context;
		this.gamePanel = gamePanel;
		
		this.defaultTheme = ThemeFactory.getInstance(context).getTheme(Constants.THEME_ONE);
	}
	@Override
	public Level getLevel(String levelName, String type) {
		// TODO Auto-generated method stub
		if(levelName.equals(Constants.LEVEL_ONE_NAME)) {
			return getLevel1(levelName, type);
		} else if(levelName.equals(Constants.LEVEL_TWO_NAME)) {
			return getLevel2(levelName, type);
		} else if(levelName.equals(Constants.LEVEL_THREE_NAME)) {
			return getLevel3(levelName, type);
		} else if(levelName.equals(Constants.LEVEL_FOUR_NAME)) {
			return getLevel4(levelName, type);
		}
		return null;
	}
	
	private Level getLevel1(String levelname, String levelType) {
		Level level1 = new Level(this.context, this.gamePanel);
		//theme 1
		level1.setLevelType(levelType);
		level1.setTheme(this.defaultTheme);
		level1.setLevelName(levelname);
		level1.setIndex(0);
		return level1;
	}
	
	private Level getLevel2(String levelname, String levelType) {
		Level level2 = new Level(this.context, this.gamePanel);
		
		level2.setLevelType(levelType);
		level2.setTheme(this.defaultTheme);
		level2.setLevelName(levelname);
		level2.setIndex(1);
		
		return level2;
	}
	
	private Level getLevel3(String levelname, String levelType) {
		Level level3 = new Level(this.context, this.gamePanel);
		
		level3.setLevelType(levelType);
		level3.setTheme(this.defaultTheme);
		level3.setLevelName(levelname);
		level3.setIndex(2);
		return level3;
	}
	
	private Level getLevel4(String levelname, String levelType) {
		Level level4 = new Level(this.context, this.gamePanel);
		
		level4.setLevelType(levelType);
		level4.setTheme(this.defaultTheme);
		level4.setLevelName(levelname);
		level4.setIndex(3);
		return level4;
	}
	
}
