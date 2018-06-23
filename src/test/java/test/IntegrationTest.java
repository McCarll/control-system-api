package test;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import ru.mccarl.controlsystem.api.App;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static junit.framework.Assert.assertTrue;
import static test.TestConfiguration.createDb;


public class IntegrationTest {

    @Before
    public void init() {
        assertThat(RULE.getConfiguration().getDataSourceFactory().getUrl()).isNotNull();
        assertTrue(createDb());
    }

    @ClassRule
    public static final DropwizardAppRule<AppConfig> RULE =
            new DropwizardAppRule<>(App.class,
                    ResourceHelpers.resourceFilePath("db/dbconfig.yml"));

    @Test
    public void ok(){
        Boolean ok = true;
        assertTrue(ok);
    }

}
