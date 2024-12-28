import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuSolverSwing {

    private static final int SIZE = 9;
    private JTextField[][] cells = new JTextField[SIZE][SIZE];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SudokuSolverSwing().createAndShowGUI();
        });
    }

    // Method to create the GUI
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the grid for input
        JPanel gridPanel = createGridPanel();
        frame.add(gridPanel, BorderLayout.CENTER);

        // Create the Solve button
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveSudoku();
            }
        });
        frame.add(solveButton, BorderLayout.SOUTH);

        // Set up the frame
        frame.pack();
        frame.setVisible(true);
    }

    // Method to create the 9x9 grid of text fields
    private JPanel createGridPanel() {
        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        gridPanel.setPreferredSize(new Dimension(450, 450));

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JTextField cell = new JTextField();
                cell.setPreferredSize(new Dimension(50, 50));
                cell.setHorizontalAlignment(JTextField.CENTER);
                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        return gridPanel;
    }

    // Backtracking algorithm to solve the Sudoku puzzle
    private boolean solveSudoku() {
        int[][] board = getBoardFromGUI();
        if (backtrack(board)) {
            updateGUIWithSolution(board);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No solution exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Get the board values from the GUI and convert them into a 2D array
    private int[][] getBoardFromGUI() {
        int[][] board = new int[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                String text = cells[row][col].getText();
                if (!text.isEmpty()) {
                    board[row][col] = Integer.parseInt(text);
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return board;
    }

    // Update the GUI with the solved Sudoku solution
    private void updateGUIWithSolution(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setText(String.valueOf(board[row][col]));
            }
        }
    }

    // Check if placing num in the given row, column, and 3x3 sub-grid is safe
    private boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check the column
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check the 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Backtracking function to solve the Sudoku puzzle
    private boolean backtrack(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively solve the next cells
                            if (backtrack(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = 0;
                        }
                    }
                    return false; // Trigger backtracking
                }
            }
        }
        return true; // Solved the board
    }
}


