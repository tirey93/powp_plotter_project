package edu.iis.powp.drawer;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.PlotterSimulator;
import edu.iis.powp.command.CommandDrawLineToPostion;
import edu.iis.powp.command.CommandSetPosition;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.features.DrawerFeature;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

/**
 * Drawer test.
 * 
 * @author Dominik
 */
public class TestDrawer {
	/**
	 * Drawer test.
	 */
	public static void main(String[] args) {
		DrawPanelController controller = new DrawPanelController();
		DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(-100, -60);
		line.setEndCoordinates(60, 130);
		IPlotter plotter = new PlotterSimulator(controller);
		
		CommandSetPosition c1 = new CommandSetPosition(0, 0);
		
		ComplexCommand square = new ComplexCommand();
		square.addCommand(c1);
		square.addCommand(new CommandDrawLineToPostion(50, 0));
		square.addCommand(new CommandDrawLineToPostion(50, 50));
		square.addCommand(new CommandDrawLineToPostion(0, 50));
		square.addCommand(new CommandDrawLineToPostion(0, 0));
		square.execute(plotter);
		//controller.drawLine(line);
	}
}
