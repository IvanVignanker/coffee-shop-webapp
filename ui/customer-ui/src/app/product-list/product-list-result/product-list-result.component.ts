import {Component, Input, OnInit, Output} from '@angular/core';
import {ProductListResponse} from "../model/productListResponse";
import {ProductListRequest} from "../model/productListRequest";
import {ProductListRoutingHttpService} from "../http/product-list-routing-http.service";

@Component({
  selector: 'app-product-list-result',
  templateUrl: './product-list-result.component.html',
  styleUrls: ['./product-list-result.component.css']
})
export class ProductListResultComponent implements OnInit {

  public products: ProductListResponse;
  private defaultRequest: ProductListRequest = ProductListRequest.prototype.getDefaultRequest();

  constructor(private listRoutingHttpService: ProductListRoutingHttpService) { }

  getProductList(productListRequest: ProductListRequest) {
    return this.listRoutingHttpService.getProducts(productListRequest).subscribe(data => {
      this.products = data;
    });
  }

  ngOnInit() {
    this.getProductList(this.defaultRequest);
  }
}
