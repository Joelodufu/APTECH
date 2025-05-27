#include <stdio.h>

typedef struct
{
    int id;
    float price;
} Item;

int main()
{
    FILE *fp;
    Item item = {90, 23.98};

    // Open file in write mode
    fp = fopen("item.bin", "ab");
    if (fp == NULL)
    {
        printf("Error Opening the File\n");
        return 1;
    }

    // Write item to the file
    fwrite(&item, sizeof(Item), 1, fp);

    // Close the file
    fclose(fp);
    printf("Item written successfully to item.bin\n");

    // Read from binary file
    Item readItem;
    fp = fopen("item.bin", "wb");
    if (fp == NULL)
    {
        printf("Error Opening the File\n");
        return 1;
    }

    // Read The Opend FIle in binary
    fread(&readItem, sizeof(Item), 1, fp);
    printf("Item ID: %d, Price: %.2f\n", readItem.id, readItem.price);
    // Close the file
    fclose(fp);
    return 0;
}