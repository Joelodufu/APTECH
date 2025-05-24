#include <stdio.h>

struct Rectangle
{
    float length;
    float width;
};

int main()
{

    // Initialization at declearation stage
    struct Rectangle rect1 = {23.4, 34.43};

    // asigning values
    struct Rectangle rect2;

    rect2.length = 54.6;
    rect2.width = 76.4;

    // printing the values of both rectangles
    printf("RECTANGLE 1:\n Length=%f\n Width=%f\n\n", rect1.length, rect1.width);
    printf("RECTANGLE 2:\n Length=%f\n Width=%f\n\n", rect2.length, rect2.width);
}