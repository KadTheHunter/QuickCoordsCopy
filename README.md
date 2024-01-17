# Quick Coords Copy
Allows you to quickly copy your in-game coordinates to send to your friends!

![](https://cdn.discordapp.com/attachments/838048982873538572/1006522579223330866/unknown.png)

## Usage
When in-game, press the `Copy Coordinates` key (<code>`</code> by default) and the coordinates will be copied to your keyboard.

## Config
```yaml
format=$x, $y, $z, $h, $v
```

## This Fork
This fork adds support for Horizontal (Yaw) and Vertical (Pitch) coordinates, both precise and snapping.
```yaml
format=$x, $y, $z, $h, $v
```
will provide the Yaw and Pitch in rounded numbers, while

```yaml
format=$x, $y, $z, $LRSnap, $UDSnap
```
will provide the Yaw and Pitch snapped to the closest cardinal direction.

It also fixes a bug with the original version where the coordinates were simply rounded, resulting in `1.1` being rounded to `1` & `1.9` being rounded to `2`, messing up coordinates unless you carefully aligned yourself.