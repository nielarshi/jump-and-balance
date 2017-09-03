/**
 * 
 */
package com.jumpandbalance.actors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.jumpandbalance.view.JumpAndBalanceGamePanel;

/**
 * @author Niel
 *
 */
public class GameStats {

	private String currentMoveScore;
	private int score;
	private int scoreX;
	private int scoreY;
	private int pillarCrossed;
	private Paint paint;
	private RectF scoreTextRect,scoreRect,pillarTextRect,pillarRect,currentRateRect;
	String colorAlpha = "FFFFFF";
	
	
	private JumpAndBalanceGamePanel gamePanel;
	public GameStats(JumpAndBalanceGamePanel gamePanel) {
		this.score = 0;
		this.currentMoveScore = "Start";
		this.gamePanel=gamePanel;
		this.paint = new Paint(); 
		this.paint.setStrokeWidth(2.0f);
		
		this.paint.setTextSize(120); 
		this.scoreX = this.gamePanel.getWidth()/2;
		this.scoreY = this.gamePanel.getHeight()/2;
	}
	
	
	/**
	 * @return the pillarCrossed
	 */
	public int getPillarCrossed() {
		return pillarCrossed;
	}


	/**
	 * @param pillarCrossed the pillarCrossed to set
	 */
	public void setPillarCrossed(int pillarCrossed) {
		this.pillarCrossed = pillarCrossed;
	}


	/**
	 * @return the currentMoveScore
	 */
	public String getCurrentMoveScore() {
		return currentMoveScore;
	}


	/**
	 * @param currentMoveScore the currentMoveScore to set
	 */
	public void setCurrentMoveScore(String currentMoveScore) {
		this.currentMoveScore = currentMoveScore;
	}


	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	/**
	 * @return the scoreX
	 */
	public int getScoreX() {
		return scoreX;
	}

	/**
	 * @param scoreX the scoreX to set
	 */
	public void setScoreX(int scoreX) {
		this.scoreX = scoreX;
	}

	/**
	 * @return the scoreY
	 */
	public int getScoreY() {
		return scoreY;
	}

	/**
	 * @param scoreY the scoreY to set
	 */
	public void setScoreY(int scoreY) {
		this.scoreY = scoreY;
	}

