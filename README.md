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
+ Save current maze to file
+ Step by Step animation button

**_Description:_**
The MazeSolver program will solve mazes given either by a file or made there and then by clicking the various squares to change their type.
The user can choose to use either Queue or Stack algorithms and a step by step animation will be show - alternitively, toggling the animation 
can play the animation of the maze being solved without the user having to press the Step button each step. 

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

| Character | Square Type |
|-----------|-------------|
| #         | Wall        |
| .         | Open        |
| o         | Start       |
| *         | Finish      |


**Maze Square-Colour Key:**

| Colour | Square Type |
|--------|-------------|
| Black  | Wall        |
| White  | Open        |
| Green  | Start       |
| Red    | Finish      |
