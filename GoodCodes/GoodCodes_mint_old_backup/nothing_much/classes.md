# Usage(notations)
<C>.method() = static method
OR
<Class>.method() = static method

<c>.method() = static method
OR
<class>.method() = static method


-----------------------------------------


# Character Class
````java
toUpperCase(), toLowerCase(), toString(), 
isJavaIdentifierPart(/*checks if char can be valid any identifier character*/),
isJavaIdentifierStart(/*checks if char can be valid starting identifier character*/),
isAlphabetic(), isLetter(), isDigit(), isLetterOrDigit(),
isWhitespace(), isSpace(), isSpaceChar(),
isLowerCase(), isUpperCase(),
````

------------------------------------------


# Java String Class
````java
s.strip(), s.stripLeading(), stripTrailing()
s.split(), S.join(), s.repeat(), s.substring(), s.subSequence()
S.format()
s.compareTo(), s.equals(), s.contains(), s.startsWith(), s.endsWith(), s.isBlank(), s.isEmpty()
s.indexOf(), s.lastIndexOf ()
s.length(), s.toCharArray(), s.charAt(), s.toLower(), s.toUpper()
s.replace(), s.replaceAll(), s.replaceFirst()
S.valueOf(), S.copyValueOf(char[] c, int start, int end)
````

------------------------------------------


# Java Math class
````java
import java.math.*;
Math.PI
M.min(), M.max(), M.pow(), M.sqrt(), M.log(), M.log10()
M.abs(), M.floor(), M.ceil(), M.round(), 
````

-------------------------------------------


# Java BigInteger Class | same for BigDecimal
````java
import java.math.BigInteger;
import java.math.BigDecimal;
//built in statics
BI.ZERO, BI.ONE, BI.TWO, BI.TEN
BI.probablePrime(), BI.valueOf()
// comparison
bi.equals(), bi.and(), bi.or(), bi.xor()
//gcd and prime
bi.gcd(), bi.isProbablePrime(), bi.nextProbablePrime()
//airthmetic
bi.add(), bi.subtract(),bi.divide(), bi.multiply(), bi.remainder()
//pow and sqrt
bi.sqrt(), bi.sqrtAndRemainder(), bi.mod(), bi.modPow()
````

------------------------------------------


# Arrays class
````java
A.fill(/*set all element to given value*/),
A.asList(), A.copyOf(), A.copyOfRange(),
A.sort(), A.parallelSort(/*use only for large arrays)*/),
A.binarySearch(),
A.equals(), A.deepEquals(/*for nested array comparision*/),A.mismatch(),
A.parallelPrefix(),
A.setAll(/*can modify each element by given function */), A.parallelSetAll(),
A.toString(/*string representation of array for debugging purpose*/),
````


-----------------------------------------

# Stream class
````java
/*
->use distinct, skip, filter... before mapping ONLY IF feasible
->beware that results might deffer doing things without mapping since objects would be treated as string rather then mapped(numeric) type.
->decide carefully or in case if confusion use these after mapping
*/

[average(), min(), max(), sum()] : Boxed Type , <NumericType>
[average(), min(), max(), sum()].getAs<NumericType> : number type
...average().getAsInt();

count() : int

//check a condition on whole stream
allMatch(predicate) : boolean
allMatch(x->x>0)//check if all are positive
anyMatch(predicate) : boolean
noneMatch(predicate) : boolean

//take or skip based on condition
distinct() : stream,
filter(predicate) : stream
takeWhile(predicate) : stream
dropWhile(predicate) : stream
skip(int) : stream

forEach, forEachOrdered
paraller, asLongStream, asDoubleStream
toArray() : <type>[]
sorted //prefer after mapping
````

--------------------------------------------

# Numeric class common methods
````java
//for Byte, Integer, Float, Long, Double
// some might not apply to Byte
NT.MIN_VALUE
NT.MAX_VALUE
NT.parse<NumericType> : int
NT.valueOf() : Integer
NT.min(), NT.max(), NT.sum(),
NT.numberOfTrailingZeros()
NT.numberOfLeadingZeros()
NT.toString()
NT.toOctalString()
NT.toBinaryString()
NT.toHexString()
````

---------------------------------------------

# List methods
````java
Collections.addAll(array of Integer or <NumericType> not int)

Collections.max(ilist)
Collections.frequency(ilist,1)
Collections.min(ilist)

Collections.indexOfSubList(ilist,ilist);
Collections.lastIndexOfSubList(ilist,ilist);
Collections.binarySearch(ilist,33);

Collections.reverse(ilist);
Collections.rotate(ilist,1);
Collections.fill(ilist,55);
Collections.sort(ilist);
Collections.swap(ilist, 2, 0);
Collections.replaceAll(ilist,55, 66);
Collections.shuffle(ilist);


l.add([int index, ]E element)
l.addAll()

l.get(int index)
l.indexOf(Object o)
l.lastIndexOf(Object o)
l.isEmpty()
l.contains(Object o)
l.containsAll(Collection<?> c)

l.forEach()
l.iterator()
l.listIterator([int index])

l.clear()
l.remove(int index)
l.removeAll(Collection<?> c))

l.set(int index, E element)
l.size()
l.subList(int fromIndex, int toIndex)
l.toArray(), toString(), stream(), parallelStream()
````

----------------------------------------------

# Set methods
````java
s.toArray(), toString(), stream(), parallelStream(),
TreeSet|HashSet<>(list of Integer or <NumericType> not int) //constructor
s.forEach()
s.iterator()
s.add()
s.clear()
s.remove()
s.removeIf(x->x>5); //bulk operation
s.contains(), 
s.isEmpty()
s.containsAll(), 
s.size(), 
````

------------------------------------------------

# Map methods
````java
m.get(1)
m.getOrDefault(key, defaultValue)
m.put(key,value)
m.putIfAbsent(key, value)
m.keySet()
m.values()
m.toString()
m.size()

m.isEmpty()
m.containsKey(arg0)
m.containsValue(arg0)

m.compute(1, (x,y)->y);
m.computeIfPresent(key, (key, value)->{});
m.remove(2[, 22])
m.replace(key, oldValue, newValue)
m.clear();

m.forEach(arg0);
m.iterator()
````

-------------------------------------------------

IntSummaryStatistics iss =  Arrays.stream("1 2 3 4 5".split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
System.out.println(
	iss.getMax() +"\n"+
	iss.getMin() +"\n"+
	iss.getSum() +"\n"+
	iss.getAverage() +"\n"+
	iss.getCount()
);
Arrays.stream("1 2 3 4 5".split(" ")).mapToInt(Integer::parseInt).summaryStatistics().getMax();

		
Arrays.stream("1 2 3 4 5".split(" ")).mapToInt(Integer::parseInt).[sum|min|max|average]().getAsInt();
Arrays.stream("1 2 3 4 5".split(" ")).mapToLong(Long::parseLong).[sum|min|max|average]().getAsLong();		
Arrays.stream("1 2 3 4 5".split(" ")).mapToInt(Integer::parseInt).count();