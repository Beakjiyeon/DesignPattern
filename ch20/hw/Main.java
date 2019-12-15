package ch20.hw;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class BigCharGui extends JFrame{
	// 백지연 : 텍스트필드 생성. 전역변수로 생성하여 리스너클래스에서 접근 가능하도록 했다.
	JTextField tf,tf2,tf3;
	Container c;
	JTextArea ta1,ta2;
	JScrollPane sc1,sc2;
	JButton b1,b2;
	public BigCharGui() {
		// 백지연 : 프레임의 타이틀을 학번 이름으로 함
		setTitle("20171078 백지연");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		// 백지연 : 텍스트 필드 생성함. 사용자로부터 문자열을 입력받음
		tf=new JTextField(10);
		// 백지연 : 레이아웃을 위해 판넬 생성
		JPanel pn=new JPanel();
		// 백지연 : 버튼 두개 생성함
		b1=new JButton("공유해서 큰 문자 생성");
		b2=new JButton("공유하지 않고 큰 문자 생성");
		// 백지연 : 텍스트 필드 생성함. 메모리 사용량을 나타냄
		tf2=new JTextField(10); // 백지연 : 공유한 케이스
		tf3=new JTextField(10); // 백지연 : 공유하지 않은 케이스
		
		ta1=new JTextArea(30,50); // 백지연 : 공유한 케이스에서 큰 문자를 띄움
		ta2=new JTextArea(30,50); // 백지연 : 공유하지 않은 케이스에서 큰 문자를 띄움
		// 백지연 : 스크롤바 붙이기
		sc1=new JScrollPane(ta1);
		sc2=new JScrollPane(ta2);
		c.add(tf,BorderLayout.NORTH);
		
		pn.setLayout(null);
		pn.add(b1);
		pn.add(b2);
		pn.add(tf2);
		pn.add(tf3);
		pn.add(sc1);
		pn.add(sc2);
		
		tf.setSize(200,30);
		tf.setLocation(150,30);
		pn.setSize(500,500);
		pn.setLocation(20,80);
		b1.setSize(200,20);
		b1.setLocation(30,50);
		b2.setSize(200,20);
		b2.setLocation(250,50);
		tf2.setSize(200,20);
		tf3.setSize(200,20);
		tf2.setLocation(30,80);
		tf3.setLocation(250,80);
		sc1.setSize(180,300);
		sc1.setLocation(30,150);
		sc2.setSize(180,300);
		sc2.setLocation(250,150);
		c.add(pn);
		
		// 백지연 : 버튼에 리스너 달기
		b1.addMouseListener(new Mouse());
		b2.addMouseListener(new Mouse());
		setSize(570,800);
		setVisible(true);
	}
	class Mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			
			String text=tf.getText();
			if(((JButton)e.getSource())==b1) {
				// 백지연 : 버튼을 누르면 이전 내용들이 사라짐. 큰문자들이 사라짐
				ta1.setText("");
				// 백지연 : 같은 폭의 글씨체로 설정하기
				ta1.setFont(new Font("굴림체",0,10));
				// 백지연 : 팩토리 생성
				BigCharFactory factory=BigCharFactory.getInstance();
				/*
				// ? 텍스트필드에 입력한 문자열로 BigString 객체를 생성
				BigString bs=new BigString(text);
				sc1.setToolTipText(bs.print());
				*/
				// 백지연 : 문자 하나씩 팩토리를 통해 가져온다.
				BigChar[] bc=new BigChar[text.length()];
				for(int i=0;i<bc.length;i++) {
					bc[i]=factory.getBigChar(text.charAt(i));
					// 백지연 : 큰 문자 버전 출력
					ta1.append(bc[i].print());
				}
				// 백지연 : 메모리 사용량
				Runtime.getRuntime().gc();
				long used=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
				tf2.setText("메모리사용량 :"+used);
			}
			if(((JButton)e.getSource()).getText().equals("공유하지 않고 큰 문자 생성")) {
				// 백지연 : 백지연 : 버튼을 누르면 이전 내용들이 사라짐. 큰문자들이 사라짐
				ta2.setText("");
				// 백지연 : 같은 폭의 글씨체로 설정하기
				ta2.setFont(new Font("굴림체",0,10));
				// 백지연 : 팩토리 생성안함
				// BigCharFactory factory=BigCharFactory.getInstance();
				
				// 백지연 : 모든 문자에 대해 큰 문자 객체가 생성됨.
				BigChar[] bc=new BigChar[text.length()];
				for(int i=0;i<bc.length;i++) {
					bc[i]=new BigChar(text.charAt(i));
					// 백지연 : 큰 문자 버전 출력
					ta2.append(bc[i].print());
				}
				// 백지연 : 메모리 사용량
				Runtime.getRuntime().gc();
				long used=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
				tf3.setText("메모리사용량 :"+used);
			}
			
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// 백지연 : 메인메소드에서 BigCharGui 객체를 생성한다.
		new BigCharGui();
		/*
		// BigChar 메소드
		BigChar bc01=new BigChar('1');
		BigChar bc02=new BigChar('1');
		BigChar bc03=new BigChar('1');
		// 백지연 : 1에 해당하는 걸 읽어서 fontdata에 넣음
		// 백지연 : new가 3번. 똑같은 내용인데 메모리가 3개든다. => 공장 사용하자!
		
		bc01.print();
		bc02.print();
		bc03.print();
		// 백지연 : .txt 파일이 있어야 한다.
		*/
		
		// BigCharFactory 테스트
		/*
		BigCharFactory bcf=new BigCharFactory();
		다음과 같이 하면 오류가 난다. 싱글턴 패턴을 공장에 적용했기 때문에 main에서는 new할 수 없다.
		*/
		BigCharFactory bcf=BigCharFactory.getInstance();
		BigChar bc01=bcf.getBigChar('1');
		BigChar bc02=bcf.getBigChar('1');
		BigChar bc03=bcf.getBigChar('1');
		
		System.out.println(bc01);
		System.out.println(bc02);
		System.out.println(bc03);
		// 백지연 : 주소가 모두 같음.. 그림은???
		
		// 백지연 ; String을 주면,
		if(args.length!=1) {
			System.out.println("명령행 인자 1개가 필요합니다.");
			System.exit(0);
		}
		//BigString bs=new BigString("12123");
		BigString bs=new BigString(args[0]);
		
		}

}
