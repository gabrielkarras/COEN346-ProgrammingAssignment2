/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/07/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst
 *
 * $Date: 14 Oct 2020
 * @author Gabriel Karras - 40036341
 * @author Alexia Capitina - 40024870
 */
class BlockStack
{
	/**
	 * Stack access counter (records every access into the stack such as pop or push)
	 */
	private int sAccessCounter = 0;

	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char[] acStack = new char[] {'a', 'b', 'c', 'd', '*', '*'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


		if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++) {
				this.acStack[i] = (char) ('a' + i);
			}

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() throws Exception
	{
		if(!isEmpty()) {
			incrementAccessCounter();
			//System.out.println("\nSuccessfully accessed stack via pick().");
			return this.acStack[this.iTop];
		}
		else{
			throw new Exception("Empty Stack");
		}
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws Exception
	{
		if(!isEmpty()) {
			incrementAccessCounter();
			//System.out.println("\nSuccessfully accessed stack via getAt().");
			return this.acStack[piPosition];
		}
		else{
			throw new Exception("Empty Stack");
		}
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws Exception
	{
		if(isEmpty()){
			incrementAccessCounter();
			this.acStack[++this.iTop] = 'a';
		}
		else if(isFull()){
			throw new Exception("Full Stack");
		}
		else{
			incrementAccessCounter();
			this.acStack[++this.iTop] = pcBlock;
		}
		//System.out.println("\nSuccessfully accessed stack via push().");
	}

	/**
	 * Standard pop operation
	 * @return  char: ex-top element of the stack
	 */
	public char pop() throws Exception
	{
		if(!isEmpty()) {
			incrementAccessCounter();
			char cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
			//System.out.println("\nSuccessfully accessed stack via pop()");
			return cBlock;
		}
		else{
			throw new Exception("Empty Stack");
		}
	}

	/**
	 * Verifies if stack is empty
	 * @return boolean: True(1) if empty, otherwise False(0)
	 */
	public boolean isEmpty()
	{
		return ( this.iTop == -1 );
	}

	/**
	 * Verifies if stack is full (fixed-capacity stack)
	 * @return boolean: True(1) if full, otherwise False(0)
	 */
	public boolean isFull()
	{
		return this.iTop == iSize - 1;
	}

	/**
	 * Retrieves stack access counter
	 * @return int sAccessCounter
	 */
	public int getAccessCounter()
	{
		return this.sAccessCounter;
	}

	/**
	 * Increments sAccessCounter by for every stack access operation(i.e.:pop,push,getAt)
	 */
	public void incrementAccessCounter()
	{
		this.sAccessCounter++;
	}

	/**
	 * Retrieves iTop
	 * @return int: iTop
	 */
	public int getITop()
	{
		return this.iTop;
	}

	/**
	 * Retrieves iSize
	 * @return int: iSize
	 */
	public int getISize()
	{
		return this.iSize;
	}

	/**
	 * Retrieves element from acStack at designated index
	 * @param index of element in acStack
	 * @return char: element from acStack
	 */
	public char getACStack(int index)
	{
		return this.acStack[index];
	}

	/**
	 * Retrieves acStack
	 * @return char[]: acStack
	 */
	public char[] getFullACStack()
	{
		return this.acStack;
	}
}

// EOF
