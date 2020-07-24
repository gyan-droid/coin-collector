package pack1;

import java.awt.Color;
import java.awt.Graphics;

public class Star {
private int xPos;
private int yPos;
private final int width = 3;
private final int height = 3;
private int red;
public int green;
public int blue;

public Star() {
	super();
}
public Star(int xPos, int yPos ) {
	this.xPos = xPos;
	this.yPos = yPos;
}


public void randomizeColor1()
{
	this.red = (int)(Math.random()*255);
	this.green = (int)(Math.random()*255);
	this.blue = (int)(Math.random()*255);
}
@Override
public String toString() {
	return "Star [xPos=" + xPos + ", yPos=" + yPos + ", width=" + width + ", height=" + height + ", red=" + red
			+ ", green=" + green + ", blue=" + blue + "]";
}
public Color randomizeColor() {
	return Color.black;
}
public int randomizeColor(int limit) {
	return 0;
}
public void drawstar(Graphics g) {
	 randomizeColor1();
	g.setColor(new Color(this.red,this.green,this.blue));
	g.fillOval(xPos, yPos, width, height);
	
}
}
