# Regular Expressions in Python — class notes 

This section covers **regular expressions (regex)** in Python thoroughly: what regex are, the important pieces (metacharacters, special sequences, character classes, anchors, groups, lookarounds), how the `re` module methods work, and plain-English explanations and examples for each method. You asked to focus **only on regular expressions for now** — tokenization comes later.

---

## What is a regular expression? (plain English)

A regular expression is a **pattern** that describes a set of strings. Think of it as a tiny language to search, match, and manipulate text. Instead of checking each character manually, you write a compact pattern and Python finds all parts of the text that match it.

Example plain idea: the pattern `\d{3}-\d{4}` describes phone-like strings such as `123-4567`.

---

## Using regex in Python — the `re` module

Import with:

```python
import re
```

Most functions take a **pattern** (string) and a **text** (string). Patterns are easier to write as **raw strings** (`r"..."`) so backslashes behave as expected.

---

# 6.1 Core pattern pieces

## 6.1.1 Metacharacters (the building blocks)

Metacharacters have special meanings inside patterns:

* `.` — matches any single character except newline (unless DOTALL flag used).
  Example: `a.c` matches `abc`, `a-c`, `a c`.

* `^` — start of string (or start of line with MULTILINE).
  Example: `^Hello` matches `Hello` only at start.

* `$` — end of string (or end of line with MULTILINE).
  Example: `world$` matches `... world` at end.

* `*` — 0 or more repetitions of previous item.
  Example: `ab*c` matches `ac`, `abc`, `abbbbbc`.

* `+` — 1 or more repetitions.
  Example: `ab+c` matches `abc`, not `ac`.

* `?` — 0 or 1 repetition (makes previous item optional). Also used for non-greedy quantifiers (with `?` after quantifier) and in lookarounds.
  Example: `colou?r` matches `color` and `colour`.

* `{m}` `{m,n}` — exact and range counts.
  Example: `\d{4}` matches 4 digits; `a{2,4}` matches `aa`, `aaa`, or `aaaa`.

* `[]` — character class (see next section).
  Example: `[A-Za-z0-9_]` matches letters, digits, underscore.

* `|` — OR (alternation).
  Example: `cat|dog` matches `cat` or `dog`.

* `()` — grouping and capturing. Also used to apply quantifiers to group.
  Example: `(ab)+` matches `ab`, `abab`, `ababab`.

