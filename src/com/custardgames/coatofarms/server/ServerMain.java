package com.custardgames.coatofarms.server;

import com.custardgames.coatofarms.server.net.ServerSocket;

public class ServerMain
{

	final private int tickrate = 30;

	private boolean running;
	
	private ServerSocket socket;

	public ServerMain(int port)
	{
		init(port);
	}

	public void init(int port)
	{
		socket = new ServerSocket(port);
		socket.start();
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
		socket.shutDown();
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

			if (1000 / tickrate - (currentFrameTime - lastFrameTime) > 0)
			{
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
	}

	private void tick()
	{
		
	}
}
