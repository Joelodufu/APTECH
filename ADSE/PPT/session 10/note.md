# Class Note: String Manipulation (Session 10)

## Overview

Strings are sequences of characters used to represent text, such as names or messages, and manipulating them is a fundamental programming skill. This session introduces string manipulation, covering common operations like concatenation, substring extraction, length calculation, and case conversion in pseudocode, with flowchart visualizations. By the end of this class, you will be able to perform string operations, write pseudocode for string-based tasks, and create flowcharts for string manipulation algorithms, applying structured programming principles.

## Learning Objectives

- Understand strings and their representation in programming.
- Perform basic string operations (e.g., concatenation, length, substring) in pseudocode.
- Use string manipulation in subroutines and loops.
- Handle strings with selection constructs for validation or searching.
- Design flowcharts and pseudocode for string-based solutions to practical problems.

## Key Concepts

1. **What Are Strings?**

   - A string is a sequence of characters (e.g., "Hello", "123", "Alice").
   - Stored as a variable of type `STRING` or as an array of characters.
   - Example: `SET name = "Bob"` assigns the string "Bob" to `name`.
   - Strings are used for text input/output, validation, and processing.

2. **Common String Operations**

   - **Length**: Returns the number of characters.
     - Syntax: `LENGTH(string)`
     - Example: `LENGTH("Hello")` returns 5.
   - **Concatenation**: Combines two strings.
     - Syntax: `string1 + string2` or `CONCAT(string1, string2)`
     - Example: `"Hello" + "World"` returns "HelloWorld".
   - **Substring**: Extracts a portion of a string.
     - Syntax: `SUBSTRING(string, start, length)`
     - Example: `SUBSTRING("Hello", 1, 3)` returns "ell" (indices often start at 1 in pseudocode).
   - **Case Conversion**:
     - `UPPER(string)`: Converts to uppercase (e.g., "hello" → "HELLO").
     - `LOWER(string)`: Converts to lowercase (e.g., "HELLO" → "hello").
   - **Character Access**: Retrieves a character at a position.
     - Syntax: `string[index]` (indices may start at 1 or 0, depending on convention).
     - Example: `"Hello"[1]` might return "H" or "e" based on indexing.

3. **String Manipulation with Loops**

   - Loops process strings character by character (e.g., counting vowels, reversing).
   - Example: A for loop can iterate over indices to check each character.
   - Strings can be treated as arrays of characters for advanced operations.

4. **String Validation and Searching**

   - **Validation**: Check if a string meets criteria (e.g., is it a valid email?).
   - **Searching**: Find a character or substring.
     - Syntax: `FIND(string, search)` returns the position or -1 if not found.
     - Example: `FIND("Hello", "l")` returns 3 (position of first "l").
   - Use selection constructs (if-then-else) for conditional checks.

5. **Subroutines for String Manipulation**

   - Procedures and functions modularize string operations (e.g., a function to count vowels).
   - Parameters pass strings or arrays; functions return results like counts or modified strings.
   - Example: `FUNCTION ReverseString(text) RETURNS STRING`.

6. **Flowchart Representation**

   - **Rectangles**: String operations (e.g., concatenate, extract substring).
   - **Diamonds**: Decisions (e.g., check if character is a vowel).
   - **Loops**: Arrows for iterating over characters.
   - **Parallelograms**: Input/output of strings.

7. **Structured Programming Principles**
   - Use **modularity** with subroutines for string tasks.
   - Apply **top-down design**: Break problems into input, processing, and output.
   - Ensure **single entry, single exit** in subroutines.
   - Combine with control structures (sequence, selection, iteration).

## Examples

1. **Concatenate and Display Strings**

   - **Problem**: Input a first name and last name, concatenate them with a space, and display the full name using a procedure.
   - **Pseudocode**:

     ```
     PROCEDURE CreateFullName(first, last)
         SET fullName = first + " " + last
         OUTPUT "Full name: ", fullName
     END PROCEDURE

     START
     OUTPUT "Enter first name:"
     INPUT firstName
     OUTPUT "Enter last name:"
     INPUT lastName
     CALL CreateFullName(firstName, lastName)
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [Output "Enter first name:"] → [Input firstName] → [Output "Enter last name:"] → [Input lastName] → [Call CreateFullName(firstName, lastName)] → [End]
     ```
     - **CreateFullName Flowchart**:
       ```
       [Start CreateFullName] → [fullName = first + " " + last] → [Output "Full name: ", fullName] → [End CreateFullName]
       ```
   - **Explanation**: The procedure concatenates strings and displays the result, demonstrating modularity.

