# AE2 Spatial Allowlist
AE2's spatial storage is pretty nice, but it doesn't allow storing tile entities from other mods. Worse than that, it's not configurable. This mod makes it configurable.

Adds a command `/saClassPath` that lists the canonical class name of the tile entity the player is looking at as well as its ancestors up to `TileEntity`. Those class paths can be added to the config to allow spatial storage to move them.

### Caution
There is a reason the tile entities are denied by default. Attempting to move them can break things or have undesired side effects. Use at your own risk.