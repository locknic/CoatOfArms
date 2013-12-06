package com.custardgames.coatofarms.shared.entitysystem.systems;

import com.custardgames.coatofarms.InputHandler;
import com.custardgames.coatofarms.shared.entitysystem.EntityECS;
import com.custardgames.coatofarms.shared.entitysystem.SystemECS;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentInput;

public class SystemInputKB extends SystemECS
{
	private InputHandler input;
	
	public SystemInputKB(InputHandler input)
	{
		super("system-input-kb");
		this.input = input;
	}

	@Override
	public void tick(long delta)
	{
		for (EntityECS e : entityManager)
		{
			if (e.componentManager.containsComponent(ComponentInput.class))
			{
				ComponentInput inputComponent = ((ComponentInput)e.componentManager.getComponent(ComponentInput.class));
				inputComponent.setIput(input.getInput());
			}
		}
	}
}
