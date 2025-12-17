# PinkScribe Project Logbook

**Student Name:** Azuka Abundance-Blessing E.  
**Project:** PinkScribe - Cute Audio-to-Text Transcription Web App (MVP)  
**Duration:** 3 Months (July 1, 2025 - September 30, 2025)  
**Structure:** 3 months, 4 weeks per month, 5 working days per week (Monday-Friday, excluding weekends/holidays for simplicity). Total: ~60 working days.  
**Objective:** Document daily learning, activities, challenges, and progress toward building PinkScribe per the PRD (e.g., setup, upload logic, API integration, display, styling) and achieving MVP success criteria. Extend beyond 5-week MVP with reviews, nice-to-haves (e.g., microphone support, multi-language), and deployment.  
**Tech Stack (per PRD/Wireframes):** HTML5, CSS3, JS (frontend); PHP (backend); Speech-to-Text API (e.g., OpenAI Whisper); XAMPP for dev, shared hosting for deployment.  
**Log Format:** Daily entries with: Date, Learning Concepts, Activities/Class Work, Project Progress/Task, Challenges & Solutions, Time Spent, Reflections.

## Month 1: July 2025 (Foundation & Setup)

Focus: Basics of web dev, environment setup, HTML/PHP forms (aligns with PRD Week 1).

### Week 1 (July 1-5)

- **July 1 (Mon):**  
  Learning Concepts: Intro to web dev (front-end vs back-end), PRD overview (goals, users, features).  
  Activities/Class Work: Installed XAMPP, read PRD sections 1-3. Created simple HTML page.  
  Project Progress/Task: Set up PinkScribe folder in htdocs.  
  Challenges & Solutions: XAMPP Apache not starting - restarted services.  
  Time Spent: 2 hours.  
  Reflections: Excited to build a cute app; PRD emphasizes beginner-friendly UI.

- **July 2 (Tue):**  
  Learning Concepts: HTML structure (tags, forms), basic PHP syntax (echo, variables).  
  Activities/Class Work: Built a hello world PHP script; tested in browser.  
  Project Progress/Task: Added basic HTML form to index.php for audio upload.  
  Challenges & Solutions: Form not submitting - added method="POST".  
  Time Spent: 3 hours.  
  Reflections: Understanding how PHP integrates with HTML for dynamic content.
****
- **July 3 (Wed):**  
  Learning Concepts: Form handling in PHP ($\_POST, if statements).  
  Activities/Class Work: Processed a text input form to echo input.  
  Project Progress/Task: Added PHP to confirm form submission in PinkScribe.  
  Challenges & Solutions: None major.  
  Time Spent: 2.5 hours.  
  Reflections: Aligns with PRD user flow step 2-3 (upload form).

- **July 4 (Thu):**  
  Learning Concepts: JS basics (event listeners, alerts).  
  Activities/Class Work: Added JS alert to a button click.  
  Project Progress/Task: Added JS preview for file selection in upload form.  
  Challenges & Solutions: JS not loading - placed script at bottom of body.  
  Time Spent: 3 hours.  
  Reflections: Small interactions make the app more engaging, per PRD.

- **July 5 (Fri):**  
  Learning Concepts: Review week 1 concepts; intro to file uploads.  
  Activities/Class Work: Uploaded a test image via PHP.  
  Project Progress/Task: Tested basic audio upload (no validation yet).  
  Challenges & Solutions: File not saving - created uploads folder with permissions.  
  Time Spent: 2 hours.  
  Reflections: Week 1 complete; ready for file logic (PRD Week 2).

### Week 2 (July 8-12)

- **July 8 (Mon):**  
  Learning Concepts: PHP file handling ($\_FILES, move_uploaded_file).  
  Activities/Class Work: Validated and uploaded a file with size limit.  
  Project Progress/Task: Implemented basic audio upload logic for PinkScribe.  
  Challenges & Solutions: Upload errors - checked php.ini for upload_max_filesize.  
  Time Spent: 3 hours.  
  Reflections: Core to PRD feature 1 (upload audio, max 10MB).

- **July 9 (Tue):**  
  Learning Concepts: File validation (types: MP3/WAV, sizes).  
  Activities/Class Work: Added type checks to upload script.  
  Project Progress/Task: Validated formats in PinkScribe upload.  
  Challenges & Solutions: MIME type issues - used $file['type'].  
  Time Spent: 2.5 hours.  
  Reflections: Ensures supported formats per PRD.

