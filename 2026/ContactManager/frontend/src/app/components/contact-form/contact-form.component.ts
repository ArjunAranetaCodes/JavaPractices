import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Contact } from '../../models/contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {
  @Input() contact!: Contact;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<Contact>();
  @Output() cancel = new EventEmitter<void>();

  form: Contact = {
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    company: '',
    jobTitle: '',
    notes: '',
    favorite: false
  };

  ngOnInit(): void {
    if (this.contact) {
      this.form = { ...this.contact };
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
    return !!(this.form.firstName?.trim() && this.form.lastName?.trim() && this.form.email?.trim());
  }
}

