import {Component, Injectable, OnInit} from '@angular/core';
import {ProductListResponse} from "./model/productListResponse";
import {ProductListRequest} from "./model/productListRequest";
import {ProductListRoutingHttpService} from "./http/product-list-routing-http.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

@Injectable()
export class ProductListComponent implements OnInit {

  public products: ProductListResponse;
  private defaultRequest: ProductListRequest = ProductListRequest.prototype.getDefaultRequest();

  constructor(private listRoutingHttpService: ProductListRoutingHttpService) {}

  ngOnInit() {
    this.getProductList(this.defaultRequest);
  }

  getProductList(productListRequest: ProductListRequest) {
    return this.listRoutingHttpService.getProducts(productListRequest).subscribe(data => {
      this.products = data;
    });
  }

  submitSearchForm(json) {
    console.log(json);
  }
}
