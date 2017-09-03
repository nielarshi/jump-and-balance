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

/**
 * @author Priya
 *
 */
public class HomeButton {

	private static RectF textRect, homeRect;
	private static HomePanel homepanel;
	public static boolean clicked;
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
	
		HomeButton.homepanel = homepanel;
		homeRect = new RectF(110, 20, 185, 100);
		image = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_ICON_IMAGE);
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
		HomeButton.clicked = clicked;
	}

	public static void draw(Canvas canvas) {

		
		canvas.drawBitmap(image, homeRect.left, homeRect.top, null);
		
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(homeRect!=null) {
			if (eventX >= homeRect.left && (eventX <= homeRect.right)) {
				   if (eventY >= (homeRect.top) && (eventY <= (homeRect.bottom ))) {
					  
					   System.out.println("cleared : true");
					   //bhavana
					   //LevelClearedInfo.levelInfoText = Constants.LEVEL_CANCELED;
					   LevelClearedInfo.cleared = true;		   
					   
				   } else {
					  }
				   } else {
			}
		}
		
	}
}
