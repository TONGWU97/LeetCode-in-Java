public class MergeSort {
    public static void main(String[] args) {
        int[] A = {3,2,1,4,5};
        sortIntegers(A);
        for(int i = 0; i < A.length; i++) {
            System.out.println(A[i]+ " ");
        }
    }

    public static void sortIntegers(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private static void mergeSort(int[] A, int start, int end, int[] temp) {
        if(start >= end) {
            return;
        }
        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    private static void merge(int[] A, int start, int end, int[] temp) {
        int leftIndex = start;
        int middle = (start + end) / 2;
        int rightIndex = middle + 1;
        int index = leftIndex;

        while(leftIndex <= middle && rightIndex <= end) {
            if(A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }
        while(leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }
        while(rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        for(int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}