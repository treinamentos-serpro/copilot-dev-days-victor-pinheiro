# AGENTS.md

## Project snapshot

This repository contains Soc Ops, a Spring Boot social bingo app for in-person mixers. The runnable app and its regression tests live under the `socops/` subproject.

## Working commands

Run commands from the repository root with the Maven wrapper:

- Start the app: `cd socops && ./mvnw spring-boot:run`
- Build the jar: `cd socops && ./mvnw clean package`
- Run the test suite: `cd socops && ./mvnw test`

## Where to start for changes

Start with the business logic before touching the UI:

- `socops/src/main/java/com/socops/service/BoardAssembler.java` is the main pure-logic engine for board generation, cell toggling, and streak detection.
- `socops/src/test/java/com/socops/service/BoardAssemblerTests.java` is the primary regression suite for behavior changes.
- `socops/src/main/java/com/socops/web/BingoRestController.java` is the integration boundary that exposes the board state to the page.

## Architecture and key files

- `socops/src/main/java/com/socops/SocOpsApplication.java`: Spring Boot entry point.
- `socops/src/main/java/com/socops/web/BingoRestController.java`: serves `/` and `/api/bingo/fresh-board`.
- `socops/src/main/java/com/socops/service/BoardAssembler.java`: board generation, cell updates, and win detection logic.
- `socops/src/main/java/com/socops/model/`: domain model such as `BingoCell` and `WinningStreak`.
- `socops/src/main/resources/templates/game.html`: Thymeleaf page and browser-side UI logic.
- `socops/src/main/resources/static/css/app.css`: shared utility CSS used by the UI.
- `socops/src/test/java/com/socops/service/BoardAssemblerTests.java`: main regression suite for board logic.

## Coding expectations

- Prefer small, deterministic helpers in the service/model layer instead of putting rules into controllers or templates.
- Keep the existing Spring MVC + Thymeleaf structure unless a task explicitly requires a larger refactor.
- Keep controller logic thin; most business rules belong in `BoardAssembler`.
- For styling, prefer the existing utility classes in `app.css` and avoid ad hoc inline styles when a reusable class can be composed.
- Match the project’s conventions: plain Java, minimal dependencies, and simple JUnit 5 tests.
- When fixing behavior, inspect the controller, assembler, and tests together before changing code; most issues live at the boundary between generated board state and UI updates.
- Prefer behavior-driven validation: add or update tests to capture the intended rule before implementing a fix.

## Relevant docs

- [README.md](README.md)
- [workshop/GUIDE.md](workshop/GUIDE.md)
- [.github/instructions/css-utilities.instructions.md](.github/instructions/css-utilities.instructions.md)
- [.github/instructions/frontend-design.instructions.md](.github/instructions/frontend-design.instructions.md)

## Good starting points for agents

If a task affects game logic, start in `BoardAssembler` and `BoardAssemblerTests`. If it affects presentation, inspect `game.html` and `app.css` next, but keep business rules out of the template layer.
