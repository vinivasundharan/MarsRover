/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import marsrovertest.Move;
import marsrovertest.Plateau;
import marsrovertest.Rover;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vini
 */
public class TestCases {
    
    Plateau plateau;
    Rover rover;
    Move move;
    public TestCases() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        plateau =new Plateau();
        rover=new Rover();
        move=new Move();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRoverInitialization()
    {
        rover.setRover("1 2 N");
        assertEquals(1,rover.getRoverXCoordinate());
        assertEquals(2,rover.getRoverYCoordinate());
        assertEquals("N",rover.getRoverDirection());
    }
    
    @Test
    public void testPlateauInitialization()
    {
        plateau.setPlateau("5 5");
        assertEquals(5,plateau.getPlateauXCoordinate());
        assertEquals(5, plateau.getPlateauYCoordinate());
    }
    
    @Test
    public void testRoverWithinBound()
    {
        rover.setRover("5 5 N");
        rover=rover.getRover();
        plateau.setPlateau("4 6");
        assertFalse(rover.checkBoundary(plateau));
    }
    
    @Test
    public void testMoveRight()
    {
        rover.setRover("1 2 N");
        plateau.setPlateau("5 5");
        rover= move.moveRight(rover);
        assertEquals(1, rover.getRoverXCoordinate());
        assertEquals(2, rover.getRoverYCoordinate());
        assertEquals("E", rover.getRoverDirection());
    }
    
    @Test
    public void testMoveLeft()
    {
        rover.setRover("1 2 N");
        rover=move.moveLeft(rover);
        assertEquals(1, rover.getRoverXCoordinate());
        assertEquals(2, rover.getRoverYCoordinate());
        assertEquals("W", rover.getRoverDirection());
    }
    
    @Test
    public void testMoveForward()
    {
        rover.setRover("1 2 N");
        rover=move.moveForward(rover);
        assertEquals(1, rover.getRoverXCoordinate());
        assertEquals(3, rover.getRoverYCoordinate());
        assertEquals("N", rover.getRoverDirection());
    }
    
    @Test
    //Test given input and output
    public void testInputPattern1()
    {
        rover.setRover("1 2 N");
        plateau.setPlateau("5 5");
        move.setMove("LMLMLMLMM", rover, plateau);
        assertEquals(1, rover.getRoverXCoordinate());
        assertEquals(3, rover.getRoverYCoordinate());
        assertEquals("N", rover.getRoverDirection());
    }
    
    @Test
    //Test given input and output
    public void testInputPattern2()
    {
        rover.setRover("3 3 E");
        plateau.setPlateau("5 5");
        move.setMove("MMRMMRMRRM", rover, plateau);
        assertEquals(5, rover.getRoverXCoordinate());
        assertEquals(1, rover.getRoverYCoordinate());
        assertEquals("E", rover.getRoverDirection());
    }
    
    @Test
    //Test rover moving out of the bounds
    public void testInputPattern3()
    {
        rover.setRover("3 3 E");
        plateau.setPlateau("5 5");
        move.setMove("MMMMMMM", rover, plateau);
        assertEquals(3, rover.getRoverXCoordinate());
        assertEquals(3, rover.getRoverYCoordinate());
        assertEquals("E", rover.getRoverDirection());
    }
}
