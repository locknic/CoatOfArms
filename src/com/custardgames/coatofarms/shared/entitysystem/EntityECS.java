package com.custardgames.coatofarms.shared.entitysystem;

import java.awt.Graphics;
import java.util.UUID;

import com.custardgames.coatofarms.shared.entitysystem.components.ComponentEntity;


public class EntityECS
{		
	private String id;	
	public ComponentManager componentManager;
	public EntityManager entityManager;
	public SystemManager systemManager;
	
	public EntityECS()
	{
		id = UUID.randomUUID().toString().replaceAll("-", "");
		
		componentManager = new ComponentManager();
		entityManager = new EntityManager();
		systemManager = new SystemManager();
		
		componentManager.add(new ComponentEntity());
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void tick(long delta)
	{
		if (((ComponentEntity)componentManager.getComponent(ComponentEntity.class)).running)
		{
			entityManager.tick(delta);
			systemManager.tick(delta);
		}
	}
	
	public void render(long delta, Graphics g)
	{
		if (((ComponentEntity)componentManager.getComponent(ComponentEntity.class)).running)
		{
			entityManager.render(delta, g);
			systemManager.render(delta, g);
		}
	}
}
