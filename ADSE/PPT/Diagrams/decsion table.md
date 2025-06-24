# Class Note: Decision Tables (Session 10)

## Overview
Decision tables are powerful tools in system analysis, used to model complex decision-making rules clearly and concisely. They are particularly valuable for defining logic in systems like library management or e-commerce, where decisions depend on multiple conditions (e.g., applying discounts, determining fines). This session provides an in-depth exploration of decision tables, focusing on their structure, creation, and application in real-world systems. Through practical examples and activities, you’ll learn to design decision tables to represent decision logic, ensuring clarity and completeness. By the end, you’ll be able to create and interpret decision tables for subsystems, applying structured programming principles.

## Learning Objectives
- Understand the purpose and structure of decision tables.
- Identify conditions, actions, and rules in decision-making scenarios.
- Construct decision tables for popular systems/subsystems (e.g., library fines, e-commerce discounts).
- Ensure completeness and clarity in decision table design.
- Integrate decision tables with other system analysis tools (e.g., flowcharts, DFDs).
# Class Note: Decision Tables (Session 10)

## Overview
Decision tables are powerful tools in system analysis, used to model complex decision-making rules clearly and concisely. They are particularly valuable for defining logic in systems like library management or e-commerce, where decisions depend on multiple conditions (e.g., applying discounts, determining fines). This session provides an in-depth exploration of decision tables, focusing on their structure, creation, and application in real-world systems. Through practical examples and activities, you’ll learn to design decision tables to represent decision logic, ensuring clarity and completeness. By the end, you’ll be able to create and interpret decision tables for subsystems, applying structured programming principles.

## Learning Objectives
- Understand the purpose and structure of decision tables.
- Identify conditions, actions, and rules in decision-making scenarios.
- Construct decision tables for popular systems/subsystems (e.g., library fines, e-commerce discounts).
- Ensure completeness and clarity in decision table design.
- Integrate decision tables with other system analysis tools (e.g., flowcharts, DFDs).

## Key Concepts
1. **What Are Decision Tables?**
   - **Definition**: A tabular representation of decision-making logic, showing how conditions lead to specific actions.
   - **Purpose**: Simplify complex decisions by listing all possible condition combinations and their outcomes.
   - **Use Cases**: Ideal for systems with multiple conditions (e.g., determining eligibility, calculating fees).
   - **Benefits**:
     - Clarity: Organizes logic in a structured format.
     - Completeness: Ensures all scenarios are covered.
     - Communication: Easy to understand for developers and stakeholders.
   - **Example**: Deciding discounts in an e-commerce system based on order amount and customer status.

2. **Structure of a Decision Table**
   - **Components**:
     - **Condition Stubs**: List conditions to evaluate (e.g., Order > $100).
     - **Condition Entries**: Values for conditions (e.g., Y/N, True/False).
     - **Action Stubs**: List possible actions (e.g., Apply 10% Discount).
     - **Action Entries**: Indicate which actions apply (e.g., marked with X).
   - **Layout**:
     ```
     Conditions   | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------|--------|--------|--------|--------|
     Condition 1  | Y      | Y      | N      | N      |
     Condition 2  | Y      | N      | Y      | N      |
     Actions      |        |        |        |        |
     Action 1     | X      |        |        |        |
     Action 2     |        | X      | X      |        |
     Action 3     |        |        |        | X      |
     ```
   - **Rules**: Each column represents a unique combination of condition outcomes (e.g., Rule 1: both conditions true).

3. **Steps to Create a Decision Table**
   - **Step 1: Identify Conditions**: List all factors affecting the decision (e.g., Is customer VIP? Is order > $100?).
   - **Step 2: Determine Actions**: List possible outcomes (e.g., Apply discount, Reject order).
   - **Step 3: Calculate Rules**: For *n* conditions, there are 2^n rules (e.g., 2 conditions → 4 rules).
   - **Step 4: Fill Condition Entries**: Use Y/N or True/False for each rule.
   - **Step 5: Specify Action Entries**: Mark actions (X) for each rule.
   - **Step 6: Optimize**: Combine redundant rules or simplify conditions.
   - **Example**: For 2 conditions, create 2^2 = 4 rules covering all combinations (YY, YN, NY, NN).

