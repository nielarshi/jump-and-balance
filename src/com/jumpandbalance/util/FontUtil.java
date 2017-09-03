/**
 * 
 */
package com.jumpandbalance.util;

import com.jumpandbalance.MainActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * @author Priya
 *
 */
public class FontUtil {

	public static final String ALL_CAPS_FONT = "All Caps.ttf";
	public static final String AIRMOLE_SHADED = "Airmole Shaded.ttf";
	public static final String AIRMOLE = "Airmole.ttf";
	public static final String AIRMOLE_STRIPE = "Airmole Stripe.ttf";
	public static final String ALTAMONTE_NF = "AltamonteNF.ttf";
	public static final String AQUARIUM = "Aquarium.ttf";
	public static final String ASTIGMA_REGULAR = "Astigma Regular.ttf";
	public static final String ASTRO_CREEP_2 = "Astro Creep 2.ttf";
	public static final String AUSTRALIAN_SUNSET = "Australian Sunset.ttf";
	public static final String CAMEO_APPEARANCE = "CameoAppearance.ttf";
	public static final String CANADIAN_AUTUMN = "Canadian Autumn.ttf";
	public static final String CAN_GOODS = "CanGoods.ttf";
	public static final String CAVEMAN = "Caveman.ttf";
	public static final String DECORINA = "Decorina.ttf";
	public static final String DAEL_CALLIGRAPHY = "Dael Calligraphy.ttf";
	public static final String GASTBY_REGULAR = "Gatsby Regular.ttf";
	
	
	public static Paint getFontPaint(String fontName) {
		Paint paint = new Paint();
	    paint.setColor(Color.BLACK);
	    paint.setTextSize(40);
	    Typeface chops = Typeface.createFromAsset(MainActivity.gamePanel.getResources().getAssets(),
	    		fontName);
	    paint.setTypeface(chops);
		return paint;
	}
	
	public static Paint getFontPaint(String fontName, int fontSize) {
		Paint paint = new Paint();
	    paint.setColor(Color.BLACK);
	    paint.setTextSize(fontSize);
	    Typeface chops = Typeface.createFromAsset(MainActivity.gamePanel.getResources().getAssets(),
	    		fontName);
	    paint.setTypeface(chops);
		return paint;
	}
	
	public static Paint getFontPaint(String fontName, int color, int fontSize) {
		Paint paint = new Paint();
	    paint.setColor(color);
	    paint.setTextSize(fontSize);
	    Typeface chops = Typeface.createFromAsset(MainActivity.gamePanel.getResources().getAssets(),
	    		fontName);
	    paint.setTypeface(chops);
		return paint;
	}
}
