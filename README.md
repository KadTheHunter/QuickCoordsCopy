# Quick Coords Copy
Allows you to quickly copy your in-game coordinates to send to your friends!

## Usage
When in-game, press the `Copy Coordinates` key (<code>`</code> by default) and the coordinates will be copied to your keyboard.

## Enhanced!
This fork:
- Adds support for Yaw (Horizontal), Rounded Yaw, Pitch (Vertical), and Full Decimal coordinates
- Replaces SimpleConfig with ClothConfig, and adds ModMenu integration
- Fixes a bug where coordinates were rounded to the nearest integer (i.e. `1.1` to `1`, and `1.9` to `2`)

## Variables
Valid variables are:
- `$x` - X coordinate
- `$xFull` - X coordinate including decimals
- `$y` - Y coordinate
- `$yFull` - Y coordinate including decimals
- `$z` - Z coordinate
- `$zFull` - Z coordinate including decimals
- `$yaw` - Yaw coordinate
- `$yawFull` - Yaw coordinate including decimals
- `$yawSnap` - Yaw coordinate rounded to the nearest cardinal direction
- `$pitch` - Pitch coordinate
- `$pitchFull` - Pitch coordinate including decimals

An example of these variables in use:
```yaml
I'm at $x $y $z, looking around $yawSnap ($yawFull to be precise!), with a pitch of $pitch!
```