Shuffle <br><br>
Given three strings $A,B$
and $C$
with $|A|=n , |B| = m$ and $|C|=n+m$ 
, your task is to decide if $C$
is a shuffle of $A$
and $B$
. A shuffle of $A$
and $B$
is formed by merging $A$
and $B$
into a new string while maintaining both the internal order of the characters of $A$
and the internal order of the characters of $B$
. For example,
$C=PINEAPPLE$ is a shuffle of
$A=PAPLE$ and $B=INEP$.

Runtime: It was implemented in $O(n \cdot m)$ using Dynamic Programming