4. **Rules for Effective Decision Tables**
   - **Completeness**: Include all possible condition combinations.
   - **Consistency**: Avoid conflicting actions for the same conditions.
   - **Clarity**: Use concise, clear labels for conditions and actions.
   - **Modularity**: Break complex decisions into smaller tables if needed.
   - **Validation**: Cross-check with stakeholders to ensure accuracy.

5. **Integration with Other Diagrams**
   - **Flowcharts**: Decision tables can be translated into flowchart decisions (e.g., if-then-else logic).
   - **DFDs**: Define processes in DFDs that use decision table logic (e.g., Process Payment → Discount Decision).
   - **HIPO Charts**: Decision tables detail the process step in IPO charts.
   - **Example**: A decision table for library fines can inform a flowchart for the fine calculation process.

6. **Applications in Real-World Systems**
   - **Library Management**: Determine fines based on days late and member type.
   - **E-commerce**: Apply discounts based on order value and customer status.
   - **Inventory Control**: Decide restocking based on stock level and demand.
   - **Student Registration**: Approve enrollment based on prerequisites and availability.

## Examples
1. **Decision Table: Library Fine Calculation**
   - **Problem**: Determine fines for a returned book based on days late and member type (Student or Regular).
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Days Late > 7      | Y      | Y      | N      | N      |
     Student Member     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Fine $5            | X      |        |        |        |
     Fine $2            |        | X      | X      |        |
     No Fine            |        |        |        | X      |
     ```
   - **Explanation**: 
     - 2 conditions → 2^2 = 4 rules.
     - Rule 1: Late > 7 days, Student → $5 fine.
     - Rule 2: Late > 7 days, Regular → $2 fine.
     - Rule 3: Not late, Student → $2 fine (e.g., base fine for students).
     - Rule 4: Not late, Regular → No fine.
   - **Pseudocode** (for reference):
     ```
     INPUT DaysLate, MemberType
     IF DaysLate > 7 THEN
         IF MemberType = "Student" THEN
             OUTPUT "Fine: $5"
         ELSE
             OUTPUT "Fine: $2"
         END IF
     ELSE
         IF MemberType = "Student" THEN
             OUTPUT "Fine: $2"
         ELSE
             OUTPUT "No fine"
         END IF
     END IF
     ```

2. **Decision Table: E-commerce Discount Eligibility**
   - **Problem**: Apply discounts based on order amount (> $100) and VIP status.
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Order > $100       | Y      | Y      | N      | N      |
     VIP Customer       | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Apply 20% Discount | X      |        |        |        |
     Apply 10% Discount |        | X      | X      |        |
     No Discount        |        |        |        | X      |
     ```
   - **Explanation**: 
     - Rule 1: Order > $100, VIP → 20% discount.
     - Rule 2: Order > $100, Not VIP → 10% discount.
     - Rule 3: Order ≤ $100, VIP → 10% discount.
     - Rule 4: Order ≤ $100, Not VIP → No discount.
   - **Flowchart Integration** (text-based):
     ```
     [Start] → [Input OrderAmount, VIPStatus] → [OrderAmount > 100?] → Yes → [Is VIP?] → Yes → [Apply 20% Discount] → [End]
                                                     ↓ No                           ↓ No
                                                  [Is VIP?] → Yes → [Apply 10% Discount] → [End]
                                                     ↓ No
                                                  [No Discount] → [End]
     ```

