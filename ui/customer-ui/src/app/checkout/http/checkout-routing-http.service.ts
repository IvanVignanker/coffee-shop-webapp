import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CheckoutRequest } from "../model/checkoutRequest";
import { CheckoutResponse } from "../model/checkoutResponse";

@Injectable({
  providedIn: 'root'
})
export class CheckoutRoutingHttpService {

  constructor(private httpClient: HttpClient) { }

  getCheckout(checkoutRequest: CheckoutRequest) : Observable<CheckoutResponse> {
    return this.httpClient.post<CheckoutResponse>('api/customer/checkout/', {checkoutRequest});
  }
}
