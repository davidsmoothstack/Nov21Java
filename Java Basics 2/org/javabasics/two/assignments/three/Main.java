package org.javabasics.two.assignments.three;

import org.javabasics.two.assignments.three.shapes.Circle;
import org.javabasics.two.assignments.three.shapes.Rectangle;
import org.javabasics.two.assignments.three.shapes.Triangle;

public class Main {
    public static void main(final String[] args) {
        final Circle circle = new Circle(6d);
        final Triangle triangle = new Triangle(100d, 100d);
        final Rectangle rectangle = new Rectangle(10d, 10d);

        circle.display();
        triangle.display();
        rectangle.display();
    }
}
