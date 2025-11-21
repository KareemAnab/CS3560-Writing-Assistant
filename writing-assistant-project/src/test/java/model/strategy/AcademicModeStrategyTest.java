package model.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcademicModeStrategyTest {

    @Test
    public void promptContainsOriginalText() {
        AcademicModeStrategy s = new AcademicModeStrategy();
        String text = "Hello";
        String result = s.buildPrompt(text);
        assertTrue(result.contains(text));
    }
}
