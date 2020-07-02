public class BallTest {
    public static void main(String args[]) {
        // Assigning Ball class reference to Football object. 
        Ball ball = new Football();
        ball.ballColor();
        //ball.ballWeight();

        // Assigning Ball class reference to BowlingBall object.
        ball = new BowlingBall();
        ball.ballVolume();
        //ball.ballSpeed();

        ball.moveBall();

        // Assigning Ball class reference to Ball object.
        ball = new Ball();
        ball.ballVolume();
        ball.ballColor();
    }
}