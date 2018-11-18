package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.shape.ILine;

public interface PlotterCommand {
	public void execute(IPlotter driver);
}
