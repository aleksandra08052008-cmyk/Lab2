import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    void testUniqueWordsSorting() {

        StringBuffer input = new StringBuffer(
                "Java is Java and powerful is"
        );

        Set<String> result = TextProcessor.processText(input);

        assertEquals(Set.of("and", "is", "java", "powerful"), result);
    }

    @Test
    void testEmptyText() {

        StringBuffer input = new StringBuffer("");

        assertThrows(IllegalArgumentException.class, () ->
                TextProcessor.processText(input)
        );
    }

    @Test
    void testNullText() {

        assertThrows(IllegalArgumentException.class, () ->
                TextProcessor.processText(null)
        );
    }
}
