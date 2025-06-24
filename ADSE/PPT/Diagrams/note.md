# Class Note: System Analysis and Diagramming Techniques (Session 10)

## Overview
System analysis involves modeling processes to design effective software solutions. This session introduces four diagramming techniques—**Flowcharts**, **Data Flow Diagrams (DFDs)**, **HIPO Charts**, and **Decision Tables**—used to represent system logic, data flow, hierarchy, and decision-making in popular systems like library management or e-commerce. Through practical activities, you’ll learn to create these diagrams for subsystems, applying structured programming principles. By the end, you’ll be able to design and interpret these diagrams to analyze real-world systems.

## Learning Objectives
- Understand the purpose and components of flowcharts, DFDs, HIPO charts, and decision tables.
- Design flowcharts to model program or process logic.
- Create DFDs to represent data flow in systems/subsystems.
- Develop HIPO charts to illustrate system hierarchy and module details.
- Construct decision tables to outline decision-making rules.
- Apply diagramming techniques to popular systems (e.g., library checkout, online shopping cart).

## Key Concepts
1. **Introduction to System Analysis**
   - **Purpose**: Analyze processes to design software by modeling logic, data flow, hierarchy, and decisions.
   - **Diagrams**: Visual tools for system design and communication.
     - **Flowcharts**: Depict step-by-step logic (e.g., algorithm for checkout).
     - **DFDs**: Show data movement (e.g., order processing).
     - **HIPO Charts**: Illustrate system hierarchy and module functions.
     - **Decision Tables**: Define rules for decisions (e.g., discount eligibility).
   - **Popular Systems**: Library management, e-commerce, inventory control, student registration.

2. **Flowcharts**
   - **Purpose**: Represent algorithms or processes using standard symbols.
   - **Symbols**:
     - **Oval**: Start/End.
     - **Rectangle**: Process/action (e.g., calculate total).
     - **Diamond**: Decision (e.g., if item in stock).
     - **Parallelogram**: Input/Output.
     - **Arrow**: Flow direction.
   - **Example**: Flowchart for validating a library book checkout.
   - **Rules**: Single start/end, clear sequence, consistent symbols.

3. **Data Flow Diagrams (DFDs)**
   - **Definition**: Model how data flows between processes, entities, and stores.
   - **Components**:
     - **External Entity**: Data source/sink (e.g., Customer).
     - **Process**: Transforms data (e.g., Verify Order).
     - **Data Flow**: Arrow showing data movement (e.g., Order Details).
     - **Data Store**: Stores data (e.g., Books Database).
   - **Levels**:
     - **Context Diagram (Level 0)**: System overview with external entities.
     - **Level-1 DFD**: Details subprocesses.
   - **Example**: DFD for e-commerce order placement.
   - **Rules**: Clear labels, consistent flow direction, balanced inputs/outputs.

4. **HIPO Charts (Hierarchy plus Input-Process-Output)**
   - **Purpose**: Show system hierarchy and module details (top-down design).
   - **Components**:
     - **Hierarchy Chart**: Tree diagram of modules (e.g., Main → Checkout → Validate).
     - **IPO Chart**: For each module, lists:
       - **Input**: Data received (e.g., MemberID).
       - **Process**: Actions performed (e.g., Check validity).
       - **Output**: Data produced (e.g., Validation result).
   - **Example**: HIPO chart for library reservation system.
   - **Rules**: Clear module breakdown, detailed IPO for each module.

5. **Decision Tables**
   - **Purpose**: Define decision-making rules based on conditions and actions.
   - **Components**:
     - **Conditions**: Criteria (e.g., Order > $100, VIP Customer).
     - **Actions**: Outcomes (e.g., Apply 10% discount).
     - **Rules**: Combinations of conditions and corresponding actions.
   - **Structure**:
     - Table with condition stubs, action stubs, condition entries (Y/N), action entries (X).
   - **Example**: Decision table for e-commerce discount eligibility.
   - **Rules**: Cover all condition combinations, avoid ambiguity.

6. **Applying Diagrams to Systems**
   - **Modularity**: Break systems into subsystems (e.g., library checkout, e-commerce payment).
   - **Top-Down Design**: Start with high-level (context DFD, hierarchy chart), refine details (Level-1 DFD, IPO).
   - **Integration**: Diagrams guide coding (e.g., flowchart to pseudocode).
   - **Real-World Systems**:
     - Library: Checkout, return, reservation.
     - E-commerce: Cart, payment, order tracking.

