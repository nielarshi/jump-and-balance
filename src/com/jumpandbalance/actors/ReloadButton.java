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

public class ReloadButton {


	private static RectF textRect, reloadRect;
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
		ReloadButton.homepanel = homepanel;
		
		reloadRect = new RectF(470, 20, 545, 100);
		image = ImageHelper.getInstance().getImageFor(ImageHelper.RELOAD_ICON_IMAGE);
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

		
		canvas.drawBitmap(image, reloadRect.left, reloadRect.top, null);
		
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(reloadRect!=null) {
			if (eventX >= reloadRect.left && (eventX <= reloadRect.right)) {
				   if (eventY >= (reloadRect.top) && (eventY <= (reloadRect.bottom ))) {
					   BackButton.clicked = false;
					   
					   if(null!=ReloadButton.homepanel.getGamePanel().getOngoingLevel()) {
						
						   ReloadButton.homepanel.getGamePanel().getOngoingLevel().setDefaultToReplayMode();
						   ReloadButton.homepanel.getGamePanel().getOngoingLevel().setCanInitialiseForReplay(true);
						   ReloadButton.homepanel.getGamePanel().getOngoingLevel().initialiseForReplay();
						   ReloadButton.homepanel.getGamePanel().getOngoingLevel().setGameOver(false);
						   ReloadButton.homepanel.getGamePanel().getOngoingLevel().setOngoing(false);
						   
						   for(LevelDiamond diamond : homepanel.getGamePanel().getOngoingLevel().getDiamondsInLevel()) {
							   diamond.setAlreadyAttained(false);
						   }
						   
						   
						   JumpAndBalanceGamePanel.isRestored = true;
					   }
					   
				   } else {
					  }
				   } else {
			}
		}
		
	}

}
