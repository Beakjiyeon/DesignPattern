package ch01.hw;

public class BookShelfIteratorBackward implements Iterator{
	private BookShelf bookShelf;
	private int index;
	public BookShelfIteratorBackward(BookShelf bookShelf) {//자신이 접근할 책꽂이(인자)를 넣음
	       this.bookShelf = bookShelf;
	       this.index = bookShelf.getLength() - 1;  // 책꽂이를 돌아다니기 전이므로,  맨 마지막 으로 초기화한다.
	   }
	@Override
	//최승휸: 원소가 더 있는지 검사하는 메소드
	public boolean hasNext() {
		if(index>=0){
			return true;
		} else{
			return false;
		}
	}

	@Override
	//최승훈: 다음 원소를 역순으로 꺼내오는 메소드.
	public Object next() {
		// TODO Auto-generated method stub
		Book book = bookShelf.getBookAt(index);
		index--;
		return book;
	}

}
