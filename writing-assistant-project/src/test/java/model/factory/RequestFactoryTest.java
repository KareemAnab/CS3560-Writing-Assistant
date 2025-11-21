package model.factory;

import model.strategy.CreativeModeStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RequestFactoryTest {

    @Test
    public void bodyContainsModelAndContent() {
        RequestFactory factory = new RequestFactory();
        String body = factory.buildRequestBody("test-model", new CreativeModeStrategy(), "Hello");
        assertTrue(body.contains("test-model"));
        assertTrue(body.contains("Hello"));
    }
}
