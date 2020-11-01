package org.eu5.learn_pisio.notekeeperkotlin

/**
 * Class to represent course info
 */
// From the standpoint of our app, a course's courseId and title cannot be changed, so
// both of these properties should be assign-once propertied.
class CourseInfo(val courseId: String, val title: String) {
	override fun toString(): String {
		return title
	}
}

// And, that gives us our complete CourseInfo class!
// Also, since our class declaration doesn't need a body, we don't have to include
// open and closing brackets. Our entire class is declared on a single line!

/**
 * Class to represent a note
 */
// The first characteristic of a note is the course that's associated with that note.
// We want the note's course to be available to be changed in a note, so it will be:
// course is mutable property!
class NoteInfo(var course: CourseInfo, var title: String, var text: String)

/**
 * Class that will serve as the central point of management for instances of classes
 * CourseInfo and NoteInfo, is going to be DataManager class.
 */
