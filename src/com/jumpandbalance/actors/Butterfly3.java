package com.jumpandbalance.actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.jumpandbalance.images.ImageHelper;

public class Butterfly3 {
	private static final int BMP_ROWS = 2;
	private static final int BMP_COLUMN = 7;
	private int x,y;
	private Bitmap butterfly1;
	private int width, height;
	private int count;
	private int currentFrame, currentYFrame = 0;
	private boolean isForward = true;
	GameOverConfirmation gocObj;
	private boolean isDrawn;
	
	
	
	public Butterfly3(GameOverConfirmation gocObj) {
		this.x = 100;
		this.y = 420;
		this.butterfly1 = ImageHelper.getInstance().getImageFor(ImageHelper.BUTTERFLY_THREE);
		
		this.width = butterfly1.getWidth() / BMP_COLUMN;
		this.height = butterfly1.getHeight() / BMP_ROWS;
		
		this.gocObj = gocObj;
	}
	
	public void draw(Canvas canvas) {
		
		
		int srcX1 = currentFrame * width;
		int srcY1= currentYFrame * height;
		
		Rect src1 = new Rect(srcX1, srcY1, srcX1 + width, srcY1 + height);
		Rect dest1 = new Rect(x, y, x + width, y + height);
		
		canvas.drawBitmap(butterfly1, src1, dest1, null);
		updateObjectLocation();
		
	}
	
	
	
	
	
	public void updateObjectLocation() {
		
		count++;
		
		/*if(isForward) {
			x +=6;
		} else {
			x-= 6;
		}*/
		x += 4;
		y -= 1.8;
if(x > (int)this.gocObj.getPanelRect().right - width) {
			
			x += 100;
			isDrawn = true;
		//	x -= 4;
			//isForward = false;e..
		//	currentYFrame = 1;
		}
		if(x < 48) {
			x -= 100;
			isDrawn = true;
		//	isForward = true;
		//	currentYFrame = 0;
		}
		
		if(y < 48) {
			y -= 100;
			isDrawn = true;
		}
		
		if(y > (int)this.gocObj.getPanelRect().bottom - height) {
			y += 150;
			isDrawn = true;
		}
		
		if(count>8) {
			
			
				currentFrame = ++currentFrame % BMP_COLUMN;
			
				
			
			count = 0;
			
			
		}
			
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Bitmap getButterfly1() {
		return butterfly1;
	}

	public void setButterfly1(Bitmap butterfly1) {
		this.butterfly1 = butterfly1;
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}
	
	

}
