/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.view.HomePanel;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Priya
 *
 */
public class BackButton {



	private static RectF textRect, homeRect;
	private static HomePanel homepanel;
	public static boolean clicked, homeClicked;
	private static Paint levelTextPaint;
	private static Paint newPaint;
	private static Bitmap image;
	/**
	 * @return the homepanel
	 */
	public static HomePanel getHomepanel() {
		return homepanel;
	}

	/**
	 * @param homepanel the homepanel to set
	 */
	public static void setHomepanel(HomePanel homepanel) {
		BackButton.homepanel = homepanel;
		

		homeRect = new RectF(20, 20, 95, 100);
		image = ImageHelper.getInstance().getImageFor(ImageHelper.BACK_ICON_IMAGE);
	}

	/**
	 * @return the clicked
	 */
	public static boolean isClicked() {
		return clicked;
	}

	/**
	 * @param clicked the clicked to set
	 */
	public static void setClicked(boolean clicked) {
		BackButton.clicked = clicked;
	}

	public static void draw(Canvas canvas) {

		canvas.drawBitmap(image, homeRect.left, homeRect.top, null);
		
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(homeRect!=null) {
			if (eventX >= homeRect.left && (eventX <= homeRect.right)) {
				   if (eventY >= (homeRect.top) && (eventY <= (homeRect.bottom ))) {
					  
					   
					   clicked = true;
					   if(homepanel.getGamePanel().isSubLevelSelected() && !homepanel.getGamePanel().isHomePanel() && !homepanel.getGamePanel().isLevelPanel()) {
							if(ThemeRequest.isRequested) {
								ThemeRequest.isRequested = false;
							} else {
								homepanel.getGamePanel().setLevelPanel(true);
								homepanel.getGamePanel().setSubLevelSelected(false);
								JumpAndBalanceGamePanel.isRestored = true;
							}
							
						}  else if(!homepanel.getGamePanel().isSubLevelSelected() && !homepanel.getGamePanel().isHomePanel() && homepanel.getGamePanel().isLevelPanel()) {
							homepanel.getGamePanel().setCurrentMainLevel(null);
							homepanel.getGamePanel().setOngoingLevel(null);
							homepanel.getGamePanel().setHomePanel(true);
							homepanel.getGamePanel().setLevelPanel(false);
							
							homeClicked = true;
						} 
					   
					   homepanel.getGamePanel().setAlphaCount(255);
					
				   } else {
					  }
				   } else {
			}
		}
		
	}

}
