package power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    @Test
    void calculateWinRate() {
        Statistic stat = new Statistic();
        stat.wins = 3;
        stat.sessionsCount = 6;
        assertEquals(0.5f,stat.calculateWinRate());
    }

    @Test
    void testToString() {
        Statistic stat = new Statistic();
        assertEquals("sessions : 0    wins : 0   losses : 0\n highest score : 0  highest tile : 0  win rate : 0.0%",stat.toString());
    }
}