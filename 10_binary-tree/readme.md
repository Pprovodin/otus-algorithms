# Comparison table
Time provided in milliseconds

| operation                         	| size     	| Simple BST 	| AVL Tree 	|
|-----------------------------------	|----------	|------------	|----------	|
| Insert Increasing                 	| 100      	| 0          	| 2        	|
|                                   	| 1000     	| 4          	| 0        	|
|                                   	| 10000    	| 257        	| 2        	|
|                                   	| 100000   	| 22,821     	| 13       	|
|                                   	| 1000000  	| timeout    	| 125      	|
|                                   	| 10000000 	| timeout    	| 1,919    	|
| Insert Random                     	| 100      	| 4          	| 1        	|
|                                   	| 1000     	| 0          	| 1        	|
|                                   	| 10000    	| 3          	| 6        	|
|                                   	| 100000   	| 36         	| 55       	|
|                                   	| 1000000  	| 575        	| 953      	|
|                                   	| 10000000 	| 9,626      	| 11,831   	|
| Remove from Increasing (half elements) 	| 100      	| 2          	| 4        	|
|                                   	| 1000     	| 1          	| 1        	|
|                                   	| 10000    	| 60         	| 6        	|
|                                   	| 100000   	| 7,198      	| 68       	|
|                                   	| 1000000  	| timeout    	| 852      	|
|                                   	| 10000000 	| timeout    	| 10,379   	|
| Remove from Increasing (10% elements)  	| 100      	| 2          	| 3        	|
|                                   	| 1000     	| 0          	| 1        	|
|                                   	| 10000    	| 21         	| 5        	|
|                                   	| 100000   	| 2,147      	| 65       	|
|                                   	| 1000000  	| timeout    	| 798      	|
|                                   	| 10000000 	| timeout    	| 10,853   	|
| Remove from Random (half elements)     	| 100      	| 0          	| 3        	|
|                                   	| 1000     	| 0          	| 1        	|
|                                   	| 10000    	| 5          	| 8        	|
|                                   	| 100000   	| 82         	| 73       	|
|                                   	| 1000000  	| 963        	| 971      	|
|                                   	| 10000000 	| 17,467     	| 16,058   	|
| Remove from Random (10% elements)      	| 100      	| 0          	| 3        	|
|                                   	| 1000     	| 0          	| 0        	|
|                                   	| 10000    	| 5          	| 6        	|
|                                   	| 100000   	| 65         	| 63       	|
|                                   	| 1000000  	| 766        	| 778      	|
|                                   	| 10000000 	| 15,071     	| 13,702   	|


# Results from console


Insert increasing:
size = 100;	time = 2;	algorithm - AvlTree;	height - 7
size = 100;	time = 0;	algorithm - BinarySearchTree;	height - 100
size = 1000;	time = 0;	algorithm - AvlTree;	height - 10
size = 1000;	time = 4;	algorithm - BinarySearchTree;	height - 1000
size = 10000;	time = 2;	algorithm - AvlTree;	height - 14
size = 10000;	time = 257;	algorithm - BinarySearchTree;	height - 10000
size = 100000;	time = 13;	algorithm - AvlTree;	height - 17
size = 100000;	time = 22821;	algorithm - BinarySearchTree;	height - 100000
size = 1000000;	time = 125;	algorithm - AvlTree;	height - 20
size = 1000000;	timeout (60seconds);	algorithm - BinarySearchTree;	height - 153460
size = 10000000;	time = 1919;	algorithm - AvlTree;	height - 24
size = 10000000;	timeout (60seconds);	algorithm - BinarySearchTree;	height - 122993

Insert random (10_000_000)
size = 100;	time = 4;	algorithm - AvlTree;	height - 8
size = 100;	time = 1;	algorithm - BinarySearchTree;	height - 12
size = 1000;	time = 1;	algorithm - AvlTree;	height - 12
size = 1000;	time = 0;	algorithm - BinarySearchTree;	height - 20
size = 10000;	time = 6;	algorithm - AvlTree;	height - 16
size = 10000;	time = 3;	algorithm - BinarySearchTree;	height - 29
size = 100000;	time = 55;	algorithm - AvlTree;	height - 20
size = 100000;	time = 36;	algorithm - BinarySearchTree;	height - 42
size = 1000000;	time = 953;	algorithm - AvlTree;	height - 24
size = 1000000;	time = 575;	algorithm - BinarySearchTree;	height - 50
size = 10000000;	time = 11831;	algorithm - AvlTree;	height - 27
size = 10000000;	time = 9626;	algorithm - BinarySearchTree;	height - 61

