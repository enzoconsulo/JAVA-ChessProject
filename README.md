# JAVA Chess Project

**Console-based Chess Game in Java**

This project was developed following the instructions detailed in the [Project Specification](./Enunciado.pdf) located in the root directory.

## Features

* Full chess rules: piece movements, captures, check, checkmate
* Special moves: castling, en passant, pawn promotion
* Turn-by-turn play via console input
* Board displayed in text form, with ANSI colors
* Exception handling for invalid moves

## Technologies

* Java 8+ (tested with Java 17)
* Eclipse IDE project structure (no external dependencies)

## What I Learned

* **Classes & Inheritance:** Base `Piece` class with specific piece subclasses (`King`, `Queen`, `Rook`, etc.)
* **Enums:** `Color` for white/black, `ChessPieceType` if used
* **Exception Handling:** Custom `ChessException` for rule violations
* **Data Structures:** 8×8 matrix for board, Java `List` for move history
* **Encapsulation & Modularization:** Separation into packages: `board`, `chess`, and `application` (UI)
* **Game Logic:** Validating moves, check/checkmate detection, turn management
* **Console I/O:** Reading positions like `e2 e4`, and printing board with Unicode pieces

## Project Structure

Use this structure to organize the code and resources:

```
ChessProject/
 ├─ src/
 │   ├─ application/
 │   │   └─ Program.java         # Main class (console UI)
 │   ├─ Board/
 │   │   ├─ Board.java
 │   │   ├─ BoardException.java
 │   │   ├─ Piece.java
 │   │   └─ Position.java
 │   ├─ Chess/
 │   │   ├─ ChessException.java
 │   │   ├─ ChessMatch.java
 │   │   ├─ ChessPiece.java
 │   │   ├─ ChessPosition.java
 │   │   └─ Color.java
 │   ├─ Chess/Pieces/
 │   │   ├─ Bishop.java
 │   │   ├─ King.java
 │   │   ├─ Knight.java
 │   │   ├─ Pawn.java
 │   │   ├─ Queen.java
 │   │   └─ Rook.java
 │   └─ ChessConsole/
 │       └─ UI.java             # (alternative entry point)
 ├─ exampleMatchClips/           # MP4 clips of recorded game moves
 ├─ Enunciado.pdf                # Project specification PDF
 ├─ README.md                    # This file
```

### Streaming MP4s on GitHub

You can click any MP4 in the **exampleMatchClips** folder on GitHub, and it will open a built‑in video player—no need to download locally. If you prefer embedding in Markdown, use:

```html
<video width="480" controls>
  <source src="https://raw.githubusercontent.com/enzoconsulo/JAVA-ChessProject/main/exampleMatchClips/Move1.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
```

---

*Developed by a Computer Engineering student to explore OOP and Java.*
