# Phone book
Comparison of searching with use of few different algorithms.

## General info
Program reads two files:
directory.txt - consisting over 1 million phone numbers with names of owners
find.txt - consisting 500 entries with names
The general purpose is to find 500 phone numbers of people from find.txt in list of people in directory.txt.
We use different search algorithms and compare times needed to find.

## Searching
 * Linear search
 * Jump search with Bubble sort. If sorting takes more than 10 times more than linear search it switch to linear search.
 * Binary search with Quick sort
 * Hashing table

## Technologies
Project is created with:
* Java 11

## Sample output
    Start searching (LinearSearch)...  
    Found 500 / 500 entries. Time taken: 0 min. 6 sec. 233 ms.
    
    Start searching (BubbleSort + JumpSearch)...  
    Found 500 / 500 entries. Time taken: 1 min. 7 sec. 754 ms.  
    Sorting time: 1 min. 2 sec. 419 ms. - STOPPED, moved to linear search  
    Searching time:0 min. 4 sec. 458 ms.
    
    Start searching (QuickSort + BinarySearch)...  
    Found 500 / 500 entries. Time taken: 0 min. 5 sec. 407 ms.  
    Sorting time: 0 min. 5 sec. 25 ms.  
    Searching time:0 min. 0 sec. 3 ms.  
    
    Start searching (HashingSearch)...  
    Found 500 / 500 entries. Time taken: 0 min. 1 sec. 589 ms.  
    Creating time: 0 min. 1 sec. 56 ms.  
    Searching time:0 min. 0 sec. 1 ms.  