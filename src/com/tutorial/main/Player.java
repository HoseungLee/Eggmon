package com.tutorial.main; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends GameObject{
	Handler handler; 
	public Player(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler; 
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32, 32); 
	}
	public void tick()
	{
		x += velX;
		y += velY; 
		if (x < 0)
		{
			x += 3;
		}
		if (y < 50)
		{
			y += 3;
		}
		if (x > 640-32)
		{
			x -= 3;
		}
		if (y > 480-100)
		{
			y -= 3;
		}
		collision(); 
	}
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Food)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//collision code
					//Increase hunger if player touches the food 
					HUD.HUNGER += 150; 
					exist = 0; 
				}
			}
		}
	}
	public void render(Graphics g)
	{
		//This is the player
		if(id == ID.Player) g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
}
