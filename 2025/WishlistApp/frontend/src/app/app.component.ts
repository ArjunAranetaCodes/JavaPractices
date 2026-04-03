import { Component, OnInit } from '@angular/core';
import { WishlistItemService } from './services/wishlist-item.service';
import { WishlistItem } from './models/wishlist-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  items: WishlistItem[] = [];
  filteredItems: WishlistItem[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedPriority: string = '';
  categories: string[] = ['Electronics', 'Clothing', 'Books', 'Home', 'Food', 'Sports', 'Beauty', 'Toys', 'Travel', 'Other'];
  showModal: boolean = false;
  editingItem: WishlistItem | null = null;
  newItem: WishlistItem = {
    name: '',
    description: '',
    price: 0,
    priority: 'MEDIUM',
    status: 'WANTED',
    category: ''
  };

  constructor(private wishlistItemService: WishlistItemService) {}

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.wishlistItemService.getAllItems().subscribe(
      (items) => {
        this.items = items;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading items:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.items];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.wishlistItemService.searchItems(this.searchTerm).subscribe(
        (searchedItems) => {
          filtered = searchedItems;
          this.applyStatusCategoryAndPriorityFilters(filtered);
        },
        (error) => {
          console.error('Error searching items:', error);
        }
      );
    } else {
      this.applyStatusCategoryAndPriorityFilters(filtered);
    }
  }

  applyStatusCategoryAndPriorityFilters(items: WishlistItem[]) {
    let filtered = [...items];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(item => item.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(item => item.category === this.selectedCategory);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(item => item.priority === this.selectedPriority);
    }

    this.filteredItems = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onPriorityChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedCategory = '';
    this.selectedPriority = '';
    this.applyFilters();
  }

  openModal(item?: WishlistItem) {
    if (item) {
      this.editingItem = { ...item };
      this.newItem = { ...item };
    } else {
      this.editingItem = null;
      this.newItem = {
        name: '',
        description: '',
        price: 0,
        priority: 'MEDIUM',
        status: 'WANTED',
        category: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingItem = null;
  }

  saveItem() {
    if (this.editingItem) {
      this.updateItem();
    } else {
      this.createItem();
    }
  }

  createItem() {
    this.wishlistItemService.createItem(this.newItem).subscribe(
      (item) => {
        this.items.push(item);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating item:', error);
      }
    );
  }

  updateItem() {
    if (this.editingItem && this.editingItem.id) {
      this.wishlistItemService.updateItem(this.editingItem.id, this.newItem).subscribe(
        (item) => {
          const index = this.items.findIndex(i => i.id === item.id);
          if (index !== -1) {
            this.items[index] = item;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating item:', error);
        }
      );
    }
  }

  markAsPurchased(item: WishlistItem) {
    if (item.id) {
      this.wishlistItemService.markAsPurchased(item.id).subscribe(
        (updatedItem) => {
          const index = this.items.findIndex(i => i.id === updatedItem.id);
          if (index !== -1) {
            this.items[index] = updatedItem;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error marking item as purchased:', error);
        }
      );
    }
  }

  deleteItem(id: number) {
    if (confirm('Are you sure you want to delete this item?')) {
      this.wishlistItemService.deleteItem(id).subscribe(
        () => {
          this.items = this.items.filter(i => i.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting item:', error);
        }
      );
    }
  }

  getWantedCount(): number {
    return this.items.filter(item => item.status === 'WANTED').length;
  }

  getPurchasedCount(): number {
    return this.items.filter(item => item.status === 'PURCHASED').length;
  }

  getTotalValue(): number {
    const wantedItems = this.items.filter(item => item.status === 'WANTED' && item.price);
    return wantedItems.reduce((sum, item) => sum + (item.price || 0), 0);
  }

  formatPrice(price: number | undefined): string {
    if (!price || price === 0) return 'Price not set';
    return `$${price.toFixed(2)}`;
  }
}

