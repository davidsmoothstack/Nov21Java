package org.javabasics.two.assignments.three.shapes;

public class Rectangle implements Shape {

  private double length;
  private double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public Double calculateArea() {
    return length * width;
  }

  @Override
  public void display() {
    System.out.println("The width of this rectangle is " + calculateArea());
  }

}
