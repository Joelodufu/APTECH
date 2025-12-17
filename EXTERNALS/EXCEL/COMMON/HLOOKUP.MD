## 💡 What is VLOOKUP?

**VLOOKUP** means **Vertical Lookup**.
It’s an Excel formula that helps you **find something in one column** and **bring back related information from another column** in the same table.

---

## 📘 Real-life Example

Imagine you have this small table 👇

| Student | Score |
| ------- | ----- |
| John    | 85    |
| Mary    | 92    |
| Peter   | 78    |

And in another cell, you type “Mary”.
You want Excel to tell you **Mary’s score** automatically.

That’s what **VLOOKUP** does!

---

## 🧠 Formula Format

```
=VLOOKUP(lookup_value, table_array, col_index_num, [range_lookup])
```

Let’s break it down:

| Part             | Meaning                                                 | Example                                 |
| ---------------- | ------------------------------------------------------- | --------------------------------------- |
| `lookup_value`   | What you are searching for                              | "Mary"                                  |
| `table_array`    | Where to search (your table)                            | A2:B4                                   |
| `col_index_num`  | The column number that has the answer                   | 2 (because Score is in 2nd column)      |
| `[range_lookup]` | Tells Excel if you want an **exact** or **close** match | FALSE = exact match, TRUE = close match |

---

## ✅ Example in Action

```
=VLOOKUP("Mary", A2:B4, 2, FALSE)
```

👉 Excel will look for “Mary” in **column A**
👉 Then bring the value from the **2nd column** in that same row
✅ Result: **92**

---

## ⚠️ Important Rules

1. The **lookup value must be in the first column** of your table.

   - (So Excel always looks _vertically down the first column_.)

2. If you use **FALSE**, Excel finds an _exact match_.
3. If you use **TRUE**, Excel finds the _closest match_ (used for numbers like price ranges).
4. **VLOOKUP only looks to the right**, never to the left.

---

## 🧩 Example with Real Data

| ID  | Name  | Department |
| --- | ----- | ---------- |
| 101 | Alice | HR         |
| 102 | Bob   | IT         |
| 103 | Carol | Finance    |

You want to find the department of ID `102`.

Formula:

```
=VLOOKUP(102, A2:C4, 3, FALSE)
```

Explanation:

- Lookup `102`
- In table `A2:C4`
- Bring result from **3rd column** (Department)
  ✅ Output: **IT**

---

## 🪄 Quick Trick

If you type the lookup value in a cell (say `E1` = 102), then use:

```
=VLOOKUP(E1, A2:C4, 3, FALSE)
```

Now it’s dynamic — you can change `E1`, and the answer updates automatically!

---

## 🧮 In Summary

| You Want                              | Use This Formula                    | Remember                |
| ------------------------------------- | ----------------------------------- | ----------------------- |
| Find Mary’s score                     | `=VLOOKUP("Mary", A2:B4, 2, FALSE)` | Exact match             |
| Find ID 102’s department              | `=VLOOKUP(E1, A2:C4, 3, FALSE)`     | Lookup value in cell E1 |
| Approximate match (like grade ranges) | `=VLOOKUP(A1, Table, 2, TRUE)`      | Table must be sorted!   |

---
