import { Component, OnInit } from '@angular/core';
import { ProductListResponse } from "../model/productListResponse";
import { ProductListRequest } from "../model/productListRequest";
import { ProductListRoutingHttpService } from "../http/product-list-routing-http.service";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

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

}
