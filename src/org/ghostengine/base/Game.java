/**
 * 
 */
package org.ghostengine.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.ghostengine.base.IO.Input;

/**
 * @author Ben Turner
 * @version 
 * @since 
 */
public abstract class Game {
	
	private BufferedImage drawingBuffer;
	private boolean isRunning;
	
	public final int HEIGHT;
	public final int WIDTH;
	public final String TITLE;
	
	private static boolean run = true;
	
	public Game(int width, int height, String title) {
		HEIGHT = height;
		WIDTH = width;
		TITLE = title;
	}
	
	public Game(String title) {
		Window.createFullscreenWindow(title);
		WIDTH = Window.getWidth();
		HEIGHT = Window.getHeight();
		TITLE = title;
	}
	
	public void run() {
		onStart();
		Window.createWindow(new Dimension(WIDTH, HEIGHT), TITLE);
		drawingBuffer = Window.getBuffer();
		Window.setVisible(true);
		
		while(run) {
			if (Window.isCloseRequested()) {
				quit();
			}
			Input.update();
			update();
			drawGUI(drawingBuffer.getGraphics());
		}
		onStop();
		Window.close();
		System.exit(0);
	}
	
	protected abstract void onStart();
	protected abstract void update();
	protected abstract void drawGUI(Graphics g);
	protected abstract void onStop();

	public boolean isRunning() {
		return isRunning;
	}
	
	public void quit() {
		run = false;
	}
}
