//numbers, strings, and Booleans, are all immutable //check others
// objects are not immutable

/*
0, NaN, undefined, null and the empty string ("") count as false, while all the other values
count as true.
*/

// - (minus) is both unary and binary operator

// infinity represents a infinite number which isnt defined
// but infinity!=undefined
// infinity!=NaN
// null==undefined //true
// infinity==infinity+1 //true

//

/*
JavaScript warns for overriding bindings(declarations) you declared with let or const but—perversely—not for standard bindings nor
for bindings declared with var or function.
*/

/*
-outer variables are available to inner scopes but variables of inner scopes are not availabe to outer scopes
*/

const hummus = function(factor) {
	const ingredient = function(amount, unit, name) {
		let ingredientAmount = amount * factor;
		if (ingredientAmount > 1) {
			unit += "s";
		}
		console.log(`${ingredientAmount} ${unit} ${name}`);
	};
	ingredient(1, "can", "chickpeas");
};
//here factor variable is available inside ingredient function but ingredientAmount is not available outside ingredient function
//this scoping is called lexical scoping

/*
-"let" and "const" creates local scope of variables in control structures(ifs and loops and others) too but "var" doesnt do so
	-so if a variable is created inside "if" using "let" or "const" it wont be accessible outside if but if same is created using "var" it woud be accessible outside "if" too
*/

// below are 3 ways to make a function

//1
//below code works fine even though the function defined after it is called
//this works as function definations are tossed to top while interpretation
/*
Function declarations are not part of the regular top-to-bottom
flow of control. They are conceptually moved to the top of their scope and can
be used by all the code in that scope. This is sometimes useful because it offers
the freedom to order code in a way that seems meaningful, without worrying
about having to define all functions before they are used.
*/
console.log("The future says:", future());
function future() {
return "You'll never have flying cars";
}

//2
//below code will not work as the fucntion defination is assigned to future variable after it is called,
// so it isnt avalaibale while calling it
console.log("The future says:", future());
let future=function() {
return "You'll never have flying cars";
}; 

//3
//below is called arrow function -added in 2015
const multiply = (x,y) => { return x * y; };
//console.log(multiply(2,5));

// if theres only one parameter and also only something like one expression to return
// then it could be done in following shorter way
const square = x => x * x;
//console.log(square(5));

//functions which doesnt return anything returns undefined by default

// extra arguements passed while calling a function are ignored
/*
 similarly when less than required arguements are passed while calling a function,
 the remaining parameters(right most) in function are assigned undefined as their value
*/
/*
JS supports default parameters in case when a arguement is either missing or contains undefined as value
for e.g.,
*/
function power(base, exponent = 2) {
	let result = 1;
	for (let count = 0; count < exponent; count++)
		result *= base;
	return result;
}
console.log(power(4)); //16
console.log(power(3,3)); //27

/*
-a function that returns reference to a function in return is called closure
-thus both function combinely perfomrs a task completely and performs partial tasks individually
*/
function multiplier(factor) {
	return number => number * factor;
}
//or
function multiplier(factor) {
	return function(number) {
		return number * factor
	};
}

//retuns arrow function(with defination as wahtever written after return) which is assigned to the LHS of caller
//

let twice = multiplier(2);
console.log(twice(5)); //10
let thrice = multiplier(3);
console.log(thrice(5)); //15

/*
Functions can be roughly divided into those that are called for their side effects
and those that are called for their return value.
*/

/*
-the function that prints something instead of returning is called function with side effect as it effects output
-the function that returns something instead of printing is called function with returns
-there also be function that does both

-Functions that create return values are easier to combine in
new ways than functions that directly perform side effects.

-A pure function is a specific kind of value-producing function that not only
has no side effects but also doesn’t rely on side effects from other code—for
example, it doesn’t read global bindings whose value might change. A pure
function has the pleasant property that, when called with the same arguments,
it always produces the same value (and doesn’t do anything else). A call to
such a function can be substituted by its return value without changing the
meaning of the code. When you are not sure that a pure function is working
correctly, you can test it by simply calling it and know that if it works in that
context, it will work in any context. Nonpure functions tend to require more
scaffolding to test.
*/

