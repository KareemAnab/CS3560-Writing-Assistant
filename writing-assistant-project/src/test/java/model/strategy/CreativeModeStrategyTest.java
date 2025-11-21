package model.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreativeModeStrategyTest {

    @Test
    public void promptContainsOriginalText() {
        CreativeModeStrategy s = new CreativeModeStrategy();
        String text = "Hello";
        String result = s.buildPrompt(text);
        assertTrue(result.contains(text));
    }
}
