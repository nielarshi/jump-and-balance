/**
 * 
 */
package com.jumpandbalance.images;

import com.jumpandbalance.R;
import com.jumpandbalance.view.JumpAndBalanceGamePanel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author Priya
 *
 */
public class ImageHelper {
	
	private static ImageHelper imageHelper;
	
	public static final String HOME_BALL_1 = "homeball1";
	public static final String HOME_BALL_2 = "homeball2";
	public static final String HOME_BALL_3 = "homeball3";
	public static final String HOME_BALL_4 = "homeball4";
	public static final String HOME_BALL_5 = "homeball5";
	public static final String HOME_BALL_6 = "homeball6";
	public static final String HOME_BALL_7 = "homeball7";
	
	public static final String LOCK_IMAGE = "lock";
	
	public static final String RAIN = "rain";
	public static final String RAIN_2 = "rain2";
	
	public static final String SNOW_1 = "snow1";
	public static final String SNOW_2 = "snow2";
	public static final String SNOW_3 = "snow3";
	public static final String SNOW_4 = "snow4";
	
	public static final String UNDERWATER_1 = "underwater1";
	public static final String UNDERWATER_2 = "underwater2";
	public static final String UNDERWATER_PLANT_1 = "underwaterplant1";
	public static final String UNDERWATER_FISH_1 = "underwaterfish1";
	public static final String UNDERWATER_FISH_2 = "underwaterfish2";
	public static final String UNDERWATER_FISH_3 = "underwaterfish3";
	public static final String UNDERWATER_FISH_4 = "underwaterfish4";
	
	public static final String UNDERWATER_STAR_FISH_1 = "underwaterstarfish3";
	public static final String UNDERWATER_SHELL_1 = "underwatershell3";
	public static final String UNDERWATER_BUBBLE_1 = "underwaterbubble3";
	
	public static final String BIRD_1 = "bird1";
	public static final String BIRD_2 = "bird2";
	
	//for home screen
	public static final String BACKGROUND_GRASS = "background1";
	public static final String BOARD = "board1";
	public static final String WOOD_PLANK_SHORT = "woodplank1";
	public static final String WOOD_PLANK_MEDIUM = "woodplank2";
	public static final String WOOD_PLANK_LONG = "woodplank3";
	
	//for level screen
	public static final String BACKGROUND_UNDERWATER = "background2";
	//public static final String BUBBLE_BLUE = "bubble1";
	public static final String BUBBLE_SKYBLUE = "bubble2";
	public static final String BUBBLE_PINK = "bubble3";
	public static final String BUBBLE_GREEN = "bubble4";
	
	
	//for theme 1
	public static final String BACKGROUND_BUILDING = "background3";
	public static final String PILLAR = "pillar1";
	public static final String BALL = "ball1";
	
	
	public static final String SPRITE_BALL = "spriteball1";
	
	
	//for theme 2
	
	
	//some more bg
	public static final String PLAIN_BG_1 = "pbg1";
	public static final String LEVEL_OVER_BG = "levelover";
	
	public static final String ONGOING_LEVEL_BACK_IMAGE = "olbi1";
	public static final String LEVEL_BACK_IMAGE = "lbi1";
	public static final String LOCKED_LEVEL_BACK_IMAGE = "llbi1";
	
	public static final String PAPERNOTE_IMAGE = "pnb1";
	
	public static final String BACK_ICON_IMAGE = "bii1";
	public static final String HOME_ICON_IMAGE = "hii1";
	public static final String MUSIC_ICON_IMAGE = "mii1";
	public static final String MUSIC_MUTE_ICON_IMAGE = "mmii1";
	public static final String THEME_ICON_IMAGE = "tii1";
	public static final String HELP_ICON_IMAGE = "helpii";
	public static final String RELOAD_ICON_IMAGE = "reloadii";
	
	
	public static final String STAR_IMAGE = "si1";
	public static final String DIAMOND_IMAGE = "di1";
	public static final String DOUBLE_DIAMOND_IMAGE = "ddi1";
	
