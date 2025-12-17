# HTML Elements Guide

This guide organizes HTML elements into categories, building on the provided structure. Each category includes a list of relevant elements, followed by a table detailing the element, its uses, an example, and practical uses. Categories are expanded to cover all standard HTML elements (excluding obsolete/deprecated ones for modernity). The structure draws from standard HTML references for completeness.

## Semantic Elements: For Structuring and Partitions
These elements provide meaning to the document structure, helping with accessibility, SEO, and layout without implying specific styling.

Elements:
1. div
2. header
3. nav
4. aside
5. footer
6. article
7. main
8. section
9. address
10. hgroup
11. search

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| div | A generic container for grouping content, often used for styling or scripting purposes. | `<div class="container">Content here</div>` | Wrapping sections of a page for CSS layouts, like creating columns or modals in web apps. |
| header | Represents introductory content or navigational aids at the top of a page or section. | `<header><h1>Site Title</h1></header>` | Site banners, logos, and menus in websites; section intros in articles. |
| nav | Defines a set of navigation links. | `<nav><ul><li><a href="/">Home</a></li></ul></nav>` | Main menus, sidebars, or pagination in blogs and e-commerce sites. |
| aside | Represents content indirectly related to the main content, like sidebars. | `<aside><h3>Related Links</h3></aside>` | Sidebars with ads, related articles, or author bios in news sites. |
| footer | Defines a footer for a document or section, typically containing copyright or contact info. | `<footer>&copy; 2025 Company</footer>` | Bottom sections of pages with links, social media, or disclaimers in corporate websites. |
| article | Represents self-contained content that could be distributed independently. | `<article><h2>News Story</h2><p>Details...</p></article>` | Blog posts, forum threads, or news articles in content-heavy sites. |
| main | Specifies the main content of the document, unique to the page. | `<main><article>Primary content</article></main>` | Central area of a webpage, excluding headers/footers, for better accessibility in apps. |
| section | Represents a standalone section of content, often with a heading. | `<section><h2>Chapter 1</h2><p>Text...</p></section>` | Dividing long pages into thematic parts, like in tutorials or reports. |
| address | Provides contact information for the author or owner of a document/section. | `<address>Email: info@example.com</address>` | Contact details in footers or about pages for businesses. |
| hgroup | Groups a set of heading elements (h1-h6) when the heading has multiple levels. | `<hgroup><h1>Main Title</h1><h2>Subtitle</h2></hgroup>` | Complex headings in articles or books, though rarely used due to modern alternatives. |
| search | Represents a part of the page for search functionality. | `<search><form><input type="search"></form></search>` | Search bars in headers for e-commerce or wiki sites. |

## Content Centric Elements
These focus on presenting and organizing content, grouped into subcategories as suggested.

### 1. Text Elements
Elements for handling text, including headings, paragraphs, and inline formatting.

