import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Bookmark } from '../../models/bookmark.model';

@Component({
  selector: 'app-bookmark-form',
  templateUrl: './bookmark-form.component.html',
  styleUrls: ['./bookmark-form.component.css']
})
export class BookmarkFormComponent implements OnInit {
  @Input() bookmark!: Bookmark;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<Bookmark>();
  @Output() cancel = new EventEmitter<void>();

  form: Bookmark = {
    title: '',
    url: '',
    category: 'Work',
    notes: ''
  };

  categories = ['Work', 'Learning', 'Tools', 'Social', 'News', 'Other'];

  ngOnInit(): void {
    if (this.bookmark) {
      this.form = { ...this.bookmark };
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
    return !!(this.form.title?.trim() && this.form.url?.trim());
  }
}
