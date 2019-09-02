import { AfterViewChecked, Component, OnInit, Input } from '@angular/core';
import { Options } from 'ng5-slider';
import {FormControl, FormGroup} from "@angular/forms";
import {SliderServiceService} from "../range-slider-service/slider-service.service";

@Component({
  selector: 'app-range-multiply-slider',
  templateUrl: './range-multiply-slider.component.html',
  styleUrls: ['./range-multiply-slider.component.css']
})
export class RangeMultiplySliderComponent implements OnInit {

  constructor(private sliderService: SliderServiceService) { }

  sliderForm: FormGroup;

  options: Options = {
    floor: 0,
    ceil: 250
  };

  ngOnInit() {
    this.sliderForm = new FormGroup({
      sliderControl: new FormControl([0, 250])
    });
  }

  onSubmit() {
    const formValue = this.sliderForm.value;
    console.log(formValue);
  }

  resetForm(): void {
    this.sliderForm.reset({sliderControl: [0, 250]});
  }

  // npm install
  // npm i ngx-bootstrap
  // npm i @ng-bootstrap/ng-bootstrap
  // npm install jquery
  // npm install bootstrap
  // npm i ng5-slider
  // npm run dev
  // https://angular-slider.github.io/ng5-slider/demos#range-slider

}
