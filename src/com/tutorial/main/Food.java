package com.tutorial.main; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
public class Food extends GameObject{
	public Rectangle getBounds()
	{
		while (1 == 1)
		{
			if (exist == 1)
			{
				return new Rectangle(x, y, 20, 20); 
				//basically makes ball exist when this occurs
			}
			else
			{
				return new Rectangle(-50, -50, 20, 20); 
			}
		}
	}
	public Food(int x, int y, ID id)
	{
		super(x, y, id);
	}
	public void render(Graphics g)
	{
		if (exist == 1)
		{
			g.setColor(Color.blue);
			g.fillRect(300, 320, 20, 20);
		}
		//basically makes ball appear when this occurs
	}
	public void tick()
	{
			
	}
} 

