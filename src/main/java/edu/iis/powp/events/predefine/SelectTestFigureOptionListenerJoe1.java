package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.DriverManager;

public class SelectTestFigureOptionListenerJoe1 implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListenerJoe1(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//FiguresJoe.figureScript1(driverManager.getCurrentPlotter());
		FiguresJoe.figureScript1(driverManager.getCurrentPlotter());
	}
}
