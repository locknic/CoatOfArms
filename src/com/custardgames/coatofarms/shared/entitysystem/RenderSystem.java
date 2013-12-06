package com.custardgames.coatofarms.shared.entitysystem;

import java.awt.Graphics;

public abstract class RenderSystem extends SystemECS
{
	public RenderSystem(String tag)
	{
		super(tag);
	}
	
	public abstract void render(long delta, Graphics g);
}
