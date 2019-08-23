https://regexone.com/lesson/line_beginning_end
````regex
'\d' - represents any digit 
'\w' - represents any alpha-numeric char 
'\w' = [a-zA-Z0-9]
'.' - single character wildcard 
'\.' - actual '.' 
'[abcdxyz]' - represents any SINGLE character from all the characters in brackets 
'[abcdxyz]' - ignores any SINGLE character from all the characters in brackets 

SOME REGEX ENGINE MIGHT NOT SUPPORT '{}' (Repetition)-
a{3} - represents 'a' char 3 times, i.e, 'aaa' 
a{1,3} - represents 'a' char 1 to 3 times, i.e, 'a' OR 'aa' OR 'aaa' 
\d{5} - represents any digit 5 times 
[wxy]{5} - represents either 'w' OR 'x' OR 'y' 5 times 
 .{2,6} - represents any single char 2 to 6 times(could be 2 OR 3 OR 4 OR 5 OR 6)
 waz{3,6}up - matches wazzzup,wazzzzup,wazzzzzup,wazzzzzzup but not wazzup,wazup 



* - 0 OR more (kleene star)
+ - 1 OR more (kleene plus)
a* - 0 OR more a
a+ - 1 OR more a 
\d+ - 1 or more digit 
[abc]+ - one or more a OR b OR c 
.* - 0 OR more any char 
a? - states that a is optional while matching so it may or may not exist 
ab?c - either abc or ac 
\? - actual '?' 

 
WHITE SPACES- 
\t - tab
\n - new line 
\r - carriage return 
' '(space) - single space 
\s - for any kind of single white space 
^hello - matches lines that starts with "hello"
World$ - matches lines that ends with "World"

 
Imagine for example that you had a command line tool to list all the image files you have in the cloud. You could then use a pattern such as ^(IMG\d+\.png)$ to capture and extract the full filename, but if you only wanted to capture the filename without the extension, you could use the pattern ^(IMG\d+)\.png$ which only captures the part before the period.
````