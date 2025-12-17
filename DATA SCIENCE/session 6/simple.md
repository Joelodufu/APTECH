

# **Python Regular Expressions – Simplified Class (No Examples)**

## **1. What Regular Expressions Are**

Regular Expressions (often shortened to *regex*) are patterns used to search, match, or manipulate text.
Think of them as a powerful way to describe what kind of text you are looking for.

---

## **2. What You Need in Python**

Python uses the built-in **`re`** module to work with regex.
It provides tools for searching, replacing, and checking text against patterns.

---

## **3. Key Regex Concepts (In Plain English)**

### **a. Literal Characters**

These are normal letters or numbers.
They match themselves directly.

### **b. Special Characters**

These are characters with special meanings inside a regex pattern.
They help you define more flexible matches.

### **c. Character Classes**

These let you specify “a group of characters” you want to allow at one location in the text.

### **d. Quantifiers**

These define **how many times** something must appear.

### **e. Anchors**

These describe **positions** in the text rather than characters.

### **f. Groups**

These allow you to treat multiple characters as a single unit.

### **g. Escaping**

If you want a special character to lose its meaning and become normal, you must “escape” it.

---

## **4. Useful Functions in Python’s `re` Module**

### **`match()`**

Checks if the beginning of the text fits the pattern.

### **`search()`**

Finds the first place in the text where the pattern appears.

### **`findall()`**

Collects every piece of text that fits the pattern.

### **`sub()`**

Replaces matches with something else.

### **`compile()`**

Stores a pattern for repeated use to make it faster and cleaner.

---

## **5. Process of Using Regex**

1. Think of the pattern you want.
2. Write that pattern using regex syntax.
3. Use one of the `re` functions to apply the pattern to text.

---

## **6. When Regex is Useful**

* Checking if a text follows a format
* Searching for specific patterns inside large text
* Cleaning or transforming text
* Extracting certain parts of text

---
All examples are simple, clear, and executed using Python’s `re` module.

---

# 🔥 **Python Regular Expressions – Dummy-Friendly Class (With Code Examples)**

*(Jupyter Notebook Ready)*

---

## 👇 **1. Importing the `re` Module**

```python
import re
```

---

## 👇 **2. Matching Literal Text**

Literal characters match themselves.

```python
text = "Hello World"
pattern = r"Hello"

result = re.search(pattern, text)
print(result)
```

---

## 👇 **3. Special Characters**

Special characters include:
`.` `^` `$` `*` `+` `?` `{}` `[]` `()` `|` `\`

Example of using a dot (`.`) which means “any character”:

```python
re.search(r"H.llo", "Hello")
```

---

## 👇 **4. Character Classes**

Use square brackets `[]` to allow **multiple possible characters**.

```python
re.search(r"H[ae]llo", "Hello")
```

---

## 👇 **5. Quantifiers**

Set **how many times** something must appear.

| Quantifier | Meaning               |
| ---------- | --------------------- |
| `*`        | 0 or more             |
| `+`        | 1 or more             |
| `?`        | 0 or 1                |
| `{n}`      | exactly n times       |
| `{n,}`     | n or more             |
| `{n,m}`    | between n and m times |

Example:

```python
re.search(r"lo+", "Hellooo")
```

---

## 👇 **6. Anchors**

Used to match **positions** in text.

| Anchor | Meaning       |
| ------ | ------------- |
| `^`    | start of text |
| `$`    | end of text   |

Example:

```python
re.match(r"Hello", "Hello World")
```

---

## 👇 **7. Groups**

Use parentheses `()` to group parts of a pattern.

```python
match = re.search(r"(Hello) (World)", "Hello World")
print(match.group(1))  # First group
print(match.group(2))  # Second group
```

---

## 👇 **8. Alternation (OR)**

Use the pipe `|` to match **one pattern OR another**.

```python
re.search(r"cat|dog", "I have a dog")
```

---

## 👇 **9. Escaping Special Characters**

Use `\` to escape characters so they behave normally.

Example: searching for a literal dot (`.`)

```python
re.search(r"\.", "Hello.")
```

---

## 👇 **10. Finding All Matches**

Returns a list of all matches.

```python
re.findall(r"\d", "A1 B2 C3")
```

---

## 👇 **11. Substitution (Replacing Text)**

`re.sub()` replaces matches.

```python
re.sub(r"\d", "*", "Room 123")
```

---

## 👇 **12. Compiling Patterns**

For repeated use → more efficient and cleaner.

```python
pattern = re.compile(r"\d+")
pattern.findall("Age 22, Score 100")
```

---
