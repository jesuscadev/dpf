package jesuscadev.dpf;

import jesuscadev.dpf.core.DataProcessingFrameworkMain;
import jesuscadev.dpf.util.DpfInitialization;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
	public static Logger logger;
	private static final String loginPropertiesFile = "config/logging.properties";
	private static final String dpfPropertiesFile = "config/dpfProperties.xml";
	private static DataProcessingFrameworkMain dpfMain;

	static {
		DpfInitialization.initializeLogger(loginPropertiesFile);
	}

	public static void main(String[] dpfArgs) {
		try {
			logger.info("Started Data Processing Framework process.");
			DpfInitialization.readProperties(dpfPropertiesFile);
			DpfInitialization.processArguments(dpfArgs);
			String dpfConfigFile = DpfInitialization.getDpfConfigFile();
			if (!dpfConfigFile.equals("")) {
				DataProcessingFrameworkMain dpfMain = new DataProcessingFrameworkMain();
				dpfMain.process(dpfConfigFile);
			} else {
				logger.severe("dpfConfigFile property not defined.");
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		} finally {
			logger.info("Finished Data Processing Framework process.");
		}
	}
}
