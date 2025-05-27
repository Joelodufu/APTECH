#include <stdio.h>

void updateValue(int a) {
    a = a + 10;
}

void updateByReference(int *b) {
    *b = *b + 10;
}

int main() {
    int x = 5, y = 5;

    updateValue(x); 
    printf("x = %d\n", x); // x remains unchanged because we passed by value

     updateByReference(&y);
    printf("y = %d\n", y); // y is updated because we passed by reference

    return 0;
}

int a = 10;
int *ptr = &a;

// Dereferencing pointer to get value of a



