package ch22.hw.drawer;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ch22.hw.command.MacroCommand;
import ch22.hw.command.ShapeCommand;

public class DrawCanvas extends Canvas implements Drawable {
    // �׸� �׸��� ��
    private Color color = Color.red;
    // �׸� �׸��⸦ �� ���� ����
    private int radius = 6;
    // �̷�
    private MacroCommand history;
    // �����
    // ������ : �� ��� ���� ����� ���� ����
    // ������ : ���� ����� �����ϴ� �Ӽ� �߰�
    private String currentShape = "fillCircleBtn";//������ ��� �����ϴ� ��
    // ������
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }
    // �̷� ��ü�� �ٽ� �׸���
    public void paint(Graphics g) {
        history.execute();
    }
    
    public void setShape(String shape){
    	this.currentShape=shape;
    }
    // �׸���
    // ������ : draw�޼ҵ� ����
    // ������ : ���� ��� ���� ������ currentShape �Ӽ��� �̿��Ͽ�
    // ������ : Graphics ��ü�� �ش� �޼ҵ带 ȣ���ؼ� �׸��� �׸���. 
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        
        if(currentShape.equals("circleBtn")){
        	// ������ : �� ����ư�� ���õȴٸ�,
        	g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("fillCircleBtn")){
        	// ������ : ä���� �� ��ư�� ���õȴٸ�,
        	g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("rectBtn")){
        	// ������ : ä���� �簢�� ��ư�� ���õȴٸ�,
        	g.fillRect(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("triBtn")){
        	// ������, ä���� �ﰢ�� ��ư�� ���õȴٸ�,
        	// ������ : �� Polygon ��ü ����
        	Polygon p=new Polygon();
        	// ������ : �� ��ü�� addPoint(int x,int y) ȣ���ؼ� ������ �߰�
        	p.addPoint(x, y-radius);
        	p.addPoint(x-radius, y+radius);
        	p.addPoint(x+radius, y+radius);
        	g.fillPolygon(p);
        }
        
        
    }
    
	public void setColor(Color color) {
		Graphics g = getGraphics();
		this.color=color;
		g.setColor(color);
	}

	//�ʱ�ȭ
	public void init() {
		color = Color.red;                  
        radius = 6;
	}
}
