package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestScienceQuestionService {

    @Test
    public void testCalculateGravitationalForceValid() {
        double force = ScienceQuestionService.calculateGravitationalForce(5.972e24, 7.348e22, 384400000);
        assertTrue(force > 1e20 && force < 2e20); // Expected ~1.98e20
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateGravitationalForceZeroDistance() {
        ScienceQuestionService.calculateGravitationalForce(1000, 1000, 0);
    }
}