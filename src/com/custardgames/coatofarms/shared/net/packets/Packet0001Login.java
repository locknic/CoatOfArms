package com.custardgames.coatofarms.shared.net.packets;


public class Packet0001Login extends Packet
{
	private String username;

	public Packet0001Login(byte[] data)
	{
		super(0001);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
	}

	public Packet0001Login(String username)
	{
		super(0001);
		this.username = username;
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
