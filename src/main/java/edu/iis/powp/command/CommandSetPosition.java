package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class CommandSetPosition implements PlotterCommand {
	private int x;
	private int y;
	@Override
	public void execute(IPlotter driver) {
		driver.setPosition(x, y);
	}
	public CommandSetPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
