import {Component, Input, OnInit} from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";
import {ProductListRequest} from "../../model/productListRequest";
import {ProductListRoutingHttpService} from "../../http/product-list-routing-http.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-popular-result',
  templateUrl: './popular-result.component.html',
  styleUrls: ['./popular-result.component.css']
})
export class PopularResultComponent implements OnInit {

  @Input('products') products: ProductListResponse;

  constructor() { }

  ngOnInit() {
  }

  addToWishList() {
    console.log("Added to wishlist");
  }

  addToCard() {
    console.log("Added to cart");
  }
}
