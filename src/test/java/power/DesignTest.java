package power;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DesignTest {

    @Test
    void of() {
        Color expectedF = Design.E_2.fontColor();  ;
        Color expectedC = Design.E_2.color();

        Design design = Design.of(2);

        assertEquals(expectedF,design.fontColor());
        assertEquals(expectedC,design.color());
    }
}