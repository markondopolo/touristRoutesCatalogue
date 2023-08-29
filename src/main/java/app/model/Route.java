package app.model;

public class Route {
    private String routeDescription;
    private int price;
    private double grade;

    public Route() {}

    public Route(String routeDescription, int price, double grade) {
        this.routeDescription = routeDescription;
        this.price = price;
        this.grade = grade;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public int getPrice() {
        return price;
    }

    public double getGrade() {
        return grade;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
