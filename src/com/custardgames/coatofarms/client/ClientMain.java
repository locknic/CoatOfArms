package com.custardgames.coatofarms.client;

import java.awt.Canvas;

import com.custardgames.coatofarms.InputHandler;
import com.custardgames.coatofarms.client.net.ClientSocket;

public class ClientMain
{
	final private int tickrate = 30;
	final private int framerate = 30;

	private boolean running;
	private boolean rendering;
	
	private ClientSocket socket;
	
	private Canvas gameScreen;
	private InputHandler input;
	private ClientEntities entities;
	
	public ClientMain(Canvas gameScreen, InputHandler input)
	{
		this.gameScreen = gameScreen;
		this.input = input;
		init();
	}

	public void init()
	{
		entities = new ClientEntities();
		running = false;
		rendering = false;
	}
	
	public void joinGame(String ipAddress, int port, String username)
	{
		socket = new ClientSocket(ipAddress, port, username);
		socket.start();
		socket.login();
		start();
	}
	
	public void leaveGame()
	{
		socket.disconnect();
		stop();
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

	private void loopRender()
	{
		long currentFrameTime = System.currentTimeMillis();
		long lastFrameTime = currentFrameTime;

		while (rendering)
		{
			lastFrameTime = System.currentTimeMillis();

			render();

			currentFrameTime = System.currentTimeMillis();

			if (1000 / framerate - (currentFrameTime - lastFrameTime) > 0)
			{
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
	}

	private void tick()
	{
		ClientLogic logic = new ClientLogic();
		logic.network(socket, input);
	}

	private void render()
	{
		ClientGraphic graphic = new ClientGraphic();
		graphic.render(gameScreen, entities);
	}
}
