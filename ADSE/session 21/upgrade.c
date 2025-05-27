#include <stdio.h>

typedef struct{
    int id;
    float grade;
} Student;

void upgrade(Student *s, float by){
    s->grade += by;// Upgrade the grade by the specified amount
}

int main(){
    Student s1 = {1, 75.0};
    printf("Before upgrade: ID = %d, Grade = %\n", s1.id, s1.grade);
    upgrade(&s1, 5.0);
    printf("After upgrade: ID = %d, Grade = %\n", s1.id, s1.grade);
    return 0;
}