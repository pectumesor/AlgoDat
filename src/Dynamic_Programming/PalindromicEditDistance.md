Palindromic Edit Distance <br><br>
Given a sequence $A$
of $n$
characters, your task is to compute the minimum number of operations that is required to turn $A$
into a palindrome. A palindrome is a sequence of characters which reads the same backward as forward, e.g., "level", "noon","racecar". We consider the following operations:

Change the character at any position
Remove the character at any a position
Insert a character at any position.
For example, if $A$
is "ETHZETHZ", the answer is 3.

Runtime: $O(n^2)$