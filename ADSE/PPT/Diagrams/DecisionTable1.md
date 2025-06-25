# **DECISION TABLE**

## ✅ What is a **Decision Table**?

A **Decision Table** is a **tool** used to model **complicated decision logic** in a simple table format.

Think of it like a **rule-based chart** that tells you:

> “If these conditions are met → then do this action.”

It’s commonly used in **software engineering**, **business rules**, and **testing**.

---

### 🌟 Basic Parts of a Decision Table

A decision table has 4 parts:

| **Conditions** | **Rule 1** | **Rule 2** | ... |
| -------------- | ---------- | ---------- | --- |
| Condition 1    | Y/N        | Y/N        | ... |
| Condition 2    | Y/N        | Y/N        | ... |
| **Actions**    |            |            |     |
| Action 1       | X          |            | ... |
| Action 2       |            | X          | ... |

---

### ✅ Example: Simple Login System

Let’s say we have a login system with these rules:

* Condition 1: Username is valid
* Condition 2: Password is valid
* Action 1: Allow login
* Action 2: Show error

Let’s build the table:

| Conditions        | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
| ----------------- | ------ | ------ | ------ | ------ |
| Username is valid | Y      | Y      | N      | N      |
| Password is valid | Y      | N      | Y      | N      |
| **Actions**       |        |        |        |        |
| Allow login       | X      |        |        |        |
| Show error        |        | X      | X      | X      |

🧠 Explain:

* Only Rule 1 allows login.
* Every other rule shows an error.

---

### ✅ Why Use Decision Tables?

* ✅ Easy to **understand** and explain logic.
* ✅ Helps avoid **missing cases**.
* ✅ Good for **testing** and **automating decisions**.
* ✅ Makes logic **visible** to both tech and non-tech people.

---

### 🧠 Class Tip: Teach It Like a Story

Say:

> Imagine you're a bouncer at a club.
> You check two things:
>
> * ID is real (condition 1)
> * Person is on the guest list (condition 2)

If both are true → Let them in (Action 1)
Else → Send them away (Action 2)

Make a table with the 4 possibilities and actions, and boom — they get it.

---

### 📝 Student Exercise

Have students make a decision table for:

**ATM Withdrawal**

* Conditions:

  1. Card is valid
  2. PIN is correct
  3. Sufficient balance

* Actions:

  * Allow withdrawal
  * Deny transaction
  * Show insufficient balance

---

### Summary Cheatsheet:

| Section    | Purpose                              |
| ---------- | ------------------------------------ |
| Conditions | Input facts or checks                |
| Rules      | All combinations of condition values |
| Actions    | What to do if the rule is true       |

---