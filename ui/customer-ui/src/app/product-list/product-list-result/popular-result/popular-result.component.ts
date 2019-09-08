import {Component, Input, OnInit} from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";

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
