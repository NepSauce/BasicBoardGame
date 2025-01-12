# Board Game Simulation

This is a simple board game simulation where you can create, move, and display different types of pieces on an 8x8 board. The program allows users to interact with the game via commands input through the console.

## Features

- **Create pieces** with different attributes (Fast, Slow, Flexible).
- **Move pieces** according to their type (fast or slow).
- **Display the board** with current piece positions.
- **Help command** to display all available commands.

## Commands

- `create x y [fast][flexible]` - Creates a new piece at position (x, y).
  - Example: `create 3 4 fast flexible`
- `move x y direction [spaces]` - Moves a piece from position (x, y) in a specified direction (up, down, left, right) by a given number of spaces.
  - Example: `move 3 4 up 2`
- `print` - Displays the current state of the board.
- `exit` - Exits the program.
- `help` - Displays the available commands.
