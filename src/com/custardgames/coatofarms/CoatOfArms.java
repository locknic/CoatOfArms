package com.custardgames.coatofarms;

import com.custardgames.coatofarms.client.ClientMain;
import com.custardgames.coatofarms.server.ServerMain;

public class CoatOfArms
{

	public static void main(String[] args)
	{
		ServerMain server = new ServerMain();
		server.start();
		
		ClientMain client = new ClientMain();
		client.start();
	}
}
