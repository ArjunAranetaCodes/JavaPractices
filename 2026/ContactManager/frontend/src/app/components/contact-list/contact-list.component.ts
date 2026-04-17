import { Component, OnInit } from '@angular/core';
import { Contact } from '../../models/contact.model';
import { ContactService } from '../../services/contact.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {
  contacts: Contact[] = [];
  filtered: Contact[] = [];
  searchTerm = '';
  companyFilter = '';
  showFavoritesOnly = false;

  showModal = false;
  isEditMode = false;
  editingContact: Contact | null = null;

  constructor(private service: ContactService) {}

  ngOnInit(): void {
    this.loadContacts();
  }

  loadContacts(): void {
    this.service.getAll().subscribe({
      next: data => {
        this.contacts = data;
        this.applyFilters();
      },
      error: err => console.error('Error loading contacts', err)
    });
  }

  applyFilters(): void {
    let result = [...this.contacts];

    if (this.searchTerm.trim()) {
      const term = this.searchTerm.toLowerCase();
      result = result.filter(c =>
        `${c.firstName} ${c.lastName}`.toLowerCase().includes(term) ||
        (c.email || '').toLowerCase().includes(term)
      );
    }

    if (this.companyFilter.trim()) {
      const term = this.companyFilter.toLowerCase();
      result = result.filter(c =>
        (c.company || '').toLowerCase().includes(term)
      );
    }

    if (this.showFavoritesOnly) {
      result = result.filter(c => !!c.favorite);
    }

    this.filtered = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onCompanyChange(): void {
    this.applyFilters();
  }

  onFavoritesToggle(): void {
    this.applyFilters();
  }

  openAddModal(): void {
    this.isEditMode = false;
    this.editingContact = {
      firstName: '',
      lastName: '',
      email: '',
      phone: '',
      company: '',
      jobTitle: '',
      notes: '',
      favorite: false
    };
    this.showModal = true;
  }

  openEditModal(contact: Contact): void {
    this.isEditMode = true;
    this.editingContact = { ...contact };
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingContact = null;
    this.isEditMode = false;
  }

  saveContact(contact: Contact): void {
    if (this.isEditMode && contact.id) {
      this.service.update(contact.id, contact).subscribe({
        next: () => {
          this.loadContacts();
          this.closeModal();
        },
        error: err => console.error('Error updating contact', err)
      });
    } else {
      this.service.create(contact).subscribe({
        next: () => {
          this.loadContacts();
          this.closeModal();
        },
        error: err => console.error('Error creating contact', err)
      });
    }
  }

  deleteContact(id: number): void {
    if (!confirm('Delete this contact?')) {
      return;
    }
    this.service.delete(id).subscribe({
      next: () => this.loadContacts(),
      error: err => console.error('Error deleting contact', err)
    });
  }
}

