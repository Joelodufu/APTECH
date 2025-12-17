# PinkScribe Web App Development Learning Plan

**Project Title:** PinkScribe - Cute Audio-to-Text Transcription Web App  
**Version:** 1.0 (MVP)  
**Student:** Azuka Abundance-Blessing E
**Mentor/Teacher:** Joel Odufu Ekowoicho
**Duration:** August 18, 2025 - September 30, 2025  
**Objective:** Build the PinkScribe MVP as per the provided Product Requirements Document (PRD) while learning HTML, CSS, JavaScript, and PHP fundamentals. The plan integrates teaching sessions, class work for concept reinforcement, and project tasks for practical application. Culminate in a functional app and presentation based on the project wireframes.  
<!-- **Session Schedule:** Mondays and Wednesdays, 5:00 PM - 6:30 PM (1.5 hours each). Sessions include:  
- 15-20 minutes: Review bottlenecks from previous assignments/tasks (Q&A, debugging).  
- 50-60 minutes: Teach new concepts and demonstrate next steps (hands-on).  
- 15-20 minutes: Assign class work and project tasks; discuss resources.  
**Independent Work:** Complete class work (1-2 hours post-session) and project tasks (3-5 hours between sessions). Log daily/weekly in your logbook: concepts learned, code snippets, outputs, challenges, and time spent.   -->
<!-- **Resources:**  
- PRD (attached/reference: Product Requirements Document.pdf)  
- Wireframes (attached/reference: Project Wireframes.pdf)  
- Tutorials: W3Schools (HTML/CSS/JS/PHP), API docs (e.g., OpenAI Whisper or AssemblyAI)  
- Tools: XAMPP for local development, GitHub for code sharing  
**Milestones:**  
- By Session 6 (Sep 3): Basic upload and transcription functional.  
- By Session 10 (Sep 17): Full MVP complete (per PRD success criteria: <1 min transcription, no errors, desktop/mobile UI).  
- By Session 13 (Sep 29): Presentation ready (fill wireframes with achievements, screenshots/GIFs).  
**Tracking:** Share code/progress via GitHub. Mid-week check-ins via email/chat for issues.   -->

## Session Plan

This table combines views for both student and mentor. Student: Focus on prep and post-session tasks. Mentor: Prepare demos and facilitate reviews.

