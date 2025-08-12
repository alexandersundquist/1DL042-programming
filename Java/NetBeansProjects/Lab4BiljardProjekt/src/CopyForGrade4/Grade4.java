/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CopyForGrade4;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.floor;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author alexs
 */
public class Grade4 {
    
final static int UPDATE_FREQUENCY = 100;    // GlobalÂ constant: fps, ie times per second to simulate

    public static void main(String[] args) {

        JFrame frame = new JFrame("No collisions!");          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table table = new Table();     
        
        //JPanel buttonPanel = new JPanel();
        //JButton button= new JButton("Start/Stop");
        //table.add(button);

        //frame.setLayout(new BorderLayout());
        frame.add(table);
        //frame.add(button);
        
        frame.pack();
        frame.setVisible(true);
        
        
    }
}

/**
 * *****************************************************************************************
 * Coord
 *
 * A coordinate is a pair (x,y) of doubles. Also used to represent vectors. Here
 * are various utility methods to compute with vectors.
 *
 *
 */
class Coord {

    double x, y;

    Coord(double xCoord, double yCoord) {
        x = xCoord;
        y = yCoord;
    }
    
    Coord(MouseEvent event) {                   // Create a Coord from a mouse event
        x = event.getX();
        y = event.getY();
    }

    static final Coord ZERO = new Coord(0,0);
    
    double magnitude() {                        
        return Math.sqrt(x * x + y * y);
    }

    Coord norm() {                              // norm: a normalised vector at the same direction
        return new Coord(x / magnitude(), y / magnitude());
    }

    void increase(Coord c) {           
        x += c.x;
        y += c.y;
    }
    
    void decrease(Coord c) {
        x -= c.x;
        y -= c.y;
    }
    
    static double scal(Coord a, Coord b) {      // scalar product
        return a.x * b.x + a.y * b.y;
    } 
    
    static Coord sub(Coord a, Coord b) {        
        return new Coord(a.x - b.x, a.y - b.y);
    }

    static Coord mul(double k, Coord c) {       // multiplication by a constant
        return new Coord(k * c.x, k * c.y);
    }

    static double distance(Coord a, Coord b) {
        return Coord.sub(a, b).magnitude();
    }
    
    static void paintLine(Graphics2D graph2D, Coord a, Coord b){  // paint line between points
        graph2D.setColor(Color.black);
        graph2D.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
    }
}

/**
 * ****************************************************************************************
 * Table
 *
 * The table has some constants and instance variables relating to the graphics and
 * the balls. When simulating the balls it starts a timer
 * which fires UPDATE_FREQUENCY times per second. Each time the timer is
 * activated one step of the simulation is performed. The table reacts to
 * events to accomplish repaints and to stop or start the timer.
 *
 */
