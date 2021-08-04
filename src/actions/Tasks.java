package actions;

public class Tasks {
    public static void task1(){

        int[][] matrix = Create.randomMatrix(5,100);
        Output.matrix(matrix);
        System.out.println("\n \n");
        OperationWithMatrix.quickSort(matrix,0, matrix.length-1,0);
        Output.matrix(matrix);
    }
    public static void task2(){

    }
}
