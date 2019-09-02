import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RangeMultiplySliderComponent } from './range-multiply-slider.component';

describe('RangeMultiplySliderComponent', () => {
  let component: RangeMultiplySliderComponent;
  let fixture: ComponentFixture<RangeMultiplySliderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RangeMultiplySliderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RangeMultiplySliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
