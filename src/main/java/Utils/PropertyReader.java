package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

	public PropertyReader() {

	}

	static FileInputStream fileInputStream = null;
	static Properties properties = null;
	static Map<String, String> property_keys = new HashMap<>();

	static {

		try {

			fileInputStream = new FileInputStream(
					new File(System.getProperty("user.dir")) + "/src/test/resources/config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
			for (Object key : properties.keySet()) {

				property_keys.put(String.valueOf(key), properties.getProperty(String.valueOf(key)));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (Objects.nonNull(fileInputStream)) {

				try {

					fileInputStream.close();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static String readKeys(String key) throws Exception {

		if (key == null && properties.getProperty(key) == null) {

			throw new Exception(properties.getProperty(key) + "Data Not Found!!");
		} else {

			return property_keys.get(key);
		}
	}
}
