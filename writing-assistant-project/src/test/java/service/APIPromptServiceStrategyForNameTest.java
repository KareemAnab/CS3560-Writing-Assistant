package service;

import model.strategy.AcademicModeStrategy;
import model.strategy.CreativeModeStrategy;
import model.strategy.ProfessionalModeStrategy;
import model.strategy.WritingModeStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class APIPromptServiceStrategyForNameTest {

    @Test
    public void returnsCorrectStrategyForName() {
        WritingModeStrategy s1 = APIPromptService.strategyForName("Creative");
        WritingModeStrategy s2 = APIPromptService.strategyForName("Professional");
        WritingModeStrategy s3 = APIPromptService.strategyForName("Academic");
        assertTrue(s1 instanceof CreativeModeStrategy);
        assertTrue(s2 instanceof ProfessionalModeStrategy);
        assertTrue(s3 instanceof AcademicModeStrategy);
    }
}
