import { Component, OnInit } from '@angular/core';
import { ProductService } from './services/product.service';
import { Product } from './models/product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  products: Product[] = [];
  filteredProducts: Product[] = [];
  searchTerm: string = '';
  selectedCategory: string = '';
  selectedSupplier: string = '';
  
  categories = ['ELECTRONICS', 'CLOTHING', 'FOOD', 'BOOKS', 'TOYS', 'SPORTS', 'HOME', 'BEAUTY', 'OTHER'];
  suppliers: string[] = [];
  
  showModal: boolean = false;
  editingProduct: Product | null = null;
  newProduct: Product = {
    name: '',
    description: '',
    sku: '',
    category: 'ELECTRONICS',
    price: 0,
    quantity: 0,
    supplier: '',
    location: '',
    minStockLevel: 10
  };

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getAllProducts().subscribe(
      (products) => {
        this.products = products;
        this.extractSuppliers();
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading products:', error);
      }
    );
  }

  extractSuppliers() {
    const supplierSet = new Set<string>();
    this.products.forEach(product => {
      if (product.supplier) {
        supplierSet.add(product.supplier);
      }
    });
    this.suppliers = Array.from(supplierSet).sort();
  }

  applyFilters() {
    let filtered = [...this.products];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.productService.searchProducts(this.searchTerm).subscribe(
        (searchedProducts) => {
          filtered = searchedProducts;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching products:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(products: Product[]) {
    let filtered = [...products];

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(product => product.category === this.selectedCategory);
    }

    // Apply supplier filter
    if (this.selectedSupplier && this.selectedSupplier !== '') {
      filtered = filtered.filter(product => product.supplier === this.selectedSupplier);
    }

    // Sort: out of stock first, then low stock, then by name
    filtered.sort((a, b) => {
      const aOutOfStock = this.isOutOfStock(a);
      const bOutOfStock = this.isOutOfStock(b);
      if (aOutOfStock && !bOutOfStock) return -1;
      if (!aOutOfStock && bOutOfStock) return 1;
      
      const aLowStock = this.isLowStock(a);
      const bLowStock = this.isLowStock(b);
      if (aLowStock && !bLowStock) return -1;
      if (!aLowStock && bLowStock) return 1;
      
      return (a.name || '').localeCompare(b.name || '');
    });

    this.filteredProducts = filtered;
  }

  isLowStock(product: Product): boolean {
    if (!product.quantity || !product.minStockLevel) {
      return false;
    }
    return product.quantity < product.minStockLevel;
  }

  isOutOfStock(product: Product): boolean {
    return !product.quantity || product.quantity === 0;
  }

  getStockStatus(product: Product): string {
    if (this.isOutOfStock(product)) {
      return 'OUT_OF_STOCK';
    }
    if (this.isLowStock(product)) {
      return 'LOW_STOCK';
    }
    return 'IN_STOCK';
  }

  onSearchChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onSupplierChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedCategory = '';
    this.selectedSupplier = '';
    this.applyFilters();
  }

  openModal(product?: Product) {
    if (product) {
      this.editingProduct = { ...product };
      this.newProduct = { ...product };
    } else {
      this.editingProduct = null;
      this.newProduct = {
        name: '',
        description: '',
        sku: '',
        category: 'ELECTRONICS',
        price: 0,
        quantity: 0,
        supplier: '',
        location: '',
        minStockLevel: 10
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingProduct = null;
  }

  saveProduct() {
    if (this.editingProduct) {
      this.updateProduct();
    } else {
      this.createProduct();
    }
  }

  createProduct() {
    this.productService.createProduct(this.newProduct).subscribe(
      (product) => {
        this.products.push(product);
        this.extractSuppliers();
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating product:', error);
      }
    );
  }

  updateProduct() {
    if (this.editingProduct && this.editingProduct.id) {
      this.productService.updateProduct(this.editingProduct.id, this.newProduct).subscribe(
        (product) => {
          const index = this.products.findIndex(p => p.id === product.id);
          if (index !== -1) {
            this.products[index] = product;
          }
          this.extractSuppliers();
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating product:', error);
        }
      );
    }
  }

  deleteProduct(id: number) {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe(
        () => {
          this.products = this.products.filter(p => p.id !== id);
          this.extractSuppliers();
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting product:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.products.length;
  }

  getLowStockCount(): number {
    return this.products.filter(p => this.isLowStock(p) && !this.isOutOfStock(p)).length;
  }

  getOutOfStockCount(): number {
    return this.products.filter(p => this.isOutOfStock(p)).length;
  }

  getTotalValue(): number {
    return this.products.reduce((total, product) => {
      if (product.price && product.quantity) {
        return total + (product.price * product.quantity);
      }
      return total;
    }, 0);
  }

  formatCurrency(amount: number | undefined): string {
    if (amount === undefined || amount === null) {
      return '$0.00';
    }
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD'
    }).format(amount);
  }

  getStockStatusClass(status: string): string {
    return `stock-${status.toLowerCase().replace('_', '-')}`;
  }

  getProductCardClass(product: Product): string {
    if (this.isOutOfStock(product)) return 'out-of-stock';
    if (this.isLowStock(product)) return 'low-stock';
    return '';
  }
}
