# GaveOfLife

This is my first project from my Java class, using loops and conditions to create 10 iterations of the Game of Life. 
Included is the java file and the first level. 
We start with a set of 1's and 0's in a random pattern of 100. 
Loop through each intiger of the 100-intiger 2D array and determine using the rules whether an integer should be 1 or 0. 

The rules of the Game of Life are as follows:
If the cell in question is "1" and has <2 or neighbors which are 1, the cell turns to 0. 
If the cell is 1 and has 2 or 3 neighbors which are 1, the cell remains 1.
If the cell is 0 and has exactly 3 neighbors, the cell becomes 1. 

This cycles for 10 generations. The resulting patters are interesting and make you want to try the game again with a different sample. How many generations can this go before it all turns to 0? What happens when you add more 1's in the sample? More 0's?
