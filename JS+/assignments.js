// ASSIGNMENTS

//fizzbuzz pg-38
for (let i=1; i<101; i++)
{
	if(i%3===0 && i%5===0)
		console.log("FizzBuzz "+i);
	if(i%5===0 && i%3!==0)
		console.log("Buzz "+i);
	else if(i%3===0)
		console.log("Fizz "+i);
}

//chessboard pg-38
n=Number(prompt("Enter a number"));
for (let i=1; i<=n; i++)
{
	let str="";
	if(i%2==0)
		for (let j=1; j<=n; j++)
			if(j%2==0)
				str+=" ";
			else
				str+="#";
	else
		for (let j=1; j<=n; j++)
			if(j%2==0)
				str+="#";
			else
				str+=" ";
	console.log(str);
}

//recursion isEven
function isEven(n)
{
	if(n>1)
		return isEven(n-2);
	else
		if(n==1)
			return "Odd";
		else if(n==0)
			return "Even";
		else
			return isEven(n+2)
}

//countBs, countChar
function countChar(str,char)
{
	count=0;
	for(let i=0;i<str.length;i++)
		if(str[i]===char)
			count++;
	return count;
}