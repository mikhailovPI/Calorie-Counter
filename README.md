
# Программа счетчика калорий

**Данная программа может**

1. Хранение данных о количестве пройденных шагов за несколько месяцев;
2. Ввод вашей цели по количеству шагов в день;
3. Ввод пройденного количества шагов за день;
4. Вывод статистики за определённый месяц.

4.1. Количество пройденных шагов по дням;
4.2. Общее количество шагов за месяц;
4.3. Максимальное пройденное количество шагов в месяце;
4.4. Среднее количество шагов;
4.5. Пройденная дистанция (в км);
4.6. Количество сожжённых килокалорий;
4.7. Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.

Программа написана на Java. Пример кода:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
```
