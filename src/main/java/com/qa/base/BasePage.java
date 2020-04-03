package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.ExcelReader;

/**
 * @author tanvig
 *
 *         base class to load initial setup files
 *
 */
public class BasePage {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\qa\\excel\\UserData.xlsx");
	public static WebDriverWait wait;
	public static String browser;
	public static TopMenu menu;

	public BasePage() {

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\qa\\properties\\Config.properties");
				config.load(fis);
				log.debug("Config file loaded !!!!");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\qa\\properties\\OR.properties");
				OR.load(fis);
				log.debug("OR file loaded !!!");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\qa\\executables\\chromedriver.exe");

				driver = new ChromeDriver();
				log.debug("Chrome browser launched.");

			} else if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\qa\\executables\\geckodriver.exe");

				driver = new FirefoxDriver();
				log.debug("Firefox browser launched.");

			}

			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 5);
			menu = new TopMenu(driver, OR);

		}

	}

	public static void quit() {

		driver.quit();
		log.debug(" browser quit !!.");

	}

}
