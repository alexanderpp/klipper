# Klipper
Klipper is a Kotlin port of the Clipper libary.


## Clipper

The Clipper library performs **clipping**, and **offsetting** of both lines and polygons.

Official documentation: [here](http://www.angusj.com/delphi/clipper/documentation/Docs/Overview/_Body.htm)

<br>

**Author**: Angus Johnson

**Link**: http://www.angusj.com/delphi/clipper.php


## Setup

Klipper is supplied via JitPack.

To add it to your Android/Gradle project complete the following steps:

* Add the JitPack to your .gradle file:

```gradle
repositories {
  maven { url 'https://jitpack.io' }
}
```

* Add the Klipper to your dependencies:

```gradle
compile 'com.github.alexanderpp:klipper:1.0'
```

## Features

### Clipping

Clipping allows you to perform boolean operations (AND, OR, NOT & XOR) on poligons.

* AND (Intersection) - create regions where both subject and clip polygons are filled;
* OR (Union) - create regions where either subject or clip polygons (or both) are filled;
* NOT (Difference) - create regions where subject polygons are filled except where clip polygons are filled;
* XOR (Exclusive or) - create regions where either subject or clip polygons are filled but not where both are filled.

More information: [here](http://www.angusj.com/delphi/clipper/documentation/Docs/Units/ClipperLib/Types/ClipType.htm)

### Offsetting

Offsetting is the process of inflating/deflating both open and closed paths using a number of different join types and end types.

More information: [here](http://www.angusj.com/delphi/clipper/documentation/Docs/Units/ClipperLib/Classes/ClipperOffset/_Body.htm)



