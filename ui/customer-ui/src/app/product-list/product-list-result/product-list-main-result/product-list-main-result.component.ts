import { Component, OnInit } from '@angular/core';
import {ProductListResponse} from "../../model/productListResponse";
import {ProductListRequest} from "../../model/productListRequest";
import {ProductListRoutingHttpService} from "../../http/product-list-routing-http.service";

@Component({
  selector: 'app-product-list-main-result',
  templateUrl: './product-list-main-result.component.html',
  styleUrls: ['./product-list-main-result.component.css']
})
export class ProductListMainResultComponent implements OnInit {

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

  addToCadt() {
    console.log("Added to cart");
  }
}
