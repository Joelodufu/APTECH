#include <stdio.h>

char printInt(int a)
{
    char grade = 'B';
    printf("This is an Int %d", a);
    return grade;
}


int main()
{
    printInt(4);
    printf("My grade is %s", printInt(0));
}

