package task_02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("incorrect file transfer");
            return;
        }
        String firstFileName = args[0];
        String secondFileName = args[1];



        BufferedReader reader = null;
        float centerX = 0;
        float centerY = 0;
        float radius = 0;

        for (int r = 0; r < 2; r++) {
            if (r == 0) {
                try {
                    reader = new BufferedReader(new FileReader(firstFileName));
                } catch (FileNotFoundException f) {
                    System.out.println("22. FileNotFound");
                    return;
                }

                ArrayList<String[]> circleList = new ArrayList<>();
                String lines;
                while ((lines = reader.readLine()) != null) {
                    if (!(lines.isEmpty())) {
                        String[] circlePoint = lines.trim().split("\\s+");
                        circleList.add(circlePoint);
                    }
                }
                reader.close();

                for (int i = 0; i < 2; i++) {
                    try {
                        if (i % 2 == 0) {
                            centerX = Float.parseFloat(circleList.get(i)[0]);
                            centerY = Float.parseFloat(circleList.get(i)[1]);
                            radius = Float.parseFloat(circleList.get(i + 1)[0]);
                            radius = (float) Math.pow(radius, 2);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("47. The data transfer format in the file is not correct " + Arrays.toString(circleList.get(i)));
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("50. Number format exception " + Arrays.toString(circleList.get(i)));
                        return;
                    }
                }
            }
            if (r == 1) {
                try {
                    reader = new BufferedReader(new FileReader(secondFileName));
                } catch (FileNotFoundException f) {
                    System.out.println("FileNotFound");
                    return;
                }

                ArrayList<String[]> pointsList = new ArrayList<>();
                String lines;
                while ((lines = reader.readLine()) != null) {
                    if (!(lines.isEmpty())) {
                        String[] circlePoint = lines.trim().split("\\s+");
                        pointsList.add(circlePoint);
                    }
                }
                reader.close();

                float x = 0;
                float y = 0;
                for (int i = 0; i < pointsList.size(); i++) {
                    try {
                        if (pointsList.get(i).length != 2) {
                            throw new NumberFormatException();
                        }
                        x = Float.parseFloat(pointsList.get(i)[0]);
                        y = Float.parseFloat(pointsList.get(i)[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("79. The data transfer format in the file is not correct " + Arrays.toString(pointsList.get(i)));
                        return;
                    }

                    float result = (float) (Math.pow(x - centerX, 2)) + (float) (Math.pow(y - centerY, 2));

                    if (result == radius) {
                        System.out.println(0 + " точка лежит на окружности");
                    }
                    if (result < radius) {
                        System.out.println(1 + " точка внутри");
                    }
                    if (result > radius) {
                        System.out.println(2 + " точка снаружи");
                    }
                }
            }
        }
    }
}
