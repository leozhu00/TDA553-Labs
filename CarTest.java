import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Volvo240 volvo240;
    Saab95 saab95;

    @BeforeEach
    void setUp() {
        volvo240 = new Volvo240();
        saab95 = new Saab95();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
        assertEquals(4, volvo240.getNrDoors());
        assertEquals(2, saab95.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(100, volvo240.getEnginePower());
        assertEquals(120, saab95.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, volvo240.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(Color.RED, saab95.getColor());
    }

    @Test
    void setColor() {
        volvo240.setColor(Color.RED);
        saab95.setColor(Color.BLACK);
        assertEquals(Color.RED, volvo240.getColor());
        assertEquals(Color.BLACK, saab95.getColor());
    }

    @Test
    void startEngine() {
        volvo240.startEngine();
        saab95.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed());
        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        volvo240.stopEngine();
        saab95.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        assertEquals(1.2, saab95.speedFactor());
        assertEquals(1.25, volvo240.speedFactor());
    }

    @Test
    void incrementSpeed() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.incrementSpeed(0.5);
        saab95.incrementSpeed(0.5);
        assertEquals(0.725, volvo240.getCurrentSpeed());
        assertEquals(0.7, saab95.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.decrementSpeed(0.5);
        saab95.decrementSpeed(0.5);
        assertEquals(0, volvo240.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void gas() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.gas(0.5);
        saab95.gas(0.5);
        assertEquals(0.725, volvo240.getCurrentSpeed());
        assertEquals(0.7, saab95.getCurrentSpeed());
    }

    @Test
    void brake() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.brake(0.5);
        saab95.brake(0.5);
        assertEquals(0, volvo240.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void getPosition() {
        assertEquals(new Point(0, 0), volvo240.getPosition());
        assertEquals(new Point(0, 0), saab95.getPosition());
    }

    @Test
    void move() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.move();
        saab95.move();
        assertEquals(0.1, volvo240.getXPosition());
        assertEquals(0, volvo240.getYPosition());
        assertEquals(0.1, saab95.getXPosition());
        assertEquals(0, saab95.getYPosition());
    }

    @Test
    void turnLeft() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.turnLeft();
        saab95.turnLeft();
        assertEquals(Math.PI / 4, volvo240.getDirection());
        assertEquals(Math.PI / 4, saab95.getDirection());
    }

    @Test
    void turnRight() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.turnRight();
        saab95.turnRight();
        assertEquals(-Math.PI / 4, volvo240.getDirection());
        assertEquals(-Math.PI / 4, saab95.getDirection());
    }

    @Test
    void SanityCheckGas() {
        for (int i = 0; i < 1000; i++) {
            volvo240.gas(0.5);
            saab95.gas(0.5);
        }
        assertTrue(volvo240.getCurrentSpeed() <= volvo240.getEnginePower());
        assertTrue(saab95.getCurrentSpeed() <= saab95.getEnginePower());
    }

    @Test
    void SanityCheckBrake() {
        for (int i = 0; i < 1000; i++) {
            volvo240.brake(0.5);
            saab95.brake(0.5);
        }
        assertEquals(0, volvo240.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }



    @Test
    void SanityCheckSpeedChangeDecrease() {
        volvo240.startEngine();
        saab95.startEngine();
        for (int i = 0; i < 1000; i++) {
            volvo240.gas(0.5);
            saab95.gas(0.5);
        double oldSpeedVolvo = volvo240.getCurrentSpeed();
        double oldSpeedSaab = saab95.getCurrentSpeed();
        volvo240.brake(0.5);
        saab95.brake(0.5);
        assertTrue(volvo240.getCurrentSpeed() < oldSpeedVolvo);
        assertTrue(saab95.getCurrentSpeed() < oldSpeedSaab);
        }
    }

    @Test
    void SanityCheckSpeedChaneIncrease(){
        volvo240.startEngine();
        saab95.startEngine();
        for (int i = 0; i < 1000; i++) {
            volvo240.gas(0.5);
            saab95.gas(0.5);
        double oldSpeedVolvo = volvo240.getCurrentSpeed();
        double oldSpeedSaab = saab95.getCurrentSpeed();
        volvo240.gas(0.5);
        saab95.gas(0.5);
        assertTrue(volvo240.getCurrentSpeed() >= oldSpeedVolvo);
        assertTrue(saab95.getCurrentSpeed() >= oldSpeedSaab);
        }


    }
}