class Table extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    private final int   TABLE_WIDTH    = 500;
    private final int   TABLE_HEIGHT   = 500;
    private final int   WALL_THICKNESS = 20;
    private final int   AMOUNT_BALLS = 100;
    private final Color COLOR          = Color.green;
    private final Color WALL_COLOR     = Color.black;
    boolean programRunning;
    Timer simulationTimer;
    JButton button;
    int countActionEvent;
    //private       Ball  ball1, ball2;
    //private final Timer simulationTimer;
    Ball[] ballArray = new Ball[AMOUNT_BALLS]; 
    
    String filler = "";
    

    
    Table() {
        
        
        setPreferredSize(new Dimension(TABLE_WIDTH + 2 * WALL_THICKNESS,
                                       TABLE_HEIGHT + 2 * WALL_THICKNESS));
        createInitialBalls();
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        button= new JButton("Start/Stop");
        button.addActionListener(this);
        this.add(button);
        
        simulationTimer = new Timer ((int) (1000.0 / Grade4.UPDATE_FREQUENCY), this);
        simulationTimer.start();
        programRunning = true;
        //simulationTimer = new Timer((int) (1000.0 / Grade4.UPDATE_FREQUENCY), this);
        
        countActionEvent = 0;
        
    }

    private void createInitialBalls(){
        //final Coord firstInitialPosition = new Coord(100, 100);
        //final Coord secondInitialPosition = new Coord(200, 200);
        
        for (int i = 0; i<AMOUNT_BALLS; i++) {
            double randomBallCoordX = ((Math.random()*TABLE_WIDTH)/2)+WALL_THICKNESS;
            double randomBallCoordY = (Math.random()*TABLE_HEIGHT)+WALL_THICKNESS;
            Coord initialPosition = new Coord(randomBallCoordX, randomBallCoordY);
            double initialVelocityX = (Math.random()*2)-1;
            double initialVelocityY = (Math.random()*2)-1;
            Ball ball = new Ball(initialPosition, initialVelocityX, initialVelocityY, this);
            ballArray[i] = ball;
        }
    }
    
    int getWallWidth() {
        return TABLE_WIDTH + WALL_THICKNESS;
    }
    
    int getWallHeight() {
        return TABLE_HEIGHT + WALL_THICKNESS;
    }
    
    int getWallThickness() {
        return WALL_THICKNESS;
    }
    
    double getActionEvent() {
        return countActionEvent;
    }
    
    int countDead() {
        int counter = 0;
        for (Ball ball:ballArray){
            if (ball.isDead){
                counter++;
            }
        }
        return counter;
    }
        
    public void actionPerformed(ActionEvent e) {          // Timer event
        
        for (Ball ball:ballArray){
            ball.move(ballArray);
        }
        if (e.getSource() == button){
            if (programRunning == false){
            simulationTimer.start();
            programRunning = true;
            filler = "";
        }
        else{
            simulationTimer.stop();
            programRunning = false;
            System.out.println(countDead());
            filler = "Antal döda: " + countDead();
        }
        
        }
        countActionEvent++;
        repaint();
        
        //if (!ball1.isMoving() && !ball2.isMoving()) {
           // simulationTimer.stop();
        //}
    }

    public void mousePressed(MouseEvent event) {
          
        Coord mousePosition = new Coord(event);
        if (programRunning == false){
            for (Ball ball: ballArray) {               //Ska man gå över alla bollar?
                ball.pressedBall(mousePosition);   
            }
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        /*ball1.shoot();
        ball2.shoot();
        if (!simulationTimer.isRunning()) {
            simulationTimer.start();      
        }*/
    }

    public void mouseDragged(MouseEvent event) {
        /*Coord mousePosition = new Coord(event);
        ball1.updateAimPosition(mousePosition);
        ball2.updateAimPosition(mousePosition);
        repaint();*/
    }

    // Obligatory empty listener methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // This makes the graphics smoother
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(WALL_COLOR);
        g2D.fillRect(0, 0, TABLE_WIDTH + 2 * WALL_THICKNESS, TABLE_HEIGHT + 2 * WALL_THICKNESS);

        g2D.setColor(COLOR);
        g2D.fillRect(WALL_THICKNESS, WALL_THICKNESS, TABLE_WIDTH, TABLE_HEIGHT);
        
        g2D.setColor(Color.BLACK);
        g2D.drawString(filler,TABLE_WIDTH/2 -20,50);
        
        for (Ball ball:ballArray) {
            ball.paint(g2D);
        }
        
        
        //ball1.paint(g2D);
        //ball2.paint(g2D);
    }
}  // end class Table

/**
 * ****************************************************************************************
 * Ball:
 *
 * The ball has instance variables relating to its graphics and game state:
 * position, velocity, and the position from which a shot is aimed (if any).
 * 
 */
class Ball {
    
    Table myTable;
    
    private final Color  COLOR_HEALTHY       = Color.WHITE;
    private final Color  COLOR_SICK          = Color.RED;
    private final int    BORDER_THICKNESS    = 2;
    private final double RADIUS              = 5;
    private final double DIAMETER            = 2 * RADIUS;
    private final double FRICTION            = 0.0;                          // its friction constant (normed for 100 updates/second)
    private final double FRICTION_PER_UPDATE =                                 // friction applied each simulation step
                          1.0 - Math.pow(1.0 - FRICTION,                       // don't ask - I no longer remember how I got to this
                                         100.0 / Grade4.UPDATE_FREQUENCY); 
    final double INIT_SICK_PROB = 0.2;
    final double GET_WELL_PROB = 0.2;
    final double DIE_PROB = 0.2;
    final double INFECT_PROB = 0.2;
    final double DISTANCING = 1.0;
    final int DAYS_IMMUNE = 1000;
    final int SICK_TIME = 500;  //5 sekunder
    
    
    boolean isSick;
    boolean isDead;
    private int timesSick;
    Coord position;
    private Coord velocity;
    private Coord aimPosition;              // if aiming for a shot, ow null
   
