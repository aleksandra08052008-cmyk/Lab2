import java.util.Arrays;
import java.util.Comparator;

public class TextProcessor {

    /**
     * Метод повертає слова без повторень,
     * відсортовані за українським алфавітом.
     *
     * @param text текст для обробки
     * @return масив унікальних слів
     */
    public static StringBuffer[] processText(StringBuffer text) {

        if (text == null) {
            throw new IllegalArgumentException(
                    "Текст не може бути null."
            );
        }

        if (text.length() == 0) {
            throw new IllegalArgumentException(
                    "Текстовий рядок порожній."
            );
        }

        String[] words = text.toString()
                .toLowerCase()
                .replaceAll("[^а-яіїєґa-z0-9\\s]", "")
                .split("\\s+");

        if (words.length == 0) {
            throw new IllegalArgumentException(
                    "У тексті відсутні слова."
            );
        }

        StringBuffer[] uniqueWords =
                new StringBuffer[words.length];

        int uniqueCount = 0;

        for (String word : words) {

            boolean isDuplicate = false;

            for (int i = 0; i < uniqueCount; i++) {

                if (uniqueWords[i].toString()
                        .contentEquals(word)) {

                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {

                uniqueWords[uniqueCount] =
                        new StringBuffer(word);

                uniqueCount++;
            }
        }

        StringBuffer[] resultWords =
                new StringBuffer[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            resultWords[i] = uniqueWords[i];
        }

        final String ukrainianAlphabet =
                "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

        Arrays.sort(resultWords,
                new Comparator<StringBuffer>() {

                    @Override
                    public int compare(
                            StringBuffer firstWord,
                            StringBuffer secondWord) {

                        char firstChar =
                                firstWord.charAt(0);

                        char secondChar =
                                secondWord.charAt(0);

                        int firstIndex =
                                ukrainianAlphabet.indexOf(
                                        firstChar
                                );

                        int secondIndex =
                                ukrainianAlphabet.indexOf(
                                        secondChar
                                );

                        return Integer.compare(
                                firstIndex,
                                secondIndex
                        );
                    }
                });

        return resultWords;
    }

    public static void main(String[] args) {

        try {

            StringBuffer text =
                    new StringBuffer(
                            "Мова Java є популярною і Java є потужною платформою"
                    );

            StringBuffer[] result =
                    processText(text);

            System.out.println(
                    "Результат:"
            );

            for (StringBuffer word : result) {
                System.out.println(word);
            }

        } catch (Exception exception) {

            System.out.println(
                    "Помилка: "
                            + exception.getMessage()
            );
        }
    }
}
