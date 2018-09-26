package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();

	}

	public static void getProperties() throws IOException {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir");
		InputStream input = new FileInputStream(path+"\\src\\test\\java\\config\\config.properties");
		prop.load(input);
		String Browser = prop.getProperty("browser");
		System.out.println("Browser: "+Browser);
	}
	
	public static void setProperties() throws IOException {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir");
		OutputStream output = new FileOutputStream(path+"\\src\\test\\java\\config\\config.properties");
		prop.setProperty("browser", "Chrome");
		prop.store(output, null);
	}

}
