package com.tutorial.main;
import java.awt.Graphics;
import java.awt.Color;

public class HUD {

	public static int HUNGER = 2000;
	
	public void tick()
	{
		HUNGER--; 
		if (HUNGER > 2000)
		{
			HUNGER = 2000;
		}
		if (HUNGER < 0)
		{
			HUNGER = 0; 
		}
	} 
	public void render(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(5, 415, 210, 32);
		g.setColor(Color.black);
		g.fillRect(10, 420, 200, 22);
		g.setColor(Color.red);
		g.fillRect(10, 420, HUNGER/10, 22);
	}
}
