import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit {

  // @ts-ignore
  imageF = require('../../../assets/imagesSlider/header.jpg');
  // @ts-ignore
  imageS = require('../../../assets/imagesSlider/beeren.jpg');
  // @ts-ignore
  imageT = require('../../../assets/imagesSlider/guide-banner.jpg');
  // @ts-ignore
  imageFo = require('../../../assets/imagesSlider/tropical-beach-garden-view.jpg');
  // @ts-ignore
  imageSix = require('../../../assets/imagesSlider/Image_Product Listing.png');

  constructor() {
  }

  ngOnInit() {
  }

}
