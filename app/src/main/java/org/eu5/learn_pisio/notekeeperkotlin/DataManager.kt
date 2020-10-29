package org.eu5.learn_pisio.notekeeperkotlin

class DataManager {
	// Our DataManager class won't need a primary constructor, but it will need some properties.
	// It'll need a property to hold a collection of courses, and it'll need a property to hold
	// a collection of notes.
	var courses = HashMap<String, CourseInfo>()
	// So, now with that in place, it takes care of constructing a new instance of our HashMap,
	// the HashMap maps String values to instances of our CourseInfo class, and a reference of
	// that HashMap is assigned to our courses property.
	var notes = ArrayList<NoteInfo>()
	// So, that takes care of constructing a new instance of ArrayList that can hold NoteInfo
	// references, and we assign the ArrayList reference to our notes property.
	
	// And, that's all the properties our DataManager class needs.
	
	//--- DataManager Initialization code ---//
	
	// We create an initializer block by using the keyword init followed by {}:
	init {
		initializeCourses()
	}
	// By doing that, anytime an instance of our DataManager class is created, the code within
	// the initializer block will automatically run, which means we'll automatically populate
	// our collection of courses.
	// Now, one thing to note:
	// initializer blocks accept no parameters, because there's no way to call them explicitly.
	// They're run automatically as part of instance creation, but initializer blocks can access
	// the parameters of our primary constructor, as well as parameters within the class.
	
	// So, in Kotlin, type initialization occurs through a combinations of the type's primary
	// constructor, which provides the initialization values, along with the code that runs
	// inside of our initializer blocks.
	
	// function that will create instances of CourseInfo class and place them into the HashMap
	private fun initializeCourses() {
		var course = CourseInfo("android_intents", "Android Programming with Intents")
		courses.set(course.courseId, course)
		// The first parameter of the HashMap's set() method is the value we'll use to look up
		// the course, and that'll be the course's courseId, so we'll pass in the courseId property
		// of our course. And, the second parameter of the set() method will be the course itself.
		
		// Now, we can of course explicitly identify which parameter we want to associate with
		// a value by using named parameters:
		course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
		courses.set(course.courseId, course)
		
		// Now, you recall that when using named parameters, the order we list the parameters
		// doesn't matter, so let's create a new CourseInfo instance and assign it to our course
		// variable:
		course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
		courses.set(course.courseId, course)
		
		// one more course using positional parameters
		course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
		courses.set(course.courseId, course)
		
		// So, that gives us a function that will initialize our courses collection with 4 courses.
		// So, now we need to add the code to have that function run whenever an instance of our
		// DataManager class is created, and we can do that within an initializer block.
	}
	// Kotlin, like other object-oriented languages, includes the concept of member visibility.
	// By default, members are public, meaning they can be used from pretty much anywhere.
	// But, now in the case of our initializeCourses() method, we don't really want anyone outside
	// of our DataManager class calling it, so we'll mark initializeCourses() as private.
}