package jrJava.tetris;

import resources.SoundPlayer;

public class SoundEffect {

	private static SoundPlayer bgSound, bubble, arrow, eerie, shift;
	
	static {
		bgSound = new SoundPlayer();
		bubble = new SoundPlayer();
		arrow = new SoundPlayer();
		eerie = new SoundPlayer();
		shift = new SoundPlayer();
		
		String path = "jrJava/tetris/";
		bgSound.load(path + "imperialMarch.wav");
		bubble.load(path + "bubbling.wav");
		arrow.load(path + "arrow.wav");
		eerie.load(path + "eerie.wav");
		shift.load(path + "shift.wav");
	}
	
	
	public static void startBgMusic(){
		bgSound.playLoop();
	}
	
	public static void stopBgMusic(){
		bgSound.stop();
	}
	
	public static void moveDown(){
		bubble.play();
	}
	
	
	public static void rotate(){
		arrow.play();
	}
	
	public static void mirror(){
		arrow.play();
	}
	
	public static void shift(){
		shift.play();
	}
	
	public static void deleteRow(){
		eerie.play();
	}
}
