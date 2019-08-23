import java.util.*;
import java.io.*;
import java.text.*;
public class MyClass
{
	public static void main(String[] args)
	{
		int i = 12456;
		long l = 1245678910;
		double d = 1245678.916111213;
		char c = '5';
		String str = "123456.78910";
		System.out.printf("% 25.2f%nTheEnd%n", d);
		int width = 3;
		int precision = 5;
		float f = 12.34567f;
		float f2 = 12.00000f;
		System.out.printf("%"+width+"."+precision+"f%n",f);
		DecimalFormat df = new DecimalFormat("#.###"); 
		System.out.printf("Original Format: %.3f Decimal Format: " + df.format(f)+"\n",f); //combined 
		System.out.printf("Original Format: %.3f Decimal Format: " + df.format(f2)+"\n",f2); //combined 
		//to remove trailing zeroes in case like 12.3000 to print 12.3 use DecimalFormat class
		// System.out.printf("%[[<space_or_0_as_padding_char>]<width>[<, as separator>].<precision>]<specifier>",data);
	}
}