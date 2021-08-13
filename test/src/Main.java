import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        double[][] matrix1 = {{1,10,3},{2,1,4},{3,10,5}};
        double[][] matrix2 = {{1,1},{2,1}};
        double[][] matrix3 = {{1,-1,3,0},{2,0,4,1},{3,0,5,3},{2,1,2,4}};

        double[][] inputMatrix = {{1.1, 0.3}, {-2.03, 3.67}};
        double[][] expectedMatrix = {{0.790, -0.065}, {0.437, 0.237}};

        double[][] matrix = {{1,2},{3,4}};

        double[][] mat = {{1}};
      //  Out(matrix);
       // Out(transpose(mat));
       // Out(clock(mat));
     //   Out(multiplyMatrices(mat,mat));
       // inverse(inputMatrix);
      //  Out(mat);
        System.out.println(del(mat));



    }


    public static double[][] inverse(double[][]matrix){
        double[][] inverseMatrix = new double[matrix.length][matrix.length];
        double[][] newMatrix= new double[matrix.length-1][matrix.length-1];

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){

                for (int r = 0, l = 0; r < matrix.length; r++){
                    if(r==i){
                        continue;
                    }
                    for (int k = 0, p = 0; k < matrix.length; k++){
                        if(k==j){
                            continue;
                        }
                        newMatrix[l][p] = matrix[r][k];
                        p++;
                    }
                    l++;
                }
                // вычисляем детерминант и помещаем в матрицу алгебраических дополнений
                if(matrix.length>2){
                    inverseMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * del(newMatrix);
                }
                else {
                    inverseMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * newMatrix[0][0];
                }
            }
        }

        inverseMatrix = transpose(inverseMatrix);
        double determinant = del(matrix);

        for (int i = 0; i < inverseMatrix.length; i++){
            for (int j = 0; j < inverseMatrix.length; j++){
                inverseMatrix[i][j] = BigDecimal.valueOf(inverseMatrix[i][j]/determinant).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
            }
        }
        Out(inverseMatrix);
        return inverseMatrix;
    }


    public static double del(double[][] matrix){

        double determinant=0;

        if(matrix.length == 1){
            determinant = matrix[0][0];
        }
        else if(matrix.length == 2){
             determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            double[][] newMatrix = new double[matrix.length-1][matrix.length-1];
            for (int r = 0; r < matrix.length; r++) {

                for (int i = 1, l = 0; i < matrix.length; i++, l++) {
                    for (int j = 0, k = 0; j < matrix.length; j++) {

                        if (j == r) {
                            continue;
                        }

                        newMatrix[l][k] = matrix[i][j];
                        k++;
                    }
                }

                determinant += Math.pow((-1), (2 + r)) * matrix[0][r] * del(newMatrix);

            }

        }

        return determinant;
    }

   public static double[][] transpose(double[][] matrix) {

       double[][] transposedMatrix = new double[matrix[0].length][matrix.length];


           for (int j = 0; j < matrix[0].length; j++) {
               for (int i = 0; i < matrix.length; i++) {
                   transposedMatrix[j][i] = matrix[i][j];
               }
           }

        return transposedMatrix;
    }

   public static double[][] clock(double[][] matrix) {
       double[][] reverseMatrix = new double[matrix[0].length][matrix.length];

       for(int j = 0, k = 0; j < matrix[0].length; j++, k++){
           for (int i = 0, l = matrix.length-1; i < matrix.length; i++, l--){
               reverseMatrix[k][l] = matrix[i][j];
           }
       }

       return reverseMatrix;
   }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < secondMatrix[0].length; j++){
                for (int k = 0; k < secondMatrix.length; ++k){
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return resultMatrix;
    }



    public static void Out(double matrix[][]){
        for(int i =0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println("\n");
        }
    }

}