package org.ghostengine.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * 
 */
public class Boot {

	public static void main(String[] args) {
		Boot boot = new Boot();
		try {
			boot.loadGameList();
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @deprecated  Replaced by {@link #loadGameList()}
	 */
	@Deprecated public void loadGames() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(null);
		File classFile = fc.getSelectedFile();

		ClassLoader loader = null;

		try {
			loader = new URLClassLoader(new URL[] { classFile.getParentFile()
					.toURI().toURL() }, getClass().getClassLoader());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		}

		try {
			String filename = classFile.getName();
			Class<?> cls = loader.loadClass(filename.substring(0,
					filename.length() - 6));
			cls.getAnnotation(GameInfo.class);
			cls.getMethod("run").invoke(cls.newInstance());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}

	}

	public void loadGameList() throws MalformedURLException,
			ClassNotFoundException {

		ArrayList<Class<?>> games = new ArrayList<>();
		
		File file = new File("D:\\GhostEngine\\Games\\bin\\");

		URL url = file.toURI().toURL();
		URL[] urls = new URL[] { url };

		ClassLoader cl = new URLClassLoader(urls);

		String fileName;
		for (File f : getClasses(file)) {
			fileName = f.getName();
			games.add(cl.loadClass(fileName.substring(0, fileName.length() - 6)));
		}
		
		ArrayList<Class<?>> gameClasses = new ArrayList<>();
		
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).isAnnotationPresent(GameInfo.class))
				gameClasses.add(games.get(i));
		}
		
		displaySelector(gameClasses.toArray(new Class<?>[gameClasses.size()]));
	}

	public File[] getClasses(File file) {
		ArrayList<File> files = new ArrayList<>();

		for (File f : file.listFiles()) {
			if (f.isFile() && f.getName().toLowerCase().endsWith(".class")) {
				files.add(f);
			} else if (f.isDirectory()) {
				for (File g : getClasses(f)) {
					files.add(g);
				}
			}
		}

		return files.toArray(new File[files.size()]);
	}
	
	public void displaySelector(Class<?>[] games) {
		JFrame frame = new JFrame("Ghost Engine Games");
		frame.setSize(800, 500);
		
		for (final Class<?> game : games) {
			GameInfo info = game.getAnnotation(GameInfo.class);
			JPanel box = new JPanel();
			box.add(new JLabel(info.Name() + " by " + info.Author()));
			JButton playButton = new JButton("Play!");
			playButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						game.getMethod("run").invoke(game.newInstance());
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException
							| SecurityException | InstantiationException e1) {
						e1.printStackTrace();
					}
				}
			});
			box.add(playButton);
			frame.add(box);
		}
		
		frame.setVisible(true);
	}
}
