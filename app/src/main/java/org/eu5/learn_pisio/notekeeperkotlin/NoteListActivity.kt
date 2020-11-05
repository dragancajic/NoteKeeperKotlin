package org.eu5.learn_pisio.notekeeperkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_note_list)
		setSupportActionBar(toolbar)
		
		fab.setOnClickListener { view ->
			val activityIntent = Intent(this, MainActivity::class.java)
			startActivity(activityIntent)
		}
		
		listOfNotesListView.adapter = ArrayAdapter<NoteInfo>( // ArrayAdapter
			this, android.R.layout.simple_list_item_1, DataManager.notes)
		
		listOfNotesListView.setOnItemClickListener{parent, view, position, id ->
			// creating the intent
			val activityIntent = Intent(this, MainActivity::class.java)
			
			// information about the note
			activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
			
			// start another activity
			startActivity(activityIntent)
		}
	}
	
}
