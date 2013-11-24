package com.custardgames.coatofarms.client;

import com.custardgames.coatofarms.InputHandler;
import com.custardgames.coatofarms.client.net.ClientSocket;
import com.custardgames.coatofarms.shared.net.packets.Packet1001Move;

public class ClientLogic
{
	
	public ClientLogic()
	{

	}
	
	public void tick(InputHandler input)
	{
		if (input.up == true)
		{
			System.out.println("Up Pressed");
		}
		if (input.down == true)
		{
			System.out.println("Down Pressed");
		}
		if (input.left == true)
		{
			System.out.println("Left Pressed");
		}
		if (input.right == true)
		{
			System.out.println("Right Pressed");
		}
	}
	
	public void network(ClientSocket socket, InputHandler input)
	{
		Packet1001Move packet = new Packet1001Move(socket.getUsername(), input.up, input.down, input.left, input.right);
		socket.sendData(packet.getData());
	}
}