3. **Decision Table: Inventory Restocking**
   - **Problem**: Decide whether to restock based on stock level (< 10 units) and high demand (sales > 50).
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Stock < 10 Units   | Y      | Y      | N      | N      |
     Sales > 50         | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Order 100 Units    | X      |        |        |        |
     Order 50 Units     |        | X      |        |        |
     Monitor Stock      |        |        | X      | X      |
     ```
   - **Explanation**:
     - Rule 1: Low stock, high sales → Order 100 units.
     - Rule 2: Low stock, low sales → Order 50 units.
     - Rule 3 & 4: Sufficient stock → Monitor stock.
   - **Explanation**: Simplifies restocking logic, ensuring all scenarios are covered.

4. **Decision Table: Student Course Enrollment**
   - **Problem**: Approve enrollment based on prerequisite completion and seat availability.
   - **Decision Table**:
     ```
     Conditions              | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------------|--------|--------|--------|--------|
     Prerequisite Completed  | Y      | Y      | N      | N      |
     Seats Available         | Y      | N      | Y      | N      |
     Actions                 |        |        |        |        |
     Approve Enrollment      | X      |        |        |        |
     Add to Waitlist         |        | X      |        |        |
     Reject Enrollment       |        |        | X      | X      |
     ```
   - **Explanation**:
     - Rule 1: Prerequisite done, seats available → Approve.
     - Rule 2: Prerequisite done, no seats → Waitlist.
     - Rule 3 & 4: Prerequisite not done → Reject.
   - **DFD Integration** (text-based, for context):
     ```
     [Student] → (Enrollment Request) → [1.1 Check Prerequisite] → (Valid Prerequisite) → [1.2 Check Seats] → (Seats Available) → [1.3 Enroll] → (Enrollment Confirmation) → [Student]
     ```

## Classwork Activities
1. **Decision Table Creation**:
   - **Task**: Create a decision table for a library checkout system to determine if a book can be borrowed (based on member status and book availability).
   - **Expected Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Member Valid       | Y      | Y      | N      | N      |
     Book Available     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Allow Checkout     | X      |        |        |        |
     Notify Unavailable |        | X      |        |        |
     Notify Invalid     |        |        | X      | X      |
     ```
   - **Objective**: Practice identifying conditions and actions for a simple system.

2. **Decision Table for E-commerce Returns**:
   - **Task**: Design a decision table for processing returns (based on return within 30 days and item condition).
   - **Expected Decision Table**:
     ```
     Conditions              | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------------|--------|--------|--------|--------|
     Return Within 30 Days   | Y      | Y      | N      | N      |
     Item in Good Condition  | Y      | N      | Y      | N      |
     Actions                 |        |        |        |        |
     Accept Return           | X      |        |        |        |
     Offer Partial Refund    |        | X      |        |        |
     Reject Return           |        |        | X      | X      |
     ```
   - **Objective**: Model decision logic for a real-world scenario.

3. **Error Correction**:
   - **Task**: Fix errors in this decision table for a library fine system:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 |
     -------------------|--------|--------|--------|
     Days Late > 5      | Y      | N      | Y      |
     Actions            |        |        |        |
     Fine $3            | X      |        |        |
     No Fine            |        | X      | X      |
     ```
   - **Issues**:
     - Missing rule for Days Late = N, Member = N (2^2 = 4 rules needed).
     - Incomplete condition (e.g., no member type).
   - **Corrected Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Days Late > 5      | Y      | Y      | N      | N      |
     Student Member     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Fine $3            | X      | X      |        |        |
     No Fine            |        |        | X      | X      |
     ```
   - **Objective**: Ensure completeness and clarity.

