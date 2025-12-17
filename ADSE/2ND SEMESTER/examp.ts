interface Student{
    name: string;
    age: number;
    grade: string;
    isGraduated: boolean;
    courses: string[];
    address: {  
        street: string;
        city: string;
        state: string;
        zipCode: string;
    };
    getDetails: () => string;
    register: () => void;
    attendClass: (courseName: string) => void;
    submitAssignment: (courseName: string, assignmentName: string) => void;
    takeExam: (courseName: string) => void;
    graduate: () => void;
    enrollInCourse: (courseName: string) => void;
    dropCourse: (courseName: string) => void;
}