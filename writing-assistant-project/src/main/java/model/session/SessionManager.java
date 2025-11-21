package model.session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SessionManager {

    private final Path file;

    public SessionManager(Path file) {
        this.file = file;
    }

    public void save(String input, String output) throws IOException {
        String combined = "---INPUT---\n" + input + "\n---OUTPUT---\n" + output + "\n";
        Files.writeString(file, combined);
    }

    public String[] load() throws IOException {
        if (!Files.exists(file)) {
            return new String[] {"", ""};
        }

        String content = Files.readString(file);

        String[] parts = content.split("---OUTPUT---\\n", 2);
        if (parts.length < 2) {
            return new String[] {content.trim(), ""};
        }

        String inputPart = parts[0].replaceFirst("^---INPUT---\\n", "");
        String outputPart = parts[1];

        // Remove a single trailing newline if present
        if (inputPart.endsWith("\n")) {
            inputPart = inputPart.substring(0, inputPart.length() - 1);
        }
        if (outputPart.endsWith("\n")) {
            outputPart = outputPart.substring(0, outputPart.length() - 1);
        }

        return new String[] {inputPart, outputPart};
    }
}
