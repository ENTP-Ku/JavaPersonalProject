package PersonalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 플레이어 캐릭터를 나타내는 클래스입니다.
 */
public class Player {
    private int x, y;
    private boolean isJumping = false;
    private int jumpSpeed = 20;
    private int gravity = 2;
    private final int groundY = 450;
    private final int width = 50;
    private final int height = 50;
    private BufferedImage playerImage; // 플레이어 이미지를 저장할 변수
    private AudioPlayer audioPlayer; // AudioPlayer 인스턴스 추가


    // 애니메이션 관련 변수
    private double currentRotation = 0.0;
    private double targetRotation = 0.0;
    private final double rotationSpeed=150; //회전량


    private Timer rotationTimer;
    private boolean isRotating = false;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        loadImage(); // 이미지 로드
        audioPlayer = new AudioPlayer(); // AudioPlayer 초기화


        // 타이머 설정: 16ms마다 호출 (약 60 FPS)
        rotationTimer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRotation();
            }
        });
    }

    /**
     * 이미지 파일을 로드합니다.
     */
    private void loadImage() {
        try {
            // 이미지 파일 경로를 지정
            playerImage = ImageIO.read(getClass().getResource("/aaa.PNG"));
        } catch (IOException e) {
            e.printStackTrace(); // 이미지 로드 실패 시 예외 처리
        }
    }
    
    

    /**
     * 플레이어의 상태를 업데이트합니다.
     */
    public void update() {
        if (isJumping) {
            y -= jumpSpeed;
            jumpSpeed -= gravity;
            if (y >= groundY) {
                y = groundY;
                isJumping = false;
                jumpSpeed = 20;
                if (isRotating) {
                    // 회전 애니메이션을 완료하고, 원래 상태로 복원
                    currentRotation = 0.0;
                    targetRotation = 0.0;
                    isRotating = false;
                    rotationTimer.stop();
                }
            } else {
                if (!isRotating) {
                    startRotationAnimation();
                }
            }
        }
    }

    /**
     * 점프를 시작합니다.
     */
    public void jump() {
        if (!isJumping) {
            isJumping = true;
            // 점프 소리 재생
            audioPlayer.playOnce("jump.wav");
        }
    }

    
    

    /**
     * 회전 애니메이션을 시작합니다.
     */
    private void startRotationAnimation() {
        // 회전 애니메이션 초기화
        currentRotation = 0.0;
        targetRotation = 90.0; // 회전 목표 각도 설정
        isRotating = true;
        rotationTimer.start();
    }

    /**
     * 회전 각도를 업데이트합니다.
     */
    private void updateRotation() {
        if (isRotating) {
            double angleDifference = targetRotation - currentRotation;
            if (Math.abs(angleDifference) <= rotationSpeed / 16 ) { // 
                currentRotation = targetRotation; // 목표 각도 도달
                isRotating = false;
                rotationTimer.stop();
            } else {
                currentRotation += rotationSpeed / 16.0 * Math.signum(angleDifference); // 회전 업데이트
            }
        }
    }

    /**
     * 플레이어를 그립니다.
     * @param g 그래픽 객체
     */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        // 회전을 위한 변환 행렬 생성
        AffineTransform originalTransform = g2d.getTransform();
        
        // 회전 적용
        g2d.rotate(Math.toRadians(currentRotation), x + width / 2, y + height / 2);
        g2d.drawImage(playerImage, x, y, width, height, null);

        // 원래의 변환 행렬로 복원
        g2d.setTransform(originalTransform);
    }

    /**
     * 플레이어의 경계 사각형을 반환합니다.
     * @return 플레이어의 경계 사각형
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