- **July 10 (Wed):**  
  Learning Concepts: Error handling in PHP (custom messages).  
  Activities/Class Work: Displayed errors for invalid uploads.  
  Project Progress/Task: Added error display to PinkScribe form.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Improves user experience.

- **July 11 (Thu):**  
  Learning Concepts: JS for file preview (display name/size).  
  Activities/Class Work: JS to show selected file details.  
  Project Progress/Task: Integrated JS preview in PinkScribe.  
  Challenges & Solutions: Event listener not firing - used onchange.  
  Time Spent: 3 hours.  
  Reflections: Ties to PRD's small JS interactions.

- **July 12 (Fri):**  
  Learning Concepts: Week review; secure file handling basics.  
  Activities/Class Work: Tested uploads with invalid files.  
  Project Progress/Task: Full upload logic tested (PRD Week 2 complete).  
  Challenges & Solutions: Security concerns - researched tmp_name usage.  
  Time Spent: 2 hours.  
  Reflections: Solid foundation for API integration.

### Week 3 (July 15-19)

- **July 15 (Mon):**  
  Learning Concepts: API intro (cURL in PHP, HTTP requests).  
  Activities/Class Work: Called a public API with cURL.  
  Project Progress/Task: Signed up for speech-to-text API (e.g., AssemblyAI).  
  Challenges & Solutions: cURL not enabled - checked XAMPP config.  
  Time Spent: 3 hours.  
  Reflections: Preps for PRD feature 2 (transcribe audio).

- **July 16 (Tue):**  
  Learning Concepts: Handling API keys (.env files).  
  Activities/Class Work: Stored key securely and used in script.  
  Project Progress/Task: Sent dummy data to API from PinkScribe.  
  Challenges & Solutions: .env not loading - used parse_ini_file.  
  Time Spent: 2.5 hours.  
  Reflections: Security is key for external services.

- **July 17 (Wed):**  
  Learning Concepts: JSON parsing in PHP (json_decode).  
  Activities/Class Work: Parsed sample API response.  
  Project Progress/Task: Extracted mock transcription text.  
  Challenges & Solutions: Invalid JSON - added error checking.  
  Time Spent: 2 hours.  
  Reflections: Essential for displaying results.

- **July 18 (Thu):**  
  Learning Concepts: Sending files to API via cURL.  
  Activities/Class Work: Uploaded file to test API endpoint.  
  Project Progress/Task: Integrated API call with uploaded audio.  
  Challenges & Solutions: File path issues - used full path.  
  Time Spent: 3 hours.  
  Reflections: PRD Week 3 in progress.

- **July 19 (Fri):**  
  Learning Concepts: API error handling.  
  Activities/Class Work: Handled failed API responses.  
  Project Progress/Task: Tested transcription with real audio (PRD Week 3 complete).  
  Challenges & Solutions: Rate limits - used free tier carefully.  
  Time Spent: 2 hours.  
  Reflections: Transcription works; exciting milestone.

### Week 4 (July 22-26)

- **July 22 (Mon):**  
  Learning Concepts: Displaying dynamic content in PHP/HTML.  
  Activities/Class Work: Showed form results on page.  
  Project Progress/Task: Displayed transcription text in PinkScribe.  
  Challenges & Solutions: Text not appearing - used conditionals.  
  Time Spent: 3 hours.  
  Reflections: PRD feature 3 (display transcription).

- **July 23 (Tue):**  
  Learning Concepts: JS clipboard copy (navigator.clipboard).  
  Activities/Class Work: Added copy button to text.  
  Project Progress/Task: Implemented "Copy to Clipboard" in PinkScribe.  
  Challenges & Solutions: Browser permissions - tested in Chrome.  
  Time Spent: 2.5 hours.  
  Reflections: User-friendly feature per PRD.

- **July 24 (Wed):**  
  Learning Concepts: Basic CSS (colors, fonts).  
  Activities/Class Work: Styled a simple page with pink palette.  
  Project Progress/Task: Applied basic styling to PinkScribe UI.  
  Challenges & Solutions: Font import - used Google Fonts.  
  Time Spent: 2 hours.  
  Reflections: Starting PRD Week 5 (styling).

