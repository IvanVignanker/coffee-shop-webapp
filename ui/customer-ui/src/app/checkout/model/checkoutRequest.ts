import {CustomerInfo} from "./customerInfo";
import {Delivery} from "./delivery";
import {Products} from "./products";
import {Charges} from "./charges";
import {ContactInfo} from "./contactInfo";

export class CheckoutRequest {

  private _customerInfo: CustomerInfo;
  private _delivery: Delivery;
  private _products: Products;
  private _charges: Charges;

  constructor(customerInfo: CustomerInfo, delivery: Delivery, products: Products, charges: Charges) {
    this._customerInfo=customerInfo;
    this._delivery=delivery;
    this._products=products;
    this._charges=charges;
  }

  get customerInfo(): CustomerInfo {
    return this._customerInfo;
  }

  set customerInfo(value: CustomerInfo) {
    this._customerInfo = value;
  }

  get delivery(): Delivery {
    return this._delivery;
  }

  set delivery(value: Delivery) {
    this._delivery = value;
  }

  get products(): Products {
    return this._products;
  }

  set products(value: Products) {
    this._products = value;
  }

  get charges(): Charges {
    return this._charges;
  }

  set charges(value: Charges) {
    this._charges = value;
  }

  getDefaultRequest(): CheckoutRequest {
    return new CheckoutRequest(
      new CustomerInfo('Joe', 'joe@gmail.com','+9720000000',
      new ContactInfo('John', 'Jack', '+972535555555')),
      new Delivery('Joe', 'Tel Aviv', 'Main street', '45',
        '55', '6', 'no comments'),
      new Products(15, 33.33, 444),
      new Charges(11, 11.11));
  }
}
