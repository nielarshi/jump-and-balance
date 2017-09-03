package com.jumpandbalance.model;

import com.jumpandbalance.actors.Level;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.view.LevelPanel;
import com.jumpandbalance.view.LevelsPanel;

public class LevelsPanelBuilder {

	LevelsPanel associatedLevelListPanel;
	LevelPanelFactory levelPanelFactory;
	
	public LevelsPanelBuilder() {
		
		
		
	}
	
	public LevelsPanel buildLevelsPanel(LevelInfo levelInfo) {
		
		associatedLevelListPanel = new LevelsPanel();
		levelPanelFactory = new LevelPanelFactory(levelInfo.getContext(), levelInfo.getHomepanel()); 
		
		
		if(levelInfo.getLevelName().equals(Constants.LEVEL_ONE_NAME)) {
			
			setLevelPanelForLevel1(levelInfo);
		} else if(levelInfo.getLevelName().equals(Constants.LEVEL_TWO_NAME)) {
			
			setLevelPanelForLevel2(levelInfo);
		} else if(levelInfo.getLevelName().equals(Constants.LEVEL_THREE_NAME)) {
			
			setLevelPanelForLevel3(levelInfo);
		} else if(levelInfo.getLevelName().equals(Constants.LEVEL_FOUR_NAME)) {
			
			setLevelPanelForLevel4(levelInfo);
		} 
		
		return associatedLevelListPanel;
	}

	private void setLevelPanelForLevel4(LevelInfo levelInfo) {

		// TODO Auto-generated method stub
		//level 1
				LevelPanel levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_ONE_NAME);
				levelPanel.setCordinates(500, 100);
				levelPanel.setLocked(false);
				
				LevelFactory levelFactory = new LevelFactory(levelInfo.getContext(), levelInfo.getGamePanel());
				
				Level level1 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level1.setNoOfPillars(6);
				
