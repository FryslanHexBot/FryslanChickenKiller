package chickenkiller;

import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.GroundItems;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.GroundItem;

public class Loot extends Node {

	public static final int Loot = 315;
	
	@Override
	public boolean activate() {
		GroundItem loot = GroundItems.getNearest(Loot);
		return loot != null && !Players.getLocal().isInCombat();
	}

	@Override
	public void execute() {
		GroundItem loot = GroundItems.getNearest(Loot);
		if(loot != null){
		if(loot.isOnScreen() && !Players.getLocal().isMoving()){
			loot.interact("Take Feather");
			
			}else if(!loot.isOnScreen()){
				Camera.turnTo(loot);
				
			}else{
				Time.sleep(400);
			}
		}

	}

}
