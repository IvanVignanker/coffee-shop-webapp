import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LabelType, Options} from "ng5-slider";
import {LocalStorageService} from "../services/localStorage/local-storage.service";
import {ProductListRequest} from "../model/productListRequest";
import {Characteristics} from "../model/characteristics";

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  @Output() requestSearchForm = new EventEmitter();

  search: string = "";
  priceMin: number = 0;
  priceMax: number = 250;
  bitterFrom: number = 1;
  bitterTo: number = 5;
  sourFrom: number = 1;
  sourTo: number = 5;
  strongFrom: number = 1;
  strongTo: number = 5;
  decaf: boolean = false;
  ground: boolean = false;

  options: Options = {
    floor: 0,
    ceil: 250,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return '$' + value;
        case LabelType.High:
          return '$' + value;
        default:
          return '$' + value;
      }
    }
  };

  constructor(private localStorageService: LocalStorageService) { }

  getRequest() :ProductListRequest {
    return new ProductListRequest(1, 10, this.search,
      this.priceMin, this.priceMax, 'popular',
      new Characteristics(this.bitterFrom, this.bitterTo,
        this.sourFrom, this.sourTo, this.strongFrom, this.strongTo,
        this.decaf, this.ground, 'arabica'));
  }

  ngOnInit() {
    this.getRequest();
  }

  onSubmit() {
    console.log(this.getRequest());
    this.localStorageService.addSearchParams(this.getRequest());
    this.requestSearchForm.emit();
  }

  onReset() {
    this.localStorageService.clearSearchParams();
  }
}