				levelPanel.setAssociatedLevel(level1);
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 2
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_TWO_NAME);
				levelPanel.setCordinates(620, 100);
				levelPanel.setLocked(false);
				
				Level level2 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level2.setNoOfPillars(9);
				
				levelPanel.setAssociatedLevel(level2);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
			
			//level 3
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_THREE_NAME);
				levelPanel.setCordinates(740, 100);
				levelPanel.setLocked(false);
				
				Level level3 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level3.setNoOfPillars(13);
				
				levelPanel.setAssociatedLevel(level3);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 4	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FOUR_NAME);
				levelPanel.setCordinates(500, 200);
				levelPanel.setLocked(false);
				
				Level level4 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level4.setNoOfPillars(16);
				
				levelPanel.setAssociatedLevel(level4);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 5	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FIVE_NAME);
				levelPanel.setCordinates(620, 200);
				levelPanel.setLocked(false);
				
				Level level5 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level5.setNoOfPillars(19);
				
				levelPanel.setAssociatedLevel(level5);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 6	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SIX_NAME);
				levelPanel.setCordinates(740, 200);
				levelPanel.setLocked(false);
				
				Level level6 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level6.setNoOfPillars(21);
				
				levelPanel.setAssociatedLevel(level6);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 7	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SEVEN_NAME);
				levelPanel.setCordinates(500, 300);
				levelPanel.setLocked(false);
				
				Level level7 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level7.setNoOfPillars(25);
				
				levelPanel.setAssociatedLevel(level7);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 8	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_EIGHT_NAME);
				levelPanel.setCordinates(620, 300);
				levelPanel.setLocked(false);
				
				Level level8 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level8.setNoOfPillars(29);
				
				levelPanel.setAssociatedLevel(level8);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
				//level 9	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_NINE_NAME);
				levelPanel.setCordinates(740, 300);
				levelPanel.setLocked(false);
				
				Level level9 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level9.setNoOfPillars(31);
				
				levelPanel.setAssociatedLevel(level9);
				levelPanel.setLocked(true);
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
	}

	private void setLevelPanelForLevel3(LevelInfo levelInfo) {
		// TODO Auto-generated method stub
		//level 1
				LevelPanel levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_ONE_NAME);
				levelPanel.setCordinates(500, 100);
				levelPanel.setLocked(false);
				
				LevelFactory levelFactory = new LevelFactory(levelInfo.getContext(), levelInfo.getGamePanel());
				
				Level level1 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level1.setNoOfPillars(11);
				
				levelPanel.setAssociatedLevel(level1);
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 2
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_TWO_NAME);
				levelPanel.setCordinates(620, 100);
				levelPanel.setLocked(false);
				
				Level level2 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level2.setNoOfPillars(11);
				
				levelPanel.setAssociatedLevel(level2);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
			
			//level 3
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_THREE_NAME);
				levelPanel.setCordinates(740, 100);
				levelPanel.setLocked(false);
				
				Level level3 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level3.setNoOfPillars(13);
				
				levelPanel.setAssociatedLevel(level3);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 4	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FOUR_NAME);
				levelPanel.setCordinates(500, 200);
				levelPanel.setLocked(false);
				
				Level level4 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level4.setNoOfPillars(16);
				
				levelPanel.setAssociatedLevel(level4);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 5	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FIVE_NAME);
				levelPanel.setCordinates(620, 200);
				levelPanel.setLocked(false);
				
				Level level5 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level5.setNoOfPillars(19);
				
				levelPanel.setAssociatedLevel(level5);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 6	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SIX_NAME);
				levelPanel.setCordinates(740, 200);
				levelPanel.setLocked(false);
				
				Level level6 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level6.setNoOfPillars(21);
				
				levelPanel.setAssociatedLevel(level6);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 7	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SEVEN_NAME);
				levelPanel.setCordinates(500, 300);
				levelPanel.setLocked(false);
				
				Level level7 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level7.setNoOfPillars(25);
				
				levelPanel.setAssociatedLevel(level7);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 8	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_EIGHT_NAME);
				levelPanel.setCordinates(620, 300);
				levelPanel.setLocked(false);
				
				Level level8 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level8.setNoOfPillars(31);
				
				levelPanel.setAssociatedLevel(level8);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
	}
	
	
	private void setLevelPanelForLevel2(LevelInfo levelInfo) {
		// TODO Auto-generated method stub
		//level 1
				LevelPanel levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_ONE_NAME);
				levelPanel.setCordinates(500, 100);
				levelPanel.setLocked(false);
				
				LevelFactory levelFactory = new LevelFactory(levelInfo.getContext(), levelInfo.getGamePanel());
				
				Level level1 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level1.setNoOfPillars(6);
				level1.setStillTheme(true);
				levelPanel.setAssociatedLevel(level1);
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 2
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_TWO_NAME);
				levelPanel.setCordinates(620, 100);
				levelPanel.setLocked(false);
				
				Level level2 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level2.setNoOfPillars(6);
				level2.setStillTheme(true);
				
				levelPanel.setAssociatedLevel(level2);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
			
			//level 3
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_THREE_NAME);
				levelPanel.setCordinates(740, 100);
				levelPanel.setLocked(false);
				
				Level level3 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level3.setNoOfPillars(9);
				
				levelPanel.setAssociatedLevel(level3);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 4	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FOUR_NAME);
				levelPanel.setCordinates(500, 200);
				levelPanel.setLocked(false);
				
				Level level4 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level4.setNoOfPillars(13);
				
				levelPanel.setAssociatedLevel(level4);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 5	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FIVE_NAME);
				levelPanel.setCordinates(620, 200);
				levelPanel.setLocked(false);
				
				Level level5 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level5.setNoOfPillars(16);
				
				levelPanel.setAssociatedLevel(level5);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 6	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SIX_NAME);
				levelPanel.setCordinates(740, 200);
				levelPanel.setLocked(false);
				
				Level level6 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level6.setNoOfPillars(21);
				
				levelPanel.setAssociatedLevel(level6);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 7	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SEVEN_NAME);
				levelPanel.setCordinates(500, 300);
				levelPanel.setLocked(false);
				
				Level level7 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level7.setNoOfPillars(26);
				
				levelPanel.setAssociatedLevel(level7);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
			//level 8	
				levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_EIGHT_NAME);
				levelPanel.setCordinates(620, 300);
				levelPanel.setLocked(false);
				
				Level level8 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
				level8.setNoOfPillars(31);
				
				levelPanel.setAssociatedLevel(level8);
				
				associatedLevelListPanel.getLevelList().add(levelPanel);
				
	}

	/**
	 * @param levelInfo
	 */
	private void setLevelPanelForLevel1(LevelInfo levelInfo) {
		
	//level 1
		LevelPanel levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_ONE_NAME);
		levelPanel.setCordinates(500, 100);
		levelPanel.setLocked(false);
		
		LevelFactory levelFactory = new LevelFactory(levelInfo.getContext(), levelInfo.getGamePanel());
		
		Level level1 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level1.setNoOfPillars(6);
		level1.setRainingTheme(true);
		levelPanel.setAssociatedLevel(level1);
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 2
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_TWO_NAME);
		levelPanel.setCordinates(620, 100);
		levelPanel.setLocked(false);
		
		Level level2 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level2.setNoOfPillars(6);
		levelPanel.setAssociatedLevel(level2);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
	
	//level 3
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_THREE_NAME);
		levelPanel.setCordinates(740, 100);
		levelPanel.setLocked(false);
		
		Level level3 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level3.setNoOfPillars(6);
		levelPanel.setAssociatedLevel(level3);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 4	
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FOUR_NAME);
		levelPanel.setCordinates(500, 200);
		levelPanel.setLocked(false);
		
		Level level4 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level4.setNoOfPillars(6);
		level4.setRainingTheme(true);
		levelPanel.setAssociatedLevel(level4);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 5	
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_FIVE_NAME);
		levelPanel.setCordinates(620, 200);
		levelPanel.setLocked(false);
		
		Level level5 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level5.setNoOfPillars(9);
		levelPanel.setAssociatedLevel(level5);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 6	
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SIX_NAME);
		levelPanel.setCordinates(740, 200);
		levelPanel.setLocked(false);
		
		Level level6 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level6.setNoOfPillars(9);
		levelPanel.setAssociatedLevel(level6);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 7	
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_SEVEN_NAME);
		levelPanel.setCordinates(500, 300);
		levelPanel.setLocked(false);
		
		Level level7 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level7.setNoOfPillars(13);
		
		levelPanel.setAssociatedLevel(level7);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 8	
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_EIGHT_NAME);
		levelPanel.setCordinates(620, 300);
		levelPanel.setLocked(false);
		
		Level level8 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level8.setNoOfPillars(16);
		levelPanel.setAssociatedLevel(level8);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);
		
	//level 9
		levelPanel = levelPanelFactory.getLevelPanel(Constants.SUB_LEVEL_NINE_NAME);
		levelPanel.setCordinates(740, 300);
		levelPanel.setLocked(false);
		
		Level level9 = levelFactory.getLevel(levelInfo.getLevelName(), levelPanel.getLevelName());
		level9.setNoOfPillars(21);
		levelPanel.setAssociatedLevel(level9);
		
		associatedLevelListPanel.getLevelList().add(levelPanel);

		
	}
}
