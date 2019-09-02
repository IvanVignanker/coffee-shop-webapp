import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';

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
  decoffein: boolean;
  ground: boolean;

  constructor() { }

  ngOnInit() {
    this.searchForm = new FormGroup({
      search: new FormControl(''),
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
