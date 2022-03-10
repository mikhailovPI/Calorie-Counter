import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    int dayMax = 30;
    int summaStep = 0; // ввожу ее тут, т.к. она используется дальше в расчетах среднего значения, дистанции и калорий
    int objectiveOld = 10000;

    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    HashMap<Integer, ArrayList<Integer>> monthToData = new HashMap<>();

    //создание хэш-таблицы для хранения данных
    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            monthToData.put(i, new ArrayList<Integer>(dayMax));
            for (int j = 0; j < dayMax; j++) {
                Integer zero = 0;
                monthToData.get(i).add(j, zero);
            }
        }
    }

    // метод для хранения данных о количестве пройденных шагов
    HashMap<Integer, ArrayList<Integer>> getSaveStep(int month, int dayUser, int step) {
        if (dayUser < 1) {
            System.out.println("Введите корректный день.");
        } else if (dayUser <= dayMax) {
            monthToData.get(month).set(dayUser - 1, step); // список шагов
            System.out.println(monthToData.get(month));
        } else {
            System.out.println("В месяце всего " + dayMax + " дней. Введите корректный день.");
        }
        return monthToData;
    }

    //метод для вывода статистики за месяц
    void getStepVar(int monthStat) {
        ArrayList<Integer> getStepMonth = monthToData.get(monthStat);
        int[] day = new int[dayMax];

        for (int i = 0; i < dayMax; i++) {
            System.out.printf("День " + (i + 1) + ": " + getStepMonth.get(i) + "; ");
        }

    }

    //метод для вывода общего числа шагов за месяц
    int getStepSum(int monthStat) {
        ArrayList<Integer> getStepMonth = monthToData.get(monthStat);
        for (int i = 0; i < getStepMonth.size(); i++) {
            summaStep = summaStep + getStepMonth.get(i);
        }

        return summaStep;
    }

    //метод для вывода максимального количества шагов за месяц
    double getStepMax(int monthStat) {
        int maximumStep = 0;
        ArrayList<Integer> getStepMonth = monthToData.get(monthStat);
        for (int i = 0; i < getStepMonth.size(); i++) {
            if (maximumStep < getStepMonth.get(i)) {
                maximumStep = getStepMonth.get(i);
            }
        }
        System.out.println("Максимальное количество шагов: " + maximumStep);
        return maximumStep;
    }

    //метод для вывода среднего количества шагов за месяц
    double getStepMiddle(int monthStat) {
        double middleStep = summaStep / dayMax;
        System.out.println("Среднее количество шагов:" + middleStep);

        return middleStep;
    }

    // метод по определению полосы достижений
    int getStepWin(int monthStat) {
        int stepSeries = 0; // максимальная серия
        int check = 0; // счетчик дней
        ArrayList<Integer> stepMo = monthToData.get(monthStat);
        for (int j = 0; j < stepMo.size(); j++) {
            if (stepMo.get(j) >= objectiveOld) {
                check += 1;
            } else {
                if (check > stepSeries) {
                    stepSeries = check;
                    check = 0;
                }
            }
        }
        System.out.println("Ваша череда достижений составляет: " + stepSeries + " дней.");
        return stepSeries;
    }

    //метод для отображения статистики
    void getStatisticMonth(int month) {
        getStepVar(month);
        getStepSum(month);
        System.out.println();
        System.out.println("Общее количество шагов: " + getStepSum(month));
        getStepMax(month);
        getStepMiddle(month);
        converter.getStepDistance(summaStep);
        converter.getCalories(summaStep);
        getStepWin(month);
        //System.out.println(summaStep);
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