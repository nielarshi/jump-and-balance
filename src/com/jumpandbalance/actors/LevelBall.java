package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.util.GameUtil;

public class LevelBall {


	private static final int BMP_ROWS = 1;
	private static final int BMP_COLUMN = 4;
	private int x,y;
	private Bitmap bitmapImage;
	private int width, height;
	private int currentFrame;
	private boolean alreadyAttained;
	private boolean hasBallTouched;
	private int randomball;
	private int count;
	private boolean isForward;
	
	
	
	public LevelBall() {
		
		this.x = -20;
		this.y = 100;
		this.bitmapImage = Bitmap.createScaledBitmap(ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_5), 200, 50, true);
		this.alreadyAttained = false;
		this.width = bitmapImage.getWidth() / BMP_COLUMN;
		this.height = bitmapImage.getHeight() / BMP_ROWS;
		
	}

	public void draw(Canvas canvas) {
	
		int srcX = currentFrame * width;
		int srcY = 0 * height;
	
		if(hasBallTouched) {
			updateDiamondRectAfterBallTouch();
		}
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dest = new Rect(x, y, x + width, y + height);
	
		
		if(!alreadyAttained) {
			canvas.drawBitmap(bitmapImage, src, dest, null);
			updateObjectLocation();
		}
		
	}

	private void updateDiamondRectAfterBallTouch() {
		
		if(!alreadyAttained) {
			x = x + 20;
			
			if(x > 2000) {
				hasBallTouched = false;
			}
		}
		
	}

	public void updateObjectLocation() {
		
		x = x + 2;
		count++;
		
		if(count>10) {
			
			if(!isForward) {
				currentFrame = ++currentFrame % BMP_COLUMN;
			} else {
				currentFrame = --currentFrame % BMP_COLUMN;
			}
			
			count = 0;
			
			if(currentFrame == 3) {
				isForward = true;
				count = -20;
			} else if(currentFrame == 0) {
				isForward = false;
			}
			
		}
		
		if(!isAlreadyAttained()) {
			if(x > 2000) {
				x = -80;
				randomball = GameUtil.randInt(1, 7);
				switch (randomball) {
				case 1:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_1);
					break;
				case 2:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_2);
					break;
				case 3:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_3);
					break;
				case 4:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_4);
					break;
				case 5:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_5);
					break;
				case 6:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_6);
					break;
				case 7:
					bitmapImage = ImageHelper.getInstance().getImageFor(ImageHelper.HOME_BALL_7);
					break;

				default:
					break;
				}
				
			}
		}
		
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the currentFrame
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}
	/**
	 * @param currentFrame the currentFrame to set
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	/**
	 * @return the bmpRows
	 */
	public static int getBmpRows() {
		return BMP_ROWS;
	}
	/**
	 * @return the bmpColumn
	 */
	public static int getBmpColumn() {
		return BMP_COLUMN;
	}

	/**
	 * @return the alreadyAttained
	 */
	public boolean isAlreadyAttained() {
		return alreadyAttained;
	}

	/**
	 * @param alreadyAttained the alreadyAttained to set
	 */
	public void setAlreadyAttained(boolean alreadyAttained) {
		this.alreadyAttained = alreadyAttained;
	}

	/**
	 * @return the hasBallTouched
	 */
	public boolean isHasBallTouched() {
		return hasBallTouched;
	}

	/**
	 * @param hasBallTouched the hasBallTouched to set
	 */
	public void setHasBallTouched(boolean hasBallTouched) {
		this.hasBallTouched = hasBallTouched;
	}
	
	
	
	
	
	

}
