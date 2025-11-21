package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class APIPromptServiceExtractContentTest {

    @Test
    public void extractsFirstContentField() {
        String json = "{\"choices\":[{\"message\":{\"content\":\"Hello\\nWorld\"}}]}";
        APIPromptService service = new APIPromptService(null, null, "m", null);
        String content = service.extractContent(json);
        assertTrue(content.contains("Hello"));
        assertTrue(content.contains("World"));
    }
}
