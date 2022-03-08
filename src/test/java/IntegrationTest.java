import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = com.cetin.education.spring.primefaces.Demo.class)
public class IntegrationTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void test() {
        this.webClient.get().uri("/index.xhtml").exchange().expectStatus().isOk();
    }
}
