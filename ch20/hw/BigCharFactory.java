package ch20.hw;

import java.util.Hashtable;

// BigChar�� �ν��Ͻ��� �ۼ��ϴ� ����
// ���⼭ �ν��Ͻ��� ������ �����ȴ�.
public class BigCharFactory {
	// �̹� ������� BigChar�� �ν��Ͻ��� ��Ƽ� �����Ѵ�.
	private Hashtable pool = new Hashtable();

	// Singleton ������ �����.
	private static BigCharFactory singleton = new BigCharFactory();

	// �����ڴ� private
	private BigCharFactory() {
	}

	// ������ �ϳ��� �ν��Ͻ��� ��´�.
	public static BigCharFactory getInstance() {
		return singleton;
	}

	// Flyweight ������ �߽��� �Ǵ� �޼ҵ�
	// �μ��� ������ ���ڿ� �����ϴ� BigChar �ν��Ͻ��� �����
	public synchronized BigChar getBigChar(char charname) { // ������ : ���� charname�� 3�̶��
		// ������ : pool�� ���� ���� �˻��� �Ѵ�. pool.getKey()
		BigChar bc = (BigChar) pool.get("" + charname);
		// ������ : char Ÿ���� String���� ��ȯ�ϱ� ���� ""�� ���ߴ�.
		// ������ : getKey�� �׻� ������Ʈ�� ���ϵǹǷ� ����ȯ�� ����� �Ѵ�.
		if (bc == null) { // ������ BigChar �� ���ٸ�...
			bc = new BigChar(charname); // ���⿡�� BigChar�� �ν��Ͻ��� ����
			pool.put("" + charname, bc); // pool�� �߰��Ѵ�.
		}
		// ������ BigChar �� �ִٸ�, �̰��� ��ȯ�Ѵ�.
		return bc;
	}
}









