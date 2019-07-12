import { Injectable } from '@angular/core';
import { ProductDetails } from "../../model/productDetails/productDetails";
import { HttpClient} from "@angular/common/http";
import { Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductRoutingHttpService {

  constructor(private httpClient: HttpClient) { }

  getProductDetailsById(productId: number) : Observable<ProductDetails> {
    return this.httpClient.get<ProductDetails>("api/customer/products/" + productId);
  }
}
