package PersonalProject;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 표준 장애물 클래스입니다.
 */
public class StandardObstacle extends AbstractObstacle {
    public StandardObstacle(int startX, int startY, int initialSpeed) {
        super(startX, startY, initialSpeed);
    }

    @Override
    public void update() {
        x -= speed;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}
