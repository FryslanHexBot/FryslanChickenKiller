package chickenkiller;

import org.hexbot.api.methods.Players;
import org.hexbot.api.wrapper.Area;
import org.hexbot.api.wrapper.Tile;

public class Walking extends Node {

	Area LUMBY_AREA = new Area(new Tile[] { new Tile(3229, 3286, 0), new Tile(3229, 3293, 0), new Tile(3223, 3293, 0), 
			new Tile(3223, 3301, 0), new Tile(3225, 3302, 0), new Tile(3237, 3302, 0), 
			new Tile(3237, 3301, 0), new Tile(3237, 3298, 0), new Tile(3236, 3298, 0), 
			new Tile(3236, 3293, 0), new Tile(3237, 3293, 0), new Tile(3237, 3290, 0), 
			new Tile(3236, 3289, 0), new Tile(3236, 3286, 0) });
	
	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !LUMBY_AREA.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
