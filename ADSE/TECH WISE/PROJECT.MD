# 🚑 **MediGenie – FAB (Floating Action Button) Design**

### **When a patient taps the Floating Action Button (FAB):**

They see **two choices**:

1️⃣ **Emergency Services**
2️⃣ **AI First Aid Chat**

---

### **1. Emergency Services**

If patient chooses **Emergency**, they see:

- **🚑 Call Ambulance** → Direct dial to the nearest ambulance service (configurable by region).
- **📞 Emergency Hotline** → Dial national/local emergency number (e.g., 112, 911, 122, etc.).
- **📍 Share Live Location** → Sends current GPS coordinates to emergency contact/ambulance dispatch.
- **📤 Notify Emergency Contact** → Sends SMS/WhatsApp to pre-saved next-of-kin with:

  - Location
  - Condition (“Fever + fainting reported”)

_(This shows **real-world readiness** for emergencies — judges will love this.)_

---

### **2. AI First Aid Chat**

If patient chooses **First Aid Chat**:

- AI asks symptoms (structured or natural language).
- Gives **immediate First Aid guidance** (hydration, OTC meds, rest, etc.).
- Creates/updates a **Case Record (Status: FirstAid)** with:

  - Name (AI suggested: “Possible Malaria Fever”).
  - Date & Time.
  - Symptoms logged.
  - Recommended OTC + Home actions.
  - Status → _First Aid_.

Later, when doctor is available, this First Aid case can be upgraded into a **full consultation case**.

---

### **3. Example User Flow**

- Patient faints / collapses → Family taps FAB → chooses **Emergency Service** → _Call Ambulance_ + _Share Live Location_.
- Different scenario: Patient has mild fever → chooses **AI First Aid Chat** → system gives paracetamol/hydration advice, logs it into Case Records.
- If condition worsens → they book doctor → doctor sees **timeline: First Aid logs + current symptoms** → faster diagnosis.

---

### **4. Why This is a Game-Changer**

✅ **Dual utility:** Handles both _life-threatening_ and _non-critical_ cases.
✅ **Judges see scalability:** Not just a chatbot → full **emergency ecosystem**.
✅ **Impactful demo:** In <3 minutes, you can show how app handles both emergencies and normal symptoms intelligently.
✅ **Adds social impact angle:** Could **save lives** in real deployments.

---

### **Demo Plan for Judges (FAB Showcase)**

1. Show FAB → tap **Emergency Service** → options appear (Call Ambulance, Share Location, Notify Contact).
2. Switch → FAB → **AI First Aid Chat** → enter “Headache + Fever” → AI gives advice + case record auto-created.
3. Open **Health Records → Cases** → “FirstAid: Possible Malaria Fever.”

💡 Judges will see:

- _Critical care support (ambulance, contact notifications)._
- _Preventive care (AI First Aid)._
- _Continuity of care (case records evolving over time)._

---
