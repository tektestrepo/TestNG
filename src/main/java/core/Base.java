package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;

	// propertiesPath will return user directory of user.
	// C:\Users\SDET\Desktop\SDET_WS\com.bdd.tekschool\src\test\resources\Properties\ProjectProperty.properties
	private String propertiesPath = System.getProperty("user.dir");// C:\Users\SDET\Desktop\SDET_WS\com.bdd.tekschool
	private String ProjectPropertyPath = propertiesPath
			+ "\\src\\test\\resources\\Properties\\ProjectProperty.properties";

	// 0 Create a constructor

	public Base() {

		
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(ProjectPropertyPath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String browserName() {

		String browser = properties.getProperty("browserName");
		return browser;

	}

	public static String getURL() {

		String url = properties.getProperty("url");
		return url;

	}

	public static long getPageLoadTimeOut() {

		String pageLoadTimeOut = properties.getProperty("pageLoadTimeOut");

		return Long.parseLong(pageLoadTimeOut);

	}

	public static long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");

		return Long.parseLong(implicitlyWait);
	}

	public static void initializeDriver() {

		if (Base.browserName().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Base.browserName().equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (Base.browserName().equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
		System.out.println("this is before test");

		driver.get(getURL());

	}
	
	public static void teardown() {
		driver.close();
		driver.quit();
	}
	
	

}
