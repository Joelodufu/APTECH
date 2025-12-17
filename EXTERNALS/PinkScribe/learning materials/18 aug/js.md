# 🌟 JavaScript Cheatsheet

## Variables and Data Types

| Feature   | Uses                                               | Example                     | Explanation                                                   | Practical Uses               |
| --------- | -------------------------------------------------- | --------------------------- | ------------------------------------------------------------- | ---------------------------- |
| var       | Declares a variable with function or global scope. | `var x = 5;`                | Old way of declaring variables, scope issues.                 | Legacy code.                 |
| let       | Declares a block-scoped variable.                  | `let y = 10;`               | Safer than `var`, respects block scope.                       | Loop counters, conditionals. |
| const     | Declares a block-scoped constant.                  | `const z = 20;`             | Cannot be reassigned, but object properties can still change. | API keys, fixed values.      |
| Number    | Represents numeric values.                         | `let num = 42.5;`           | Handles integers and floats.                                  | Math operations.             |
| String    | Represents text.                                   | `let str = "Hello";`        | Holds characters wrapped in quotes.                           | Names, messages.             |
| Boolean   | Represents true/false.                             | `let isActive = true;`      | Logical values for conditions.                                | Toggles, flags.              |
| Array     | Stores ordered lists.                              | `let arr = [1,2,3];`        | Indexed collection of values.                                 | Lists, product catalogs.     |
| Object    | Stores key-value pairs.                            | `let obj = {name:"John"};`  | Groups related data.                                          | User profiles, configs.      |
| null      | Intentional absence of value.                      | `let value = null;`         | Explicitly "nothing".                                         | Resetting data.              |
| undefined | Uninitialized variable.                            | `let x;`                    | Means "no value assigned".                                    | Checking variable states.    |
| Symbol    | Creates unique identifiers.                        | `const sym = Symbol('id');` | Always unique, even with same description.                    | Private object keys.         |
| BigInt    | Very large integers.                               | `let big = 123n;`           | Numbers beyond `Number.MAX_SAFE_INTEGER`.                     | Cryptography, finance.       |

---

## Functions

| Feature              | Uses                         | Example                                       | Explanation                   | Practical Uses     |
| -------------------- | ---------------------------- | --------------------------------------------- | ----------------------------- | ------------------ |
| function declaration | Defines a named function.    | `function add(a,b){ return a+b; }`            | Hoisted, reusable.            | Calculations.      |
| function expression  | Stores function in variable. | `const multiply = function(a,b){return a*b;}` | Not hoisted, flexible.        | Callbacks.         |
| arrow function       | Concise function syntax.     | `const square = x => x*x;`                    | Shorter, keeps `this`.        | Event handlers.    |
| default parameters   | Default argument values.     | `function greet(name="Guest"){...}`           | Avoids `undefined` arguments. | Optional API args. |
| rest parameters      | Collects args into array.    | `function sum(...nums){...}`                  | Allows variable inputs.       | Math utilities.    |
| spread operator      | Expands arrays/objects.      | `[...arr, 4]`                                 | Clones, merges data.          | Copying objects.   |

---

## Array Methods

