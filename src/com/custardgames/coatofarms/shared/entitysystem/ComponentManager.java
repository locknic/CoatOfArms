package com.custardgames.coatofarms.shared.entitysystem;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager
{
	private List<Component> components;
	
	public ComponentManager()
	{
		components = new ArrayList<Component>();
	}
	
	public void addComponent(Component component)
	{
		components.add(component);
	}
	
	public void removeComponent(String id)
	{
		int indexLocation = 0;
		for (Component component : components)
		{
			if (component.getId().equals(id))
			{
				components.remove(indexLocation);
			}
			indexLocation++;
		}
	}
	
	public Component getComponent(String id)
	{
		for (Component component : components)
		{
			if (component.getId().equals(id))
			{
				return component;
			}
		}
		
		return null;
	}
	
	public boolean containsComponent(String id)
	{
		for (Component component : components)
		{
			if (component.getId().equals(id))
			{
				return true;
			}
		}
		
		return false;
	}
}
