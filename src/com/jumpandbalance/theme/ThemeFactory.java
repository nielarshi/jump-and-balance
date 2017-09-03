/**
 * 
 */
package com.jumpandbalance.theme;

import android.content.Context;

import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.interfaces.FactoryProducer;
import com.jumpandbalance.interfaces.Theme;

/**
 * @author Priya
 *
 */
public class ThemeFactory extends FactoryProducer{

	private static ThemeFactory themeFactory;
	private static Theme theme1, theme2, theme3, theme4;
	private static Context context;
	
	private ThemeFactory() {
		
	}
	public static ThemeFactory getInstance(Context gameContext) {
		if(themeFactory==null) {
			themeFactory = new ThemeFactory();
			context = gameContext;
			initializeThemes();
		}
		return themeFactory;
	}
	
	private static void initializeThemes() {

		theme1 = new ThemeOne(context);
		theme2 = new ThemeTwo(context);
		theme3 = new ThemeThree(context);
		theme4 = new ThemeFour(context);
	}
	
	
	@Override
	public Theme getTheme(int type) {
		if(type == Constants.THEME_ONE) {
			return theme1;
		} else if(type == Constants.THEME_TWO) {
			return theme2;
		} else if(type == Constants.THEME_THREE) {
			return theme3;
		} else if(type == Constants.THEME_FOUR) {
			return theme4;
		}
		return null;
	}

}
