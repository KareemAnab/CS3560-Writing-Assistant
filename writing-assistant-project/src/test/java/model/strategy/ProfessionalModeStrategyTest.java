package model.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessionalModeStrategyTest {

    @Test
    public void promptContainsOriginalText() {
        ProfessionalModeStrategy s = new ProfessionalModeStrategy();
        String text = "Hello";
        String result = s.buildPrompt(text);
        assertTrue(result.contains(text));
    }
}
