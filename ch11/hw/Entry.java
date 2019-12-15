package ch11.hw;

public abstract class Entry {
	public abstract String getName(); // �̸��� ��´�.

	public abstract int getSize(); // ����� ��´�.

	// ������ : �޼ҵ� �߰�. private ���� getter
	public abstract String getDate();
	public abstract String getAuthor();
	// ������ : ������ ������ ��´�.
	public abstract int getCount();
	public Entry add(Entry entry) throws FileTreatmentException {
		// �� Ŭ������ �ٸ� ��Ʈ���� �߰��Ϸ��� �ϸ�, ���ܸ� �߻���Ų��.
		// "�ڽ��� ó������ �ʰ�, �� �޼ҵ带 ȣ���� ��ü�� ���Ľ�Ų��"��� ����Ǿ� ����.
		throw new FileTreatmentException();
	}

	public void printList() { // �϶��� ǥ���Ѵ�.
		printList("");
	}

	protected abstract void printList(String prefix); // prefix�� �տ� �ٿ��� �϶���
														// ǥ���Ѵ�.

	// ������ : ������¥�� ������, ���ϰ������� ��µǰ� �Ѵ�.
	public String toString() { // ���ڿ� ǥ��
		return getName() + " (" + getSize() + ")["+getDate()+"]["+getCount()+"��]["+getAuthor()+"]";
	}
}
