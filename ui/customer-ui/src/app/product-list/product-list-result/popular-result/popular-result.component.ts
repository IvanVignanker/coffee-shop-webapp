import { Component, OnInit } from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";
import {ProductListRequest} from "../../model/productListRequest";
import {ProductListRoutingHttpService} from "../../http/product-list-routing-http.service";

@Component({
  selector: 'app-popular-result',
  templateUrl: './popular-result.component.html',
  styleUrls: ['./popular-result.component.css']
})
export class PopularResultComponent implements OnInit {

  private json: string;
  public products: ProductListResponse;
  private defaultRequest: ProductListRequest = ProductListRequest.prototype.getDefaultRequest();

  constructor(private listRoutingHttpService: ProductListRoutingHttpService) { }

  getProductList(productListRequest: ProductListRequest) {
    return this.listRoutingHttpService.getProducts(productListRequest).subscribe(data => {
      this.products = data;
      this.json = JSON.stringify(this.products);
    });
  }

  ngOnInit() {
    this.getProductList(this.defaultRequest);
  }

  addToWishList() {
    console.log("Added to wishlist");
  }

  addToCadt() {
    console.log("Added to cart");
  }
}
