package chickenkiller;

import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.GameObjects;
import org.hexbot.api.methods.Players;
import org.hexbot.api.methods.Walking;
import org.hexbot.api.wrapper.Area;
import org.hexbot.api.wrapper.GameObject;
import org.hexbot.api.wrapper.Tile;

public class Flee extends Node {
	Area LUMBY_AREA = new Area(new Tile[] { new Tile(3229, 3286, 0), new Tile(3229, 3293, 0), new Tile(3223, 3293, 0), 
			new Tile(3223, 3301, 0), new Tile(3225, 3302, 0), new Tile(3237, 3302, 0), 
			new Tile(3237, 3301, 0), new Tile(3237, 3298, 0), new Tile(3236, 3298, 0), 
			new Tile(3236, 3293, 0), new Tile(3237, 3293, 0), new Tile(3237, 3290, 0), 
			new Tile(3236, 3289, 0), new Tile(3236, 3286, 0) });
	
	private final Tile LUMBY_DOOR_TILE = new Tile(3230, 3291, 0);
	private final Tile LUMBY_FLEE_TILE = new Tile(3225, 3292, 0);
	
	

	@Override
	public boolean activate() {
		return Players.getLocal().getHp()<8 && LUMBY_AREA.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		GameObject lumbydoor = GameObjects.getAt(LUMBY_DOOR_TILE);
		if(LUMBY_AREA.contains(Players.getLocal())){
			if(lumbydoor != null){
				if(lumbydoor.isOnScreen()){
					lumbydoor.interact("Open");
				}else if(!lumbydoor.isOnScreen()){
					Camera.turnTo(lumbydoor);
					if(!lumbydoor.isOnScreen()){
						Walking.walkTileMM(LUMBY_DOOR_TILE);
					}
				}
			}else if(lumbydoor == null){
				Walking.walkTileMM(LUMBY_FLEE_TILE);
			}
	
		}


	}

}
