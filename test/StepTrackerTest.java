import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTrackerTest {

    int dayMax = 30;

    Converter converter = new Converter();
    StepTracker stepTracker = new StepTracker();

    @Test
    void wrongDayTest() {
        int month = 1;

        assertNull(stepTracker.getSaveStep(month, -5, 0));
        assertNull(stepTracker.getSaveStep(month, 50, 0));
    }

    @Test
    void objectiveStepTest() {
        assertEquals(10000 , stepTracker.objectiveStep(-1000));
        assertEquals(12000 , stepTracker.objectiveStep(12000));
    }

    @Test
    void getStepSumTest() {
        int month = 1;
        stepTracker.getSaveStep(month, 1, 1000);
        stepTracker.getSaveStep(month, 2, 2000);
        stepTracker.getSaveStep(month, 3, 3000);
        stepTracker.getSaveStep(month, 4, 4000);
        stepTracker.getSaveStep(month, 10, 5000);
        stepTracker.getSaveStep(month, 17, 10500);

        assertEquals(25500, stepTracker.getStepSum(month));
    }

    @Test
    void getStepMaxTest() {
        int month = 2;
        stepTracker.getSaveStep(month, 1, 15020);
        stepTracker.getSaveStep(month, 2, 15430);
        stepTracker.getSaveStep(month, 3, 14761);
        stepTracker.getSaveStep(month, 4, 18612);
        stepTracker.getSaveStep(month, 10, 18465);
        stepTracker.getSaveStep(month, 25, 22451);

        assertEquals(22451, stepTracker.getStepMax(month));
    }

    @Test
    void getStepMiddleTest() {
        int month = 3;
        for (int i =1; i<=dayMax; i++) {
            stepTracker.getSaveStep(month, i, 10000);
        }

        assertEquals(10000.0, stepTracker.getStepMiddle(month));
    }

    @Test
    void getStepZeroWinTest() {
        int month = 4;
        for (int i =1; i<=dayMax; i++) {
            stepTracker.getSaveStep(month, i, 9000);
        }

        assertEquals(0, stepTracker.getStepWin(month));
    }

    @Test
    void getStepWinTest() {
        int month = 5;
        stepTracker.getSaveStep(month, 1, 121);
        stepTracker.getSaveStep(month, 2, 12100);
        stepTracker.getSaveStep(month, 3, 13100);
        stepTracker.getSaveStep(month, 4, 21600);
        stepTracker.getSaveStep(month, 5, 1846);
        stepTracker.getSaveStep(month, 6, 12315);
        stepTracker.getSaveStep(month, 7, 12315);
        stepTracker.getSaveStep(month, 8, 12315);
        stepTracker.getSaveStep(month, 9, 12315);
        stepTracker.getSaveStep(month, 10, 12315);

        assertEquals(5, stepTracker.getStepWin(month));
    }

    @Test
    void getStepDistanceTest() {
        int summ = dayMax*9000;
        converter.getStepDistance(summ);
        converter.getCalories(summ);

        assertEquals(202.5, converter.getStepDistance(summ));
        assertEquals(13500.0 , converter.getCalories(summ));
    }
}