    Ball(Coord initialPosition, double initialVelocityX, double initialVelocityY, Table mt) {
        myTable = mt;
        position = initialPosition;
        velocity = new Coord(0,0);
        velocity.x =initialVelocityX;      // WARNING! Are initial velocities 
        velocity.y =initialVelocityY;
        timesSick = 0;

        double riskInitialSick = Math.random();
        if (riskInitialSick<INIT_SICK_PROB){
            isSick = true;
        }
        
        isDead = false;
    }                                

    boolean isMoving() {    // if moving too slow I am deemed to have stopped
        return velocity.magnitude() > FRICTION_PER_UPDATE;
    }
    
    void pressedBall (Coord grabPosition) {
        if (Coord.distance(position, grabPosition) <= RADIUS) {
            isSick = true;
        }
    }

    void move(Ball[] ballArray) {
        //checkCollisionWithBall(Ball[] ballArray);
        
        for (Ball ball : ballArray){
            if (checkBallCollision(ball)&& checkTrajectoryOfBalls(ball)){
                collisionEffect(ball);
            }   
        } 
        
        countTimesSick();
        
        ballDieOrGetHealthy();
        
        changeDirectionWall();

        ballMove();                  
    }
    
    void checkCollisionWithBall(Ball[] ballArray) {
        for (Ball ball : ballArray){
            if (checkBallCollision(ball)&& checkTrajectoryOfBalls(ball)){
                collisionEffect(ball);
            }   
        } 
    }
    
    void countTimesSick() {
        if (isSick) {
            timesSick ++;
        }
    }
    
    void ballDieOrGetHealthy() {
        if(timesSick == SICK_TIME) {
            double dieProbability = Math.random();
            if (dieProbability < DIE_PROB){
                killBall();
            }
            else{
                isSick = false;
                timesSick = 0;
            }         
        }
    }
    
    void killBall() {
        isDead = true;
        isSick = false;
        velocity = Coord.ZERO;
        position.x = myTable.getWallWidth() + 100;
        position.y = myTable.getWallHeight() + 100;
    }
    
    void ballMove(){
        position.increase(velocity);
    }
    
    int touchWall() {
        int wallPositionX = myTable.getWallWidth();
        int wallPositionY = myTable.getWallHeight();
        int wallThickness = myTable.getWallThickness();
            if (position.x + RADIUS >= wallPositionX && checkTrajectoryToEastWall() || position.x - RADIUS <= wallThickness && checkTrajectoryToWestWall()) { 
                return 1;
            }
            if (position.y + RADIUS >= wallPositionY && checkTrajectoryToSouthWall()|| position.y - RADIUS <= wallThickness && checkTrajectoryToNorthWall()) {
                return 2;
            }
        return 0;
    }
    
    boolean checkTrajectoryToEastWall() {
        boolean towardsWall = false;
        int wallPositionX = myTable.getWallWidth();

        double currentDistanceToWall = wallPositionX - this.position.x;
        
        Coord followingPosition = this.position;
        followingPosition.increase(velocity);
        
        double followingDistanceToWall = wallPositionX - followingPosition.x; 
        if (followingDistanceToWall < currentDistanceToWall){
            towardsWall = true;
        }
        return towardsWall;
    }
    
    boolean checkTrajectoryToWestWall() {
        boolean towardsWall = false;
        int wallThickness = myTable.getWallThickness();
        
        double currentDistanceToWall = this.position.x - wallThickness;
        
        Coord followingPosition = this.position;
        followingPosition.increase(velocity);
        
        double followingDistanceToWall = followingPosition.x - wallThickness; 
        if (followingDistanceToWall < currentDistanceToWall){
            towardsWall = true;
        }
        return towardsWall;
    }
    
    boolean checkTrajectoryToNorthWall() {
        boolean towardsWall = false;
        int wallThickness = myTable.getWallThickness();
        
        double currentDistanceToWall = this.position.y - wallThickness;
        
        Coord followingPosition = this.position;
        followingPosition.increase(velocity);
        
        double followingDistanceToWall = followingPosition.y - wallThickness; 
        if (followingDistanceToWall < currentDistanceToWall){
            towardsWall = true;
        }
        return towardsWall;
    }
    
    boolean checkTrajectoryToSouthWall() {
        boolean towardsWall = false;
        int wallPositionY = myTable.getWallHeight();
        
        double currentDistanceToWall = wallPositionY - this.position.y;
        
        Coord followingPosition = this.position;
        followingPosition.increase(velocity);
        
        double followingDistanceToWall = wallPositionY - followingPosition.y; 
        if (followingDistanceToWall < currentDistanceToWall){
            towardsWall = true;
        }
        return towardsWall;
    }
    
