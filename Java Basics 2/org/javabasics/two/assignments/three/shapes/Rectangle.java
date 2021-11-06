package org.javabasics.two.assignments.three.shapes;

public class Rectangle implements Shape {

    private final double length;
    private final double width;

    public Rectangle(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Double calculateArea() {
        return this.length * this.width;
    }

    @Override
    public void display() {
        System.out.println("The width of this rectangle is " + this.calculateArea());
    }

}
