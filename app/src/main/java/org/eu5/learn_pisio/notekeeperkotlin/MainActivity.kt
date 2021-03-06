package org.eu5.learn_pisio.notekeeperkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
	
	private var notePosition = POSITION_NOT_SET
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)
		
		val coursesAdapter = ArrayAdapter<CourseInfo>( // adapter
			this, android.R.layout.simple_spinner_item, DataManager.courses.values.toList())
		coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		
		coursesSpinner.adapter = coursesAdapter // adapter property of Spinner class
		
		// retrieve back proper note position from savedInstanceState OR from extra within intent!
		notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?:
			intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)
		
		if (notePosition != POSITION_NOT_SET)
			displayNote()
		else {
			DataManager.notes.add(NoteInfo())
			notePosition = DataManager.notes.lastIndex
		}
	}
	
	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putInt(NOTE_POSITION, notePosition)
	}
	
	private fun  displayNote() {
		if (notePosition > DataManager.notes.lastIndex) {
			showMessage("Note not found")
			return
		}
		
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
			R.id.action_next -> { // code in block statement
				if (notePosition < DataManager.notes.lastIndex) {
					moveNext()
				} else {
					val message = "No more notes"
					showMessage(message)
				}
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}
	
	private fun showMessage(message: String) {
		Snackbar.make(noteTitleEditText, message, Snackbar.LENGTH_LONG).show()
	}
	
	private fun moveNext() {
		++notePosition
		displayNote()
		invalidateOptionsMenu()
	}
	
	override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
		if (notePosition >= DataManager.notes.lastIndex) {
			val menuItem = menu?.findItem(R.id.action_next)
			if (menuItem != null) {
				menuItem.icon = getDrawable(R.drawable.ic_block_white_24dp)
				menuItem.isEnabled = false
			}
		}
		return super.onPrepareOptionsMenu(menu)
	}
	
	override fun onPause() {
		super.onPause()
		saveNote()
	}
	
	private fun saveNote() {
		val note = DataManager.notes[notePosition]
		note.title = noteTitleEditText.text.toString()
		note.text = noteTextEditText.text.toString()
		note.course = coursesSpinner.selectedItem as CourseInfo
	}
}
