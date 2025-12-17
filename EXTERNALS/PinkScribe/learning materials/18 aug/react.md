# 🌟 ReactJS Cheatsheet

## Basics

| Feature   | Uses                          | Example                                               | Explanation                          | Practical Uses     |
| --------- | ----------------------------- | ----------------------------------------------------- | ------------------------------------ | ------------------ |
| JSX       | Write HTML-like syntax in JS. | `<h1>Hello {name}</h1>`                               | Compiled into `React.createElement`. | UI rendering.      |
| Component | Reusable UI piece.            | `function Button(){ return <button>Click</button>; }` | Building blocks of React apps.       | Buttons, forms.    |
| Props     | Pass data to components.      | `<User name="John"/>`                                 | Read-only inputs to components.      | Dynamic content.   |
| State     | Manage local data.            | `const [count,setCount]=useState(0);`                 | Triggers re-render when updated.     | Counters, toggles. |
| Render    | Return UI output.             | `return <div>Hello</div>`                             | Every component must return JSX.     | Display content.   |

---

## Hooks

| Feature     | Uses                           | Example                                 | Explanation                                   | Practical Uses            |
| ----------- | ------------------------------ | --------------------------------------- | --------------------------------------------- | ------------------------- |
| useState    | Add state.                     | `const [val,setVal]=useState(0)`        | Returns variable + updater fn.                | Counters, inputs.         |
| useEffect   | Side effects.                  | `useEffect(()=>{ fetchData(); },[])`    | Runs after render, dependencies control when. | API calls, timers.        |
| useContext  | Access context.                | `const theme = useContext(ThemeCtx)`    | Reads values from provider.                   | Theming, auth.            |
| useRef      | Persist values across renders. | `const inputRef = useRef(null)`         | Doesn’t trigger re-renders.                   | DOM access, timers.       |
| useReducer  | Complex state logic.           | `useReducer(reducer,initState)`         | Alternative to `useState`.                    | Forms, dashboards.        |
| useMemo     | Memoize values.                | `useMemo(()=>expensiveFn(),[deps])`     | Prevents recalculations.                      | Performance boost.        |
| useCallback | Memoize functions.             | `useCallback(()=>doSomething(),[deps])` | Prevents unnecessary re-renders.              | Passing stable callbacks. |

---

## Props & State

| Feature             | Uses                    | Example                                  | Explanation          | Practical Uses        |
| ------------------- | ----------------------- | ---------------------------------------- | -------------------- | --------------------- |
| Passing Props       | Send values to child.   | `<Child msg="Hi"/>`                      | Props are immutable. | Reusable components.  |
| Destructuring Props | Cleaner access.         | `function C({msg}){return <p>{msg}</p>}` | Avoids `props.msg`.  | Readability.          |
| State Updates       | Change component state. | `setCount(count+1)`                      | Triggers re-render.  | Counters, UI updates. |

---

## Events

| Feature      | Uses                    | Example                                         | Explanation                                | Practical Uses            |
| ------------ | ----------------------- | ----------------------------------------------- | ------------------------------------------ | ------------------------- |
| onClick      | Handle clicks.          | `<button onClick={handleClick}>Go</button>`     | Uses camelCase in JSX.                     | Buttons.                  |
| onChange     | Track input changes.    | `<input onChange={e=>setVal(e.target.value)}/>` | Gets `event` object.                       | Forms.                    |
| onSubmit     | Handle form submission. | `<form onSubmit={handleSubmit}>...</form>`      | Prevent default with `e.preventDefault()`. | Validations.              |
| onMouseEnter | Hover effects.          | `<div onMouseEnter={fn}>Hover</div>`            | Runs when mouse enters element.            | Tooltips.                 |
| onKeyDown    | Keyboard events.        | `<input onKeyDown={fn}/>`                       | Captures key presses.                      | Shortcuts, accessibility. |

---

## Conditional Rendering

| Feature          | Uses                | Example                                  | Explanation                          | Practical Uses   |
| ---------------- | ------------------- | ---------------------------------------- | ------------------------------------ | ---------------- |
| Ternary Operator | Inline condition.   | `{isLoggedIn ? <Dashboard/> : <Login/>}` | Renders one of two components.       | Auth UI.         |
| Logical AND      | Render if true.     | `{error && <p>{error}</p>}`              | Renders only when condition is true. | Alerts.          |
| Early Return     | Conditional return. | `if(!data) return <Spinner/>`            | Prevents further rendering.          | Loading screens. |

