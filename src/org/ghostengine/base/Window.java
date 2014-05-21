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

/**
 * @author Ben Turner
 * @version 
 * @since 
 */
public class Window {

	private static int height;
	private static int width;
	private static String title;
	private static JFrame window;
	private static JPanel frame;
	private static boolean closeRequested = false;
	
	private static BufferedImage buffer;
	
	public static void requestClose() {
		closeRequested = true;
	}
	
	public static void createWindow(Dimension size, String title) {
		// Set variables
		height = size.height;
		width = size.width;		
		Window.title = title;
		
		// Create buffers
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
		frame.setSize(window.getContentPane().getSize());
		window.add(frame);
		Input listener = new Input();
		window.addKeyListener(listener);
		window.addMouseListener(listener);
		window.addMouseMotionListener(listener);
	}
	
	public static void createFullscreenWindow(String title) {
		Window.title = title;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		createWindow(size, title);
		window.setUndecorated(true);
		width = size.width;
		height = size.height;
	}
	
	public static void setVisible(boolean b) {
		window.setVisible(b);
	}
	
	public static void render() {
		// TODO
	}

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	public static String getTitle() {
		return title;
	}
	
	public static BufferedImage getBuffer() {
		if (buffer == null) {
			buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		return buffer;
	}
	
	public static boolean isCloseRequested() {
		return closeRequested;
	}
	
	public static void close() {
		window.dispose();
	}
}
