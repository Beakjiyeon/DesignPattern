package ch10.hw;

public class InsertSorter implements Sorter {
	public void sort(Comparable[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) { 
					// data[i] 가 data[j] 보다 크면
					// 서로 교환한다.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
					
				}
				}
}
}}