	public static final String MENU_IMAGE = "mi1";
	public static final String REPLAY_IMAGE = "ri1";
	public static final String PLAY_IMAGE = "pi1";
	public static final String CONTINUE_IMAGE = "ci1";
	public static final String OK_IMAGE = "oi1";
	public static final String CANCEL_IMAGE = "cai1";
	
	
	public static final String THEME_1_IMAGE = "t1i1";
	public static final String THEME_2_IMAGE = "t2i1";
	public static final String THEME_3_IMAGE = "t3i1";
	public static final String THEME_4_IMAGE = "t4i1";
	
	public static final String THEME_1_IMAGE_BIG = "t1i1b";
	public static final String THEME_2_IMAGE_BIG = "t2i1b";
	public static final String THEME_3_IMAGE_BIG = "t3i1b";
	public static final String THEME_4_IMAGE_BIG = "t4i1b";
	
	//Butterfly
	public static final String BUTTERFLY_ONE = "bfi1s";
	public static final String BUTTERFLY_TWO = "bfi2s";
	public static final String BUTTERFLY_THREE = "bfi3s";
	public static final String BUTTERFLY_FOUR = "bfi4s";
	public static final String BUTTERFLY_FIVE = "bfi5s";
	public static final String BUTTERFLY_SIX = "bfi6s";
	public static final String BUTTERFLY_SEVEN = "bf71s";
	public static final String BUTTERFLY_EIGHT = "bfi8s";
	public static final String BUTTERFLY_NINE = "bfi9s";
	public static final String BUTTERFLY_TEN = "bfi10s";
	public static final String BUTTERFLY_ELEVEN = "bfi11s";
	public static final String BUTTERFLY_TWELVE = "bfi12s";
	
	public static final String FIVE_STAR = "ffi1s";
	
	
	private Bitmap lockBitmap;
	
	//for home screen
	private Bitmap backgroundGrassBitmap;
	private Bitmap boardBitmap;
	private Bitmap woodPlankShortBitmap;
	private Bitmap woodPlankMediumBitmap;
	private Bitmap woodPlankLongBitmap;
	
	
	//for level screen
	private Bitmap backgroundUnderWaterBitmap;
	//private Bitmap bubbleBlueBitmap;
	private Bitmap bubbleSkyblueBitmap;
	private Bitmap bubblePinkBitmap;
	private Bitmap bubbleGreenBitmap;
	
	
	//for theme 1
	private Bitmap backgroundBuildingBitmap;
	private Bitmap pillarBitmap;
	private Bitmap ballBitmap;
	
	//for theme 2
	
	//some more bg
	private Bitmap plainBGBitmap;
	private Bitmap levelOverbg;

	private Bitmap ongoingLevelbackImage;
	private Bitmap levelbackImage;
	private Bitmap lockedLevelbackImage;
	private Bitmap papernoteBitmap;
	
	private Bitmap homeIconBitmap;
	private Bitmap musicIconBitmap;
	private Bitmap muteMusicIconBitmap;


	private Bitmap backIconBitmap;


	private Bitmap diamondIconBitmap;


	//private Bitmap doublediamondIconBitmap;


	private Bitmap replayIconBitmap;


	private Bitmap continueIconBitmap;
	
	
	private Bitmap okIconBitmap;
	
	
	private Bitmap cancelIconBitmap;
	
	private Bitmap menuIconBitmap;


	private Bitmap starIconBitmap;


	private Bitmap rainBitmap;


	private Bitmap themeIconImage;


	private Bitmap helpiconImage;


	private Bitmap rain2Bitmap;


	private Bitmap snow1Bitmap, snow2Bitmap;


	private Bitmap ballSpritesBitmap;


	private Bitmap theme1Bitmap;


	private Bitmap theme2Bitmap;


	private Bitmap theme3Bitmap;


	private Bitmap theme4Bitmap;


	private Bitmap underwater1Bitmap;


	private Bitmap underwater2Bitmap;


	private Bitmap underwaterPlant1SpriteBitmap;


	private Bitmap underwaterfish1SpriteBitmap;


	private Bitmap underwaterfish2SpriteBitmap;


	private Bitmap underwaterfish3SpriteBitmap;


	private Bitmap underwaterstarFish4SpriteBitmap;