- **July 25 (Thu):**  
  Learning Concepts: Responsive design (media queries).  
  Activities/Class Work: Made form mobile-friendly.  
  Project Progress/Task: Ensured PinkScribe works on mobile.  
  Challenges & Solutions: Layout breaks - adjusted widths.  
  Time Spent: 3 hours.  
  Reflections: Meets PRD success criteria for UI.

- **July 26 (Fri):**  
  Learning Concepts: Week/month review; cute UI touches (emojis).  
  Activities/Class Work: Added animations via CSS.  
  Project Progress/Task: Finalized MVP styling (PRD Week 5 complete).  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: MVP functional; tested <1 min transcription.

## Month 2: August 2025 (Testing & Enhancements)

Focus: Debugging, deployment, nice-to-haves (e.g., microphone, languages).

### Week 1 (August 1-5)

- **August 1 (Mon):**  
  Learning Concepts: Debugging PHP errors (error_reporting).  
  Activities/Class Work: Fixed sample buggy code.  
  Project Progress/Task: Debugged upload/API issues in PinkScribe.  
  Challenges & Solutions: Undefined variables - initialized them.  
  Time Spent: 3 hours.  
  Reflections: Ensures no PHP errors per PRD.

- **August 2 (Tue):**  
  Learning Concepts: Edge case testing (large files, invalid formats).  
  Activities/Class Work: Tested with various inputs.  
  Project Progress/Task: Validated PRD success criteria.  
  Challenges & Solutions: Timeout on large files - increased max_execution_time.  
  Time Spent: 2.5 hours.  
  Reflections: App stable on desktop/mobile.

- **August 3 (Wed):**  
  Learning Concepts: Deployment basics (shared hosting).  
  Activities/Class Work: Uploaded simple app to free host.  
  Project Progress/Task: Deployed PinkScribe to shared hosting.  
  Challenges & Solutions: Config differences - adjusted .htaccess.  
  Time Spent: 3 hours.  
  Reflections: Live demo ready.

- **August 4 (Thu):**  
  Learning Concepts: Nice-to-have: Microphone recording (Web Audio API in JS).  
  Activities/Class Work: Recorded short audio in browser.  
  Project Progress/Task: Added microphone option to PinkScribe.  
  Challenges & Solutions: Permissions - prompted user.  
  Time Spent: 3 hours.  
  Reflections: Enhances PRD future features.

- **August 5 (Fri):**  
  Learning Concepts: Week review; multi-language transcription.  
  Activities/Class Work: Passed language param to API.  
  Project Progress/Task: Added language select dropdown.  
  Challenges & Solutions: API support - checked docs.  
  Time Spent: 2 hours.  
  Reflections: Expands usability.

### Week 2 (August 8-12)

- **August 8 (Mon):**  
  Learning Concepts: User accounts basics (sessions in PHP).  
  Activities/Class Work: Simple login/logout.  
  Project Progress/Task: Added save transcriptions for logged-in users.  
  Challenges & Solutions: Session start - placed at top.  
  Time Spent: 3 hours.  
  Reflections: PRD nice-to-have for future.

- **August 9 (Tue):**  
  Learning Concepts: Database intro (MySQL with PHP).  
  Activities/Class Work: Created table and inserted data.  
  Project Progress/Task: Stored transcriptions in DB.  
  Challenges & Solutions: Connection errors - used mysqli.  
  Time Spent: 2.5 hours.  
  Reflections: Enables history saving.

- **August 10 (Wed):**  
  Learning Concepts: Retrieving DB data.  
  Activities/Class Work: Displayed stored data.  
  Project Progress/Task: Showed past transcriptions in dashboard.  
  Challenges & Solutions: SQL injection - used prepared statements.  
  Time Spent: 2 hours.  
  Reflections: Secure and functional.

- **August 11 (Thu):**  
  Learning Concepts: Advanced JS (fetch for API if needed).  
  Activities/Class Work: JS API call alternative.  
  Project Progress/Task: Optimized PinkScribe for faster loads.  
  Challenges & Solutions: None.  
  Time Spent: 3 hours.  
  Reflections: Improves performance.

- **August 12 (Fri):**  
  Learning Concepts: Week review; security best practices.  
  Activities/Class Work: Sanitized inputs.  
  Project Progress/Task: Full testing of enhancements.  
  Challenges & Solutions: CSRF - added tokens.  
  Time Spent: 2 hours.  
  Reflections: App more robust.

