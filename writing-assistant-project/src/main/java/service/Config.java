package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final Properties props = new Properties();

    public Config() {
        try (InputStream in =
                     Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found on classpath");
            }
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load config.properties", e);
        }
    }

    public String getOpenAIApiKey() {
        return props.getProperty("OPENAI_API_KEY");
    }

    public String getBaseUrl() {
        return props.getProperty("OPENAI_BASE_URL", "https://api.openai.com/v1");
    }

    public String getModelName() {
        return props.getProperty("MODEL_NAME", "gpt-4.1-mini");
    }
}
