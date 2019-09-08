import {Component, Input, OnInit} from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";

@Component({
  selector: 'app-product-list-main-result',
  templateUrl: './product-list-main-result.component.html',
  styleUrls: ['./product-list-main-result.component.css']
})
export class ProductListMainResultComponent implements OnInit {

  @Input('products') products: ProductListResponse;

  constructor() {}

  ngOnInit() {
  }

  addToCard() {
    console.log("Added to cart");
  }
}
