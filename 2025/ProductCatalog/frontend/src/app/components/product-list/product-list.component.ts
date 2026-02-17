import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  filteredProducts: Product[] = [];
  searchTerm: string = '';
  selectedCategory: string = 'all';
  categories: string[] = ['all', 'Electronics', 'Clothing', 'Books', 'Food', 'Sports', 'Home', 'Other'];
  showModal: boolean = false;
  editingProduct: Product | null = null;
  isEditMode: boolean = false;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe({
      next: (data) => {
        this.products = data;
        this.filteredProducts = data;
      },
      error: (error) => {
        console.error('Error loading products:', error);
      }
    });
  }

  searchProducts(): void {
    if (this.searchTerm.trim()) {
      this.productService.searchProducts(this.searchTerm).subscribe({
        next: (data) => {
          this.filteredProducts = data;
          if (this.selectedCategory !== 'all') {
            this.filteredProducts = this.filteredProducts.filter(
              p => p.category.toLowerCase() === this.selectedCategory.toLowerCase()
            );
          }
        },
        error: (error) => {
          console.error('Error searching products:', error);
        }
      });
    } else {
      this.filterProducts();
    }
  }

  filterProducts(): void {
    if (this.selectedCategory === 'all') {
      this.filteredProducts = this.products;
    } else {
      this.filteredProducts = this.products.filter(
        p => p.category.toLowerCase() === this.selectedCategory.toLowerCase()
      );
    }

    if (this.searchTerm.trim()) {
      this.filteredProducts = this.filteredProducts.filter(
        p => p.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }
  }

  onCategoryChange(): void {
    this.filterProducts();
  }

  openAddModal(): void {
    this.editingProduct = {
      name: '',
      description: '',
      price: 0,
      quantity: 0,
      category: 'Electronics'
    };
    this.isEditMode = false;
    this.showModal = true;
  }

  openEditModal(product: Product): void {
    this.editingProduct = { ...product };
    this.isEditMode = true;
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingProduct = null;
    this.isEditMode = false;
  }

  saveProduct(product: Product): void {
    if (this.isEditMode && product.id) {
      this.productService.updateProduct(product.id, product).subscribe({
        next: () => {
          this.loadProducts();
          this.closeModal();
        },
        error: (error) => {
          console.error('Error updating product:', error);
        }
      });
    } else {
      this.productService.createProduct(product).subscribe({
        next: () => {
          this.loadProducts();
          this.closeModal();
        },
        error: (error) => {
          console.error('Error creating product:', error);
        }
      });
    }
  }

  deleteProduct(id: number): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe({
        next: () => {
          this.loadProducts();
        },
        error: (error) => {
          console.error('Error deleting product:', error);
        }
      });
    }
  }
}
