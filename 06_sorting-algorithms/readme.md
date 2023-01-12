# Sorting Algorithms

## Comparison Table
Time provided in milliseconds, _timeout_ is equal to 60 seconds.

|                                       	| 100 	| 1k 	| 10k 	| 100k   	| 1m             	| 10m            	|
|---------------------------------------	|-----	|----	|-----	|--------	|----------------	|----------------	|
| BubbleSort O(N^2)                     	| 1   	| 5  	| 140 	| 11,531 	| exceed _timeout_ 	| exceed _timeout_ 	|
| OptimizedBubbleSort O(N^2)            	| 0   	| 0  	| 0   	| 1      	| exceed _timeout_ 	| exceed _timeout_ 	|
| InsertionSort O(N^2)                  	| 0   	| 0  	| 0   	| 1      	| 1,030          	| 28,605         	|
| InsertionShiftSort O(N^2)             	| 0   	| 0  	| 0   	| 2      	| 229            	| 10,592         	|
| InsertionBinarySearchShiftSort O(N^2) 	| 0   	| 0  	| 0   	| 4      	| 54,201         	| exceed _timeout_ 	|
| ShellSort O(N^1,75)                   	| 0   	| 0  	| 2   	| 2      	| 101            	| 2,178          	|
| SelectionSort O(N^2)                  	| 0   	| 2  	| 91  	| 8,766  	| exceed _timeout_ 	| exceed _timeout_ 	|
| HeapSort O(NlogN)                     	| 0   	| 0  	| 1   	| 9      	| 96             	| 1,040          	|
| MergeSort O(NlogN)                    	| 0   	| 0  	| 1   	| 8      	| 157            	| 1,235          	|
| QuickSort O(NlogN)                    	| 0   	| 0  	| 0   	| 1      	| 56             	| 197            	|

## Results from console
size = 100; time = 1; algorithm - BubbleSort
size = 100; time = 0; algorithm - OptimizedBubbleSort
size = 100; time = 0; algorithm - InsertionSort
size = 100; time = 0; algorithm - InsertionShiftSort
size = 100; time = 0; algorithm - InsertionBinarySearchShiftSort
size = 100; time = 0; algorithm - ShellSort
size = 100; time = 0; algorithm - SelectionSort
size = 100; time = 0; algorithm - HeapSort
size = 100; time = 0; algorithm - MergeSort
size = 100; time = 0; algorithm - QuickSort
size = 1000; time = 5; algorithm - BubbleSort
size = 1000; time = 0; algorithm - OptimizedBubbleSort
size = 1000; time = 0; algorithm - InsertionSort
size = 1000; time = 0; algorithm - InsertionShiftSort
size = 1000; time = 0; algorithm - InsertionBinarySearchShiftSort
size = 1000; time = 0; algorithm - ShellSort
size = 1000; time = 1; algorithm - SelectionSort
size = 1000; time = 0; algorithm - HeapSort
size = 1000; time = 0; algorithm - MergeSort
size = 1000; time = 0; algorithm - QuickSort
size = 10000; time = 115; algorithm - BubbleSort
size = 10000; time = 0; algorithm - OptimizedBubbleSort
size = 10000; time = 0; algorithm - InsertionSort
size = 10000; time = 0; algorithm - InsertionShiftSort
size = 10000; time = 0; algorithm - InsertionBinarySearchShiftSort
size = 10000; time = 2; algorithm - ShellSort
size = 10000; time = 90; algorithm - SelectionSort
size = 10000; time = 0; algorithm - HeapSort
size = 10000; time = 1; algorithm - MergeSort
size = 10000; time = 0; algorithm - QuickSort
size = 100000; time = 11728; algorithm - BubbleSort
size = 100000; time = 1; algorithm - OptimizedBubbleSort
size = 100000; time = 2; algorithm - InsertionSort
size = 100000; time = 2; algorithm - InsertionShiftSort
size = 100000; time = 5; algorithm - InsertionBinarySearchShiftSort
size = 100000; time = 7; algorithm - ShellSort
size = 100000; time = 8901; algorithm - SelectionSort
size = 100000; time = 8; algorithm - HeapSort
size = 100000; time = 8; algorithm - MergeSort
size = 100000; time = 1; algorithm - QuickSort
size = 1000000; timeout (60seconds); algorithm - BubbleSort
size = 1000000; timeout (60seconds); algorithm - OptimizedBubbleSort
size = 1000000; time = 997; algorithm - InsertionSort
size = 1000000; time = 258; algorithm - InsertionShiftSort
size = 1000000; timeout (60seconds); algorithm - InsertionBinarySearchShiftSort
size = 1000000; time = 99; algorithm - ShellSort
size = 1000000; timeout (60seconds); algorithm - SelectionSort
size = 1000000; time = 89; algorithm - HeapSort
size = 1000000; time = 164; algorithm - MergeSort
size = 1000000; time = 57; algorithm - QuickSort
size = 10000000; timeout (60seconds); algorithm - BubbleSort
size = 10000000; timeout (60seconds); algorithm - OptimizedBubbleSort
size = 10000000; time = 28605; algorithm - InsertionSort
size = 10000000; time = 10592; algorithm - InsertionShiftSort
size = 10000000; timeout (60seconds); algorithm - InsertionBinarySearchShiftSort
size = 10000000; time = 2178; algorithm - ShellSort
size = 10000000; timeout (60seconds); algorithm - SelectionSort
size = 10000000; time = 1040; algorithm - HeapSort
size = 10000000; time = 1235; algorithm - MergeSort
size = 10000000; time = 197; algorithm - QuickSort