import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    int dayMax = 30;
    int[] day = new int[dayMax];
    String[] mon = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август",
            "сентябрь", "октябрь", "ноябрь", "декабрь"};
    int objectiveOld = 10000;
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    ArrayList<Integer> stepUser;
    ArrayList<Integer> stepUserJan = new ArrayList<>();
    ArrayList<Integer> stepUserFeb = new ArrayList<>();
    ArrayList<Integer> stepUserMar = new ArrayList<>();
    ArrayList<Integer> stepUserApr = new ArrayList<>();
    ArrayList<Integer> stepUserMay = new ArrayList<>();
    ArrayList<Integer> stepUserJun = new ArrayList<>();
    ArrayList<Integer> stepUserJul = new ArrayList<>();
    ArrayList<Integer> stepUserAug = new ArrayList<>();
    ArrayList<Integer> stepUserSep = new ArrayList<>();
    ArrayList<Integer> stepUserOct = new ArrayList<>();
    ArrayList<Integer> stepUserNow = new ArrayList<>();
    ArrayList<Integer> stepUserDec = new ArrayList<>();

    HashMap<String, ArrayList<Integer>> stepsMonth = new HashMap<>();

    // метод по получению массива дней
    int[] dayMas() {
        for (int i = 0; i < dayMax; i++) { // заполняем массив днями
            day[i] = i;
        }
        return day;
    }

    // метод по созданию "нулевого списка"
    void stepZero() {
        for (int i = 0; i < dayMax; i++) { //делаем заготовку из "нулевого" списка по шагам
            Integer zero = 0;
            stepUserJan.add(i, zero);
            stepUserFeb.add(i, zero);
            stepUserMar.add(i, zero);
            stepUserApr.add(i, zero);
            stepUserMay.add(i, zero);
            stepUserJun.add(i, zero);
            stepUserJul.add(i, zero);
            stepUserAug.add(i, zero);
            stepUserSep.add(i, zero);
            stepUserOct.add(i, zero);
            stepUserNow.add(i, zero);
            stepUserDec.add(i, zero);
        }
    }

    // метод по созданию "нулевой таблицы"
    void table() {
        stepsMonth.put(mon[0], stepUserJan);
        stepsMonth.put(mon[1], stepUserFeb);
        stepsMonth.put(mon[2], stepUserMar);
        stepsMonth.put(mon[3], stepUserApr);
        stepsMonth.put(mon[4], stepUserMay);
        stepsMonth.put(mon[5], stepUserJun);
        stepsMonth.put(mon[6], stepUserJul);
        stepsMonth.put(mon[7], stepUserAug);
        stepsMonth.put(mon[8], stepUserSep);
        stepsMonth.put(mon[9], stepUserOct);
        stepsMonth.put(mon[10], stepUserNow);
        stepsMonth.put(mon[11], stepUserDec);
    }

    // метод для хранения данных о количестве пройденных шагов
    HashMap<String, ArrayList<Integer>> saveStep(String month, int dayUser) {
        int index = dayUser - 1; //Получение индекса для массива дней

        if (dayUser < 1) {
            System.out.println("Введите корректный день.");
        } else if (dayUser <= dayMax) {
            System.out.println("Укажите количество шагов:");
            int step = scanner.nextInt();
            stepUser = stepsMonth.get(month);
            stepUser.set(day[index], step);
            stepsMonth.put(month, stepUser);
        } else {
            System.out.println("В месяце всего " + dayMax + " дней. Введите корректный день.");
        }
        return stepsMonth;
    }

    //метод для вывода статистики за месяц
    void stepVar(String monthStat) {
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < dayMax; i++) {
            System.out.print("День " + (day[i] + 1) + ": " + stepMo.get(i) + "; ");
        }
    }

    //метод для вывода общего числа шагов за месяц
    double stepSum(String monthStat) {
        int summa = 0;
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < stepMo.size(); i++) {
            summa = summa + stepMo.get(i);
        }
        System.out.println();
        System.out.println("Общее количество шагов: " + summa);
        return summa;
    }

    //метод для вывода максимального количества шагов за месяц
    double stepMax(String monthStat) {
        int maximum = 0;
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < stepMo.size(); i++) {
            if (maximum < stepMo.get(i)) {
                maximum = stepMo.get(i);
            }
        }
        System.out.println("Максимальное количество шагов: " + maximum);
        return maximum;
    }

    //метод для вывода среднее количество шагов за месяц
    double stepMiddle(String monthStat) {
        int summa = 0;
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < stepMo.size(); i++) {
            summa = summa + stepMo.get(i);
        }
        double middle = summa / dayMax;
        System.out.println("Среднее количество шагов:" + middle);

        return middle;
    }

    //метод для вывода пройденных км за месяц
    double stepDis(String monthStat) {
        converter.stepDistance();
        int summa = 0;
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < dayMax; i++) {
            summa = summa + stepMo.get(i);
        }
        double stepDist = converter.stepDistance() * summa;
        System.out.println("Пройденная дистанция: " + stepDist + " км");
        return stepDist;
    }

    //метод для вывода сожженых калорий за месяц
    double calor(String monthStat) {
        converter.cCal();
        int summa = 0;
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int i = 0; i < dayMax; i++) {
            summa = summa + stepMo.get(i);
        }
        double stepCal = converter.cCal() * summa;
        System.out.println("Количество сожжённых килокалорий: " + stepCal + " кКал");
        return stepCal;
    }

    // метод по определению полосы достижений
    int stepWin(String monthStat) {
        int stepSeriesa = 0; // максимальная серия
        int check = 0; // счетчик дней
        ArrayList<Integer> stepMo = stepsMonth.get(monthStat);
        for (int j = 0; j < stepMo.size(); j++) {
            if (stepMo.get(j) >= objectiveOld) {
                check += 1;
            } else {
                if (check > stepSeriesa) {
                    stepSeriesa = check;
                    check = 0;
                }
            }
        }
        System.out.println("Ваша череда достижений составляет: " + stepSeriesa + " дней.");
        return stepSeriesa;
    }

    // метод для задания новой цели
    void objectiveStep() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int objective = scanner.nextInt();
        while (true) {
            if (objective < 0) {
                System.out.println("Цель не может быть отрицательной. Введите новую цель.");
            } else {
                objectiveOld = objective;
                System.out.println("Новая цель в " + objectiveOld + " установлена!");
            }
            break;
        }
    }
}