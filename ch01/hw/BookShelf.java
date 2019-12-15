package ch01.hw;
import java.util.Vector;					 
public class BookShelf implements Aggregate{
     // å������ å�� �����ϱ� ���� Book �迭�� �����Ѵ�.
	private Vector books;  //�迭 ������ �����ϰ�, ������ �Ҵ���� �ʾҴ�. ���赵���� ������ �����ϴ� �κ�-å���̰� å�� ������ �ִ�.
    private int last = 0; // ������ å�� ���� ��ġ�� �����Ѵ�.

    				//å������ ũ��
    public BookShelf(int initialsize) {
        this.books = new Vector(initialsize); // ���⼭ �迭 ������ ������ �������.
    }

	 // �Է������� index�� �ش��ϴ� å�� ��ȯ�ϴ� �޼ҵ�
    // public Book getBookFrom(int index)
    public Book getBookAt(int index) {
        return (Book)books.get(index);
    }

	// å���̿� å�� �ȴ� �޼ҵ�
    public void appendBook(Book book) {
    	books.add(book);
    }

	// å������ å ������ ��ȯ�ϴ� �޼ҵ�
    public int getLength() {
        return books.size();
    }

	// �ڽ��� Iterator�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
    public Iterator iterator() {
		// �ڽ��� ���ڷ� �Ͽ� BookShelfIterator ��ü�� �����Ͽ� ��ȯ�Ѵ�.
        return new BookShelfIteratorBackward(this);  //this: ���� å����
    }
}










