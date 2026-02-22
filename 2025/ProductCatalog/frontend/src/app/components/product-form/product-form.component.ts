import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  @Input() product!: Product;
  @Input() isEditMode: boolean = false;
  @Output() save = new EventEmitter<Product>();
  @Output() cancel = new EventEmitter<void>();

  formProduct: Product = {
    name: '',
    description: '',
    price: 0,
    quantity: 0,
    category: 'Electronics'
  };

  categories: string[] = ['Electronics', 'Clothing', 'Books', 'Food', 'Sports', 'Home', 'Other'];

  ngOnInit(): void {
    if (this.product) {
      this.formProduct = { ...this.product };
    }
  }

  onSubmit(): void {
    if (this.isValid()) {
      this.save.emit(this.formProduct);
    }
  }

  onCancel(): void {
    this.cancel.emit();
  }

  isValid(): boolean {
    return !!(
      this.formProduct.name?.trim() &&
      this.formProduct.description?.trim() &&
      this.formProduct.price > 0 &&
      this.formProduct.quantity >= 0 &&
      this.formProduct.category
    );
  }
}
