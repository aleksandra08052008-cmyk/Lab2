import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    public void testNormalText() {

        StringBuffer text =
                new StringBuffer(
                        "Мова Java є популярною"
                );

        StringBuffer[] result =
                TextProcessor.processText(text);

        assertEquals(4, result.length);
    }

    @Test
    public void testDuplicateWords() {

        StringBuffer text =
                new StringBuffer(
                        "Java Java Java"
                );

        StringBuffer[] result =
                TextProcessor.processText(text);

        assertEquals(1, result.length);

        assertEquals(
                "java",
                result[0].toString()
        );
    }

    @Test
    public void testNullText() {

        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> TextProcessor.processText(null)
                );

        assertEquals(
                "Текст не може бути null.",
                exception.getMessage()
        );
    }

    @Test
    public void testEmptyText() {

        StringBuffer text =
                new StringBuffer("");

        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> TextProcessor.processText(text)
                );

        assertEquals(
                "Текстовий рядок порожній.",
                exception.getMessage()
        );
    }

    @Test
    public void testSpecialCharacters() {

        StringBuffer text =
                new StringBuffer(
                        "Привіт!!! Java???"
                );

        StringBuffer[] result =
                TextProcessor.processText(text);

        assertEquals(2, result.length);
    }

    @Test
    public void testSorting() {

        StringBuffer text =
                new StringBuffer(
                        "яблуко банан абрикос"
                );

        StringBuffer[] result =
                TextProcessor.processText(text);

        assertEquals(
                "абрикос",
                result[0].toString()
        );

        assertEquals(
                "банан",
                result[1].toString()
        );

        assertEquals(
                "яблуко",
                result[2].toString()
        );
    }
}
