/**
 * 
 */
package com.jumpandbalance.actors;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author Niel
 *
 */
public class BallPath {

	private int x;
	private int y;
	private Paint paint;
	private Ball ball;
	private float currentTimeInAir=0;
	private ArrayList<Integer> xPoints;
	private ArrayList<Integer> yPoints;
	private int count=0;
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
		x=this.ball.getX();
		y=this.ball.getY();
		xPoints.add(x);
		yPoints.add(y);
	}
	public BallPath() {
		
		this.paint = new Paint(); 
		this.paint.setStrokeWidth(15.0f);
		this.paint.setColor(Color.GRAY); 
		this.xPoints=new ArrayList<Integer>();
		this.yPoints=new ArrayList<Integer>();
	}
	public void draw(Canvas canvas) {
		int index = 0;
		int yPoint = 0;
		for(int xPoint : xPoints){
			yPoint=yPoints.get(index++);
			canvas.drawPoint(xPoint, yPoint, paint);
		}
		
		
	}
	
	public void update() {
		
			updateBallPathXY();
		
	}
	private void updateBallPathXY() {
		count++;
		ball.getSpeed().setyVelocity((float)(ball.getSpeed().getyVelocity()+( 0.5 * currentTimeInAir)));        // Apply gravity to vertical velocity
		x += ball.getSpeed().getxVelocity() * currentTimeInAir;      // Apply horizontal velocity to X position
		y += ball.getSpeed().getyVelocity() * currentTimeInAir;      // Apply vertical velocity to X position
		currentTimeInAir+=0.02;
		System.out.println(x+"==========?"+y);
		if(count%7==0){
			xPoints.add(x);
			yPoints.add(y);
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
	 * @return the currentTimeInAir
	 */
	public float getCurrentTimeInAir() {
		return currentTimeInAir;
	}
	/**
	 * @param currentTimeInAir the currentTimeInAir to set
	 */
	public void setCurrentTimeInAir(float currentTimeInAir) {
		this.currentTimeInAir = currentTimeInAir;
	}
	/**
	 * @return the xPoints
	 */
	public ArrayList<Integer> getxPoints() {
		return xPoints;
	}
	/**
	 * @param xPoints the xPoints to set
	 */
	public void setxPoints(ArrayList<Integer> xPoints) {
		this.xPoints = xPoints;
	}
	/**
	 * @return the yPoints
	 */
	public ArrayList<Integer> getyPoints() {
		return yPoints;
	}
	/**
	 * @param yPoints the yPoints to set
	 */
	public void setyPoints(ArrayList<Integer> yPoints) {
		this.yPoints = yPoints;
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
	
	
}
