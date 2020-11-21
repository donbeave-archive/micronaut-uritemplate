package micronaut.uritemplate;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpringTest {

    private static final String URL_FORMAT = "https://www.mydomain.com/post/{postSlug}";

    @Test
    void springUriTemplate() {
        // given
        UriTemplate template = new UriTemplate(URL_FORMAT);

        // expect
        assertEquals("https://www.mydomain.com/post/zzz", template.expand(Map.of("postSlug", "zzz")).toString());

        // when
        Map<String, String> match = template.match("https://www.mydomain.com/post/abc");

        // then
        assertNotNull(match.get("postSlug"));
        assertEquals("abc", match.get("postSlug"));
    }

}
