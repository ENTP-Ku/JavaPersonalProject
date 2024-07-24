package PersonalProject;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 장애물의 추상 클래스입니다.
 */
public abstract class AbstractObstacle {
    protected int x, y;
    protected int speed;
    protected final int width = 50;
    protected final int height = 50;

    public AbstractObstacle(int startX, int startY, int initialSpeed) {
        this.x = startX;
        this.y = startY;
        this.speed = initialSpeed;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public abstract void update();

    public abstract void paint(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
