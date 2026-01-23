import { Component, OnInit } from '@angular/core';
import { CustomerService } from './services/customer.service';
import { Customer } from './models/customer';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  customers: Customer[] = [];
  filteredCustomers: Customer[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedIndustry: string = '';
  
  statuses = ['LEAD', 'ACTIVE', 'INACTIVE', 'CLOSED'];
  industries = ['TECHNOLOGY', 'HEALTHCARE', 'FINANCE', 'RETAIL', 'EDUCATION', 'MANUFACTURING', 'CONSULTING', 'OTHER'];
  
  showModal: boolean = false;
  editingCustomer: Customer | null = null;
  newCustomer: Customer = {
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    company: '',
    industry: 'TECHNOLOGY',
    status: 'LEAD',
    address: '',
    city: '',
    state: '',
    zipCode: '',
    country: '',
    notes: ''
  };

  constructor(private customerService: CustomerService) {}

  ngOnInit() {
    this.loadCustomers();
  }

  loadCustomers() {
    this.customerService.getAllCustomers().subscribe(
      (customers) => {
        this.customers = customers;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading customers:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.customers];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.customerService.searchCustomers(this.searchTerm).subscribe(
        (searchedCustomers) => {
          filtered = searchedCustomers;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching customers:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(customers: Customer[]) {
    let filtered = [...customers];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(customer => customer.status === this.selectedStatus);
    }

    // Apply industry filter
    if (this.selectedIndustry && this.selectedIndustry !== '') {
      filtered = filtered.filter(customer => customer.industry === this.selectedIndustry);
    }

    // Sort by status priority (ACTIVE first, then LEAD, then INACTIVE, then CLOSED), then by name
    filtered.sort((a, b) => {
      const statusOrder: { [key: string]: number } = {
        'ACTIVE': 1,
        'LEAD': 2,
        'INACTIVE': 3,
        'CLOSED': 4
      };
      const aStatus = a.status || 'LEAD';
      const bStatus = b.status || 'LEAD';
      const statusDiff = (statusOrder[aStatus] || 5) - (statusOrder[bStatus] || 5);
      if (statusDiff !== 0) return statusDiff;
      
      const aName = `${a.firstName} ${a.lastName}`;
      const bName = `${b.firstName} ${b.lastName}`;
      return aName.localeCompare(bName);
    });

    this.filteredCustomers = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onIndustryChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedIndustry = '';
    this.applyFilters();
  }

  openModal(customer?: Customer) {
    if (customer) {
      this.editingCustomer = { ...customer };
      this.newCustomer = { ...customer };
    } else {
      this.editingCustomer = null;
      this.newCustomer = {
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
        company: '',
        industry: 'TECHNOLOGY',
        status: 'LEAD',
        address: '',
        city: '',
        state: '',
        zipCode: '',
        country: '',
        notes: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingCustomer = null;
  }

  saveCustomer() {
    if (this.editingCustomer) {
      this.updateCustomer();
    } else {
      this.createCustomer();
    }
  }

  createCustomer() {
    this.customerService.createCustomer(this.newCustomer).subscribe(
      (customer) => {
        this.customers.push(customer);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating customer:', error);
      }
    );
  }

  updateCustomer() {
    if (this.editingCustomer && this.editingCustomer.id) {
      this.customerService.updateCustomer(this.editingCustomer.id, this.newCustomer).subscribe(
        (customer) => {
          const index = this.customers.findIndex(c => c.id === customer.id);
          if (index !== -1) {
            this.customers[index] = customer;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating customer:', error);
        }
      );
    }
  }

  deleteCustomer(id: number) {
    if (confirm('Are you sure you want to delete this customer?')) {
      this.customerService.deleteCustomer(id).subscribe(
        () => {
          this.customers = this.customers.filter(c => c.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting customer:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.customers.length;
  }

  getActiveCount(): number {
    return this.customers.filter(c => c.status === 'ACTIVE').length;
  }

  getLeadCount(): number {
    return this.customers.filter(c => c.status === 'LEAD').length;
  }

  getStatusCount(status: string): number {
    return this.customers.filter(c => c.status === status).length;
  }

  getIndustryCount(industry: string): number {
    return this.customers.filter(c => c.industry === industry).length;
  }

  getFullName(customer: Customer): string {
    return `${customer.firstName} ${customer.lastName}`;
  }

  getFullAddress(customer: Customer): string {
    const parts: string[] = [];
    if (customer.address) parts.push(customer.address);
    if (customer.city) parts.push(customer.city);
    if (customer.state) parts.push(customer.state);
    if (customer.zipCode) parts.push(customer.zipCode);
    if (customer.country) parts.push(customer.country);
    return parts.join(', ');
  }

  getStatusClass(status: string | undefined): string {
    if (!status) return 'status-lead';
    return `status-${status.toLowerCase()}`;
  }

  getCardClass(customer: Customer): string {
    const status = customer.status || 'LEAD';
    return `status-${status.toLowerCase()}`;
  }
}