2. **Function to Count Vowels**

   - **Problem**: Write a function to count vowels (a, e, i, o, u) in a string, ignoring case.
   - **Pseudocode**:

     ```
     FUNCTION CountVowels(text) RETURNS INTEGER
         SET text = LOWER(text)
         SET count = 0
         FOR i = 1 TO LENGTH(text)
             SET char = text[i]
             IF char == "a" OR char == "e" OR char == "i" OR char == "o" OR char == "u" THEN
                 count = count + 1
             END IF
         END FOR
         RETURN count
     END FUNCTION

     START
     OUTPUT "Enter a string:"
     INPUT inputText
     SET vowelCount = CountVowels(inputText)
     OUTPUT "Number of vowels: ", vowelCount
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [Output "Enter a string:"] → [Input inputText] → [Call CountVowels(inputText)] → [Output "Number of vowels: ", vowelCount] → [End]
     ```
     - **CountVowels Flowchart**:
       ```
       [Start CountVowels] → [text = LOWER(text), count = 0, i = 1] → [i <= LENGTH(text)?] → Yes → [char = text[i]] → [char in "a,e,i,o,u"?] → Yes → [count = count + 1] → [i = i + 1] → [Back to i <= LENGTH(text)?]
                                                        ↓ No                                       ↓ No                            ↓
                                                    [Return count] → [End CountVowels]                                    [i = i + 1] → [Back to i <= LENGTH(text)?]
       ```
   - **Explanation**: The function converts the string to lowercase, loops through characters, and counts vowels.

3. **Procedure to Reverse a String**

   - **Problem**: Create a procedure to reverse a string and display it (e.g., "Hello" → "olleH").
   - **Pseudocode**:

     ```
     PROCEDURE ReverseString(text)
         SET reversed = ""
         FOR i = LENGTH(text) DOWNTO 1
             SET reversed = reversed + text[i]
         END FOR
         OUTPUT "Reversed string: ", reversed
     END PROCEDURE

     START
     OUTPUT "Enter a string:"
     INPUT inputText
     CALL ReverseString(inputText)
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [Output "Enter a string:"] → [Input inputText] → [Call ReverseString(inputText)] → [End]
     ```
     - **ReverseString Flowchart**:
       ```
       [Start ReverseString] → [reversed = "", i = LENGTH(text)] → [i >= 1?] → Yes → [reversed = reversed + text[i]] → [i = i - 1] → [Back to i >= 1?]
                                                       ↓ No
                                                  [Output "Reversed string: ", reversed] → [End ReverseString]
       ```
   - **Explanation**: The procedure builds a reversed string by appending characters in reverse order.

4. **Function to Validate Username**

   - **Problem**: Write a function to validate a username (must be 6–12 characters, letters only) and use it in a program.
   - **Pseudocode**:

     ```
     FUNCTION IsValidUsername(username) RETURNS BOOLEAN
         SET len = LENGTH(username)
         IF len < 6 OR len > 12 THEN
             RETURN FALSE
         END IF
         FOR i = 1 TO len
             SET char = username[i]
             IF NOT (char >= "a" AND char <= "z" OR char >= "A" AND char <= "Z") THEN
                 RETURN FALSE
             END IF
         END FOR
         RETURN TRUE
     END FUNCTION

     START
     OUTPUT "Enter username:"
     INPUT username
     IF IsValidUsername(username) THEN
         OUTPUT "Valid username"
     ELSE
         OUTPUT "Invalid username"
     END IF
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [Output "Enter username:"] → [Input username] → [Call IsValidUsername(username)] → [IsValidUsername = TRUE?] → Yes → [Output "Valid username"] → [End]
                                                                                                    ↓ No
                                                                                               [Output "Invalid username"] → [End]
     ```
     - **IsValidUsername Flowchart**:
       ```
       [Start IsValidUsername] → [len = LENGTH(username)] → [len < 6 OR len > 12?] → Yes → [Return FALSE] → [End IsValidUsername]
                                                  ↓ No
                                             [i = 1] → [i <= len?] → Yes → [char = username[i]] → [char is letter?] → Yes → [i = i + 1] → [Back to i <= len?]
                                                             ↓ No                                  ↓ No                       ↓
                                                         [Return TRUE] → [End IsValidUsername]  [Return FALSE] → [End IsValidUsername]
       ```
   - **Explanation**: The function checks length and ensures all characters are letters, returning a boolean.

## Classwork Activities

