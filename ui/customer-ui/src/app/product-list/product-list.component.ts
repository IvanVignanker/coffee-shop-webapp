import {Component, Injectable, OnInit} from '@angular/core';
import { ProductListRoutingHttpService } from "./http/product-list-routing-http.service";
import { ProductListResponse } from "./model/productListResponse";
import {ProductListRequest} from "./model/productListRequest";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

@Injectable()
export class ProductListComponent implements OnInit {

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
