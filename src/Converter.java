public class Converter {

    double stepDistance() {
        double shagD = 75 * 1e-5; // длина шага в км
        int shag = 1;
        double distance = shag * shagD;
        return distance;
    }

    double cCal() {
        double stepCal = 50; // количетво каллорий в одном шаге
        double cal = (stepCal) / 1000;
        return cal;
    }
}