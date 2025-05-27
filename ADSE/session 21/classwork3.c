#include <stdio.h>

int main()
{
    FILE *fp;

    // OPEN THE FILE
    fp = fopen("letters.txt", "w");
    if (fp == NULL)
    {
        printf("Error Opening the File\n");
        return 1;
    }
    printf("File opened successfully\n");

    // WRITE INTO THE FILE
    fputc('A', fp);
    fputc('B', fp);
    fputc('C', fp);
    fputc('D', fp);

    // CLOSE THE FILE
    fclose(fp);

    // OPEN THE FILE
    fp = fopen("letters.txt", "r");
    if (fp == NULL){
        printf("Error Opening the File\n");
        return 1;
    }

    printf("File opened successfully for reading\n");
    // READ FROM THE FILE
    char ch;
    while ((ch = fgetc(fp)) != EOF) {
        printf("%c ", ch);
    }

    // CLOSE THE FILE

    fclose(fp);
}