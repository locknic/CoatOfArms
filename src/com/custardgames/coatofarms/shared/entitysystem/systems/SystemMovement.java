package com.custardgames.coatofarms.shared.entitysystem.systems;

import com.custardgames.coatofarms.shared.entitysystem.EntityECS;
import com.custardgames.coatofarms.shared.entitysystem.SystemECS;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentInput;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentPosition;

public class SystemMovement extends SystemECS
{

	public SystemMovement()
	{
		super("system-movement");
	}

	@Override
	public void tick(long delta)
	{
		for (EntityECS e : entityManager)
		{
			if (e.componentManager.containsComponent(ComponentInput.class) && e.componentManager.containsComponent(ComponentPosition.class))
			{
				ComponentInput inputComponent = ((ComponentInput)e.componentManager.getComponent(ComponentInput.class));
				ComponentPosition positionComponent = ((ComponentPosition)e.componentManager.getComponent(ComponentPosition.class));
				
				if (inputComponent.checkInput("W"))
				{
					positionComponent.translateY(-5);
				}
				if (inputComponent.checkInput("S"))
				{
					positionComponent.translateY(5);
				}
				if (inputComponent.checkInput("A"))
				{
					positionComponent.translateX(-5);
				}
				if (inputComponent.checkInput("D"))
				{
					positionComponent.translateX(5);
				}
			}
		}
	}
	
}
