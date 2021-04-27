package edu.bzu.assignment2.pojo;

public class Car {
  private  String model;
   private String color;

    public Car( String model,String color) {
        model=this.model;
        color=this.color;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
