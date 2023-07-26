# List Interface

## Table of Contents
<!-- TOC -->
* [List Interface](#list-interface)
  * [Table of Contents](#table-of-contents)
  * [List Interface Characteristics](#list-interface-characteristics)
  * [Most Used List Implementations](#most-used-list-implementations)
    * [ArrayList](#arraylist)
    * [LinkedList](#linkedlist)
  * [Choose the appropriate implementation](#choose-the-appropriate-implementation)
    * [Comparison Table](#comparison-table)
  * [Ref.](#ref)
<!-- TOC -->

## List Interface Characteristics
In Java, the List interface is a part of the Java Collections Framework and represents an *ordered* collection of elements, allowing *duplicates* and maintaining the insertion order. Some key characteristics of the List interface include:


- **Ordered Collection**: Elements in a List are stored in a specific order, which is typically the order in which they were inserted.


- **Duplicates Allowed**: A List can contain duplicate elements, meaning you can add the same element multiple times.


- **Indexed Access**: Elements in a List can be accessed using their index, starting from 0 for the first element.


- **Dynamic Size**: Unlike arrays, a List can dynamically resize to accommodate the addition or removal of elements.


- **Common Operations**: The List interface defines various methods for adding, removing, and accessing elements such as `add()`, `remove()`, `get()`, `size()`, etc.


- *Iterable*: Being part of the Collections Framework, the List interface is iterable, allowing for easy iteration using loops or Java streams.

  - See also: [Streams](../java-8/stream-api.md)

<sub>[Back to top](#table-of-contents)</sub>


## Most Used List Implementations
Java provides several implementations of the List interface, each with its own strengths and weaknesses. Here are the most commonly used implementations:


<sub>[Back to top](#table-of-contents)</sub>


### ArrayList

- It uses a dynamic array to store elements.
- Offers fast access and search time (O(1)), making it suitable for random access.
- Slower insertion and deletion (O(n)) as elements may need to be shifted.

>It's generally preferred when frequent element access is required, but not so much for frequent insertions and deletions.


<sub>[Back to top](#table-of-contents)</sub>


### LinkedList

- It uses a doubly-linked list to store elements.
- Insertion and deletion are faster (O(1)) as it involves changing pointers.
- Slower access time (O(n)) since you need to traverse the list from the beginning to access an element.
- Suitable when you require frequent insertion and deletion, but not ideal for random access.
- Comparison Table of ArrayList and LinkedList


<sub>[Back to top](#table-of-contents)</sub>


## Choose the appropriate implementation

Always consider the trade-offs and performance characteristics to make an informed decision.

>If you need fast random access and infrequent insertion/deletion, use `ArrayList`. 

>For frequent insertion and deletion, `LinkedList` might be a better choice. 


<sub>[Back to top](#table-of-contents)</sub>


### Comparison Table

| Characteristics           | ArrayList                                   | LinkedList                  |
|---------------------------|---------------------------------------------|-----------------------------|
| Underlying Data Structure | Dynamic Array                               | Doubly Linked List          |
| Access Time               | Fast (O(1))                                 | Slow (O(n))                 |
| Insertion/Deletion Time   | Slow (O(n))                                 | Fast (O(1))                 |
| Random Access             | Efficient                                  | Inefficient [^1]            |
| Memory Overhead           | Lower                                       | Higher                      |
| Iteration Performance     | Faster                                      | Slower [^1]                 |
| Use Cases                 | Frequent access, infrequent insertion/deletion | Frequent insertion/deletion |

[^1] Elements are not stored in contiguous memory locations. Instead, each element in a LinkedList is stored in a separate node, and these nodes are connected through pointers (references) to the previous and next nodes, forming a chain-like structure.


<sub>[Back to top](#table-of-contents)</sub>


---

## Ref.


---

[Get Started](../../../../../get-started.md) |
[Languages](../../../../../get-started.md#languages) |
[Java Development](../develop.md#generics-and-collections) |
[Original Collections API](../java-1_2/collections-api.md) |
[Updated Collections](updated-collections.md)

---
