package model.strategy;

public interface WritingModeStrategy {
    String buildPrompt(String userText);
    String getName();
}
