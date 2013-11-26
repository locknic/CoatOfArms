package com.custardgames.coatofarms.server.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import com.custardgames.coatofarms.shared.net.packets.Packet;
import com.custardgames.coatofarms.shared.net.packets.Packet.PacketTypes;
import com.custardgames.coatofarms.shared.net.packets.Packet0001Login;
import com.custardgames.coatofarms.shared.net.packets.Packet0002Disconnect;
import com.custardgames.coatofarms.shared.net.packets.Packet1001Move;

public class ServerSocket extends Thread
{
	private DatagramSocket socket;
	private int port;
	private List<ServerUser> connectedUsers;

	public ServerSocket(int port)
	{
		try
		{
			this.port = port;
			this.socket = new DatagramSocket(this.port);
			connectedUsers = new ArrayList<ServerUser>();
		}
		catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run()
	{
		while (true)
		{
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try
			{
				socket.receive(packet);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
		}
	}

	public void sendData(byte[] data, InetAddress ipAddress, int port)
	{
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
		try
		{
			socket.send(packet);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void sendDataToAllClients(byte[] data)
	{

	}

	public void shutDown()
	{

	}

	private void parsePacket(byte[] data, InetAddress address, int port)
	{
		String message = new String(data).trim();
		PacketTypes type = Packet.lookupPacket(message.substring(0, 4));
		Packet packet = null;
		switch (type)
		{
		default:
		case INVALID:
			break;
		case LOGIN:
			packet = new Packet0001Login(data);
			handleLogin((Packet0001Login) packet, address, port);
			break;
		case DISCONNECT:
			packet = new Packet0002Disconnect(data);
			handleDC((Packet0002Disconnect) packet);
			break;
		case MOVE:
			packet = new Packet1001Move(data);
			handleMove((Packet1001Move) packet);
			break;
		}
	}

	public void handleLogin(Packet0001Login packet, InetAddress address, int port)
	{
		boolean alreadyConnected = false;
		for(ServerUser user : connectedUsers)
		{
			if (user.getUsername().equals(packet.getUsername()))
			{
				alreadyConnected = true;
			}
		}
		if (!alreadyConnected)
		{
			ServerUser newUser = new ServerUser(packet.getUsername(), address.getHostAddress(), port);
			connectedUsers.add(newUser);
			System.out.println(packet.getUsername() + " has connected to the server, total players: " + connectedUsers.size());
		}
	}

	public void handleDC(Packet0002Disconnect packet)
	{
		int indexLocation = 0;;
		for (ServerUser user : connectedUsers)
		{
			if (user.getUsername().equals(packet.getUsername()))
			{
				break;
			}
			indexLocation++;
		}
		
		if (indexLocation < connectedUsers.size())
		{
			connectedUsers.remove(indexLocation);
			System.out.println(packet.getUsername() + " has disconnected from the server, remaining players: " + connectedUsers.size());
		}
	}

	private void handleMove(Packet1001Move packet)
	{

	}
}