## Examples
1. **Flowchart: Library Book Return**
   - **Problem**: Design a flowchart for returning a book (input book ID, check if borrowed, update status).
   - **Flowchart** (text-based):
     ```
     [Start] → [Input BookID] → [Is BookID valid?] → Yes → [Is Book borrowed?] → Yes → [Update Status to Available] → [Output "Book returned"] → [End]
                                     ↓ No                                  ↓ No
                                  [Output "Invalid BookID"] → [End]      [Output "Not borrowed"] → [End]
     ```
   - **Pseudocode** (for reference):
     ```
     START
     INPUT BookID
     IF BookID EXISTS IN Books THEN
         IF BookStatus = "Borrowed" THEN
             SET BookStatus = "Available"
             OUTPUT "Book returned"
         ELSE
             OUTPUT "Not borrowed"
         END IF
     ELSE
         OUTPUT "Invalid BookID"
     END IF
     END
     ```
   - **Explanation**: Uses decision diamonds for validation and rectangles for actions, modeling the return process.

2. **Context DFD: E-commerce Payment System**
   - **Problem**: Create a context DFD for processing payments in an e-commerce system.
   - **DFD** (text-based):
     ```
     [Customer] → (Payment Details) → [Payment Processing System] → (Payment Confirmation) → [Customer]
                                      ↓ (Order Update) ↓
                                    [Orders Database]
     ```
   - **Explanation**: Shows Customer sending payment details, processed by the system, updating the order database, and confirming payment.

3. **HIPO Chart: Library Reservation System**
   - **Problem**: Design a HIPO chart for reserving a book.
   - **Hierarchy Chart** (text-based):
     ```
                [Library System]
                     |
               [Reservation Module]
                     |
     --------------------------------
     |               |              |
 [Validate Member] [Check Book] [Reserve Book]
     ```
   - **IPO Chart for Validate Member**:
     ```
     Input: MemberID
     Process: Check if MemberID exists in Members database
     Output: Valid/Invalid status
     ```
   - **Explanation**: The hierarchy chart shows module structure; the IPO chart details inputs, processes, and outputs for one module.

4. **Decision Table: E-commerce Discount Eligibility**
   - **Problem**: Create a decision table for discounts based on order amount and customer status.
   - **Decision Table**:
     ```
     Conditions        | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------|--------|--------|--------|--------|
     Order > $100      | Y      | Y      | N      | N      |
     VIP Customer      | Y      | N      | Y      | N      |
     Actions           |        |        |        |        |
     Apply 20% Discount| X      |        |        |        |
     Apply 10% Discount|        | X      | X      |        |
     No Discount       |        |        |        | X      |
     ```
   - **Explanation**: Defines rules: 20% discount for VIPs with orders > $100, 10% for others with orders > $100 or VIPs, none otherwise.

## Classwork Activities
1. **Flowchart Design**:
   - **Task**: Design a flowchart for an e-commerce order validation process (input order, check stock, confirm if valid).
   - **Expected Flowchart** (text-based):
     ```
     [Start] → [Input OrderID] → [Is OrderID valid?] → Yes → [Are items in stock?] → Yes → [Confirm Order] → [Output "Order confirmed"] → [End]
                                      ↓ No                                  ↓ No
                                   [Output "Invalid OrderID"] → [End]     [Output "Out of stock"] → [End]
     ```
   - **Objective**: Practice flowchart symbols and decision logic.

2. **DFD Creation**:
   - **Task**: Create a Level-1 DFD for a library checkout subsystem (validate member, check book, issue book).
   - **Expected DFD** (text-based):
     ```
     [Member] → (Checkout Request) → [1.1 Validate Member] → (Valid Member) → [1.2 Check Book] → (Available Book) → [1.3 Issue Book] → (Issue Confirmation) → [Member]
     ↓                               ↓ (Member Data) ↑               ↓ (Book Data) ↓                 ↓ (Loan Data) ↓
     [Members DB]                  [Members DB]                     [Books DB]                      [Loans DB]
     ```
   - **Objective**: Model data flows and subprocesses.

