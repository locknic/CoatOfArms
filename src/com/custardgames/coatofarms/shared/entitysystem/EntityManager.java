package com.custardgames.coatofarms.shared.entitysystem;

import java.util.ArrayList;
import java.util.List;

public class EntityManager
{
	private List<Entity> entities;

	public EntityManager()
	{
		entities = new ArrayList<Entity>();
	}

	public void addEntity(Entity entity)
	{
		entities.add(entity);
	}

	public void removeEntity(String id)
	{
		int indexLocation = 0;
		for (Entity entity : entities)
		{
			if (entity.getId().equals(id))
			{
				entities.remove(indexLocation);
			}
			indexLocation++;
		}
	}

	public List<Entity> getEntity(String id)
	{
		List<Entity> gettingEntities = new ArrayList<Entity>();
		for (Entity entity : entities)
		{
			if (entity.getId().equals(id))
			{
				gettingEntities.add(entity);
			}
		}
		return gettingEntities;
	}

	public boolean containsEntity(String id)
	{
		for (Entity entity : entities)
		{
			if (entity.getId().equals(id))
			{
				return true;
			}
		}

		return false;
	}

	public void tick(long delta)
	{
		for(Entity entity : entities)
		{
			entity.tick(delta);
		}
	}
}
