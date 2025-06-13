# Objective and Practical Questions for Programming in C (Sessions 1-5)

## Objective Questions (Multiple Choice)

1. **What is the primary purpose of an algorithm in programming?**  
   a) To execute a program  
   b) To provide a step-by-step solution to a problem  
   c) To debug code  
   d) To store data  

2. **Which symbol in a flowchart represents a decision point?**  
   a) Rectangle  
   b) Oval  
   c) Diamond  
   d) Parallelogram  

3. **What is a pseudocode?**  
   a) A low-level programming language  
   b) A high-level description of a program in plain language  
   c) A compiled code  
   d) A type of flowchart  

4. **Which of the following is NOT a constituent of a programming language?**  
   a) Syntax  
   b) Semantics  
   c) Hardware  
   d) Data types  

5. **In C, which keyword is used to declare a variable?**  
   a) var  
   b) int  
   c) define  
   d) let  

6. **What is the correct syntax for a single-line comment in C?**  
   a) /* Comment */  
   b) // Comment  
   c) # Comment  
   d) <!-- Comment -->  

7. **Which data type in C is used to store a single character?**  
   a) int  
   b) float  
   c) char  
   d) double  

8. **What is the output of the expression `5 + 3 * 2` in C?**  
   a) 16  
   b) 11  
   c) 13  
   d) 10  

9. **Which operator is used to assign a value to a variable in C?**  
   a) ==  
   b) =  
   c) !=  
   d) +=  

10. **What does the `scanf()` function do in C?**  
    a) Prints output to the console  
    b) Reads input from the user  
    c) Declares a variable  
    d) Performs arithmetic operations  

11. **Which operator has the highest precedence in C?**  
    a) Addition (+)  
    b) Multiplication (*)  
    c) Assignment (=)  
    d) Logical AND (&&)  

12. **What is the purpose of the `printf()` function in C?**  
    a) To read input  
    b) To display output  
    c) To declare variables  
    d) To perform loops  

13. **Which of the following is a relational operator in C?**  
    a) &&  
    b) ||  
    c) >  
    d) !  

14. **What will be the value of `x` after the expression `x = 10 / 3` in C, where `x` is an integer?**  
    a) 3.33  
    b) 3  
    c) 4  
    d) 10  

15. **Which selection construct is used to execute a block of code based on multiple conditions?**  
    a) if  
    b) switch-case  
    c) for  
    d) while  

16. **What is the output of the following code?**  
    ```c
    int x = 5;
    if (x > 3) {
        printf("Greater");
    } else {
        printf("Smaller");
    }
    ```  
    a) Greater  
    b) Smaller  
    c) Error  
    d) No output  

17. **Which loop in C executes at least once regardless of the condition?**  
    a) for  
    b) while  
    c) do-while  
    d) nested if  

18. **What does the `break` statement do in a loop?**  
    a) Exits the program  
    b) Skips the current iteration  
    c) Terminates the loop  
    d) Restarts the loop  

19. **What is the correct syntax for a `for` loop in C?**  
    a) for (initialization; condition; update)  
    b) for (condition; initialization; update)  
    c) for (update; condition; initialization)  
    d) for (initialization; update; condition)  

20. **Which function is used to read a single character from the input in C?**  
    a) scanf()  
    b) getchar()  
    c) printf()  
    d) putchar()  

## Practical Questions (Coding)

1. **Write a C program to print "Hello, World!" to the console.**  
   - Use the `printf()` function to display the output.

2. **Write a C program to calculate the sum of two integers entered by the user.**  
   - Use `scanf()` to read two integers and `printf()` to display their sum.

3. **Write a C program to check if a number entered by the user is even or odd.**  
   - Use the modulo operator (`%`) and an `if-else` statement to determine if the number is even or odd.

4. **Write a C program to print the first 10 natural numbers using a `for` loop.**  
   - Use a `for` loop to iterate from 1 to 10 and print each number.

5. **Write a C program to calculate the factorial of a number entered by the user.**  
   - Use a `while` loop to compute the factorial and handle non-negative input.

## Answers to Objective Questions

1. b) To provide a step-by-step solution to a problem  
2. c) Diamond  
3. b) A high-level description of a program in plain language  
4. c) Hardware  
5. b) int  
6. b) // Comment  
7. c) char  
8. b) 11 (Multiplication has higher precedence than addition: 5 + (3 * 2) = 5 + 6 = 11)  
9. b) =  
10. b) Reads input from the user  
11. b) Multiplication (*)  
12. b) To display output  
13. c) >  
14. b) 3 (Integer division truncates decimal part: 10 / 3 = 3)  
15. b) switch-case  
16. a) Greater  
17. c) do-while  
18. c) Terminates the loop  
19. a) for (initialization; condition; update)  
20. b) getchar()  

## Answers to Practical Questions

1. **Hello, World! Program**  
```c
#include <stdio.h>
int main() {
    printf("Hello, World!\n");
    return 0;
}
```

2. **Sum of Two Integers**  
```c
#include <stdio.h>
int main() {
    int a, b, sum;
    printf("Enter two integers: ");
    scanf("%d %d", &a, &b);
    sum = a + b;
    printf("Sum: %d\n", sum);
    return 0;
}
```

3. **Check Even or Odd**  
```c
#include <stdio.h>
int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    if (num % 2 == 0) {
        printf("%d is even.\n", num);
    } else {
        printf("%d is odd.\n", num);
    }
    return 0;
}
```

4. **Print First 10 Natural Numbers**  
```c
#include <stdio.h>
int main() {
    for (int i = 1; i <= 10; i++) {
        printf("%d ", i);
    }
    printf("\n");
    return 0;
}
```

5. **Calculate Factorial**  
```c
#include <stdio.h>
int main() {
    int num;
    unsigned long long factorial = 1;
    printf("Enter a non-negative number: ");
    scanf("%d", &num);
    if (num < 0) {
        printf("Factorial is not defined for negative numbers.\n");
    } else {
        int i = 1;
        while (i <= num) {
            factorial *= i;
            i++;
        }
        printf("Factorial of %d is %llu\n", num, factorial);
    }
    return 0;
}
```