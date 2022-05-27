package com.devhouseagency.robotworld;

import com.devhouseagency.robotworld.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    void testPositionGetX() {
        Position position = new Position(1, 5);
        assertEquals(1, position.getX());
    }

    @Test
    void testPositionGetY() {
        Position position = new Position(1, 5);
        assertEquals(5, position.getY());
    }

    @Test
    void testEquals() {
        Position pos1 = new Position(1, 5);
        Position pos2 = new Position(1, 5);
        assertTrue(pos1.equals(pos2));
    }

    @Test
    void isInsideBounds() {
        Position topLeft = new Position(-50, 50);
        Position bottomRight = new Position(50, -50);

        Position pos1 = new Position(35, -35);
        assertTrue(pos1.isIn(topLeft, bottomRight));

        Position pos2 = new Position(-100, 45);
        assertFalse(pos2.isIn(topLeft, bottomRight));
    }
}
