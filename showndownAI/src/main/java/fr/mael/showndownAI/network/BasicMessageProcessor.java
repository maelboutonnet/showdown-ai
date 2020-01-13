package fr.mael.showndownAI.network;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mael.showndownAI.battleData.Battle;

public class BasicMessageProcessor extends Thread {
	
	private final Logger LOGGER = LogManager.getLogger(getClass());
	CircularBuffer buffer;
	WebsocketFacade facade;
	Map<String, Battle> battleMap = new HashMap();
	
	public BasicMessageProcessor(CircularBuffer buffer,WebsocketFacade facade) {
		this.buffer = buffer;
		this.facade = facade;
	}

	@Override
    public void run() {
		for (;;) {
			try {
				String newMessage = buffer.poll();
				LOGGER.debug("Message : " + newMessage);
				if (InMessage.BATTLE_ID.matches(newMessage)) {
					String battleID = InMessage.BATTLE_ID.get(newMessage);
					battleID = battleID.substring(1);
					LOGGER.info("message for battle " + battleID + " received");
					Battle currentBattle;
					if (!battleMap.containsKey(battleID)) {
						currentBattle = new Battle();
						battleMap.put(battleID, currentBattle);
					} else {
						currentBattle = battleMap.get(battleID);
					}
					if (InMessage.REQUEST_DATA.matches(newMessage)) {
						String battleData = InMessage.REQUEST_DATA.get(newMessage);
						if (!currentBattle.initDone && !battleData.isEmpty()) {
							currentBattle.init(battleData);
							facade.sendCommand(battleID, currentBattle.getNextMove());
						}
					}
				}
				
			} catch (InterruptedException e) {
				LOGGER.error("",e);
			}
		}
	}
	

}
