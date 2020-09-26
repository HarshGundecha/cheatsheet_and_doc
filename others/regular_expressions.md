- [Regex](#regex)
	- [Basics](#basics)
	- [Capture Group](#capture-group)
	- [Repetition](#repetition)
	- [White spaces](#white-spaces)
	- [Example](#example)
- [References](#references)

# Regex

## Basics

-----------------------------------------------------------------------------------
| Exp         | Meaning
--------------|--------------------------------------------------------------------
| .           | single character wildcard 
| `\.`		  | actual '.' 
| *           | character left to * 0 to N times
| .*          | any char 0 to N times
| a*          | 0 to N times a
| +           | character left to + 1 to N times
| a+          | 1 to N times a 
| \d+         | 1 to N digit(s) 
| [abc]+      | a OR b OR c one or more time  
| \?          | represents actual '?', escaping
| ?           | make the character left to ? optional
| a?          | states that a is optional 
| ab?c        | matches abc or ac 
| \d          | any digit 
| \D		  | any non diigt 
| \w          | any alphanumeric char
| \W          | any Non-alphanumeric char
| [abc]		  | represents any SINGLE character from all the characters in brackets 
| [^abc]	  | ignores any SINGLE character from all the characters in brackets 
| ^           | begining of line
| ^hello      | matches lines that starts with "hello"
| $           | end of line
| World$      | matches lines that ends with "World"
| ^hello$     | matches lines that exactly contains "hello"

---
---
---

## Capture Group

----------------------------------
| Exp.		  | Meaning
--------------|-------------------
| (…)		  | Capture Group
| (a(bc))	  | Capture Sub-group
| (.*)		  | Capture all
| (abc|def)	  | Matches abc or def

---
---

## Repetition
- some regex engine might not support '{}' (Repetition)

---------------------------------------------------------------------------------------
| Exp.        | Meaning
--------------|------------------------------------------------------------------------
| a{3}        | represents 'a' char 3 times, i.e, 'aaa' 
| a{1,3}      | represents 'a' char 1 to 3 times, i.e, 'a' OR 'aa' OR 'aaa' 
| \d{5}       | represents any digit 5 times 
| [wxy]{5}    | represents either 'w' OR 'x' OR 'y' 5 times 
| .{2,6}      | represents any single char 2 to 6 times
| waz{3,6}up  | matches wazzzup with 3 to 6 z 

---
---
---

## White spaces

--------------------------------------------------
| Exp         | Meaning
--------------|-----------------------------------
| ' '         | single space 
| \t          | tab
| \n          | new line 
| \r          | carriage return 
| \s          | for any kind of single white space 
| \S          | for any kind of non white space 

---
---
---
 
## Example
- Imagine for example that you had a command line tool to list all the image files you have in the cloud. You could then use a pattern such as ^(IMG\d+\.png)$ to capture and extract the full filename, but if you only wanted to capture the filename without the extension, you could use the pattern ^(IMG\d+)\.png$ which only captures the part before the period.

# References
- [RegexOne](https://regexone.com/)