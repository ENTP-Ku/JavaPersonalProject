package PersonalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Ground {
    private int groundY; // 바닥의 Y 좌표 (경계면의 높이)
    private int width; // 바닥의 너비
    private int height; // 바닥의 두께
    private int hatchOffset; // 빗금의 X 좌표 오프셋
    private int obstacleSpeed; // 장애물 속도

    /**
     * Ground 객체의 생성자
     * @param groundY 바닥의 Y 좌표 (경계면의 높이)
     * @param width 바닥의 너비
     * @param height 바닥의 두께
     * @param initialSpeed 초기 장애물 속도
     */
    public Ground(int groundY, int width, int height, int initialSpeed) {
        this.groundY = groundY; // 바닥의 Y 좌표
        this.width = width; // 바닥의 너비
        this.height = height; // 바닥의 두께
        this.hatchOffset = 0; // 빗금의 X 좌표 오프셋 초기화
        this.obstacleSpeed = initialSpeed; // 장애물 속도 설정
    }

    /**
     * 바닥을 업데이트합니다. (빗금의 위치를 장애물 속도에 맞게 이동)
     */
    public void update() {
        hatchOffset -= obstacleSpeed; // 빗금의 X 좌표 오프셋을 장애물 속도만큼 감소

        // 빗금 위치가 화면을 벗어나면 다시 시작 위치로 이동
        if (hatchOffset <= -300) { // 빗금의 간격만큼 벗어났을 때 초기화
            hatchOffset = 0;
        }
    }

    /**
     * 바닥을 그립니다.
     * @param g 그래픽 객체
     */
    public void draw(Graphics g) {
        // 바닥에 경계면 그리기
        g.setColor(Color.BLACK); // 경계면 색상 설정
        int boundaryY = groundY; // 바닥의 경계면 Y 좌표
        g.drawLine(0, boundaryY, width, boundaryY); // 바닥 경계선을 그리기

        // 바닥에 빗금 그리기
        int hatchSpacing = 300; // 빗금 사이의 간격
        g.setColor(Color.GRAY); // 빗금 색상 설정

        // 빗금이 바닥으로부터 50픽셀 아래에 위치하도록 조정
        int hatchY = boundaryY + 25; 

        for (int x = hatchOffset; x < width + hatchSpacing; x += hatchSpacing) {
            g.drawLine(x, hatchY - height / 2, x - hatchSpacing / 2, hatchY + height / 2); // 빗금 그리기
        }
    }

    /**
     * 장애물 속도를 설정합니다.
     * @param speed 새로운 장애물 속도
     */
    public void setObstacleSpeed(int speed) {
        this.obstacleSpeed = speed;
    }
}
