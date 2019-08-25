import {CustomerInfo} from "./customerInfo";
import {Delivery} from "./delivery";
import {Products} from "./products";
import {ContactInfo} from "./contactInfo";

export class CheckoutRequest {
  private _customerInfo: CustomerInfo;
  private _products: Products;

  constructor(customerInfo: CustomerInfo, products: Products) {
    this._customerInfo=customerInfo;
    this._products=products;
  }

  get customerInfo(): CustomerInfo {
    return this._customerInfo;
  }

  set customerInfo(value: CustomerInfo) {
    this._customerInfo = value;
  }

  get products(): Products {
    return this._products;
  }

  set products(value: Products) {
    this._products = value;
  }

  getDefaultRequest(): CheckoutRequest {
    return new CheckoutRequest(
      new CustomerInfo('Joe', 'joe@gmail.com','+9720000000',
      new ContactInfo('John', 'Jack', '+972535555555'),
      new Delivery('Joe', 'Tel Aviv', 'Main street', '45',
        '55', '6', 'no comments')),
      new Products(15, 33.33, 444));
  }
}
