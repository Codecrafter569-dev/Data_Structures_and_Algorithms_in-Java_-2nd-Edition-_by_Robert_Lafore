<div align="center">

# 🧠 Data Structures & Algorithms in Java

### My complete hands-on journey through *Data Structures and Algorithms in Java (2nd Edition)* by **Robert Lafore**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Programs](https://img.shields.io/badge/Programs-145-brightgreen?style=for-the-badge)
![Lines](https://img.shields.io/badge/Lines_of_Code-13.5K+-blue?style=for-the-badge)
![Topics](https://img.shields.io/badge/Topics-13-orange?style=for-the-badge)
![Built on](https://img.shields.io/badge/Built_on-Android_%2B_Termux-3DDC84?style=for-the-badge&logo=android&logoColor=white)

**Every structure implemented by hand. Every algorithm typed, broken, debugged, and understood. No shortcuts. No copy-paste.**

</div>

---

## 📌 About

This repository holds **all the code I wrote while completing Lafore's DSA book** — from the first array to weighted graphs.

- ✍️ Written **from scratch**, chapter by chapter
- 🔁 Many topics have **multiple versions** (`V2`, `V3`, …) showing how I refined my solution
- 🧪 Every file is a **standalone runnable program** with its own `main`
- 📱 Coded and run on a **phone** using **Termux**

---

## 📊 At a Glance

| 📦 Metric | 🔢 Value |
|---|---|
| **Java programs** | 145 |
| **Lines of code** | 13,500+ |
| **Topic folders** | 13 |
| **Time span** | Mar → May 2025 (~8 weeks) |
| **Language** | Java (no external libraries) |
| **Package style** | Default package, one file = one runnable demo |

---

## 🗺️ Roadmap — Book Chapters → Folders

| # | 📚 Book Chapter | 📁 Folder | 📄 Files | 🔑 Key Topics |
|:-:|---|---|:-:|---|
| 2–3 | Arrays & Simple Sorting | [`Arrays`](./Arrays) | 26 | Ordered arrays, binary search, bubble / selection / insertion / cocktail / odd-even sort, remove duplicates, median |
| 4 | Stacks & Queues | [`Stack`](./Stack) · [`Queues`](./Queues) | 8 · 11 | Bracket checking, infix → postfix, postfix evaluation, circular queue, deque, priority queue |
| 5 | Linked Lists | [`LinkList`](./LinkList) | 15 | Singly / doubly / circular lists, iterators, sorted list, Josephus problem, list-based stack & queue |
| 6 | Recursion | [`Recurtion`](./Recurtion) | 16 | Factorial, Towers of Hanoi, anagrams, merge sort, knapsack, team combinations, power |
| 7 | Advanced Sorting | [`Advance Sorting`](./Advance%20Sorting) | 13 | Shellsort, partitioning, quicksort variants, quickselect (median), radix sort |
| 8 | Binary Trees | [`Binary tree`](./Binary%20tree) | 15 | BST insert / find / delete, all traversals, balanced trees, Huffman coding, expression trees |
| 9 | Red-Black Trees | [`RedBlackTree`](./RedBlackTree) | 1 | Rotations, color flips, self-balancing insert |
| 10 | 2-3-4 Trees | [`2-3-4_Tree`](./2-3-4_Tree) | 5 | Node splits, inorder traversal, find-min |
| 11 | Hash Tables | [`HashTable`](./HashTable) | 9 | Linear / quadratic probing, double hashing, chaining, rehashing, digit folding |
| 12 | Heaps | [`Heap`](./Heap) | 7 | Max & min heap, heap sort, priority queue, tree-based heap |
| 13 | Graphs | [`Graph`](./Graph) | 10 | BFS, DFS, MST, topological sort, Warshall's transitive closure, Knight's tour |
| 14 | Weighted Graphs | [`Weight Graph`](./Weight%20Graph) | 7 | Weighted MST, shortest path, Floyd–Warshall, all-pairs, Hamiltonian cycles, TSP (brute force) |

> 🧩 Root files: `InputStatement.java`, `BankAccountTest.java` — early Java warm-ups before Chapter 2.

---

## ⏱️ Big-O Cheat Sheet (what these implementations demonstrate)

| 🧱 Structure / Algorithm | 🔍 Search | ➕ Insert | ➖ Delete | 📝 Note |
|---|:-:|:-:|:-:|---|
| Unsorted array | O(N) | O(1) | O(N) | Shift after delete |
| Ordered array | O(log N) | O(N) | O(N) | Binary search |
| Stack / Queue | — | O(1) | O(1) | push / pop, enqueue / dequeue |
| Linked list | O(N) | O(1) at head | O(N) | No shifting needed |
| Hash table | O(1) avg | O(1) avg | O(1) avg | Load factor matters |
| BST | O(log N) avg | O(log N) avg | O(log N) avg | O(N) worst if unbalanced |
| Red-Black / 2-3-4 tree | O(log N) | O(log N) | O(log N) | Self-balancing |
| Heap (priority queue) | — | O(log N) | O(log N) | Remove max / min |

| 🔃 Sorting | Time | Note |
|---|:-:|---|
| Bubble / Selection / Insertion | O(N²) | Simple, in place |
| Shellsort | between O(N) and O(N²), gap-dependent | Insertion sort with gaps |
| Quicksort | O(N log N) avg · O(N²) worst | Pivot choice matters |
| Merge sort | O(N log N) | Needs extra space |
| Heap sort | O(N log N) | In place |
| Radix sort | O(N·k) | k = digits, no comparisons |

| 🕸️ Graph Algorithm | Time (adjacency matrix) |
|---|:-:|
| BFS / DFS | O(V²) (O(V+E) with adjacency list) |
| Warshall / Floyd–Warshall | O(V³) |
| Hamiltonian cycle / TSP brute force | factorial — only for tiny graphs |

---

## ⭐ Highlight Projects

| 🏆 Project | 📂 Location | 💡 Why it's cool |
|---|---|---|
| **Huffman coding** | `Binary tree/HuffmanTestDrive.java` | Builds an optimal prefix code from character frequencies |
| **Red-Black tree** | `RedBlackTree/RedBlackTreeTestDrive.java` | Rotations + recoloring to stay balanced |
| **2-3-4 tree** | `2-3-4_Tree/` | Splits nodes on the way down |
| **Knight's Tour** | `Graph/KnightTour.java` | Classic backtracking / graph search |
| **Topological sort** | `Graph/ToPoLogicaliyInGraph.java` | Ordering dependencies in a DAG |
| **Floyd–Warshall** | `Weight Graph/FloydWarshall.java` | All-pairs shortest paths |
| **Traveling Salesman (brute force)** | `Weight Graph/TravelingSalesmanBF.java` | Shows why TSP explodes |
| **Josephus problem** | `LinkList/JosephusProblem.java` | Circular linked list in action |
| **Towers of Hanoi** | `Recurtion/TowerOfHanoi.java` | Recursion at its purest |
| **Knapsack solver** | `Recurtion/KnapsackSolver.java` | Recursive subset search |

---

## 📂 Project Structure

```
📦 Data_Structures_and_Algorithms_in-Java_-2nd-Edition-_by_Robert_Lafore
 ┣ 📁 Arrays              (26)   ← Ch 2–3
 ┣ 📁 Stack               (8)    ← Ch 4
 ┣ 📁 Queues              (11)   ← Ch 4
 ┣ 📁 LinkList            (15)   ← Ch 5
 ┣ 📁 Recurtion           (16)   ← Ch 6
 ┣ 📁 Advance Sorting     (13)   ← Ch 7
 ┣ 📁 Binary tree         (15)   ← Ch 8
 ┣ 📁 RedBlackTree        (1)    ← Ch 9
 ┣ 📁 2-3-4_Tree          (5)    ← Ch 10
 ┣ 📁 HashTable           (9)    ← Ch 11
 ┣ 📁 Heap                (7)    ← Ch 12
 ┣ 📁 Graph               (10)   ← Ch 13
 ┣ 📁 Weight Graph        (7)    ← Ch 14
 ┣ 📄 InputStatement.java
 ┣ 📄 BankAccountTest.java
 ┗ 📄 README.md
```

---

## ▶️ How to Run

**Requirements:** JDK 8 or newer.

### 📱 Termux (Android)

```bash
pkg update && pkg install openjdk-17 git

git clone https://github.com/Codecrafter569-dev/Data_Structures_and_Algorithms_in-Java_-2nd-Edition-_by_Robert_Lafore.git
cd Data_Structures_and_Algorithms_in-Java_-2nd-Edition-_by_Robert_Lafore
```

### 💻 Run any program

Each file is standalone, so compile and run it from inside its folder:

```bash
cd Arrays
javac HighArrayApp.java
java HighArrayApp
```

> 🔎 Folders with spaces need quotes: `cd "Binary tree"`
>
> ⌨️ Some programs read from the keyboard — just follow the on-screen prompts.

---

## 🗓️ Learning Timeline

| 📅 Period (2025) | 🎯 Focus |
|---|---|
| Mar 17 – 24 | Java basics, arrays, searching, simple sorts |
| Mar 25 – 29 | Stacks & queues |
| Mar 30 – Apr 2 | Linked lists |
| Apr 3 – 7 | Recursion |
| Apr 7 – 11 | Advanced sorting |
| Apr 14 – 25 | Binary trees, red-black trees, 2-3-4 trees |
| Apr 26 – May 5 | Hash tables, heaps |
| May 6 – 11 | Graphs & weighted graphs |

---

## 🎓 What I Learned

- 🧩 How each structure works **inside**, not just how to call it
- ⚖️ Trade-offs: speed vs. memory, simplicity vs. balance
- 🔁 Turning recursion into iteration (and back)
- 🐞 Debugging pointers, indices, and off-by-one errors
- 📈 Reasoning about **Big-O** before writing code

---

## 📝 Notes

- Folder and file names keep my original spelling (e.g. `Recurtion`) so history stays honest.
- Code follows the book's concepts, but is **my own implementation and experiments**.

---

## 📖 Credits

- 📗 **Book:** *Data Structures and Algorithms in Java, 2nd Edition* — **Robert Lafore**
- 👨‍💻 **Code & practice:** [**Codecrafter569-dev**](https://github.com/Codecrafter569-dev)

<div align="center">

### ⭐ If this helped you, drop a star — it keeps me motivated!

*Next up: applying these structures to real projects.* 🚀

</div>
