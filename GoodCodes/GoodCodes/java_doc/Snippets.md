# BinarySearch
````java
int bin_search(int a[], int l, int r,  int k)
{		
	for(int m = (l+r)/2; l<=r; m = (l+r)/2)
		if( a[m] < k )
			l = m+1;
		else if( a[m] > k )
			r = m-1;
		else
			return m;
	return -1;
}
````

-------------------------------------------

# BinaryFindMax
````java
//your code here
````

-------------------------------------------

# BinaryFindNearest
````java
//your code here
````

-------------------------------------------

# find primes
````java
// get the next prime number
public static int getNextPrime(int i, int n, boolean[] barr)
{
	if(i<2)
		return 2;
	for(;i<=Math.sqrt(n+1);i++)
		if(!barr[i])
			return i;
	return n+1;
}

//get all primes up to gievn N
public static boolean[] getBooleanPrimesUpToN(int n)
{
	boolean[] barr = new boolean[n+1];
	int i,j;
	barr[0]=barr[1] = true;
	for(i=getNextPrime(0, n, barr); i<=n; i=getNextPrime(i+1, n, barr))
		for(j=i+i; j<=n; j+=i)
			barr[j] = true;
	return barr;
}
````

-------------------------------------------

# Reverse LinkedList
````java
public Node reverse(Node head)
{
	Node curr = head, prev = null;
	while(curr!=null)
	{
		curr = curr.next;
		head.next = prev;
		prev = head;
		head = curr;
	}
	return prev;
}
````

-------------------------------------------

# Count frequency of input
````java
Map<Integer, Integer> freq = new HashMap<>();

Arrays.stream(br.readLine().split(" +"))
	.mapToInt(Integer::parseInt)
		.forEach(i->freq.put(i, freq.getOrDefault(i, 0)+1));
````

-------------------------------------------

# iterate over hashMap
- ## 1. Iterate keys

	````java
	for (<type> key : myMap.keySet())
		so.println(key);
	````

- ## 2. Iterate values
	````java
	for (<type> value : myMap.values())
		so.println(value);
	````

- ## 3. Iterate Key : Value pair
  - ### 1
	````java
	for (Map.Entry<<key_type>, <value_type>> entry : myMap.entrySet())
		so.println(entry.getKey()+" : "+entry.getValue());
	````
  - ### 2

	````java
	myMap.entrySet()
		.forEach( entry -> so.println( entry.getKey()+" : "+entry.getValue() ) );
	````

-------------------------------------------

# English Numbers to Roman

Number | Roman
-------|--------
1			 | I
5			 | V
10		 | X
50		 | L
100		 | C
500		 | D
1000	 | M

-------------------------------------------

## ASCII Table
Character	|ASCII
----------|---------
SPACE 		| 32
0-9 			| 48 - 57
A-Z 			| 65 - 90
a-z 			|	97 - 122