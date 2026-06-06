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
## System Parameter Configurations (Runtime Overrides)
1.START (QRSystemPro): This is the main entry point of your application (QRSystemPro.java). It represents the initial setup and configuration where the entire 2.system boots up.AuthService: This configures the security and verification layer. It handles user authentication by validating inputs against your flat-file 3.database (users.txt).DashboardPanel: This is the User Interface (UI) configuration. It structures the main workspace using your custom ModernCard component 4.layout.DataManager (QR Engine): This represents the core backend logic configuration. It controls the generation, processing, and handling of data within the 5.app.Storage (qr_history.txt): This defines the data persistence configuration. It ensures that every generated QR code and action is successfully logged and stored in the history file
## Visual & Technical Configurations Included:
1.Dark Theme UI: The code includes specific hex color configurations (#333333, #424242, #1a237e) so that when you import it into draw.io, it automatically styles your diagram with a clean, modern dark mode look.
2.Orthogonal Routing: The connectors (edges) are pre-configured to snap neatly into straight, logical lines instead of crossing over each other, keeping the layout perfectly organized.
## Quick Usage Summary
1.Runtime Flow (Steps)Start: The user runs QRSystemPro.java which opens the login screen.
2.Login: The user enters credentials, and AuthService verifies them against the users.txt file.
3.Dashboard: Upon successful login, the main dashboard opens featuring the modern ModernCard layout.
4.QR Operation: When the user performs a QR action, the DataManager processes the request.
5.Save: The processed QR data is automatically appended and saved into the qr_history.txt file.
## File Usage Summaryusers.
1.txt: Read-only access used strictly to verify user login credentials.
2.qr_history.txt: Write access to append new QR logs, and read access to display history on the dashboard.
## Project Structure
QR_Java_Project/
│
├── 📁 src/ (Source Code)
│   ├── 📄 QRSystemPro.java       # Main entry point of the application
│   ├── 📄 AuthService.java       # Handles user authentication & validation
│   ├── 📄 SimpleAuth.java        # Fallback/basic authentication helper
│   ├── 📄 DataManager.java       # Handles file read/write logic for QR/Users
│   ├── 📄 User.java              # Object model representing user data
│   │
│   └── 📁 ui/ (User Interface Components)
│       ├── 📄 LoginPanel.java    # Graphical User Interface for login
│       ├── 📄 DashboardPanel.java# Main interface shown after login
│       └── 📄 ModernCard.java    # Custom styled UI component for dashboard metrics
│
└── 📁 data/ (Flat-File Storage)
    ├── 📄 users.txt              # Stores usernames and passwords
    └── 📄 qr_history.txt         # Stores log data of all generated QR codes
## Core Modules Breakdown
1.Execution Layer: Controlled by QRSystemPro.java which initializes the program window.

2.Logic/Data Layer: Managed by AuthService.java and DataManager.java to process users and file operations.

3.Presentation (UI) Layer: Driven by Swing components (LoginPanel, DashboardPanel, ModernCard) to handle what the user sees.

4.Storage Layer: Plain text files (users.txt, qr_history.txt) acting as a lightweight, serverless database.

## Presentation Layer (User Interface)
These components handle everything the user sees and interacts with on their screen.

1.LoginPanel.java: The initial window that prompts the user for their username and password.

2.DashboardPanel.java: The main post-login workspace where users generate QR codes and view logs.

3.ModernCard.java: A custom visual layout helper used to display stylish metric cards (like "Total QR Codes Generated") on the dashboard.

## Logic & Controller Layer
These components process data, handle business rules, and connect the UI to the backend storage.

1.QRSystemPro.java: The main engine and entry point of the app that boots up the entire system.

2.AuthService.java / SimpleAuth.java: The security coordinators that take inputs from the LoginPanel and check if they are valid.

3.DataManager.java: The data coordinator that contains the logic to generate QR codes and format data into strings before saving them.

## Data & Storage Layer (Backend)
These components manage the storage of your information without using a heavy external database.
1.User.java: A data object model used to temporarily hold user credentials in memory while the app is running.

2.users.txt: A flat text file acting as a database table to store registered user credentials.

3.qr_history.txt: A flat text file used as an audit log to store every generated QR code entry with its metadata.
### Security Features
## Authentication Layer (Credential Verification)
1.AuthService.java Control: The system restricts unauthorized application access through a strict login gateway.
2.Input Validation: User-submitted text fields from LoginPanel.java are filtered and checked against stored records before creating a dashboard session.2. 
## Flat-File Data Isolation
1.Separation of Concerns: Credentials (users.txt) and transactional QR data (qr_history.txt) are kept in separate storage paths. This prevents a vulnerability in the QR logging system from exposing user credentials.
2.Encapsulated Data Access: UI components cannot access the files directly; all file I/O operations are strictly routed through DataManager.java and AuthService.java.3. 
## Session Management
1.State Control: The system transitions between windows safely (LoginPanel $\rightarrow$ DashboardPanel). When a user triggers the "Logout" event, the dashboard state is destroyed, preventing session hijacking or unauthorized back-navigation.
## Secure Data Mapping
1.Object Model Integrity: The use of User.java ensures that credentials are mapped into memory as encapsulated objects using private fields, rather than being handled as loose, exposed strings throughout the application runtime.
## Future Improvements 
1.Database Migration: Replace text files (.txt) with SQLite or MySQL for better data handling and stability.

2.Password Hashing: Implement algorithms like BCrypt in AuthService to secure credentials instead of saving them in plain text.

3.Automated Alerts: Add a dashboard notification system or email API to automatically flag and alert overdue users.

4.Modern UI Framework: Upgrade from legacy Java Swing to JavaFX or a web frontend for better design and responsive layouts.

5.Cloud Backup: Sync local qr_history.txt data with cloud storage (like AWS S3) to prevent data loss.
## Screenshots
https://github.com/shouravnath290-cell/QR-Code-Generator-Version-3.0/blob/c042a50a9e1adf24195859966a2c343e18b2769d/Screenshot%202026-05-12%20170400.png

## Contributing to QR System Pro
Thank you for wanting to improve this project! Please follow these quick steps to contribute:

1. Getting Started
Fork this repository to your GitHub account.

2.Clone it locally and open the project in any Java IDE (IntelliJ, Eclipse, or NetBeans).

3.Ensure you are using JDK 8 or higher.

## Development Rules

1.UI Changes: Keep all UI modifications inside the ui/ package. Use ModernCard.java to maintain a consistent dark-theme design.

2.Core Logic: Add calculation or file parsing logic inside DataManager.java. Do not write database logic directly inside UI button listeners.

3.File Safety: Ensure any new feature does not break the formatting of users.txt and qr_history.txt.
## Submission Process
1.Create a feature branch:
git checkout -b feature/AmazingFeature
## Commit your clean, tested changes with a clear message:
git commit -m "feat: add overdue fine system to DataManager"
## Push to your branch and open a Pull Request (PR) for review!
## MIT License (Summary)
1.Free Use: Anyone can copy, modify, distribute, or use your QR system code for personal or commercial projects.

2.Attribution: Others must include your original copyright notice in their copies of the software.

3.No Liability: The software is provided "as-is". You are not legally responsible if any data gets corrupted or lost while using this app.
## Author
[Shourav nath]
Computer Science and Engineering Student
GitHub:https://github.com/shouravnath290-cell
## Conclusion
QR System Pro is a lightweight, efficient, and user-friendly Java Swing application designed for seamless QR code tracking and file-based management. By bridging custom UI designs with robust system logic, it delivers an easy-to-use platform for access control or inventory tracking.
Moving forward, transitioning to relational databases and migrating to modern frameworks like JavaFX will scale this tool into a highly secure, enterprise-ready administrative asset.