Elements: h1, h2, h3, h4, h5, h6, p, b, strong, em, i, u, s, small, sub, sup, abbr, code, samp, kbd, var, dfn, mark, q, cite, time, data, br, wbr, span, bdi, bdo, pre, blockquote, figcaption, figure

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| h1 to h6 | Define headings with decreasing importance (h1 most important). | `<h1>Main Heading</h1>` | Page titles (h1), subsections (h2-h6) for SEO and structure in documents. |
| p | Defines a paragraph of text. | `<p>This is a paragraph.</p>` | Body text in articles, blogs, or descriptions. |
| b | Bold text without added importance. | `<b>Bold text</b>` | Styling keywords in UI, though strong is preferred for semantics. |
| strong | Indicates strong importance, typically bold. | `<strong>Important!</strong>` | Emphasizing warnings or key terms in instructions. |
| em | Emphasized text, typically italic. | `<em>Emphasized</em>` | Stressing words in sentences for readability in narratives. |
| i | Italic text without emphasis. | `<i>Italic</i>` | Foreign words or thoughts in text. |
| u | Underlined text. | `<u>Underlined</u>` | Misspelled words in editors or links (though a is better for links). |
| s | Strikethrough text for deleted content. | `<s>Old price: $10</s>` | Showing discounts in e-commerce or edits in wikis. |
| small | Smaller text for side comments. | `<small>Copyright notice</small>` | Fine print in footers or disclaimers. |
| sub | Subscript text. | `H<sub>2</sub>O` | Chemical formulas or footnotes. |
| sup | Superscript text. | `x<sup>2</sup>` | Math equations or ordinal numbers like 1<sup>st</sup>. |
| abbr | Abbreviation with optional title for expansion. | `<abbr title="HyperText Markup Language">HTML</abbr>` | Tooltips for acronyms in technical docs. |
| code | Inline code snippet. | `<code>console.log()</code>` | Displaying code in tutorials. |
| samp | Sample output from a program. | `<samp>Error: 404</samp>` | Showing console outputs in docs. |
| kbd | Keyboard input. | `<kbd>Ctrl + C</kbd>` | Instructions for shortcuts in software guides. |
| var | Variable in math or programming. | `<var>x</var>` | Math formulas or code explanations. |
| dfn | Defining instance of a term. | `<dfn>HTML</dfn> is a markup language.` | Glossaries or first mentions in articles. |
| mark | Highlighted text for reference. | `<mark>Highlighted</mark>` | Search results or annotations. |
| q | Inline quotation. | `<q>Quote here</q>` | Short quotes in text. |
| cite | Citation of a creative work. | `<cite>Book Title</cite>` | Referencing sources in blogs. |
| time | Machine-readable date/time. | `<time datetime="2025-08-18">Today</time>` | Event dates for calendars or SEO. |
| data | Machine-readable data. | `<data value="123">Item</data>` | Linking data for scripting in lists. |
| br | Line break. | `Line one<br>Line two` | Poetry or addresses without paragraphs. |
| wbr | Word break opportunity. | `Verylong<wbr>word` | Preventing awkward line breaks in long words. |
| span | Generic inline container. | `<span class="highlight">Text</span>` | Styling parts of text without semantics. |
| bdi | Isolates text for bidirectional control. | `<bdi>Arabic text</bdi>` | Mixing LTR/RTL languages. |
| bdo | Overrides text direction. | `<bdo dir="rtl">Text</bdo>` | Forcing direction in multilingual sites. |
| pre | Preformatted text, preserves whitespace. | `<pre>Code block</pre>` | Displaying code or ASCII art. |
| blockquote | Block quotation. | `<blockquote>Long quote</blockquote>` | Pull quotes in articles. |
| figcaption | Caption for a figure. | `<figure><img src="img.jpg"><figcaption>Caption</figcaption></figure>` | Image descriptions in galleries. |
| figure | Self-contained content like images with caption. | `<figure><img src="img.jpg"></figure>` | Illustrations or charts in reports. |

### 2. Lists
Elements for creating ordered, unordered, or description lists.

Elements: ol, ul, li, dl, dt, dd, menu

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| ol | Ordered list. | `<ol><li>Item 1</li></ol>` | Numbered steps in recipes or tutorials. |
| ul | Unordered list. | `<ul><li>Item</li></ul>` | Bullet points in features lists. |
| li | List item in ol/ul/menu. | `<li>Item</li>` | Individual entries in menus or checklists. |
| dl | Description list. | `<dl><dt>Term</dt><dd>Definition</dd></dl>` | Glossaries or FAQs. |
| dt | Term in description list. | `<dt>HTML</dt>` | Keys in key-value pairs. |
| dd | Description in description list. | `<dd>Markup language</dd>` | Values in definitions. |
| menu | List of commands. | `<menu><li>Option</li></menu>` | Context menus, though rarely used. |

### 3. Tables
Elements for tabular data.

Elements: table, caption, colgroup, col, thead, tbody, tfoot, tr, th, td

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| table | Defines a table. | `<table><tr><td>Cell</td></tr></table>` | Data grids like spreadsheets or schedules. |
| caption | Table title. | `<caption>Table Title</caption>` | Describing table content for accessibility. |
| colgroup | Groups columns for styling. | `<colgroup><col span="2"></colgroup>` | Applying CSS to column groups. |
| col | Defines column properties. | `<col style="width:50%">` | Setting widths in tables. |
| thead | Table header section. | `<thead><tr><th>Header</th></tr></thead>` | Column headers in reports. |
| tbody | Table body section. | `<tbody><tr><td>Data</td></tr></tbody>` | Main data rows. |
| tfoot | Table footer section. | `<tfoot><tr><td>Total</td></tr></tfoot>` | Summary rows like totals. |
| tr | Table row. | `<tr><td>Cell</td></tr>` | Rows in data tables. |
| th | Table header cell. | `<th>Header</th>` | Bold/centered headers. |
| td | Table data cell. | `<td>Data</td>` | Standard cells. |

