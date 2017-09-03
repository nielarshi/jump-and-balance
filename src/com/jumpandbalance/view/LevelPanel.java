/**
 * 
 */
package com.jumpandbalance.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

import com.jumpandbalance.actors.BackButton;
import com.jumpandbalance.actors.Level;
import com.jumpandbalance.images.ImageHelper;
import com.jumpandbalance.stat.LevelGameStat;
import com.jumpandbalance.util.FontUtil;

/**
 * @author Priya
 *
 */
public class LevelPanel {


	private Level associatedLevel;
	private String levelName;
	private String levelDescription;
	private String levelScore;
	private int x;
	private int y;
	private boolean locked;
	private boolean levelTouched;
	private Paint levelTextPaint, levelRectPaint;
	private RectF textRect;
	private Bitmap lockImageBitmap;
	private BitmapDrawable bitmapDrawable;
	private HomePanel homepanel;
	private Context context;
	private Paint paintBorder;
	private Bitmap levelBackImage;
	private Bitmap starImage;
	
	
	public LevelPanel(Context context, HomePanel homepanel) {
		this.context = context;
		this.homepanel = homepanel;
		this.lockImageBitmap = ImageHelper.getInstance().getImageFor(ImageHelper.LOCK_IMAGE);
		this.bitmapDrawable = new BitmapDrawable(lockImageBitmap);
		this.starImage = ImageHelper.getInstance().getImageFor(ImageHelper.STAR_IMAGE);
		this.levelTextPaint = FontUtil.getFontPaint(FontUtil.ALL_CAPS_FONT, Color.rgb(178, 255, 98), 25);
		
		this.levelRectPaint = new Paint();
		
		this.levelRectPaint.setStrokeWidth(2);
		this.levelRectPaint.setShadowLayer(4.0f, 15.0f, 8.0f, Color.BLACK);
		this.levelRectPaint.setAntiAlias(true);
		
		paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
        paintBorder.setShadowLayer(4.0f, 0.0f, 2.0f, Color.BLACK);
	
	}
	
	
	/**
	 * @return the levelBackImage
	 */
	public Bitmap getLevelBackImage() {
		return levelBackImage;
	}


	/**
	 * @param levelBackImage the levelBackImage to set
	 */
	public void setLevelBackImage(Bitmap levelBackImage) {
		this.levelBackImage = levelBackImage;
	}


	public void draw(Canvas canvas) {
		
		
		canvas.drawBitmap(levelBackImage, this.x, this.y, null);
		
		
		
		if(locked) {
//			this.levelRectPaint.setColor(Color.RED);
//			this.bitmapDrawable.setBounds(this.x + 300,this.y - 10 ,this.x + 400, this.y + 70);
//			this.bitmapDrawable.draw(canvas);
			
			float widthOfText = this.levelTextPaint.measureText(this.levelName);
			float xOfText = this.x + levelBackImage.getWidth()/2 - widthOfText/2;
			canvas.drawText(this.levelName, xOfText, this.y+55, this.levelTextPaint);
			
		} else {
		//	this.levelRectPaint.setColor(Color.WHITE);
			canvas.drawText(""+this.associatedLevel.getLevelGameStat().getStarCount(), this.x + levelBackImage.getWidth()/2 - 20, this.y + levelBackImage.getHeight()/2 +5, this.levelTextPaint);
			canvas.drawBitmap(starImage, this.x + levelBackImage.getWidth()/2 - 5, this.y + levelBackImage.getHeight()/2 - starImage.getHeight()/2 - 5, null);
			
		}
//		
		
	}
	
	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (this.x ) && (eventX <= (this.x + levelBackImage.getWidth()))) {
			   if (eventY >= (this.y ) && (eventY <= (this.y + levelBackImage.getHeight()))) {
				    
				   if(!locked) {
					   
					   
					   setLevelTouched(true);
					   if(this.homepanel!=null){
						   System.out.println("homepanel yes");
						   if(this.homepanel.getGamePanel()!=null) {
							   System.out.println("gamepanel yes");
						   } else {
							   System.out.println("homepanel no");
						   }
					   } else {
						   System.out.println("homepanel no");
						   if(this.homepanel.getGamePanel()!=null) {
							   System.out.println("gamepanel yes");
						   } else {
							   System.out.println("homepanel no");
						   }
					   }
					   BackButton.clicked = false;
					   this.homepanel.getGamePanel().setCurrentLevel(this);
					   this.homepanel.getGamePanel().setOngoingLevel(this.associatedLevel);
					  
					
					   this.homepanel.getGamePanel().setAlphaCount(255);
					   
					
				   } else {
					   setLevelTouched(false);
				   }
			   } else {
				   setLevelTouched(false);
			   }
			} else {
				  setLevelTouched(false);
			}
		
	}
	
	/**
	 * @return the associatedLevel
	 */
	public Level getAssociatedLevel() {
		return associatedLevel;
	}


	/**
	 * @param associatedLevel the associatedLevel to set
	 */
	public void setAssociatedLevel(Level associatedLevel) {
		this.associatedLevel = associatedLevel;
	}


	/**
	 * @return the homepanel
	 */
	public HomePanel getHomepanel() {
		return homepanel;
	}


	/**
	 * @param homepanel the homepanel to set
	 */
	public void setHomepanel(HomePanel homepanel) {
		this.homepanel = homepanel;
	}


	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	/**
	 * @return the levelDescription
	 */
	public String getLevelDescription() {
		return levelDescription;
	}

	/**
	 * @param levelDescription the levelDescription to set
	 */
	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	/**
	 * @return the levelScore
	 */
	public String getLevelScore() {
		return levelScore;
	}

	/**
	 * @param levelScore the levelScore to set
	 */
	public void setLevelScore(String levelScore) {
		this.levelScore = levelScore;
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
	
	public void setCordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the levelTouched
	 */
	public boolean isLevelTouched() {
		return levelTouched;
	}
	/**
	 * @param levelTouched the levelTouched to set
	 */
	public void setLevelTouched(boolean levelTouched) {
		this.levelTouched = levelTouched;
	}


	/**
	 * @return the levelTextPaint
	 */
	public Paint getLevelTextPaint() {
		return levelTextPaint;
	}


	/**
	 * @param levelTextPaint the levelTextPaint to set
	 */
	public void setLevelTextPaint(Paint levelTextPaint) {
		this.levelTextPaint = levelTextPaint;
	}


	/**
	 * @return the levelRectPaint
	 */
	public Paint getLevelRectPaint() {
		return levelRectPaint;
	}


	/**
	 * @param levelRectPaint the levelRectPaint to set
	 */
	public void setLevelRectPaint(Paint levelRectPaint) {
		this.levelRectPaint = levelRectPaint;
	}


	/**
	 * @return the textRect
	 */
	public RectF getTextRect() {
		return textRect;
	}


	/**
	 * @param textRect the textRect to set
	 */
	public void setTextRect(RectF textRect) {
		this.textRect = textRect;
	}


	/**
	 * @return the lockImageBitmap
	 */
	public Bitmap getLockImageBitmap() {
		return lockImageBitmap;
	}


	/**
	 * @param lockImageBitmap the lockImageBitmap to set
	 */
	public void setLockImageBitmap(Bitmap lockImageBitmap) {
		this.lockImageBitmap = lockImageBitmap;
	}


	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}


	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	
	
	

}
