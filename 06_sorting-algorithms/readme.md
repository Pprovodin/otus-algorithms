# Comparison Algorithms
Time provided in milliseconds.

## Comparison Table
_timeout_ is equal to 60 seconds.

|                                       	| 100 	| 1k 	| 10k 	| 100k   	| 1m             	| 10m            	|
|---------------------------------------	|-----	|----	|-----	|--------	|----------------	|----------------	|
| BubbleSort O(N^2)                     	| 1   	| 5  	| 106 	| 10,420 	| exceed _timeout_ 	| exceed _timeout_ 	|
| OptimizedBubbleSort O(N^2)            	| 0   	| 5  	| 109 	| 11,996 	| exceed _timeout_ 	| exceed _timeout_ 	|
| InsertionSort O(N^2)                  	| 0   	| 3  	| 29  	| 2,942  	| 1,392         	| 30,188         	|
| InsertionShiftSort O(N^2)             	| 0   	| 2  	| 11  	| 951    	| 955            	| 33,072         	|
| InsertionBinarySearchShiftSort O(N^2) 	| 0   	| 1  	| 27  	| 694    	| 54,201         	| exceed _timeout_ 	|
| ShellSort O(N^1,75)                   	| 0   	| 0  	| 4   	| 14     	| 151            	| 2,291          	|
| SelectionSort O(N^2)                  	| 0   	| 1  	| 38  	| 3,464  	| exceed _timeout_ 	| exceed _timeout_ 	|
| HeapSort O(NlogN)                     	| 0   	| 0  	| 1   	| 12     	| 109            	| 1,611          	|
| MergeSort O(NlogN)                    	| 0   	| 0  	| 1   	| 16     	| 192            	| 2,425          	|
| QuickSort O(NlogN)                    	| 0   	| 0  	| 1   	| 7      	| 95             	| 1,075          	|

# Specific Algorithms

##Comparison Table 1
Arrays were generated with bounds (0, 999).

|                                              	| 100 	| 1k 	| 10k 	| 100k 	| 1m 	| 10m 	|
|----------------------------------------------	|-----	|----	|-----	|------	|----	|-----	|
| BucketSort (O(N) when uniformly distributed) 	| 17  	| 2  	| 6   	| 25   	| 61 	| 644 	|
| CountingSort O(N); with natural numbers only 	| 0   	| 0  	| 0   	| 4    	| 9  	| 61  	|
| RadixSort O(N); with natural numbers only    	| 0   	| 0  	| 2   	| 9    	| 36 	| 340 	|

##Comparison Table 2
Arrays were generated with bounds (0, _size of array_).

|                                              	| 100 	| 1k 	| 10k 	| 100k 	| 1m  	| 10m   	|
|----------------------------------------------	|-----	|----	|-----	|------	|-----	|-------	|
| BucketSort (O(N) when uniformly distributed) 	| 2   	| 1  	| 5   	| 30   	| 238 	| 2,106 	|
| CountingSort O(N); with natural numbers only 	| 0   	| 0  	| 1   	| 5    	| 30  	| 1,281 	|
| RadixSort O(N); with natural numbers only    	| 0   	| 0  	| 2   	| 9    	| 60  	| 733   	|