1. **Pseudocode Writing**:

   - **Task**: Write pseudocode for a procedure that extracts the first 3 characters of a string and displays them.
   - **Expected Pseudocode**:

     ```
     PROCEDURE GetFirstThree(text)
         IF LENGTH(text) >= 3 THEN
             SET result = SUBSTRING(text, 1, 3)
             OUTPUT "First three characters: ", result
         ELSE
             OUTPUT "String too short"
         END IF
     END PROCEDURE

     START
     OUTPUT "Enter a string:"
     INPUT inputText
     CALL GetFirstThree(inputText)
     END
     ```

2. **Flowchart Design**:

   - **Task**: Create a flowchart for a program that uses a function to check if a string is a palindrome (e.g., "radar").
   - **Expected Flowchart** (main, text-based):
     ```
     [Start] → [Input text] → [Call IsPalindrome(text)] → [IsPalindrome = TRUE?] → Yes → [Output "Palindrome"] → [End]
                                                               ↓ No
                                                          [Output "Not a palindrome"] → [End]
     ```
     - **IsPalindrome Flowchart**:
       ```
       [Start IsPalindrome] → [text = LOWER(text), left = 1, right = LENGTH(text)] → [left <= right?] → Yes → [text[left] != text[right]?] → Yes → [Return FALSE] → [End IsPalindrome]
                                                                ↓ No                                       ↓ No
                                                            [Return TRUE] → [End IsPalindrome]           [left = left + 1, right = right - 1] → [Back to left <= right?]
       ```

3. **Error Correction**:

   - **Task**: Fix errors in this pseudocode:
     ```
     FUNCTION GetLength(text)
         RETURN LENGTH(text)
     END
     START
         INPUT str
         OUTPUT GetLength
     END
     ```
   - **Issues**:
     - Function lacks `RETURNS dataType` (e.g., `RETURNS INTEGER`).
     - Function call `GetLength` needs argument (`GetLength(str)`).
     - Missing `END FUNCTION`.
   - **Corrected Pseudocode**:

     ```
     FUNCTION GetLength(text) RETURNS INTEGER
         RETURN LENGTH(text)
     END FUNCTION

     START
         INPUT str
         SET result = GetLength(str)
         OUTPUT result
     END
     ```

4. **Group Activity: Real-World Scenario**:

   - **Task**: In pairs, design pseudocode and a flowchart for a program that:
     - Inputs a sentence.
     - Uses a function to count words (split by spaces).
     - Uses a procedure to capitalize the first letter of the sentence.
     - Outputs the word count and capitalized sentence.
   - **Example Pseudocode**:

     ```
     FUNCTION CountWords(sentence) RETURNS INTEGER
         SET count = 1
         FOR i = 1 TO LENGTH(sentence)
             IF sentence[i] == " " THEN
                 count = count + 1
             END IF
         END FOR
         RETURN count
     END FUNCTION

     PROCEDURE CapitalizeFirst(sentence)
         SET first = UPPER(SUBSTRING(sentence, 1, 1))
         SET rest = SUBSTRING(sentence, 2, LENGTH(sentence) - 1)
         OUTPUT "Capitalized: ", first + rest
     END PROCEDURE

     START
     OUTPUT "Enter a sentence:"
     INPUT sentence
     SET wordCount = CountWords(sentence)
     OUTPUT "Word count: ", wordCount
     CALL CapitalizeFirst(sentence)
     END
     ```

   - **Discussion**: Share solutions and discuss how strings differ from arrays.

## Objective Questions (Multiple Choice)

Test your understanding of string manipulation with the following questions:

1. **What is a string in programming?**

   - A. A number
   - B. A sequence of characters
   - C. A loop
   - D. An array of numbers
   - **Answer**: B
   - **Explanation**: A string is a sequence of characters (e.g., "Hello"). Numbers (A), loops (C), and numeric arrays (D) are different.

2. **What does `LENGTH("Code")` return?**

   - A. 3
   - B. 4
   - C. 5
   - D. 0
   - **Answer**: B
   - **Explanation**: `LENGTH("Code")` returns 4, the number of characters in "Code".

3. **What is the result of `"Hi" + "There"`?**

   - A. HiThere
   - B. Hi There
   - C. Hi+There
   - D. Error
   - **Answer**: A
   - **Explanation**: Concatenation combines strings, so `"Hi" + "There"` yields "HiThere". Spaces require explicit inclusion (B).

4. **What does `SUBSTRING("Hello", 2, 2)` return?**

   - A. He
   - B. el
   - C. ll
   - D. lo
   - **Answer**: B
   - **Explanation**: `SUBSTRING("Hello", 2, 2)` extracts 2 characters starting at position 2 (1-based), yielding "el".