4. **Group Activity: Subsystem Decision Logic**:
   - **Task**: In pairs, choose a subsystem (e.g., e-commerce shipping, library reservation) and:
     - Identify 2–3 conditions and actions.
     - Create a decision table.
     - Convert one rule into pseudocode and a flowchart.
   - **Example (E-commerce Shipping)**:
     - **Decision Table**:
       ```
       Conditions            | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
       ---------------------|--------|--------|--------|--------|
       Order Weight > 5kg   | Y      | Y      | N      | N      |
       Express Delivery     | Y      | N      | Y      | N      |
       Actions              |        |        |        |        |
       Charge $20           | X      |        |        |        |
       Charge $10           |        | X      | X      |        |
       Charge $5            |        |        |        | X      |
       ```
     - **Pseudocode for Rule 1**:
       ```
       IF OrderWeight > 5 AND ExpressDelivery = TRUE THEN
           OUTPUT "Shipping: $20"
       END IF
       ```
     - **Flowchart for Rule 1** (text-based):
       ```
       [Start] → [Input OrderWeight, ExpressDelivery] → [OrderWeight > 5?] → Yes → [ExpressDelivery?] → Yes → [Charge $20] → [End]
       ```
   - **Discussion**: Share tables and discuss how they simplify decision-making.

## Objective Questions (Multiple Choice)
Test your understanding of decision tables:

1. **What is the primary purpose of a decision table?**
   - A. Show data flow
   - B. Model decision-making rules
   - C. Represent system hierarchy
   - D. Depict process logic
   - **Answer**: B
   - **Explanation**: Decision tables define rules for decisions. DFDs show data flow (A), HIPO charts show hierarchy (C), and flowcharts depict logic (D).

2. **What are condition entries in a decision table?**
   - A. Actions to take
   - B. Y/N or True/False values
   - C. Data stores
   - D. Process steps
   - **Answer**: B
   - **Explanation**: Condition entries (Y/N) specify condition states. Actions are outcomes (A), data stores are in DFDs (C), and process steps are in flowcharts (D).

3. **How many rules are needed for 3 conditions?**
   - A. 3
   - B. 6
   - C. 8
   - D. 9
   - **Answer**: C
   - **Explanation**: For *n* conditions, there are 2^n rules. For 3 conditions, 2^3 = 8 rules.

4. **What does an X in a decision table’s action entry indicate?**
   - A. Condition is true
   - B. Action is taken
   - C. Data flow occurs
   - D. Module is called
   - **Answer**: B
   - **Explanation**: An X marks actions to take for a rule. Conditions use Y/N (A), data flow is in DFDs (C), and modules are in HIPO charts (D).

5. **What is wrong with a decision table missing a rule?**
   - A. It’s incomplete
   - B. It’s inconsistent
   - C. It lacks data flow
   - D. It has no hierarchy
   - **Answer**: A
   - **Explanation**: Missing rules mean not all condition combinations are covered, making it incomplete. Inconsistency is conflicting rules (B), others are unrelated (C, D).

6. **Which system would use a decision table for fines?**
   - A. Library management
   - B. Data flow analysis
   - C. Hierarchy design
   - D. Process optimization
   - **Answer**: A
   - **Explanation**: Library systems use decision tables for fines (e.g., based on days late). Others relate to DFDs (B),
## Key Concepts
1. **What Are Decision Tables?**
   - **Definition**: A tabular representation of decision-making logic, showing how conditions lead to specific actions.
   - **Purpose**: Simplify complex decisions by listing all possible condition combinations and their outcomes.
   - **Use Cases**: Ideal for systems with multiple conditions (e.g., determining eligibility, calculating fees).
   - **Benefits**:
     - Clarity: Organizes logic in a structured format.
     - Completeness: Ensures all scenarios are covered.
     - Communication: Easy to understand for developers and stakeholders.
   - **Example**: Deciding discounts in an e-commerce system based on order amount and customer status.

2. **Structure of a Decision Table**
   - **Components**:
     - **Condition Stubs**: List conditions to evaluate (e.g., Order > $100).
     - **Condition Entries**: Values for conditions (e.g., Y/N, True/False).
     - **Action Stubs**: List possible actions (e.g., Apply 10% Discount).
     - **Action Entries**: Indicate which actions apply (e.g., marked with X).
   - **Layout**:
     ```
     Conditions   | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------|--------|--------|--------|--------|
     Condition 1  | Y      | Y      | N      | N      |
     Condition 2  | Y      | N      | Y      | N      |
     Actions      |        |        |        |        |
     Action 1     | X      |        |        |        |
     Action 2     |        | X      | X      |        |
     Action 3     |        |        |        | X      |
     ```
   - **Rules**: Each column represents a unique combination of condition outcomes (e.g., Rule 1: both conditions true).

