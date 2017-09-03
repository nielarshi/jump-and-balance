/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Priya
 *
 */
public class HelpModeDone {



	private static RectF textRect, helpRect;
	private static JumpAndBalanceGamePanel gamePanel;
	public static boolean clicked;
	public static boolean finished;
	private static Paint levelTextPaint;
	private static Paint newPaint;
	
	
	
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
		HelpModeDone.gamePanel = gamePanel;
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
		HelpModeDone.clicked = clicked;
	}

	public static void draw(Canvas canvas) {

		textRect = new RectF(gamePanel.getWidth()-121, gamePanel.getHeight()-193, gamePanel.getWidth()-9, gamePanel.getHeight()-138);
		
		newPaint = new Paint();
		newPaint.setStrokeWidth(2.0f);
		newPaint.setAntiAlias(true);
		newPaint.setAlpha(1);
		newPaint.setColor(Color.GRAY);

		canvas.drawRoundRect(textRect, 10, 10, newPaint);
		
		helpRect = new RectF(gamePanel.getWidth()-120, gamePanel.getHeight()-194, gamePanel.getWidth()-10, gamePanel.getHeight()-137);
		
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
		
		String text = "Done";
		float textLength = levelTextPaint.measureText(text);
		canvas.drawText(text, (helpRect.centerX()-(textLength/2)), helpRect.centerY() + 10, levelTextPaint);
		
		levelTextPaint = new Paint();
		levelTextPaint.setColor(Color.GRAY);
		levelTextPaint.setTextSize(30);
		levelTextPaint.setStrokeWidth(1.0f);
		
	}

	public static void handleActionDown(int eventX, int eventY) {
		if(helpRect!=null) {
			if (eventX >= helpRect.left && (eventX <= helpRect.right)) {
				   if (eventY >= (helpRect.top) && (eventY <= (helpRect.bottom ))) {
					  
					   System.out.println("help clicked : true");
				
					   HelpModeButton.clicked = false;		   
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
		HelpModeDone.textRect = textRect;
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
		HelpModeDone.helpRect = helpRect;
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
		HelpModeDone.finished = finished;
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
		HelpModeDone.levelTextPaint = levelTextPaint;
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
		HelpModeDone.newPaint = newPaint;
	}

	
}
