/**
 * 
 */
package com.jumpandbalance.media;

import android.content.Context;
import android.media.MediaPlayer;

import com.jumpandbalance.R;

/**
 * @author Priya
 *
 */
public class MediaHelper {

	private static MediaHelper mediahelper;
	private Context context;
	private static MediaPlayer mainlevelScreenBackgroundMusic;
	private static MediaPlayer mainlevelSelectionMusic;
	private static MediaPlayer subLevelScreenBackgroundMusic;
	private static MediaPlayer subLevelSelectionMusic;
	private static MediaPlayer onGoingLevelBackgroundMusic;
	private static MediaPlayer ballJumpMusic;
	private static MediaPlayer ballFallSuccessMusic;
	private static MediaPlayer ballFallFailedMusic;
	private static MediaPlayer levelOverMusic;
	private static MediaPlayer backButtonPressedSound;
	
	private MediaHelper(Context context) {
		this.context = context;
	}
	
	public static MediaHelper getInstance(Context context) {
		if(mediahelper==null) {
			mediahelper = new MediaHelper(context);
			
			mainlevelScreenBackgroundMusic = MediaPlayer.create(context, R.raw.hiphop1);
			mainlevelSelectionMusic = MediaPlayer.create(context, R.raw.hiphop1);
			subLevelScreenBackgroundMusic = MediaPlayer.create(context, R.raw.hiphop2);
			subLevelSelectionMusic = MediaPlayer.create(context, R.raw.hiphop1);
			onGoingLevelBackgroundMusic = MediaPlayer.create(context, R.raw.hiphop1);
			ballJumpMusic = MediaPlayer.create(context, R.raw.hiphop1);
			ballFallSuccessMusic = MediaPlayer.create(context, R.raw.hiphop1);
			ballFallFailedMusic = MediaPlayer.create(context, R.raw.hiphop1);
			levelOverMusic = MediaPlayer.create(context, R.raw.hiphop1);
			backButtonPressedSound = MediaPlayer.create(context, R.raw.hiphop1);
			
		}
		
		return mediahelper;
	}

	/**
	 * @return the mainlevelScreenBackgroundMusic
	 */
	public MediaPlayer getMainlevelScreenBackgroundMusic() {
		return mainlevelScreenBackgroundMusic;
	}

	/**
	 * @param mainlevelScreenBackgroundMusic the mainlevelScreenBackgroundMusic to set
	 */
	public void setMainlevelScreenBackgroundMusic(
			MediaPlayer mainlevelScreenBackgroundMusic) {
		MediaHelper.mainlevelScreenBackgroundMusic = mainlevelScreenBackgroundMusic;
	}

	/**
	 * @return the mainlevelSelectionMusic
	 */
	public MediaPlayer getMainlevelSelectionMusic() {
		return mainlevelSelectionMusic;
	}

	/**
	 * @param mainlevelSelectionMusic the mainlevelSelectionMusic to set
	 */
	public void setMainlevelSelectionMusic(
			MediaPlayer mainlevelSelectionMusic) {
		MediaHelper.mainlevelSelectionMusic = mainlevelSelectionMusic;
	}

	/**
	 * @return the subLevelScreenBackgroundMusic
	 */
	public MediaPlayer getSubLevelScreenBackgroundMusic() {
		return subLevelScreenBackgroundMusic;
	}

	/**
	 * @param subLevelScreenBackgroundMusic the subLevelScreenBackgroundMusic to set
	 */
	public void setSubLevelScreenBackgroundMusic(
			MediaPlayer subLevelScreenBackgroundMusic) {
		MediaHelper.subLevelScreenBackgroundMusic = subLevelScreenBackgroundMusic;
	}

	/**
	 * @return the subLevelSelectionMusic
	 */
	public MediaPlayer getSubLevelSelectionMusic() {
		return subLevelSelectionMusic;
	}

	/**
	 * @param subLevelSelectionMusic the subLevelSelectionMusic to set
	 */
	public void setSubLevelSelectionMusic(MediaPlayer subLevelSelectionMusic) {
		MediaHelper.subLevelSelectionMusic = subLevelSelectionMusic;
	}

	/**
	 * @return the onGoingLevelBackgroundMusic
	 */
	public MediaPlayer getOnGoingLevelBackgroundMusic() {
		return onGoingLevelBackgroundMusic;
	}

	/**
	 * @param onGoingLevelBackgroundMusic the onGoingLevelBackgroundMusic to set
	 */
	public void setOnGoingLevelBackgroundMusic(
			MediaPlayer onGoingLevelBackgroundMusic) {
		MediaHelper.onGoingLevelBackgroundMusic = onGoingLevelBackgroundMusic;
	}

	/**
	 * @return the ballJumpMusic
	 */
	public MediaPlayer getBallJumpMusic() {
		return ballJumpMusic;
	}

	/**
	 * @param ballJumpMusic the ballJumpMusic to set
	 */
	public void setBallJumpMusic(MediaPlayer ballJumpMusic) {
		MediaHelper.ballJumpMusic = ballJumpMusic;
	}

	/**
	 * @return the ballFallSuccessMusic
	 */
	public MediaPlayer getBallFallSuccessMusic() {
		return ballFallSuccessMusic;
	}

	/**
	 * @param ballFallSuccessMusic the ballFallSuccessMusic to set
	 */
	public void setBallFallSuccessMusic(MediaPlayer ballFallSuccessMusic) {
		MediaHelper.ballFallSuccessMusic = ballFallSuccessMusic;
	}

	/**
	 * @return the ballFallFailedMusic
	 */
	public MediaPlayer getBallFallFailedMusic() {
		return ballFallFailedMusic;
	}

	/**
	 * @param ballFallFailedMusic the ballFallFailedMusic to set
	 */
	public void setBallFallFailedMusic(MediaPlayer ballFallFailedMusic) {
		MediaHelper.ballFallFailedMusic = ballFallFailedMusic;
	}

	/**
	 * @return the levelOverMusic
	 */
	public MediaPlayer getLevelOverMusic() {
		return levelOverMusic;
	}

	/**
	 * @param levelOverMusic the levelOverMusic to set
	 */
	public void setLevelOverMusic(MediaPlayer levelOverMusic) {
		MediaHelper.levelOverMusic = levelOverMusic;
	}

	/**
	 * @return the backButtonPressedSound
	 */
	public MediaPlayer getBackButtonPressedSound() {
		return backButtonPressedSound;
	}

	/**
	 * @param backButtonPressedSound the backButtonPressedSound to set
	 */
	public void setBackButtonPressedSound(MediaPlayer backButtonPressedSound) {
		MediaHelper.backButtonPressedSound = backButtonPressedSound;
	}

	
	
	
}