3. **Steps to Create a Decision Table**
   - **Step 1: Identify Conditions**: List all factors affecting the decision (e.g., Is customer VIP? Is order > $100?).
   - **Step 2: Determine Actions**: List possible outcomes (e.g., Apply discount, Reject order).
   - **Step 3: Calculate Rules**: For *n* conditions, there are 2^n rules (e.g., 2 conditions → 4 rules).
   - **Step 4: Fill Condition Entries**: Use Y/N or True/False for each rule.
   - **Step 5: Specify Action Entries**: Mark actions (X) for each rule.
   - **Step 6: Optimize**: Combine redundant rules or simplify conditions.
   - **Example**: For 2 conditions, create 2^2 = 4 rules covering all combinations (YY, YN, NY, NN).

4. **Rules for Effective Decision Tables**
   - **Completeness**: Include all possible condition combinations.
   - **Consistency**: Avoid conflicting actions for the same conditions.
   - **Clarity**: Use concise, clear labels for conditions and actions.
   - **Modularity**: Break complex decisions into smaller tables if needed.
   - **Validation**: Cross-check with stakeholders to ensure accuracy.

5. **Integration with Other Diagrams**
   - **Flowcharts**: Decision tables can be translated into flowchart decisions (e.g., if-then-else logic).
   - **DFDs**: Define processes in DFDs that use decision table logic (e.g., Process Payment → Discount Decision).
   - **HIPO Charts**: Decision tables detail the process step in IPO charts.
   - **Example**: A decision table for library fines can inform a flowchart for the fine calculation process.

6. **Applications in Real-World Systems**
   - **Library Management**: Determine fines based on days late and member type.
   - **E-commerce**: Apply discounts based on order value and customer status.
   - **Inventory Control**: Decide restocking based on stock level and demand.
   - **Student Registration**: Approve enrollment based on prerequisites and availability.

## Examples
1. **Decision Table: Library Fine Calculation**
   - **Problem**: Determine fines for a returned book based on days late and member type (Student or Regular).
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Days Late > 7      | Y      | Y      | N      | N      |
     Student Member     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Fine $5            | X      |        |        |        |
     Fine $2            |        | X      | X      |        |
     No Fine            |        |        |        | X      |
     ```
   - **Explanation**: 
     - 2 conditions → 2^2 = 4 rules.
     - Rule 1: Late > 7 days, Student → $5 fine.
     - Rule 2: Late > 7 days, Regular → $2 fine.
     - Rule 3: Not late, Student → $2 fine (e.g., base fine for students).
     - Rule 4: Not late, Regular → No fine.
   - **Pseudocode** (for reference):
     ```
     INPUT DaysLate, MemberType
     IF DaysLate > 7 THEN
         IF MemberType = "Student" THEN
             OUTPUT "Fine: $5"
         ELSE
             OUTPUT "Fine: $2"
         END IF
     ELSE
         IF MemberType = "Student" THEN
             OUTPUT "Fine: $2"
         ELSE
             OUTPUT "No fine"
         END IF
     END IF
     ```

2. **Decision Table: E-commerce Discount Eligibility**
   - **Problem**: Apply discounts based on order amount (> $100) and VIP status.
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Order > $100       | Y      | Y      | N      | N      |
     VIP Customer       | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Apply 20% Discount | X      |        |        |        |
     Apply 10% Discount |        | X      | X      |        |
     No Discount        |        |        |        | X      |
     ```
   - **Explanation**: 
     - Rule 1: Order > $100, VIP → 20% discount.
     - Rule 2: Order > $100, Not VIP → 10% discount.
     - Rule 3: Order ≤ $100, VIP → 10% discount.
     - Rule 4: Order ≤ $100, Not VIP → No discount.
   - **Flowchart Integration** (text-based):
     ```
     [Start] → [Input OrderAmount, VIPStatus] → [OrderAmount > 100?] → Yes → [Is VIP?] → Yes → [Apply 20% Discount] → [End]
                                                     ↓ No                           ↓ No
                                                  [Is VIP?] → Yes → [Apply 10% Discount] → [End]
                                                     ↓ No
                                                  [No Discount] → [End]
     ```

