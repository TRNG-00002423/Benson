ROUND1: 
    N = 1_000_000 
    Target: 20_000

    Linear Search Time: 4_025_250
    Binary Search Time: 6_041

ROUND2:
    N = 5_000_000
    Target: 10_000_000

    Linear Search Time: 5_327_959
    Binary Search Time: 5_916 

Timing may be affected by JVM warmup and caching. Initial run may be slower as JVM optimizes the code. Accessing an array may be faster if accessed recently due to caching. Big-O is the main factor as logn time is much faster than linear time. Linear search uses linear time as worst case scenario requires searching through all the indices. Binary search uses logn time as it halfs the current searching pool each iteration which is a lot more efficient.