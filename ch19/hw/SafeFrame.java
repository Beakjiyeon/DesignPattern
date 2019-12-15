package ch19.hw;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// GUI를 사용해서, 금고경비 시스템을 실현한다.
public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60); // 현재시각 표시

	private TextArea textScreen = new TextArea(10, 60); // 경비센터 출력

	private Button buttonUse = new Button("금고사용"); // 금고사용 버튼

	private Button buttonAlarm = new Button("비상벨"); // 비상벨 버튼

	private Button buttonPhone = new Button("일반 통화"); // 일반 통화 버튼

	// 백지연 : 씨씨티비 버튼 생성
	private Button buttonCCTV = new Button("CCTV"); // CCTV 버튼
	
	private Button buttonExit = new Button("종료"); // 종료 버튼

	// 금고의 현재 상태를 저장하는 변수
	// 백지연 : hour의 초기값은 15이다. 

	private State state = DayState.getInstance(); // '주간'으로 초기화 함

	// 생성자
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray); // 배경색의 설정
		setLayout(new BorderLayout()); // 레이아웃 매니저의 설정

		// textClock을 배치
		add(textClock, BorderLayout.NORTH); // 
		textClock.setEditable(false);

		// textScreen을 배치
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);

		// 패널에 버튼들을 추가함 
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonCCTV);
		panel.add(buttonExit);
		// 백지연 : 씨씨티비 버튼 판넬에 붙이기
		
		// 그 패널을 배치
		add(panel, BorderLayout.SOUTH);
		
		// 표시
		pack();
		show();
		
		// 리스너의 설정
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
		// 백지연 : 씨씨티비 버튼 리스너설정
		buttonCCTV.addActionListener(this);
	}

	// 버튼이 눌러지면 이 메소드가 실행된다. 
	// 눌러진 버튼의 종류에 따라 
	// state.doUse(this) / state.doAlarm(this) / state.doPhone(this)  중 
	// 하나를 호출한다.
    // => 현재 상태가 주간인지 야간이지 체크하는 코드가 필요없다.
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		
		if (e.getSource() == buttonUse) { // 금고사용 버튼이 눌러지면...
			state.doUse(this);
		} else if (e.getSource() == buttonAlarm) { // 비상벨 버튼이 눌러지면...
			state.doAlarm(this);
		} else if (e.getSource() == buttonPhone) { // 일반 통화 버튼이 눌러지면...
			state.doPhone(this);
		} else if (e.getSource() == buttonExit) { // 종료 버튼이 눌러지면...
			System.exit(0);
			
		}// 백지연 : 씨씨티비 버튼이 눌려졌다면,
		else if (e.getSource() == buttonCCTV) { // 종료 버튼이 눌러지면...
			state.doCCTV(this);
			
		}else {
			System.out.println("?");
		}
	}

	// 시간 설정을 위해서 클라이언트(Main)가 호출하는 메소드
	public void setClock(int hour) {
		String clockstring = "현재 시각은";
		
		if (hour < 10) { // 현재 시각이 두 자리수가 아니면...
			clockstring += "0" + hour + ":00";
		} else { // 현재 시각이 두 자리수이면...
			clockstring += hour + ":00";
		}
		
		System.out.println(clockstring); // 화면에 출력
		
		textClock.setText(clockstring); // GUI에 출력
		
		state.doClock(this, hour); // 현재 상태를 나타내는 객체에 현재 시각을 설정한다.
	}

	// 현재의 상태를  변화시킬 때 호출하는 메소드
	public void changeState(State state) {
		System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
		this.state = state;
	}

	// 경비센터에 대한 호출을 표현함
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}

	// 경비센터의 로그에 기록하는 일을 표현함
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}
}
