package com.tutorial.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640, HEIGHT = 480;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud; 
	private Food food; 
	
	public Game()
	{
		handler = new Handler(); 
		// tells game to realize that keys are going to be pressed
		this.addKeyListener(new KeyInput(handler));
		hud = new HUD();
		new Window(WIDTH, HEIGHT, "Almon", this);
		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT * 3/5, ID.Player, handler));
		handler.addObject(new Food(300, 320, ID.Food));
	}
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true; 
	}
	public synchronized void stop()
	{
		try{
			//.join stops the thread
			thread.join();
			running = false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		//game loop, updates the game 
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
        stop();
	}
	private void tick()
	{
		handler.tick();
		hud.tick(); 
	}
	private void render()
	{
		//lowers framerate
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return; 
		}
		Graphics g = bs.getDrawGraphics();
		//makes window black 
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		hud.render(g);
		g.dispose();
		bs.show();
	}
	public static void main(String args[])
	{
		new Game();
	}
	
}