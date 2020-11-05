package org.eu5.learn_pisio.notekeeperkotlin

object DataManager {
	var courses = HashMap<String, CourseInfo>()
	var notes = ArrayList<NoteInfo>()
	
	// And, that's all the properties our DataManager class needs.
	
	//--- DataManager Initialization code ---//
	
	// We create an initializer block by using the keyword init followed by {}:
	init {
		initializeCourses()
		initializeNotes()
	}
	// By doing that, anytime an instance of our DataManager class is created, the code within
	// the initializer block will automatically run, which means we'll automatically populate
	// our collection of courses and notes.
	
	// So, in Kotlin, type initialization occurs through a combinations of the type's primary
	// constructor, which provides the initialization values, along with the code that runs
	// inside of our initializer blocks.
	
	// function that will create instances of CourseInfo class and place them into the HashMap
	private fun initializeCourses() {
		var course = CourseInfo("android_intents", "Android Programming with Intents")
		courses.set(course.courseId, course)
		
		// using named parameters:
		course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
		courses.set(course.courseId, course)
		
		course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
		courses.set(course.courseId, course)
		
		// using positional parameters
		course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
		courses.set(course.courseId, course)
	}
	
	// function that will create instances of NoteInfo class and place them into the ArrayList
	private fun initializeNotes() {
		//var course = CourseInfo("android_intents", "Android Programming with Intents")
		var course = courses["android_intents"]!!
		var note = NoteInfo(
			course,
			"Dynamic intent resolution",
			"Wow, intents allow components to be resolved at runtime"
		)
		notes.add(note)
		
		//course = CourseInfo("android_intents", "Android Programming with Intents")
		course = courses["android_intents"]!!
		note = NoteInfo(
			course,
			"Delegating intents",
			"PendingIntents are powerful; they delegate much more than just a component invocation"
		)
		notes.add(note)
		
		//course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
		course = courses["android_async"]!!
		note = NoteInfo(
			course,
			"Service default threads",
			"Did you know that by default an Android Service will tie up the UI thread?"
		)
		notes.add(note)
		
		//course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
		course = courses["android_async"]!!
		note = NoteInfo(
			course,
			"Long running operations",
			"Foreground Services can be tied to a notification icon"
		)
		notes.add(note)
		
		//course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
		course = courses["java_lang"]!!
		note = NoteInfo(
			course,
			"Parameters",
			"Leverage variable-length parameter lists"
		)
		notes.add(note)
		
		//course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
		course = courses["java_lang"]!!
		note = NoteInfo(
			course,
			"Anonymous classes",
			"Anonymous classes simplify implementing one-use types"
		)
		notes.add(note)
		
		//course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
		course = courses["java_core"]!!
		note = NoteInfo(
			course,
			"Compiler options",
			"The -jar option isn't compatible with the -cp option"
		)
		notes.add(note)
		
		//course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
		course = courses["java_core"]!!
		note = NoteInfo(
			course,
			"Serialization",
			"Remember to include SerialVersionUID to assure version compatibility"
		)
		notes.add(note)
	}
}