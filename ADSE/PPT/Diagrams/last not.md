Let’s walk through the most **common system design tools** We have learnt, explain **what they do**, and **when to use each one**.

---

## 🔁 OVERVIEW TABLE

| **Tool**                             | **Purpose**                                                   | **When to Use**                                                     |
| ------------------------------------ | ------------------------------------------------------------- | ------------------------------------------------------------------- |
| **DFD (Data Flow Diagram)**          | Shows how **data flows** in a system                          | When analyzing **processes & data movement**                        |
| **System Flowchart**                 | Shows **physical or logical flow** of information and actions | When mapping **system operations or hardware/software interaction** |
| **Decision Table**                   | Lists all possible **conditions and actions**                 | When rules or decisions are **complex**                             |
| **HIPO Chart**                       | Breaks system into **modules** and shows their inputs/outputs | During **planning and modular design**                              |
| **ER Diagram (Entity-Relationship)** | Describes how **data entities** are related in a database     | When designing the **database structure**                           |

---

## 🔍 DETAILED BREAKDOWN

---

### 1. ✅ **DFD – Data Flow Diagram**

- **What it shows:**
  How data moves through the system, between users, processes, and storage.

- **Best For:**
  Understanding the **functional flow** of data, especially in early system analysis.

- **When to use:**

  - During requirement gathering
  - When showing how data is input, processed, and stored
  - When you want a **logical view** of the system

---

### 2. 🔄 **System Flowchart**

- **What it shows:**
  The **sequence** of operations in a system — including **decisions**, **data inputs**, and **outputs**.

- **Best For:**
  Explaining **how the system runs** (especially in legacy or detailed technical diagrams).

- **When to use:**

  - To document system **logic**
  - For **hardware/software interaction** diagrams
  - During **implementation** or when improving existing processes

---

### 3. 🧠 **Decision Table**

- **What it shows:**
  A matrix of all possible **conditions and corresponding actions**.

- **Best For:**
  Business rules or program logic with **lots of combinations**.

- **When to use:**

  - When decisions are based on **multiple conditions**
  - In **testing**, validation, and rules automation

---

### 4. 🏗️ **HIPO Chart (Hierarchy + IPO)**

- **What it shows:**
  Program is broken into **modules**, each showing its **Input, Process, Output**.

- **Best For:**
  Planning **structured programs** or systems.

- **When to use:**

  - Early in design phase
  - To **break a big system** into manageable pieces
  - When documenting or explaining **modular logic**

---

### 5. 🗃️ **ER Diagram – Entity-Relationship Diagram**

- **What it shows:**
  **Entities (tables)**, their **attributes**, and **relationships**.

- **Best For:**
  Designing and understanding a **relational database**.

- **When to use:**

  - During **database design**
  - When analyzing relationships between data types
  - To prepare for implementation in SQL or NoSQL systems

---

## ✅ FINAL RECOMMENDATION — When to Use What:

| **Phase**                   | **Best Tools**                           |
| --------------------------- | ---------------------------------------- |
| **Requirement Gathering**   | DFD, System Flowchart                    |
| **System Analysis**         | DFD, Decision Table, ER Diagram          |
| **Design Phase**            | HIPO Chart, ER Diagram, System Flowchart |
| **Implementation Planning** | HIPO Chart, Decision Table, Flowchart    |
| **Database Design**         | ER Diagram                               |
| **Testing & Validation**    | Decision Table, DFD                      |

---

## 🧠 Summary Quote for Students:

> "**DFD** shows how data moves,
> **ER Diagram** shows how data is structured,
> **Flowcharts** show how the system runs,
> **Decision tables** show rule logic,
> **HIPO** shows what each module does."

---
