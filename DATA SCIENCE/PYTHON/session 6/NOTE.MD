

# **📘 CLASS NOTE: REGULAR EXPRESSIONS (REGEX) IN PYTHON**

### *Structured for Brain-Mapping + Real-World Problem Use Cases*

---
 
# **MODULE 1: Introduction to Regular Expressions**

## **1.1 What Are Regular Expressions?**

Regex is a language for defining patterns in text.
They help computers understand or manipulate text based on rules.

---

## **1.2 Why Use Regex in Python?**

Python’s `re` module allows you to:

* search patterns
* extract data
* validate user inputs
* replace unwanted characters
* split text into meaningful chunks

---

## **1.3 Importing `re`**

```python
import re
```

---

## **📌 MODULE 1 — Problem-Based Usage**

### **Problem:**

You want to find out if the word **“error”** appears anywhere in a long log file.

### **Explanation:**

Instead of manually scanning through text, regex lets you search instantly.

### **How / Syntax:**

```python
if re.search("error", log_text):
    print("Error found")
```

---

# **MODULE 2: Basic Pattern Elements**

## **2.1 Literal Characters**

Direct matching.

```python
re.search("dog", "my dog is smart")
```

---

## **2.2 Metacharacters**

| Symbol | Meaning                 |    |
| ------ | ----------------------- | -- |
| `.`    | any character           |    |
| `^`    | start of string         |    |
| `$`    | end of string           |    |
| `[]`   | match set of characters |    |
| `()`   | group                   |    |
| `      | `                       | OR |
| `\`    | escape character        |    |

---

## **2.3 Examples**

### Match any character

```python
re.findall("h.t", "hat hit hot hut")
```

### Escape characters

```python
re.search(r"\.", "Website is live.")
```

---

## **📌 MODULE 2 — Problem-Based Usage**

### **Problem:**

You want to find all **three-letter words** ending in **“at”** like `cat, hat, rat`.

### **Explanation:**

Use the dot `.` to stand for any middle character.

### **How / Syntax:**

```python
re.findall(r".at", "cat hat rat wheat")  
# Output: ['cat','hat','rat']
```

---

# **MODULE 3: Character Classes**

## **3.1 Predefined Character Classes**

| Class | Meaning       |
| ----- | ------------- |
| `\d`  | digit         |
| `\D`  | non-digit     |
| `\w`  | word char     |
| `\W`  | non-word char |
| `\s`  | space         |
| `\S`  | non-space     |

---

## **3.2 Custom Sets**

### Only letters:

```python
re.findall(r"[A-Za-z]", "A2B3C4")
```

### Only numbers:

```python
re.findall(r"[0-9]", "Phone: 0803-123-4567")
```

### Excluding characters:

```python
re.findall(r"[^0-9]", "H3e4l5l6o")
```

---

## **📌 MODULE 3 — Problem-Based Usage**

### **Problem:**

Extract only the digits from a messy phone number like:
`"Call me at: 0803-12-45-678"`

### **Explanation:**

`\d` extracts digits; `\D` removes non-digits.

### **How / Syntax:**

```python
digits = re.findall(r"\d", "Call me at 0803-12-45-678")
print("".join(digits))  # 08031245678
```

---

# **MODULE 4: Quantifiers (Repetitions)**

| Pattern | Meaning         |
| ------- | --------------- |
| `*`     | 0 or more       |
| `+`     | 1 or more       |
| `?`     | 0 or 1          |
| `{n}`   | exactly n       |
| `{n,}`  | n or more       |
| `{n,m}` | between n and m |

---

## **4.1 Examples**

### 1 or more (`+`)

```python
re.findall(r"\d+", "A1 B22 C333")
```

### Range (`{2,4}`)

```python
re.findall(r"\d{2,4}", "12 123 1234 12345")
```

---

## **📌 MODULE 4 — Problem-Based Usage**

### **Problem:**

You want to validate that a year is exactly 4 digits (e.g., 2025).

### **Explanation:**

Use `{4}` to ensure exactly four digits.

### **How / Syntax:**

```python
re.fullmatch(r"\d{4}", "2025")
```

---

# **MODULE 5: Anchors**

## **5.1 Start `^`**

```python
re.match(r"Hello", "Hello world")
```

## **5.2 End `$`**

```python
re.search(r"world$", "Hello world")
```

## **5.3 Word Boundary `\b`**

```python
re.findall(r"\bgo\b", "go to the goal")  
# only matches "go"
```

---

## **📌 MODULE 5 — Problem-Based Usage**

### **Problem:**

You want to check if a sentence **begins** with “Dear” and **ends** with a period.

### **Explanation:**

Use anchors:

* `^` start
* `$` end

### **How / Syntax:**

```python
re.fullmatch(r"^Dear.*\.$", "Dear John, welcome.")
```

---

# **MODULE 6: Groups & Capturing**

## **6.1 Capturing Groups**

```python
re.findall(r"(\d{3})-(\d{4})", "Call 090-1234")
```

## **6.2 Alternation `|`**

```python
re.findall(r"cat|dog", "I love cat and dog")
```

## **6.3 Non-Capturing `(?: )`**

```python
re.findall(r"(?:Mr|Mrs|Ms)\. \w+", "Mr. John, Ms. Kate")
```

---

## **📌 MODULE 6 — Problem-Based Usage**

### **Problem:**

You want to extract the **area code** and **main number** from Nigerian numbers like:
`"080-1234"`

### **Explanation:**

Use groups:

* `(\d{3})` for area code
* `(\d{4})` for number

### **How / Syntax:**

```python
re.findall(r"(\d{3})-(\d{4})", "080-1234")
# Output: [('080','1234')]
```

---

# **MODULE 7: Practical `re` Functions**

## **7.1 `re.search()`**

Finds first match.

## **7.2 `re.findall()`**

Returns all matches.

## **7.3 `re.match()`**

Matches only at start.

## **7.4 `re.split()`**

Split using regex.

```python
re.split(r"\W+", "a,b*c d")
```

## **7.5 `re.sub()`**

Replace.

```python
re.sub(r"\d", "*", "A1 B2 C3")
```

---

## **📌 MODULE 7 — Problem-Based Usage**

### **Problem:**

You want to **replace all numbers with X** in user input.

### **Explanation:**

Use `re.sub(pattern, replacement, text)`.

### **How / Syntax:**

```python
cleaned = re.sub(r"\d", "X", "Pass123word")
```

---

# **MODULE 8: Escape Sequences**

Characters like `.` or `*` must be escaped when you want to treat them literally.

```python
re.findall(r"\.", "3.50")
```

---

## **📌 MODULE 8 — Problem-Based Usage**

### **Problem:**

You want to find all email addresses ending with `.com`.

### **Explanation:**

Escape the dot because dot means “any character”.

### **How / Syntax:**

```python
re.findall(r"\.com\b", "email@yahoo.com test@site.org")
```

---

# **MODULE 9: Real-World Patterns**

## **9.1 Email Validation**

```python
pattern = r"^[\w\.-]+@[\w\.-]+\.\w+$"
```

## **9.2 Nigerian Phone Number**

```python
pattern = r"^(?:\+234|0)\d{10}$"
```

## **9.3 URLs**

```python
pattern = r"https?://[\w\.-/\?=&]+"
```

---

## **📌 MODULE 9 — Problem-Based Usage**

### **Problem:**

You want to validate a registration form to ensure user email is correct.

### **Explanation:**

Use regex to enforce structure:
`username @ domain . extension`

### **How / Syntax:**

```python
if re.fullmatch(pattern, email):
    print("Valid")
