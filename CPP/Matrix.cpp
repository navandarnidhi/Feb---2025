/*
2. Create a C++ class named Matrix to represent a two-dimensional matrix of integers. The class should have the following characteristics:
Private Data Members:
  int row: The number of rows in the matrix.
  int col: The number of columns in the matrix.
  int **arr: A dynamically allocated two-dimensional array to store the matrix elements.
Public Member Functions:
  Constructor: Initialize the matrix with a given number of rows and columns. The constructor should dynamically allocate memory for the matrix.
  Destructor: Deallocate the memory used by the matrix to prevent memory leaks.
  void acceptRecord(): Allow the user to input values for each element of the matrix.
  void printRecord(): Display the matrix elements in a human-readable format.
*/

#include <iostream>
#include <iomanip> // for std::setw
using namespace std;
class Matrix {
private:
    int row; // Number of rows
    int col; // Number of columns
    int **arr; // Pointer to a dynamically allocated 2D array
public:
    // Constructor to initialize the matrix with given rows and columns
    Matrix(int r, int c) : row(r), col(c) {
        arr = new int*[row]; // Allocate memory for rows
        for (int i = 0; i < row; ++i) {
            arr[i] = new int[col]; // Allocate memory for each column in the row
        }
    }

    // Destructor to deallocate the memory used by the matrix
    ~Matrix() {
        for (int i = 0; i < row; ++i) {
            delete[] arr[i]; // Delete each row
        }
        delete[] arr; // Delete the array of pointers
    }

    // Function to accept values for each element of the matrix
    void acceptRecord() {
        cout << "Enter elements of the matrix (" << row << "x" << col << "):\n";
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cout << "Element [" << i + 1 << "][" << j + 1 << "]: ";
                cin >> arr[i][j];
            }
        }
    }

    // Function to print the matrix elements in a human-readable format
    void printRecord() const {
        cout << "Matrix (" << row << "x" << col << "):\n";
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cout << setw(5) << arr[i][j]; // Use setw for better formatting
            }
            cout << endl;
        }
    }
};

int main() {
    int rows, cols;
    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    Matrix matrix(rows, cols); // Create a Matrix object
    matrix.acceptRecord(); // Accept values for the matrix
    matrix.printRecord(); // Print the matrix

    return 0;
}
// The main function prompts the user for the number of rows and columns,
// creates a Matrix object, accepts the matrix elements from the user,
// and then prints the matrix in a formatted way. The destructor ensures that
// the dynamically allocated memory is properly released when the Matrix object goes out of scope.
// This implementation meets the requirements specified in the problem statement.
// The Matrix class provides a clear structure for managing a two-dimensional matrix of integers,   