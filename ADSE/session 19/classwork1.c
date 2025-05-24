#include <stdio.h>
#include <string.h>
struct Book
{
    char title[50];
    char author[50];
    float price;
};
int main()
{

    // DECLEAR THE VARIABLE
    struct Book myBook;

    // ASSIGNING VALUES

    puts("Enter The Book Title\n");
    scanf("%[^\n]", myBook.title);

    puts("Enter The Book Author\n");
    scanf("%[^\n]", myBook.author);

    puts("Enter The Book Price\n");
    scanf("%f", myBook.price);

    // PRINTING OUT
    puts(myBook.title);
    puts(myBook.author);
    printf("%f\n", myBook.price);
}