import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { EventItem } from '../../models/event.model';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent implements OnInit {
  @Input() event!: EventItem;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<EventItem>();
  @Output() cancel = new EventEmitter<void>();

  form: EventItem = {
    title: '',
    description: '',
    location: '',
    startDateTime: '',
    endDateTime: '',
    category: 'Work',
    status: 'PLANNED'
  };

  statuses = ['PLANNED', 'COMPLETED', 'CANCELLED'];
  categories = ['Work', 'Personal', 'Birthday', 'Other'];

  ngOnInit(): void {
    if (this.event) {
      this.form = { ...this.event };
    }
  }

  onSubmit(): void {
    if (this.isValid()) {
      const payload: EventItem = {
        ...this.form,
        startDateTime: this.normalizeDateTime(this.form.startDateTime),
        endDateTime: this.normalizeDateTime(this.form.endDateTime)
      };
      this.save.emit(payload);
    }
  }

  private normalizeDateTime(v: string): string {
    if (!v) return v;
    if (v.length === 16) {
      return v + ':00';
    }
    return v;
  }

  onCancel(): void {
    this.cancel.emit();
  }

  isValid(): boolean {
    return !!(this.form.title?.trim() && this.form.startDateTime && this.form.endDateTime);
  }
}
