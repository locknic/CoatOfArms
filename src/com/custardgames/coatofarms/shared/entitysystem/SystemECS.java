package com.custardgames.coatofarms.shared.entitysystem;

import java.util.UUID;


public abstract class SystemECS
{
	public boolean running;
	
	private String id;
	private String tag;
	protected EntityManager entityManager;
	
	public SystemECS(String tag)
	{
		this.running = true;
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
		this.tag = tag;
		this.entityManager = new EntityManager();
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getTag()
	{
		return this.tag;
	}
	
	public boolean containsEntity(String id)
	{
		return entityManager.containsEntity(id);
	}
	
	public void addEntity(EntityECS entity)
	{
		entityManager.add(entity);
	}
	
	public void removeEntity(String id)
	{
		entityManager.removeEntity(id);
	}
	
	public void getEntity(String id)
	{
		entityManager.getEntity(id);
	}
	
	public abstract void tick(long delta);
}
