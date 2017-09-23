/**
 * Created by George-Lenovo on 6/29/2017.
 */
class BestSubmatrix {
    int sum;
    int[] elements;

    BestSubmatrix() {
    }

    BestSubmatrix(int sum, int a, int b, int c, int d) {
        this.sum = sum;

        int[] elements = new int[4];
        elements[0] = a;
        elements[1] = b;
        elements[2] = c;
        elements[3] = d;

        this.elements = elements;
    }

    static void printSubmatrix(BestSubmatrix best2x2) {
        System.out.println(best2x2.elements[0] + " " + best2x2.elements[1]);
        System.out.println(best2x2.elements[2] + " " + best2x2.elements[3]);
        System.out.println(best2x2.sum);
    }
}
