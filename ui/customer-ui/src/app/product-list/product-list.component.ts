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

  constructor(private listRoutingHttpService: ProductListRoutingHttpService,
  private localStorageService: LocalStorageService) {}

  ngOnInit() {
    this.getProductList(JSON.parse(this.localStorageService.getSearchParams()));
  }

  getProductList(productListRequest: ProductListRequest) {
    return this.listRoutingHttpService.getProducts(productListRequest).subscribe(data => {
      this.products = data;
    });
  }

  resetSearchForm() {
    console.log(this.localStorageService.getSearchParams());
    this.getProductList(JSON.parse(this.localStorageService.getSearchParams()));
  }

  submitSearchForm() {
    this.getProductList(JSON.parse(this.localStorageService.getSearchParams()));
  }
}
