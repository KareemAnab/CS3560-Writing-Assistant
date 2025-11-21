package model.strategy;

public class AcademicModeStrategy implements WritingModeStrategy {
    @Override
    public String buildPrompt(String userText) {
        return "Rewrite the following in a clear academic style appropriate for a college essay:\n\n" + userText;
    }

    @Override
    public String getName() {
        return "Academic";
    }
}
