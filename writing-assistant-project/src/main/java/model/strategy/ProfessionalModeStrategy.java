package model.strategy;

public class ProfessionalModeStrategy implements WritingModeStrategy {
    @Override
    public String buildPrompt(String userText) {
        return "Rewrite the following in a concise, professional tone:\n\n" + userText;
    }

    @Override
    public String getName() {
        return "Professional";
    }
}
