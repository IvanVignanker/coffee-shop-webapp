import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable } from "rxjs";
import { ProductListResponse } from "../../model/productListResponse";
import { ProductListRequest } from "../../model/productListRequest";

@Injectable({
  providedIn: 'root'
})
export class ProductListRoutingHttpService {

  constructor(private httpClient: HttpClient) { }

  getProducts(productListRequest: ProductListRequest) :Observable<ProductListResponse> {
    console.log(JSON.stringify(productListRequest).replace('_', ''));
    const httpOptions = {
      headers: new HttpHeaders(
        {
          'Authorization': 'Your Token',
          'Content-Type': 'application/json'
        })
    }
    return this.httpClient.post<ProductListResponse>("api/products",
      JSON.stringify(productListRequest).replace('_', ''), httpOptions)
  }
}
