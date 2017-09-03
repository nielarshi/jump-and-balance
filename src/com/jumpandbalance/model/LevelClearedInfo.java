/**
 * 
 */
package com.jumpandbalance.model;

import com.jumpandbalance.R;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.view.HomePanel;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

/**
 * @author Priya
 *
 */
public class LevelClearedInfo {
	//private static RectF textRect, continueRect;
	public JumpAndBalanceGamePanel gamePanel;
	public static boolean cleared;
	//private static Paint levelTextPaint;
	//private static Paint newPaint;
	//public static String levelInfoText;
	private Bitmap backGroundImage;
	private RectF panelRect, okRect, cancelRect;
	private Bitmap okImage;
	private Bitmap cancelImage;
	
	public LevelClearedInfo(JumpAndBalanceGamePanel gamePanel) {
		this.gamePanel = gamePanel;
		//this.backGroundImage = ImageHelper.getInstance().getImageFor(ImageHelper.LEVEL_OVER_BG);
		
		int panelLeft = 45;
		int panelTop =  45;
		int panelBottom = gamePanel.getHeight()-45;
		int panelRight = gamePanel.getWidth() - 45;
		panelRect = new RectF(panelLeft, panelTop, panelRight, panelBottom);
		
		this.okRect = new RectF(panelRight - 200, panelTop + 220, panelRight - 140, panelTop + 280);
		this.okImage = ImageHelper.getInstance().getImageFor(ImageHelper.OK_IMAGE);
		
		this.cancelRect = new RectF(panelRight - 200, panelTop + 300, panelRight - 140, panelTop + 360);
		this.cancelImage = ImageHelper.getInstance().getImageFor(ImageHelper.CANCEL_IMAGE);
	}
	
	
	

	public void draw(Canvas canvas) {
		
		canvas.drawBitmap(backGroundImage, null, panelRect, null);	
		canvas.drawBitmap(okImage, null, okRect, null);
		canvas.drawBitmap(cancelImage, null, cancelRect, null);
		/*textRect = new RectF(44, 44, gamePanel.getWidth()-46, gamePanel.getHeight()-46);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(2.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(1);
		newPaint.setColor(Color.GRAY);

		newPaint.setShadowLayer(14.0f, 10.0f, 18.0f, Color.BLACK);

		canvas.drawRoundRect(textRect, 10, 10, newPaint);
		
		
		textRect = new RectF(45, 45, gamePanel.getWidth()-45, gamePanel.getHeight()-45);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(3.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(1);
		newPaint.setColor(Color.LTGRAY);

		newPaint.setShadowLayer(14.0f, 10.0f, 18.0f, Color.BLACK);

		canvas.drawRoundRect(textRect, 10, 10, newPaint);
		
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.DKGRAY);
		levelTextPaint.setTextSize(70);
		levelTextPaint.setStrokeWidth(2.0f);
		
		String text = levelInfoText;
		float textLength = ((gamePanel.getWidth()/2) - (levelTextPaint.measureText(text)/2));
		canvas.drawText(text, textLength, 200, levelTextPaint);
		
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.GRAY);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(1.0f);
		
		text = "Click continue to continue";
		textLength = ((gamePanel.getWidth()/2) - (levelTextPaint.measureText(text)/2));
		
		
		canvas.drawText(text, textLength, 280, levelTextPaint);
		

		textRect = new RectF((gamePanel.getWidth()/2) - 99, 349,  (gamePanel.getWidth()/2) + 101, 401);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(3.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(4);
		newPaint.setColor(Color.BLACK);
		newPaint.setShadowLayer(14.0f, 10.0f, 18.0f, Color.BLACK);
		
		
		canvas.drawRoundRect(textRect, 10, 10, newPaint);
		
		
		continueRect = new RectF((gamePanel.getWidth()/2) - 100, 350,  (gamePanel.getWidth()/2) + 100, 400);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(3.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(4);
		newPaint.setColor(Color.YELLOW);
		newPaint.setShadowLayer(14.0f, 10.0f, 18.0f, Color.BLACK);
		
		
		canvas.drawRoundRect(continueRect, 10, 10, newPaint);

		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.BLACK);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(1.0f);*/
		/*String text = levelInfoText;
		float textLength = ((gamePanel.getWidth()/2) - (levelTextPaint.measureText(text)/2));
		canvas.drawText(text, textLength, 200, levelTextPaint);
		text = "Continue";
		textLength = ((gamePanel.getWidth()/2) - (levelTextPaint.measureText(text)/2));
		
		
		canvas.drawText(text, textLength, 385, levelTextPaint);*/
	}

	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= okRect.left && (eventX <= okRect.right)) {
			   if (eventY >= (okRect.top) && (eventY <= (okRect.bottom ))) {
				  
				   System.out.println("cleared : true");
				   cleared = false;
				   gamePanel.setHomePanel(true);
				   gamePanel.setLevelPanel(false);
				   gamePanel.setLevelSelected(false);
				   gamePanel.setSubLevelSelected(false);
				   gamePanel.setCurrentMainLevel(null);
				   gamePanel.setOngoingLevel(null);
				   
			   } else {
				  }
			   } else {
		}
	
	
		if (eventX >= cancelRect.left && (eventX <= cancelRect.right)) {
			   if (eventY >= (cancelRect.top) && (eventY <= (cancelRect.bottom ))) {
				  
				   System.out.println("cleared : true");
				   cleared = false;
				   
			   } else {
				  }
			   } else {
		}
	}
	
	
	/**
	 * @return the levelInfoText
	 */
	/*public static String getLevelInfoText() {
		return levelInfoText;
	}

	*//**
	 * @param levelInfoText the levelInfoText to set
	 *//*
	public static void setLevelInfoText(String levelInfoText) {
		LevelClearedInfo.levelInfoText = levelInfoText;
	}*/


	/**
	 * @return the cleared
	 */
	public static boolean isCleared() {
		return cleared;
	}

	/**
	 * @param cleared the cleared to set
	 */
	public static void setCleared(boolean cleared) {
		LevelClearedInfo.cleared = cleared;
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
	public Bitmap getBackGroundImage() {
		return backGroundImage;
	}


	public void setBackGroundImage(Bitmap backGroundImage) {
		this.backGroundImage = backGroundImage;
	}


	public Bitmap getOKImage() {
		return okImage;
	}


	public void setOkImage(Bitmap okImage) {
		this.okImage = okImage;
	}

	
}
