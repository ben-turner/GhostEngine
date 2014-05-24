/**
 * 
 */
package org.ghostengine.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.ghostengine.base.IO.Input;
import org.ghostengine.project.Broken;

/**
 * Window is the class used to create and store a game window.
 * 
 * @author Ben Turner
 * @version 1.0
 * @since 1.0
 */
public class Window {

	private static int height;
	private static int width;
	private static String title;
	private static JFrame window;
	private static JPanel frame;
	
	/**
	 *  Used by {@link #Game} to determine when to stop the game.
	 */
	private static boolean closeRequested = false;

	/**
	 * The buffer is a bitmap waiting to be drawn to the window.
	 */
	private static BufferedImage buffer;

	/**
	 * Sets {@link #closeRequested} as true.
	 */
	public static void requestClose() {
		closeRequested = true;
	}

	/**
	 * Creates a windowed (not full-screen) game window of the specified dimensions with the specified title.
	 * 
	 * @param size The width and hight of the window.
	 * @param title The window title.
	 */
	@Broken(Description = "Window is created with minimum possible size.")
	public static void createWindow(Dimension size, String title) {
		// FIXME Window is created with minimum possible size.
		// Set variables
		height = size.height;
		width = size.width;
		Window.title = title;

		// Create content buffer
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Create window
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				closeRequested = true;
			}
		});

		frame = new JPanel() {
			private static final long serialVersionUID = 4268219540828240804L;

			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(buffer, 0, 0, frame);
			}
		};
		frame.setSize(width, height);
		window.add(frame);
		Input listener = new Input();
		window.addKeyListener(listener);
		window.addMouseListener(listener);
		window.addMouseMotionListener(listener);
	}

	/**
	 * Creates a full-screen, undecorated game window.
	 * @param title The window title.
	 */
	@Broken(Description = "Window is invisible.")
	public static void createFullscreenWindow(String title) {
		// FIXME Window is created with minimum possible size.
		Window.title = title;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		createWindow(size, title);
		window.setUndecorated(true);
		width = size.width;
		height = size.height;
	}

	/**
	 * Calls {@link #JFrame.setVisible()} with the specified value.
	 * @param b 
	 */
	public static void setVisible(boolean b) {
		window.setVisible(b);
	}

	public static void render() {
		// TODO create rendering logic
	}

	/**
	 * @return The height of the drawing area.
	 */
	public static int getHeight() {
		return height;
	}

	/**
	 * @return The width of the drawing area.
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * @return The window title.
	 */
	public static String getTitle() {
		return title;
	}

	/**
	 * This method gets a bitmap used to draw to the window.
	 * @return The window buffer.
	 */
	public static BufferedImage getBuffer() {
		if (buffer == null) {
			buffer = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
		}
		return buffer;
	}

	/**
	 * Checks if {@link #requestClose()} has been called.
	 * 
	 * @return {@link closeRequested}
	 */
	public static boolean isCloseRequested() {
		return closeRequested;
	}

	/**
	 * Closes the window immediately without finishing the drawing loop or calling {@link #Game.onStop()}.
	 */
	public static void close() {
		window.dispose();
	}
}
