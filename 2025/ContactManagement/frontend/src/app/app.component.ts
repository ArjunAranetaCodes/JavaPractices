import { Component, OnInit } from '@angular/core';
import { ContactService } from './services/contact.service';
import { Contact } from './models/contact';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  contacts: Contact[] = [];
  filteredContacts: Contact[] = [];
  searchTerm: string = '';
  showModal: boolean = false;
  editingContact: Contact | null = null;
  newContact: Contact = {
    name: '',
    email: '',
    phone: '',
    address: ''
  };

  constructor(private contactService: ContactService) {}

  ngOnInit() {
    this.loadContacts();
  }

  loadContacts() {
    this.contactService.getAllContacts().subscribe(
      (contacts) => {
        this.contacts = contacts;
        this.applySearch();
      },
      (error) => {
        console.error('Error loading contacts:', error);
      }
    );
  }

  applySearch() {
    if (this.searchTerm.trim() === '') {
      this.filteredContacts = [...this.contacts];
    } else {
      this.contactService.searchContacts(this.searchTerm).subscribe(
        (contacts) => {
          this.filteredContacts = contacts;
        },
        (error) => {
          console.error('Error searching contacts:', error);
        }
      );
    }
  }

  openModal(contact?: Contact) {
    if (contact) {
      this.editingContact = { ...contact };
      this.newContact = { ...contact };
    } else {
      this.editingContact = null;
      this.newContact = {
        name: '',
        email: '',
        phone: '',
        address: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingContact = null;
  }

  saveContact() {
    if (this.editingContact) {
      this.updateContact();
    } else {
      this.createContact();
    }
  }

  createContact() {
    this.contactService.createContact(this.newContact).subscribe(
      (contact) => {
        this.contacts.push(contact);
        this.applySearch();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating contact:', error);
      }
    );
  }

  updateContact() {
    if (this.editingContact && this.editingContact.id) {
      this.contactService.updateContact(this.editingContact.id, this.newContact).subscribe(
        (contact) => {
          const index = this.contacts.findIndex(c => c.id === contact.id);
          if (index !== -1) {
            this.contacts[index] = contact;
          }
          this.applySearch();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating contact:', error);
        }
      );
    }
  }

  deleteContact(id: number) {
    if (confirm('Are you sure you want to delete this contact?')) {
      this.contactService.deleteContact(id).subscribe(
        () => {
          this.contacts = this.contacts.filter(c => c.id !== id);
          this.applySearch();
        },
        (error) => {
          console.error('Error deleting contact:', error);
        }
      );
    }
  }
}


