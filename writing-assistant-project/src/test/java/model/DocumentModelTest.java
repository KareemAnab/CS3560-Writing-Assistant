package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentModelTest {

    @Test
    public void listenersAreNotified() {
        DocumentModel model = new DocumentModel();
        final boolean[] called = {false};
        final String[] latest = {"", ""};

        model.addListener((in, out) -> {
            called[0] = true;
            latest[0] = in;
            latest[1] = out;
        });

        model.setInputText("in");
        model.setOutputText("out");

        assertTrue(called[0]);
        assertEquals("in", latest[0]);
        assertEquals("out", latest[1]);
    }
}
