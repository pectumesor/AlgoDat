Internet Connectivity <br><br>
You are given a connected graph with $n$
vertices (numbered from $0$ to $n-1$) and $m$
edges. This graph represents a computer network, in which each vertex is a computer and each edge is a cable between two computers.
Your goal is to connect all the computers in the network to the Internet. To do that, you must upgrade some of the computers to "Internet access computers" and you must upgrade some of the cables to "Internet access cables".
For each computer $i$ and for each edge $(i,j)$
you are given the cost to upgrade it. 
You achieve your goal if, after these upgrades, there exists a path from every computer to an "Internet access computer" such that the path only uses "Internet access cables" (for the computers that are "Internet access computers", this requirement is automatically satisfied).

Runtime: We have $O(E \log E)$ since we use Kruskal Algorithm with the UnionFind Data Structure.