* `\` — escape character. Use `\.` to match a literal dot, `\\` to match a backslash.

**Plainly:** metacharacters let you express repetition, position, optional sections, alternation, and grouping.

---

## 6.1.2 Special sequences

Shorthand classes that are widely used:

* `\d` — any digit; equivalent to `[0-9]`.

* `\D` — non-digit; equivalent to `[^0-9]`.

* `\w` — “word” character; letters, digits, underscore. Equivalent roughly to `[A-Za-z0-9_]` (behavior depends on locale/unicode).

* `\W` — non-word character.

* `\s` — whitespace (space, tab, newline, etc.).

* `\S` — non-whitespace.

* `\b` — word boundary (position between `\w` and `\W` — like between a word character and a space or punctuation). **Important:** `\b` is *not* a character; it's a position.

* `\B` — non-word-boundary.

* `\n`, `\t`, etc. — usual escapes for newline, tab.

**Plainly:** use `\d`, `\w`, `\s` to write shorter patterns for digits, letters, and whitespace.

---

## 6.1.3 Character classes (square brackets)

Character classes let you list allowed characters:

* `[abc]` matches `a` or `b` or `c`.
* `[a-z]` range — lowercase letters. Combine ranges: `[A-Za-z0-9]`.
* `[^0-9]` — negated class: any character except digits.
* Inside classes most metacharacters are literal (e.g. `.` means dot inside `[]`), but `^`, `-`, `]`, and `\` keep special roles.

You can also use POSIX-like classes with `re` by explicitly listing or via Unicode properties (with `regex` module or using `\p{...}` in some engines — but standard `re` doesn't support `\p{}`).

**Example:** `[A-F0-9]` matches hex digits A–F or numeric 0–9.

---

## Additional important concepts

### Anchors

* `^` and `$` explained above.
* `\A` — absolute start of string (ignores MULTILINE).
* `\Z` — absolute end of string (ignores MULTILINE).
* Use `\b` for word boundaries.

### Greedy vs. Lazy quantifiers

* Greedy quantifiers (default): `.*`, `.+`, `.{m,n}` — match **as much as possible** while still allowing the rest of the pattern to succeed.
* Lazy (non-greedy): add `?` after quantifier: `.*?`, `+?`, `{m,n}?` — match **as little as possible**.

Example:

* Pattern `<.*>` applied to `<a> <b>` will match `<a> <b>` as one big match (greedy).
* Pattern `<.*?>` will match `<a>` then `<b>` (lazy) — often what you want when parsing tags.

### Groups, capturing, and backreferences

* `(pattern)` captures a matched substring into a numbered group: group 1, 2, ...
* `(?P<name>pattern)` creates a **named group** accessible by `name`.
* Backreference: `\1` refers to the text matched by group 1 within the pattern (useful for detecting repeated words or mirrored patterns).

  * Example: `r'(\w+)\s+\1'` matches duplicated words like `the the`.
* Use `match.group(1)` or `match.group('name')` in Python to retrieve captured text.

### Non-capturing groups

* `(?:pattern)` groups but **does not capture** — useful for applying quantifiers or alternation without creating a group number.

### Lookahead and lookbehind (zero-width assertions)

They check context without consuming characters.

* Positive lookahead `(?=...)` — asserts that what follows matches `...`.

  * Example: `\w+(?=\.)` matches words followed by a dot, but the dot is not part of the match.

* Negative lookahead `(?!...)` — asserts the following text does *not* match `...`.

  * Example: `foo(?!bar)` matches `foo` not followed by `bar`.

* Positive lookbehind `(?<=...)` — asserts preceding text matches `...`.

  * Example: `(?<=\$)\d+` matches digits preceded by `$`.

* Negative lookbehind `(?<!...)` — asserts preceding text does *not* match `...`.

**Important:** In Python's `re` module, lookbehind expressions must be fixed width (older versions) — variable-length lookbehind is not allowed.

---

### Flags (modifiers)

You pass flags to change behavior:

* `re.IGNORECASE` or `re.I` — case-insensitive.
* `re.MULTILINE` or `re.M` — make `^` and `$` match start/end of **lines** (not only whole string).
* `re.DOTALL` or `re.S` — `.` matches newline too.
* `re.VERBOSE` or `re.X` — lets you write readable patterns with whitespace and comments (very handy for complex regex).
* Combine flags with `|`, or inline like `(?i)` for IGNORECASE within pattern.

---

# 6.2 Python methods that use regular expressions — deep dive + plain-English

We'll go through the main `re` functions: `findall`, `finditer`, `search`, `match`, `sub`, `compile`, `split`. For each: what it returns, typical use, plain-English explanation, examples, and gotchas.

Import reminder:

```python
import re
```

---

## 6.2.1 `re.findall(pattern, string, flags=0)`

**What it does:**
Returns a **list** of all (non-overlapping) matches of the pattern in the string.

* If the pattern has **no capturing groups**, `findall` returns a list of full matched strings.
* If the pattern has **one or more capturing groups**, `findall` returns a list of tuples with captured groups (or list of strings if there is exactly one group).

**Plain-English:** It scans the text and collects every chunk that matches the pattern into a list. Good when you just want all found pieces.

**Example 1 — no groups**

```python
re.findall(r'\d+', 'there are 12 apples and 30 oranges')
# -> ['12', '30']
```

**Example 2 — with groups**

```python
re.findall(r'(\w+)@(\w+\.\w+)', 'a@x.com b@site.org')
# -> [('a', 'x.com'), ('b', 'site.org')]
```

Each tuple holds the captured groups.

**Gotchas / tips:**

* `findall` does **not** return match objects — no span or start index. Use `finditer` if you need positions.
* Overlapping matches are *not* returned (e.g., for pattern `(?=(aba))` you can use lookahead to find overlaps).
* If you need both the matched substring and its position, use `re.finditer`.

---

## 6.2.2 `re.finditer(pattern, string, flags=0)`

**What it does:**
Returns an **iterator** that yields `Match` objects for each non-overlapping match.

**Plain-English:** Like `findall`, but instead of giving you plain strings, it gives you match objects so you can inspect the match, its groups, and its position (start/end indices).

**Example:**

```python
for m in re.finditer(r'\d+', 'a12b 345 c6'):
    print(m.group(), m.start(), m.end())