/*
We’ve seen a few suspicious-looking expressions like myString.length (to get
the length of a string) and Math.max (the maximum function) in past chapters.
These are expressions that access a property of some value. In the first case,
we access the length property of the value in myString. In the second, we
access the property named max in the Math object 

=>short explanation
-The two main ways to access properties in JavaScript are with a dot and with
square brackets.
-Both value.x and value[x] access a property on value—but
not necessarily the same property
-in first case i.e., value.x , x is not evaluated ,property is directly accessed
-while in value["x"] the expression between square bracket is evaluated and the result is access as a property of value

-accessing en element of array is like accessing a property of array but since the indexes are numeric we cant access array.0 so we use array[0]


=>long explanation
The two main ways to access properties in JavaScript are with a dot and with
square brackets. Both value.x and value[x] access a property on value—but
not necessarily the same property. The difference is in how x is interpreted.
When using a dot, the word after the dot is the literal name of the property.
When using square brackets, the expression between the brackets is evaluated to
get the property name. Whereas value.x fetches the property of value named
“x”, value[x] tries to evaluate the expression x and uses the result, converted
to a string, as the property name.
So if you know that the property you are interested in is called color, you say
value.color. If you want to extract the property named by the value held in
the binding i, you say value[i]. Property names are strings. They can be any
string, but the dot notation works only with names that look like valid binding
names. So if you want to access a property named 2 or John Doe, you must
use square brackets: value[2] or value["John Doe"].
The elements in an array are stored as the array’s properties, using numbers
as property names. Because you can’t use the dot notation with numbers and
usually want to use a binding that holds the index anyway, you have to use the
bracket notation to get at them.
The length property of an array tells us how many elements it has. This
property name is a valid binding name, and we know its name in advance, so
to find the length of an array, you typically write array.length because that’s
easier to write than array["length"].

-all variabes or objects or datataypes have some default methods of them 
like toUpperCase() or toLowerCase() method for string or push() and pop() for arrays





*/

let day1 = {
	squirrel: false,
	events: ["work", "touched tree", "pizza", "running"]
	""
};
console.log(day1.squirrel); // → false
console.log(day1.wolf); // → undefined
day1.wolf = false;
console.log(day1.wolf); // → false
/*
-Reading a property that doesn’t exist will give you the value undefined.
-It is possible to assign a value to a property expression with the = operator.
This will replace the property’s value if it already existed or create a new property on the object if it didn’t.
*/

let descriptions = {
work: "Went to work",
"touched tree": "Touched a tree"
};
/*
-Properties whose names aren’t valid binding names or valid numbers have to be quoted like "touched tree" in above example.
*/

let anObject = {left: 1, right: 2};
console.log(anObject.left); // → 1
delete anObject.left;
console.log(anObject.left); // → undefined
console.log("left" in anObject); // → false
console.log("right" in anObject); // → true
/*
-the delete operator deletes an object's property
-the in operator returns true or false for whether a property exists or not in a object
*/


console.log(Object.keys({x: 0, y: 0, z: 2})); // → ["x", "y", "z"]
/*
To find out what properties an object has, you can use the Object.keys
function. You give it an object, and it returns an array of strings—the object’s
property names.
*/



let objectA = {a: 1, b: 2};
Object.assign(objectA, {b: 3, c: 4});
console.log(objectA); // → {a: 1, b: 3, c: 4}
/*
There’s an Object.assign function that copies all properties from one object
into another.
*/


WHAT IS IMMUTABLE

let object1 = {value: 10};
let object2 = object1;
let object3 = {value: 10};
console.log(object1 == object2); // → true
console.log(object1 == object3); // → false
object1.value = 15;
console.log(object2.value); // → 15
console.log(object3.value); // → 10


/*
-The object1 and object2 bindings grasp the same object, which is why
changing object1 also changes the value of object2. They are said to have the
same identity.
-When you compare objects with JavaScript’s == operator, it compares by
identity
*/
const score = {visitors: 0, home: 0};
score.visitors = 1; // This is okay
score = {visitors: 1, home: 1}; // This isn't allowed
/*
-const made variable that stores object cant be reused to store another object, but the propertties of object can be changed
*/


let journal = [];
function addEntry(events, squirrel) {
	journal.push({events, squirrel});
}
addEntry(["work", "touched tree", "pizza", "running", "television"], false);
addEntry(["work", "ice cream", "cauliflower", "lasagna", "touched tree", "brushed teeth"], false);
addEntry(["weekend", "cycling", "break", "peanuts", "beer"], true);
console.log(journal);
/*
-in journal.push() we see that we are inserting object with only property or value but not both like property:value
-in this case the the variable name would become the property name and the variables values would become property's values
*/

let animals=["dog", "cat"];
animals.includes("dog"); //true
//Arrays have an includes method that checks whether a given value exists in the array.


