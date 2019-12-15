package ch01.hw;

public class BookShelfIteratorBackward implements Iterator{
	private BookShelf bookShelf;
	private int index;
	public BookShelfIteratorBackward(BookShelf bookShelf) {//�ڽ��� ������ å����(����)�� ����
	       this.bookShelf = bookShelf;
	       this.index = bookShelf.getLength() - 1;  // å���̸� ���ƴٴϱ� ���̹Ƿ�,  �� ������ ���� �ʱ�ȭ�Ѵ�.
	   }
	@Override
	//�ֽ���: ���Ұ� �� �ִ��� �˻��ϴ� �޼ҵ�
	public boolean hasNext() {
		if(index>=0){
			return true;
		} else{
			return false;
		}
	}

	@Override
	//�ֽ���: ���� ���Ҹ� �������� �������� �޼ҵ�.
	public Object next() {
		// TODO Auto-generated method stub
		Book book = bookShelf.getBookAt(index);
		index--;
		return book;
	}

}
