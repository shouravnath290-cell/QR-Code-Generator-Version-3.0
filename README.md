# Simple QR Code System

A lightweight, clean, and fast Java Swing desktop application designed to generate QR codes quickly without any cluttered interfaces. Built entirely with standard core Java packages, it offers a distraction-free environment for day-to-day QR generation tasks.

---

## Key Features

* **Secure Authentication:** Built-in lightweight login and registration flow handled via a custom `AuthService` framework.
* **Minimalist UI:** Completely stripped of unnecessary graphics, icons, or emojis. Focuses strictly on readable, bold text layouts.
* **Over 20 Default Categories:** Quick access tiles for Website links, PDFs, WiFi configurations, Crypto addresses, WhatsApp links, and SMS.
* **Dynamic Category Management:** Add new temporary QR categories on-the-fly directly from the dashboard header via the GUI.
* **Advanced Bulk Generation:** Input multiple data items separated by commas or line breaks to batch-generate multiple QR codes sequentially.
* **Multi-Threaded Performance:** Bulk tasks run in background worker threads, preventing the main application UI from freezing or lagging.
* **Automatic Protocol Injection:** Automatically catches web links and ensures they are properly prefixed with `https://`.
* **Adaptive Theme Toggle:** Quick interface switcher between standard Light and Dark modes.
* **Local Logging:** All successfully requested transactions are tracked locally in a plain-text database (`qr_history.txt`).

---

## How It Works

1. **User Authentication:** Launching the application brings up a `GridBagLayout`-based login frame. Users can either sign in with existing details or register a new local session profile.
2. **Dashboard Overview:** Once authenticated, the core dashboard presents categories mapped directly from a structured one-dimensional array.
3. **API Integration:** Clicking any category prompts an input query. The app securely handles data parsing and forwards the encoded payload to `api.qrserver.com`.
4. **Browser Output:** The generated QR code vector immediately surfaces using the host platform's default internet browser.

---

## Getting Started

### Prerequisites
Make sure you have Java Development Kit (JDK) 8 or higher installed on your computer.

### Method 1: Using an IDE (IntelliJ IDEA / Eclipse)
1. Clone or download this repository to your local machine.
2. Open your IDE and import the project folder.
3. Locate `MainApplication.java` inside the source files.
4. Right-click the file and select **Run 'MainApplication.main()'**.

### Method 2: Running via Command Line (Terminal / CMD)
1. Open your terminal and navigate to the project directory containing the `.java` files:
   ```bash
   cd path/to/your/project-folder
2. Compile all source files simultaneously:
javac *.java
3.Execute the compiled application:
java MainApplication
##File Architecture
1.MainApplication.java — The core runtime launcher and container initialization layer.

2.AuthService.java & SimpleAuth.java — Abstract layer blueprint and localized logical validation rules.

3.LoginPanel.java — Form structural UI built with GridBag constraints for handling inputs.

4.DashboardPanel.java — Central hub handling viewports, dark-theme styling, multi-threading loop, and batch lists.

5.ModernCard.java — Component handling specific mouse events, dynamic hover layouts, and boundaries.

6.DataManager.java — Handles file streaming and local persistence routines for qr_history.txt.
