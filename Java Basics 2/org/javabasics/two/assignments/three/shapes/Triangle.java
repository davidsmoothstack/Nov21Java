package org.javabasics.two.assignments.three.shapes;

public class Triangle implements Shape {
    private Double base;
    private Double height;

    public Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double calculateArea() {
        return base * height / 2;
    }

    @Override
    public void display() {
        System.out.println("The area of this triangle is " + calculateArea());
    }
}
