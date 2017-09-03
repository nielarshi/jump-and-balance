/**
 * 
 */
package com.jumpandbalance.actors;

import com.jumpandbalance.util.GameUtil;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author TCS
 *
 */
public class Pillar {
	
	private Bitmap bitmapImage;
	private int x;
	private int y;
	private boolean touched;
	private int touchXPosition;
	private int touchYPosition;
	private Ball ball;
	private int index;
	private boolean touchInitiated;
	private Paint paint;
	private boolean isTouchOver;
	private long clickStartTime;
	private boolean isMovingUp;
	private int count;
	private boolean canMoveHorizontally;
	private boolean movingBackward;
	
	
	/**
	 * @return the movingBackward
	 */
	public boolean isMovingBackward() {
		return movingBackward;
	}

	/**
	 * @param movingBackward the movingBackward to set
	 */
	public void setMovingBackward(boolean movingBackward) {
		this.movingBackward = movingBackward;
	}

	/**
	 * @return the canMoveHorizontally
	 */
	public boolean isCanMoveHorizontally() {
		return canMoveHorizontally;
	}

	/**
	 * @param canMoveHorizontally the canMoveHorizontally to set
	 */
	public void setCanMoveHorizontally(boolean canMoveHorizontally) {
		this.canMoveHorizontally = canMoveHorizontally;
	}

	/**
	 * @return the isMovingUp
	 */
	public boolean isMovingUp() {
		return isMovingUp;
	}

	/**
	 * @param isMovingUp the isMovingUp to set
	 */
	public void setMovingUp(boolean isMovingUp) {
		this.isMovingUp = isMovingUp;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the clickStartTime
	 */
	public long getClickStartTime() {
		return clickStartTime;
	}

	/**
	 * @param clickStartTime the clickStartTime to set
	 */
	public void setClickStartTime(long clickStartTime) {
		this.clickStartTime = clickStartTime;
	}

	/**
	 * @return the isTouchOver
	 */
	public boolean isTouchOver() {
		return isTouchOver;
	}

	/**
	 * @param isTouchOver the isTouchOver to set
	 */
	public void setTouchOver(boolean isTouchOver) {
		this.isTouchOver = isTouchOver;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	public Pillar(Bitmap bitmapImage, int x, int y) {
		this.bitmapImage = bitmapImage;
		this.x = x;
		this.y = y;

		paint = new Paint();
        paint.setShadowLayer(10.0f, 0.0f, 2.0f, 0xFF000000); 
        
        
	}
	
	public Pillar(Bitmap bitmapImage) {
		this.bitmapImage = bitmapImage;
	}
	
	/**
	 * @return the bitmapImage
	 */
	public Bitmap getBitmapImage() {
		return bitmapImage;
	}
	/**
	 * @param bitmapImage the bitmapImage to set
	 */
	public void setBitmapImage(Bitmap bitmapImage) {
		this.bitmapImage = bitmapImage;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the touched
	 */
	public boolean isTouched() {
		return touched;
	}
	/**
	 * @param touched the touched to set
	 */
	public void setTouched(boolean touched) {
		this.touched = touched;
	}
	
	/**
	 * @return the touchXPosition
	 */
	public int getTouchXPosition() {
		return touchXPosition;
	}
	/**
	 * @param touchXPosition the touchXPosition to set
	 */
	public void setTouchXPosition(int touchXPosition) {
		this.touchXPosition = touchXPosition;
	}
	/**
	 * @return the touchYPosition
	 */
	public int getTouchYPosition() {
		return touchYPosition;
	}
	/**
	 * @param touchYPosition the touchYPosition to set
	 */
	public void setTouchYPosition(int touchYPosition) {
		this.touchYPosition = touchYPosition;
	}
	
	/**
	 * @return the ball
	 */
	public Ball getBall() {
		return ball;
	}
	/**
	 * @param ball the ball to set
	 */
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	
	
	/**
	 * @return the touchInitiated
	 */
	public boolean isTouchInitiated() {
		return touchInitiated;
	}

	/**
	 * @param touchInitiated the touchInitiated to set
	 */
	public void setTouchInitiated(boolean touchInitiated) {
		this.touchInitiated = touchInitiated;
	}

	public void draw(Canvas canvas) {
	
		 canvas.drawBitmap(bitmapImage, x - (bitmapImage.getWidth() / 2), y, paint);
	}

	public void animatePillar() {
		
	}
	
	public void handleActionDown(int eventX, int eventY) {
		
		if (eventX >= (x - bitmapImage.getWidth() / 2) && (eventX <= (x + bitmapImage.getWidth()/2))) {
		   if (eventY >= (y) && (y <= (y + bitmapImage.getHeight()))) {
			   setTouchInitiated(true);
			   
			   System.out.println("Pillar touched inside");
			   touchYPosition = eventY - y;
			   touchXPosition = touchYPosition;
			   
			   HelpButton.clicked = false;
			   
		   } else {
			   setTouched(false);
		   }
		} else {
			  setTouched(false);
		}
	}
	
}
