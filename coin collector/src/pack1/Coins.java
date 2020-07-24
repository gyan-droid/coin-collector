 

package pack1;

import java.awt.Color;
import java.awt.Graphics;

public class Coins {
	public int xPos;
	public int yPos;
	public int width;
	public int height;
	private Player player;
	public Boolean isCollected = false;
	
	public Coins(int xPos, int yPos, int width, int height, Player player)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.player = player;
	}
	
	public void isCollected()
	{
		
		Thread thread = new Thread(()->
		{
			isCollected = player.hasCollected(this);
		});
		thread.start();
		if(isCollected == true)
			thread.stop();

	}
	
	public void drawCoin(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillOval(xPos, yPos, width, height);
	}
}
