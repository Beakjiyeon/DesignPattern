package ch20.hw;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class BigCharGui extends JFrame{
	// ������ : �ؽ�Ʈ�ʵ� ����. ���������� �����Ͽ� ������Ŭ�������� ���� �����ϵ��� �ߴ�.
	JTextField tf,tf2,tf3;
	Container c;
	JTextArea ta1,ta2;
	JScrollPane sc1,sc2;
	JButton b1,b2;
	public BigCharGui() {
		// ������ : �������� Ÿ��Ʋ�� �й� �̸����� ��
		setTitle("20171078 ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		// ������ : �ؽ�Ʈ �ʵ� ������. ����ڷκ��� ���ڿ��� �Է¹���
		tf=new JTextField(10);
		// ������ : ���̾ƿ��� ���� �ǳ� ����
		JPanel pn=new JPanel();
		// ������ : ��ư �ΰ� ������
		b1=new JButton("�����ؼ� ū ���� ����");
		b2=new JButton("�������� �ʰ� ū ���� ����");
		// ������ : �ؽ�Ʈ �ʵ� ������. �޸� ��뷮�� ��Ÿ��
		tf2=new JTextField(10); // ������ : ������ ���̽�
		tf3=new JTextField(10); // ������ : �������� ���� ���̽�
		
		ta1=new JTextArea(30,50); // ������ : ������ ���̽����� ū ���ڸ� ���
		ta2=new JTextArea(30,50); // ������ : �������� ���� ���̽����� ū ���ڸ� ���
		// ������ : ��ũ�ѹ� ���̱�
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
		
		// ������ : ��ư�� ������ �ޱ�
		b1.addMouseListener(new Mouse());
		b2.addMouseListener(new Mouse());
		setSize(570,800);
		setVisible(true);
	}
	class Mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			
			String text=tf.getText();
			if(((JButton)e.getSource())==b1) {
				// ������ : ��ư�� ������ ���� ������� �����. ū���ڵ��� �����
				ta1.setText("");
				// ������ : ���� ���� �۾�ü�� �����ϱ�
				ta1.setFont(new Font("����ü",0,10));
				// ������ : ���丮 ����
				BigCharFactory factory=BigCharFactory.getInstance();
				/*
				// ? �ؽ�Ʈ�ʵ忡 �Է��� ���ڿ��� BigString ��ü�� ����
				BigString bs=new BigString(text);
				sc1.setToolTipText(bs.print());
				*/
				// ������ : ���� �ϳ��� ���丮�� ���� �����´�.
				BigChar[] bc=new BigChar[text.length()];
				for(int i=0;i<bc.length;i++) {
					bc[i]=factory.getBigChar(text.charAt(i));
					// ������ : ū ���� ���� ���
					ta1.append(bc[i].print());
				}
				// ������ : �޸� ��뷮
				Runtime.getRuntime().gc();
				long used=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
				tf2.setText("�޸𸮻�뷮 :"+used);
			}
			if(((JButton)e.getSource()).getText().equals("�������� �ʰ� ū ���� ����")) {
				// ������ : ������ : ��ư�� ������ ���� ������� �����. ū���ڵ��� �����
				ta2.setText("");
				// ������ : ���� ���� �۾�ü�� �����ϱ�
				ta2.setFont(new Font("����ü",0,10));
				// ������ : ���丮 ��������
				// BigCharFactory factory=BigCharFactory.getInstance();
				
				// ������ : ��� ���ڿ� ���� ū ���� ��ü�� ������.
				BigChar[] bc=new BigChar[text.length()];
				for(int i=0;i<bc.length;i++) {
					bc[i]=new BigChar(text.charAt(i));
					// ������ : ū ���� ���� ���
					ta2.append(bc[i].print());
				}
				// ������ : �޸� ��뷮
				Runtime.getRuntime().gc();
				long used=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
				tf3.setText("�޸𸮻�뷮 :"+used);
			}
			
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// ������ : ���θ޼ҵ忡�� BigCharGui ��ü�� �����Ѵ�.
		new BigCharGui();
		/*
		// BigChar �޼ҵ�
		BigChar bc01=new BigChar('1');
		BigChar bc02=new BigChar('1');
		BigChar bc03=new BigChar('1');
		// ������ : 1�� �ش��ϴ� �� �о fontdata�� ����
		// ������ : new�� 3��. �Ȱ��� �����ε� �޸𸮰� 3�����. => ���� �������!
		
		bc01.print();
		bc02.print();
		bc03.print();
		// ������ : .txt ������ �־�� �Ѵ�.
		*/
		
		// BigCharFactory �׽�Ʈ
		/*
		BigCharFactory bcf=new BigCharFactory();
		������ ���� �ϸ� ������ ����. �̱��� ������ ���忡 �����߱� ������ main������ new�� �� ����.
		*/
		BigCharFactory bcf=BigCharFactory.getInstance();
		BigChar bc01=bcf.getBigChar('1');
		BigChar bc02=bcf.getBigChar('1');
		BigChar bc03=bcf.getBigChar('1');
		
		System.out.println(bc01);
		System.out.println(bc02);
		System.out.println(bc03);
		// ������ : �ּҰ� ��� ����.. �׸���???
		
		// ������ ; String�� �ָ�,
		if(args.length!=1) {
			System.out.println("����� ���� 1���� �ʿ��մϴ�.");
			System.exit(0);
		}
		//BigString bs=new BigString("12123");
		BigString bs=new BigString(args[0]);
		
		}

}
