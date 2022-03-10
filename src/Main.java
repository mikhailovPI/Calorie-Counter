import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        stepTracker.table();
        stepTracker.dayMas();
        stepTracker.stepZero();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {

                Scanner scan = new Scanner(System.in);
                System.out.println("Укажите месяц, за который необходимо ввести количество шагов:");
                String months = scan.nextLine();
                String mon = months.toLowerCase();
                System.out.println("Укажите день, за который необходимо ввести количество шагов:");
                int dayUser = scan.nextInt();
                stepTracker.saveStep(mon, dayUser);

            } else if (command == 2) {
                Scanner scan = new Scanner(System.in);
                System.out.println("За какой месяц вывести статистику?");
                String monthsStat = scan.nextLine();
                String monthStat = monthsStat.toLowerCase();
                System.out.println(" Вы имеете следующую статистику:");
                stepTracker.stepVar(monthStat);
                stepTracker.stepSum(monthStat);
                stepTracker.stepMax(monthStat);
                stepTracker.stepMiddle(monthStat);
                stepTracker.stepDis(monthStat);
                stepTracker.calor(monthStat);
                stepTracker.stepWin(monthStat);

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
