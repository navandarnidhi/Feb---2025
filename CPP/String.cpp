/*
1. Design a String class with the following requirements:
- Data members:
  int length;
  char *str;
- Member functions:
  - A constructor that initializes an empty string.
  - A destructor to release any dynamically allocated memory.
  - A member function named acceptRecord that accept string.
  - A member function named printRecord that prints string.
*/
#include <iostream>
#include <cstring> // for strlen and strcpy

class String {
private:
    int length;
    char* str;

public:
    // Constructor - initializes an empty string
    String() {
        length = 0;
        str = new char[1];
        str[0] = '\0';
    }

    // Destructor - releases dynamically allocated memory
    ~String() {
        delete[] str;
    }

    // Accepts a string from the user
    void acceptRecord() {
        char buffer[100]; // temp buffer
        std::cout << "Enter a string: ";
        std::cin.getline(buffer, 100);

        length = strlen(buffer);

        delete[] str; // release old memory if any
        str = new char[length + 1];
        strcpy(str, buffer);
    }

    // Prints the string
    void printRecord() const {
        std::cout << "String: " << str << std::endl;
    }
};

int main() {
    String myString;

    myString.acceptRecord();
    myString.printRecord();

    return 0;
}