```

---

# **MODULE 10: Advanced Concepts**

## **10.1 Lookaheads**

Match something that is followed by something else.

```python
re.findall(r"\d+(?=%)", "10% profit")
```

---

## **10.2 Lookbehinds**

Match something preceded by something else.

```python
re.findall(r"(?<=N)\d+", "N500")
```

---

## **10.3 Greedy vs Non-Greedy**

### Greedy

```python
"<.*>"
```

### Non-Greedy

```python
"<.*?>"
```

---

## **📌 MODULE 10 — Problem-Based Usage**

### **Problem:**

Extract every HTML tag from `<p>Hello</p>` without grabbing the entire block.

### **Explanation:**

Use non-greedy `.*?`.

### **How / Syntax:**

```python
re.findall(r"<.*?>", "<p>Hello</p>")
# Output: ['<p>', '</p>']
```

---

# **MODULE 11: PRACTICE QUESTIONS**

1. Extract all 5-letter words.
   Pattern: `\b\w{5}\b`

2. Find all hashtags in text.
   Pattern: `#\w+`

3. Validate a strong password.
   Pattern uses lookaheads.

4. Extract dates in `DD/MM/YYYY`.
   Pattern: `\d{2}/\d{2}/\d{4}`

---

# **MODULE 12: BRAIN-MAP SUMMARY**

### **Regex Core**

* Characters
* Character classes
* Quantifiers
* Anchors
* Groups

### **Python Tools**

* search
* match
* findall
* sub
* split

### **Advanced**

* lookaheads
* lookbehinds
* greedy/non-greedy

### **Applications**

* validation
* cleaning
* extraction
* parsing

---
