# Bioinformatic Class

This class provides several methods related to bioinformatics, including sequence generation, entropy calculation, and motif finding. Below is a brief description of each method and its parameters.

## Methods

### 1. `sequence(int quantity, int size, int key_A, int key_C, int key_G, int key_T)`

Generates a list of random DNA sequences based on the given keys for nucleotides.

- **Parameters:**
  - `quantity` (int): Number of sequences to generate.
  - `size` (int): Length of each sequence.
  - `key_A` (int): Key to generate an "A" nucleotide.
  - `key_C` (int): Key to generate a "C" nucleotide.
  - `key_G` (int): Key to generate a "G" nucleotide.
  - `key_T` (int): Key to generate a "T" nucleotide.
- **Returns:** An `ArrayList<String>` of DNA sequences.

### 2. `calculateEntropy(ArrayList<String> sequences)`

Calculates the Shannon entropy for each sequence and returns the average entropy across all sequences.

- **Parameters:**
  - `sequences` (ArrayList<String>): A list of DNA sequences.
- **Returns:** The average entropy as a `double`.

### 3. `dataBaseSequences(int quantity, ArrayList<String> sequence)`

Stores DNA sequences in a HashMap, with the index as the key and the sequence as the value.

- **Parameters:**
  - `quantity` (int): The number of sequences to store.
  - `sequence` (ArrayList<String>): The list of sequences.
- **Returns:** A `HashMap<Integer, String>` containing the indexed sequences.

### 4. `createTxT(HashMap<Integer, String> list)`

Creates a text file `database.txt` and writes the sequences from the HashMap into the file.

- **Parameters:**
  - `list` (HashMap<Integer, String>): The HashMap containing sequences to write into the file.
- **Returns:** None (writes to a file).

### 5. `findMotif(String file, int size)`

Reads a file and searches for the most frequent DNA motif (substring of length `size`).

- **Parameters:**
  - `file` (String): The path to the file containing DNA sequences.
  - `size` (int): The length of the motif to search for.
- **Returns:** A `String` describing the most frequent motif and its count.
- **Throws:** `FileNotFoundException`, `IOException`.

---

This class is designed for working with DNA sequences in bioinformatics. It allows for the generation of random sequences, entropy analysis, and motif identification from data stored in text files.