| Session # | Date (2025) | Pre-Session Prep (Student) | Session Focus (1.5 hours) | Post-Session: Class Work (Student: 1-2 hrs) | Post-Session: Project Task (Student: 3-5 hrs) | Mentor Notes (Prep/Facilitation) |
|-----------|-------------|----------------------------|----------------------------|---------------------------------------------|-----------------------------------------------|----------------------------------|
| 1 | Aug 18 (Mon) | Install XAMPP; read PRD Overview/Goals sections. | Review: N/A (first session).<br>Teach: Web dev basics (HTML structure, forms); PHP intro (variables, echo, POST). Demo project setup.<br>Assign: Discuss tasks/resources. | Create simple HTML form with text input/submit; PHP script to echo input. Test in XAMPP. | Set up PinkScribe folder; build basic HTML upload form (file input, "Choose File"/"Transcribe" buttons). Log notes. | Prep: HTML/PHP demo code. Facilitate: Hands-on setup. |
| 2 | Aug 20 (Wed) | Complete/attempt Session 1 tasks; note issues. | Review: Class Work 1 & Project Task 1 (e.g., fix form bugs).<br>Teach: PHP form processing; JS basics (event listeners).<br>Assign: Tasks/resources. | PHP script for form data display; JS alert on submit. | Add PHP to handle submission; display confirmation message. Test flow. | Prep: Form/JS examples. Facilitate: Debug session outputs. |
| 3 | Aug 25 (Mon) | Complete/attempt Session 2 tasks; log bottlenecks. | Review: Class Work 2 & Project Task 2 (e.g., PHP/JS integration).<br>Teach: PHP file uploads ($_FILES, validation: types/sizes).<br>Assign: Tasks/resources. | Upload image in PHP (validate JPG/PNG, <2MB); display uploaded image. | Implement audio upload (MP3/WAV, <10MB); store file temporarily. | Prep: Upload code demo. Facilitate: Error handling Q&A. |
| 4 | Aug 27 (Wed) | Complete/attempt Session 3 tasks; note errors. | Review: Class Work 3 & Project Task 3 (e.g., validation issues).<br>Teach: JS for upload preview; PHP/JS error handling.<br>Assign: Tasks/resources. | JS to show selected file name; PHP error messages for invalid files. | Add JS preview and error handling to PinkScribe form. Test with audio samples. | Prep: JS preview script. Facilitate: Cross-browser testing tips. |
| 5 | Sep 1 (Mon) | Complete/attempt Session 4 tasks; sign up for API (e.g., AssemblyAI). | Review: Class Work 4 & Project Task 4 (e.g., preview bugs).<br>Teach: API integration (cURL in PHP, .env for keys, JSON parsing).<br>Assign: Tasks/resources. | Use cURL to call public API (e.g., JSONPlaceholder); parse response. | Choose API; send dummy data via cURL in PinkScribe. | Prep: cURL/API demo. Facilitate: Security best practices. |
| 6 | Sep 3 (Wed) | Complete/attempt Session 5 tasks; log API issues. | Review: Class Work 5 & Project Task 5 (e.g., cURL errors).<br>Teach: Send audio to API; extract transcription text.<br>Assign: Tasks/resources. | Simulate API with dummy JSON; extract and display text. | Integrate API: Send uploaded audio, echo raw transcription. Handle errors. | Prep: Audio API call example. Facilitate: Response parsing walkthrough. |
| 7 | Sep 8 (Mon) | Complete/attempt Session 6 tasks; test responses. | Review: Class Work 6 & Project Task 6 (e.g., JSON issues).<br>Teach: Display dynamic content (PHP conditionals); JS clipboard copy.<br>Assign: Tasks/resources. | PHP to show results post-submit; JS copy button for sample text. | Display transcription on page; add "Copy" button. Test end-to-end. | Prep: Display/JS copy demo. Facilitate: User flow simulation. |
| 8 | Sep 10 (Wed) | Complete/attempt Session 7 tasks; note display bugs. | Review: Class Work 7 & Project Task 7 (e.g., copy function).<br>Teach: CSS basics (colors, fonts, layouts, media queries for responsive).<br>Assign: Tasks/resources. | Style simple HTML page (pink palette, fonts); add media queries. | Apply pink palette, modern fonts, cursive "PinkScribe" logo. Test mobile. | Prep: CSS examples (Google Fonts). Facilitate: Responsive design tools. |
| 9 | Sep 15 (Mon) | Complete/attempt Session 8 tasks; check responsiveness. | Review: Class Work 8 & Project Task 8 (e.g., CSS conflicts).<br>Teach: Advanced UI (emojis, animations, mobile-friendly touches).<br>Assign: Tasks/resources. | Add CSS animation/emoji; create "girly" header. | Add emojis/animations; finalize cute UI per PRD. | Prep: UI enhancement demos. Facilitate: Aesthetic feedback. |
| 10 | Sep 17 (Wed) | Complete/attempt Session 9 tasks; log UI issues. | Review: Class Work 9 & Project Task 9 (e.g., animation bugs).<br>Teach: Debugging (PHP errors, edge cases); intro deployment (shared hosting).<br>Assign: Tasks/resources. | Debug sample buggy PHP script; deploy simple app to free host (e.g., 000webhost). | Test edge cases (e.g., large files); deploy PinkScribe to hosting. | Prep: Debugging tools/demo. Facilitate: Deployment walkthrough. |
| 11 | Sep 22 (Mon) | Complete/attempt Session 10 tasks; verify hosting. | Review: Class Work 10 & Project Task 10 (e.g., hosting errors).<br>Teach: Full testing (PRD criteria: speed, no errors, multi-device).<br>Assign: Tasks/resources. | Test mini app for errors on desktop/mobile. | Validate PRD success: <1 min transcription, no errors, desktop/mobile. Add live demo link. | Prep: Testing checklist. Facilitate: Performance optimization. |
| 12 | Sep 24 (Wed) | Complete/attempt Session 11 tasks; gather screenshots/GIFs. | Review: Class Work 11 & Project Task 11 (e.g., test results).<br>Teach: Presentation prep (fill wireframes: achievements, challenges, demo).<br>Assign: Tasks/resources. | Create one wireframe slide (e.g., "Challenges & Solutions"). | Fill all wireframes: Add details (API used, before/after, GIFs). | Prep: Wireframe examples. Facilitate: Content brainstorming. |
| 13 | Sep 29 (Mon) | Complete/attempt Session 12 tasks; finalize slides. | Review: Class Work 12 & Project Task 12 (e.g., slide content).<br>Teach: Bonus nice-to-haves (e.g., microphone basics); final wrap-up.<br>Assign: Optional tasks. | Explore JS microphone API basics. | Optional: Add microphone support or language select. Update logbook with reflections. | Prep: Bonus demo. Facilitate: Project demo & feedback. |
<!-- 
## Additional Guidelines
- **Logbook Entries:** Fill for 2 months (Aug-Sep). Include session notes, code, challenges solved, and progress toward PRD goals (e.g., strengthening PHP skills, API integration).
- **Flexibility:** If ahead, advance to nice-to-haves (e.g., save transcriptions). If delayed, merge sessions (e.g., combine CSS/debugging).
- **Evaluation:** Based on PRD success criteria and wireframe presentation. Final demo on Sep 29 or 30.
- **Contact:** For issues outside sessions, email [teacher email] or chat. Share logbook weekly.

This plan aligns with the PRD timeline (5 weeks core build) expanded for bi-weekly sessions and reviews. Success = Functional, cute app + confident web dev skills! 🚀 -->