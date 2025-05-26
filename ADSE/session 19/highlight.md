## 📘 **Class Notes: Passing Structures in C (By Value vs By Reference)**

### 🔹 Introduction

In C, structures (`struct`) are used to group related variables together under one name. When you pass a structure to a function, it can be done **by value** or **by reference**, just like basic data types.

---

### 🧪 **1. Passing Structures by Value**

```c
void update(struct Point p);
```

* The function gets a **copy** of the structure.
* Any modification inside the function does **not affect** the original structure in `main`.

**Example:**

```c
struct Point {
    int x, y;
};

void movePoint(struct Point p) {
    p.x += 10;
    p.y += 10;
}
```

> ✅ Used when you don’t want the function to modify the original data.

---

### 🔧 **2. Passing Structures by Reference**

```c
void update(struct Point *p);
```

* The function receives the **memory address** of the structure.
* Modifications **do affect** the original structure.
* Use `->` to access members.

**Example:**

```c
void movePoint(struct Point *p) {
    p->x += 10;
    p->y += 10;
}
```

> ✅ Used when you want the function to modify the original structure or avoid copying large data.

---

### 🧠 Key Differences

| Feature            | By Value                | By Reference             |
| ------------------ | ----------------------- | ------------------------ |
| What is passed     | A copy of the structure | Address of the structure |
| Original modified? | ❌ No                    | ✅ Yes                    |
| Memory use         | More (due to copying)   | Less (no copy)           |
| Access syntax      | `p.x`                   | `p->x`                   |

---

### ✅ Best Practice

* Use **pass-by-value** for small, read-only structures.
* Use **pass-by-reference** for large structures or when you need to modify the original.

---

### 🧪 Practice Exercise

```c
struct Student {
    int id;
    float grade;
};

void updateGrade(struct Student *s);
```

* Write the full function to increase the student's grade by 5.
* In `main`, declare a `Student` and call `updateGrade`.

---
