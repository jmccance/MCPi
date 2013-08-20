# MCPi

## Overview

This app visualizes a Monte Carlo algorithm for calculating π. When run, you'll
see lots of dots drawn onto a square that has a circle inscribed in it. Dots
inside the circle are one color, while dots outside the circle are another. The
ratio of circle dots to square dots is used to calculate an approximation of π.
The red circle shows how big the white circle would be if you had drawn it using
the current approximation of π, which is shown in the middle of the
visualization.

### Building

MCPi is built with Maven. To build and run, use:

    mvn clean package
    cd target
    java -jar mcpi-1.0-SNAPSHOT.jar

### Technical Details

The algorithm works by approximating the ratio of the area of a unit square and
a circle inscribed inside that square. Note that if *C* is the area of the
circle and *S* is the area of the square, and the side of the square is *L*,
then

    C     π(L/2)^2
    --- = --------
    S       L^2

          πL^2
        = ----
          4L^2

        = π / 4

So

    4C
    -- = π
    S

Of course we can't just calculate C directly without knowing π in advance, but
using a Monte Carlo approach we can get a rough estimate of the value of
*C*/*S* by generating an even distribution of points over the square. Since the
number of points that shows up in either shape will be directly proportional to
the area of that shape, the ratio of the number of points inside the circle to
the total number of points will be approximately *C*/*S*. The more points we
generate, the closer we'll get to *C*/*S* and the more accurate our final
estimate will be.

## TODO

### Points

The current approach to passing points around is pretty ugly. Having a
separation between screen points and "real" points makes sense, but the current
proliferation of `Point2D` and `PiPoint` is just silly.

### Configuration

There's some low-hanging fruit to be picked in to allow easy setting of FPS and
window size.