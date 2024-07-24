package PersonalProject;

import javax.swing.*;

/**
 * 게임을 시작하는 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Dino Game"); // 게임 창을 위한 프레임 생성
        GamePanel gamePanel = new GamePanel(); // 게임 패널 생성
        frame.add(gamePanel); // 프레임에 게임 패널 추가
        frame.setSize(1200, 600); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        frame.setVisible(true); // 프레임을 화면에 표시
    }
}
