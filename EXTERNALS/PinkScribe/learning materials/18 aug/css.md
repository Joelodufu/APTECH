
# 🌟 CSS Cheatsheet

## Basics

Features for styling with CSS.

| Feature            | Uses                         | Example                        | Explanation                             | Practical Uses                     |
| ------------------ | ---------------------------- | ------------------------------ | --------------------------------------- | ---------------------------------- |
| Selector           | Selects elements to style.   | `p { color: red; }`            | Applies styles to all `<p>` tags.       | Changing default look of elements. |
| Class Selector     | Targets elements with class. | `.btn { background: blue; }`   | Styles elements with class="btn".       | Reusable button styles.            |
| ID Selector        | Targets element by ID.       | `#header { font-size: 20px; }` | Styles unique element with id="header". | Specific unique section.           |
| Inline Style       | Direct style in element.     | `<p style="color:green;">`     | Overrides stylesheet but not reusable.  | Quick one-off fixes.               |
| Universal Selector | Styles all elements.         | `* { margin: 0; }`             | Affects everything on page.             | Reset default spacing.             |

---

## Colors & Backgrounds

| Feature          | Uses                      | Example                                   | Explanation                     | Practical Uses           |
| ---------------- | ------------------------- | ----------------------------------------- | ------------------------------- | ------------------------ |
| Color            | Sets text color.          | `p { color: blue; }`                      | Changes text color.             | Branding, emphasis.      |
| Background Color | Sets element background.  | `div { background: yellow; }`             | Fills element box with color.   | Section highlights.      |
| Background Image | Sets image as background. | `div { background-image: url(bg.jpg); }`  | Applies image inside box.       | Hero sections, banners.  |
| Gradient         | Smooth color transition.  | `background: linear-gradient(red, blue);` | Creates gradient background.    | Buttons, modern designs. |
| Opacity          | Adjusts transparency.     | `div { opacity: 0.5; }`                   | Makes element semi-transparent. | Overlays, fades.         |

---

## Typography

| Feature     | Uses                            | Example                                 | Explanation                   | Practical Uses       |
| ----------- | ------------------------------- | --------------------------------------- | ----------------------------- | -------------------- |
| Font Family | Sets typeface.                  | `p { font-family: Arial, sans-serif; }` | Defines font style.           | Branding text.       |
| Font Size   | Sets text size.                 | `p { font-size: 18px; }`                | Controls readability.         | Headings, body text. |
| Font Weight | Boldness of text.               | `p { font-weight: bold; }`              | Makes text thicker.           | Emphasis.            |
| Text Align  | Aligns text horizontally.       | `p { text-align: center; }`             | Left, right, center, justify. | Centered headings.   |
| Line Height | Controls spacing between lines. | `p { line-height: 1.6; }`               | Improves readability.         | Paragraph styling.   |

---

## Box Model

| Feature      | Uses                            | Example                                | Explanation                            | Practical Uses      |
| ------------ | ------------------------------- | -------------------------------------- | -------------------------------------- | ------------------- |
| Margin       | Space outside element.          | `div { margin: 20px; }`                | Creates outer spacing.                 | Layout spacing.     |
| Padding      | Space inside element.           | `div { padding: 10px; }`               | Inner spacing around content.          | Button padding.     |
| Border       | Outline of element.             | `div { border: 2px solid black; }`     | Adds border around box.                | Input fields.       |
| Width/Height | Sets element size.              | `div { width: 200px; height: 100px; }` | Fixes element dimensions.              | Containers.         |
| Box Sizing   | Defines how size is calculated. | `div { box-sizing: border-box; }`      | Includes padding/border in total size. | Consistent layouts. |

---

## Positioning & Layout

| Feature  | Uses                       | Example                                  | Explanation                                | Practical Uses               |
| -------- | -------------------------- | ---------------------------------------- | ------------------------------------------ | ---------------------------- |
| Display  | Sets element display type. | `div { display: flex; }`                 | Options: block, inline, flex, grid.        | Layout design.               |
| Position | Controls placement.        | `div { position: absolute; top: 10px; }` | Static, relative, absolute, fixed, sticky. | Navbars, modals.             |
| Z-Index  | Layer order.               | `div { z-index: 10; }`                   | Higher values appear above others.         | Modals, overlays.            |
| Float    | Moves element left/right.  | `img { float: right; }`                  | Old layout method, still useful.           | Wrapping text around images. |
| Clear    | Controls float wrapping.   | `p { clear: both; }`                     | Prevents overlap after floated elements.   | Fixing layout issues.        |

---

## Flexbox

| Feature         | Uses                      | Example                           | Explanation                            | Practical Uses     |
| --------------- | ------------------------- | --------------------------------- | -------------------------------------- | ------------------ |
| Display Flex    | Activates flexbox.        | `div { display: flex; }`          | Enables flex container.                | Navbars, grids.    |
| Justify Content | Align items horizontally. | `justify-content: space-between;` | Start, end, center, space-around, etc. | Navigation menus.  |
| Align Items     | Align vertically.         | `align-items: center;`            | Aligns children inside container.      | Centered layouts.  |
| Flex Wrap       | Controls wrapping.        | `flex-wrap: wrap;`                | Items move to next line if needed.     | Responsive grids.  |
| Flex Grow       | Allows items to expand.   | `flex: 1;`                        | Divides available space.               | Equal-width cards. |

---

## Grid

| Feature               | Uses                           | Example                                  | Explanation                         | Practical Uses         |
| --------------------- | ------------------------------ | ---------------------------------------- | ----------------------------------- | ---------------------- |
| Display Grid          | Enables grid layout.           | `div { display: grid; }`                 | Turns element into grid container.  | Dashboards, galleries. |
| Grid Template Columns | Defines columns.               | `grid-template-columns: repeat(3, 1fr);` | Creates 3 equal columns.            | Layout sections.       |
| Grid Gap              | Spacing between items.         | `gap: 20px;`                             | Space between rows/columns.         | Clean layouts.         |
| Grid Row/Col Span     | Spans multiple cells.          | `grid-column: span 2;`                   | Expands item across columns.        | Wide cards.            |
| Place Items           | Shorthand for align & justify. | `place-items: center;`                   | Centers content in both directions. | Centered widgets.      |

---

## Transitions & Animations

| Feature     | Uses                     | Example                                              | Explanation                 | Practical Uses        |
| ----------- | ------------------------ | ---------------------------------------------------- | --------------------------- | --------------------- |
| Transition  | Smooth property changes. | `transition: all 0.3s ease;`                         | Animates changes.           | Button hover effects. |
| Transform   | Rotate, scale, skew.     | `transform: rotate(45deg);`                          | Changes element visually.   | Rotating icons.       |
| Animation   | Defines keyframes.       | `animation: bounce 2s infinite;`                     | Creates continuous effects. | Loaders, banners.     |
| Keyframes   | Define animation steps.  | `@keyframes bounce { from {top:0;} to {top:10px;} }` | Sets animation motion.      | Custom animations.    |
| Hover/Focus | Pseudo-classes.          | `button:hover { background: red; }`                  | Adds interactivity.         | Links, buttons.       |

---
