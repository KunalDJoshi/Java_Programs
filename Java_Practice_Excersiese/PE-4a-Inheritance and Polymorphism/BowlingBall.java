public class BowlingBall extends Ball {
    double diameter = 5;
    double speed = 20;

    public void ballVolume() {
        radius = (diameter / 2);
        System.out.println("radius: " + radius);
        volume = (3.14) * (radius) * (radius) * (radius) * 4 / 3;
        System.out.println("volume of ball is: " + volume + "cubic inches");
    }

    public void ballSpeed() {
        System.out.println("Speed of ball is: " + speed + "mph");
    }
}