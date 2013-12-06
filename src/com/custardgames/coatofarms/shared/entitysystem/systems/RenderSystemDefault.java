package com.custardgames.coatofarms.shared.entitysystem.systems;

import java.awt.Color;
import java.awt.Graphics;

import com.custardgames.coatofarms.shared.entitysystem.EntityECS;
import com.custardgames.coatofarms.shared.entitysystem.RenderSystem;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentEntity;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentPosition;
import com.custardgames.coatofarms.shared.entitysystem.components.ComponentSize;

public class RenderSystemDefault extends RenderSystem
{

	public RenderSystemDefault()
	{
		super("render-system-default");
	}

	@Override
	public void tick(long delta)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(long delta, Graphics g)
	{
		for (EntityECS e : entityManager)
		{
			if (e.componentManager.containsComponent(ComponentEntity.class) && e.componentManager.containsComponent(ComponentPosition.class) && e.componentManager.containsComponent(ComponentSize.class))
			{
				ComponentEntity entityComponent = ((ComponentEntity)e.componentManager.getComponent(ComponentEntity.class));
				ComponentPosition positionComponent = ((ComponentPosition)e.componentManager.getComponent(ComponentPosition.class));
				ComponentSize sizeComponent = ((ComponentSize)e.componentManager.getComponent(ComponentSize.class));
				
				if (entityComponent.running)
				{
					g.setColor(Color.RED);
					g.fillRect(positionComponent.getIntX(), positionComponent.getIntY(), sizeComponent.getWidth(), sizeComponent.getHeight());
				}
			}
		}
	}
}
