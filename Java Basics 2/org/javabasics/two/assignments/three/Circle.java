package org.javabasics.two.assignments.three;

public class Circle implements Shape {
  private Double radius;

  public Circle(Double radius) {
    this.radius = radius;
  }

  @Override
  public Double calculateArea() {
    return Math.pow(radius, 2) * Math.PI;
  }

  @Override
  public void display() {
    System.out.println("The area of this circle is " + calculateArea());
  }
}
