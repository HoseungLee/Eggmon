package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

//Creates a window
public class Window extends Canvas{

	private static final long serialVersionUID = -240840600533728354L;
	
	public Window(int width, int height, String title, Game game)
	{
		//JFrame is frame of the window 
		//".frame" is referring back to JFrame
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Makes the "X" button of the window function
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Makes it that so that you can't resize window, graphics problems
		frame.setResizable(false);
		//Makes the window start in the middle rather than upper left
		frame.setLocationRelativeTo(null);
		//Adds the game class into the frame
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
