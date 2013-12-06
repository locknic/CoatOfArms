package com.custardgames.coatofarms.shared.entitysystem;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ComponentManager extends ArrayList<ComponentECS>
{
	
	public ComponentManager()
	{
		super();
	}
	
	public boolean containsComponent(Class<?> componentType)
	{
		for (ComponentECS component : this)
		{
			if (component.getClass() == componentType)
			{
				return true;
			}
		}
		
		return false;
	}

	public void removeComponent(Class<?> componentType)
	{
		int indexLocation = 0;
		for (ComponentECS component : this)
		{
			if (component.getClass() == componentType)
			{
				this.remove(indexLocation);
				break;
			}
			indexLocation++;
		}
	}
	
	public ComponentECS getComponent(Class<?> componentType)
	{
		for (ComponentECS component : this)
		{
			if (component.getClass() == componentType)
			{
				return component;
			}
		}
		
		return null;
	}
}
