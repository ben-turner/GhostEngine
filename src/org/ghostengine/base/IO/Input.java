/**
 * 
 */
package org.ghostengine.base.IO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;

/**
 * @author Ben Turner
 * @version 
 * @since 
 */
public class Input implements KeyListener, MouseMotionListener, MouseInputListener {
	
	public static final int KEY_NONE		= 0;
	public static final int KEY_BACKSPACE	= 8;
	public static final int KEY_RETURN		= 10;
	public static final int KEY_NUM5		= 12;
	public static final int KEY_SHIFT		= 16;
	public static final int KEY_CONTROL		= 17;
	public static final int KEY_ALT			= 18;
	public static final int KEY_BREAK		= 19;
	public static final int KEY_CAPSLOCK	= 20;
	public static final int KEY_ESCAPE		= 27;
	public static final int KEY_PAGEUP		= 33;
	public static final int KEY_PAGEDOWN	= 34;
	public static final int KEY_END			= 35;
	public static final int KEY_HOME		= 36;
	public static final int KEY_LEFT		= 37;
	public static final int KEY_UP			= 38;
	public static final int KEY_RIGHT		= 39;
	public static final int KEY_DOWN		= 40;
	public static final int KEY_COMMA		= 44;
	public static final int KEY_MINUS		= 45;
	public static final int KEY_PERIOD		= 46;
	public static final int KEY_SLASH		= 47;
	public static final int KEY_0			= 48;
	public static final int KEY_1			= 49;
	public static final int KEY_2			= 50;
	public static final int KEY_3			= 51;
	public static final int KEY_4			= 52;
	public static final int KEY_5			= 53;
	public static final int KEY_6			= 54;
	public static final int KEY_7			= 55;
	public static final int KEY_8			= 56;
	public static final int KEY_9			= 57;
	public static final int KEY_SEMICOLON	= 59;
	public static final int KEY_EQUALS		= 61;
	public static final int KEY_A			= 65;
	public static final int KEY_B			= 66;
	public static final int KEY_C			= 67;
	public static final int KEY_D			= 68;
	public static final int KEY_E			= 69;
	public static final int KEY_F			= 70;
	public static final int KEY_G			= 71;
	public static final int KEY_H			= 72;
	public static final int KEY_I			= 73;
	public static final int KEY_J			= 74;
	public static final int KEY_K			= 75;
	public static final int KEY_L			= 76;
	public static final int KEY_M			= 77;
	public static final int KEY_N			= 78;
	public static final int KEY_O			= 79;
	public static final int KEY_P			= 80;
	public static final int KEY_Q			= 81;
	public static final int KEY_R			= 82;
	public static final int KEY_S			= 83;
	public static final int KEY_T			= 84;
	public static final int KEY_U			= 85;
	public static final int KEY_V			= 86;
	public static final int KEY_W			= 87;
	public static final int KEY_X			= 88;
	public static final int KEY_Y			= 89;
	public static final int KEY_Z			= 90;
	public static final int KEY_LBRACKET	= 91;
	public static final int KEY_BACKSLASH	= 92;
	public static final int KEY_RBRACKET	= 93;
	public static final int KEY_NUMPAD0		= 96;
	public static final int KEY_NUMPAD1		= 97;
	public static final int KEY_NUMPAD2		= 98;
	public static final int KEY_NUMPAD3		= 99;
	public static final int KEY_NUMPAD4		= 100;
	public static final int KEY_NUMPAD5		= 101;
	public static final int KEY_NUMPAD6		= 102;
	public static final int KEY_NUMPAD7		= 103;
	public static final int KEY_NUMPAD8		= 104;
	public static final int KEY_NUMPAD9		= 105;
	public static final int KEY_MULTIPLY	= 106;
	public static final int KEY_ADD			= 107;
	public static final int KEY_SUBTRACT	= 109;
	public static final int KEY_DECIMAL		= 110;
	public static final int KEY_DIVIDE		= 111;
	public static final int KEY_F1			= 112;
	public static final int KEY_F2			= 113;
	public static final int KEY_F3			= 114;
	public static final int KEY_F4			= 115;
	public static final int KEY_F5			= 116;
	public static final int KEY_F6			= 117;
	public static final int KEY_F7			= 118;
	public static final int KEY_F8			= 119;
	public static final int KEY_F9			= 120;
	public static final int KEY_F10			= 121;
	public static final int KEY_F11			= 122;
	public static final int KEY_F12			= 123;
	public static final int KEY_DELETE		= 127;
	public static final int KEY_CIRCUMFLEX	= 130;
	public static final int KEY_NUMLOCK		= 144;
	public static final int KEY_INSERT		= 155;
	public static final int KEY_GRAVE		= 192;
	public static final int KEY_APOSTROPHE	= 222;
	public static final int KEY_WINDOWS		= 524;
	public static final int KEY_MENU		= 525;
	
	
	static ArrayList<Byte> pressedKeys = new ArrayList<>();
	static ArrayList<keyWrapper> upKeys = new ArrayList<>();
	static int mouseX = 0;
	static int mouseY = 0;
	static boolean mouseL = false;
	static boolean mouseR = false;
	static boolean mouseC = false;

	public static boolean isKeyPressed(int keyCode) {
		return Input.pressedKeys.contains((byte) keyCode);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Input.pressedKeys.add((byte) e.getKeyCode());
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Input.upKeys.add(new keyWrapper((byte) e.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void update() {
		for (int i = 0; i < upKeys.size(); i++) {
			if (upKeys.get(i).doRemove()) {
				pressedKeys.remove((Object) upKeys.get(i).getKeyCode());
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Input.mouseX = (int) e.getLocationOnScreen().getX();
		Input.mouseY = (int) e.getLocationOnScreen().getY();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:
			mouseL = true;
			break;
		case 2:
			mouseR = true;
			break;
		case 3:
			mouseC = true;
			break;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			mouseL = false;
			break;
		case MouseEvent.BUTTON2:
			mouseC = false;
			break;
		case MouseEvent.BUTTON3:
			mouseR = false;
			break;
		}
	}
	
	class keyWrapper {
		boolean checkedOnce = false;
		byte keyCode;
		
		public keyWrapper(byte keyCode) {
			this.keyCode = keyCode;
		}
		
		public boolean doRemove() {
			if (checkedOnce) {
				return true;
			} else {
				checkedOnce = true;
				return false;
			}
		}
		
		public byte getKeyCode() {
			return keyCode;
		}
	}
}
