# Java 

## Aufgabe 8.2 Sudoku Solver 

Schreibe ein Programm dass mittels [Backtracking](https://de.wikipedia.org/wiki/Backtracking) ein Sudoku lösen kann. 
Ist ein Sudoku nicht lösbar gebt eine Meldung auf der Konsole aus. 

Eine Beispiel Eingabe: 

```java
int[][] sudoku = {
 { 8 , 4 , 3 , 0 , 0 , 0 , 2 , 5 , 9 },
 { 6 , 7 , 9 , 2 , 0 , 5 , 8 , 3 , 1 },
 { 0 , 0 , 2 , 9 , 0 , 3 , 7 , 0 , 0 },
 { 0 , 0 , 0 , 7 , 0 , 2 , 0 , 0 , 0 },
 { 5 , 0 , 6 , 4 , 0 , 9 , 1 , 0 , 7 },
 { 0 , 0 , 0 , 6 , 0 , 8 , 0 , 0 , 0 },
 { 0 , 0 , 7 , 3 , 0 , 4 , 5 , 0 , 0 },
 { 3 , 6 , 8 , 5 , 0 , 7 , 9 , 1 , 4 },
 { 4 , 9 , 5 , 0 , 0 , 0 , 3 , 7 , 2 }};
```