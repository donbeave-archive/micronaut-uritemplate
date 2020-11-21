package micronaut.uritemplate;

import io.micronaut.http.uri.UriMatchInfo;
import io.micronaut.http.uri.UriMatchTemplate;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MicronautTest {

    private static final String URL_FORMAT = "https://www.mydomain.com/post/{postSlug}";

    @Test
    void micronautUriTemplate() {
        // given
        UriMatchTemplate template = UriMatchTemplate.of(URL_FORMAT);

        // expect
        assertEquals("https://www.mydomain.com/post/zzz", template.expand(Map.of("postSlug", "zzz")));

        // when
        Optional<UriMatchInfo> match = template.match("https://www.mydomain.com/post/abc");

        // then
        assertTrue(match.isPresent());
        assertTrue(match.get().getVariableValues().containsKey("postSlug"));
        assertEquals("abc", match.get().getVariableValues().get("postSlug"));
    }

}
