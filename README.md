# 🚀 AI Email Writer - Chrome Extension  

<p align="center">
  <img src="https://img.shields.io/github/last-commit/Vanshdeep-04/ai-email-writer?style=flat&color=blue" alt="last commit">
  <img src="https://img.shields.io/github/repo-size/Vanshdeep-04/ai-email-writer?color=orange" alt="repo size">
  <img src="https://img.shields.io/github/stars/Vanshdeep-04/ai-email-writer?style=social" alt="stars">
</p>

---

## 📌 Overview

AI Email Writer is a **Chrome Extension** powered by **Spring Boot (Backend)** and **React (Frontend)** that helps you generate **smart, AI-powered replies** in Gmail instantly.  
Choose between **Professional**, **Friendly**, or **Casual** tones and let AI do the writing for you! ✨

---

## 🌟 Features

- ⚡ **Instant AI-generated email replies** directly in Gmail  
- 🎨 **Multiple tones**: Professional, Friendly, Casual  
- 🔄 **Real-time integration** with Gmail Compose window  
- 🛠 **Spring Boot backend** with REST API for AI responses  
- 💻 **React-based UI** for enhanced user experience  
- 🔌 **Chrome extension** with Manifest V3 support  

---

## 🛠 Tech Stack

| Layer         | Technology                 |
|---------------|---------------------------|
| **Frontend**  | React (Vite), CSS         |
| **Backend**   | Java Spring Boot, REST API|
| **Extension** | JavaScript, Manifest V3   |
| **AI Model**  | Google Gemini API          |
| **Tools**     | GitHub Desktop, Chrome DevTools |

---

## 📂 Project Structure
'''
ai-email-writer/
│
├── backend/                     # Spring Boot Backend (REST API for AI-generated replies)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/ai/emailwriter/   # Backend source code
│   │   │   └── resources/                 # Application properties, config files
│   ├── pom.xml                  # Maven configuration file
│   └── README.md                # Backend-specific documentation
│
├── email-writer-react/          # React Frontend (User interface for tone selection, integration)
│   ├── public/                  # Static assets
│   ├── src/
│   │   ├── components/          # Reusable React components
│   │   ├── pages/               # Page-level components
│   │   └── App.js               # Main React app file
│   ├── package.json             # Dependencies and scripts
│   └── README.md                # Frontend-specific documentation
│
├── chrome-extension/            # Chrome Extension (Manifest V3)
│   ├── content.js               # Script injected into Gmail
│   ├── content.css              # Custom styles for AI button
│   ├── manifest.json            # Extension configuration
│   ├── icons/                   # Extension icons
│   └── README.md                # Extension-specific documentation
│
└── README.md                    # Main project documentation
'''

## Installation & Setup
1️⃣ **Clone the repository**
git clone https://github.com/Vanshdeep-04/ai-email-writer.git
cd ai-email-writer

### 2️⃣ Backend Setup (Spring Boot)
cd backend
mvn clean install
mvn spring-boot:run
Backend runs on http://localhost:8080.

### 3️⃣ Frontend Setup (React)
cd email-writer-react
npm install
npm run dev
React frontend runs on http://localhost:5173 (or similar port).

### 4️⃣ Chrome Extension Setup
Open Google Chrome → **Go to chrome://extensions/**
**Enable Developer Mode** (top-right corner)
Click Load unpacked → **Select chrome-extension folder**
The AI Email Writer button will now appear in Gmail.

## 🚀 Usage
Open Gmail and compose an email.
**Select your preferred tone** (Professional, Friendly, Casual).
**Click AI Reply to generate and insert a smart reply instantly.

## 👨‍💻 Author
Vansh Deep
📧 vansh.chd412@gmail.com
🌐 **LinkedIn** -> https://www.linkedin.com/in/vansh-deep-887bb8281?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app
