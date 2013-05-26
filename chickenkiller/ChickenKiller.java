package chickenkiller;

import org.hexbot.api.util.Random;
import org.hexbot.script.Manifest;
import org.hexbot.script.Script;

@Manifest(author = "Fryslan", name = "Fryslan ChickenKiller", description = "Kills chickens", version = 0.1)
public class ChickenKiller extends Script {

	private static final Node[] jobs = { new Loot(), new Kill(), new Flee(), new Walking()};

	@Override
	public int loop() {
	for (Node job : jobs) {
		if(job.activate()) {
			job.execute();
			return Random.nextInt(50, 150);
		}
	}
	return 50;
	}

	@Override
	public void onEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	}
}
