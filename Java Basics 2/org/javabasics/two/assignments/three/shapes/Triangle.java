package org.javabasics.two.assignments.three.shapes;

public class Triangle implements Shape {
    private final Double base;
    private final Double height;

    public Triangle(final Double base, final Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double calculateArea() {
        return this.base * this.height / 2;
    }

    @Override
    public void display() {
        System.out.println("The area of this triangle is " + this.calculateArea());
    }
}
