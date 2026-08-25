# AGENTS.md

## Mandatory development checklist

Before finishing any change, run and confirm these in order:

- Lint: `cd socops && ./mvnw -q test` is the project validation signal available here; do not skip if a lint step exists in the repo.
- Build: `cd socops && ./mvnw clean package`
- Test: `cd socops && ./mvnw test`

## Project

This is a Spring Boot social bingo app. The core logic lives in `socops/`.

## Start here

- `socops/src/main/java/com/socops/service/BoardAssembler.java` — board generation, toggling, streak detection
- `socops/src/test/java/com/socops/service/BoardAssemblerTests.java` — behavior regression tests
- `socops/src/main/java/com/socops/web/BingoRestController.java` — API/page boundary

## Conventions

- Prefer business rules in `BoardAssembler`, not controllers or templates.
- Keep controllers thin and UI presentation separate from game logic.
- Use the existing CSS utilities in `socops/src/main/resources/static/css/app.css` before adding ad hoc styles.
- Match the project’s plain Java + JUnit 5 style and minimal dependency approach.
- When fixing behavior, inspect the assembler, controller, and tests together before changing code.

## Useful docs

- [README.md](README.md)
- [workshop/GUIDE.md](workshop/GUIDE.md)
- [.github/instructions/css-utilities.instructions.md](.github/instructions/css-utilities.instructions.md)
- [.github/instructions/frontend-design.instructions.md](.github/instructions/frontend-design.instructions.md)
