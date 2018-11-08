This program takes a file as a command line argument and goes through the file,
finds anagrams of each word, and prints out the anagrams. Apostrophes are ignored
and it is not case sensitive. The Quicksort algorithm was used to come up with
a key for each word as opposed to a different sorting algorithm because it was
already implemented in the last assignment and it performed the best.

The Quicksort algorithm has an average time complexity of O(n log(n)). Insertionsort
has an average time complexity of O(n^2), making it less suitable for large arrays.
Mergesort has an average time complexity of O(n log(n)). I chose Quicksort
because it has a better average time complexity than Insertionsort and because in
the tests for the last assignment, it performed the best on every test. In hindsight,
Insertionsort would have been suitable for this application because it does just fine
on small arrays, and since I am sorting letters in words, the arrays are quite small.
Insertionsort would have been a good choice had I not already implemented the other
algorithms because it is easy to implement, and suitable for this application.

Input format:
    1 word per line in a text file, which is given as a command line argument

Output format:
    word_0
    word_0_anagram_0
    word_0_anagram_1
    word_0_anagram_2
        .
        .
        .

    word_1
    word_1_anagram_0
    word_1_anagram_1
    word_1_anagram_2
        .
        .
        .

Compile Main.java, Word.java, and QuickSort.java
Run Main