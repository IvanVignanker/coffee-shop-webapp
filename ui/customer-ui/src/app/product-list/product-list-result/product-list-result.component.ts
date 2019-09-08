import {Component, Input, OnInit, Output} from '@angular/core';
import {ProductListResponse} from "../model/productListResponse";

@Component({
  selector: 'app-product-list-result',
  templateUrl: './product-list-result.component.html',
  styleUrls: ['./product-list-result.component.css']
})
export class ProductListResultComponent implements OnInit {

  @Input('products') products: ProductListResponse;

  constructor() {
  }

  ngOnInit() {
  }
}
