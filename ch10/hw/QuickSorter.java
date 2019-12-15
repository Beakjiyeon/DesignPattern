package ch10.hw;

public class QuickSorter implements Sorter {
    Comparable[] data;
    public void sort(Comparable[] data) {
        this.data = data;
        qsort(0, data.length - 1);
       
    }
    
    private void qsort(int pre, int post) {
        int saved_pre = pre;
        int saved_post = post;
        Comparable mid = data[(pre + post) / 2];
        do {
        	// mid���� ū data�� ���ö����� pre�� ���������� �̵���Ų��.
        	// ������ : �� ����� ��ġ�� �ٲ��ش�.
            while (mid.compareTo(data[pre])>0) {
                pre++;
            }
            // mid���� ���� data�� ���ö����� post�� �������� �̵���Ų��.
            // ������ : �� ����� ��ġ�� �ٲ��ش�.
            while (data[post].compareTo(mid)>0) {
                post--;
            }
            if (pre <= post) {
                Comparable tmp = data[pre];
                data[pre] = data[post];
                data[post] = tmp;
                pre++;
                post--;
            }
        } while (pre <= post);
        if (saved_pre < post) {
            qsort(saved_pre, post);
        }
        if (pre < saved_post) {
            qsort(pre, saved_post);
        }
    }
}
