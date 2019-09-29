import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Options } from "ng5-slider";
import { LocalStorageService } from "../services/localStorage/local-storage.service";

export interface Request {
  page?: number;
  results?: number;
  sortBy?: string;
  search?: string;
  priceMin?: number;
  priceMax?: number;
  characteristics?: {
    bitterFrom?: number;
    bitterTo?: number;
    sourFrom?: number;
    sourTo?: number;
    strongFrom?: number;
    strongTo?: number;
    decaf?: boolean;
    ground?: boolean;
    coffeeType?: string;
  }
}

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  @Output() requestSearchForm = new EventEmitter();
  @Output() resetSearchForm = new EventEmitter();

  req: Request = {};

  pageModel: number = 0;
  resultsModel: number = 10;
  sortByModel: string = "popular | price | name";
  searchModel: string = "";
  priceMinModel: number = 0;
  priceMaxModel: number = 250;
  bitterFromModel: number = 1;
  bitterToModel: number = 5;
  sourFromModel: number = 1;
  sourToModel: number = 5;
  strongFromModel: number = 1;
  strongToModel: number = 5;
  decafModel: boolean = false;
  groundModel: boolean = true;
  coffeeTypeModel: string = "arabica";

  options: Options = {
    floor: 0,
    ceil: 250
  };

  constructor(private localStorageService: LocalStorageService) { }

  getRequest() {
    return this.req = {
      page: this.pageModel,
      results: this.resultsModel,
      search: this.searchModel,
      priceMin: this.priceMinModel,
      priceMax: this.priceMaxModel,
      sortBy: this.sortByModel,
      characteristics: {
        bitterFrom: this.bitterFromModel,
        bitterTo: this.bitterToModel,
        sourFrom: this.sourFromModel,
        sourTo: this.sourToModel,
        strongFrom: this.strongFromModel,
        strongTo: this.strongToModel,
        decaf: this.decafModel,
        ground: this.groundModel,
        coffeeType: this.coffeeTypeModel
      }
    }
  }

  setDefaultValues() {
    return this.req = {
      page: 0,
      results: 10,
      search: "",
      priceMin: 0,
      priceMax: 250,
      sortBy: "popular | price | name",
      characteristics: {
        bitterFrom: 1,
        bitterTo: 5,
        sourFrom: 1,
        sourTo: 5,
        strongFrom: 1,
        strongTo: 5,
        decaf: false,
        ground: true,
        coffeeType: "arabica"
      }
    }
  }

  ngOnInit() {
    this.localStorageService.addSearchParams(this.setDefaultValues());
    this.requestSearchForm.emit();
  }

  onSubmit() {
    this.localStorageService.addSearchParams(this.getRequest());
    this.requestSearchForm.emit();
  }

  onReset() {
    this.localStorageService.clearSearchParams();
    this.localStorageService.addSearchParams(this.setDefaultValues());
    this.resetSearchForm.emit();
  }
}
