package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.MyAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.events.predefine.SelectChangeVisibleOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.features.DrawerFeature;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;

public class TestPlotSoftPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				application.getDriverManager());

		application.addTest("Figure Joe 1", selectTestFigureOptionListener);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupDrivers(Application application) {
		IPlotter clientPlotter = new ClientPlotter();
		application.addDriver("Client Plotter", clientPlotter);
		application.getDriverManager().setCurrentPlotter(clientPlotter);

		IPlotter plotter = new MyAdapter(DrawerFeature.getDrawerController());
		application.addDriver("Buggy Simulator", plotter);

		application.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		//defaultDrawerWindow.setVisible(true);
		defaultDrawerWindow.setVisible(false);

	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application();
				DrawerFeature.setupDrawerPlugin(app);

				setupDefaultDrawerVisibilityManagement(app);

				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
