ALGO-Turm <br> <br>
Gegeben sei eine Kiste mit $n \leq 5000$
ALGO-Steinen, welche von $1$
bis $n$
durchnummeriert sind. Der $i$-te ALGO-Stein ist ein Quader mit Grundfläche
$l_i \times b_i$ und Höhe $h_i$, mit
$l_i,b_i \in \{1,2,...,10000\}$ und
$h_i \in \{0,1,...,1000\}$.

Aus diesen Steinen soll nun ein möglichst hoher Turm gebaut werden. Dazu dürfen die vorhandenen Steine aufeinandergestapelt werden, solange dabei keine Überhänge entstehen. Formaler: Der
-te Stein darf genau dann auf den
-ten Stein aufgesetzt werden, wenn mindestens eine der folgenden zwei Bedingungen gilt:
1. $l_j \geq l_i $ und $b_j \geq b_i$ oder
2. $l_j \geq b_i $ und $b_j \geq l_i$


Intuitiv gesprochen entspricht die zweite Bedingung einer Drehung des
$i$-ten Steins um $90°$ Grad.

Ein ALGO-Turm ist eine Liste $\{t_1,t_2,...,t_k\}$
von paarweise unterschiedlichen Indizes, sodass für alle $1 \leq i < k$
der Stein $t_{i+1}$ auf den Stein $t_i$ aufgesetzt werden darf. Die Höhe $H$
eines solchen Turms ergibt sich als Summe der Höhen aller verwendeten Steine, das heisst
$\sum_{i=1}^k h_{t_i}$.

Ihre Aufgabe ist es nun, die Höhe eines höchstmöglichen ALGO-Turms zu berechnen, welcher mit den vorhandenen ALGO-Steinen gebaut werden kann. 
Dabei dürfen Sie annehmen, dass alle Grundflächen paarweise unterschiedlich sind, und dass die Steine nach absteigender Grundfläche sortiert sind.
In anderen Worten gilt für $1 \leq i < n$ 
, dass $l_i \cdot b_i > l_{i+1} \cdot b_{i+1}$.

Runtime: $O(n^2)$ mit Dynamisches Programmieren.