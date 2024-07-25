package PersonalProject;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 새로운 장애물 클래스입니다.
 */
public class NewObstacle extends AbstractObstacle {
    public NewObstacle(int startX, int startY, int initialSpeed) {
        super(startX, startY, initialSpeed);
    }

    @Override
    public void update() {
        x -= speed;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}
