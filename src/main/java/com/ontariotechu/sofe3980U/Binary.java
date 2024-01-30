package com.ontariotechu.sofe3980U;
/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add

				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;	
	}
			/**
	* Performing OR operation bitwise from two binary numbers
	* @param num1 The first or object
	* @param num2 The second or object
	* @return A binary variable with a value of <i>num1 OR num2</i>.
	*/
	public static Binary OR(Binary num1,Binary num2) {
		int length1 = num1.number.length();
		int length2 = num2.number.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < Math.max(length1, length2); i++) {
			char ind1, ind2, orResult;

			if (i < length1) 
    			ind1 = num1.number.charAt(length1 - 1 - i);
			else 
    			ind1 = '0';

			if (i < length2) 
    			ind2 = num2.number.charAt(length2 - 1 - i);
			else 
    			ind2 ='0';
			
			if (ind1 == '1' || ind2 == '1') 
    			orResult = '1';
 			else 
    			orResult = '0';

			result.insert(0, orResult);
		}

		return new Binary(result.toString());
	}
		/**
	* Performing AND operation bitwise from two binary numbers
	* @param num1 The first and object
	* @param num2 The second and object
	* @return A binary variable with a value of <i>num1 AND num2</i>.
	*/
	public static Binary AND(Binary num1, Binary num2) {
		int length1 = num1.number.length();
		int length2 = num2.number.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < Math.max(length1, length2); i++) {
			char ind1, ind2, andResult;

			if (i < length1) 
    			ind1 = num1.number.charAt(length1 - 1 - i);
			else 
    			ind1 = '0';

			if (i < length2) 
    			ind2 = num2.number.charAt(length2 - 1 - i);
			else 
    		ind2 ='0';

			if (ind1 == '1' && ind2 == '1') 
    			andResult = '1';
 			else 
    			andResult = '0';
				
			result.insert(0, andResult);
		}
		return new Binary(result.toString());
	}
			/**
	* Performing multiplication operation from two binary numbers
	* @param num1 The first and object
	* @param num2 The second and object
	* @return A binary variable with a value of <i>num1 * num2</i>.
	*/
	public static Binary Multiply(Binary num1, Binary num2) {
		Binary result = new Binary("0");

		for (int i = 0; i < num2.number.length(); i++) {
			char currentIndex = num2.number.charAt(num2.number.length() - 1 - i);
			if (currentIndex == '1') {

				Binary partialProduct = new Binary(num1.number);

				for (int j = 0; j < i; j++) {
					partialProduct = Binary.add(partialProduct, partialProduct);
				}
				result = Binary.add(result, partialProduct);
			}
		}
		return result;
	}
}