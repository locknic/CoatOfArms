package com.custardgames.coatofarms;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener
{
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		toggle(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		toggle(e, false);
	}

	private void toggle(KeyEvent e, boolean state)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
		{
			up = state;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
		{
			down = state;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		{
			left = state;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			right = state;
		}
	}

}
