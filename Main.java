public class Ponomarenko Oleksandra\Main {

    public static void main(String[] args) {

        // C2 = 1  -> O1 = -
        // C3 = 2  -> C = 2
        // C5 = 0  -> O2 = *
        // C7 = 5  -> тип індексів float

        float a = 1;
        float n = 6;
        float m =4;
        float C = 2;

        double S = 0;

        try {

            for (float i = a; i <= n; i++) {

                for (float j = a; j <= m; j++) {

                    // O2 = *
                    float numerator = i * j;

                    // O1 = -
                    float denominator = i - C;

                    // перевірка ділення на нуль
                    if (denominator == 0) {
                        throw new ArithmeticException(
                                "Ділення на нуль: i - C = 0 при i = " + i);
                    }

                    S += numerator / denominator;
                }
            }

            System.out.println("S = " + S);

        } catch (ArithmeticException e) {

            System.out.println("Помилка: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}