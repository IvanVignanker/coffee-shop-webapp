import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit {

  // @ts-ignore
  imageF = require('../../../assets/imagesSlider/photoForSlider3.jpg');
  // @ts-ignore
  imageS = require('../../../assets/imagesSlider/photoForSlider1.jpg');
  // @ts-ignore
  imageT = require('../../../assets/imagesSlider/photoForSlider2.jpg');
  // @ts-ignore
  imageFo = require('../../../assets/imagesSlider/photoForSlider5.jpg');
  // @ts-ignore
  imageSix = require('../../../assets/imagesSlider/photoForSlider4.png');

  constructor() {
  }

  ngOnInit() {
  }

}
