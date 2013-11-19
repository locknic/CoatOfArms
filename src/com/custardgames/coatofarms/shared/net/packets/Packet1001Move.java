package com.custardgames.coatofarms.shared.net.packets;

import com.custardgames.coatofarms.client.net.ClientSocket;
import com.custardgames.coatofarms.server.net.ServerSocket;

public class Packet1001Move extends Packet
{
	private String username;
	private int x, y;

	public Packet1001Move(byte[] data)
	{
		super(1001);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
		this.x = Integer.parseInt(dataArray[1]);
		this.y = Integer.parseInt(dataArray[2]);
	}

	public Packet1001Move(String username, int x, int y, String currentAnimation)
	{
		super(1001);
		this.username = username;
		this.x = x;
		this.y = y;
	}

	@Override
	public void writeData(ClientSocket client)
	{
		client.sendData(getData());
	}

	@Override
	public void writeData(ServerSocket server)
	{
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData()
	{
		return ("1001" + this.username + "," + this.x + "," + this.y).getBytes();
	}

	public String getUsername()
	{
		return username;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

}
