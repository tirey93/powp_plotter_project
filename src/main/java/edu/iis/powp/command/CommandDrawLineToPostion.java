package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class CommandDrawLineToPostion implements PlotterCommand {
	private int x;
	private int y;
	@Override
	public void execute(IPlotter driver) {
		driver.drawTo(x, y);

	}
	public CommandDrawLineToPostion(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
