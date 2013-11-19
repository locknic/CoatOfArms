package com.custardgames.coatofarms.server;

public class ServerMain
{

	final private int tickrate = 30;

	private boolean running;
	
	private int totalTicks;

	public ServerMain()
	{
		init();
	}

	public void init()
	{
		running = false;
	}

	public synchronized void start()
	{
		running = true;

		Thread runner = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				loop();
			}
		});
		runner.start();
	}

	public void stop()
	{
		running = false;
	}

	private void loop()
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

	private void tick()
	{
		System.out.println(totalTicks + " Server Ticking");
		totalTicks++;
	}
}
