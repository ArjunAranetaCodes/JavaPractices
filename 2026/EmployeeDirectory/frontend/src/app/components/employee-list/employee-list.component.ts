import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee.model';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  filtered: Employee[] = [];
  searchTerm = '';
  selectedDepartment = 'all';
  departments: string[] = ['all', 'Engineering', 'HR', 'Finance', 'Sales', 'Marketing', 'Operations', 'Other'];

  showModal = false;
  isEditMode = false;
  editingEmployee: Employee | null = null;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAll().subscribe({
      next: (data) => {
        this.employees = data;
        this.applyFilters();
      },
      error: (err) => console.error('Error loading employees', err)
    });
  }

  applyFilters(): void {
    let result = [...this.employees];

    if (this.selectedDepartment !== 'all') {
      result = result.filter(e => (e.department || '').toLowerCase() === this.selectedDepartment.toLowerCase());
    }

    if (this.searchTerm.trim()) {
      const term = this.searchTerm.toLowerCase();
      result = result.filter(e =>
        `${e.firstName} ${e.lastName}`.toLowerCase().includes(term) ||
        (e.email || '').toLowerCase().includes(term)
      );
    }

    this.filtered = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onDepartmentChange(): void {
    this.applyFilters();
  }

  openAddModal(): void {
    this.isEditMode = false;
    this.editingEmployee = {
      firstName: '',
      lastName: '',
      email: '',
      jobTitle: '',
      department: 'Engineering',
      phone: '',
      location: ''
    };
    this.showModal = true;
  }

  openEditModal(employee: Employee): void {
    this.isEditMode = true;
    this.editingEmployee = { ...employee };
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingEmployee = null;
    this.isEditMode = false;
  }

  saveEmployee(employee: Employee): void {
    if (this.isEditMode && employee.id) {
      this.employeeService.update(employee.id, employee).subscribe({
        next: () => {
          this.loadEmployees();
          this.closeModal();
        },
        error: (err) => console.error('Error updating employee', err)
      });
    } else {
      this.employeeService.create(employee).subscribe({
        next: () => {
          this.loadEmployees();
          this.closeModal();
        },
        error: (err) => console.error('Error creating employee', err)
      });
    }
  }

  deleteEmployee(id: number): void {
    if (!confirm('Are you sure you want to delete this employee?')) {
      return;
    }
    this.employeeService.delete(id).subscribe({
      next: () => this.loadEmployees(),
      error: (err) => console.error('Error deleting employee', err)
    });
  }
}

