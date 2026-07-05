# AsteroidsGame

A Java Swing recreation of the classic **Asteroids** arcade game, built from scratch with `AWT`/`Swing` for rendering and input handling. Includes a bonus **Breakout** implementation sharing the same object-oriented foundation.

## Overview

You pilot a ship through a field of drifting asteroids, dodging collisions and blasting them into smaller pieces (or oblivion) with bullets. The game runs on a manual game loop (`Thread` + `repaint()`) rather than a game engine, with collision detection, movement, and screen-wrapping handled directly in custom classes.

## Controls

| Key | Action |
|---|---|
| `S` | Start the game |
| `↑` | Thrust forward |
| `←` / `→` | Rotate ship left / right |
| `Space` | Fire bullet |

## Project Structure

**Asteroids**
- `game.java` – main game panel: game loop, input handling, collision logic, rendering
- `Window.java` – application window / entry point
- `Ship.java` – player ship: movement, rotation, thrust, dampening
- `Asteroid.java` – asteroid entities with position, velocity, and size
- `Bullet.java` – projectiles fired by the ship
- `SpaceObject.java` – shared base class for movable game objects (position, velocity, bounds-wrapping)
- `ClassTester.java` – scratch file for testing individual classes

**Breakout (bonus)**
- `BreakOut.java` / `BreakOutRunner.java` – Breakout game panel and launcher
- `Paddle.java`, `Ball.java`, `Brick.java`, `Block.java` – paddle, ball, and brick entities

## Running It

This is a plain Java project with no build tool — compile and run directly with the JDK:

```bash
javac *.java
java Window
```

(If `Window` isn't the class with `main`, check which of `game.java` / `Window.java` defines it and run that one instead.)

## Notes

This was built as a class/practice project to explore 2D game mechanics — physics-lite movement, collision detection, and object-oriented design — using nothing but core Java and Swing. Expect some rough edges (it's a learning project, not a polished release).

## License

No license specified.
