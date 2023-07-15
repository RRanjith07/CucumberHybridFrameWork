package utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties getPropeties() throws IOException {
        Properties prop = new Properties();
        File file = new File(System.getProperty("user.dir")+
                "\\src\\test\\resources\\config\\Config.properties");
        try{
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        }catch (Throwable e) {e.printStackTrace();}

        return prop;
    }
}
