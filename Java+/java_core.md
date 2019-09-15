# Imp classes to look for
arrrays
ticks and hacks like bits and all

average operations per second = 10^8

---------------------------------------------

-	## Arrays
	- binarySearch
	- sort

-	## Collections
	- different collections with imlememtstions
	-	+ useful methods

-	## Stream
	- https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
	- sorted
	- range
	- toArray
	- mapTo<Type>
	- reduce
	- filter
	- skip
	- forEach
	- concat
	- count
	- distinct

----------------------------------------------------
Collections.reverse(Arrays.asList(strArr));


-----------------------------------------------------------------

# Fast I/O

## Output ways

### `StringBuilder`
- provides more control over content manipulation, use only when needed
	
	````java 
	StruigBuilder sb = new StringBuilder();	//declare
	sb.setLength(0);				//clear sb for reuse at begining of loop
	sb.append(str);					//append
	sb.insert(0, str);			//prepend
	sb.deleteCharAt(index); //used to rmeove last new line character
	//others
	length(), indexOf(), lastIndexOf(), charAt(),
	set(), replace(), delete(), deleteCharAt(), reverse(), trimToSize(),
	//to print
	System.out.println(sb);
	````

### `System.out`
- provides less control but should be used, short, concise and default
  
	````java
	PrintStream so = System.out;
	so.println("hello"); // can use all System.out methods with so object

	Consumer<Object> cc = s -> System.out.println(s); // notice that println is harcoded to cc
	cc.accept(5+5); // prints 10

	so.append(data);		// keep appending your data to so and flush at end
	so.append(data, startIndex, endIndex);
	// same as simple append + can be use to append substring from given string by setting indexes
	so.format("<printf_syntax_here>",data); // used to append alongwith formatting

	so.flush(); 				// write/flush data to stdout
	//others
	print(), printf(), println(),
	````

## Input Ways

### `BufferedReader`
- provides faster reading, specially for reading numric arrays given on single line
	````java
	class Temp{
		public static void main(String[] s)throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int i = Temp.readX(br)[0];		//input 1 number
			int[] arr = Temp.readX(br);	//input N number
		}
		public static int[] readX(BufferedReader br)throws IOException{
			return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}
	````

### `Scanner`
- slow, but contains more options for reading input 
	````java
	Scanner sc = new Scanner(System.in);
	<number_type> nt = sc.next<number_type>();
	String s = sc.readLine();	//reads whole line + also used to advance pointer to next line
	char c 
	````
-----------------------------------------------------------------

# Conversion Ways
## string to numeric types
````java
<Type>.parse<Type>	//return primitive type i.e, int (preferred)  
Integer.parseInt()

<Type>.valueOf			//returns Class object type i.e, Integer
Integer.valueOf()
````

## numeric types to string
````java
int i = 123;
float f = 1.2f;
String stri = i+"";
String strf = f+"";
````

## one base to other base (2,8,10,16)
````java
Integer.parseInt("01111111", 2) +"\n"+
// 0111111 as binary to 127 as integer in base 10

Integer.toString(127, 2) +"\n"+
// 127 as ineger in base 10 to 01111111 in binary

Long.toString(Integer.parseInt("127", 10), 2) +"\n"+
Integer.toString(Integer.parseInt("01111111", 2), 10)
//oneliner vice-versa
````

## character to digit
````java
String str = "123";
int i = Character.getNumericValue(str.charAt(0));
````
## digit to character
````java
int i = "123";
char c = (i+"").charAt(0);
````

## character to ASCII
````java
char c = 'a';
int asciiOfC = (int)c;
````

------------------------------------------------

# imports
````java
import java.lang.*;	// for 
import java.io.*;		// for io, 
import java.util.*;	// for
import java.util.stream.Stream; //for stream related all things
````
--------------------------------------------
#HashMap  
- hm.put(key, value);
- hm.size();
- hm.getOrDefault(keyToSearch, defaultValue);
- hm.get(key);
- hm.remove(key);

---------------------------------
#Stream related functions
- range(0,n)      		        		=		i=0..i<n
- filter((x->{										=		body of for loop for single - element x in array
		return True or False
	}) 
- intStream()                     =		integer based stream
- forEach                         =		iterate over some data
- parallel()                      =		multithreaded, use only if - input is too long
- toArray()                       =		generate array from incoming - data
- count()                         =		gives count of incoming data
- mapTo<Type>(<cast_function>)    =		parse incoming data to other - type for further processing
- sorted()                        =		sorts data in natural order
- sum()                           =		gives sum of incoming data

-----------------------------------------------
#comparisions
- string compare that returns boolean  
	`str1.equals(str2);`

- generic version that returns boolean  
	`Objects.equals(var1, var2))`
01
-------------------------------------------------	

- //find max element from array one liner  
`max = IntStream.of(intArr).max().getAsInt();`

---------------------------------------------


# Datatypes and Range
## Primitive types()
Type		|	Size 		|	Range
--------|---------|---------------------------------------------------
byte		| 1 byte	|	2^7		-		~10^2		-		-128 to 127
short		|	2 bytes |	2^15	-		~10^4		-		-32,768 to 32,767
int			|	4 bytes |	2^31	-		~10^9 	-		-2,147,483,648 to 2,147,483, 647
long		|	8 bytes |	2^63	-		~10^18	-		-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float		|	4 bytes |	approximately ±3.40282347E+38F (6-7 significant decimal digits)Java implements IEEE 754 standard
double	|	8 bytes |	approximately ±1.79769313486231570E+308(15 significant decimal digits)
char		|	2 byte	|	0 to 65,536 (unsigned)
boolean |			-		|	true or false

## Non Primitive Types
String
Array
Class Objects
Stream