### 4. Media
Elements for embedding images, audio, video, and other media.

Elements: img, audio, video, source, track, picture, area, map, iframe, embed, object

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| img | Embeds an image. | `<img src="image.jpg" alt="Description">` | Photos in galleries or logos. |
| audio | Embeds sound content. | `<audio src="sound.mp3" controls></audio>` | Podcasts or background music. |
| video | Embeds video content. | `<video src="video.mp4" controls></video>` | Tutorials or ads on sites. |
| source | Specifies multiple media resources. | `<video><source src="video.mp4" type="video/mp4"></video>` | Fallbacks for different formats. |
| track | Timed text track for media. | `<video><track src="subtitles.vtt" kind="subtitles"></video>` | Captions for accessibility. |
| picture | Responsive images with multiple sources. | `<picture><source srcset="large.jpg" media="(min-width:600px)"><img src="small.jpg"></picture>` | Adaptive images for devices. |
| area | Defines clickable areas in image maps. | `<map><area shape="rect" coords="0,0,50,50" href="link"></map>` | Interactive maps or diagrams. |
| map | Defines an image map. | `<img usemap="#map"><map name="map"></map>` | Hotspots on images. |
| iframe | Embeds another HTML page. | `<iframe src="page.html"></iframe>` | Embedding maps or videos from external sources. |
| embed | Embeds external content like plugins. | `<embed src="flash.swf">` | Legacy plugins, rarely used now. |
| object | Embeds multimedia or resources. | `<object data="pdf.pdf"></object>` | PDFs or SVGs in pages. |

### 5. Forms
Elements for user input and data submission.

Subcategories as provided:

#### Inputs
Elements/types: input (with types: text, email, password, number, color, submit, button, file, date, time, month, week, range, search, tel, url, hidden), button

| Element/Type | Uses | Example | Practical Uses |
|--------------|------|---------|----------------|
| input type="text" | Single-line text input. | `<input type="text" name="name">` | Name fields in sign-up forms. |
| input type="email" | Email address input with validation. | `<input type="email" name="email">` | Contact forms. |
| input type="password" | Masked text input. | `<input type="password" name="pass">` | Login screens. |
| input type="number" | Numeric input with spinner. | `<input type="number" name="age">` | Quantity selectors in shops. |
| input type="color" | Color picker. | `<input type="color" name="color">` | Theme customizers. |
| input type="submit" | Form submission button. | `<input type="submit" value="Send">` | Submit buttons in forms. |
| input type="button" | Generic button. | `<input type="button" value="Click">` | Triggering scripts. |
| input type="file" | File upload. | `<input type="file" name="file">` | Profile picture uploads. |
| input type="date" | Date picker. | `<input type="date" name="dob">` | Booking calendars. |
| input type="time" | Time picker. | `<input type="time" name="time">` | Appointment scheduling. |
| input type="month" | Month/year picker. | `<input type="month" name="month">` | Credit card expiration. |
| input type="week" | Week picker. | `<input type="week" name="week">` | Weekly reports. |
| input type="range" | Slider for numeric range. | `<input type="range" min="0" max="100">` | Volume controls. |
| input type="search" | Search input with clear button. | `<input type="search" name="search">` | Site search bars. |
| input type="tel" | Telephone number input. | `<input type="tel" name="phone">` | Contact info. |
| input type="url" | URL input with validation. | `<input type="url" name="website">` | Link submissions. |
| input type="hidden" | Hidden data sent with form. | `<input type="hidden" name="id" value="123">` | Session tokens. |
| button | Clickable button in forms. | `<button type="submit">Submit</button>` | Styled submit buttons. |

#### Selection
Elements: select, option, optgroup, datalist

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| select | Dropdown list. | `<select><option>Value</option></select>` | Country selectors in forms. |
| option | Item in select or datalist. | `<option value="1">Option 1</option>` | Choices in menus. |
| optgroup | Groups options in select. | `<optgroup label="Group"><option>Opt</option></optgroup>` | Categorized dropdowns like continents/countries. |
| datalist | Predefined options for input. | `<input list="options"><datalist id="options"><option>Value</option></datalist>` | Autocomplete suggestions. |

#### Radio
Element: input type="radio"

| Element/Type | Uses | Example | Practical Uses |
|--------------|------|---------|----------------|
| input type="radio" | Single choice from group. | `<input type="radio" name="group" value="1">` | Gender selection or polls. |

#### Check
Element: input type="checkbox"

