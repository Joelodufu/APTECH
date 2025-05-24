#include <stdio.h>
#include <string.h>
int main()
{
    char name[] = "Good afternoon ";
    char greet[] = "Good afternoon ";
    if (strcmp(name, greet) == 0)
    {
        puts("Same String");
    }
    else
    {
        puts("Not the same ");
    };
    puts(greet);
}