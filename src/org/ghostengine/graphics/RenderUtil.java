/**
 * 
 */
package org.ghostengine.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.ghostengine.base.Window;

/**
 * @author Ben Turner
 * @version
 * @since
 */
public class RenderUtil {

	public static void clearScreen() {
		BufferedImage screen = Window.getBuffer();
		for (int i = 0; i < Window.getHeight(); i++) {
			for (int j = 0; j < Window.getWidth(); j++) {
				screen.setRGB(j, i, Color.black.getRGB());
			}
		}
		// TODO: ZBuffer
	}

	public static void clearScreen(Color c) {
		BufferedImage screen = Window.getBuffer();
		for (int i = 0; i < Window.getHeight(); i++) {
			for (int j = 0; j < Window.getWidth(); j++) {
				screen.setRGB(j, i, c.getRGB());
			}
		}
		// TODO: ZBuffer
	}
}
