# Monopoly-Project Sprint 3
Monopoly Project For CSCI 234. 

Authors: Finn Dempsey, Kristian Wright, Collin Cabral-Castro, Rachele Grigoli

[**BurnDown Chart**](https://moravian0-my.sharepoint.com/:x:/g/personal/wrightk_moravian_edu/EYr0nc55eU5Crc-SL6Qc2WEBqKtaUUfoWnwiVYXO8xEwbg?e=1Oinfl)


This project is a digital implementation of the classic Monopoly board game, developed as part of the CSCI 234 course. The project includes a fully functional game board, player management, property handling, and a graphical user interface (GUI) for user interaction.

## Features
- **Game Board**: A dynamic game board that supports multiple players and properties.
- **Player Management**: Tracks player tokens, turns, and game progress.
- **Bank System**: Manages in-game currency and property ownership.
- **Property System**: Handles property details such as name, price, color, and ownership.
- **Dice Rolling**: Simulates dice rolls and tracks doubles.
- **Graphical User Interface (GUI)**: Provides an interactive interface for players to play the game.
- **JUnit Testing**: Comprehensive test coverage for game logic and GUI components.

## Project Structure
- **Model**: Contains the core game logic, including classes for `Bank`, `Player`, `Property`, `GameBoard`, and `Dice`.
- **View**: Handles the graphical representation of the game, including the `GameBoardView` and `DiceView`.
- **ViewTests**: Includes JUnit test cases for testing the GUI and game logic.

## How to Run
1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Build the project using Maven:
   ```bash
   mvn test
   mvn clean install

## UML Diagram

![UML Diagram](UML)

