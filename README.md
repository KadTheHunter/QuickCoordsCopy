<h1 align="center">Quick Coordinates Copy: Enhanced</h1>

<p align="center">
<a href="https://modrinth.com/mod/quickcoordinatescopy-enhanced">
<img alt="Current Modrinth Release" src="https://img.shields.io/modrinth/v/BHa3moov?style=for-the-badge&logo=modrinth"/>
</a>
<a href="https://github.com/KadTheHunter/QuickCoordsCopy/releases">
<img alt="Current GitHub Release" src="https://img.shields.io/github/v/release/KadTheHunter/QuickCoordsCopy?label=VERSION&style=for-the-badge&logo=github"/>
</a>
<br/><br/>
<a>
<img alt="Modrinth Downloads" src="https://img.shields.io/modrinth/dt/BHa3moov?style=for-the-badge&logo=modrinth"/>
</a>
<br/><br/>
<a href="https://buymeacoffee.com/kaddicus" target="_blank">
<img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="31" width="164">
</a>
</p>

Quick Coordinates Copy: Enhanced is a client-side mod for [Fabric](https://fabricmc.net).

[Fabric API](https://modrinth.com/mod/fabric-api) is required, [Mod Menu](https://modrinth.com/mod/modmenu) and [Cloth Config API](https://modrinth.com/mod/cloth-config) are optional, but strongly recommended.

---

*While its possible to remember or manually type out coordinates from F3 or a HUD mod, why should it be so difficult? With Quick Coordinates Copy: Enhanced, you can copy any and every coordinate in a format suitable for you, with the quick press of a button!*

## Usage
When in-game, press the primary or secondary `Copy Coordinates` key (Default: <code>`</code> for primary, unbound for secondary) and the coordinates will be copied to your clipboard, in the format you chose.

## Enhanced!
This fork:
- Adds support for Yaw (Horizontal), Rounded Yaw, Pitch (Vertical), and Full Decimal coordinates
- Adds a secondary keybind/copy format
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
- `$pitchSnap` - Pitch coordinate rounded to the nearest vertical direction

An example of these variables in use:
```yaml
I'm at $x $y $z, looking around $yawSnap ($yaw to be precise, $yawFull more-so!), with a pitch around $pitchSnap ($pitch to be precise, $pitchFull more-so!)
```

---

Full credit to **CraftVoltage**/**Simplex-Dev** for creating the original [Quick Coordinates Copy](https://modrinth.com/mod/qcc) mod, and **eliaxelang007** for creating the first fork.

This fork retains the LGPL-2.1-only license used in the original.