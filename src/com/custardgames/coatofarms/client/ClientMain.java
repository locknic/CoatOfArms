package com.custardgames.coatofarms.client;

public class ClientMain
{
	final private int tickrate = 30;
	final private int framerate = 30;
	
	private boolean running;
	private boolean rendering;
	
	private int totalTicks;
	private int totalRenders;
	
	public ClientMain()
	{
		init();
	}

	public void init()
	{
		running = false;
		rendering = false;
		totalTicks = 0;
		totalRenders = 0;
	}

	public synchronized void start()
	{
		running = true;
		rendering = true;
		
		Thread runner = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				loopTick();
			}
		});
		runner.start();
		
		Thread renderer = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				loopRender();
			}
		});
		renderer.start();
	}

	public void stop()
	{
		running = false;
		rendering = false;
	}
	
	private void loopTick()
	{
		long currentFrameTime = System.currentTimeMillis();
		long lastFrameTime = currentFrameTime;

		while (running)
		{
			lastFrameTime = System.currentTimeMillis();

			tick();

			currentFrameTime = System.currentTimeMillis();

			try
			{
				Thread.sleep(1000 / tickrate - (currentFrameTime - lastFrameTime));
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void loopRender()
	{
		long currentFrameTime = System.currentTimeMillis();
		long lastFrameTime = currentFrameTime;

		while (rendering)
		{
			lastFrameTime = System.currentTimeMillis();

			render();

			currentFrameTime = System.currentTimeMillis();

			try
			{
				Thread.sleep(1000 / framerate - (currentFrameTime - lastFrameTime));
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void tick()
	{
		System.out.println(totalTicks + " Client Ticking");
		totalTicks++;
	}
	
	private void render()
	{
		System.out.println(totalRenders + " Client Rendering");
		totalRenders++;
	}
}
