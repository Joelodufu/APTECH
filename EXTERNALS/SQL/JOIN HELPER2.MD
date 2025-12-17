

## 🧩 Base Tables

### **Table A (Students)**

| student_id | name  | class_id |
| ---------- | ----- | -------- |
| 1          | Mary  | 101      |
| 2          | John  | 102      |
| 3          | Grace | 103      |

### **Table B (Classes)**

| class_id | class_name |
| -------- | ---------- |
| 101      | Math       |
| 102      | English    |
| 104      | Biology    |

---

## 🔹 1️⃣ INNER JOIN → Intersection (A ∩ B)

👉 Returns only rows with matching `class_id` in both tables.

| **Table A (Students)** | **Table B (Classes)** | **Result (A INNER JOIN B)** |
| ---------------------- | --------------------- | --------------------------- |
| Mary → 101             | 101 → Math            | Mary → 101 → Math           |
| John → 102             | 102 → English         | John → 102 → English        |
| Grace → 103            | 104 → Biology         | ❌ No Match → Not included   |

✅ **Only matching rows** appear (101 and 102).

---

## 🔹 2️⃣ LEFT JOIN → Left + Intersection (A ∪ (A ∩ B))

👉 Returns **all rows from A**, and matched ones from B.
If no match, B’s side becomes **NULL**.

| **Table A (Students)** | **Table B (Classes)** | **Result (A LEFT JOIN B)** |
| ---------------------- | --------------------- | -------------------------- |
| Mary → 101             | 101 → Math            | Mary → 101 → Math          |
| John → 102             | 102 → English         | John → 102 → English       |
| Grace → 103            | ❌ Not found           | Grace → 103 → NULL         |

✅ Every row from **A** is kept.
Unmatched (`103`) shows **NULL**.

---

## 🔹 3️⃣ RIGHT JOIN → Right + Intersection (B ∪ (A ∩ B))

👉 Returns **all rows from B**, and matched ones from A.
If no match, A’s side becomes **NULL**.

| **Table A (Students)** | **Table B (Classes)** | **Result (A RIGHT JOIN B)** |
| ---------------------- | --------------------- | --------------------------- |
| Mary → 101             | 101 → Math            | Mary → 101 → Math           |
| John → 102             | 102 → English         | John → 102 → English        |
| ❌ Not found            | 104 → Biology         | NULL → 104 → Biology        |

✅ Every row from **B** is kept.
Unmatched (`104`) shows **NULL** from A.

---

## 🔹 4️⃣ FULL JOIN → Union (A ∪ B)

👉 Combines results of LEFT JOIN and RIGHT JOIN.
Shows **all rows** from both — matched or not.

| **Table A (Students)** | **Table B (Classes)** | **Result (A FULL JOIN B)** |
| ---------------------- | --------------------- | -------------------------- |
| Mary → 101             | 101 → Math            | Mary → 101 → Math          |
| John → 102             | 102 → English         | John → 102 → English       |
| Grace → 103            | ❌ Not found           | Grace → 103 → NULL         |
| ❌ Not found            | 104 → Biology         | NULL → 104 → Biology       |

✅ Includes **everything** — matched or not.

🟡 MySQL doesn’t directly support `FULL JOIN`, but you can simulate it using `UNION` of LEFT + RIGHT JOINs.

---

## 🔹 5️⃣ CROSS JOIN → Cartesian Product (A × B)

👉 Matches **every row in A** with **every row in B**.
If A has 3 rows and B has 3 rows → 3 × 3 = 9 results.

| **Table A (Students)** | **Table B (Classes)** | **Result (A CROSS JOIN B)** |
| ---------------------- | --------------------- | --------------------------- |
| Mary → 101             | 101 → Math            | Mary → 101 → Math           |
| Mary → 101             | 102 → English         | Mary → 102 → English        |
| Mary → 101             | 104 → Biology         | Mary → 104 → Biology        |
| John → 102             | 101 → Math            | John → 101 → Math           |
| John → 102             | 102 → English         | John → 102 → English        |
| John → 102             | 104 → Biology         | John → 104 → Biology        |
| Grace → 103            | 101 → Math            | Grace → 101 → Math          |
| Grace → 103            | 102 → English         | Grace → 102 → English       |
| Grace → 103            | 104 → Biology         | Grace → 104 → Biology       |

✅ All possible combinations are shown.
🧨 Be careful — it can produce a *huge* result set.

---

## 🎯 Summary Table (Quick Recap)

| Join Type      | Returns                  | Missing Side Fills           |
| -------------- | ------------------------ | ---------------------------- |
| **INNER JOIN** | Only matching rows       | Excludes non-matching        |
| **LEFT JOIN**  | All from left + matches  | NULL for right               |
| **RIGHT JOIN** | All from right + matches | NULL for left                |
| **FULL JOIN**  | All from both sides      | NULL for both sides          |
| **CROSS JOIN** | All combinations         | None (every row matches all) |

---
