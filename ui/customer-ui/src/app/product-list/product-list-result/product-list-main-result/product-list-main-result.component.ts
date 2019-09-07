import {Component, Input, OnInit} from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";
import {ProductListRequest} from "../../model/productListRequest";
import {ProductListRoutingHttpService} from "../../http/product-list-routing-http.service";
import {Products} from "../../../checkout/model/products";

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