5. **What does this pseudocode output for `text = "cat"`?**

   ```
   OUTPUT UPPER(text)
   ```

   - A. cat
   - B. CAT
   - C. Cat
   - D. cAT
   - **Answer**: B
   - **Explanation**: `UPPER("cat")` converts to "CAT". Other options reflect incorrect or partial conversion.

6. **What is wrong with this pseudocode?**

   ```
   SET text = "Test"
   OUTPUT text[0]
   ```

   - A. Invalid index
   - B. Missing LOOP
   - C. No subroutine
   - D. No START/END
   - **Answer**: A
   - **Explanation**: If 1-based indexing is used (common in pseudocode), `text[0]` is invalid; use `text[1]`. Other issues are secondary.

7. **What does this function do?**

   ```
   FUNCTION HasSpace(text) RETURNS BOOLEAN
       FOR i = 1 TO LENGTH(text)
           IF text[i] == " " THEN
               RETURN TRUE
           END IF
       END FOR
       RETURN FALSE
   END FUNCTION
   ```

   - A. Counts spaces
   - B. Checks for a space
   - C. Removes spaces
   - D. Reverses the string
   - **Answer**: B
   - **Explanation**: The function returns `TRUE` if a space is found, otherwise `FALSE`. It doesn’t count (A), remove (C), or reverse (D).

8. **What is the output if `word = "Book"`?**

   ```
   SET word = "Book"
   SET result = SUBSTRING(word, 1, 2) + UPPER(SUBSTRING(word, 3, 2))
   OUTPUT result
   ```

   - A. BoOK
   - B. BOOK
   - C. BoOk
   - D. book
   - **Answer**: A
   - **Explanation**: `SUBSTRING("Book", 1, 2) = "Bo"`, `SUBSTRING("Book", 3, 2) = "ok"`, `UPPER("ok") = "OK"`, so `"Bo" + "OK" = "BoOK"`.

9. **Why use loops with strings?**

   - A. To change data type
   - B. To process each character
   - C. To concatenate strings
   - D. To avoid subroutines
   - **Answer**: B
   - **Explanation**: Loops iterate over string characters for tasks like counting or searching. Other options are incorrect.

10. **What does this pseudocode do for `text = "hi there"`?**
    ```
    SET text = "hi there"
    SET pos = FIND(text, " ")
    OUTPUT pos
    ```
    - A. Outputs 3
    - B. Outputs 2
    - C. Outputs -1
    - D. Outputs 1
    - **Answer**: A
    - **Explanation**: `FIND("hi there", " ")` returns 3, the position of the first space (1-based indexing). Other options miscalculate.

## Homework

1. **Pseudocode Practice**:
   - Write pseudocode for a function that checks if a string contains only digits and a procedure to display the result.
2. **Flowchart Creation**:
   - Design a flowchart for a program that uses a function to count uppercase letters in a string.
3. **Real-World Application**:
   - Describe a scenario where string manipulation is used (e.g., formatting user input). Write a paragraph and pseudocode with a procedure to remove extra spaces.
4. **Debugging Challenge**:
   - Fix this pseudocode:
     ```
     SET text = "Hello"
     OUTPUT SUBSTRING(text, 0, 2)
     ```
     - Issues: Invalid start index (use 1 for 1-based indexing), no `START/END`.
     - Provide the corrected version.

## Additional Notes

- **Teaching Tips**:
  - **Duration**: 2–3 class periods (3–4.5 hours).
    - **Period 1**: String basics, Example 1, Activity 1.
    - **Period 2**: Advanced operations, Examples 2 and 3, Activities 2 and 3.
    - **Period 3 (optional)**: Example 4, Activity 4, review, quiz.
  - **Visual Aids**: Draw strings as character arrays (e.g., |H|e|l|l|o|) to clarify indexing.
  - **Engagement**: Use relatable scenarios (e.g., usernames, messages).
  - **Differentiation**:
    - Beginners: Focus on concatenation and length.
    - Advanced: Introduce regular expressions or string splitting.
- **Resources**:
  - Flowchart tools: Draw.io, Lucidchart, or paper templates.
  - Text editor for pseudocode: Notepad++, Visual Studio Code.
- **Assessment**:
  - Use objective questions for quizzes or homework.
  - Grade classwork for correct string operations, loop usage, and flowchart logic.
- **Extension**:

  - Implement a pseudocode example in Python:

    ```python
    def count_vowels(text):
        text = text.lower()
        return sum(1 for char in text if char in "aeiou")

    text = input("Enter a string: ")
    print("Number of vowels:", count_vowels(text))
    ```

- **Connections**:
  - Builds on Sessions 8 (arrays) and 9 (subroutines) for text processing.
  - Prepares for future sessions (e.g., file handling, data structures) by handling text data.
