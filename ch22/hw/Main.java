package ch22.hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ch22.hw.command.*;
import ch22.hw.drawer.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener {
	// �׸��� �̷�
    private MacroCommand history = new MacroCommand();
    //  �׸��� ����
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // ���� ��ư
    private JButton clearButton  = new JButton("clear");
    // undo ��ư                                  
    private JButton undoButton  = new JButton("undo");  
    // ������ : redo ��ư 
    private JButton redoButton = new JButton("redo");
    // ���� ��ư                                           
    private JButton redButton  = new JButton("red");        
    // ��� ��ư                                           
    private JButton greenButton  = new JButton("green");    
    // �Ķ� ��ư                                          
    private JButton blueButton  = new JButton("blue");  
    // ������ : ���� ���� ��� ��� ���� ���
    // ������ : ������ ���� : ä���� ��, �� ��, ä���� �簢��, ä���� �ﰢ��
    // ������ : ��� ��ư
    private JButton circleBtn = new JButton("��");
    // ������ : ä���� �� ��ư
    private JButton fillCircleBtn = new JButton("��");
    // ������ : ä���� �簢�� ��ư
    private JButton rectBtn = new JButton("��");
    // ������ : ä���� �ﰢ�� ��ư
    private JButton triBtn = new JButton("��");
    
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
        
        // ������ : ȭ�� ���� gui
        // ������ : 1�� 
        // ������ : ù��° ��ư �ڽ�-������, ����ư,undo,redo
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        buttonBox.add(redoButton);
        
        // ������ : 2�� : �ι�° ��ư �ڽ�-������ư
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
		new Main("20171078 ������");
	}

	public void actionPerformed(ActionEvent e) {
		// ������ : clear ��ư�� ������ �� �ʱ�ȭ ������ �ʿ�
		if(e.getSource() == clearButton){
			 history.clear(); 
			 canvas.init();
	         canvas.repaint();
	         // ������ : ������ �׸��� ColorCommand ��ü�� �ϳ� �����ؼ� �����丮�� �߰��Ѵ�.
	         Command cmd = new ColorCommand(canvas,Color.RED);
	     	 history.append(cmd);
	     	 cmd.execute();
	     	
	     	 cmd = new ShapeCommand(canvas,"fillCircleBtn");
	     	 history.append(cmd);
	     	 cmd.execute();
		}else if(e.getSource() ==undoButton){
			// ������ : ������ ��ư�� undo ��ư�̸� history�� undo()�� ȣ�� �� ȭ�鿡 �ٽñ׸���.
			history.undo();                             
            canvas.repaint(); 
		}else if(e.getSource() ==redoButton){//�ǵ����� ��ư
			// ������ : ������ ��ư�� redo ��ư�̸� history�� redo()�� ȣ�� �� ȭ�鿡 �ٽñ׸���.
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
			Command cmd = new ShapeCommand(canvas,"circleBtn");//ShapeCommand Ŭ������ ��ư ���� �Է��Ѵ�.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==fillCircleBtn){
			Command cmd = new ShapeCommand(canvas,"fillCircleBtn");//ShapeCommand Ŭ������ ��ư ���� �Է��Ѵ�.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==rectBtn){
			Command cmd = new ShapeCommand(canvas,"rectBtn");//ShapeCommand Ŭ������ ��ư ���� �Է��Ѵ�.
			history.append(cmd);  
			cmd.execute();
		}else if(e.getSource() ==triBtn){
			Command cmd = new ShapeCommand(canvas,"triBtn");//ShapeCommand Ŭ������ ��ư ���� �Է��Ѵ�.
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
