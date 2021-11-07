package org.javabasics.two.assignments.three.shapes;

public class Circle implements Shape {
    private final Double radius;

    public Circle(final Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public void display() {
        System.out.println("The area of this circle is " + this.calculateArea());
    }
}
