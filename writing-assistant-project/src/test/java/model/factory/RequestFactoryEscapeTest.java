package model.factory;

import model.strategy.CreativeModeStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestFactoryEscapeTest {

    @Test
    public void bodyEscapesQuotes() {
        RequestFactory factory = new RequestFactory();
        String body = factory.buildRequestBody(
                "m",
                new CreativeModeStrategy(),
                "He said \"hi\""
        );

        // Body should NOT contain raw quotes
        assertFalse(body.contains("He said \"hi\""));
    }
}
