# Codeforces-1374E1-Reading-Books-easy-version-
Link: https://codeforces.com/problemset/problem/1374/E1
### Analysis
```
t[i] = reading time (amount)
a[i] = whether Alice likes the book
b[i] = whether Bob likes the book

goal:
- the set of books chosen must be both liked by Alice and Bob
- total reading time should be minimized
- sum of t[i] over all books that are in the chosen set

don’t forget that there’s an impossible test case

————————————

11 4

both:
7 1 1
2 1 1
1 1 1
8 1 1

bob only:
4 0 1
1 0 1
1 0 1

alice only:
2 1 0
3 1 0
0 1 0

none:
3 0 0

priority queue:
alice =   0   2 3
bob =     1   1 4
both = 1    2 7 8

= 1 + 0 + 1 + 2 + 2 + 1
= 7

input:
11 4
7 1 1
2 1 1
1 1 1
8 1 1
4 0 1
1 0 1
1 0 1
2 1 0
3 1 0
0 1 0
3 0 0

ans: 11

————————————

5 2

none:
6 0 0
9 0 0

bob only:
1 0 1

both:
2 1 1

alice only:
5 1 0

1 + 2 + 5 = 8

ans: 8

————————————

5 3

none:
3 0 0

alice only:
2 1 0
3 1 0

bob only:
5 0 1
3 0 1

impossible because freq[a[i]] < k and freq[b[i]] < k

in order to be valid:
freq[a[i]] >= k and freq[b[i]] >= k

ans: -1
```
