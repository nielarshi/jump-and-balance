/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.MainActivity;
import com.jumpandbalance.constant.Constants;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.model.LevelClearedInfo;
import com.jumpandbalance.view.HomePanel;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Priya
 *
 */
public class MusicButton {

	private static RectF textRect, homeRect, tempHomeRect, rect1, rect2, rect3;
	private static HomePanel homepanel;
	public static boolean clicked;
	private static Paint levelTextPaint;
	private static Paint newPaint;
	private static Bitmap musicImage;
	
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
		MusicButton.homepanel = homepanel;
		
			rect1 = new RectF(200, 20, 275, 100);
			rect2 = new RectF(110, 20, 185, 100);
			rect3 = new RectF(20, 20, 95, 100);
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
	
	

	/**
	 * @return the musicImage
	 */
	public static Bitmap getMusicImage() {
		return musicImage;
	}

	/**
	 * @param musicImage the musicImage to set
	 */
	public static void setMusicImage(Bitmap musicImage) {
		MusicButton.musicImage = musicImage;
	}

	public static void draw(Canvas canvas) {

		if(homepanel.getGamePanel().isSubLevelSelected()) {
			homeRect = rect1;
		} else if(homepanel.getGamePanel().isLevelPanel()) {
			homeRect = rect2;
		} else if(homepanel.getGamePanel().isHomePanel()) {
			homeRect = rect3;
		}
		
		
		canvas.drawBitmap(musicImage, homeRect.left, homeRect.top, null);
		
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(homeRect!=null) {
			if (eventX >= homeRect.left && (eventX <= homeRect.right)) {
				   if (eventY >= (homeRect.top) && (eventY <= (homeRect.bottom ))) {
					   
					   if(clicked) {
						   
						   MusicButton.musicImage = ImageHelper.getInstance().getImageFor(ImageHelper.MUSIC_ICON_IMAGE);
						    clicked = false;
					   } else {
						   
						   MusicButton.musicImage = ImageHelper.getInstance().getImageFor(ImageHelper.MUSIC_MUTE_ICON_IMAGE);
						   clicked = true;
					   }
					   
					   
					   JumpAndBalanceGamePanel.resetMusic();
					  
					     
				   } else {
					  }
				   } else {
			}
		}
		
	}
}
