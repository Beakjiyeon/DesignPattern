package ch17.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameObserver extends Frame implements Observer, ActionListener {
	private GraphText textGraph = new GraphText(60);
	// 백지연 : GraphText와 동일한 형태의  text field를 만들기
	private GraphNamePrint textGraph2=new GraphNamePrint(60);

	private GraphCanvas canvasGraph = new GraphCanvas();

	private Button buttonClose = new Button("Close");

	public FrameObserver() {
		super("FrameObserver");
		// BorderLayout는 GUI 컴포넌트를 동서남북,중앙 중 하나에 배치한다.
		setLayout(new BorderLayout());

		setBackground(Color.lightGray);
		textGraph.setEditable(false);
		canvasGraph.setSize(500, 500);

		// 백지연 : textGraph2를 textGraph 아래에 위치 시키기 위해 패널을 사용
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(textGraph);
		p.add(textGraph2);
		
		// 각 GUI 컴포넌트를 북, 중앙, 남에 단다.
		// 백지연 : 판넬을 프레임의 북쪽에 붙임.
		add(p,BorderLayout.NORTH);
		add(canvasGraph, BorderLayout.CENTER);
		add(buttonClose, BorderLayout.SOUTH);
		// Close 버튼이 눌려질 때의 ActionListener를 등록한다.
		buttonClose.addActionListener(this);
		
		pack(); // 프레임 크기를 조절한다.
		show(); // 화면에 보인다.
	}

	// Close 버튼이 눌려질 때 호출된다.
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		System.exit(0);
	}

	public void update(NumberGenerator generator) {
		textGraph.update(generator);
		textGraph2.update(generator);
		canvasGraph.update(generator);
	}
}

class GraphText extends TextField implements Observer {
	public GraphText(int columns) {
		super(columns);
	}

	public void update(NumberGenerator generator) {
		int number = generator.getNumber();
		String text = number + ":";
		for (int i = 0; i < number; i++) {
			text += '*';
		}
		setText(text); // 텍스트 필드에 text를 출력한다.
	}
}
class GraphNamePrint extends TextField implements Observer{
	
	// 백지연 : 텍스트 필드 생성자super로 호출
	public GraphNamePrint(int columns) {
		// TODO Auto-generated constructor stub
		super(columns);
	}
	String text;
	
	// 백지연 : 텍스트 필드에 나온 수만큼 이름 출력
	@Override
	public void update(NumberGenerator generator) {
		int num=generator.getNumber();
		text=num+": ";
		for(int i=0;i<num;i++)
			text+="백지연 ";
		setText(text);
	}
	
	

}
// Canvas: 그림 그릴 수 있는 빈 사각형을 나타내는 클래스
class GraphCanvas extends Canvas implements Observer {
	private int number;

	public void update(NumberGenerator generator) {
		number = generator.getNumber();
		repaint();  // paint() 메소드를 자동으로 호출한다.

	}

	// Graphics: 그림 그리기 위한 여러 가지 메소드와 
	// 그리기 관련 정보(색깔, 폰트 등)를 가지고 있는 클래스
	// paint() 메소드는 Graphics 객체를 인자로 전달받는다.
	public void paint(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		// 현재 색을 흰색으로 설정한다.
		g.setColor(Color.white);
		// 0도에서 360까지 원호를 그린다.
		g.fillArc(0, 0, width, height, 0, 360);
        // 현재 색을 빨간색으로 설정한다.
		g.setColor(Color.red);
		// 90도에서 시계방향으로 원호를 그린다.
		g.fillArc(0, 0, width, height, 90, -number * 360 / 50);
	}
}
