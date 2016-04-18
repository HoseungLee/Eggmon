package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

// visually updates objects to screen 
public class Handler {
// list all game objects
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
		//obtains id of object
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	public void render(Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
}
