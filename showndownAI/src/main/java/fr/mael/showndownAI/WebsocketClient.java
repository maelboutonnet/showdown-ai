package fr.mael.showndownAI;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;

@ClientEndpoint
public class WebsocketClient {
	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@OnMessage
	public void onMessage(String message, Session session) {
	    LOGGER.log(Level.INFO, message);
    }
}
