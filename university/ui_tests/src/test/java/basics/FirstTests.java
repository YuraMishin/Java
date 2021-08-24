package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class basics.FirstTests.
 * Implements FirstTests.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.08.2021
 */
class FirstTests {
    /**
     * Tests h1 tag
     */
    @Test
    void shouldTestH1() {
        // given
        var expected = "University";
        var url = "http://localhost:8080/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver(options);

        // when
        driver.get(url);
        var actual = driver.findElementByTagName("h1").getText();
        driver.quit();

        // then
        assertThat(expected).isEqualTo(actual);
    }
}