### Week 3 (August 15-19)

- **August 15 (Mon):**  
  Learning Concepts: Code optimization/review.  
  Activities/Class Work: Refactored sample code.  
  Project Progress/Task: Optimized PinkScribe code.  
  Challenges & Solutions: Redundant code - removed.  
  Time Spent: 3 hours.  
  Reflections: Cleaner codebase.

- **August 16 (Tue):**  
  Learning Concepts: Performance testing.  
  Activities/Class Work: Timed API calls.  
  Project Progress/Task: Ensured <1 min transcription.  
  Challenges & Solutions: Slow API - chose faster provider.  
  Time Spent: 2.5 hours.  
  Reflections: Meets PRD criteria.

- **August 17 (Wed):**  
  Learning Concepts: Cross-browser testing.  
  Activities/Class Work: Tested in Firefox/Edge.  
  Project Progress/Task: Fixed browser-specific issues.  
  Challenges & Solutions: JS compatibility - polyfills.  
  Time Spent: 2 hours.  
  Reflections: Broader compatibility.

- **August 18 (Thu):**  
  Learning Concepts: Documentation (README.md).  
  Activities/Class Work: Wrote project docs.  
  Project Progress/Task: Added to GitHub repo.  
  Challenges & Solutions: None.  
  Time Spent: 3 hours.  
  Reflections: Professional touch.

- **August 19 (Fri):**  
  Learning Concepts: Month review; feedback loop.  
  Activities/Class Work: Self-reviewed progress.  
  Project Progress/Task: Final MVP tweaks.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Enhancements complete; app robust.

### Week 4 (August 22-26)

- **August 22 (Mon):**  
  Learning Concepts: Advanced styling (cursive fonts, animations).  
  Activities/Class Work: Added fade-in to text.  
  Project Progress/Task: Polished "girly" UI per PRD.  
  Challenges & Solutions: Font rendering - web-safe fonts.  
  Time Spent: 3 hours.  
  Reflections: Cute theme achieved.

- **August 23 (Tue):**  
  Learning Concepts: Mobile optimization.  
  Activities/Class Work: Used dev tools for emulation.  
  Project Progress/Task: Tested on phone.  
  Challenges & Solutions: Touch issues - adjusted buttons.  
  Time Spent: 2 hours.  
  Reflections: PRD success: Works on mobile.

- **August 24 (Wed):**  
  Learning Concepts: Backup/version control (Git basics).  
  Activities/Class Work: Committed changes.  
  Project Progress/Task: Versioned PinkScribe repo.  
  Challenges & Solutions: Git conflicts - merged.  
  Time Spent: 2.5 hours.  
  Reflections: Safe progress tracking.

- **August 25 (Thu):**  
  Learning Concepts: User testing simulation.  
  Activities/Class Work: Role-played user flow.  
  Project Progress/Task: Gathered "feedback" notes.  
  Challenges & Solutions: None.  
  Time Spent: 3 hours.  
  Reflections: Improves UX.

- **August 26 (Fri):**  
  Learning Concepts: Month review; API alternatives.  
  Activities/Class Work: Tested Google Speech-to-Text.  
  Project Progress/Task: Switched API if needed.  
  Challenges & Solutions: Integration diffs - updated code.  
  Time Spent: 2 hours.  
  Reflections: Flexibility in stack.

## Month 3: September 2025 (Polish & Wrap-Up)

Focus: Final testing, refinements, and project closure (up to current date Sep 22).

### Week 1 (September 1-5)

- **September 1 (Mon):**  
  Learning Concepts: Final debugging (edge cases).  
  Activities/Class Work: Tested with large files.  
  Project Progress/Task: Fixed edge case issues in PinkScribe.  
  Challenges & Solutions: Memory limit - adjusted php.ini.  
  Time Spent: 3 hours.  
  Reflections: Ensures stability.

- **September 2 (Tue):**  
  Learning Concepts: Performance optimization.  
  Activities/Class Work: Reduced API call time.  
  Project Progress/Task: Optimized transcription speed.  
  Challenges & Solutions: Caching - added simple cache.  
  Time Spent: 2.5 hours.  
  Reflections: Meets <1 min goal.

