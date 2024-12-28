# Sudoku Solver

Sudoku Solver with Swing GUI in Java
This is a simple Sudoku Solver implemented in Java using Swing (without JavaFX). The program allows users to input a Sudoku puzzle, and upon clicking the "Solve" button, it solves the puzzle using the backtracking algorithm and displays the solution.

**How It Works**

**Swing GUI Components**:
•	JTextField: Each cell of the Sudoku grid is represented by a JTextField. The grid is 9x9, with each JTextField allowing users to enter numbers.
•	JButton: The "Solve" button triggers the solving process when clicked.
•	JPanel: A JPanel is used to hold the grid of JTextField objects and the button.

**Sudoku Solver Logic**:
•	Backtracking Algorithm: The algorithm tries placing numbers (1-9) into empty cells and checks if they are valid (using the isSafe method).
•	Solution Update: If a solution is found, the grid is updated with the solved puzzle. If no solution is found, an error message is shown using JOptionPane.

**Flow of the Program**:
1.	The user enters numbers (1-9) into the grid cells, leaving empty cells as 0.
2.	The user clicks the "Solve" button to trigger the solving process.
3.	The program uses backtracking to solve the puzzle.
4.	If a solution is found, the grid is updated with the solved values.
5.	If no solution exists, an error message is shown.

**Features and Enhancements**:
**Input Validation**:
•	A DocumentListener is added to each JTextField to ensure that only valid numbers (1-9) can be entered. Invalid inputs will cause the background color of the cell to turn red, and an error message will appear when attempting to solve.

**Styling**:
•	Each JTextField has a border to make the grid clearer.
•	The font used is Arial, size 18, for readability.
•	The default background color is white, which turns red if invalid input is detected.

**Error Handling**:
•	If invalid data is entered (e.g., a non-numeric value or a number outside the 1-9 range), the user will receive an error message, and the input field will turn red.
•	If the puzzle is unsolvable, the program will display an error and reset the grid.

**How to Run**
1. Save the code:
Save the code in a file called SudokuSolverSwing.java.
2. Compile the program:
Open a terminal and navigate to the directory containing the file. Compile the code using the following command:
javac SudokuSolverSwing.java
3. Run the program:
Once compiled, run the program with the following command:
java SudokuSolverSwing
4. Input the Sudoku puzzle:
Enter the numbers from 1 to 9 in the grid cells (you can leave some cells empty or fill them with 0).
5. Solve the puzzle:
Click the "Solve" button to see the solution.

**Example Input**
Input this puzzle into the grid:

5 3 0 0 7 0 0 0 0 

6 0 0 1 9 5 0 0 0 

0 9 8 0 0 0 0 6 0 

8 0 0 0 6 0 0 0 3 

4 0 0 8 0 3 0 0 1 

7 0 0 0 2 0 0 0 6 

0 6 0 0 0 0 2 8 0 

0 0 0 4 1 9 0 0 5 

0 0 0 0 8 0 0 7 9

After clicking "Solve", the program will fill the grid with the solution:

5 3 4 6 7 8 9 1 2

6 7 2 1 9 5 3 4 8

1 9 8 3 4 2 5 6 7

8 5 9 7 6 1 4 2 3

4 2 6 8 5 3 7 9 1

7 1 3 9 2 4 8 5 6

9 6 1 5 3 7 2 8 4

2 8 7 4 1 9 6 3 5

3 4 5 2 8 6 1 7 9

**Error Handling**
**Invalid Entry**:
•	Non-Numeric Input: If you enter any character other than a number (e.g., "abc"), the field will turn red, and you will be prompted with an error message when attempting to solve the puzzle.
•	Out-of-Range Numbers: If you enter a number outside the valid range (1-9), the cell will also turn red.
**Example Error Message**:
Error: Please enter only numbers between 1 and 9.
________________________________________

**Conclusion**
This Sudoku solver with a Swing GUI provides an interactive and user-friendly interface for solving Sudoku puzzles. With input validation, error handling, and the backtracking algorithm, it offers both functionality and usability for anyone looking to play or solve Sudoku puzzles efficiently in Java.

