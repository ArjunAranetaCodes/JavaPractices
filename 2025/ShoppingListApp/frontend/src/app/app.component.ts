import { Component, OnInit } from '@angular/core';
import { ShoppingItemService } from './services/shopping-item.service';
import { ShoppingItem } from './models/shopping-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  items: ShoppingItem[] = [];
  filteredItems: ShoppingItem[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedPriority: string = '';
  categories: string[] = ['Produce', 'Dairy', 'Meat', 'Bakery', 'Beverages', 'Snacks', 'Frozen', 'Household', 'Other'];
  units: string[] = ['pcs', 'kg', 'lb', 'g', 'oz', 'l', 'ml', 'cup', 'tbsp', 'tsp', 'box', 'pack'];
  showModal: boolean = false;
  editingItem: ShoppingItem | null = null;
  newItem: ShoppingItem = {
    name: '',
    quantity: 1,
    unit: 'pcs',
    priority: 'MEDIUM',
    completed: false,
    category: ''
  };

  constructor(private shoppingItemService: ShoppingItemService) {}

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.shoppingItemService.getAllItems().subscribe(
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
      this.shoppingItemService.searchItems(this.searchTerm).subscribe(
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

  applyStatusCategoryAndPriorityFilters(items: ShoppingItem[]) {
    let filtered = [...items];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      const completed = this.selectedStatus === 'completed';
      filtered = filtered.filter(item => item.completed === completed);
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

  openModal(item?: ShoppingItem) {
    if (item) {
      this.editingItem = { ...item };
      this.newItem = { ...item };
    } else {
      this.editingItem = null;
      this.newItem = {
        name: '',
        quantity: 1,
        unit: 'pcs',
        priority: 'MEDIUM',
        completed: false,
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
    this.shoppingItemService.createItem(this.newItem).subscribe(
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
      this.shoppingItemService.updateItem(this.editingItem.id, this.newItem).subscribe(
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

  toggleItem(item: ShoppingItem) {
    if (item.id) {
      this.shoppingItemService.toggleCompleted(item.id).subscribe(
        (updatedItem) => {
          const index = this.items.findIndex(i => i.id === updatedItem.id);
          if (index !== -1) {
            this.items[index] = updatedItem;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error toggling item:', error);
        }
      );
    }
  }

  deleteItem(id: number) {
    if (confirm('Are you sure you want to delete this item?')) {
      this.shoppingItemService.deleteItem(id).subscribe(
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

  getTotalCount(): number {
    return this.items.length;
  }

  getCompletedCount(): number {
    return this.items.filter(item => item.completed).length;
  }

  getPendingCount(): number {
    return this.items.filter(item => !item.completed).length;
  }

  formatQuantity(item: ShoppingItem): string {
    if (!item.quantity || item.quantity === 1) {
      return item.unit ? `1 ${item.unit}` : '1';
    }
    return item.unit ? `${item.quantity} ${item.unit}` : `${item.quantity}`;
  }
}
