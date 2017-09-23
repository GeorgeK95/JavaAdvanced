/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        int[][] initializedMatrix = InitializeMatrix.getInitializedMatrix();
        BestSubmatrix best2x2 = getBestSubmatrix(initializedMatrix);
        BestSubmatrix.printSubmatrix(best2x2);
    }

    private static BestSubmatrix getBestSubmatrix(int[][] initializedMatrix) {
        int best = Integer.MIN_VALUE;
        BestSubmatrix bs = new BestSubmatrix();
        for (int i = 0; i < initializedMatrix.length - 1; i++) {
            for (int j = 0; j < initializedMatrix[0].length - 1; j++) {
                int current = initializedMatrix[i][j] + initializedMatrix[i][j + 1] +
                        initializedMatrix[i + 1][j] + initializedMatrix[i + 1][j + 1];
                if (current > best) {
                    best = current;
                    bs = new BestSubmatrix(current, initializedMatrix[i][j], initializedMatrix[i][j + 1],
                            initializedMatrix[i + 1][j], initializedMatrix[i + 1][j + 1]);
                }
            }
        }
        return bs;
    }

}
