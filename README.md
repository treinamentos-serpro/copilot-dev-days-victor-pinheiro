<div align="center">

# 🎯 Soc Ops

**Social Bingo for in-person mixers — powered by GitHub Copilot Agents**

Find people who match the prompts. Get 5 in a row. Break the ice. 🎉

[![Java 21](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![GitHub Copilot](https://img.shields.io/badge/Built_with-GitHub_Copilot-6e40c9?logo=github)](https://github.com/features/copilot)

🌐 [Português (BR)](README.pt_BR.md) · [Español](README.es.md)

</div>

---

## ✨ What is Soc Ops?

Soc Ops is a **Social Bingo** app built live during a GitHub Copilot Agent workshop. Walk into a room full of strangers and walk out with new connections — one square at a time.

- 🟩 **Tap a square** when you find someone who matches the prompt
- 🏆 **Get 5 in a row** — row, column, or diagonal — to win
- 🔄 **New board every game** — no two games are the same
- 💾 **Auto-saves progress** — resume where you left off

The twist? This entire app is a hands-on lab for [GitHub Copilot Agents](https://github.com/features/copilot). You'll use AI to redesign the UI, write tests, generate quiz themes, and orchestrate multi-agent workflows — all without leaving VS Code.

---

## 🚀 Quick Start

**Prerequisites:** [Java 21+](https://adoptium.net/) · [Maven 3.9+](https://maven.apache.org/) (or use the included wrapper)

```bash
# Run the app
cd socops && ./mvnw spring-boot:run

# Then open http://localhost:8080
```

```bash
# Build a JAR
cd socops && ./mvnw clean package

# Run tests
cd socops && ./mvnw test
```

> The app deploys automatically to GitHub Pages on every push to `main`.

---

## 🧪 Workshop Lab

This repo is the starter project for the **VS Code + GitHub Copilot Agent Lab**. Each part introduces a new Copilot Agent capability:

| Part | Title | What you'll learn |
|------|-------|-------------------|
| [**00**](workshop/00-overview.md) | Overview & Checklist | Setup, prerequisites, goals |
| [**01**](workshop/01-setup.md) | Setup & Context Engineering | `.github/instructions`, workspace rules |
| [**02**](workshop/02-design.md) | Design-First Frontend | Plan Mode, UI redesign, CSS skills |
| [**03**](workshop/03-quiz-master.md) | Custom Quiz Master | Custom agent creation, prompt design |
| [**04**](workshop/04-multi-agent.md) | Multi-Agent Development | TDD Red → Green → Refactor pipeline |

📚 **[Open the full Lab Guide →](workshop/GUIDE.md)**

---

## 🏗️ Project Structure

```
socops/
├── src/main/java/com/socops/
│   ├── service/BoardAssembler.java   ← board logic, streak detection
│   └── web/BingoRestController.java  ← REST API + page routing
├── src/main/resources/
│   ├── templates/game.html           ← Thymeleaf UI template
│   └── static/css/app.css            ← utility CSS classes
└── src/test/                         ← JUnit 5 behavior tests
workshop/                             ← step-by-step lab guides
```

---

## 🤝 Contributing

Found a bug or want to extend the lab? Open an issue or a pull request — contributions are welcome.

---

<div align="center">

Made with ☕ + 🤖 during a GitHub Copilot Dev Day

</div>
