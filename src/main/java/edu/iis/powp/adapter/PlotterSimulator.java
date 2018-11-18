package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.features.DrawerFeature;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

/**
 * Plotter adapter to drawer with several bugs.
 */
public class PlotterSimulator implements IPlotter {
	private int startX = 0, startY = 0;
	private DrawPanelController drawController = null;
	private ILine line = LineFactory.getBasicLine();

	public PlotterSimulator(DrawPanelController drawPanelController) {
		super();
		drawController = drawPanelController;
	}
	public PlotterSimulator(DrawPanelController drawPanelController, ILine line) {
		super();
		drawController = drawPanelController;
		this.line = line;
	}
	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void drawTo(int x, int y) {
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		this.setPosition(x, y);
		drawController.drawLine(this.line);
	}

	@Override
	public String toString() {
		return "PlotterSimulator";
	}
}
