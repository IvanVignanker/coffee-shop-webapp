import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Options } from "ng5-slider";
import {LocalStorageService} from "../services/localStorage/local-storage.service";

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  @Output() requestSearchForm = new EventEmitter();
  searchForm: FormGroup;

  search: string;
  bitterFrom: number;
  bitterTo: number;
  sourFrom: number;
  sourTo: number;
  decaf: boolean;
  ground: boolean;
  roasts: string;
  instant: boolean;

  options: Options = {
    floor: 0,
    ceil: 250
  };

  constructor(private localStorageService: LocalStorageService) { }

  ngOnInit() {
    this.searchForm = new FormGroup({
      search: new FormControl(''),
      sliderControl: new FormControl([0, 250]),
      bitterFrom: new FormControl(''),
      bitterTo: new FormControl(''),
      sourFrom: new FormControl(''),
      sourTo: new FormControl(''),
      decaf: new FormControl(''),
      ground: new FormControl(''),
      roasts: new FormControl(''),
      instant: new FormControl(''),
    });
  }

  onSubmit() {
    const formValue = this.searchForm.value;
    this.localStorageService.addSearchParams(formValue);
    this.requestSearchForm.emit();
  }

  onReset() {
    this.localStorageService.clearSearchParams();
  }
}
