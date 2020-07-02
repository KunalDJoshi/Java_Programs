public class Ball {
    double diameter = 4;
    double volume;
    double radius;

    public void moveBall() {
        System.out.println("Running the Ball class move method moveBall.");

    }

    public void ballVolume() {
        radius = (diameter / 2);
        volume = (3.14) * (radius) * (radius) * (radius) * 4 / 3;
        System.out.println("volume of ball is: " + volume + "cubic inches");

    }

    public void ballColor() {
        System.out.println("Color of ball is blue");
    }

}