/*
We saw push and pop, which add and remove elements at the end of an array.
The corresponding methods for adding and removing
things at the start of an array are called unshift and shift respectively.

-To search for a specific value, arrays provide an indexOf method. The method
searches through the array from the start to the end and returns the index at
which the requested value was found—or -1 if it wasn’t found. To search from
the end instead of the start, there’s a similar method called lastIndexOf
-Both indexOf and lastIndexOf take an optional second argument that indicates
where to start searching.

-Another fundamental array method is slice, which takes start and end indices
and returns an array that has only the elements between them. The start
index is INCLUSIVE, the end index EXCLUSIVE.
-When the end index is not given, slice will take all of the elements after the
start index. You can also omit the start index to copy the entire array.

-The concat method can be used to glue arrays together to create a new array,
similar to what the + operator does for strings.

*/


function remove(array, index) {
	return array.slice(0, index).concat(array.slice(index + 1));
}
console.log(remove(["a", "b", "c", "d", "e"], 2)); // → ["a", "b", "d", "e"]
/*
The above example shows both concat and slice in action. It takes an
array and an index, and it returns a new array that is a copy of the original
array with the element at the given index removed.
-If you pass concat an argument that is not an array, that value will be added
to the new array as if it were a one-element array.
*/



//There is a simpler way to loop over arrays in modern JavaScript.
for (let entry of journal) {
	console.log(`${entry.events.length} events.`);
}
/*
When a for loop looks like this, with the word "of" after a variable definition,
it will loop over the elements of the value given after of. This works not only
for arrays but also for strings and some other data structures.
-We’ll discuss how it works in Chapter 6.

*/


console.log("coconuts".slice(4, 7)); // → nut
console.log("coconut".indexOf("u")); // → 5
/*
-Every string value has a number
of methods. Some very useful ones are slice and indexOf, which resemble the
array methods of the same name.
-One difference is that a string’s indexOf can search for a string containing
more than one character, whereas the corresponding array method looks only
for a single element.
*/

console.log(" okay \n ".trim()); // okay
/*
-The trim method removes whitespace (spaces, newlines, tabs, and similar
characters) from the start and end of a string.
*/

console.log(String(6).padStart(3, "0")); // 006
/*
you can use padStart() to pad some character to a string, it takes the desired length and padding character as arguments.
*/


let sentence = "Secretarybirds specialize in stomping";
let words = sentence.split(" ");
console.log(words); // ["Secretarybirds", "specialize", "in", "stomping"]
console.log(words.join(". ")); // Secretarybirds. specialize. in. stomping
/*
-You can split a string on every occurrence of another string with split and
join it again with join.
-split makes array from string and join makes string from array
*/


console.log("LA".repeat(3)); // LALALA
/*
A string can be repeated with the repeat method, which creates a new string
containing multiple copies of the original string, glued together.
*/


let string = "abc";
console.log(string.length); // 3
console.log(string[1]); // b
/*
We have already seen the string type’s length property. Accessing the individual
characters in a string looks like accessing array elements (with a caveat
that we’ll discuss in Chapter 5).
*/





function max(...numbers) {
	let result = -Infinity;
	for (let number of numbers) {
		if (number > result) result = number;
	}
	return result;
}
console.log(max(4, 1, 9, -2)); // 9
/*
==>Rest parameters
It can be useful for a function to accept any number of arguments. For example,
Math.max computes the maximum of all the arguments it is given.
To write such a function, you put three dots before the function’s last parameter,
like this:
-When such a function is called, the rest parameter is bound to an array
containing all further arguments. If there are other parameters before it, their
values aren’t part of that array. When, as in max, it is the only parameter, it
will hold all arguments.
*/


let numbers = [5, 1, 7];
console.log(max(...numbers)); // 7
/*
-You can use a similar three-dot notation to call a function with an array of
arguments.
-This “spreads” out the array into the function call, passing its elements as
separate arguments.
*/


console.log(max(9, ...numbers, 2)); // 9
/*
-It is possible to include an array like that along with other
arguments, as in 
*/

let words = ["never", "fully"];
console.log(["will", ...words, "understand"]); // ["will", "never", "fully", "understand"]
/*
-Square bracket array notation similarly allows the triple-dot operator to
spread another array into the new array.
*/

/*
=>The Math object
-Math object contains methods like Math.max, min ,sqrt.
-for trignometric functions it consist Math.cos, sin, tan, acos, asin, atan
-for π (PI) it consist Math.PI constant

*/

console.log(Math.random()); // 0.36993729369714856
/*
Math.random is a function that returns a
new pseudorandom number between zero (inclusive) and one (exclusive) every
time you call it.
*/
const n=2;
const max=Math.pow(10,n);
console.log(Math.floor(Math.random() * max)); // 2
//generates a number from 1 to n digit random number, could also give 0






//continue from pg-73

