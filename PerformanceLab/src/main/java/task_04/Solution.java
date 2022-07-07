package task_04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try {
            fileName = args[0];
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("args NULL: " + Arrays.toString(args));
            return;
        }
        System.out.println(fileName);
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("FileNoteFound");
            return;
        }
        String line;
        ArrayList<Integer> array = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            try {
                if (!(line.isEmpty())) {
                    array.add(Integer.parseInt(line.trim()));
                }
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException");
                return;
            }
        }

        if (array.size() == 0) {
            System.out.println("array.size: " + array.size());
            System.out.println("File isEmpty");
            return;
        }

        double summ = 0;
        for (Integer integer : array) {
            summ = summ + integer;
        }
        int simpleAvarege = (int) Math.round(summ) / array.size();
        int minimumMoves = 0;
        for (Integer integer : array) {
            if (integer < simpleAvarege) {
                minimumMoves = minimumMoves + (simpleAvarege - integer);
            }
            if (integer > simpleAvarege) {
                minimumMoves = minimumMoves + (integer - simpleAvarege);
            }
        }
        System.out.println(minimumMoves);

//        int[] a = new int[]{10, 15, 5, 61, 1};
//        double summ = 0;
//        for (int i = 0; i < a.length; i++) {
//            summ = summ + a[i];
//        }
//        int simpleAvarege = (int)Math.round(summ) / a.length;
//        int min = 0;
//        System.out.println("Arrays: " + Arrays.toString(a));
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] < simpleAvarege) {
//                min = min + (simpleAvarege - a[i]);
//            }
//            if (a[i] > simpleAvarege) {
//                min = min + (a[i] - simpleAvarege);
//            }
//        }
//        System.out.println(min);
    }
}

