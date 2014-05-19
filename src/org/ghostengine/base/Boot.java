package org.ghostengine.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import my_games.LineTest;

public class Boot {
	
	public static void main(String[] args) {
		Boot boot = new Boot();
		//boot.loadGames();
		new LineTest().run();
		//boot.loadGameList();
	}

	public void loadGames() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(null);
		File classFile = fc.getSelectedFile();

		ClassLoader loader = null;

		try {
			loader = new URLClassLoader(new URL[] { classFile.getParentFile().toURI().toURL() }, getClass().getClassLoader());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		}

		try {
			String filename = classFile.getName();
			Class<?> cls = loader.loadClass(filename.substring(0,
					filename.length() - 6));
			cls.getMethod("run").invoke(cls.newInstance());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}

	}
	
	public void loadGameList() {
		ClassLoader cl = null;
		try {
			File gamesDir = new File("D:/GhostEngine/Games/bin");
			ArrayList<URL> games = new ArrayList<>();
			for (File f : gamesDir.listFiles()) {
				if (f.isFile() && f.getName().toLowerCase().endsWith(".class"))
					games.add(f.toURI().toURL());
			}
			cl = new URLClassLoader(games.toArray(new URL[games.size()]), getClass().getClassLoader());
			cl.getParent();
		} catch (MalformedURLException e) {
			
		}
	}
}
