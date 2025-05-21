package web.service;

public class ScienceQuestionService {

    private static final double G = 6.674e-11; // gravitational constant

    public static double calculateGravitationalForce(double mass1, double mass2, double distance) {
        if (distance == 0) throw new IllegalArgumentException("Distance cannot be zero");
        return G * (mass1 * mass2) / (distance * distance);
    }
}