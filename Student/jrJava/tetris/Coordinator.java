package jrJava.tetris;

public class Coordinator {

	public static final int SCREEN_WIDTH = 280, SCREEN_HEIGHT = 680;
	
	public static boolean needToCreateNewTetrisObject = true;
	public static JDrawingBoard board = new JDrawingBoard(SCREEN_WIDTH , SCREEN_HEIGHT);
	public static TetrisObject currentTetris;
	
	public static int[][] templates = {
			{1, 1, 1,  1, 1, 1,  1, 1, 1},
			{0, 1, 0,  0, 1, 0,  0, 1, 1},
			{1, 1, 0,  0, 1, 0,  0, 1, 1},
			{0, 1, 0,  1, 1, 1,  0, 1, 0},
			{1, 0, 0,  1, 0, 0,  1, 1, 1},
			{0, 1, 1,  1, 1, 1,  1, 1, 0},
			{0, 1, 0,  0, 1, 0,  1, 1, 1} 
	};
	
	
	public static int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xffff00ff, 0xff00ffff};
	
	
	public static void main(String[] args) {
		
		int sleepInterval = 10;
		int drawInterval = 5*sleepInterval;
		int moveInterval = drawInterval*10;
		long nextDrawTime = System.currentTimeMillis();
		long nextMoveTime = System.currentTimeMillis();
		
		SoundEffect.startBgMusic();
		
		while(true){
			
			if(needToCreateNewTetrisObject) {
				createNewTetrisObject();
			}
			
			if(System.currentTimeMillis()>nextMoveTime){
				currentTetris.moveDown();
				nextMoveTime += moveInterval;
			}
			
			if(System.currentTimeMillis()>nextDrawTime){
				board.clearCanvas();
				board.clearTCanvas();
				Graveyard.draw(board.getCanvas());
				currentTetris.draw(board.getTCanvas());
				board.repaint();
				nextDrawTime += drawInterval;
			}
			
			try {
				Thread.sleep(sleepInterval);
			} catch (InterruptedException e) { }
		}
	}

	
	public static void createNewTetrisObject(){
		if(currentTetris!=null) board.removeKeyListener(currentTetris);
		currentTetris = new TetrisObject(templates[(int)(Math.random()*templates.length)], 
                colors[(int)(Math.random()*colors.length)]);
		board.addKeyListener(currentTetris);
		needToCreateNewTetrisObject = false;
	}

}








