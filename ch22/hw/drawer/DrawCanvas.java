package ch22.hw.drawer;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ch22.hw.command.MacroCommand;
import ch22.hw.command.ShapeCommand;

public class DrawCanvas extends Canvas implements Drawable {
    // 그림 그리는 색
    private Color color = Color.red;
    // 그림 그리기를 할 점의 변경
    private int radius = 6;
    // 이력
    private MacroCommand history;
    // 선모양
    // 백지연 : 선 모양 변경 기능을 위한 수정
    // 백지연 : 현재 모양을 보관하는 속성 추가
    private String currentShape = "fillCircleBtn";//눌러진 모양 저장하는 곳
    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }
    // 이력 전체를 다시 그리기
    public void paint(Graphics g) {
        history.execute();
    }
    
    public void setShape(String shape){
    	this.currentShape=shape;
    }
    // 그리기
    // 백지연 : draw메소드 수정
    // 백지연 : 현재 모양 값을 가지는 currentShape 속성을 이용하여
    // 백지연 : Graphics 객체의 해당 메소드를 호출해서 그림을 그린다. 
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        
        if(currentShape.equals("circleBtn")){
        	// 백지연 : 빈 원버튼이 선택된다면,
        	g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("fillCircleBtn")){
        	// 백지연 : 채워진 원 버튼이 선택된다면,
        	g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("rectBtn")){
        	// 백지연 : 채워진 사각형 버튼이 선택된다면,
        	g.fillRect(x - radius, y - radius, radius * 2, radius * 2);
        }else if(currentShape.equals("triBtn")){
        	// 백지연, 채워진 삼각형 버튼이 선택된다면,
        	// 백지연 : 빈 Polygon 객체 생성
        	Polygon p=new Polygon();
        	// 백지연 : 이 객체의 addPoint(int x,int y) 호출해서 꼭지점 추가
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

	//초기화
	public void init() {
		color = Color.red;                  
        radius = 6;
	}
}