    void changeDirectionWall() {
        if (touchWall() == 1) {
            velocity.x = -velocity.x;
        }
        if (touchWall() == 2) {
            velocity.y = -velocity.y;
        }
    }
    
    boolean checkBallCollision(Ball ball) {
        boolean collision = false;
        if(ball !=this){
            double deltaX = ball.position.x - this.position.x;
            double deltaY = ball.position.y - this.position.y;
            if (Math.pow(deltaX,2)+Math.pow(deltaY, 2) < Math.pow(DIAMETER,2)) {
                collision = true;
            }
        }
        return collision;
    }
    
    boolean checkTrajectoryOfBalls (Ball ball) {
        boolean towardsEachOther = false;

        double currentDistance = Coord.distance(ball.position,this.position);
             
        Coord followingPositionThis = this.position;
        Coord followingPositionBall = ball.position;
        
        followingPositionThis.increase(this.velocity); 
        followingPositionBall.increase(ball.velocity); 

        double followingDistance = Coord.distance(followingPositionBall,followingPositionThis);        
        if (followingDistance <= currentDistance) {
            towardsEachOther = true; 
        }
        return towardsEachOther;
    }
    
    void collisionEffect(Ball ball) {
        double dx = (this.position.x-ball.position.x)/Math.sqrt((Math.pow(this.position.x-ball.position.x,2)+Math.pow(this.position.y-ball.position.y,2)));
        double dy = (this.position.y-ball.position.y)/Math.sqrt((Math.pow(this.position.x-ball.position.x,2)+Math.pow(this.position.y-ball.position.y,2)));
        double impulsThis = this.velocity.x * dx + this.velocity.y * dy;
        double impulsBall = ball.velocity.x * dx + ball.velocity.y * dy;
        double impuls = impulsBall - impulsThis;
        
        double velocityThisX = this.velocity.x + impuls * dx;
        double velocityThisY = this.velocity.y + impuls * dy;
        double velocityBallX = ball.velocity.x - impuls * dx;
        double velocityBallY = ball.velocity.y - impuls * dy;
        
        this.velocity.x = velocityThisX;
        this.velocity.y = velocityThisY;
        ball.velocity.x = velocityBallX;
        ball.velocity.y = velocityBallY;
        
        double infectProbability = Math.random();
        
        if (this.isSick) {
            if (infectProbability < INFECT_PROB) {
                ball.isSick = true;
                ball.timesSick = 0;
            }    
        }
        if (ball.isSick && this.isSick == false) {
            if (infectProbability < INFECT_PROB) {
                this.isSick = true;
                this.timesSick = 0;
            }
        }
        }
    
    // paint: to draw the ball, first draw a black ball
    // and then a smaller ball of proper color inside
    // this gives a nice thick border
    void paint(Graphics2D g2D) {
        if (isDead == false) {
            g2D.setColor(Color.black);
            g2D.fillOval(
                    (int) (position.x - RADIUS + 0.5),
                    (int) (position.y - RADIUS + 0.5),
                    (int) DIAMETER,
                    (int) DIAMETER);
            if (this.isSick) {
                g2D.setColor(COLOR_SICK);
                g2D.fillOval(
                    (int) (position.x - RADIUS + 0.5 + BORDER_THICKNESS),
                    (int) (position.y - RADIUS + 0.5 + BORDER_THICKNESS),
                    (int) (DIAMETER - 2 * BORDER_THICKNESS),
                    (int) (DIAMETER - 2 * BORDER_THICKNESS));
            }
            else {
                g2D.setColor(COLOR_HEALTHY);
                g2D.fillOval(
                    (int) (position.x - RADIUS + 0.5 + BORDER_THICKNESS),
                    (int) (position.y - RADIUS + 0.5 + BORDER_THICKNESS),
                    (int) (DIAMETER - 2 * BORDER_THICKNESS),
                    (int) (DIAMETER - 2 * BORDER_THICKNESS));
            /*if (isAiming()) {
                paintAimingLine(g2D);
            }*/
            }
    }
    }
    
    
    /*private void paintAimingLine(Graphics2D graph2D) {
            Coord.paintLine(
                    graph2D,
                    aimPosition, 
                    Coord.sub(Coord.mul(2, position), aimPosition)
                           );
    } */
} // end  class Ball  
