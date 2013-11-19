package com.custardgames.coatofarms.shared.net.packets;

import com.custardgames.coatofarms.client.net.ClientSocket;
import com.custardgames.coatofarms.server.net.ServerSocket;

public abstract class Packet
{
	public static enum PacketTypes
	{
		INVALID(0000), LOGIN(0001), DISCONNECT(0002), MOVE(1001);

		private int packetID;

		private PacketTypes(int packetId)
		{
			this.packetID = packetId;
		}

		public int getID()
		{
			return packetID;
		}
	}

	public byte packetID;

	public Packet(int packetId)
	{
		this.packetID = (byte) packetID;
	}

	public abstract void writeData(ClientSocket client);

	public abstract void writeData(ServerSocket server);

	public String readData(byte[] data)
	{
		String message = new String(data).trim();
		return message.substring(2);
	}

	public abstract byte[] getData();

	public static PacketTypes lookupPacket(String packetId)
	{
		try
		{
			return lookupPacket(Integer.parseInt(packetId));
		}
		catch (NumberFormatException e)
		{
			return PacketTypes.INVALID;
		}
	}

	public static PacketTypes lookupPacket(int id)
	{
		for (PacketTypes p : PacketTypes.values())
		{
			if (p.getID() == id)
			{
				return p;
			}
		}
		return PacketTypes.INVALID;
	}
}
