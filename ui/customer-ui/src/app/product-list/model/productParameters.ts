export class ProductParameters {

  private _strong: number;
  private _bitter: number;
  private _sour: number;
  private _decaf: boolean;
  private _coffeeType: string;

  constructor(strong: number, bitter: number, sour: number, decaf: boolean, coffeeType: string){
    this._strong=strong;
    this._bitter=bitter;
    this._sour=sour;
    this._decaf=decaf;
    this._coffeeType=coffeeType;
  }

  get sour(): number {
    return this._sour;
  }

  set sour(value: number) {
    this._sour = value;
  }

  get bitter(): number {
    return this._bitter;
  }

  set bitter(value: number) {
    this._bitter = value;
  }

  get strong(): number {
    return this._strong;
  }

  set strong(value: number) {
    this._strong = value;
  }

  get decaf(): boolean {
    return this._decaf;
  }

  set decaf(value: boolean) {
    this._decaf = value;
  }

  get coffeeType(): string {
    return this._coffeeType;
  }

  set coffeeType(value: string) {
    this._coffeeType = value;
  }
}
