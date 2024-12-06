# Quick Coords Copy
Allows you to quickly copy your in-game coordinates to send to your friends!

## Usage
When in-game, press the `Copy Coordinates` key (<code>`</code> by default) and the coordinates will be copied to your keyboard.

## Config
```yaml
format=$x, $y, $z, $yaw, $pitch
```

## This Fork
This fork adds support for Horizontal (Yaw) and Vertical (Pitch) coordinates.
```yaml
format=$x, $y, $z, $yaw, $pitch
```
will provide the Yaw and Pitch in rounded numbers, while

```yaml
format=$x, $y, $z, $yawSnap, $pitch
```
will provide the Yaw snapped to the closest cardinal direction.

It also fixes a bug with the original version where the coordinates were simply rounded, resulting in `1.1` being rounded to `1` & `1.9` being rounded to `2`, messing up coordinates unless you carefully aligned yourself.