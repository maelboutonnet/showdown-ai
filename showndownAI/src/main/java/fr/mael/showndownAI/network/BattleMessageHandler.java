package fr.mael.showndownAI.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mael.showndownAI.battleData.Battle;

public class BattleMessageHandler  implements WebsocketClient.MessageHandler {
	private final Logger LOGGER = LogManager.getLogger(getClass());
	
	Battle battle;

	public BattleMessageHandler(Battle battle) {
		this.battle = battle;
	}

	@Override
	public void handleMessage(String message) {
		LOGGER.info("Message received : ");
		LOGGER.info(message);
		if (message.startsWith(">") && this.battle.id == null) {
			this.battle.id = message.substring(1, message.indexOf("\n"));
			LOGGER.info("Battle ID initiated with : " + this.battle.id );
		} else if (this.battle.id != null) {
			LOGGER.info("Battle Message received : ");
			LOGGER.info(message);
		}
		
	}

}
