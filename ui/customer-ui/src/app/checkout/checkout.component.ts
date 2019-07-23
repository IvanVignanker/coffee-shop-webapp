import { Component, Injectable, OnInit } from '@angular/core';
import { CheckoutRoutingHttpService } from "./http/checkout-routing-http.service";
import { Router } from "@angular/router";
import { CheckoutRequest } from "./model/checkoutRequest";
import { CheckoutResponse } from "./model/checkoutResponse";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})

@Injectable()
export class CheckoutComponent implements OnInit {

  // private json: string;
  private checkoutResponse: CheckoutResponse;
  private defaultRequest: CheckoutRequest = CheckoutRequest.prototype.getDefaultRequest();

  constructor(private checkoutRoutingHttpService: CheckoutRoutingHttpService,
              private router: Router) {}

  getCheckout(checkoutRequest: CheckoutRequest) {
    return this.checkoutRoutingHttpService.getCheckout(checkoutRequest).subscribe(data => {
      this.checkoutResponse = data;
      // this.json = JSON.stringify(this.checkoutResponse);
      this.router.navigate(['/received/' + this.checkoutResponse.orderId]);
    });
  }

  ngOnInit() {
    this.getCheckout(this.defaultRequest);
  }
}
