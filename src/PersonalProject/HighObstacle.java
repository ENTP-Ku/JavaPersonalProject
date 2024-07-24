package PersonalProject;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 높은 장애물 클래스입니다.
 */
public class HighObstacle extends AbstractObstacle {
    public HighObstacle(int startX, int startY, int initialSpeed) {
        super(startX, startY, initialSpeed);
    }

    @Override
    public void update() {
        x -= speed;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
