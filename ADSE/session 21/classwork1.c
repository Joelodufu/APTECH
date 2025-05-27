#include <stdio.h>

int main(){
    FILE *fp;
    char data[]="My First File Handling in C";

    // Open file in write mode
    fp = fopen("newfile.txt", "w");
    if(fp==NULL){
        printf("Error Opening the File\n");
        return 1;
    }

    // Write data to the file
    fprintf(fp, "%s", data);

    // Close the file
    fclose(fp);
    printf("Data written successfully to newfile.txt\n");

    

    return 0;
}