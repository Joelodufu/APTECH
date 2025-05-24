#include <stdio.h>
#include <string.h>
typedef struct 
{
    char name[50];
    int emp_id;
    float salary;
} Employee;

void printEmployee(struct Employee *emp)
{
    printf("Employee %d, With the name %s, is paid the sum of: %f\n", emp.emp_id, emp.name, emp.salary);
}

int main()
{
    // creating 2 variables of the same structure
     Employee emp1, emp2;

    // initializing emp1 with different values
    emp1.emp_id = 001;
    emp1.salary = 24000000;
    strcpy(emp1.name, "Tumininu");

     Employee *ptr1 = &emp1;
     Employee *ptr2 = &emp2;
    // initializing emp2 with different values
    emp2.emp_id = 002;
    emp2.salary = 23000000;
    strcpy(emp2.name, "Bashir");

    // Printing details of both employees
    printEmployee(ptr1);
    printEmployee(ptr2);
}
