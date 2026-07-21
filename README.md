# Detective Mystery Game - 🕵️ The truth is hidden... can you find it?

## 🌟 Overview
The "Detective Mystery Game" is a fully functional Java console application where the player acts as a detective tasked with solving the high-profile theft of the "Star of Cognifzy" diamond. The player must navigate various crime scenes, collect evidence, solve logic puzzles, interrogate suspects, and deduce the real criminal. 

This project demonstrates core Java concepts, including Object-Oriented Programming (OOP) principles, exception handling, data structures (Collections), and interactive console loops.

## 🚀 Features
- **Exploration:** Visit multiple locations like the Museum, Library, Hotel, Warehouse, Park, and Secret Laboratory.
- **Evidence & Clues System:** Collect items and hints to build your case. Examine them for further details.
- **Interrogation System:** Interact with 6 unique suspects with varying truthfulness, motives, and alibis.
- **Logic Puzzles:** Crack codes to unlock hidden locations and secure the evidence required for conviction.
- **Difficulty Levels:** Choose between Easy, Medium, or Hard to limit the number of turns available.
- **Multiple Endings:** Win by accurately identifying the culprit with enough evidence, or lose by accusing the wrong person or running out of time.
- **Clean UI:** Well-formatted console outputs with ASCII art for immersion.

## 🛠 Technology Stack
- Java 17+
- Core Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList, HashMap)
- Scanner Class (for input)

## Architecture
<img src="https://github.com/ritish18089/CognifzyTask1/blob/main/cogtask1.png" height="1000px" width="1000px">

## Class Diagram Highlights
- `Main`: The entry point that instantiates the game.
- `Game`: Manages the main game loop, difficulty settings, and turns.
- `Detective`: Represents the player; handles inventory and notebook management.
- `CrimeScene`: Represents a locational entity holding clues, evidence, and lock states.
- `Suspect`: Defines the NPC's profile and interrogation dialogue behavior.
- `Clue` & `Evidence`: Model classes representing items in the world.
- `CaseFile`: Maintains global state related to suspects and puzzles.
- `Story` & `Utils`: Helper classes for formatting, narrations, and safe input reading.

## Workflow
1. The game displays the introductory narrative.
2. The user selects a difficulty which sets the turn limit.
3. The main loop begins, presenting a menu.
4. The user takes actions (visiting places, questioning suspects, examining items) which consume turns.
5. Solving the terminal puzzle unlocks the Secret Laboratory.
6. Gathering at least 2 pieces of evidence and solving the puzzle allows the player to successfully accuse the guilty suspect.
7. Game ends when a suspect is accused, or turns run out.

## Installation Steps
1. Ensure you have the Java Development Kit (JDK 17 or higher) installed on your system.
2. Clone or download this repository.
3. Navigate to the `Task 1 - Detective Mystery Game` directory.

## How to Run
### Command Line
1. Open your terminal or command prompt.
2. Navigate to the `src` folder:
   ```bash
   cd "Task 1 - Detective Mystery Game/src"
   ```
3. Compile all `.java` files:
   ```bash
   javac *.java
   ```
4. Run the main class:
   ```bash
   java Main
   ```

### IDE (VS Code, Eclipse, IntelliJ IDEA)
- Import the folder as a Java Project.
- Locate `Main.java`.
- Click the Run button within your IDE.

## Future Enhancements
- Save/Load functionality using File Handling.
- More complex procedural puzzles (randomly generated clues).
- Branching dialogue trees during interrogations.
- Graphic User Interface (GUI) via JavaFX.

## Learning Outcomes
- Real-world application of OOP principles (Encapsulation, Polymorphism).
- Managing application state across multiple objects.
- Implementing robust user input validation.
- Structuring a modular and maintainable Java project.

---

**Author:** Ritish Kannur  
**Internship:** Software Development  
**Project:** Detective Mystery Game  
