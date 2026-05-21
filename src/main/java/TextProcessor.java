import java.util.Set;
import java.util.TreeSet;

public class TextProcessor {

    public static Set<String> processText(StringBuffer text) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty or null");
        }

        String[] words = text.toString().split("\\s+");
        Set<String> uniqueWords = new TreeSet<>();

        for (String word : words) {

            String cleaned = word.replaceAll("[^a-zA-Zа-яА-ЯіїєІЇЄ]", "");

            if (!cleaned.isEmpty()) {
                uniqueWords.add(cleaned.toLowerCase());
            }
        }

        return uniqueWords;
    }

    public static void main(String[] args) {

        StringBuffer text = new StringBuffer(
                "Java is powerful and Java is popular and reliable"
        );

        Set<String> result = processText(text);

        System.out.println("Result:");
        for (String w : result) {
            System.out.println(w);
        }
    }
}
