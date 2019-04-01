public class QuickSort {
    public static void main(String[] args) {
        int[] A = { 3, 2, 1, 4, 5 };
        sortIntegers(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i] + " ");
        }
    }

    public static void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        // 两个指针
        int left = start, right = end;
        // pivot的选取，不要选A[start], A[end]
        int pivot = A[(start + end) / 2];

        // left <= right
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

}