package study.lang.operator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class T1 {
  public static void main(String[] args) {
    // 운세 메시지를 배열로 정의
    String[] fortunes = {"오늘은 아주 좋은 하루가 될 것입니다!", "조심하세요, 오늘은 약간의 어려움이 있을 수 있습니다.",
        "기대하지 않았던 좋은 소식을 들을 것입니다.", "오늘은 새로운 도전에 적합한 날입니다.", "누군가가 당신에게 감사하는 말을 전할 것입니다.",
        "오늘은 평소와 다르게 조용한 하루를 보내게 될 것입니다.", "즐거운 일이 많이 생길 것입니다.", "주의하세요, 실수를 하지 않도록 주의가 필요합니다.",
        "오늘은 운이 아주 좋습니다.", "새로운 사람을 만나게 될 것입니다."};

    // JFrame 생성
    JFrame frame = new JFrame("운세 보기");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLayout(new BorderLayout());

    // JLabel 생성 및 추가
    JLabel questionLabel = new JLabel("운세를 보시겠습니까?", SwingConstants.CENTER);
    frame.add(questionLabel, BorderLayout.NORTH);

    // 패널 생성
    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.CENTER);

    // JButton 생성
    JButton yesButton = new JButton("네");
    JButton noButton = new JButton("아니요");

    // 버튼을 패널에 추가
    panel.add(yesButton);
    panel.add(noButton);

    // 랜덤 객체 생성
    Random random = new Random();

    // 버튼 클릭 이벤트 처리
    yesButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int index = random.nextInt(fortunes.length);
        JOptionPane.showMessageDialog(frame, "오늘의 운세: " + fortunes[index]);
      }
    });

    noButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "운세를 보지 않으셨습니다. 좋은 하루 되세요!");
      }
    });

    // JFrame을 화면에 표시
    frame.setVisible(true);
  }
}
