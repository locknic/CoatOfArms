package com.custardgames.coatofarms.shared.entitysystem.components;

import com.custardgames.coatofarms.shared.entitysystem.ComponentECS;

public class ComponentSize extends ComponentECS
{
	private int width, height;

	public ComponentSize()
	{
		super("component-size");
		this.width = 0;
		this.height = 0;
	}

	public ComponentSize(int width, int height)
	{
		super("size");
		setSize(width, height);
	}

	public void setSize(int width, int height)
	{
		setWidth(width);
		setHeight(height);
	}

	public void translate(int width, int height)
	{
		setHeight(getHeight() + height);
	}

	public void translateWidth(int width)
	{
		setWidth(getWidth() + width);
	}

	public void translateHeight(int height)
	{
		setHeight(getHeight() + height);
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
