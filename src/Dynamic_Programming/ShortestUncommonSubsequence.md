Shortest Uncommon Subsequence <br><br>
Given an $n$-element string $A$
and an
$m$-element string $B$
such that $A$
is not a subsequence of $B$
and $n \leq m$
, your task is to compute the length of a shortest uncommon subsequence of $A$
with respect to $B$
, i.e., the length of a shortest subsequence of $A$
that is not a subsequence of $B$
. For example, if $A = EETTT$
and $B = TETTE$
, $EET$
is a shortest uncommon subsequence of $A$
with respect to $B$
, and its length is 3.

Runtime: $O(nm^2)$

Achieved by using a table to prevent computation of already computed values, i.e.:
Dynamic Programming
