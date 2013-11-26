package com.custardgames.coatofarms.shared.entitysystem;

import java.util.ArrayList;
import java.util.List;

public class SystemManager
{
	private List<System> systems;
	
	public SystemManager()
	{
		systems = new ArrayList<System>();
	}
	
	public void addSystem(System system)
	{
		systems.add(system);
	}
	
	public void removeSystem(String id)
	{
		int indexLocation = 0;
		for (System system : systems)
		{
			if (system.getId().equals(id))
			{
				systems.remove(indexLocation);
			}
			indexLocation++;
		}
	}
	
	public System getSystem(String id)
	{
		for (System system : systems)
		{
			if (system.getId().equals(id))
			{
				return system;
			}
		}
		
		return null;
	}
	
	public boolean containsSystem(String id)
	{
		for (System system : systems)
		{
			if (system.getId().equals(id))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void tick(long delta)
	{
		for (System system : systems)
		{
			system.tick(delta);
		}
	}
}
