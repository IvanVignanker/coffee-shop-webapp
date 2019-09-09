import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ProductListResponse } from "../model/productListResponse";
import { ProductListRequest } from "../model/productListRequest";

@Injectable({
  providedIn: 'root'
})
export class ProductListRoutingHttpService {

  constructor(private httpClient: HttpClient) { }

  getProducts(productListRequest: ProductListRequest) :Observable<ProductListResponse> {
    return this.httpClient.post<ProductListResponse>("api/products", {productListRequest});
  }
}