Insert random (10_000)
size = 100;	time = 3;	algorithm - AvlTree;	height - 8
size = 100;	time = 0;	algorithm - BinarySearchTree;	height - 11
size = 1000;	time = 1;	algorithm - AvlTree;	height - 12
size = 1000;	time = 1;	algorithm - BinarySearchTree;	height - 20
size = 10000;	time = 4;	algorithm - AvlTree;	height - 15
size = 10000;	time = 3;	algorithm - BinarySearchTree;	height - 30
size = 100000;	time = 50;	algorithm - AvlTree;	height - 16
size = 100000;	time = 54;	algorithm - BinarySearchTree;	height - 48
size = 1000000;	time = 213;	algorithm - AvlTree;	height - 16
size = 1000000;	time = 4391;	algorithm - BinarySearchTree;	height - 160
size = 10000000;	time = 1700;	algorithm - AvlTree;	height - 16
size = 10000000;	timeout (60seconds);	algorithm - BinarySearchTree;	height - 639

Remove (N/2)
size = 100;	time = 2;	algorithm - BinarySearchTree;	height - 50
size = 1000;	time = 1;	algorithm - BinarySearchTree;	height - 500
size = 10000;	time = 60;	algorithm - BinarySearchTree;	height - 5000
size = 100000;	time = 7198;	algorithm - BinarySearchTree;	height - 50000
size = 100;	time = 4;	algorithm - AvlTree;	height - 6
size = 1000;	time = 1;	algorithm - AvlTree;	height - 9
size = 10000;	time = 6;	algorithm - AvlTree;	height - 13
size = 100000;	time = 68;	algorithm - AvlTree;	height - 16
size = 1000000;	time = 852;	algorithm - AvlTree;	height - 19
size = 10000000;	time = 10379;	algorithm - AvlTree;	height - 23

Remove increasing (N/10)
size = 100;	time = 2;	algorithm - BinarySearchTree;	height - 90
size = 1000;	time = 0;	algorithm - BinarySearchTree;	height - 900
size = 10000;	time = 21;	algorithm - BinarySearchTree;	height - 9000
size = 100000;	time = 2147;	algorithm - BinarySearchTree;	height - 90000
size = 100;	time = 3;	algorithm - AvlTree;	height - 7
size = 1000;	time = 1;	algorithm - AvlTree;	height - 10
size = 10000;	time = 5;	algorithm - AvlTree;	height - 14
size = 100000;	time = 65;	algorithm - AvlTree;	height - 17
size = 1000000;	time = 798;	algorithm - AvlTree;	height - 20
size = 10000000;	time = 10853;	algorithm - AvlTree;	height - 24


Remove random (N/2)
size = 100;	time = 3;	algorithm - AvlTree;	height - 6
size = 100;	time = 0;	algorithm - BinarySearchTree;	height - 17
size = 1000;	time = 1;	algorithm - AvlTree;	height - 11
size = 1000;	time = 0;	algorithm - BinarySearchTree;	height - 24
size = 10000;	time = 8;	algorithm - AvlTree;	height - 15
size = 10000;	time = 5;	algorithm - BinarySearchTree;	height - 35
size = 100000;	time = 73;	algorithm - AvlTree;	height - 19
size = 100000;	time = 82;	algorithm - BinarySearchTree;	height - 41
size = 1000000;	time = 971;	algorithm - AvlTree;	height - 22
size = 1000000;	time = 963;	algorithm - BinarySearchTree;	height - 52
size = 10000000;	time = 16058;	algorithm - AvlTree;	height - 26
size = 10000000;	time = 17467;	algorithm - BinarySearchTree;	height - 67

Remove random (N/10)
size = 100;	time = 3;	algorithm - AvlTree;	height - 8
size = 100;	time = 0;	algorithm - BinarySearchTree;	height - 15
size = 1000;	time = 0;	algorithm - AvlTree;	height - 11
size = 1000;	time = 0;	algorithm - BinarySearchTree;	height - 23
size = 10000;	time = 6;	algorithm - AvlTree;	height - 16
size = 10000;	time = 5;	algorithm - BinarySearchTree;	height - 34
size = 100000;	time = 63;	algorithm - AvlTree;	height - 19
size = 100000;	time = 65;	algorithm - BinarySearchTree;	height - 44
size = 1000000;	time = 778;	algorithm - AvlTree;	height - 23
size = 1000000;	time = 766;	algorithm - BinarySearchTree;	height - 56
size = 10000000;	time = 13702;	algorithm - AvlTree;	height - 28
size = 10000000;	time = 15071;	algorithm - BinarySearchTree;	height - 63


