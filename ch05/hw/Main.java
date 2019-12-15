package ch05.hw;

import ch05.hw.framework.*;

import ch05.hw.idcard.*;

// ������ : Thread Ŭ������ ��ӹ޾Ƽ�, Main Ŭ���� �ڽ��� �����尡 �ȴ�.
public class Main extends Thread {

	public static void main(String[] args) {
		
		// ������ : IDCardFactorySeoul�� getInstance()�� �ι� ȣ��
		// ������ : factory1�� factory2�� ����Ű���� �Ѵ�.
		// ������ : �� �� ������ ������ ��ü�� ����Ű���� �׽�Ʈ�Ѵ�.
		// ������ : ��� �޼���: "factory1�� factory2�� ���� �ν��Ͻ� �Դϴ�."
		Factory factory1 = IDCardFactorySeoul.getInstance();
		Factory factory2 = IDCardFactorySeoul.getInstance();
		
		if(factory1 == factory2){
			System.out.println("factory01�� factory02�� ���� �ν��Ͻ� �Դϴ�.");
		}
		else
			System.out.println("factory01�� factory02�� �ٸ� �ν��Ͻ� �Դϴ�.");

		// ������ : Main�� ��ü 3�� ����, (�̸���, "�ֽ���","�ڱ��̸�1","�ڱ��̸�2")
		// ������ : ������ start�޼ҵ带 ȣ��
		// ������ : run�޼ҵ� - IDCardFactoryBusan �ν��Ͻ� ��� �ڽ��� �̸� getName()�̿��Ͽ� ��� �ּҿ� ���
		
		// ������ : ������ 3���� ������ �� �����Ų��.
		new Main("�ֽ���").start(); // ������ : run( ) �� �ڵ����� ����ȴ�.
		new Main("������").start();
		new Main("������2").start();
		
	}
	public void run(){
		IDCardFactoryBusan obj = IDCardFactoryBusan.getInstance();
		// ������ : ������ ��ü�� �ּҰ��� �����Ѵ�.
		System.out.println(getName() + ": obj = " + obj);
		// ������ : Main�� ���� ���ڸ� ����.
	}
	public Main(String name){
		super(name);//���ھ��� �����ڸ� ���� �θ���.
	}

}
