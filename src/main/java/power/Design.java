package power;

import java.awt.*;

/**
 * Colors for tiles
 * @author Egor
 */
public enum Design {
    E_0     (0,    0xcdc0b4, 0x776e65),
    E_2     (2,    0x776E65, 0xEEE4DA),
    E_4     (4,    0x776E65, 0xEDE0C8),
    E_8     (8,    0xF9F6F2, 0xF2B179),
    E_16    (16,   0xF9F6F2, 0xF59563),
    E_32    (32,   0xF9F6F2, 0xF67C5F),
    E_64    (64,   0xF9F6F2, 0xF65E3B),
    E_128   (128,  0xF9F6F2, 0xEDCF72),
    E_256   (256,  0xF9F6F2, 0xEDCC61),
    E_512   (512,  0xF9F6F2, 0xEDC850),
    E_1024  (1024, 0xF9F6F2, 0xEDC53F),
    E_2048  (2048, 0xF9F6F2, 0xEDC22E),
    E_4096  (4096, 0xF9F6F2, 0x0FAB87),
    E_8192  (8192, 0xF9F6F2, 0x4334A7);
    private final int value;
    private final Color color;
    private final Color fontColor;



    Design(int n, int f, int c) {
        value = n;
        color = new Color(c);
        fontColor = new Color(f);
    }

    /**
     * @param num value of tile
     * @return font and background color of tile by its value
     */
    static Design of(int num) {
        return Design.valueOf("E_" + num);
    }

    public Color fontColor() {
        return fontColor;
    }

    public Color color() {
        return color;
    }

    public int value() {
        return value;
    }
}
