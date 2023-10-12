
public class Main{

    //variant 8
    public static double calculateY(double x) {
        if (x > 3.4) {
            return Math.sin(x) * Math.log(x);
        } else {
            return Math.pow(Math.cos(x), 2);
        }
    }

    public static int calculateStepCount(double start, double end, double step) {
        if (start > end || step <= 0) {
            throw new IllegalArgumentException("Некоректні вхідні дані");
        }

        return (int) Math.ceil((end - start) / step) + 1;
    }

    public static double[] calculateYArray(double start, double end, double step) {
        int stepCount = calculateStepCount(start, end, step);
        double[] yArray = new double[stepCount];
        for (int i = 0; i < stepCount; i++) {
            double x = start + i * step;
            yArray[i] = calculateY(x);
        }
        return yArray;
    }

    public static double[] calculateXArray(double start, double end, double step) {
        int stepCount = calculateStepCount(start, end, step);
        double[] xArray = new double[stepCount];
        for (int i = 0; i < stepCount; i++) {
            xArray[i] = start + i * step;
        }
        return xArray;
    }

    public static int findIndexOfMax(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findIndexOfMin(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double calculateSum(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum;
    }

    public static double calculateAverage(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        double sum = calculateSum(array);
        return sum / array.length;
    }

    public static void printMaxAndMinValues(double[] yArray, double[] xArray) {
        int indexOfMax = findIndexOfMax(yArray);
        int indexOfMin = findIndexOfMin(yArray);

        double maxX = xArray[indexOfMax];
        double maxY = yArray[indexOfMax];
        double minX = xArray[indexOfMin];
        double minY = yArray[indexOfMin];

        System.out.println("Результати обчислень:");
        System.out.printf("Максимальне значення y = %.3f досягається при x = %.3f%n", maxY, maxX);
        System.out.printf("Мінімальне значення y = %.3f досягається при x = %.3f%n", minY, minX);
    }

    public static void main(String[] args) {
        double start = 2.0;
        double end = 5.0;
        double step = 0.005;

        double[] xArray = calculateXArray(start, end, step);
        double[] yArray = calculateYArray(start, end, step);

        System.out.println("Результати обчислень:");

        System.out.println("Перші 5 значень x та відповідних їм y:");
        int n = Math.min(5, xArray.length);
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.3f, y[%d] = %.3f%n", i, xArray[i], i, yArray[i]);
        }

        System.out.println("Значення для вибраних x:");
        System.out.printf("x = %.3f, y = %.3f%n", xArray[0], yArray[0]);
        System.out.printf("x = %.3f, y = %.3f%n", xArray[280], yArray[280]);
        System.out.printf("x = %.3f, y = %.3f%n", xArray[600], yArray[600]);

        printMaxAndMinValues(yArray, xArray);

        double sumOfY = calculateSum(yArray);
        double averageOfY = calculateAverage(yArray);

        System.out.printf("Сума всіх значень y: %.3f%n", sumOfY);
        System.out.printf("Середнє арифметичне значень y: %.3f%n", averageOfY);
    }

}
