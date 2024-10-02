Multiple of Three You are given two n-element arrays
A and P, indexed from 0 to n-1, that contain as values integers between 0
and n-1
. You are a playing a game in which you start with a pawn at index k
. If your pawn is at some point at index i
, you can move it to index P[i]
. Your goal is to arrive at an index where A[i]
is a multiple of 3.

Return the number of moves that you must make to arrive at such an index, or return -1
if you can never arrive at such an index. Note that, if A[k]
is already a multiple of 3, the answer is 0.

For example, for n = 5
, k = 0
, A = [1,3,1,2,2]
, and P = [2,0,3,1,1]
, the answer is 3.