	private Bitmap underwaterfish4SpriteBitmap;


	private Bitmap underwaterShell1SpriteBitmap;


	private Bitmap underwaterBubble1SpriteBitmap;


	private Bitmap bird11SpriteBitmap;


	private Bitmap bird12SpriteBitmap;


	private Bitmap homeBall1Bitmap;


	private Bitmap homeBall2Bitmap;


	private Bitmap homeBall3Bitmap;


	private Bitmap homeBall4Bitmap;

	private Bitmap homeBall5Bitmap;

	private Bitmap homeBall6Bitmap;

	private Bitmap homeBall7Bitmap;

	private Bitmap reloadiconImage;

	private Bitmap theme1Bitmap_big;

	private Bitmap theme2Bitmap_big;

	private Bitmap theme3Bitmap_big;

	private Bitmap theme4Bitmap_big;

	private Bitmap playIconBitmap;
	
	private Bitmap butterfly1Bitmap_s1;
	
	private Bitmap butterfly1Bitmap_s2;
	
	private Bitmap butterfly1Bitmap_s3;
	
	private Bitmap butterfly1Bitmap_s4;
	
	private Bitmap butterfly1Bitmap_s5;
	
	private Bitmap butterfly1Bitmap_s6;
	
	private Bitmap butterfly1Bitmap_s7;
	
	private Bitmap butterfly1Bitmap_s8;
	
	private Bitmap butterfly1Bitmap_s9;
	
	private Bitmap butterfly1Bitmap_s10;
	
	private Bitmap butterfly1Bitmap_s11;
	
	private Bitmap butterfly1Bitmap_s12;
	
	private Bitmap fiveStar_s;
	
	
	
