package model.session;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SessionManagerTest {

    @Test
    public void saveAndLoadRoundTrip() throws IOException {
        Path temp = Files.createTempFile("session", ".txt");
        SessionManager sm = new SessionManager(temp);

        String in = "input text";
        String out = "output text";

        sm.save(in, out);
        String[] pair = sm.load();

        assertEquals(in, pair[0]);
        assertEquals(out, pair[1]);
    }
}
