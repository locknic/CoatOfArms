package com.custardgames.coatofarms.shared.net.packets;


public class Packet0002Disconnect extends Packet
{
	private String username;

	public Packet0002Disconnect(byte[] data)
	{
		super(0002);
		this.username = readData(data);
	}

	public Packet0002Disconnect(String username)
	{
		super(0002);
		this.username = username;
	}

	@Override
	public byte[] getData()
	{
		return ("0002" + this.username).getBytes();
	}

	public String getUsername()
	{
		return username;
	}

}
