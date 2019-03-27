package ui;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import tool.Utils;

public class 右下角視窗 {

	public static void main(String[] args) {
		try {
			if (SystemTray.isSupported()) {
				// get the SystemTray instance
				final SystemTray tray = SystemTray.getSystemTray();
				// load an image
				File f = Utils.getResourceFromRoot("ui/throbber.gif");
				Image img = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());

				// create a popup menu
				final PopupMenu popMenu = new PopupMenu();
				// create a tray icon
				final TrayIcon trayIcon = new TrayIcon(img, "System Tray Test", popMenu);

				// create menu item for the default action
				MenuItem exitItem = new MenuItem("Exit");
				popMenu.add(exitItem);

				// create a action listener to listen for default action executed on the tray
				// icon
				ActionListener listener = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tray.remove(trayIcon);
						System.exit(0);
					}
				};

				exitItem.addActionListener(listener);

				tray.add(trayIcon);
			} else {
				System.out.println("SystemTray is not supported");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
