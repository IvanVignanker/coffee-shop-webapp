import { ContactInfo } from "./contactInfo";
import { Delivery } from "./delivery";

export class CustomerInfo {

  private _entityName: string;
  private _email: string;
  private _phoneNumber: string;
  private _contactInfo: ContactInfo;
  private _delivery: Delivery;

  constructor(entityName: string, email: string, phoneNumber: string, contactInfo: ContactInfo, delivery: Delivery,) {
    this._entityName=entityName;
    this._email=email;
    this._phoneNumber=phoneNumber;
    this._contactInfo=contactInfo;
    this._delivery=delivery;
  }

  get entityName(): string {
    return this._entityName;
  }

  set entityName(value: string) {
    this._entityName = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get phoneNumber(): string {
    return this._phoneNumber;
  }

  set phoneNumber(value: string) {
    this._phoneNumber = value;
  }
  get delivery(): Delivery {
    return this._delivery;
  }

  set delivery(value: Delivery) {
    this._delivery = value;
  }
}
