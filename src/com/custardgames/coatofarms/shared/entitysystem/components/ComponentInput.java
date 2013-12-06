package com.custardgames.coatofarms.shared.entitysystem.components;

import java.util.ArrayList;
import java.util.List;

import com.custardgames.coatofarms.shared.entitysystem.ComponentECS;

public class ComponentInput extends ComponentECS
{
	private List<String> input;
	
	public ComponentInput()
	{
		super("component-input");
		input = new ArrayList<String>();
	}
	
	public void setIput(List<String> input)
	{
		this.input = input;
	}
	
	public boolean checkInput(String keyCode)
	{
		for (int inputIndex = 0; inputIndex < input.size(); inputIndex++)
		{
			if (input.get(inputIndex).equals(keyCode))
			{
				return true;
			}
		}
		return false;
	}
}
