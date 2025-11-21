package service;

import model.api.APIClient;
import model.factory.RequestFactory;
import model.strategy.AcademicModeStrategy;
import model.strategy.CreativeModeStrategy;
import model.strategy.ProfessionalModeStrategy;
import model.strategy.WritingModeStrategy;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIPromptService {

    private final APIClient client;
    private final RequestFactory factory;
    private final String modelName;
    private WritingModeStrategy mode;

    public APIPromptService(APIClient client,
                            RequestFactory factory,
                            String modelName,
                            WritingModeStrategy initialMode) {
        this.client = client;
        this.factory = factory;
        this.modelName = modelName;
        this.mode = initialMode;
    }

    public static APIPromptService fromConfig() {
        Config config = new Config();
        APIClient client = APIClient.getInstance(
                config.getOpenAIApiKey(),
                config.getBaseUrl()
        );
        RequestFactory factory = new RequestFactory();
        WritingModeStrategy initial = new CreativeModeStrategy();
        return new APIPromptService(client, factory, config.getModelName(), initial);
    }

    public void setMode(WritingModeStrategy mode) {
        this.mode = mode;
    }

    public WritingModeStrategy getMode() {
        return mode;
    }

    public String generateText(String userText) throws IOException, InterruptedException {
        if (userText == null || userText.trim().isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be empty");
        }

        String body = factory.buildRequestBody(modelName, mode, userText);
        String rawResponse = client.postJson("/chat/completions", body);
        return extractContent(rawResponse);
    }

    // package-private for tests
    // package-private for tests
    String extractContent(String raw) {
        Pattern p = Pattern.compile("\"content\"\\s*:\\s*\"(.*?)\"", Pattern.DOTALL);
        Matcher m = p.matcher(raw);

        if (m.find()) {
            String content = m.group(1);

            // Convert escaped newlines in JSON to real newlines
            content = content.replace("\\n", System.lineSeparator());

            // Unescape quotes
            content = content.replace("\\\"", "\"");

            // Unescape backslashes
            content = content.replace("\\\\", "\\");

            return content.trim();
        }

        return "No content found in response.";
    }


    public static WritingModeStrategy strategyForName(String name) {
        if ("Professional".equals(name)) {
            return new ProfessionalModeStrategy();
        } else if ("Academic".equals(name)) {
            return new AcademicModeStrategy();
        } else {
            return new CreativeModeStrategy();
        }
    }
}
