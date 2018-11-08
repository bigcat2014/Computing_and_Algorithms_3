This program tests Insertionsort, Mergesort, and Quicksort algorithms, sorting from low to high, on
arrays of different lengths and different start cases. The start cases include random, sorted low to high, and
sorted high to low. The program measures cpu time (System.nanoTime()), number of
comparisons, and number of swaps.

The lengths of the arrays being tested are 1000, 10000, 20000, 30000, 40000, and 50000

The random arrays are created from one master random array of length 50000, the max length
being tested. I wanted to test the arrays in chunks, so I built the master array
in chunks. This means that at indices 0 to 999, the random values range from 0 to 1000,
indices 1000 to 9999, the random values range from 0 to 10000, indices 10000 to 19999
the random values range from 0 to 20000, and so on.

Compile Main.java, InsertionSort.java, MergeSort.java, and QuickSort.java
Run Main