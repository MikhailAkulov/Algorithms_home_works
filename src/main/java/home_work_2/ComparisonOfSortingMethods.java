package home_work_2;

import java.util.Random;

public class ComparisonOfSortingMethods {

    private static final Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Создадим произвольный массив на 100000 элементов и протестируем разные методы сортировки:");
        int[] testArray = ArrayUtils.prepareArray(100000);

        // 1-й эксперимент. Пузырьковая сортировка
        long startTime = System.currentTimeMillis();
        SortUtils.bubbleSort(testArray.clone());
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("Время выполнения пузырьковой сортировки: %d мс.\n", processingTime);

        // 2-й эксперимент. Сортировка выбором
        startTime = System.currentTimeMillis();
        SortUtils.directSort(testArray.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения сортировки выбором: %d мс.\n", processingTime);

        // 3-й эксперимент. Сортировка вставкой
        startTime = System.currentTimeMillis();
        SortUtils.insertionSort(testArray.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения сортировки вставкой: %d мс.\n", processingTime);

        // 4-й эксперимент. Быстрая сортировка
        startTime = System.currentTimeMillis();
        SortUtils.quickSort(testArray.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения быстрой сортировки: %d мс.\n", processingTime);

        // 5-й эксперимент. Пирамидальная сортировка
        startTime = System.currentTimeMillis();
        SortUtils.heapSort(testArray.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения пирамидальной сортировки: %d мс.\n", processingTime);
    }

    static class SortUtils{

        /**
         * Пузырьковая сортировка
         * Сложность поиска O(n^2)
         */
        public static void bubbleSort(int[] array) {
            boolean finish;
            do {
                finish = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        finish = false;
                    }
                }
            }
            while (!finish);
        }

        /**
         * Сортировка вставками
         * Сложность поиска O(n^2)
         */
        public static void insertionSort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                for(int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[i]) {
                        int buf = array[i];
                        array[i] = array[j];
                        array[j] = buf;
                    }
                }
            }
        }

        /**
         * Сортировка выбором
         * Сложность поиска O(n^2)
         */
        public static void directSort(int[] array){
            for (int i = 0; i < array.length; i++){
                int min = i;
                for(int j = i + 1; j < array.length; j++){
                    if (array[j] < array[min]){
                        min = j;
                    }
                }
                if (i != min){

                    array[i] = array[i] + array[min];
                    array[min] = array[i] - array[min];
                    array[i] = array[i] - array[min];
                }
            }
        }

        /**
         * Быстрая сортировка
         * Сложность поиска O(n * log n)
         */
        static void quickSort(int[] array){
            quickSort(array, 0, array.length - 1);
        }

        static void quickSort(int[] array, int startPosition, int endPosition){
            int leftPosition = startPosition;
            int rightPosition = endPosition;

            // Вычисляем индекс и значение опорного элемента
            int pivot = array[(startPosition + endPosition) / 2];

            do{
                while (array[leftPosition] < pivot)
                    leftPosition++;

                while (array[rightPosition] > pivot)
                    rightPosition--;

                if (leftPosition <= rightPosition){
                    if (leftPosition < rightPosition){
                        int buf = array[leftPosition];
                        array[leftPosition] = array[rightPosition];
                        array[rightPosition] = buf;
                    }
                    leftPosition++;
                    rightPosition--;
                }
            }
            while (leftPosition <= rightPosition);

            if (leftPosition < endPosition){
                quickSort(array, leftPosition, endPosition);
            }
            if(startPosition < rightPosition){
                quickSort(array, startPosition, rightPosition);
            }
        }

        /**
         * Сортировка кучей (пирамидальная)
         * Сложность поиска O(n * log n)
         */
        public static void heapSort(int[] array) {

            // Построение кучи (перегруппируем массив)
            for (int i = array.length / 2 - 1; i >= 0 ; i--) {
                heapify(array, array.length, i);
            }

            // Один за другим извлекаем элементы из кучи
            for (int i = array.length - 1; i >= 0 ; i--) {
                // Перемещаем текущий корень в конец
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                // Вызываем процедуру heapify на меньшей куче
                heapify(array, i, 0);
            }
        }

        private static void heapify(int[] array, int heapSize, int rootIndex) {
            int largest = rootIndex; // Инициализируем наибольший элемент как корень
            int leftChild = 2 * rootIndex + 1; // Левый ребенок = 2 * rootIndex + 1
            int rightChild = 2 * rootIndex + 2; // Правый ребенок = 2 * rootIndex + 2

            // Если левый ребенок больше корня
            if (leftChild < heapSize && array[leftChild] > array[largest]) {
                largest = leftChild;
            }

            // Если правый ребенок больше самого большого элемента на данный момент
            if (rightChild < heapSize && array[rightChild] > array[largest]) {
                largest = rightChild;
            }

            // Если самый большой элемент не корень
            if (largest != rootIndex) {
                int temp = array[rootIndex];
                array[rootIndex] = array[largest];
                array[largest] = temp;

                // Рекурсивно преобразуем в двоичную кучу затронутое дерево
                heapify(array, heapSize, largest);
            }
        }
    }

    static class ArrayUtils{

        static int[] prepareArray(int length){
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(100);
            }
            return arr;
        }
    }
}