3. **HIPO Chart Development**:
   - **Task**: Design a HIPO chart for an e-commerce cart management subsystem (add item, update quantity, remove item).
   - **Expected Hierarchy Chart** (text-based):
     ```
                [Cart Management]
                        |
        --------------------------------
        |              |               |
     [Add Item]    [Update Quantity] [Remove Item]
     ```
   - **Expected IPO Chart for Add Item**:
     ```
     Input: ItemID, Quantity
     Process: Validate ItemID, check stock, add to cart
     Output: Updated cart, confirmation message
     ```
   - **Objective**: Understand system hierarchy and module details.

4. **Decision Table Design**:
   - **Task**: Create a decision table for a library fine system (fine based on days late and member type).
   - **Expected Decision Table**:
     ```
     Conditions        | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------|--------|--------|--------|--------|
     Days Late > 7   | Y      | Y      | N      | N      |
     Student Member    | Y      | N      | Y      | N      |
     Actions           |        |        |        |        |
     Fine $5           | X      |        |        |        |
     Fine $2           |        | X      | X      |        |
     No Fine           |        |        |        | X      |
     ```
   - **Objective**: Practice rule-based decision modeling.

5. **Group Activity: Subsystem Analysis**:
   - **Task**: In pairs, choose a subsystem (e.g., library reservation, e-commerce payment) and create:
     - A flowchart for the process logic.
     - A context DFD showing data flow.
     - A HIPO chart for module hierarchy.
     - A decision table for a key decision (e.g., payment approval).
   - **Example (Library Reservation)**:
     - **Flowchart**:
       ```
       [Start] → [Input MemberID, BookID] → [Is MemberID valid?] → Yes → [Is Book available?] → Yes → [Reserve Book] → [Output "Reserved"] → [End]
                                           ↓ No                                  ↓ No
                                        [Output "Invalid ID"] → [End]          [Output "Not available"] → [End]
       ```
     - **Context DFD**:
       ```
       [Member] → (Reservation Request) → [Reservation System] → (Reservation Confirmation) → [Member]
       ↓ (Book Update) → [Books DB]
       ```
     - **HIPO Hierarchy Chart**:
       ```
                [Reservation]
                     ↓
       [Validate Member]  [Check Book]  [Reserve Book]
       ```
       - **IPO for Reserve Book**:
         ```
         Input: BookID
         Process: Update reservation status
         Output: Confirmation message
         ```
     - **Decision Table** (Reservation Eligibility):
       ```
       Conditions       | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
       -----------------|--------|--------|--------|--------|
       Member Valid     | Y      | Y      | N      | N      |
       Book Available   | Y      | N      | Y      | N      |
       Actions          |        |        |        |        |
       Reserve Book     | X      |        |        |        |
       Notify Unavailable|        | X      |        |        |
       Notify Invalid   |        |        | X      | X      |
       ```
   - **Discussion**: Present diagrams and explain their role in system design.

## Objective Questions (Multiple Choice)
Test your understanding of system analysis and diagramming techniques:

1. **What is the primary purpose of a flowchart?**
   - A. Show data flow
   - B. Represent process logic
   - C. Define system hierarchy
   - D. Outline decision rules
   - **Answer**: B
   - **Explanation**: Flowcharts model step-by-step logic. DFDs show data flow (A), HIPO charts define hierarchy (C), and decision tables outline rules (D).

2. **Which flowchart symbol represents input/output?**
   - A. Diamond
   - B. Rectangle
   - C. Parallelogram
   - D. Oval
   - **Answer**: C
   - **Explanation**: Parallelograms represent input/output. Diamonds are decisions (A), rectangles are processes (B), and ovals are start/end (D).

3. **In a DFD, what does a data store represent?**
   - A. A process
   - B. A database or file
   - C. An external entity
   - D. A decision
   - **Answer**: B
   - **Explanation**: Data stores (e.g., Books DB) represent storage. Processes transform data (A), entities provide/receive data (C), and decisions are in flowcharts (D).

4. **What does a context DFD show?**
   - A. Subprocesses
   - B. System overview with external entities
   - C. Module hierarchy
   - D. Decision rules
   - **Answer**: B
   - **Explanation**: Context DFDs show the system and external entities. Level-1 DFDs show subprocesses (A), HIPO charts show hierarchy (C), and decision tables show rules (D).

