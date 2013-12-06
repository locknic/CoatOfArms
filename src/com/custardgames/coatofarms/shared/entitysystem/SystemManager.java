package com.custardgames.coatofarms.shared.entitysystem;

import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SystemManager extends ArrayList<SystemECS>
{
	
	public SystemManager()
	{
		super();
	}
	
	public boolean containsSystem(String id)
	{
		for (SystemECS system : this)
		{
			if (system.getId().equals(id))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean containsSystemType(Class<?> systemType)
	{
		for (SystemECS system : this)
		{
			if (system.getClass() == systemType)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void startSystem(String id)
	{
		getSystem(id).running = true;
	}
	
	public void startSystemType(Class<?> systemType)
	{
		getSystemType(systemType).running = true;
	}
	
	public void stopSystem(Class<?> systemType)
	{
		getSystemType(systemType).running = false;
	}
	
	public void removeSystem(String id)
	{
		int indexLocation = 0;
		for (SystemECS system : this)
		{
			if (system.getId().equals(id))
			{
				this.remove(indexLocation);
			}
			indexLocation++;
		}
	}
	
	public void removeSystemType(Class<?> systemType)
	{
		int indexLocation = 0;
		for (SystemECS system : this)
		{
			if (system.getClass() == systemType)
			{
				this.remove(indexLocation);
			}
			indexLocation++;
		}
	}
	
	public SystemECS getSystem(String id)
	{
		for (SystemECS system : this)
		{
			if (system.getId().equals(id))
			{
				return system;
			}
		}
		
		return null;
	}
	
	public SystemECS getSystemType(Class<?> systemType)
	{
		for (SystemECS system : this)
		{
			if (system.getClass() == systemType)
			{
				return system;
			}
		}
		
		return null;
	}
	
	public void tick(long delta)
	{
		for (SystemECS system : this)
		{
			system.tick(delta);
		}
	}
	
	public void render(long delta, Graphics g)
	{
		for (SystemECS system : this)
		{
			if (system instanceof RenderSystem)
			{
				((RenderSystem)system).render(delta, g);
			}
		}
	}
}
