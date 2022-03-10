public class Converter {

    double getStepDistance(int summa) {
        double lengthStep = 75 * 1e-5; // длина шага в км
        double distance = summa * lengthStep;
        System.out.println("Пройденная дистанция: " + distance + " км");
        return distance;
    }

    double getCalories(int summa) {
        double stepCal = 50; // количетво каллорий в одном шаге
        double cal = ((stepCal) / 1000) * summa;
        System.out.println("Количество сожжённых килокалорий: " + cal + " кКал");
        return cal;
    }
}