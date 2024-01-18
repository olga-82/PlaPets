package utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if (properties.toString().equals("{}")) {
            initProperties();
        }
        return properties.getProperty(param);
    }

    private static void initProperties() {
      //  String target = System.getProperty("target", "prod");
        // src/test/resources/prod.properties
        String path = String.format("src/test/resources/prod.properties");
        try (FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


//    public static String getProperty(Type param) {
//        if (properties.toString().equals("{}")) {
//            initProperty();
//        }
//        return properties.getProperty(String.valueOf(param));
//    }
//
//    public static String getProperty(Sex param) {
//        if (properties.toString().equals("{}")) {
//            initProperty();
//        }
//        return properties.getProperty(String.valueOf(param));
//    }


