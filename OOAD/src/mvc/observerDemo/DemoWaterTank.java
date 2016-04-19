package mvc.observerDemo;

/*	This program shows the Observer pattern applied to
 *	the water flow from a tank reaching a critical level.
 *	The level monitor knows the critical level and should
 *	 shut off the water flow when the critical level is
 *	 reached.
 *	Complete the code segment.
 */
import java.util.*;

///////////////////////////////////////////////////////

class Tank extends Observable {
	int currentLevel;
	boolean shutOff = false;

	Tank(int c) {
		currentLevel = c;
	}

	Tank() {
	}

	public void flowOut() {
		if (!shutOff) {
			--currentLevel;
			System.out.println("The current Level is " + currentLevel);
			setChanged();
			notifyObservers();
		} else {
			System.out.println("Reached Critical Level No WATer FLow ! after "	+ currentLevel);
		}

	}

	public int getLevel() {
		return currentLevel;
	}

	public void stop() {
		shutOff = true;
	}
}

// ////////////////////////////////////////////////
class LevelMonitor implements Observer {

	int criticalLevel = 0;
	Tank tank;

	public LevelMonitor(int level, Tank t) {
		this.criticalLevel = level;
		tank = t;
		tank.addObserver(this);
	}

	public LevelMonitor() {
	}

	public void shutOffTank() {
		tank.stop();
	}

	@Override
	public void update(Observable o, Object arg) {

		if (tank.getLevel() == criticalLevel) {
			shutOffTank();
			System.out.println("Criticl Level reached Tank shut off ");
		}

	}

}

public class DemoWaterTank {
	public static void main(String[] args) {

		Tank tank = new Tank(10);

		LevelMonitor monitor = new LevelMonitor(5, tank);
		for (int i = 0; i < 10; ++i) {
			tank.flowOut();
		}

	}
}
