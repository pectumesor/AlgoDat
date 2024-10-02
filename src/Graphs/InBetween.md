In Between<br>

You are given a directed graph $G = (V,E)$
as an adjacency list and two vertices $x,y \in V$
. Here we say that a vertex $z$
is between $x$
and $y$
if there exist paths in $G$
such that $(1)$
you can reach $z$
from $x$
and $(2)$
you can reach $y$
from $z$
. Your goal is to count the number of vertices between $x$
and $y$.

Runtime: $O(|V|+ |E|)$. Can be achieved using DFS.

Solution: Run DFS from x in the original Graph and from y in the reversed Graph.
The first DFS will find all reachable $'z'$ and the second one will find,
all $'z'$ that can reach y. Thus counting which $'z'$ were reachable by both is the amount of nodes inbetween.