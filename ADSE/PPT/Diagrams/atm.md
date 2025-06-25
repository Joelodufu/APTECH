### 💳 **Scenario: ATM Withdrawal**

#### **Conditions**

1. Card is valid?
2. PIN is correct?
3. Sufficient balance?

#### **Actions**

- **A1**: Allow withdrawal
- **A2**: Deny transaction
- **A3**: Show insufficient balance

---

### ✅ **Decision Table: ATM Withdrawal**

| Rule No. | Card Valid | PIN Correct | Balance Sufficient | **A1<br>Allow** | **A2<br>Deny** | **A3<br>Insufficient** |
| -------- | ---------- | ----------- | ------------------ | --------------- | -------------- | ---------------------- |
| Rule 1   | Yes        | Yes         | Yes                | ✅              |                |                        |
| Rule 2   | Yes        | Yes         | No                 |                 |                | ✅                     |
| Rule 3   | Yes        | No          | Yes                |                 | ✅             |                        |
| Rule 4   | Yes        | No          | No                 |                 | ✅             |                        |
| Rule 5   | No         | Yes         | Yes                |                 | ✅             |                        |
| Rule 6   | No         | Yes         | No                 |                 | ✅             |                        |
| Rule 7   | No         | No          | Yes                |                 | ✅             |                        |
| Rule 8   | No         | No          | No                 |                 | ✅             |                        |

---

### 🧠 Explanation

- **Only Rule 1** meets **all** the conditions → Allow withdrawal.
- **Rule 2** has valid card and PIN but **insufficient balance** → Show insufficient balance.
- **All others** fail at least one required step → Deny transaction.

---

## 🧠 Case Study 2: **Online Order Processing**

### 📦 Scenario:

An online shop decides whether to process an order based on:

1. **Item is in stock**
2. **Payment is successful**

### 🎯 Goal:

Use a decision table to determine whether the order should be:

- ✅ Processed
- ❌ Rejected
- ⏳ Placed on Hold

---

## ✍️ Step-by-Step Teaching

### ✅ Step 1: Define the **Conditions**

| #   | Condition              | Values   |
| --- | ---------------------- | -------- |
| 1   | Item is in stock?      | Yes / No |
| 2   | Payment is successful? | Yes / No |

---

### ✅ Step 2: Define the **Actions**

| #   | Action              | Description                      |
| --- | ------------------- | -------------------------------- |
| A1  | Process Order       | Ship the item                    |
| A2  | Reject Order        | Inform customer of failure       |
| A3  | Place Order on Hold | Wait until item is back in stock |

---

### ✅ Step 3: Calculate Number of Rules

There are **2 conditions**, each with 2 values (Yes/No):

👉 **2² = 4 rules**

---

### ✅ Step 4: Build the **Decision Table**

| Rule | Item in Stock | Payment Successful | **A1<br>Process** | **A2<br>Reject** | **A3<br>Hold** |
| ---- | ------------- | ------------------ | ----------------- | ---------------- | -------------- |
| 1    | Yes           | Yes                | ✅                |                  |                |
| 2    | Yes           | No                 |                   | ✅               |                |
| 3    | No            | Yes                |                   |                  | ✅             |
| 4    | No            | No                 |                   | ✅               |                |

---

### 🧠 EXPLAIN:

1. **Rule 1**: Everything is fine → process the order.
2. **Rule 2**: Item is available, but payment failed → reject the order.
3. **Rule 3**: Payment worked, but item is unavailable → put the order on hold.
4. **Rule 4**: Nothing is working → reject the order.

---

### 📝 Exercise:

> Given 3 conditions :
>
> - User is logged in
> - Email is verified
> - Subscription is active

Build a decision table showing whether:

- Access is **granted**
- Access is **denied**
- Prompt for **email verification**

---

### 🎯 Summary:

| **Step**        | **What to Do**                        |
| --------------- | ------------------------------------- |
| List conditions | All Yes/No input checks               |
| List actions    | What should happen in each scenario   |
| Count rules     | Use 2ⁿ where n = number of conditions |
| Fill the table  | Show actions for every rule           |

---
