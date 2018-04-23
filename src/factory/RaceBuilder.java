package factory;
import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer.Color;
import game.arenas.exceptions.RacerTypeException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shmuel moha 204568323
 * @author alexs waizman 314342064
 *
 */
public class RaceBuilder {
	private static RaceBuilder instance=null;//Singleton
	ClassLoader classLoder = ClassLoader.getSystemClassLoader();//getting the class loader
	Class<?> reflectClass;
	Constructor<?> reflectConstractor;
	
	
	protected RaceBuilder() {
		// Exists only to defeat instantiation
	}
	/**
	 * gets the instance of the RaceBuilder
	 * @return instance
	 */
	public static RaceBuilder getInstance() {
		if (instance == null) {
			instance = new RaceBuilder();
		}
		return instance;
	}
	
	public Arena  buildArena(String arenaType, double length, int maxRacers) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		reflectClass = classLoder.loadClass(arenaType);//loading the class from path
		reflectConstractor = reflectClass.getConstructor(double.class, int.class);//loading the contractor 
		return(Arena) reflectConstractor.newInstance(length,maxRacers);//returning a new instance of the provided class
	}
	public Racer buildRacer(String racerType, String name, double maxSpeed, double
			acceleration, utilities.EnumContainer.Color color) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		reflectClass = classLoder.loadClass(racerType);
		reflectConstractor = reflectClass.getConstructor(String.class, double.class, double.class, Color.class);
		return (Racer)reflectConstractor.newInstance(name,maxSpeed,acceleration,color);

	}
	public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, 
			double acceleration, Color color, int numOfWheels) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		reflectClass = classLoder.loadClass(racerType);
		reflectConstractor = reflectClass.getConstructor(String.class, double.class, double.class, Color.class,int.class);
		return (Racer)reflectConstractor.newInstance(name,maxSpeed,acceleration,color,numOfWheels);

	}

}
