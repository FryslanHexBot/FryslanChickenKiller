package chickenkiller;

import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.Npcs;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.Npc;

public class Kill extends Node {

	public static int[] MOB_ID = {41,1071};
	
	@Override
	public boolean activate() {
		Npc chicken = Npcs.getNearest(MOB_ID);
		return !Players.getLocal().isInCombat() && Players.getLocal().getHp() >7 && chicken != null;
	}

	@Override
	public void execute() {
		Npc chicken = Npcs.getNearest(MOB_ID);
		if(!Players.getLocal().isInCombat() && !Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1 && chicken.isOnScreen()){
			chicken.interact("Attack");
			Time.sleep(750, 1000);
		}else if(!chicken.isOnScreen()){
			Camera.turnTo(chicken);
		}else{
			Time.sleep(400);
		}
		


	}

}
