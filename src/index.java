/*
 * Garbage means unreferenced objects
 * Garbage Collection is a process of reclaiming the runtime unused memory automatically or we can say that, it is a way to
 * destroy unused objects. 
 * To do so, we were using free() function in C language and delete() in C++. 
 * But, in java it is performed automatically. So, java provides better memory management.
 */

/*
 * Here, in this code we are creating an object.Then we will set it to null, such that it becomes eligible for 
 * garbage collection, assuming that there are no references to the same object stored anywhere. 
 * And as per the definition of garbage collection, the object will get destroyed by the garbage collector, 
 * but still we will be using the same object in our code again. 
 */

class A {
	int x;
	static A e = null;

	A() {
		x = 100;
	}

	// finalize() method is called just before the garbage collection is performed
	@Override
	protected void finalize() {
		System.out.println("Garbage Collector to be called");
		e = this;
	}
}

public class index {

	public static void main(String[] args) {
		// creating object of class A
		A obj = new A();
		System.out.println(obj.x);
		// dereferencing the object 
		obj = null;
		// calling the garbage collector
		System.gc();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		// object is assigned the value stored in static object e of class A
		obj = A.e;
		System.out.println(obj.x);
	}

}
