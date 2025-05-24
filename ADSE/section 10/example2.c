#include <stdio.h>
/** 
 * START
 * Promt uusers to enter two numbers
 * Read those two numbers
 * Calculate the difference Between the two numbers
 * Print the difference out
 * END
 * 
 */

int main()
{
    int arr[5] = {10, 20, 30, 40, 50};
    int *ptr = arr; // Points to the first element
    for (int i = 0; i < 5; i++)
    {
        printf("Element %d: %p\n", i, arr + i);
    }
    return 0;
}