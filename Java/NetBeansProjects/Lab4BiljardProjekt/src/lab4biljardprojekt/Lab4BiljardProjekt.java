/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4biljardprojekt;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Joachim Parrow 2010 rev 2011, 2012, 2013, 2015, 2016
 *
 * Simulator for two balls
 */


public class Lab4BiljardProjekt {

    final static int UPDATE_FREQUENCY = 100;    // GlobalÂ constant: fps, ie times per second to simulate

    public static void main(String[] args) {

        JFrame frame = new JFrame("No collisions!");          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        ScoreBoard scoreBoard = new ScoreBoard();

        Table table = new Table(scoreBoard); 
        
        frame.add(scoreBoard, BorderLayout.NORTH);
        frame.add(table, BorderLayout.CENTER);  
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
class ScoreBoard extends JPanel{
    //Table myTable;   
    int score1;
    int score2;
    String scorePlayer1;
    String scorePlayer2; 
    boolean player1Turn;
    
    int BOARD_WIDTH = 320;
    
    ScoreBoard() {
        //myTable = mt;
        
        //BOARD_WIDTH = myTable.getWallWidth();
        
        setPreferredSize(new Dimension(BOARD_WIDTH, 80));
        
        player1Turn = true;
        
        score1 = 0;
        score2 = 0;
        
        scorePlayer1 = "Player 1 score: " + score1;
        scorePlayer2 = "Player 2 score: " + score2;
    }
    
    void addPlayer1Score() {
        score1++;
        scorePlayer1 = "Player 1 score: " + score1;
        //System.out.print("scored1");
        repaint();
    }
    
    void addPlayer2Score() {
        score2++;
        scorePlayer2 = "Player 2 score: " + score2;
        //System.out.print("scored2");
        repaint();
    }
    
    void resetScore() {
        score1 = 0;
        score2 = 0;
        scorePlayer1 = "Player 1 score: " + score1;
        scorePlayer2 = "Player 2 score: " + score2;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {       
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setColor(Color.BLACK);
        g2D.drawString(scorePlayer1, BOARD_WIDTH/2 -20,50);
        g2D.drawString(scorePlayer2, BOARD_WIDTH/2 -20,70);
    }
}

class Table extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    final double RADIUS_BALL           = 15;
    final double DIAMETER_BALL         = 2 * RADIUS_BALL;
    final double RADIUS_HOLE           = 20;
    final double DIAMETER_HOLE         = RADIUS_HOLE * 2;
    private final int   WALL_THICKNESS = 20;
    private final int   TABLE_WIDTH    = 300;
    private final int   TABLE_HEIGHT   = 500;
    private final double   TABLE_WIDTH_AND_WALL = TABLE_WIDTH + WALL_THICKNESS;
    private final double   TABLE_HEIGHT_AND_WALL = TABLE_HEIGHT + WALL_THICKNESS;
    private final int   TOTAL_AMOUNT_BALLS = 16;
    private final int   AMOUNT_NON_CUE_BALLS = 15;
    private final int   AMOUNT_HOLES = 6;
    private final Color COLOR          = Color.green;
    private final Color WALL_COLOR     = Color.gray;
    
    int player1Score;
    int player2Score;
    
    CueBall cueBall;
    
    Ball[] ballArray = new Ball[TOTAL_AMOUNT_BALLS]; 
    Coord[] arrayInitialPositionsBall = new Coord[AMOUNT_NON_CUE_BALLS]; //gör en array av var alla bollar ska ligga
    
    Hole[] holeArray = new Hole[AMOUNT_HOLES];
    Coord[] arrayHolePositions = new Coord[AMOUNT_HOLES];
    
    private final Timer simulationTimer;
    private boolean programRunning;
    
    JButton button;
    
    ScoreBoard myScoreBoard;
    
    Table(ScoreBoard sb) {
        
        setPreferredSize(new Dimension(TABLE_WIDTH + 2 * WALL_THICKNESS,
                                       TABLE_HEIGHT + 2 * WALL_THICKNESS));
        
        myScoreBoard = sb;
        
        player1Score = 0;
        player2Score = 0;
        
        createArrayInitialPositionBall();
        createInitialBalls();
        createCueBall();
        
        createArrayHolePositions();
        createHoles();
                
        addMouseListener(this);
        addMouseMotionListener(this);
        
        button= new JButton("Restart game");
        button.addActionListener(this);
        this.add(button);

        simulationTimer = new Timer((int) (1000.0 / Lab4BiljardProjekt.UPDATE_FREQUENCY), this);
    }
    
    private void createArrayInitialPositionBall() {

        double deltaY = Math.sqrt(Math.pow(DIAMETER_BALL,2) - Math.pow(RADIUS_BALL,2));
        //Första raden
        Coord startPosition = new Coord(TABLE_WIDTH/2+25,350);
        arrayInitialPositionsBall[0] = startPosition;
        
        //Andra raden
        Coord startPosition1 = new Coord(startPosition.x - RADIUS_BALL, startPosition.y + deltaY);
        arrayInitialPositionsBall[1] = startPosition1;        
        Coord startPosition2 = new Coord(startPosition1.x + DIAMETER_BALL, startPosition1.y);
        arrayInitialPositionsBall[2] = startPosition2;
        
        //Tredje raden
        Coord startPosition3 = new Coord(startPosition2.x + RADIUS_BALL, startPosition2.y + deltaY);
        arrayInitialPositionsBall[3] = startPosition3;        
        Coord startPosition4 = new Coord(startPosition3.x - DIAMETER_BALL, startPosition3.y);
        arrayInitialPositionsBall[4] = startPosition4;
        Coord startPosition5 = new Coord(startPosition4.x - DIAMETER_BALL, startPosition4.y);
        arrayInitialPositionsBall[5] = startPosition5;

        
        //Fjärde raden
        Coord startPosition6 = new Coord(startPosition5.x - RADIUS_BALL, startPosition5.y + deltaY);
        arrayInitialPositionsBall[6] = startPosition6;        
        Coord startPosition7 = new Coord(startPosition6.x + DIAMETER_BALL, startPosition6.y);
        arrayInitialPositionsBall[7] = startPosition7;        
        Coord startPosition8 = new Coord(startPosition7.x + DIAMETER_BALL, startPosition7.y);
        arrayInitialPositionsBall[8] = startPosition8;        
        Coord startPosition9 = new Coord(startPosition8.x + DIAMETER_BALL, startPosition8.y);
        arrayInitialPositionsBall[9] = startPosition9;
        
        
        //Femte raden
        Coord startPosition10 = new Coord(startPosition9.x + RADIUS_BALL, startPosition9.y + deltaY);
        arrayInitialPositionsBall[10] = startPosition10;
        Coord startPosition11 = new Coord(startPosition10.x - DIAMETER_BALL, startPosition10.y);
        arrayInitialPositionsBall[11] = startPosition11;
        Coord startPosition12 = new Coord(startPosition11.x - DIAMETER_BALL, startPosition11.y);
        arrayInitialPositionsBall[12] = startPosition12;
        Coord startPosition13 = new Coord(startPosition12.x - DIAMETER_BALL, startPosition12.y);
        arrayInitialPositionsBall[13] = startPosition13;
        Coord startPosition14 = new Coord(startPosition13.x - DIAMETER_BALL, startPosition13.y);
        arrayInitialPositionsBall[14] = startPosition14;
    }
    
    private void createCueBall(){
        boolean stripedBall = false;
        Coord cueBallInitialPosition = new Coord(TABLE_WIDTH/2+25,150);
        cueBall = new CueBall(cueBallInitialPosition, this, stripedBall, myScoreBoard);
        ballArray[15]=cueBall;
    }

    private void createInitialBalls(){
        boolean stripedBall;
        for (int i = 0; i<AMOUNT_NON_CUE_BALLS; i++) {
            if (i<8){
                stripedBall = false;
            }
            else{
                stripedBall = true;
            }
            Coord initialPosition = arrayInitialPositionsBall[i];
            Ball ball = new Ball(initialPosition,this, stripedBall, myScoreBoard);
            ballArray[i] = ball;
        }
    }
       
    void createArrayHolePositions(){
        Coord topLeftHole = new Coord(WALL_THICKNESS,WALL_THICKNESS);
        arrayHolePositions[0] = topLeftHole;
        Coord topRightHole = new Coord(TABLE_WIDTH_AND_WALL,WALL_THICKNESS);
        arrayHolePositions[1] = topRightHole;
        Coord midRightHole = new Coord(TABLE_WIDTH_AND_WALL,TABLE_HEIGHT_AND_WALL/2);
        arrayHolePositions[2] = midRightHole;
        Coord bottomRightHole = new Coord(TABLE_WIDTH_AND_WALL,TABLE_HEIGHT_AND_WALL);
        arrayHolePositions[3] = bottomRightHole;
        Coord bottomLeftHole = new Coord(WALL_THICKNESS,TABLE_HEIGHT_AND_WALL);
        arrayHolePositions[4] = bottomLeftHole;
        Coord midLeftHole = new Coord(WALL_THICKNESS,TABLE_HEIGHT_AND_WALL/2);
        arrayHolePositions[5] = midLeftHole;                
    }
    
    void createHoles(){
        for (int i = 0; i<AMOUNT_HOLES; i++){
            Hole hole = new Hole(arrayHolePositions[i], this);
            holeArray[i] = hole;
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
    
    Hole[] getHoleArray(){
        return holeArray;
    }
    
    void restartGame() {
        createArrayInitialPositionBall();
        createInitialBalls();
        createCueBall();
        myScoreBoard.resetScore();
        repaint();
        }
    
    int countNotMovingBalls() {
        int counterNotMovingBall = 0;
        for (Ball ball : ballArray) {
            if (!ball.isMoving()) {                 //FEL!
                counterNotMovingBall++;  
            } 
        }
        return counterNotMovingBall;
    }
    
    boolean checkMousePressedNotBallOrHole(Coord mousePosition) {
        for (Ball ball:ballArray){
            if (Coord.distance(mousePosition, ball.position) <= DIAMETER_BALL) {
                return false;
            } 
        }
        for (Hole hole:holeArray){
            if (Coord.distance(mousePosition, hole.position) <= DIAMETER_HOLE) {
                return false;
            } 
        }
        return true;
    }
        
    public void actionPerformed(ActionEvent e) {          // Timer event
        for (Ball ball:ballArray){
            ball.move(ballArray);
        }
        repaint();
        
        if (countNotMovingBalls() == TOTAL_AMOUNT_BALLS){
            simulationTimer.stop();
            programRunning = false;
        }
        
        if (e.getSource() == button){
            restartGame();
        }
    }

    public void mousePressed(MouseEvent event) {
        Coord mousePosition = new Coord(event);
        if (!programRunning){
            cueBall.setAimPosition(mousePosition);
        }
        
        if (!programRunning && cueBall.isDead && checkMousePressedNotBallOrHole(mousePosition)) {
            cueBall.setCueBallPosition(mousePosition); 
            cueBall.isDead = false;
        }
        repaint(); 
    }

    public void mouseReleased(MouseEvent e) {
        cueBall.shoot();
        if (!simulationTimer.isRunning()) {
            simulationTimer.start();
            programRunning = true;
        }
    }

    public void mouseDragged(MouseEvent event) {
        Coord mousePosition = new Coord(event);
        cueBall.updateAimPosition(mousePosition);
        repaint();
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

        for (Ball ball:ballArray) {
            ball.paint(g2D);
        }
        
        for (Hole hole:holeArray){
            hole.paint(g2D);
        }
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
    ScoreBoard myScoreBoard;
    
    final int    BORDER_THICKNESS    = 2;
    final int    STRIPED_BORDER      = 6;
    final double RADIUS              = 15;
    final double DIAMETER            = 2 * RADIUS;
    final double FRICTION            = 0.015;                          // its friction constant (normed for 100 updates/second)
    final double FRICTION_PER_UPDATE =                                 // friction applied each simulation step
                          1.0 - Math.pow(1.0 - FRICTION,                       // don't ask - I no longer remember how I got to this
                                         100.0 / Lab4BiljardProjekt.UPDATE_FREQUENCY);           
    Coord position;
    Coord velocity;
    boolean isDead;
    boolean isStriped;


    Ball(Coord initialPosition, Table mt, boolean stripedBall, ScoreBoard sb) {
        myScoreBoard = sb;
        myTable = mt;
        position = initialPosition;
        velocity = new Coord(0,0);
        isDead = false;
        isStriped = stripedBall;
    }                               
    
    
    boolean isMoving() {    // if moving too slow I am deemed to have stopped
        return velocity.magnitude() > FRICTION_PER_UPDATE;
    }
    
    void move(Ball[] ballArray) {
        for (Ball ball : ballArray){
            if (checkBallCollision(ball) && checkTrajectoryOfBalls(ball)){
                collisionEffect(ball);
            }
            if (checkHitHole()){
                killBall();
            }
        }

        changeDirectionWall();

        if (isMoving()) {                                   
            position.increase(velocity);      
            velocity.decrease(Coord.mul(FRICTION_PER_UPDATE, velocity.norm()));
        }                                          
    }
    
    void killBall() {
        isDead = true;
        velocity = Coord.ZERO;
        position.x = myTable.getWallWidth() + 100;
        position.y = myTable.getWallHeight() + 100;
        if (isStriped && this != myTable.cueBall){
            myScoreBoard.addPlayer1Score();
            //System.out.println(myTable.player1Score);
        }
        if (!isStriped && this != myTable.cueBall){
            myScoreBoard.addPlayer2Score();
            //System.out.println(myTable.player2Score);
        }
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
        }
    
    boolean checkHitHole(){
        Hole[] arrayOfHoles = myTable.getHoleArray();
        for (Hole hole:arrayOfHoles){
            if (Coord.distance(this.position, hole.position) <= RADIUS)
                return true;
        }
        return false;
    }
    
    // paint: to draw the ball, first draw a black ball
    // and then a smaller ball of proper color inside
    // this gives a nice thick border
    void paint(Graphics2D g2D) {
        if (!isStriped) {
            paintSolidBall(g2D);
        }
        else {
            paintStripedBall(g2D);
        }
    }
    
    void paintSolidBall(Graphics2D g2D){
        g2D.setColor(Color.black);
        g2D.fillOval(
                (int) (position.x - RADIUS + 0.5),
                (int) (position.y - RADIUS + 0.5),
                (int) DIAMETER,
                (int) DIAMETER);
        g2D.setColor(Color.blue);
        g2D.fillOval(                    
                (int) (position.x - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (position.y - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS));
    }
    
    void paintStripedBall (Graphics2D g2D){
        g2D.setColor(Color.black);
        g2D.fillOval(
                (int) (position.x - RADIUS + 0.5),
                (int) (position.y - RADIUS + 0.5),
                (int) DIAMETER,
                (int) DIAMETER);
        g2D.setColor(Color.red);
        g2D.fillOval(                    
                (int) (position.x - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (position.y - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS));
        g2D.setColor(Color.white);
        g2D.fillOval(                    
                (int) (position.x - RADIUS + 0.5 + STRIPED_BORDER),
                (int) (position.y - RADIUS + 0.5 + STRIPED_BORDER),
                (int) (DIAMETER - 2 * STRIPED_BORDER),
                (int) (DIAMETER - 2 * STRIPED_BORDER));    
    }
} // end  class Ball  

class CueBall extends Ball {
    
    Coord aimPosition;
    
    CueBall(Coord cueBallInitialPosition, Table mt, boolean stripedBall, ScoreBoard sb) {
        super(cueBallInitialPosition, mt, stripedBall, sb);
        myScoreBoard = sb;
        myTable = mt;
        position = cueBallInitialPosition;
        velocity = Coord.ZERO;
        isStriped = stripedBall;
    }
    
    void setCueBallPosition(Coord mousePosition){
        position = mousePosition;
    }
    
    void setAimPosition(Coord grabPosition) {
        if (Coord.distance(position, grabPosition) <= RADIUS) {
            aimPosition = grabPosition;
        }
    }
    
    void updateAimPosition(Coord newPosition) {
        if (isAiming()){
            aimPosition = newPosition;
        }
    }

    void shoot() {
        if (isAiming()) {
            Coord aimingVector = Coord.sub(position, aimPosition);
            velocity = Coord.mul(Math.sqrt(10.0 * aimingVector.magnitude() / Lab4BiljardProjekt.UPDATE_FREQUENCY),
                                 aimingVector.norm());  // don't ask - determined by experimentation
            aimPosition = null;
        }
    }
    
    boolean isAiming() {
        return aimPosition != null;
    }
    
    @Override                                       //Fixa så att man inte måste kopiera
    public void paint(Graphics2D g2D) {
        if (isAiming()) {
            paintAimingLine(g2D);
        }
        g2D.setColor(Color.black);
        g2D.fillOval(
                (int) (position.x - RADIUS + 0.5),
                (int) (position.y - RADIUS + 0.5),
                (int) DIAMETER,
                (int) DIAMETER);
        g2D.setColor(Color.WHITE);
        g2D.fillOval(
                (int) (position.x - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (position.y - RADIUS + 0.5 + BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS),
                (int) (DIAMETER - 2 * BORDER_THICKNESS));
     
    }
    
    void paintAimingLine(Graphics2D graph2D) {
            Coord.paintLine(
                    graph2D,
                    aimPosition, 
                    Coord.sub(Coord.mul(2, position), aimPosition)
                           );
    }
}

class Hole {
    
    final double RADIUS     = 20;
    final double DIAMETER   = 2 * RADIUS;
    final int AMOUNT_HOLES  = 6;
        
    Coord position;
    Table myTable;
    
    Hole(Coord initialPosition, Table mt) {
        myTable = mt;
        position = initialPosition;
    }
    
    public void paint(Graphics2D g2D) {
        g2D.setColor(Color.black);
        g2D.fillOval(
                (int) (position.x - RADIUS),
                (int) (position.y - RADIUS),
                (int) DIAMETER,
                (int) DIAMETER);  
    }
}