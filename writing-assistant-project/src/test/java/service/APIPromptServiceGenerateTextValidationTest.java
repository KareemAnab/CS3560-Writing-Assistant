package service;

import model.api.APIClient;
import model.factory.RequestFactory;
import model.strategy.CreativeModeStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class APIPromptServiceGenerateTextValidationTest {

    @Test
    public void throwsOnEmptyInput() {
        APIClient client = APIClient.getInstance("test-key", "https://example.com");
        APIPromptService service = new APIPromptService(client, new RequestFactory(), "m", new CreativeModeStrategy());
        assertThrows(IllegalArgumentException.class, () -> service.generateText("   "));
    }
}
