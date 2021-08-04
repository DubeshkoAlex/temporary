package actions;

public class OperationWithMatrix {

    public static void quickSort(int[][] arr, int from, int to, int k){

        if(from < to){
            int divideIndex = partition(arr, from, to,k);
            quickSort(arr,from,divideIndex - 1,k);
            quickSort(arr, divideIndex, to,k);
        }
    }

//    private static int partition(int[][] arr, int from, int to, int k){
//        int rightIndex = to;
//        int leftIndex = from;
//
//        int pivot = arr[(from+to)/2][k];
//        while(leftIndex <= rightIndex){
//
//            while (arr[leftIndex][k] < pivot){
//                leftIndex++;
//            }
//
//            while (arr[rightIndex][k] > pivot){
//                rightIndex--;
//            }
//
//            if(leftIndex <= rightIndex){
//                swap(arr, rightIndex, leftIndex);
//                leftIndex++;
//                rightIndex--;
//            }
//        }
//        return leftIndex;
//    }
private static int partition(int[][] arr, int from, int to, int k){
    int rightIndex = to;
    int leftIndex = from;

    int pivot = arr[k][(from+to)/2];
    while(leftIndex <= rightIndex){

        while (arr[k][leftIndex] < pivot){
            leftIndex++;
        }

        while (arr[k][rightIndex] > pivot){
            rightIndex--;
        }

        if(leftIndex <= rightIndex){
            swap(arr, rightIndex, leftIndex);
            leftIndex++;
            rightIndex--;
        }
    }
    return leftIndex;
}

    public static void swap(int[][] array, int index1, int index2){
       arraySwap(array[index1],array[index2]);
    }

    public static void arraySwap(int[] array1, int[] array2){
        int[] tmp = new int[array1.length];
        for (int i = 0; i < array1.length; i++){
            tmp[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++){
            array1[i] = array2[i];
        }
        for (int i = 0; i < tmp.length; i++){
            array2[i] = tmp[i];
        }
    }

}
