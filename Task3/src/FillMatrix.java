import java.util.Random;

public class FillMatrix {

    static void initializeMatrix(int lowOfDiapason, int highOFDiapason, double massive[][]) {
        Random random = new Random();
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[0].length; j++) {
                massive[i][j] = random.nextDouble() * (highOFDiapason - lowOfDiapason) + lowOfDiapason;
            }
        }
    }
}
