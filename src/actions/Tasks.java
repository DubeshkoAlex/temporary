package actions;

import javax.sound.midi.Soundbank;

public class Tasks {
    public static void task1(){
        int matrixSize = GetInfo.getInt("Please input the size of matrix: ");
        boolean columnOrRowSort = GetInfo.getBoolean("Please input the type of sort: by column - true, by row - false: ");
        int numberOfRowOrColumn = GetInfo.getInt("Please input the number of row or column from 1 to "+ matrixSize + ": ")-1;
        int[][] matrix = Create.randomMatrix(matrixSize,100);
        Output.matrix(matrix);
        System.out.println("\n \n");
        OperationWithMatrix.sortMatrix(matrix,numberOfRowOrColumn,columnOrRowSort);
        Output.matrix(matrix);
    }
    public static void task2(){

    }
}
