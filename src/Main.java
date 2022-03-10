import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Укажите месяц, за который необходимо ввести количество шагов:");
                int month = scanner.nextInt();
                System.out.println("Укажите день, за который необходимо ввести количество шагов:");
                int dayUser = scanner.nextInt();
                System.out.println("Укажите количество шагов:");
                int step = scanner.nextInt();
                stepTracker.getSaveStep(month, dayUser, step);

            } else if (command == 2) {
                System.out.println("За какой месяц вывести статистику?");
                int monthStat = scanner.nextInt();
                System.out.println(" Вы имеете следующую статистику:");
                stepTracker.getStatisticMonth(monthStat);

            } else if (command == 3) {
                stepTracker.objectiveStep();

            } else if (command == 4) {
                System.out.println("До встречи!");
                break;
            } else {
                System.out.println("Такой команды не существует. Введите другую команду :)");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберети действие:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}