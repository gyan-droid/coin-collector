package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
private int xPos;
private int yPos;
private int speed;
private Color color; 
private int width;
private int height;
private BackGround current;
public Player(int xPos , int yPos ,int width , int height , Color color , BackGround current) {
	this.xPos = xPos;
	this.yPos = yPos;
	this.color = color;
	this.current = current;
	this.width = width;
	this.height = height;
}
public void rightSpeed(int speed) {
	 this.speed = speed;
	for(int i = 0; i<=5;i++)
	{
		if(current.width>=xPos)
			xPos+=speed;
	}
		
}
public void leftSpeed(int speed) {
	 this.speed = speed;
	for(int i = 0; i<=5;i++)
	{
		if(xPos>0)
			xPos+=speed;
	}
}
public void downSpeed(int speed) {
	this.speed = speed;
	for(int i = 0; i<=5;i++)
	{
		if(current.height>=yPos)
			yPos+=speed;
	}
}
	public void upSpeed(int speed) {
		this.speed = speed;
		for(int i = 0; i<=5;i++)
		{
			if(yPos>0)
				yPos+=speed;
		
}
	}
		public boolean hasCollected(Coins coin)
		{
			Rectangle coinRect = new Rectangle(coin.xPos, coin.yPos, coin.width + 1, coin.height + 1);
			Rectangle playerRect = new Rectangle(xPos, yPos, width + 1, height + 1);
			
			if(coinRect.intersects(playerRect))
			{
				coin.xPos = -1000;
				coin = null;
				BackGround.score++;
				return true;
			}
		
//			if(bombRect.intersects(playerRect)) {
//				bombs.xPos = -1000;
//				bombs = null;
//				BackGround.score--;
//				return true;
//			}
			return false;
		}
//		

	public void rightFace(Graphics g) {
		int offset = 5;
	g.setColor(color);
	g.fillOval(xPos, yPos, width, height );
	g.setColor(Color.yellow);
	g.fillRect(xPos+width-offset, yPos+offset, 3, 3);
	}
	public void leftFace(Graphics g) {
		int offset = 5;
	g.setColor(color);
	g.fillOval(xPos, yPos, width, height);
	g.setColor(Color.yellow);
	g.fillRect(xPos+offset, yPos+offset, 3, 3);
	}
}
