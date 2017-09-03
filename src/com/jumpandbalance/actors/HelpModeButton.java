/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Priya
 *
 */
public class HelpModeButton {



	private static RectF textRect, helpRect;
	private static JumpAndBalanceGamePanel gamePanel;
	public static boolean clicked;
	public static boolean finished;
	private static Paint levelTextPaint;
	private static Paint newPaint;
	private static Bitmap image;
	
	
	/**
	 * @return the gamePanel
	 */
	public static JumpAndBalanceGamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * @param gamePanel the gamePanel to set
	 */
	public static void setGamePanel(JumpAndBalanceGamePanel gamePanel) {
		HelpModeButton.gamePanel = gamePanel;
		

		helpRect = new RectF(380, 20, 455, 100);
		image = ImageHelper.getInstance().getImageFor(ImageHelper.HELP_ICON_IMAGE);
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
		HelpModeButton.clicked = clicked;
	}

	public static void draw(Canvas canvas) {

		
		canvas.drawBitmap(image, helpRect.left, helpRect.top, null);
		
		
		
		/*textRect = new RectF(gamePanel.getWidth() / 2 - 100, 20, gamePanel.getWidth() / 2 + 120, 70);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(2.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(1);
		newPaint.setColor(Color.GRAY);

		canvas.drawRoundRect(textRect, 10, 10, newPaint);
		
		helpRect = new RectF(gamePanel.getWidth() / 2 - 99, 21, gamePanel.getWidth() / 2 + 121, 71);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(3.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(1);
		newPaint.setColor(Color.GREEN);

		canvas.drawRoundRect(helpRect, 10, 10, newPaint);
		
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.DKGRAY);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(2.0f);
		
		String text = "Tutor mode";
		float textLength = levelTextPaint.measureText(text);
		canvas.drawText(text, (helpRect.centerX()-(textLength/2)), helpRect.centerY() + 10, levelTextPaint);
		
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.GRAY);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(1.0f);
		*/
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(helpRect!=null) {
			if (eventX >= helpRect.left && (eventX <= helpRect.right)) {
				   if (eventY >= (helpRect.top) && (eventY <= (helpRect.bottom ))) {
					  
					   System.out.println("help clicked : true");
				//	   LevelClearedInfo.levelInfoText = Constants.LEVEL_CANCELED;
				//	   HelpButton.clicked = true;
					   HelpModeButton.clicked = true;		   
					   HelpModeButton.finished = true;
				   } else {
					  }
				   } else {
			}
		}
		
	}

	/**
	 * @return the textRect
	 */
	public static RectF getTextRect() {
		return textRect;
	}

	/**
	 * @param textRect the textRect to set
	 */
	public static void setTextRect(RectF textRect) {
		HelpModeButton.textRect = textRect;
	}

	/**
	 * @return the helpRect
	 */
	public static RectF getHelpRect() {
		return helpRect;
	}

	/**
	 * @param helpRect the helpRect to set
	 */
	public static void setHelpRect(RectF helpRect) {
		HelpModeButton.helpRect = helpRect;
	}

	/**
	 * @return the finished
	 */
	public static boolean isFinished() {
		return finished;
	}

	/**
	 * @param finished the finished to set
	 */
	public static void setFinished(boolean finished) {
		HelpModeButton.finished = finished;
	}

	/**
	 * @return the levelTextPaint
	 */
	public static Paint getLevelTextPaint() {
		return levelTextPaint;
	}

	/**
	 * @param levelTextPaint the levelTextPaint to set
	 */
	public static void setLevelTextPaint(Paint levelTextPaint) {
		HelpModeButton.levelTextPaint = levelTextPaint;
	}

	/**
	 * @return the newPaint
	 */
	public static Paint getNewPaint() {
		return newPaint;
	}

	/**
	 * @param newPaint the newPaint to set
	 */
	public static void setNewPaint(Paint newPaint) {
		HelpModeButton.newPaint = newPaint;
	}

	
}
