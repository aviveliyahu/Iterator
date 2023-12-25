# Iterator and sorting project
## Description
An academic project written in Java, this code is able to recieve any type of array (int,string,char and also generic type of array) and sort it.
This code was mainly used by us to make sure we undertand how does the Generic type of object works in java, and how to handle every type of given array in order to sort and use an iterator on it.


The user is able to create an ArrSorter class with an array insterted into its constructor. sorting is done by three types of sorting techiques-
* Bubble sort (sort #1)
* Merge sort (sort #2)
* Quick sort (sort #3)
  
The default sort is merge sort. the user can choose in which way to do the sort by adding a number to the constructor.

The ArrSorter constructor will recognize the type of array that was given, and will convert the given array into a generic type of array- then it will sort it using the options written above. the array will be saved in three ways:
* Original array.
* Sorted array.
* Reversed array.

The ArrIterator class extends the abstract class 'Iterator' (which basically defines which functions it must have). it's constructor, as the ArrSorter constuctor - will recognize the type of array that was given, and will convert the given array into a generic type of array. After creating the object, user will be able to use the next funcions -
* hasNext() - returns boolean answer if the given array has another item in it.
* next() - returns the next number in the array, throws exception if there isnt one.
* indexOf(T element) - returns the index of the given element from the array, returns -1 if it does not exist in the array. 

After creating the ArrSorter object, the user is able to use the ArrIterator class's function on each one of array it has (original, sorted, reversed).

## Getting Started

### Executing program
There are several ways to run this system:

* Clone git project into your IDE.
* Manually download included files and open it as a new project in your IDE.

  In both cases, you will have to created a 'main' class and create an ArrSorter object to check the code and its functions.

## Authors

Contributors:

[@Aviv Eliyahu](https://github.com/aviveliyahu)


