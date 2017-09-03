/**
 * 
 */
package com.jumpandbalance.gamedata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.content.Context;


/**
 * @author Priya
 *
 */
public class GameDataHelper {

	public static void saveGameData(GameData gameData, Context ctx) {
		if(gameData!=null) {
			try {
				ObjectOutputStream output;
				output = new ObjectOutputStream(ctx.openFileOutput("GameData.dat",0));
	            output.writeObject(gameData);
	            output.flush();
	            output.close();
	            System.out.println("game data saved");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
public static GameData restoreGameData(Context ctx){
		
		GameData gameData = null;
		
		ObjectInputStream input = null;
		
		try {
			input = new ObjectInputStream(ctx.openFileInput("GameData.dat"));
			gameData = (GameData) input.readObject();
			System.out.println("saved game data retrieved");
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch(IllegalArgumentException ill) {
			ill.printStackTrace();
			return null;
		}
		
		return gameData;
	}
	
	
	
	
}