- **September 3 (Wed):**  
  Learning Concepts: Security audit.  
  Activities/Class Work: Checked for vulnerabilities.  
  Project Progress/Task: Secured PinkScribe inputs.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Robust against attacks.

- **September 4 (Thu):**  
  Learning Concepts: Deployment update.  
  Activities/Class Work: Updated hosting settings.  
  Project Progress/Task: Re-deployed with fixes.  
  Challenges & Solutions: DB sync - exported/imported.  
  Time Spent: 3 hours.  
  Reflections: Live version updated.

- **September 5 (Fri):**  
  Learning Concepts: Week review; user feedback.  
  Activities/Class Work: Simulated user tests.  
  Project Progress/Task: Incorporated minor UX tweaks.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: App user-ready.

### Week 2 (September 8-12)

- **September 8 (Mon):**  
  Learning Concepts: Advanced CSS (hover effects).  
  Activities/Class Work: Added button hovers.  
  Project Progress/Task: Enhanced PinkScribe buttons.  
  Challenges & Solutions: CSS specificity - used !important.  
  Time Spent: 3 hours.  
  Reflections: Polished UI.

- **September 9 (Tue):**  
  Learning Concepts: JS enhancements (form validation).  
  Activities/Class Work: Validated inputs client-side.  
  Project Progress/Task: Added JS validation to upload form.  
  Challenges & Solutions: Regex issues - simplified checks.  
  Time Spent: 2.5 hours.  
  Reflections: Reduces server load.

- **September 10 (Wed):**  
  Learning Concepts: API rate limit management.  
  Activities/Class Work: Implemented retry logic.  
  Project Progress/Task: Added retry for API failures.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Reliable transcription.

- **September 11 (Thu):**  
  Learning Concepts: Backup strategies.  
  Activities/Class Work: Backed up files/DB.  
  Project Progress/Task: Created PinkScribe backup.  
  Challenges & Solutions: File size - compressed.  
  Time Spent: 3 hours.  
  Reflections: Data safety ensured.

- **September 12 (Fri):**  
  Learning Concepts: Week review; final testing.  
  Activities/Class Work: Ran full test suite.  
  Project Progress/Task: Verified all PRD criteria.  
  Challenges & Solutions: Minor bugs - fixed.  
  Time Spent: 2 hours.  
  Reflections: MVP solid.

### Week 3 (September 15-19)

- **September 15 (Mon):**  
  Learning Concepts: Code documentation.  
  Activities/Class Work: Added comments to code.  
  Project Progress/Task: Documented PinkScribe logic.  
  Challenges & Solutions: None.  
  Time Spent: 2.5 hours.  
  Reflections: Easier maintenance.

- **September 16 (Tue):**  
  Learning Concepts: Performance tuning.  
  Activities/Class Work: Optimized CSS/JS loading.  
  Project Progress/Task: Improved PinkScribe load times.  
  Challenges & Solutions: Resource order - deferred JS.  
  Time Spent: 3 hours.  
  Reflections: Faster app.

- **September 17 (Wed):**  
  Learning Concepts: User feedback integration.  
  Activities/Class Work: Adjusted based on mock feedback.  
  Project Progress/Task: Tweaked UI/UX in PinkScribe.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Enhanced usability.

- **September 18 (Thu):**  
  Learning Concepts: Final deployment check.  
  Activities/Class Work: Tested live site.  
  Project Progress/Task: Updated hosting with latest code.  
  Challenges & Solutions: DNS delay - waited.  
  Time Spent: 3 hours.  
  Reflections: Live and stable.

- **September 19 (Fri):**  
  Learning Concepts: Week review; project closure.  
  Activities/Class Work: Reviewed logs.  
  Project Progress/Task: Finalized PinkScribe features.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: Ready for use.

### Week 4 (September 22-26, up to current date Sep 22)

- **September 22 (Mon):**  
  Learning Concepts: Final reflections; project wrap-up.  
  Activities/Class Work: Reviewed all logs and code.  
  Project Progress/Task: Archived PinkScribe project; prepared for handoff.  
  Challenges & Solutions: None.  
  Time Spent: 2 hours.  
  Reflections: 3 months complete; gained PHP/JS skills, built functional app per PRD.

(Note: Entries stop at Sep 22 per current date and time (05:07 PM WAT). Continue similarly for Sep 23-30 if extended, focusing on maintenance or additional nice-to-haves.)
