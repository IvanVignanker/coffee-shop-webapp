import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Options } from "ng5-slider";

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  searchForm: FormGroup;

  search: string;
  bitterMin: number;
  bitterMax: number;
  sourMin: number;
  sourMax: number;
  roasts: string;
  instant: boolean;
  decoffeein: boolean;
  ground: boolean;

  options: Options = {
    floor: 0,
    ceil: 250
  };

  constructor() { }

  ngOnInit() {
    this.searchForm = new FormGroup({
      search: new FormControl(''),
      sliderControl: new FormControl([0, 250]),
      bitterMin: new FormControl(''),
      bitterMax: new FormControl(''),
      sourMin: new FormControl(''),
      sourMax: new FormControl(''),
      roasts: new FormControl(''),
      instant: new FormControl(''),
      decoffeein: new FormControl(''),
      ground: new FormControl(''),
    });
  }

  onSubmit() {
    const formValue = this.searchForm.value;
    console.log(formValue);
  }
}
