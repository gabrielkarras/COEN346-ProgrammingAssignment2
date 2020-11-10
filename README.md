
**OS Programming - Mutex, Semaphores and Synchronization**

## **Objectives**

The objective of this assignment is to allow you to learn how to implement critical sections and barrier synchronization of concurrent threads using semaphores.

## **Tasks**

**Task 1**: Writing Some Java Code, Part I
Declare an integer “stack access counter” variable in the BlockStack class. Have it incremented by 1 every time the stack is accessed (i.e. via push(), pop(), pick(), or getAt() methods). Print indication messages for successful push and pop operations. Print ‘*’ instead of ‘$’ for each empty position in the stack (modify given code).
When the main thread terminates, print out the counter's value. Submit the modified code and the output.

**Task 2**: Writing Some More Java Code, Part II
The BlockStack class has somewhat bogus implementation, no checking for
boundaries, etc... Most of the class is also not quite correctly coded from the good
object-oriented practices point of view like data hiding, encapsulation, etc.

 1. Make the iSize, iTop, acStack, and possibly your stack access counter private and create methods to retrieve their values. Do appropriate changes in the main code. 
 2. Modify the push() operation of the BlockStack class to handle the case when the stack is empty (last element was popped). Calling push() on empty stack should place an ‘a’ on top.
 3. Implement boundaries, empty/full stack checks and alike using the Java's exception handling mechanism. Declare your own exception, or a set of exceptions. Make appropriate changes in the main code to catch those exceptions. Print “Empty Stack !!!” message in case of empty stack and “Full Stack !!!” message in case of full stack. **NOTE**: If do you catch ArrayIndexOutOfBoundsException it’s a good
thing, but it's not your own exception :-)

**Task 3**: Atomicity Bugs Hunt with Mutex
Compile and run the Java app given to you as is, and look at the output. After possibly getting scared of what you have seen, you will have to correct things. Yet, before you do so, make execution of the critical sections atomic. Use the mutex semaphore for that purpose.

**Task 4**: The Right Order, Take I
In this task you have to ensure that the PHASE I of every thread is completed before PHASE II of any thread has a chance to commence. Each time a thread is finished print a message that thread-i has finished PHASE I. Finally, print a message indicates that all the threads finished PHASE I. You still need to do so using semaphore operations. Submit the output and a context diff to the original sources.

**Task 5**: The Right Order, Take II
The second synchronization requirement on top of the one of “Take I” is that all 10 threads must start their PHASE II in order of their TID, i.e. 1, 2, 3, 4 ... The
second semaphore, s2, and turnTestAndSet() method are provided to you to help with this. Each time a thread attempts to start but fails because of incorrect order, please print a message that thread-i has attempted but waiting for its turn to finish PHASE II. Finally, print a message indicates that all the threads finished PHASE II. Submit the output the modified source code.

