public class Matrix {

    static void matrixActions(int lowDiapason, int highDiapason, double massive[][]) {
        if (lowDiapason > highDiapason) {
            System.out.println("The high value of diapason must be greater than the low one.");
        }
        else {
            FillMatrix.initializeMatrix(lowDiapason, highDiapason, massive);
            minAndMaxOfMatrix(massive);
            averageOfMatrix(massive);
            localMin(massive);
            localMax(massive);
            transposition(massive);
        }
    }

    static void minAndMaxOfMatrix(double mas[][]) {
        double minValueOfMatrix = 1000000000;
        double maxValueOfMatrix = -1000000000;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] < minValueOfMatrix) {
                    minValueOfMatrix = mas[i][j];
                }
                else if (mas[i][j] > maxValueOfMatrix) {
                    maxValueOfMatrix = mas[i][j];
                }
            }
        }
        System.out.println("Minimum value of matrix is " + minValueOfMatrix
                + ", maximum value of matrix is " + maxValueOfMatrix);
    }

    static void averageOfMatrix(double massive[][]) {
        double avgArithm;
        double avgGeom;
        double sumOfValues = 0;
        double multOfValues = 1;
        boolean hasNegative = false;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[0].length; j++) {
                sumOfValues += massive[i][j];
                if (massive[i][j] >= 0) {
                    multOfValues *= massive[i][j];
                }
                else {
                    hasNegative = true;
                }
            }
        }
        if (hasNegative == false) {
            avgArithm = sumOfValues / (double) (massive.length * massive[0].length);
            avgGeom = Math.pow(multOfValues, 1.0 / (massive.length * massive[0].length));
            System.out.println("Arithmetic average of matrix: " + avgArithm);
            System.out.println("Geometric average of matrix: " + avgGeom);
        }
        else {
            avgArithm = sumOfValues / (double) (massive.length * massive[0].length);
            System.out.println("Arithmetic average of matrix: " + avgArithm);
            System.out.println("Geometric average doesn't exist.");
        }

    }

    static void localMin(double mas[][]) {
        double localMin = 1000000000;
        int row = -1;
        int column = -1;
        boolean ifFound = false;
        for (int i = 0; i < mas.length; i++) {
            for(int j = 0; j < mas[0].length; j++) {
                // для верхней строки
                if ((mas[i][j] == mas[0][j])
                        && (mas[i][j] != mas[0][0])
                        && (mas[i][j] != mas[0][mas[0].length - 1])
                        && (mas[i][j] < mas[i][j - 1])
                        && (mas[i][j] < mas[i][j + 1])
                        && (mas[i][j] < mas[i + 1][j])) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для левого столбца
                else if ((mas[i][j] == mas[i][0])
                        && (mas[i][j] != mas[0][0])
                        && (mas[i][j] != mas[mas.length - 1][0])
                        && (mas[i][j] < mas[i - 1][j])
                        && (mas[i][j] < mas[i + 1][j])
                        && (mas[i][j] < mas[i][j + 1])) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для последней строки
                else if ((mas[i][j] == mas[mas.length - 1][j])
                        && (mas[i][j] != mas[mas.length - 1][0])
                        && (mas[i][j] != mas[mas.length - 1][mas[0].length - 1])
                        && (mas[i][j] < mas[i][j - 1])
                        && (mas[i][j] < mas[i - 1][j])
                        && (mas[i][j] < mas[i][j + 1])) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для правого столбца
                else if ((mas[i][j] == mas[i][mas[0].length - 1])
                        && (mas[i][j] != mas[0][mas[0].length - 1])
                        && (mas[i][j] != mas[mas.length - 1][mas[0].length - 1])
                        && (mas[i][j] < mas[i - 1][j])
                        && (mas[i][j] < mas[i + 1][j])
                        && (mas[i][j] < mas[i][j - 1])) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                else if ((mas[i][j] < mas[i - 1][j])
                        && (mas[i][j] < mas[i][j + 1])
                        && (mas[i][j] < mas[i + 1][j])
                        && (mas[i][j] < mas[i][j - 1])) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
            }
            if (ifFound == true) {
                break;
            }
        }
        if (row == -1) {
            System.out.println("No local minimum.");
        }
        else {
            System.out.println("Local min is " + localMin
                    + ". The indexes of local min: row = " + row + ", column = " + column + ".");
        }
    }

    static void localMax(double mas[][]) {
        double localMax = -1000000000;
        int row = -1;
        int column = -1;
        boolean ifFound = false;
        for (int i = 0; i < mas.length; i++) {
            for(int j = 0; j < mas[0].length; j++) {
                // для верхней строки
                if ((mas[i][j] == mas[0][j])
                        && (mas[i][j] != mas[0][0])
                        && (mas[i][j] != mas[0][mas[0].length - 1])
                        && (mas[i][j] > mas[i][j - 1])
                        && (mas[i][j] > mas[i][j + 1])
                        && (mas[i][j] > mas[i + 1][j])) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для левого столбца
                else if ((mas[i][j] == mas[i][0])
                        && (mas[i][j] != mas[0][0])
                        && (mas[i][j] != mas[mas.length - 1][0])
                        && (mas[i][j] > mas[i - 1][j])
                        && (mas[i][j] > mas[i + 1][j])
                        && (mas[i][j] > mas[i][j + 1])) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для последней строки
                else if ((mas[i][j] == mas[mas.length - 1][j])
                        && (mas[i][j] != mas[mas.length - 1][0])
                        && (mas[i][j] != mas[mas.length - 1][mas[0].length - 1])
                        && (mas[i][j] > mas[i][j - 1])
                        && (mas[i][j] > mas[i - 1][j])
                        && (mas[i][j] > mas[i][j + 1])) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                // для правого столбца
                else if ((mas[i][j] == mas[i][mas[0].length - 1])
                        && (mas[i][j] != mas[0][mas[0].length - 1])
                        && (mas[i][j] != mas[mas.length - 1][mas[0].length - 1])
                        && (mas[i][j] > mas[i - 1][j])
                        && (mas[i][j] > mas[i + 1][j])
                        && (mas[i][j] > mas[i][j - 1])) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }
                else if ((mas[i][j] > mas[i - 1][j])
                        && (mas[i][j] > mas[i][j + 1])
                        && (mas[i][j] > mas[i + 1][j])
                        && (mas[i][j] > mas[i][j - 1])) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }

            }
            if (ifFound == true) {
                break;
            }
        }
        if (row == -1) {
            System.out.println("No local maximum.");
        }
        else {
            System.out.println("Local max is " + localMax
                    + ". The indexes of local maximum: row = " + row + ", column = " + column + ".");
        }
    }

    static void localMin_2(double mas[][]) {
        double localMin = 1000000000;
        int row = -1;
        int column = -1;
        boolean ifFound = false;
        for (int i = 0; i < mas.length; i++) {
            for(int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == mas[0][j]) { // верхняя строка
                    // рассмотрен случай, где крайние элементы матрицы
                    // могут считаться локальными минимумами/максимумами (по условию видимо не рассматривается)
                    if (mas[i][j] == mas[0][0] && mas[i][j] < mas[i + 1][j] && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;

                    }
                    else if (mas[i][j] == mas[0][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i + 1][j]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][0] && mas[i][j] != mas[0][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i][j + 1] && mas[i][j] < mas[i + 1][j]){
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[i][0]) { // левый столбец
                    // рассмотрен случай, где крайние элементы матрицы
                    // могут считаться локальными минимумами/максимумами (по условию видимо не рассматривается)
                    if (mas[i][j] == mas[0][0] && mas[i][j] < mas[i + 1][j] && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][0] && mas[i][j] < mas[i - 1][j]
                            && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][0] && mas[i][j] != mas[mas.length - 1][0] && mas[i][j] < mas[i - 1][j]
                            && mas[i][j] < mas[i + 1][j] && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[mas.length - 1][j]) { // последняя строка
                    // рассмотрен случай, где крайние элементы матрицы
                    // могут считаться локальными минимумами/максимумами (по условию видимо не рассматривается)
                    if (mas[i][j] == mas[mas.length - 1][0] && mas[i][j] < mas[i - 1][j]
                            && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i - 1][j]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[mas.length - 1][0] && mas[i][j] != mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i - 1][j] && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[i][mas[0].length - 1]) { // правый столбец
                    // рассмотрен случай, где крайние элементы матрицы
                    // могут считаться локальными минимумами/максимумами (по условию видимо не рассматривается)
                    if (mas[i][j] == mas[0][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i][j + 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] < mas[i][j - 1] && mas[i][j] < mas[i - 1][j]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][mas[0].length - 1] &&
                            mas[i][j] != mas[mas.length - 1][mas[0].length - 1] && mas[i][j] < mas[i - 1][j]
                            && mas[i][j] < mas[i + 1][j] && mas[i][j] < mas[i][j - 1]) {
                        localMin = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] < mas[i - 1][j] && mas[i][j] < mas[i][j + 1]
                        && mas[i][j] < mas[i + 1][j] && mas[i][j] < mas[i][j - 1]) {
                    localMin = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }

            }
            if (ifFound == true) {
                break;
            }
        }

        if (row == -1) {
            System.out.println("No local minimum.");
        }
        else {
            System.out.println("Local min is " + localMin
                    + ". The indexes of local min: row = " + row + ", column = " + column + ".");
        }
    }

    static void localMax_2(double mas[][]) {
        double localMax = -1000000000;
        int row = -1;
        int column = -1;
        boolean ifFound = false;
        for (int i = 0; i < mas.length; i++) {
            for(int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == mas[0][j]) { // верхняя строка
                    if (mas[i][j] == mas[0][0] && mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;

                    }
                    else if (mas[i][j] == mas[0][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i + 1][j]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][0] && mas[i][j] != mas[0][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i][j + 1] && mas[i][j] > mas[i + 1][j]){
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[i][0]) { // левый столбец
                    if (mas[i][j] == mas[0][0] && mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][0] && mas[i][j] > mas[i - 1][j]
                            && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][0] && mas[i][j] != mas[mas.length - 1][0] && mas[i][j] > mas[i - 1][j]
                            && mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[mas.length - 1][j]) { // последняя строка
                    if (mas[i][j] == mas[mas.length - 1][0] && mas[i][j] > mas[i - 1][j]
                            && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i - 1][j]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[mas.length - 1][0] && mas[i][j] != mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i - 1][j] && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] == mas[i][mas[0].length - 1]) { // правый столбец
                    if (mas[i][j] == mas[0][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i][j + 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] == mas[mas.length - 1][mas[0].length - 1]
                            && mas[i][j] > mas[i][j - 1] && mas[i][j] > mas[i - 1][j]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                    else if (mas[i][j] != mas[0][mas[0].length - 1] &&
                            mas[i][j] != mas[mas.length - 1][mas[0].length - 1] && mas[i][j] > mas[i - 1][j]
                            && mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j - 1]) {
                        localMax = mas[i][j];
                        row = i;
                        column = j;
                        ifFound = true;
                        break;
                    }
                }
                else if (mas[i][j] > mas[i - 1][j] && mas[i][j] > mas[i][j + 1]
                        && mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j - 1]) {
                    localMax = mas[i][j];
                    row = i;
                    column = j;
                    ifFound = true;
                    break;
                }

            }
            if (ifFound == true) {
                break;
            }
        }
        if (row == -1) {
            System.out.println("No local maximum.");
        }
        else {
            System.out.println("Local max is " + localMax
                    + ". The indexes of local maximum: row = " + row + ", column = " + column + ".");
        }
    }

    static void transposition(double mas[][]) {

        System.out.println("Matrix:");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(" " + mas[i][j] + " ");
            }
            System.out.print('\n');
        }

        if (mas.length == mas[0].length) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = i; j < mas[0].length; j++) {
                    if (mas[i][j] != mas[j][i]) {
                        mas[i][j] += mas[j][i];
                        mas[j][i] = mas[i][j] - mas[j][i];
                        mas[i][j] -= mas[j][i];
                    }
                }
            }
            System.out.println();
            System.out.println("Transposed square matrix: ");
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    System.out.print(" " + mas[i][j] + " ");
                }
                System.out.print('\n');
            }
        }
        else {
            double transposedMatrix[][] = new double[mas[0].length][mas.length];
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    transposedMatrix[j][i] = mas[i][j];
                }
            }
            System.out.println();
            System.out.println("Transposed rectangle matrix: ");
            for (int i = 0; i < transposedMatrix.length; i++) {
                for (int j = 0; j < transposedMatrix[0].length; j++) {
                    System.out.print(" " + transposedMatrix[i][j] + " ");
                }
                System.out.print('\n');
            }
        }
    }

}
