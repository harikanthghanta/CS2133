import java.util.Random;

/**
 * Created by kyle on 4/7/15.
 */
public class Sorting {
    public static int n = 1;
    public static int multiplier = 10;

    public static long startTime = 0;
    public static long endTime = 0;

    public static long lastBubbleSortTime = 0;
    public static long lastMergeSortTime = 0;

    public static void main (String args[]){

        while (true){
            n *= multiplier;

            //using two arrays from the beginning so we don't have to worry about making a copy
            double[] arrayX = new double[n];
            double[] arrayY = new double[n];

            for(int i = 0; i < n; i++){
                //making sure the lists to sort are identical
                double temp = Math.random();
                arrayX[i] = temp;
                arrayY[i] = temp;
            }

            long startTime;
            long endTime;

            startTime = System.currentTimeMillis();
            mergeSort(arrayX);
            endTime = System.currentTimeMillis();

            lastMergeSortTime = endTime - startTime;
            startTime = 0;
            endTime = 0;

            bubbleSort(arrayY);

            System.out.println(n + " items");
            System.out.println("---------------------------------------------");
            System.out.println("Merge Sort finished in: " + lastMergeSortTime);
            System.out.println("Bubble Sort finished in: " + lastBubbleSortTime);
            System.out.println();
        }
    }

    public static void bubbleSort(double[] arrayToSort){
        startTime = System.currentTimeMillis();
        boolean swapOccurred = true;
        while (swapOccurred){
            if (System.currentTimeMillis() - startTime > 20000) {
                System.out.println("Bubble sort took longer than 20 seconds");
                System.exit(0);
            }
            swapOccurred = false;
            for(int i = 0; i < arrayToSort.length - 1; i++){
                if(arrayToSort[i] > arrayToSort[i + 1]){
                    double temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swapOccurred = true;
                }
            }
        }
        endTime = System.currentTimeMillis();
        lastBubbleSortTime = endTime - startTime;
    }

    public static double[] mergeSort(double[] arrayToSort){
        double[] result = null;

        if (arrayToSort.length <= 1){
            return arrayToSort;
        }

        int halfSize = arrayToSort.length / 2;
        double[] left = new double[halfSize];
        double[] right = new double[arrayToSort.length - halfSize];

        System.arraycopy(arrayToSort, 0, left, 0, halfSize);
        System.arraycopy(arrayToSort, halfSize, right, 0, (arrayToSort.length - halfSize));

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    public static double[] merge(double[] left, double[] right){
        double[] result = new double[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;

        for(int i = 0; i < result.length; i++){
            if(rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])){
                result[i] = left[leftIndex];
                leftIndex++;
            } else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return result;
    }
}
