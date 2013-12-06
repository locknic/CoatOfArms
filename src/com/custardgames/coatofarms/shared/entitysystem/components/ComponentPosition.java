package com.custardgames.coatofarms.shared.entitysystem.components;

import com.custardgames.coatofarms.shared.entitysystem.ComponentECS;

public class ComponentPosition extends ComponentECS
{
	private float x, y;
	private double rotation;

	public ComponentPosition()
	{
		super("component-position");
		x = 0;
		y = 0;
	}

	public ComponentPosition(float x, float y)
	{
		super("position");
		setPosition(x, y);
	}

	public void setPosition(float x, float y)
	{
		setX(x);
		setY(y);
	}

	public void translate(float x, float y)
	{
		
		setY(getY() + y);
	}
	
	public void translateX(float x)
	{
		setX(getX() + x);
	}
	
	public void translateY(float y)
	{
		setY(getY() + y);
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	public void setRotation(double rotation)
	{
		this.rotation = rotation;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public int getIntX()
	{
		return (int) getX();
	}

	public int getIntY()
	{
		return (int) getY();
	}
	
	public double getRoatation()
	{
		return rotation;
	}
	
	public double getRoatationRadians()
	{
		return Math.toRadians(rotation);
	}
}
