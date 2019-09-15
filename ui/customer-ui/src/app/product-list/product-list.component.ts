import {Component, Injectable, OnInit} from '@angular/core';
import {ProductListResponse} from "./model/productListResponse";
import {ProductListRequest} from "./model/productListRequest";
import {ProductListRoutingHttpService} from "./services/http/product-list-routing-http.service";
import {LocalStorageService} from "./services/localStorage/local-storage.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

@Injectable()
export class ProductListComponent implements OnInit {

  public products: ProductListResponse;
  private defaultRequest: ProductListRequest = ProductListRequest.prototype.getDefaultRequest();

  constructor(private listRoutingHttpService: ProductListRoutingHttpService,
  private localStorageService: LocalStorageService) {}

  ngOnInit() {
    console.log(this.defaultRequest);
    this.getProductList(this.defaultRequest);
  }

  getProductList(productListRequest: ProductListRequest) {
    return this.listRoutingHttpService.getProducts(productListRequest).subscribe(data => {
      this.products = data;
    });
  }

  submitSearchForm() {
    this.getProductList(JSON.parse(this.localStorageService.getSearchParams()));
  }
}
