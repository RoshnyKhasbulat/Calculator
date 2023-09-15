import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение строки с арифметическим выражением
        String input = scanner.nextLine();

        try {
            // Вычисление результата и вывод на экран
            String result = calc(input);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws ArithmeticException, IllegalArgumentException {
        // Разделение строки на операнды и операцию
        String[] elements = input.split(" ");

        // Проверка наличия трех элементов в строке
        if (elements.length != 3) {
            throw new IllegalArgumentException("Неправильный формат выражения");
        }

        try {
            int a = Integer.parseInt(elements[0]);
            int b = Integer.parseInt(elements[2]);

            int result;

            // Выполнение арифметической операции в зависимости от символа операции
            switch (elements[1]) {
                case "+":
                    result = a + b;
                    break;

                case "-":
                    result = a - b;
                    break;

                case "*":
                    result = a * b;
                    break;

                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("Деление на ноль недопустимо");
                    }
                    result = a / b;
                    break;

                default:
                    throw new IllegalArgumentException("Неподдерживаемая операция");
            }

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат чисел");
        }
    }
}