package ch22.hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ch22.hw.command.*;
import ch22.hw.drawer.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener {
	// 그리기 이력
    private MacroCommand history = new MacroCommand();
    //  그리기 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 제거 버튼
    private JButton clearButton  = new JButton("clear");
    // undo 버튼                                  
    private JButton undoButton  = new JButton("undo");  
    // 백지연 : redo 버튼 
    private JButton redoButton = new JButton("redo");
    // 빨간 버튼                                           
    private JButton redButton  = new JButton("red");        
    // 녹색 버튼                                           
    private JButton greenButton  = new JButton("green");    
    // 파란 버튼                                          
    private JButton blueButton  = new JButton("blue");  
    // 백지연 : 선의 구성 요소 모양 변경 기능
    // 백지연 : 도형의 종류 : 채워진 원, 빈 원, 채워진 사각형, 채워진 삼각형
    // 백지연 : 빈원 버튼
    private JButton circleBtn = new JButton("○");
    // 백지연 : 채워진 원 버튼
    private JButton fillCircleBtn = new JButton("●");
    // 백지연 : 채워진 사각형 버튼
    private JButton rectBtn = new JButton("■");
    // 백지연 : 채워진 삼각형 버튼
    private JButton triBtn = new JButton("▲");
    
    public Main(String title){
    	super(title);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Command cmd = new ColorCommand(canvas,Color.RED);
    	history.append(cmd);
    	
    	cmd = new ShapeCommand(canvas,"fillCircleBtn");
    	history.append(cmd);

    	
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        undoButton.addActionListener(this); 
        redoButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        circleBtn.addActionListener(this);
        fillCircleBtn.addActionListener(this);
        rectBtn.addActionListener(this);
        triBtn.addActionListener(this);
        
        // 백지연 : 화면 구성 gui
        // 백지연 : 1행 
        // 백지연 : 첫번째 버튼 박스-지워기, 색버튼,undo,redo
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        buttonBox.add(redoButton);
        
        // 백지연 : 2행 : 두번째 버튼 박스-도형버튼
        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox2.add(circleBtn);
        buttonBox2.add(fillCircleBtn);
        buttonBox2.add(rectBtn);
        buttonBox2.add(triBtn);
        
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(buttonBox2);
        mainBox.add(canvas);
        getContentPane().add(mainBox);
        
        pack();
        setVisible(true);
    }
	public static void main(String[] args) {
		new Main("20171078 백지연");
	}

	public void actionPerformed(ActionEvent e) {
		// 백지연 : clear 버튼을 눌렀을 때 초기화 과정이 필요
		if(e.getSource() == clearButton){
			 history.clear(); 
			 canvas.init();
	         canvas.repaint();
	         // 백지연 : 빨간색 그리는 ColorCommand 객체를 하나 생성해서 히스토리에 추가한다.
	         Command cmd = new ColorCommand(canvas,Color.RED);
	     	 history.append(cmd);
	     	 cmd.execute();
	     	
	     	 cmd = new ShapeCommand(canvas,"fillCircleBtn");
	     	 history.append(cmd);
	     	 cmd.execute();
		}else if(e.getSource() ==undoButton){
			// 백지연 : 눌려진 버튼이 undo 버튼이면 history의 undo()를 호출 후 화면에 다시그린다.
			history.undo();                             
            canvas.repaint(); 
		}else if(e.getSource() ==redoButton){//되돌리기 버튼
			// 백지연 : 눌려진 버튼이 redo 버튼이면 history의 redo()를 호출 후 화면에 다시그린다.
			history.redo();
			canvas.repaint();
		}else if(e.getSource() ==redButton){
			Command cmd = new ColorCommand(canvas, Color.red);  
            history.append(cmd);
            cmd.execute(); 
		}else if(e.getSource() == greenButton){
			Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);                                
            cmd.execute();  
		}else if(e.getSource() ==blueButton){
			Command cmd = new ColorCommand(canvas, Color.blue); 
            history.append(cmd);                                
            cmd.execute();  
		}
		else if(e.getSource() ==circleBtn){
			Command cmd = new ShapeCommand(canvas,"circleBtn");//ShapeCommand 클래스에 버튼 명을 입력한다.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==fillCircleBtn){
			Command cmd = new ShapeCommand(canvas,"fillCircleBtn");//ShapeCommand 클래스에 버튼 명을 입력한다.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==rectBtn){
			Command cmd = new ShapeCommand(canvas,"rectBtn");//ShapeCommand 클래스에 버튼 명을 입력한다.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==triBtn){
			Command cmd = new ShapeCommand(canvas,"triBtn");//ShapeCommand 클래스에 버튼 명을 입력한다.
			history.append(cmd);  
			cmd.execute();
		}
		
	}
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
	}

	public void mouseMoved(MouseEvent e) {
		
	}

}
