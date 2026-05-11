# Word Scramble

A small JavaFX word-scramble game built as an early-stage prototype.

Players click letter buttons to build the target word from the available letters.
The project is still very much in development and will gradually grow into a more complete game.

## Current Status

This repository currently contains a minimal playable version of the game.
The UI, gameplay flow, and overall design are still evolving.

## Features

- JavaFX desktop application
- Letter-button based word building
- Simple slot display for the target word
- Basic success/failure handling
- Maven-based project setup

## Requirements

- Java 21
- Maven 3.9+ (or the included Maven wrapper)
- JavaFX dependencies are managed through Maven

## Run

From the project root:

```bash
./mvnw clean javafx:run
```

If you prefer system Maven:

```bash
mvn clean javafx:run
```

## Project Structure

- `src/main/java/com/tahsynapse/wordscramble/Application.java` — JavaFX entry point
- `src/main/java/com/tahsynapse/wordscramble/Launcher.java` — main launcher class
- `src/main/java/com/tahsynapse/wordscramble/Controller.java` — game logic and button handling
- `src/main/resources/com/tahsynapse/wordscramble/hello-view.fxml` — JavaFX layout

## Roadmap

Planned improvements include:

- multiple scramble words
- better scoring and restart flow
- cleaner UI/UX
- improved gameplay feedback
- stronger win/lose handling
- more polish before the project is considered complete

## Notes

This is an infant-stage project.
Expect the code and gameplay to change as the full scramble game is developed.

## License

No license has been chosen yet.