	private ImageHelper() {
		
		BitmapFactory.Options o=new BitmapFactory.Options();
	//	o.inSampleSize = 0;
		o.inScaled = false;
		o.inDither=false;                    
		o.inPurgeable=true;                   
		
		
		homeBall1Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_1, o), 200, 50, true);
		homeBall2Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_g, o), 200, 50, true);
		homeBall3Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_m, o), 200, 50, true);
		homeBall4Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_o, o), 200, 50, true);
		homeBall5Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_p, o), 200, 50, true);
		homeBall6Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_r, o), 200, 50, true);
		homeBall7Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_y, o), 200, 50, true);
		
		
		
		lockBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.locked, o);
		
		rainBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.rain, o);
		//rain2Bitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.rain_1_small, o);
		
		snow1Bitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.snow1, o);
		snow2Bitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.snow2, o);
		
		underwater1Bitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.w12, o);
		underwater2Bitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.w22, o);
		
		underwaterPlant1SpriteBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.tree, o), 400, 401, true);
		underwaterfish1SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.fish12, o);
		underwaterfish2SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.fish13, o);
		underwaterfish3SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.fish14, o);
		underwaterfish4SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.fish15, o);
		
		underwaterstarFish4SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.startish11, o);
		underwaterShell1SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.shell11, o);
		underwaterBubble1SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.bubble11, o);
		
		bird11SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.bird_small1, o);
		bird12SpriteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.bird_small, o);
		
		
		//for home screen
		backgroundGrassBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.background_home_1, o);
		boardBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.board_home_1, o), 220, 80, true);
		woodPlankShortBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.pillar_home_1, o), 50, 250, true);
		woodPlankMediumBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.pillar_home_3, o), 50, 300, true);
		woodPlankLongBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.pillar_home_4, o), 50, 350, true);
		
		//for level screen
		backgroundUnderWaterBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.levelbg_s, o);
		//bubbleBlueBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.bubble1, o);
		bubbleSkyblueBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_score2, o), 80, 40, true);
		bubblePinkBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sun, o), 60, 60, true);
		bubbleGreenBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.buttons_3_shine, o);
		
		//for theme 1
		backgroundBuildingBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.building_7);
		pillarBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.pillar_11, o), 50, 350 ,true);
		ballBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball_r, o), 200, 50, true);
		
		ballSpritesBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.ball1, o);
		
		
		
		//for theme 2

		
		
		//some more bg
		plainBGBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.score_s, o);
		levelOverbg = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.score_txt_s, o);
		ongoingLevelbackImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.buttons_5, o), 100,100, true);
		levelbackImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.buttons_3_shine, o), 100, 100, true);
		lockedLevelbackImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.buttons_4_shine, o), 100, 100, true);
		
		papernoteBitmap = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.pin_3, o);
		
		backIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_back, o), 50, 50, true);
		homeIconBitmap =Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_home, o), 50, 50, true);
		musicIconBitmap =Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_music, o), 50, 50, true);
		muteMusicIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_mute, o), 50, 50, true);
		themeIconImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_theme, o), 50, 50, true);
		helpiconImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_question, o), 50, 50, true);
		reloadiconImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_replay, o), 50, 50, true);
		
		
		starIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.star, o), 50, 50, true);
		diamondIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.diamond_1, o), 50, 50, true);
		//doublediamondIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.diamond5_double, o), 50, 50, true);
		
		menuIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_menu, o), 60, 60, true);
		replayIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_replay, o), 60, 60, true);
		playIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_play, o), 60, 60, true);
		
		continueIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_continue, o), 60, 60, true);
		okIconBitmap= Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_ok, o), 60, 60, true);
		cancelIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.f_cancel, o), 60, 60, true);
		
		
		//theme image
		
		theme1Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme1_s, o), 90, 60, true);
		theme2Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme2_s, o), 90, 60, true);
		theme3Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme3_s, o), 90, 60, true);
		theme4Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme4_s, o), 90, 60, true);
		
		theme1Bitmap_big = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme1_b, o), 450, 260, true);
		theme2Bitmap_big = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme2_b, o), 450, 260, true);
		theme3Bitmap_big = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme3_b, o), 450, 260, true);
		theme4Bitmap_big = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.sample_theme4_b, o), 450, 260, true);
		
		//butterfly
		
		butterfly1Bitmap_s1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly1, o), 140, 60, true);
		butterfly1Bitmap_s2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly2, o), 280, 80, true);
		butterfly1Bitmap_s3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly3, o), 140, 60, true);
		butterfly1Bitmap_s4 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly4, o), 280, 80, true);
		butterfly1Bitmap_s5 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly5, o), 350, 100, true);
		butterfly1Bitmap_s6 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly6, o), 70, 40, true);
		butterfly1Bitmap_s7 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly7, o), 350, 100, true);
		butterfly1Bitmap_s8 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly8, o), 280, 80, true);
		butterfly1Bitmap_s9 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly9, o), 70, 40,true);
		butterfly1Bitmap_s10 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly10, o), 280, 100, true);
		butterfly1Bitmap_s11 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly11, o), 70, 40, true);
		butterfly1Bitmap_s12 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.butterfly12, o), 140, 60, true);
		fiveStar_s = BitmapFactory.decodeResource(JumpAndBalanceGamePanel.context.getResources(), R.drawable.fivestar_s, o);
	}
	
	public static ImageHelper getInstance() {
		if(imageHelper==null) {
			System.out.println("Image helper null");
			imageHelper = new ImageHelper();
		}
		return imageHelper;
	}
	
	public Bitmap getImageFor(String seekerName) {

		if (seekerName.equals(HOME_BALL_1)) {
			
			return this.homeBall1Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_2)) {
			
			return this.homeBall2Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_3)) {
			
			return this.homeBall3Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_4)) {
			
			return this.homeBall4Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_5)) {
			
			return this.homeBall5Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_6)) {
			
			return this.homeBall6Bitmap;
		
		} else if (seekerName.equals(HOME_BALL_7)) {
			
			return this.homeBall7Bitmap;
		
		} else if (seekerName.equals(RAIN)) {
			
			return this.rainBitmap;
		
		} else if (seekerName.equals(RAIN_2)) {
			
			return this.rain2Bitmap;
		
		} else if (seekerName.equals(UNDERWATER_1)) {
			
			return this.underwater1Bitmap;
		
		} else if (seekerName.equals(UNDERWATER_2)) {
			
			return this.underwater2Bitmap;
		
		} else if (seekerName.equals(UNDERWATER_PLANT_1)) {
			
			return this.underwaterPlant1SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_FISH_1)) {
			
			return this.underwaterfish1SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_FISH_2)) {
			
			return this.underwaterfish2SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_FISH_3)) {
			
			return this.underwaterfish3SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_FISH_4)) {
			
			return this.underwaterfish4SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_STAR_FISH_1)) {
			
			return this.underwaterstarFish4SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_SHELL_1)) {
			
			return this.underwaterShell1SpriteBitmap;
		
		} else if (seekerName.equals(UNDERWATER_BUBBLE_1)) {
			
			return this.underwaterBubble1SpriteBitmap;
		
		} else if (seekerName.equals(BIRD_1)) {
			
			return this.bird11SpriteBitmap;
		
		} else if (seekerName.equals(BIRD_2)) {
			
			return this.bird12SpriteBitmap;
		
		} else if (seekerName.equals(BACKGROUND_GRASS)) {
			
			return this.backgroundGrassBitmap;
		
		} else if (seekerName.equals(BOARD)) {
			
			return this.boardBitmap;
		
		} else if (seekerName.equals(WOOD_PLANK_SHORT)) {
		
			return this.woodPlankShortBitmap;
		
		} else if (seekerName.equals(WOOD_PLANK_MEDIUM)) {
			
			return this.woodPlankMediumBitmap;
		
		} else if (seekerName.equals(WOOD_PLANK_LONG)) {
			
			return this.woodPlankLongBitmap;
		
		} else if (seekerName.equals(BACKGROUND_UNDERWATER)) {
		
			return this.backgroundUnderWaterBitmap;
		
		} /*else if (seekerName.equals(BUBBLE_BLUE)) {
			
			return this.bubbleBlueBitmap;
		
		}*/ else if (seekerName.equals(BUBBLE_SKYBLUE)) {
		
			return this.bubbleSkyblueBitmap;
		
		} else if (seekerName.equals(BUBBLE_PINK)) {
		
			return this.bubblePinkBitmap;
		
		} else if (seekerName.equals(BUBBLE_GREEN)) {
			
			return this.bubbleGreenBitmap;
		
		} else if (seekerName.equals(BACKGROUND_BUILDING)) {
			
			return this.backgroundBuildingBitmap;
		
		} else if (seekerName.equals(PILLAR)) {
			
			return this.pillarBitmap;
		
		} else if (seekerName.equals(BALL)) {
		
			return this.ballBitmap;
		
		} else if (seekerName.equals(PLAIN_BG_1)) {
		
			return this.plainBGBitmap;
		
		}else if (seekerName.equals(LEVEL_OVER_BG)) {
				
				return this.levelOverbg;
			
		}else if (seekerName.equals(LOCK_IMAGE)) {
			
			return this.lockBitmap;
		
		} else if (seekerName.equals(ONGOING_LEVEL_BACK_IMAGE)) {
			
			return this.ongoingLevelbackImage;
		
		} else if (seekerName.equals(LEVEL_BACK_IMAGE)) {
			
			return this.levelbackImage;
		
		} else if (seekerName.equals(LOCKED_LEVEL_BACK_IMAGE)) {
			
			return this.lockedLevelbackImage;
		
		} else if (seekerName.equals(PAPERNOTE_IMAGE)) {
			
			return this.papernoteBitmap;
		
		} else if (seekerName.equals(HOME_ICON_IMAGE)) {
			
			return this.homeIconBitmap;
		
		} else if (seekerName.equals(MUSIC_ICON_IMAGE)) {
			
			return this.musicIconBitmap;
		
		} else if (seekerName.equals(MUSIC_MUTE_ICON_IMAGE)) {
			
			return this.muteMusicIconBitmap;
		
		} else if (seekerName.equals(BACK_ICON_IMAGE)) {
			
			return this.backIconBitmap;
		
		} else if (seekerName.equals(STAR_IMAGE)) {
			
			return this.starIconBitmap;
		
		} else if (seekerName.equals(DIAMOND_IMAGE)) {
			
			return this.diamondIconBitmap;
		
		} /*else if (seekerName.equals(DOUBLE_DIAMOND_IMAGE)) {
			
			return this.doublediamondIconBitmap;
		
		}*/ else if (seekerName.equals(REPLAY_IMAGE)) {
			
			return this.replayIconBitmap;
		
		} else if (seekerName.equals(PLAY_IMAGE)) {
			
			return this.playIconBitmap;
		
		} else if (seekerName.equals(CONTINUE_IMAGE)) {
			
			return this.continueIconBitmap;
		
		}else if (seekerName.equals(OK_IMAGE)) {
			
			return this.okIconBitmap;
		
		}else if (seekerName.equals(CANCEL_IMAGE)) {
			
			return this.cancelIconBitmap;
		
		}else if (seekerName.equals(MENU_IMAGE)) {
			
			return this.menuIconBitmap;
		
		}  else if (seekerName.equals(THEME_ICON_IMAGE)) {
			
			return this.themeIconImage;
		
		} else if (seekerName.equals(HELP_ICON_IMAGE)) {
			
			return this.helpiconImage;
		
		} else if (seekerName.equals(RELOAD_ICON_IMAGE)) {
			
			return this.reloadiconImage;
		
		} else if (seekerName.equals(SNOW_1)) {
			
			return this.snow1Bitmap;
		
		}else if (seekerName.equals(SNOW_2)) {
			
			return this.snow2Bitmap;
		
		} else if (seekerName.equals(SPRITE_BALL)) {
			
			return this.ballSpritesBitmap;
		
		} else if (seekerName.equals(THEME_1_IMAGE)) {
			
			return this.theme1Bitmap;
		
		} else if (seekerName.equals(THEME_2_IMAGE)) {
			
			return this.theme2Bitmap;
		
		} else if (seekerName.equals(THEME_3_IMAGE)) {
			
			return this.theme3Bitmap;
		
		} else if (seekerName.equals(THEME_4_IMAGE)) {
			
			return this.theme4Bitmap;
		
		} else if (seekerName.equals(THEME_1_IMAGE_BIG)) {
			
			return this.theme1Bitmap_big;
		
		} else if (seekerName.equals(THEME_2_IMAGE_BIG)) {
			
			return this.theme2Bitmap_big;
		
		} else if (seekerName.equals(THEME_3_IMAGE_BIG)) {
			
			return this.theme3Bitmap_big;
		
		} else if (seekerName.equals(THEME_4_IMAGE_BIG)) {
			
			return this.theme4Bitmap_big;
			
		}else if (seekerName.equals(BUTTERFLY_ONE)) {
			
			return this.butterfly1Bitmap_s1;
			
		}else if (seekerName.equals(BUTTERFLY_TWO)) {
			
			return this.butterfly1Bitmap_s2;
			
		}else if (seekerName.equals(BUTTERFLY_THREE)) {
			
			return this.butterfly1Bitmap_s3;
		
		}else if (seekerName.equals(BUTTERFLY_FOUR)) {
			
			return this.butterfly1Bitmap_s4;
		
		}else if (seekerName.equals(BUTTERFLY_FIVE)) {
			
			return this.butterfly1Bitmap_s5;
		
		}else if (seekerName.equals(BUTTERFLY_SIX)) {
			
			return this.butterfly1Bitmap_s6;
			
		}else if (seekerName.equals(BUTTERFLY_SEVEN)) {
			
			return this.butterfly1Bitmap_s7;
			
		}else if (seekerName.equals(BUTTERFLY_EIGHT)) {
			
			return this.butterfly1Bitmap_s8;
			
		}else if (seekerName.equals(BUTTERFLY_NINE)) {
			
			return this.butterfly1Bitmap_s9;
		
		}else if (seekerName.equals(BUTTERFLY_TEN)) {
			
			return this.butterfly1Bitmap_s10;
		
		}else if (seekerName.equals(BUTTERFLY_ELEVEN)) {
			
			return this.butterfly1Bitmap_s11;
		
		}else if (seekerName.equals(BUTTERFLY_TWELVE)) {
			
			return this.butterfly1Bitmap_s12;
			
		}else if (seekerName.equals(FIVE_STAR)) {
			
			return this.fiveStar_s;
		}
		
				
		return null;
	}
}
