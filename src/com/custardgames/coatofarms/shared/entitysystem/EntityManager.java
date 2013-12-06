package com.custardgames.coatofarms.shared.entitysystem;

import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class EntityManager extends ArrayList<EntityECS>
{
	public EntityManager()
	{
		super();
	}

	public boolean containsEntity(String id)
	{
		for (EntityECS entity : this)
		{
			if (entity.getId().equals(id))
			{
				return true;
			}
		}

		return false;
	}
	
	public void removeEntity(String id)
	{
		int indexLocation = 0;
		for (EntityECS entity : this)
		{
			if (entity.getId().equals(id))
			{
				this.remove(indexLocation);
			}
			indexLocation++;
		}
	}
	
	public EntityECS getEntity(String id)
	{
		for (EntityECS entity : this)
		{
			if (entity.getId().equals(id))
			{
				return entity;
			}
		}
		return null;
	}

	public void tick(long delta)
	{
		for(EntityECS entity : this)
		{
			entity.tick(delta);
		}
	}
	
	public void render(long delta, Graphics g)
	{
		for(EntityECS entity : this)
		{
			entity.render(delta, g);
		}
	}
}
