package com.custardgames.coatofarms.shared.net.packets;

import com.custardgames.coatofarms.client.net.ClientSocket;
import com.custardgames.coatofarms.server.net.ServerSocket;

public class Packet0001Login extends Packet
{
	private String username;

	public Packet0001Login(byte[] data)
	{
		super(0001);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
	}

	public Packet0001Login(String username, int x, int y)
	{
		super(0001);
		this.username = username;
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
		return ("0001" + this.username).getBytes();
	}

	public String getUsername()
	{
		return username;
	}
}