# Output:
# 12 1 3
# 345 4 7
# 6 8 9
```

**Why use it:** When you need indexes, access to named groups, or want to process matches one-by-one in a memory-efficient way (iterator), use `finditer`.

**Gotchas / tips:**

* `finditer` yields `Match` objects; use `m.group()`, `m.groups()`, `m.groupdict()`, `m.start()`, `m.end()`, `m.span()`.
* Since it's an iterator, you can break early if you found what you need.

---

## 6.2.3 `re.search(pattern, string, flags=0)`

**What it does:**
Scans through the string, returning a `Match` object for the **first** location where the pattern produces a match. Returns `None` if no match.

**Plain-English:** "Find me the first place in the text where this pattern appears." It can start anywhere in the string.

**Example:**

```python
m = re.search(r'\d+', 'abc 123 def 456')
m.group()  # -> '123'
m.start()  # -> index where '123' begins
```

**When to use:** When you want to test if something exists, or examine the first occurrence.

**Gotchas / tips:**

* If you need all occurrences, use `findall` or `finditer`.
* `search` and `match` are different: `search` looks anywhere; `match` only at the beginning (see next).

---

## 6.2.4 `re.match(pattern, string, flags=0)`

**What it does:**
Attempts to match the pattern at the **beginning** of the string only. Returns a `Match` object if it matches from the start; otherwise `None`.

**Plain-English:** "Does the string **start** with something matching this pattern?" Equivalent to using `^` at pattern start, but `match` is explicit about start.

**Example:**

```python
re.match(r'\d+', '123abc')      # Match object (123)
re.match(r'\d+', 'abc123')      # None, because digits don't start the string
re.search(r'\d+', 'abc123')     # would find digits at position 3
```

**Gotchas / tips:**

* Use `match` when you care about beginning-of-string matches. Otherwise `search` is probably what you want.

---

## 6.2.5 `re.sub(pattern, repl, string, count=0, flags=0)`

**What it does:**
Substitutes occurrences of the pattern in the string with `repl`. Returns the new string. If `count` is given, only replaces that many occurrences (0 means replace all).

`repl` can be:

* A string: may contain backreferences like `\1` or `\g<1>` to include captured groups.
* A function: a callable that receives a `Match` object and returns the replacement string — very powerful for dynamic replacements.

**Plain-English:** "Find all text that matches this pattern and replace it with something else."

**Basic example:**

```python
re.sub(r'\d+', '#', 'ID 123 and 456')
# -> 'ID # and #'
```

**Using captured groups in replacement:**

```python
re.sub(r'(\w+), (\w+)', r'\2 \1', 'Doe, John')  # swap names
# -> 'John Doe'
```

**Using a function for transformations:**

```python
def repl(m):
    return str(int(m.group()) * 2)

