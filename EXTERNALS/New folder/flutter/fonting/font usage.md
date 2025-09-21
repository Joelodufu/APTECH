

# 📚 Using Custom Google Fonts in Flutter to Create a Stylish Logo

### 🎯 Course Objective

By the end of this course, students will:

* Understand how to download and integrate custom fonts into a Flutter project.
* Learn how to configure fonts in `pubspec.yaml`.
* Apply Google Fonts (manually or via the `google_fonts` package).
* Build and style a custom **logo widget** with unique typography.

---

## 📝 Course Outline

### **Module 1: Introduction to Fonts in Flutter**

* Why custom fonts matter in mobile app branding.
* Difference between system fonts and custom fonts.
* Overview of Google Fonts.

---

### **Module 2: Setting Up Custom Fonts (Manual Way)**

1. Download a font (e.g., **Pacifico** from Google Fonts).
2. Add the font files into `assets/fonts/` in your Flutter project.
3. Edit `pubspec.yaml`:

   ```yaml
   flutter:
     fonts:
       - family: Pacifico
         fonts:
           - asset: assets/fonts/Pacifico-Regular.ttf
   ```
4. Apply the font in a `Text` widget:

   ```dart
   Text(
     "My Stylish Logo",
     style: TextStyle(
       fontFamily: "Pacifico",
       fontSize: 32,
       color: Colors.deepPurple,
     ),
   )
   ```

---

### **Module 3: Using the Google Fonts Package (Faster Method)**

1. Add dependency:

   ```yaml
   dependencies:
     google_fonts: ^6.1.0
   ```
2. Import and apply directly:

   ```dart
   import 'package:google_fonts/google_fonts.dart';

   Text(
     "My Stylish Logo",
     style: GoogleFonts.pacifico(
       fontSize: 36,
       color: Colors.pinkAccent,
     ),
   )
   ```
3. Compare manual vs package approach.

---

### **Module 4: Designing a Stylish Logo Widget**

* Wrap the text inside a **Container** with decoration.
* Add color gradients, shadows, and padding for branding.
* Example:

  ```dart
  class StylishLogo extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
      return Container(
        padding: EdgeInsets.all(12),
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [Colors.purple, Colors.blue],
          ),
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
              color: Colors.black26,
              blurRadius: 8,
              offset: Offset(2, 4),
            ),
          ],
        ),
        child: Text(
          "Silicash",
          style: GoogleFonts.pacifico(
            fontSize: 40,
            fontWeight: FontWeight.bold,
            color: Colors.white,
          ),
        ),
      );
    }
  }
  ```

---

### **Module 5: Practice Project – Logo Screen**

* Create a splash/logo screen for your app.
* Center the stylish logo.
* Animate it with **FadeIn** or **Scale transition**.

---

### **Module 6: Wrap-Up & Next Steps**

* Review: fonts integration methods.
* Tips for choosing the right font for branding.
* Next step: combining custom fonts with icons (Material Icons or SVG).

---
