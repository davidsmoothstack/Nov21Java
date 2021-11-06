package org.javabasics.two.assignments.three;

import org.javabasics.two.assignments.three.shapes.Circle;
import org.javabasics.two.assignments.three.shapes.Rectangle;
import org.javabasics.two.assignments.three.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        var circle = new Circle(6d);
        var triangle = new Triangle(100d, 100d);
        var rectangle = new Rectangle(10d, 10d);

        circle.display();
        triangle.display();
        rectangle.display();
    }
}