---

## Lists & Keys

| Feature  | Uses             | Example                                        | Explanation                      | Practical Uses  |
| -------- | ---------------- | ---------------------------------------------- | -------------------------------- | --------------- |
| map      | Render lists.    | `{items.map(i=><li key={i.id}>{i.name}</li>)}` | Each child needs unique key.     | Dynamic tables. |
| key Prop | Unique identity. | `<li key={id}>...</li>`                        | Helps React optimize re-renders. | Performance.    |

---

## Forms

| Feature          | Uses                 | Example                                                     | Explanation                | Practical Uses   |
| ---------------- | -------------------- | ----------------------------------------------------------- | -------------------------- | ---------------- |
| Controlled Input | Bind value to state. | `<input value={val} onChange={e=>setVal(e.target.value)}/>` | React controls form input. | Form validation. |
| Textarea         | Controlled textarea. | `<textarea value={msg} onChange={...}/>`                    | Works like input.          | Comments.        |
| Select           | Controlled select.   | `<select value={sel} onChange={...}>...</select>`           | Works with `value`.        | Dropdowns.       |
| Checkbox         | Boolean value.       | `<input type="checkbox" checked={isOn} onChange={...}/>`    | Uses `checked` prop.       | Toggles.         |

---

## Context API

| Feature       | Uses             | Example                                                   | Explanation                     | Practical Uses           |
| ------------- | ---------------- | --------------------------------------------------------- | ------------------------------- | ------------------------ |
| createContext | Make context.    | `const ThemeCtx=createContext()`                          | Creates global state container. | Theme, auth.             |
| Provider      | Wrap components. | `<ThemeCtx.Provider value="dark">...</ThemeCtx.Provider>` | Passes value to children.       | Global theming.          |
| useContext    | Consume context. | `const theme=useContext(ThemeCtx)`                        | Reads value directly.           | Access theme everywhere. |

---

## React Router (v6)

| Feature       | Uses                       | Example                                                | Explanation                 | Practical Uses   |
| ------------- | -------------------------- | ------------------------------------------------------ | --------------------------- | ---------------- |
| BrowserRouter | Router wrapper.            | `<BrowserRouter>...</BrowserRouter>`                   | Enables routing in app.     | Multi-page apps. |
| Routes        | Define routes.             | `<Routes><Route path="/" element={<Home/>}/></Routes>` | Contains route mappings.    | Page navigation. |
| Route         | Match path to component.   | `<Route path="/about" element={<About/>}/>`            | Renders component for path. | Page switching.  |
| Link          | Navigate between routes.   | `<Link to="/about">About</Link>`                       | Client-side navigation.     | Menus.           |
| useNavigate   | Navigate programmatically. | `const nav=useNavigate(); nav("/home")`                | Change route in code.       | Redirects.       |

---

## Advanced

| Feature        | Uses                       | Example                                              | Explanation                   | Practical Uses      |
| -------------- | -------------------------- | ---------------------------------------------------- | ----------------------------- | ------------------- |
| Lazy Loading   | Load components on demand. | `const Comp=React.lazy(()=>import("./Comp"))`        | Improves performance.         | Code splitting.     |
| Suspense       | Fallback UI while loading. | `<Suspense fallback={<Spinner/>}><Comp/></Suspense>` | Works with `lazy`.            | Loading spinners.   |
| Error Boundary | Catch render errors.       | `componentDidCatch(error,info){...}`                 | Only in class components.     | Graceful fallback.  |
| Portals        | Render outside root.       | `ReactDOM.createPortal(<Modal/>, el)`                | Renders in separate DOM node. | Modals, tooltips.   |
| StrictMode     | Highlight issues.          | `<React.StrictMode>...</React.StrictMode>`           | Helps detect unsafe patterns. | Dev-only debugging. |

---

⚡ That’s the **ReactJS cheatsheet** in the exact same format as your JS & CSS versions.
