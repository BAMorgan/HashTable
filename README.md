# HashTable# HashTable and Anagram Finder Implementation in Java

## Overview
This project implements a **custom HashTable** to efficiently find **anagrams** from a list of words. It includes:
- **Custom HashTable Implementation**: Uses a **prime-based hashing function** for optimized performance.
- **Anagram Finder**: Stores and retrieves anagrams efficiently.
- **Performance Comparison**: Compares custom hash function vs. Java's built-in `.hashCode()`.

## Features
- **Efficient HashTable implementation with collision handling**.
- **Stores anagrams together in an optimized array-based hash structure**.
- **Analyzes collisions and running time for performance benchmarking**.
- Reads input from `words.txt` (word dictionary) and searches words from `input.txt`.
- Outputs results, including **anagram matches, collision counts, and performance metrics**, to `output.txt`.

## Files in this Repository
- **`Driver.java`** - Main entry point, handles file I/O and executes the hashing and searching.
- **`Anagram.java`** - Defines an `Anagram` class to store key-value pairs for anagram groups.
- **`HashTable.java`** - Implements a **custom HashTable** with a specialized **collision resolution method**.
- **`words.txt`** - Dictionary of words used for anagram matching.
- **`input.txt`** - List of words to search for anagrams.
- **`output.txt`** - Stores **anagram results, collision counts, and execution times**.
- **`readme.txt`** - Notes on hashing strategies, performance trade-offs, and reflections on the implementation.

## How to Run
1. **Compile the Java Files**  
   ```sh
   javac Driver.java Anagram.java HashTable.java
   ```
2. **Run the Program**  
   ```sh
   java Driver
   ```
3. The program will read `words.txt`, process anagrams from `input.txt`, and store results in `output.txt`.

## Time Complexity
- **Hash Insertion:** O(1) (Amortized, but may increase with collisions)
- **Hash Lookup (Anagram Search):** O(1) (Best Case), O(n) (Worst Case with collisions)
- **Collision Handling:** O(n) in case of excessive hash collisions

## Advantages & Limitations
✅ **Advantages:**
- **Constant-time anagram lookup** (if no collisions).
- **Custom hashing function reduces clustering effects**.
- **Faster performance compared to Java's `HashMap` in some cases**.

⚠️ **Limitations:**
- **Hash Collisions may slow down performance** (tracked in `output.txt`).
- **Memory overhead due to large preallocated array size**.
- **Sensitive to choice of hash function**.

## Example

### Sample Input (`input.txt`)
```
qiewuro
ssrab
oflg
equiye
stair
arts
ueenq
aaeilor
plicablexe
```
### Sample Output (`output.txt`)
```
Collision Count: 1579
Java Collision Count: 1487
------------------------------------------------------
My Running Time: 24ms || Java Running Time: 30ms
------------------------------------------------------
qiewuro 0
ssrab 1 brass 
oflg 2 flog golf 
equiye 0
stair 1 stair 
arts 2 star tsar 
ueenq 1 queen 
aaeilor 0
plicablexe 1 explicable 
```
