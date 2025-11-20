package model.factory;

import model.strategy.WritingModeStrategy;

public class RequestFactory {

    public String buildRequestBody(String modelName,
                                   WritingModeStrategy modeStrategy,
                                   String userText) {
        String prompt = modeStrategy.buildPrompt(userText);
        String escaped = escape(prompt);

        String body = """
                {
                  "model": "%s",
                  "messages": [
                    { "role": "user", "content": "%s" }
                  ],
                  "max_tokens": 300
                }
                """;

        return body.formatted(modelName, escaped);
    }

    // basic escaping so JSON is valid
    private String escape(String text) {
        return text
                .replace("\\", "\\\\")   // backslash -> \\
                .replace("\"", "\\\"")   // double quote -> \"
                .replace("\n", "\\n");   // newline -> \n
    }
}
