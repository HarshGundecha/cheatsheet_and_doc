- [DB Normal Forms](#db-normal-forms)
	- [1nf](#1nf)
	- [2nf](#2nf)
	- [3nf](#3nf)
	- [bcnf](#bcnf)
	- [4nf](#4nf)
- [References](#references)

# DB Normal Forms

## 1nf
- atomic value
- domain shouldnt change

## 2nf
- to be in 1 nf
- not partial dependency
	- Partial Dependency is where an attribute in a table depends on only a part of the primary key and not on the whole key.

## 3nf
- 2nf
- it should not have Transitive Dependency.
	- Transitive Dependency is When a non-prime attribute depends on other non-prime attributes rather than depending upon the prime attributes or primary key.

## bcnf
- 3nf
- for any dependency A → B, A should be a super key.

## 4nf
- 3nf
- For a dependency A → B, if for a single value of A, multiple value of B exists, then the table may have multi-valued dependency.
  - Also, a table should have at-least 3 columns for it to have a multi-valued dependency.
	And, for a relation R(A,B,C), if there is a multi-valued dependency between, A and B, th
	en B and C should be independent of each other.
	- If all these conditions are true for any relation(table), it is said to have multi-valued dependency.

# References
- [studytonight](https://www.studytonight.com/dbms/boyce-codd-normal-form.php)
- checkout youtube too