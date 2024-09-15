# Bioinformatic workshop
## Bioinformatic class
This class provides several methods related to bioinformatics, including sequence generation, entropy calculation, and motif finding. Below is a brief description of each method and its parameters.

### Methods

#### 1. `sequence(int quantity, int size, int key_A, int key_C, int key_G, int key_T)`

Generates a list of random DNA sequences based on the given keys for nucleotides.

- **Parameters:**
  - `quantity` (int): Number of sequences to generate.
  - `size` (int): Length of each sequence.
  - `key_A` (int): Key to generate an "A" nucleotide.
  - `key_C` (int): Key to generate a "C" nucleotide.
  - `key_G` (int): Key to generate a "G" nucleotide.
  - `key_T` (int): Key to generate a "T" nucleotide.
- **Returns:** An `ArrayList<String>` of DNA sequences.

#### 2. `calculateEntropy(ArrayList<String> sequences)`

Calculates the Shannon entropy for each sequence and returns the average entropy across all sequences.

- **Parameters:**
  - `sequences` (ArrayList<String>): A list of DNA sequences.
- **Returns:** The average entropy as a `double`.

#### 3. `dataBaseSequences(int quantity, ArrayList<String> sequence)`

Stores DNA sequences in a HashMap, with the index as the key and the sequence as the value.

- **Parameters:**
  - `quantity` (int): The number of sequences to store.
  - `sequence` (ArrayList<String>): The list of sequences.
- **Returns:** A `HashMap<Integer, String>` containing the indexed sequences.

#### 4. `createTxT(HashMap<Integer, String> list)`

Creates a text file `database.txt` and writes the sequences from the HashMap into the file.

- **Parameters:**
  - `list` (HashMap<Integer, String>): The HashMap containing sequences to write into the file.
- **Returns:** None (writes to a file).

#### 5. `findMotif(String file, int size)`

Reads a file and searches for the most frequent DNA motif (substring of length `size`).

- **Parameters:**
  - `file` (String): The path to the file containing DNA sequences.
  - `size` (int): The length of the motif to search for.
- **Returns:** A `String` describing the most frequent motif and its count.
- **Throws:** `FileNotFoundException`, `IOException`.

---

## Controller Class

This class acts as the main controller for managing and executing the functionality provided by the `bioinformatic` class. It demonstrates the process of generating DNA sequences, saving them to a file, finding the most frequent motif, and calculating entropy.

## Overview

The `controller` class instantiates the `bioinformatic` class and uses its methods to:
1. Generate random DNA sequences.
2. Store these sequences in a text file.
3. Find the most frequent motif (substring) in the sequences.
4. Calculate the Shannon entropy of the generated sequences.

## Constructor

### `controller()`

The constructor initializes the bioinformatic process and coordinates the following steps:

1. **Create Bioinformatic Instance:**
   - A `bioinformatic` object named `jaja` is created to access its methods.

2. **Generate Sequences:**
   - Calls the `sequence` method from the `bioinformatic` class to generate 10,000 random DNA sequences, each 6 nucleotides long. The parameters `0`, `2`, `3`, and `1` are used as keys to assign nucleotides (A, C, G, T).

