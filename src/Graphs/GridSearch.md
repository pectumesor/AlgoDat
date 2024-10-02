Grid search <br><br>
You are given a map of a city as a $n \times n$ grid $A$.
Each entry $a_{i,j}$
of $A$
represents the cost of moving to coordinates $(i,j)$
from one of the adjacent cells, i.e:$a_{i-1,j}
,a_{i+1,j}
,a_{i,j+1}
,a_{i,j-1}$.

Return the minimum cost of going from $(0,0)$
to $(n-1,n-1)$.

Runtime: $O(n^2 \log n)$. This is achieved by running the Djikstra Algorithm over the Grid.
Since Graphs can also be presented as Adjacency Matrices, this is possible.