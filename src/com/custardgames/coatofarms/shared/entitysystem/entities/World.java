package com.custardgames.coatofarms.shared.entitysystem.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.custardgames.coatofarms.InputHandler;
import com.custardgames.coatofarms.shared.entitysystem.EntityECS;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentInput;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentPosition;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentSize;
import com.custardgames.coatofarms.shared.entitysystem.systems.RenderSystemDefault;
import com.custardgames.coatofarms.shared.entitysystem.systems.SystemInputKB;
import com.custardgames.coatofarms.shared.entitysystem.systems.SystemMovement;

public class World extends EntityECS
{
	private int width, height;
	private InputHandler input;
	
	public World(InputHandler input, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.input = input;
		
		init();
	}
	
	public void init()
	{
		systemManager.add(new RenderSystemDefault());
		systemManager.add(new SystemInputKB(input));
		systemManager.add(new SystemMovement());

		EntityECS player = new EntityECS();
		player.componentManager.add(new ComponentPosition(200, 200));
		player.componentManager.add(new ComponentSize(50, 50));
		player.componentManager.add(new ComponentInput());
		systemManager.getSystemType(RenderSystemDefault.class).addEntity(player);
		systemManager.getSystemType(SystemInputKB.class).addEntity(player);
		systemManager.getSystemType(SystemMovement.class).addEntity(player);

		entityManager.add(player);
	}
	
	public void tick(long delta)
	{
		super.tick(delta);
	}
	
	public BufferedImage render(long delta)
	{
		BufferedImage screen = new BufferedImage(width, height, 1);
		Graphics g = screen.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		super.render(delta, g);
		g.dispose();
		return screen;
	}
}
