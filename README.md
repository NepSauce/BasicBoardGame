# Board Game Simulator

This project simulates a simple board game with pieces that move across an 8x8 grid according to specific movement rules.

## Project Overview

- **Piece Class**: Represents a piece on the board with a name, color, and position.
- **SlowPiece**: A piece that moves one step at a time, left or right.
- **FastPiece**: A piece that moves multiple steps at a time, left or right.
- **Flexible Pieces**: Pieces that can move in any direction (left, right, up, down).
- **Board Class**: Contains the 8x8 grid, handles adding and moving pieces.
- **GameDemo Class**: Provides a simple user interface to create pieces, move them, and display the board.

## Commands

- **create x y [fast] [flexible]**: Creates a piece at (x, y) with optional fast and flexible attributes.
- **move x y direction [spaces]**: Moves a piece at (x, y) in the specified direction (up, down, left, right), with optional space count for fast pieces.
- **print**: Displays the board.
- **help**: Lists all available commands.
- **exit**: Exits the game.

## Example Usage

```bash
> create 3 3 fast flexible
Input a name for the new piece: Jedi
Input a colour for the new piece: Red
