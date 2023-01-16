# Data Structures

## Comparison Table
Time provided in milliseconds
timeout is 60 seconds

| operation            	| size    	| SingleArray 	| VectorArray 	| FactorArray 	| ArrayList 	| MatrixArray 	|
|----------------------	|---------	|-------------	|-------------	|-------------	|-----------	|-------------	|
| put in the end       	| 100     	| 1           	| 0           	| 0           	| 0         	| 0           	|
|                      	| 1000    	| 1           	| 0           	| 0           	| 0         	| 0           	|
|                      	| 10000   	| 98          	| 0           	| 0           	| 0         	| 0           	|
|                      	| 100000  	| 2,769       	| 22          	| 3           	| 1         	| 1           	|
|                      	| 1000000 	| timeout     	| 5,967       	| 32          	| 29        	| 31          	|
| put in the beginning 	| 100     	| 1           	| 0           	| 0           	| 0         	| 0           	|
|                      	| 1000    	| 1           	| 0           	| 0           	| 0         	| 3           	|
|                      	| 10000   	| 77          	| 1           	| 1           	| 1         	| 63          	|
|                      	| 100000  	| 2,662       	| 91          	| 74          	| 78        	| 5,380       	|
|                      	| 1000000 	| timeout     	| 35,017      	| 21,682      	| 22,231    	| timeout     	|
| put in the middle    	| 100     	| 1           	| 0           	| 0           	| 0         	| 0           	|
|                      	| 1000    	| 1           	| 0           	| 0           	| 0         	| 3           	|
|                      	| 10000   	| 82          	| 1           	| 1           	| 1         	| 75          	|
|                      	| 100000  	| 3,036       	| 95          	| 78          	| 77        	| 5,296       	|
|                      	| 1000000 	| timeout     	| timeout     	| 45,793      	| 44,679    	| timeout     	|