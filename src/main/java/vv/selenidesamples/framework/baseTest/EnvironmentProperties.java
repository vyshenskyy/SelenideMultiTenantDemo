package vv.selenidesamples.framework.baseTest;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties {

	private static final String DEFAULT_ENVIRONMENT_PROPERTIES_FILE = System.getProperty("environment.file.name");
	private static final String BROWSER_PROPERTIES_FILE = "browser.properties";
	private static final Properties DEFAULT_ENVIRONMENT_PROPERTIES = loadEnvironmentProperties(DEFAULT_ENVIRONMENT_PROPERTIES_FILE);
	private static final Properties BROWSER_PROPERTIES = loadProperties(BROWSER_PROPERTIES_FILE);

	private Properties envProperties;

	public EnvironmentProperties(String environmentPropertiesFileName) {
		envProperties = new Properties(BROWSER_PROPERTIES);
		if ("".equals(environmentPropertiesFileName)) {
			envProperties.putAll(DEFAULT_ENVIRONMENT_PROPERTIES);
		} else {
			Properties prop = loadEnvironmentProperties(environmentPropertiesFileName);
			envProperties.putAll(prop);
		}
	}

	public static String getProperty(Properties properties, String propertyKey) {
		String propertyValue = System.getProperty(propertyKey); // Try to read a property from system variables
		if (propertyValue == null) {
			propertyValue = properties.getProperty(propertyKey);
		}
		return propertyValue;
	}

	private static Properties loadEnvironmentProperties(String environmentPropertiesFileName) {
		String propFileName = "env/" + environmentPropertiesFileName + ".properties";
		return loadProperties(propFileName);
	}
	
	private static Properties loadProperties(String propFileName) {
		Properties prop = new Properties();
		try (InputStream inputStream = EnvironmentProperties.class.getClassLoader().getResourceAsStream(propFileName)) {
			prop.load(inputStream);
		} catch (Exception ex) {
			throw new RuntimeException("Cannot load properties from " + propFileName);
		}
		return prop;
	}

	public static String getBrowser() {
		return getProperty(BROWSER_PROPERTIES, "browser");
	}

	public static long getSelenideTimeout() {
		return Long.parseLong(getProperty(BROWSER_PROPERTIES, "selenide.timeout"));
	}

	public static String getBaseUrl() {
		return getProperty(BROWSER_PROPERTIES, "baseUrl");
	}

	public static String getRemote() {
		return getProperty(BROWSER_PROPERTIES, "remote");
	}

	public String getTestUrl() {
		String testUrl = getProperty(envProperties, "testUrl");
		// if this value is not defined, we use baseUrl
		return (null == testUrl) ? getBaseUrl() : testUrl;
	}

	/**
	 * @return url of the login page
	 */
	public String getLoginUrl() {
		String loginUrl = getProperty(envProperties, "loginUrl");
		return (null == loginUrl) ? getTestUrl() : loginUrl;
	}

	public String getLoginName() {
		return getProperty(envProperties, "loginName");
	}

	public String getPassword() {
		return getProperty(envProperties, "password");
	}
	
	public String getTenant() {
		return getProperty(envProperties, "tenant");
	}
}