3. **Decision Table: Inventory Restocking**
   - **Problem**: Decide whether to restock based on stock level (< 10 units) and high demand (sales > 50).
   - **Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Stock < 10 Units   | Y      | Y      | N      | N      |
     Sales > 50         | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Order 100 Units    | X      |        |        |        |
     Order 50 Units     |        | X      |        |        |
     Monitor Stock      |        |        | X      | X      |
     ```
   - **Explanation**:
     - Rule 1: Low stock, high sales → Order 100 units.
     - Rule 2: Low stock, low sales → Order 50 units.
     - Rule 3 & 4: Sufficient stock → Monitor stock.
   - **Explanation**: Simplifies restocking logic, ensuring all scenarios are covered.

4. **Decision Table: Student Course Enrollment**
   - **Problem**: Approve enrollment based on prerequisite completion and seat availability.
   - **Decision Table**:
     ```
     Conditions              | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------------|--------|--------|--------|--------|
     Prerequisite Completed  | Y      | Y      | N      | N      |
     Seats Available         | Y      | N      | Y      | N      |
     Actions                 |        |        |        |        |
     Approve Enrollment      | X      |        |        |        |
     Add to Waitlist         |        | X      |        |        |
     Reject Enrollment       |        |        | X      | X      |
     ```
   - **Explanation**:
     - Rule 1: Prerequisite done, seats available → Approve.
     - Rule 2: Prerequisite done, no seats → Waitlist.
     - Rule 3 & 4: Prerequisite not done → Reject.
   - **DFD Integration** (text-based, for context):
     ```
     [Student] → (Enrollment Request) → [1.1 Check Prerequisite] → (Valid Prerequisite) → [1.2 Check Seats] → (Seats Available) → [1.3 Enroll] → (Enrollment Confirmation) → [Student]
     ```

## Classwork Activities
1. **Decision Table Creation**:
   - **Task**: Create a decision table for a library checkout system to determine if a book can be borrowed (based on member status and book availability).
   - **Expected Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Member Valid       | Y      | Y      | N      | N      |
     Book Available     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Allow Checkout     | X      |        |        |        |
     Notify Unavailable |        | X      |        |        |
     Notify Invalid     |        |        | X      | X      |
     ```
   - **Objective**: Practice identifying conditions and actions for a simple system.

2. **Decision Table for E-commerce Returns**:
   - **Task**: Design a decision table for processing returns (based on return within 30 days and item condition).
   - **Expected Decision Table**:
     ```
     Conditions              | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     ------------------------|--------|--------|--------|--------|
     Return Within 30 Days   | Y      | Y      | N      | N      |
     Item in Good Condition  | Y      | N      | Y      | N      |
     Actions                 |        |        |        |        |
     Accept Return           | X      |        |        |        |
     Offer Partial Refund    |        | X      |        |        |
     Reject Return           |        |        | X      | X      |
     ```
   - **Objective**: Model decision logic for a real-world scenario.