| Feature  | Uses                        | Example                          | Explanation              | Practical Uses    |
| -------- | --------------------------- | -------------------------------- | ------------------------ | ----------------- |
| push     | Add element at end.         | `arr.push(4)`                    | Expands array length.    | Shopping cart.    |
| pop      | Remove last element.        | `arr.pop()`                      | Shrinks array.           | Stack operations. |
| shift    | Remove first element.       | `arr.shift()`                    | Removes from front.      | Queue processing. |
| unshift  | Add to start.               | `arr.unshift(0)`                 | Inserts at beginning.    | Prepending.       |
| map      | Transform each element.     | `arr.map(x=>x*2)`                | Returns new array.       | Data formatting.  |
| filter   | Keep matching elements.     | `arr.filter(x=>x>2)`             | Removes unwanted.        | Search results.   |
| reduce   | Fold array into one value.  | `arr.reduce((a,b)=>a+b)`         | Accumulates results.     | Totals.           |
| forEach  | Run function on each item.  | `arr.forEach(x=>console.log(x))` | No return value.         | Logging.          |
| find     | Get first matching element. | `arr.find(x=>x===3)`             | Returns first match.     | Lookup.           |
| includes | Check if value exists.      | `arr.includes(2)`                | Returns boolean.         | Validation.       |
| slice    | Copy portion.               | `arr.slice(1,3)`                 | Doesn’t modify original. | Pagination.       |
| splice   | Add/remove in-place.        | `arr.splice(1,1,"new")`          | Changes array.           | Editing lists.    |
| concat   | Merge arrays.               | `arr.concat([4,5])`              | Creates new array.       | Combine data.     |
| join     | Convert to string.          | `arr.join(",")`                  | Joins with delimiter.    | CSV export.       |

---

## String Methods

| Feature     | Uses                | Example                  | Explanation               | Practical Uses      |
| ----------- | ------------------- | ------------------------ | ------------------------- | ------------------- |
| toUpperCase | Uppercase text.     | `"hi".toUpperCase()`     | Doesn’t modify original.  | Formatting titles.  |
| toLowerCase | Lowercase text.     | `"HI".toLowerCase()`     | Normalizes strings.       | User input.         |
| trim        | Remove whitespace.  | `" hi ".trim()`          | From both ends.           | Clean inputs.       |
| split       | Split into array.   | `"a,b".split(",")`       | Breaks into parts.        | Parsing CSV.        |
| replace     | Replace text.       | `"hi".replace("h","H")`  | First match by default.   | Text updates.       |
| substring   | Extract characters. | `"hello".substring(1,4)` | Doesn’t accept negatives. | Parsing.            |
| slice       | Extract portion.    | `"hello".slice(1,4)`     | Accepts negatives.        | Text clipping.      |
| includes    | Check substring.    | `"hello".includes("he")` | Boolean result.           | Validation.         |
| startsWith  | Starts with check.  | `"hi".startsWith("h")`   | Boolean result.           | Search filters.     |
| endsWith    | Ends with check.    | `"hi".endsWith("i")`     | Boolean result.           | File extensions.    |
| match       | Regex match.        | `"hi".match(/h/)`        | Returns array or null.    | Pattern extraction. |
| charAt      | Get character.      | `"hi".charAt(0)`         | Returns string of 1 char. | Parsing.            |

---

## Objects

| Feature        | Uses                   | Example                  | Explanation                  | Practical Uses      |
| -------------- | ---------------------- | ------------------------ | ---------------------------- | ------------------- |
| Object.keys    | Get keys array.        | `Object.keys(obj)`       | Returns property names.      | Iteration.          |
| Object.values  | Get values array.      | `Object.values(obj)`     | Returns property values.     | Display data.       |
| Object.entries | Get key-value pairs.   | `Object.entries(obj)`    | Array of pairs.              | Converting to maps. |
| Object.assign  | Copy properties.       | `Object.assign({}, obj)` | Shallow copy/merge.          | Cloning configs.    |
| Object.create  | Create from prototype. | `Object.create(proto)`   | Prototype-based inheritance. | OOP.                |
| Object.freeze  | Lock object.           | `Object.freeze(obj)`     | Prevents changes.            | Immutable configs.  |

---

## Control Flow

