# MCPi

## Overview

This app visualizes a Monte Carlo algorithm for calculating π.

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