import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { JournalEntry } from '../../models/journal-entry.model';

@Component({
  selector: 'app-journal-form',
  templateUrl: './journal-form.component.html',
  styleUrls: ['./journal-form.component.css']
})
export class JournalFormComponent implements OnInit {
  @Input() entry!: JournalEntry;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<JournalEntry>();
  @Output() cancel = new EventEmitter<void>();

  form: JournalEntry = {
    title: '',
    content: '',
    entryDate: new Date().toISOString().slice(0, 10),
    mood: 'NEUTRAL'
  };

  moods = ['HAPPY', 'NEUTRAL', 'SAD'];

  ngOnInit(): void {
    if (this.entry) {
      this.form = { ...this.entry };
    }
  }

  onSubmit(): void {
    if (this.isValid()) {
      this.save.emit(this.form);
    }
  }

  onCancel(): void {
    this.cancel.emit();
  }

  isValid(): boolean {
    return !!(this.form.title?.trim() && this.form.entryDate);
  }
}