| Feature     | Uses                        | Example                     | Explanation                | Practical Uses            |
| ----------- | --------------------------- | --------------------------- | -------------------------- | ------------------------- |
| if          | Run code if true.           | `if(x>0){...}`              | Conditional branching.     | Form validation.          |
| else        | Alternative if false.       | `if(x){...}else{...}`       | Provides fallback.         | Default logic.            |
| switch      | Multiple branches.          | `switch(day){case 1:...}`   | Cleaner than many `if`s.   | State handling.           |
| for         | Loop counter.               | `for(let i=0;i<5;i++){...}` | Runs fixed times.          | Iterations.               |
| while       | Loop until condition false. | `while(x>0){x--}`           | Checks before looping.     | Processing tasks.         |
| do...while  | Runs at least once.         | `do{x--}while(x>0)`         | Checks after loop.         | Games, retries.           |
| for...of    | Loop over iterable.         | `for(x of arr){...}`        | Easier for arrays/strings. | Lists.                    |
| for...in    | Loop over keys.             | `for(k in obj){...}`        | Iterates object props.     | Inspecting objects.       |
| break       | Exit loop.                  | `break;`                    | Stops loop immediately.    | Early exit.               |
| continue    | Skip iteration.             | `continue;`                 | Skips to next loop.        | Skipping invalid entries. |
| try...catch | Handle errors.              | `try{...}catch(e){...}`     | Graceful error handling.   | API calls.                |

---

## DOM Manipulation

| Feature                | Uses                  | Example                               | Explanation                    | Practical Uses   |
| ---------------------- | --------------------- | ------------------------------------- | ------------------------------ | ---------------- |
| document.querySelector | Select first element. | `document.querySelector(".cls")`      | Uses CSS selector.             | Dynamic UI.      |
| getElementById         | Select by ID.         | `document.getElementById("id")`       | Fast, unique match.            | Forms.           |
| innerHTML              | Set/get HTML.         | `el.innerHTML="<p>Hi</p>"`            | Replaces HTML inside.          | Dynamic content. |
| style                  | Inline style changes. | `el.style.color="red"`                | Applies CSS inline.            | Interactivity.   |
| addEventListener       | Add event handler.    | `el.addEventListener("click", fn)`    | Multiple handlers allowed.     | Buttons.         |
| removeEventListener    | Remove handler.       | `el.removeEventListener("click", fn)` | Needs same function reference. | Cleanup.         |
| classList              | Manage classes.       | `el.classList.add("active")`          | Add/remove/toggle classes.     | Toggling states. |
| createElement          | Make new element.     | `document.createElement("div")`       | Creates DOM nodes.             | Dynamic UI.      |

---

## Asynchronous JavaScript

| Feature       | Uses                  | Example                           | Explanation              | Practical Uses  |
| ------------- | --------------------- | --------------------------------- | ------------------------ | --------------- |
| setTimeout    | Delay code.           | `setTimeout(fn,1000)`             | Runs once after delay.   | Notifications.  |
| setInterval   | Repeat code.          | `setInterval(fn,1000)`            | Loops until cleared.     | Timers.         |
| clearTimeout  | Stop timeout.         | `clearTimeout(id)`                | Cancels delayed task.    | Cancel actions. |
| clearInterval | Stop interval.        | `clearInterval(id)`               | Cancels repeated task.   | Stop timers.    |
| Promise       | Async result wrapper. | `new Promise((res)=>res("done"))` | Represents future value. | API handling.   |
| async/await   | Cleaner async code.   | `await fetch(url)`                | Pauses until resolved.   | Data fetching.  |
| fetch         | HTTP requests.        | `fetch("/api").then(...)`         | Promise-based API calls. | Web requests.   |

---

## ES6+

| Feature           | Uses                  | Example                    | Explanation                | Practical Uses |
| ----------------- | --------------------- | -------------------------- | -------------------------- | -------------- |
| destructuring     | Unpack values.        | `let {a,b}=obj`            | Extract properties easily. | Cleaner code.  |
| template literals | Embedded expressions. | `` `Hi ${name}` ``         | Backtick syntax.           | Dynamic text.  |
| import            | Bring module.         | `import x from "./mod.js"` | Imports functions/objects. | Modular apps.  |
| export            | Share module.         | `export function fn(){}`   | Makes code reusable.       | Shared utils.  |
| class             | Define blueprint.     | `class Car{...}`           | OOP, constructor-based.    | Models.        |

---