	public void draw(Canvas canvas) {
		paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        scoreTextRect = new RectF(this.gamePanel.getWidth()-200, 30, this.gamePanel.getWidth()-100, 80);
        canvas.drawRoundRect(scoreTextRect, 10, 10,paint);
        
        this.paint.setColor(Color.BLUE); 
        this.paint.setTextSize(28); 
		this.paint.setStrokeWidth(2);
//		this.paint.setColor(Color.parseColor("#" + colorAlpha));// initially colorAlpha is ff
		
		if(scoreX < scoreTextRect.left+10) {
			scoreX++;
		}
		if(scoreY < scoreTextRect.top+30) {
			scoreY++;
			
		}
        canvas.drawText("Score", scoreTextRect.left+10, scoreTextRect.top+30, paint);
        
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        scoreRect = new RectF(this.gamePanel.getWidth()-90, 30, this.gamePanel.getWidth()-20, 80);
        canvas.drawRoundRect(scoreRect, 10, 10,paint);
        pillarTextRect = new RectF(this.gamePanel.getWidth()-200, 90, this.gamePanel.getWidth()-100, 140);
        canvas.drawRoundRect(pillarTextRect, 10, 10,paint);
        
        
        this.paint.setColor(Color.BLUE); 
        this.paint.setTextSize(28); 
		this.paint.setStrokeWidth(2);
        canvas.drawText("Pillars", pillarTextRect.left+10, pillarTextRect.top+30, paint);
       
       	paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        
        pillarRect = new RectF(this.gamePanel.getWidth()-90, 90, this.gamePanel.getWidth()-20, 140);
        canvas.drawRoundRect(pillarRect, 10, 10,paint);
        
		this.paint.setStrokeWidth(2.0f);
		this.paint.setTextSize(120); 
		
		HelpModeButton.clicked = false;
		
		if("+1".equals(currentMoveScore)){
			this.paint.setColor(Color.BLUE); 
			
		//	canvas.drawText(currentMoveScore, scoreX, scoreY, paint);
			
			
				this.paint.setTextSize(28); 
				this.paint.setStrokeWidth(2);
				if(score<0){
				canvas.drawText(String.valueOf(0), scoreRect.left+5, scoreRect.top+30, paint);
				canvas.drawText(String.valueOf(pillarCrossed), pillarRect.left+10, pillarRect.top+30, paint);
				
			}else{
				
				canvas.drawText(String.valueOf(score), scoreRect.left+5, scoreRect.top+30, paint);
				canvas.drawText(String.valueOf(pillarCrossed), pillarRect.left+10, pillarRect.top+30, paint);
				
			}
			
		}else if("-1".equals(currentMoveScore)){
			this.paint.setColor(Color.RED); 
			if(score<=0){
			this.paint.setTextSize(28); 
			this.paint.setStrokeWidth(2);
			
				canvas.drawText(String.valueOf(0), scoreRect.left+5, scoreRect.top+30, paint);
				canvas.drawText(String.valueOf(pillarCrossed), pillarRect.left+10, pillarRect.top+30, paint);
				
			}else{
			//	canvas.drawText(currentMoveScore, scoreX, scoreY, paint);
				this.paint.setTextSize(28); 
				this.paint.setStrokeWidth(2);
				
				canvas.drawText(String.valueOf(score), scoreRect.left+5, scoreRect.top+30, paint);

				canvas.drawText(String.valueOf(pillarCrossed), pillarRect.left+10, pillarRect.top+30, paint);
				
			}
		}else{
			this.paint.setTextSize(180); 
			this.paint.setStrokeWidth(1.0f);
			this.paint.setColor(Color.BLACK); 
			canvas.drawText(currentMoveScore, 20, 150, paint);
			this.paint.setTextSize(30); 
			this.paint.setStrokeWidth(0);
			canvas.drawText("Press and swipe down 1st pillar to start playing", 20, 220, paint);
			HelpModeButton.clicked = true;
		}
		
		
	}


	/**
	 * @return the paint
	 */
	public Paint getPaint() {
		return paint;
	}


	/**
	 * @param paint the paint to set
	 */
	public void setPaint(Paint paint) {
		this.paint = paint;
	}


	/**
	 * @return the scoreTextRect
	 */
	public RectF getScoreTextRect() {
		return scoreTextRect;
	}


	/**
	 * @param scoreTextRect the scoreTextRect to set
	 */
	public void setScoreTextRect(RectF scoreTextRect) {
		this.scoreTextRect = scoreTextRect;
	}


	/**
	 * @return the scoreRect
	 */
	public RectF getScoreRect() {
		return scoreRect;
	}


	/**
	 * @param scoreRect the scoreRect to set
	 */
	public void setScoreRect(RectF scoreRect) {
		this.scoreRect = scoreRect;
	}


	/**
	 * @return the pillarTextRect
	 */
	public RectF getPillarTextRect() {
		return pillarTextRect;
	}


	/**
	 * @param pillarTextRect the pillarTextRect to set
	 */
	public void setPillarTextRect(RectF pillarTextRect) {
		this.pillarTextRect = pillarTextRect;
	}


	/**
	 * @return the pillarRect
	 */
	public RectF getPillarRect() {
		return pillarRect;
	}


	/**
	 * @param pillarRect the pillarRect to set
	 */
	public void setPillarRect(RectF pillarRect) {
		this.pillarRect = pillarRect;
	}


	/**
	 * @return the currentRateRect
	 */
	public RectF getCurrentRateRect() {
		return currentRateRect;
	}


	/**
	 * @param currentRateRect the currentRateRect to set
	 */
	public void setCurrentRateRect(RectF currentRateRect) {
		this.currentRateRect = currentRateRect;
	}


	/**
	 * @return the colorAlpha
	 */
	public String getColorAlpha() {
		return colorAlpha;
	}


	/**
	 * @param colorAlpha the colorAlpha to set
	 */
	public void setColorAlpha(String colorAlpha) {
		this.colorAlpha = colorAlpha;
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
	
	
}