re.sub(r'\d+', repl, 'a1 b2 c3')  # -> 'a2 b4 c6'
```

**Gotchas / tips:**

* If `repl` is a string and uses `\1`, prefer raw strings `r'\1'` or `r'\g<1>'` to avoid Python escape issues.
* Use function replacements when the replacement depends on matched text.

---

## 6.2.6 `re.compile(pattern, flags=0)`

**What it does:**
Compiles a regex pattern into a `Pattern` object. This object has methods like `.search()`, `.match()`, `.findall()`, `.finditer()`, `.sub()`, `.split()` — the same operations but bound to this compiled pattern.

**Plain-English:** "Pre-build" the pattern so Python doesn't re-parse it every time. Do this for reused patterns (performance & clarity).

**Example:**

```python
pat = re.compile(r'\b\w+\b')
pat.findall('one two three')  # -> ['one','two','three']
```

**Why use it:**

* **Performance:** compiling once and reusing is faster when applying the same pattern repeatedly.
* **Organization:** you can attach flags to the pattern at compile time and use `pat` methods.

**Flags inline alternative:** `re.compile(r'pattern', re.I | re.M)`

**Gotchas / tips:**

* Use `re.VERBOSE` while compiling for readable regex with comments:

```python
pat = re.compile(r'''
    ^               # start
    (\d{3})         # area code
    [- ]?           # optional separator
    (\d{3})         # prefix
    [- ]?(\d{4})$   # line number
''', re.VERBOSE)
```

---

## 6.2.7 `re.split(pattern, string, maxsplit=0, flags=0)`

**What it does:**
Splits the string by occurrences of the pattern, returning a list of substrings. If the pattern contains capturing groups, the text matched by groups is also included in the result.

**Plain-English:** Like `str.split()` but you can split using a regex pattern (for complex separators).

**Example — splitting on whitespace (simple):**

```python
re.split(r'\s+', 'a  b \n c')  # -> ['a', 'b', 'c']
```

**Example — capturing separators:**

```python
re.split(r'(\d+)', 'a1b23c')  # -> ['a', '1', 'b', '23', 'c']
```

Because the group captured the digits, they appear in the result list.

**Gotchas / tips:**

* If you want to discard separators, don't capture them.
* `maxsplit` behaves like in `str.split`.

---

# Extra: `Match` object details (used by search/match/finditer)

When you have a `Match` object `m`:

* `m.group()` or `m.group(0)` — entire match.
* `m.group(1)`, `m.group(2)`, ... — groups.
* `m.groups()` — tuple of all groups.
* `m.groupdict()` — dict of named groups.
* `m.start()` / `m.end()` / `m.span()` — indices of the match in the original string.
* `m.re` — pattern object; `m.string` — original string.

---

# Practical examples and explanations (real-ish use cases)

### 1) Validate a simple email (not perfect, but practical)

```python
pattern = r'^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
re.match(pattern, 'john.doe@example.com')  # Match object if valid
```

Plain: start-to-end pattern that enforces an `@` and a suffix of letters.

### 2) Extract all URLs (simple version)

```python
urls = re.findall(r'https?://[^\s,"]+', text)
```

Plain: `http` or `https`, then everything until whitespace or common separators.

### 3) Swap `Last, First` to `First Last`

```python
re.sub(r'(\w+),\s*(\w+)', r'\2 \1', 'Doe, John; Smith, Jane')
# -> 'John Doe; Jane Smith'
```

Plain: capture two words separated by comma, replace with group order reversed.

### 4) Remove HTML tags (quick-and-dirty)

```python
clean = re.sub(r'<[^>]+>', '', html_text)
```

Plain: matches `<...>` and removes. (Caveat: regex is brittle for complex HTML; use an HTML parser for robust work.)

### 5) Find overlapping matches (advanced)

To find overlapping `aba` in `ababa`, use lookahead:

```python
re.findall(r'(?=(aba))', 'ababa')  # -> ['aba', 'aba'] overlapping matches
```

Plain: lookahead checks position and captures overlapping occurrences.

---

# Practical tips, best practices & common pitfalls (for dummies)

* **Use raw strings** for patterns: `r"\n"` vs `"\\n"` — raw strings avoid double backslashes.
* **Start simple**: test patterns incrementally.
* **Use `re.VERBOSE`** for complex patterns — break into lines and comment.
* **Prefer `finditer` when you need positions** or to avoid building big lists.
* **Escape user input** when building regex from user text: use `re.escape(user_input)` to avoid surprises (`.` or `*` in user input become literal).
* **Don't use regex to parse nested/complex HTML/XML**; use a parser (BeautifulSoup, lxml).
* **Remember greediness**: if `.*` gobbles too much, try `.*?` or more specific patterns.
* **Be careful with `^` and `$` and MULTILINE**: they behave differently depending on flags.
* **Profiling**: some regexes are expensive and can be exploited (catastrophic backtracking). If a pattern has many nested quantifiers (e.g., `(.*a)+`), test performance on long strings.

---

# Quick handy cheat-sheet (patterns you will use a lot)

* `\d+` — one or more digits
* `\w+` — one or more word characters
* `\s+` — whitespace sequence
* `^...$` — whole-string match
* `\bword\b` — whole word `word`
* `(?:abc)` — non-capturing group
* `(?P<name>...)` — named capture
* `(?=...)` / `(?!...)` — lookahead assertions
* `(?<=...)` / `(?<!...)` — lookbehind assertions (fixed width in `re`)

---

# Short cheat examples for each `re` method (one-liners)

* `findall`:

```python
re.findall(r'\w+', 'This is 1 test')  # -> ['This','is','1','test']
```

* `finditer`:

```python
[m.span() for m in re.finditer(r'\d+', '12 and 345')]  # -> [(0,2),(7,10)]
```

* `search`:

```python
m = re.search(r'cat', 'dog and cat'); m and m.group()  # -> 'cat'
```

* `match`:

```python
bool(re.match(r'\d+', '123abc'))  # True; at start
```

* `sub`:

```python
re.sub(r'\s+', ' ', 'a   b\tc\n')  # -> 'a b c'
```

* `compile`:

```python
p = re.compile(r'\b\w+\b'); p.findall('a b c')  # -> ['a','b','c']
```

* `split`:

```python
re.split(r'[;,\s]\s*', 'a, b; c d')  # -> ['a','b','c','d']
```

---

# Example "lesson plan" you can give students

1. Explain raw strings and import `re`.
2. Show simple pattern matches (`search`, `match`).
3. Teach `\d`, `\w`, `\s`, `[]` classes, `+`, `*`, `?`, `{m,n}` with examples.
4. Demonstrate groups and named groups with `findall` vs `finditer`.
5. Show `sub` with a function (dynamic replacement).
6. Introduce flags: `re.I`, `re.M`, `re.S`, `re.X`.
7. Cover lookarounds with lots of small examples.
8. End with pitfalls: greediness, escaping user input, performance.

---

