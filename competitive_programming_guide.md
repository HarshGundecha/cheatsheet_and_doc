```java
//untested
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
float f = sc.nextFloat();
double d = sc.nextDouble();
byte b = sc.nextByte();
String s = sc.next(); //reads data until a white space is not found
char c = sc.next().charAt(0);
// to move pointer to next line from current line or read a whole line use
sc.nextLine();
//or
sc.readLine();
```


```java
// to be reviewed, just dumped here from some other context
import java.util.Scanner;
Class Scanner
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		type t;
		t = nextType();
		//for eg.
		int i;
		i = nextInt();
		// in short use "nextType()" where Type is any primitive datatype except string
		//more eg. nextFloat(), nextDouble(), nextBigInteger() etc
		
		//for string and single character
		//for string use nextLine();
			//forwards the pointer to next line after reading content
		//for single character use next().charAt(0);
		
		//all these methods also have similar "boolean hasNextType()" methods to first check if a certain type of data is there or not
		//just use hasNextType() for e.g hasNextInt();

		//also have a "String next()" which returns anything until a space from current position
	}
}


```




datatypes with their limits
efficient input- different ways of input
collections and their usages
most basic competitve prgramming tasks
most basic math operations
	- prime
	- gcd
	- min,max, average etc
find string in string
find a number in array
manipulations of array and strings
	- built in methods
	- custom logics
sort array with different types of sort
reverse array
split and merge a string back and forth
types of program based on how it generates output
	- on each input independently
	- from first input upto current input
	- after taking all input 