| Element/Type | Uses | Example | Practical Uses |
|--------------|------|---------|----------------|
| input type="checkbox" | Multiple choices. | `<input type="checkbox" name="option">` | Terms agreement or multi-select filters. |

Additional Form Elements: form, label, fieldset, legend, textarea, output, progress, meter

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| form | Container for form controls. | `<form action="/submit"><input></form>` | Collecting user data for login or surveys. |
| label | Caption for form control. | `<label for="id">Label</label><input id="id">` | Improving accessibility by linking to inputs. |
| fieldset | Groups related form elements. | `<fieldset><legend>Group</legend><input></fieldset>` | Organizing long forms into sections. |
| legend | Caption for fieldset. | `<legend>Section Title</legend>` | Titles for grouped inputs. |
| textarea | Multi-line text input. | `<textarea name="message"></textarea>` | Comment boxes or descriptions. |
| output | Result of a calculation. | `<output name="result">0</output>` | Displaying form computations like totals. |
| progress | Progress of a task. | `<progress value="50" max="100"></progress>` | File upload indicators. |
| meter | Scalar measurement. | `<meter value="0.6">60%</meter>` | Battery levels or ratings. |

## Additional Categories for Completeness

### Root and Metadata Elements
Foundational elements for document structure.

Elements: html, head, body, base, link, meta, style, title

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| html | Root element of HTML document. | `<html lang="en"></html>` | Enclosing all content; setting language. |
| head | Container for metadata. | `<head><title>Page</title></head>` | Holding scripts, styles, and meta info. |
| body | Main content of the document. | `<body><p>Content</p></body>` | All visible page content. |
| base | Base URL for relative links. | `<base href="https://example.com/">` | Simplifying links in multi-page sites. |
| link | External resource link, like CSS. | `<link rel="stylesheet" href="style.css">` | Loading stylesheets or favicons. |
| meta | Metadata like charset or viewport. | `<meta charset="UTF-8">` | SEO keywords, responsive design. |
| style | Inline CSS styles. | `<style>body {color: red;}</style>` | Page-specific styling. |
| title | Document title. | `<title>Page Title</title>` | Browser tab text and bookmarks. |

### Inline Edits and Other Semantics
For marking changes or special text.

Elements: del, ins, hr, ruby, rp, rt

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| del | Deleted text. | `<del>Old text</del>` | Showing revisions in documents. |
| ins | Inserted text. | `<ins>New text</ins>` | Tracking changes in collaborative edits. |
| hr | Thematic break (horizontal rule). | `<hr>` | Separating sections in articles. |
| ruby | Ruby annotations for East Asian text. | `<ruby>漢<rt>kan</rt></ruby>` | Pronunciations in Japanese/Chinese sites. |
| rp | Fallback for ruby parentheses. | `<ruby>漢<rp>(</rp><rt>kan</rt><rp>)</rp></ruby>` | Compatibility for non-supporting browsers. |
| rt | Ruby text. | `<rt>Annotation</rt>` | Furigana in educational content. |

### Scripting and Interactive Elements
For dynamic content and user interaction.

Elements: script, noscript, canvas, details, summary, dialog

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| script | Embeds executable code, usually JavaScript. | `<script>alert('Hi');</script>` | Adding interactivity like validations. |
| noscript | Content for when scripts are disabled. | `<noscript>Enable JS</noscript>` | Fallback messages in apps. |
| canvas | Drawable graphics via scripting. | `<canvas width="200" height="100"></canvas>` | Charts, games, or animations. |
| details | Disclosure widget for hide/show. | `<details><summary>Click</summary><p>Hidden</p></details>` | FAQs or expandable sections. |
| summary | Heading for details element. | `<summary>Toggle</summary>` | Accordion menus. |
| dialog | Modal or popup dialog. | `<dialog open><p>Message</p></dialog>` | Alerts or forms in web apps. |

### Web Components and Advanced
For custom elements and embeds.

Elements: template, slot, svg, math

| Element | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| template | Holds client-side content not rendered initially. | `<template><div>Content</div></template>` | Reusable HTML in JavaScript frameworks. |
| slot | Placeholder in web components. | `<slot name="content"></slot>` | Custom elements in Shadow DOM. |
| svg | Container for SVG graphics. | `<svg><circle cx="50" cy="50" r="40"/></svg>` | Icons, charts, or illustrations. |
| math | MathML for mathematical notation. | `<math><mi>x</mi></math>` | Equations in scientific papers.