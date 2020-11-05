package org.eu5.learn_pisio.notekeeperkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
	
	private var notePosition = POSITION_NOT_SET
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)
		
		val adapterCourses = ArrayAdapter<CourseInfo>( // adapter
			this, android.R.layout.simple_spinner_item, DataManager.courses.values.toList())
		adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		
		coursesSpinner.adapter = adapterCourses // adapter property of Spinner class
		
		// retrieve back note position from extra within intent
		notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)
		
		if (notePosition != POSITION_NOT_SET)
			displayNote()
	}
	
	private fun displayNote() {
		val note = DataManager.notes[notePosition]
		noteTitleEditText.setText(note.title)
		noteTextEditText.setText(note.text)
		
		val coursePosition = DataManager.courses.values.indexOf(note.course)
		coursesSpinner.setSelection(coursePosition)
	}
	
	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return when (item.itemId) {
			R.id.action_settings -> true
			else -> super.onOptionsItemSelected(item)
		}
	}
}
