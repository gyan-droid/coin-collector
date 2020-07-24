package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackGround extends JPanel implements KeyListener{
public final int width = 1200;
public final int height  = 800;
private JFrame window = new JFrame("Collect Coin");
private Star stars[] = new Star[1000];
private Player gyan = new Player(2,2,20,20,Color.red,this);
Coins[] coins = new Coins[100];
//bomb[] bombs = new bomb[20];
private int time = 60;
public static int score = 0;
public void initStars() {
	for(int i =0;i<stars.length;i++) {
	stars[i] = new Star((int)(Math.random()*1200),(int)(Math.random()*800));
	
	}
}
public void initCoins()
{
	for(int i = 0; i < coins.length; i++)
	{
		coins[i] = new Coins((int)(Math.random()*1200),((int)(Math.random()*800)),15,15,gyan);
	}
}
//public void initbomb()
//{
//	for(int i = 0; i < bombs.length; i++)
//	{
//		bombs[i] = new bomb((int)(Math.random()*1200),((int)(Math.random()*800)),15,15,gyan);
//	}
//}
private void drawStar(Graphics g) {
	for(int i = 0;i<stars.length;i++)
		stars[i].drawstar(g);
}
public BackGround() {

	window.add(this);
	this.setFocusable(true);
	this.addKeyListener(this);
	
	initStars();
	initCoins();
	// initbomb();
	
	Thread thread = new Thread(()->
	{
		while(time > 0) {
		try {
			Thread.sleep(1000);
			time--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		window.dispose();
		
	});
	thread.start();
	window.setSize(width,height);
	window.setLocation(0, 0);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
}

public void paint(Graphics g) {
	super.paintComponent(g);
	this.setBackground(Color.black);
	drawStar(g);
	this.repaint();
	gyan.rightFace(g);
	gyan.leftFace(g);
	for(int i = 0; i < coins.length; i++) {
		coins[i].drawCoin(g);}
//	for(int i = 0; i < bombs.length; i++) {
	//	bombs[i].drawbomb(g);}
	g.setColor(Color.PINK);
	g.drawString("Time Remaining : "+time, 10, 10);
	g.drawString("Score : "+score, 10, 40);
	g.setColor(Color.green);
	g.drawString("This game is designed by Gyanendra", 700, 700);
}
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
	{
		for(int i = 0; i < coins.length; i++)
				coins[i].isCollected();
		gyan.rightSpeed(5);
		

	}
	else if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
	{
		for(int i = 0; i < coins.length; i++)
			coins[i].isCollected();
		gyan.leftSpeed(-5);

	}
	else if(arg0.getKeyCode() == KeyEvent.VK_UP)
	{
		for(int i = 0; i < coins.length; i++)
			coins[i].isCollected();
		gyan.upSpeed(-5);

	}
	else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
	{
		for(int i = 0; i < coins.length; i++)
			coins[i].isCollected();
		gyan.downSpeed(5);

	}
	else
	{
		gyan.rightSpeed(0);
		gyan.leftSpeed(0);
		gyan.upSpeed(0);
		gyan.downSpeed(0);
	}
		
	
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
//	if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
//	{
//		for(int i = 0; i < coins.length; i++)
//				coins[i].isCollected();
//		player.setXSpeed(5);
//		
//
//	}
//	if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
//	{
//		for(int i = 0; i < coins.length; i++)
//			coins[i].isCollected();
//		player.setXSpeed(-5);
//
//	}
//	if(arg0.getKeyCode() == KeyEvent.VK_UP)
//	{
//		for(int i = 0; i < coins.length; i++)
//			coins[i].isCollected();
//		player.setYSpeed(-5);
//
//	}
//	if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
//	{
//		for(int i = 0; i < coins.length; i++)
//			coins[i].isCollected();
//		player.setYSpeed(5);
//
//	}
	
}
@Override
public void keyTyped(KeyEvent arg0) {

	
}

}



