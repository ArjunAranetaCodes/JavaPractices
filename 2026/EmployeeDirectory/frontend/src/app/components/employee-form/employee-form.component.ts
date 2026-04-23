import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {
  @Input() employee!: Employee;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<Employee>();
  @Output() cancel = new EventEmitter<void>();

  form: Employee = {
    firstName: '',
    lastName: '',
    email: '',
    jobTitle: '',
    department: 'Engineering',
    phone: '',
    location: ''
  };

  departments: string[] = ['Engineering', 'HR', 'Finance', 'Sales', 'Marketing', 'Operations', 'Other'];

  ngOnInit(): void {
    if (this.employee) {
      this.form = { ...this.employee };
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
    return !!(
      this.form.firstName?.trim() &&
      this.form.lastName?.trim() &&
      this.form.email?.trim()
    );
  }
}