5. **What is the purpose of a HIPO chart’s hierarchy chart?**
   - A. Show data flow
   - B. Detail input-process-output
   - C. Illustrate module structure
   - D. Define decision logic
   - **Answer**: C
   - **Explanation**: Hierarchy charts show module breakdown. IPO charts detail input-process-output (B), DFDs show data flow (A), and decision tables define logic (D).

6. **In a decision table, what are condition entries?**
   - A. Actions to take
   - B. Y/N values for conditions
   - C. Data flows
   - D. Module names
   - **Answer**: B
   - **Explanation**: Condition entries (Y/N) specify condition states. Actions are outcomes (A), data flows are in DFDs (C), and modules are in HIPO charts (D).

7. **Which diagram is best for modeling an e-commerce payment process’s data flow?**
   - A. Flowchart
   - B. DFD
   - C. HIPO chart
   - D. Decision table
   - **Answer**: B
   - **Explanation**: DFDs model data flow (e.g., payment details to confirmation). Flowcharts model logic (A), HIPO charts show hierarchy (C), and decision tables show rules (D).

8. **What does an IPO chart describe for a module?**
   - A. Decision rules
   - B. Input, process, and output
   - C. Data flow
   - D. Process logic
   - **Answer**: B
   - **Explanation**: IPO charts list input, process, and output for a module. Decision tables show rules (A), DFDs show data flow (C), and flowcharts show logic (D).

9. **Which diagram would you use to decide discounts in an e-commerce system?**
   - A. Flowchart
   - B. DFD
   - C. Decision table
   - D. HIPO chart
   - **Answer**: C
   - **Explanation**: Decision tables define rules for decisions (e.g., discounts). Flowcharts show logic (A), DFDs show data flow (B), and HIPO charts show hierarchy (D).

10. **Why use a Level-1 DFD?**
    - A. Show system overview
    - B. Detail subprocesses
    - C. Define module hierarchy
    - D. Outline decision rules
    - **Answer**: B
    - **Explanation**: Level-1 DFDs break down processes into subprocesses. Context DFDs show the overview (A), HIPO charts define hierarchy (C), and decision tables outline rules (D).

## Homework
1. **Flowchart Practice**:
   - Design a flowchart for a student grade calculation process (input marks, validate, compute average).
2. **DFD Development**:
   - Create a context DFD for a library book reservation system (Member reserves Book, system updates records).
3. **HIPO Chart Design**:
   - Develop a HIPO chart for an inventory restocking subsystem (check stock, order items, update inventory).
4. **Decision Table Creation**:
   - Create a decision table for a library membership renewal (based on payment status and membership type).
5. **Real-World Application**:
   - Choose a system (e.g., online shopping). Write a paragraph describing a subsystem and create one diagram (flowchart, DFD, HIPO chart, or decision table).

## Additional Notes
- **Teaching Tips**:
  - **Duration**: 2–3 class periods (3–4.5 hours).
    - **Period 1**: Flowcharts, Example 1, Activity 1.
    - **Period 2**: DFDs, HIPO charts, Examples 2 and 3, Activities 2 and 3.
    - **Period 3**: Decision tables, Example 4, Activities 4 and 5, review.
  - **Visual Aids**: Provide symbol templates for flowcharts/DFDs; use whiteboards for HIPO charts.
  - **Engagement**: Use relatable systems (e.g., library, e-commerce) to make diagrams accessible.
  - **Differentiation**:
    - Beginners: Focus on flowchart basics and context DFDs.
    - Advanced: Create Level-2 DFDs or combine diagrams for a complex system.
- **Resources**:
  - Diagramming tools: Draw.io, Lucidchart, Microsoft Visio.
  - Paper templates for flowchart symbols, DFD components, and decision tables.
- **Assessment**:
  - Grade classwork for correct symbol usage, data flow, hierarchy, and rule clarity.
  - Use objective questions for quizzes or homework.
- **Extension**:
  - Convert a flowchart to pseudocode:
    ```pseudocode
    START
    INPUT OrderID
    IF OrderID EXISTS THEN
        IF AllItemsInStock THEN
            OUTPUT "Order confirmed"
        ELSE
            OUTPUT "Out of stock"
        END IF
    ELSE
        OUTPUT "Invalid OrderID"
    END IF
    END
    ```
- **Connections**:
  - Builds on Sessions 7–9 (structured programming, subroutines, strings) for system modeling.
  - Prepares for Sessions 11 (file handling) and 12 (advanced concepts) by providing design blueprints.