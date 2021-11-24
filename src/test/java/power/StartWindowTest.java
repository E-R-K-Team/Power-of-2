package power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartWindowTest {

    @Test
    public void creationTest(){
        StartWindow window = new StartWindow();
        assertEquals(true,window.getLogo().isVisible());
    }

}