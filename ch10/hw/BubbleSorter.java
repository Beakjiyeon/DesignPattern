package ch10.hw;
// ������ : BubbleSorter Ŭ���� �߰�
public class BubbleSorter implements Sorter {
		public void sort(Comparable[] data) {
			for (int i = 0; i < data.length; i++) {
				for (int j =0; j < data.length-1; j++) {
					if (data[j].compareTo(data[j+1]) ==1) { 
						// data[i] �� data[j] ���� ũ��
						Comparable passingplace = data[j];
						data[j] = data[j+1];
						data[j+1] = passingplace;
					}
				}
			}
		}
	}