3. **Error Correction**:
   - **Task**: Fix errors in this decision table for a library fine system:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 |
     -------------------|--------|--------|--------|
     Days Late > 5      | Y      | N      | Y      |
     Actions            |        |        |        |
     Fine $3            | X      |        |        |
     No Fine            |        | X      | X      |
     ```
   - **Issues**:
     - Missing rule for Days Late = N, Member = N (2^2 = 4 rules needed).
     - Incomplete condition (e.g., no member type).
   - **Corrected Decision Table**:
     ```
     Conditions         | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
     -------------------|--------|--------|--------|--------|
     Days Late > 5      | Y      | Y      | N      | N      |
     Student Member     | Y      | N      | Y      | N      |
     Actions            |        |        |        |        |
     Fine $3            | X      | X      |        |        |
     No Fine            |        |        | X      | X      |
     ```
   - **Objective**: Ensure completeness and clarity.

4. **Group Activity: Subsystem Decision Logic**:
   - **Task**: In pairs, choose a subsystem (e.g., e-commerce shipping, library reservation) and:
     - Identify 2–3 conditions and actions.
     - Create a decision table.
     - Convert one rule into pseudocode and a flowchart.
   - **Example (E-commerce Shipping)**:
     - **Decision Table**:
       ```
       Conditions            | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
       ---------------------|--------|--------|--------|--------|
       Order Weight > 5kg   | Y      | Y      | N      | N      |
       Express Delivery     | Y      | N      | Y      | N      |
       Actions              |        |        |        |        |
       Charge $20           | X      |        |        |        |
       Charge $10           |        | X      | X      |        |
       Charge $5            |        |        |        | X      |
       ```
     - **Pseudocode for Rule 1**:
       ```
       IF OrderWeight > 5 AND ExpressDelivery = TRUE THEN
           OUTPUT "Shipping: $20"
       END IF
       ```
     - **Flowchart for Rule 1** (text-based):
       ```
       [Start] → [Input OrderWeight, ExpressDelivery] → [OrderWeight > 5?] → Yes → [ExpressDelivery?] → Yes → [Charge $20] → [End]
       ```
   - **Discussion**: Share tables and discuss how they simplify decision-making.

## Objective Questions (Multiple Choice)
Test your understanding of decision tables:

1. **What is the primary purpose of a decision table?**
   - A. Show data flow
   - B. Model decision-making rules
   - C. Represent system hierarchy
   - D. Depict process logic
   - **Answer**: B
   - **Explanation**: Decision tables define rules for decisions. DFDs show data flow (A), HIPO charts show hierarchy (C), and flowcharts depict logic (D).

2. **What are condition entries in a decision table?**
   - A. Actions to take
   - B. Y/N or True/False values
   - C. Data stores
   - D. Process steps
   - **Answer**: B
   - **Explanation**: Condition entries (Y/N) specify condition states. Actions are outcomes (A), data stores are in DFDs (C), and process steps are in flowcharts (D).

3. **How many rules are needed for 3 conditions?**
   - A. 3
   - B. 6
   - C. 8
   - D. 9
   - **Answer**: C
   - **Explanation**: For *n* conditions, there are 2^n rules. For 3 conditions, 2^3 = 8 rules.

4. **What does an X in a decision table’s action entry indicate?**
   - A. Condition is true
   - B. Action is taken
   - C. Data flow occurs
   - D. Module is called
   - **Answer**: B
   - **Explanation**: An X marks actions to take for a rule. Conditions use Y/N (A), data flow is in DFDs (C), and modules are in HIPO charts (D).

5. **What is wrong with a decision table missing a rule?**
   - A. It’s incomplete
   - B. It’s inconsistent
   - C. It lacks data flow
   - D. It has no hierarchy
   - **Answer**: A
   - **Explanation**: Missing rules mean not all condition combinations are covered, making it incomplete. Inconsistency is conflicting rules (B), others are unrelated (C, D).

6. **Which system would use a decision table for fines?**
   - A. Library management
   - B. Data flow analysis
   - C. Hierarchy design
   - D. Process optimization
   - **Answer**: A
   - **Explanation**: Library systems use decision tables for fines (e.g., based on days late). Others relate to DFDs (B),