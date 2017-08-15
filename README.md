# Maze Solver 

#### Data Structures Summer Assignment
***
**_Features include:_**
+ Gui interface
+ Stack/Queue solving algorithms
+ Load maze from text file
+ Draw your own maze by clicking on the Squares
+ Resizeable maze grid
+ Colour coded squares
+ Click to change the square type

**_Description:_**
The MazeSolver program will solve mazes given either by a file or made there and then by clicking the various squares to change their type.

_Format of the Maze File:_
```
4 7
#######
#...#o#
#*#...#
#######
```

The first two numbers, seperated by a single space, are the rows and columns values respectively. Followed by the maze diagram.

**Maze File Key:**
| Character        | Square Type    | 
| ---------------- |:-------------: |
| **#**            | WALL           |
| **.**            | OPEN           |
| **o**            | START          |
| __*__            | FINISH         |

**Maze Square-Colour Key:**
| Colour            | Square Type    | 
| ----------------  |:-------------: |
| **BLACK**         | WALL           |
| **WHITE**         | OPEN           |
| **GREEN**         | START          |
| **RED**           | FINISH         |
