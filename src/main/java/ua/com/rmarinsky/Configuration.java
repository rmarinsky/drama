package ua.com.rmarinsky;

public class Configuration {

    public static String baseUrl = null;
    public static boolean headless = true;
    public static boolean devTools = false;
    public static double defaultTimeout = 4000.0;
    public static double poolingInterval = 0.0;

    public static double browserToStartTimeout = 40000.0;

    public static boolean saveTraces = true;

    public static String tracesPath = System.getProperty("user.dir") + "/build/pw";

}
