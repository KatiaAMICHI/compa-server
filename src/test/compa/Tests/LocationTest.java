package compa.Tests;

import compa.app.ClassFinder;
import compa.app.Container;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class LocationTest {

    Vertx vertx;

    @Before
    public void before(TestContext context) {
        Container c = new Container(context.asyncAssertSuccess(), Container.MODE.TEST);
        c.run(new ClassFinder());
        vertx = c.getVertx();
    }

    @After
    public void after(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void newInstanceWork(TestContext context) {
    }

    // based on fake location
    @Test
    public void getLocationOnPeriod(TestContext context) {
    }
}
