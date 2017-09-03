/**
 * 
 */
package com.jumpandbalance.helper;

/**
 * @author TCS
 *
 */
public class Speed {

	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_LEFT = -1;
	public static final int DIRECTION_UP = -1;
	public static final int DIRECTION_DOWN = 1;
	
	private float xVelocity = 1;
	private float yVelocity = 1;
	
	private int xDirection = DIRECTION_RIGHT;
	private int yDirection = DIRECTION_DOWN;
	
	public Speed() {
		this.xVelocity = 10;
		this.yVelocity = -10.0f;
	}
	
	public Speed(int xVelocity, int yVelocity) {
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	/**
	 * @return the xVelocity
	 */
	public float getxVelocity() {
		return xVelocity;
	}
	/**
	 * @param xVelocity the xVelocity to set
	 */
	public void setxVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}
	/**
	 * @return the yVelocity
	 */
	public float getyVelocity() {
		return yVelocity;
	}
	/**
	 * @param yVelocity the yVelocity to set
	 */
	public void setyVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}
	/**
	 * @return the xDirection
	 */
	public int getxDirection() {
		return xDirection;
	}
	/**
	 * @param xDirection the xDirection to set
	 */
	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}
	/**
	 * @return the yDirection
	 */
	public int getyDirection() {
		return yDirection;
	}
	/**
	 * @param yDirection the yDirection to set
	 */
	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
	
	
}
