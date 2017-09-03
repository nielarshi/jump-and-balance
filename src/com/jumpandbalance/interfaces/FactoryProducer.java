/**
 * 
 */
package com.jumpandbalance.interfaces;

import com.jumpandbalance.actors.Level;
import com.jumpandbalance.model.LevelInfo;
import com.jumpandbalance.view.LevelPanel;

/**
 * @author Priya
 *
 */
public abstract class FactoryProducer {

	public Theme getTheme(int type) {
		return null;
	}
	public Level getLevel(String levelName, String type) {
		return null;
	}
	public LevelPanel getLevelPanel(String levelName) {
		return null;
	}
	public LevelInfo getLevelInfo() {
		return null;
	}
}
