#include<stdio.h>


union Data
{
    int i;
    float f;
    char c;
};

int main(){


    union Data d;
    d.i = 65;
    printf("Integer: %d\n", d.i);            // Output: 65
    printf("Char (same memory): %c\n", d.c); // Output: A (ASCII 65)
    d.f = 3.14;
    printf("Float (overwrites): %.2f\n", d.f); // Output: 3.14
    printf("Float (overwrites): %d\n", d.i); // Output: 3.14
    return 0;
}

