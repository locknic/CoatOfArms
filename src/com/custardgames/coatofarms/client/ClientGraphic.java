package com.custardgames.coatofarms.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class ClientGraphic
{
	
	public ClientGraphic()
	{
		
	}
	
	public void render(Canvas gameScreen, ClientEntities entities)
	{
		BufferStrategy bs = gameScreen.getBufferStrategy();
		if (bs == null)
		{
			gameScreen.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, gameScreen.getWidth(), gameScreen.getHeight());
		g.dispose();
		bs.show();
	}
	
}
