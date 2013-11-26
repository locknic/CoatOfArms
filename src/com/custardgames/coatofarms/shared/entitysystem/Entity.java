package com.custardgames.coatofarms.shared.entitysystem;


public class Entity
{	
	private String id;
	
	private EntityManager entityManager;
	private ComponentManager componentManager;
	private SystemManager systemManager;
	
	public Entity()
	{
		entityManager = new EntityManager();
		componentManager = new ComponentManager();
		systemManager = new SystemManager();
	}
	
	public Entity(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void addEntity(Entity entity)
	{
		entityManager.addEntity(entity);
	}
	
	public void removeEntity(String id)
	{
		entityManager.removeEntity(id);
	}
	
	public void getEntity(String id)
	{
		entityManager.getEntity(id);
	}
	
	public boolean containsEntity(String id)
	{
		return entityManager.containsEntity(id);
	}
	
	public void addComponent(Component component)
	{
		componentManager.addComponent(component);
	}
	
	public void removeComponent(String id)
	{
		componentManager.removeComponent(id);
	}
	
	public void getComponent(String id)
	{
		componentManager.getComponent(id);
	}
	
	public boolean containsComponent(String id)
	{
		return componentManager.containsComponent(id);
	}
	
	public void addSystem(System system)
	{
		systemManager.addSystem(system);
	}
	
	public void removeSystem(String id)
	{
		systemManager.removeSystem(id);
	}
	
	public void getSystem(String id)
	{
		systemManager.getSystem(id);
	}
	
	public boolean containsSystem(String id)
	{
		return systemManager.containsSystem(id);
	}
	
	public void tick(long delta)
	{
		entityManager.tick(delta);
		systemManager.tick(delta);
	}
}
