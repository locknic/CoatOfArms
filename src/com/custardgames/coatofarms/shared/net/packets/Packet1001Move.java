package com.custardgames.coatofarms.shared.net.packets;


public class Packet1001Move extends Packet
{
	private String username;
	private boolean up, down, left, right;

	public Packet1001Move(byte[] data)
	{
		super(1001);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
		this.up = readBoolean(dataArray[1]);
		this.down = readBoolean(dataArray[2]);
		this.left = readBoolean(dataArray[3]);
		this.right = readBoolean(dataArray[4]);
	}

	public Packet1001Move(String username, boolean up, boolean down, boolean left, boolean right)
	{
		super(1001);
		this.username = username;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	@Override
	public byte[] getData()
	{
		return ("1001" + this.username + "," + this.up + "," + this.down  + "," + this.left + "," + this.right).getBytes();
	}

	public String getUsername()
	{
		return username;
	}

	public boolean getUp()
	{
		return this.up;
	}
	
	public boolean getDown()
	{
		return this.down;
	}
	
	public boolean getLeft()
	{
		return this.left;
	}
	
	public boolean getRight()
	{
		return this.right;
	}

}
