public abstract class PluginManager {
	public static Plugin load(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName(name);	
		return (Plugin) c.newInstance();
	}
}
