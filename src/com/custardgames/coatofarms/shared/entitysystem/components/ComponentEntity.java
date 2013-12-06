package com.custardgames.coatofarms.shared.entitysystem.components;

import com.custardgames.coatofarms.shared.entitysystem.ComponentECS;

public class ComponentEntity extends ComponentECS
{
	public boolean running;
	public boolean alive;
	
	public ComponentEntity()
	{
		super("component-entity");
		running = true;
		alive = true;
	}

}
