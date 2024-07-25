package qwerqwerqwer;

import java.awt.*;

// 총알을 관리하는 클래스
public class Bullet {
    private Rectangle rectangle; // 총알의 위치와 크기를 정의하는 Rectangle 객체
    private final int speed = 5;  // 총알의 이동 속도

    // 생성자: 총알의 초기 위치를 설정합니다.
    public Bullet(int x, int y) {
        rectangle = new Rectangle(x, y, 10, 20); // 총알의 크기를 10x20으로 설정
    }

    // 총알의 Rectangle 객체를 반환합니다.
    public Rectangle getRectangle() {
        return rectangle;
    }

    // 총알을 아래로 이동시킵니다.
    public void move() {
        rectangle.y += speed;
    }

    // 총알이 화면 밖으로 나갔는지 확인합니다.
    public boolean isOffScreen(int height) {
        return rectangle.y > height;
    }

    // 총알을 그립니다.
    public void draw(Graphics g) {
        g.setColor(Color.RED); // 총알 색상을 빨간색으로 설정
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height); // 총알을 사각형으로 그립니다.
    }
}
