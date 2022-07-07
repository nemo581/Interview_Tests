package task_01;

public class Solution {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            if (n <= 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (m <= 0) {
                throw new NumberFormatException();
            }
            circularArray(n, m);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException");
        } catch (ArrayIndexOutOfBoundsException oobe) {
            System.out.println("IndexOitOfBounds");
        }
    }

    public static void circularArray(int n, int m){
        int countN = 0;
        int countM = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        boolean isFirstRun = true;
        while (true) {
            if (isFirstRun) {
                System.out.print(array[countN] + " ");
                isFirstRun = false;
                countM++;
            }
            if (countM == m) {
                if (countN == 0) {
                    break;
                } else {
                    System.out.print(array[countN] + " ");
                    countM = 1;
                }
            }
            countM++;
            countN++;
            if (countN == n) {
                countN = 0;
            }
        }
    }
}
