package com.custardgames.coatofarms;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener
{
	private List<String> input;

	public InputHandler()
	{
		input = new ArrayList<String>();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e)
	{		
		boolean containsKey = false;
		for (int inputIndex = 0; inputIndex < input.size(); inputIndex++)
		{
			if (input.get(inputIndex).equals(KeyEvent.getKeyText(e.getKeyCode())))
			{
				containsKey = true;
			}
		}
		
		if (!containsKey)
		{
			input.add(KeyEvent.getKeyText(e.getKeyCode()));
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		for (int inputIndex = 0; inputIndex < input.size(); inputIndex++)
		{
			if (input.get(inputIndex).equals(KeyEvent.getKeyText(e.getKeyCode())))
			{
				input.remove(inputIndex);
				break;
			}
		}
	}
	
	public List<String> getInput()
	{
		return input;
	}
 
	public void releaseAll()
	{
		input = new ArrayList<String>();
	}
}
