import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularResultComponent } from './popular-result.component';

describe('PopularResultComponent', () => {
  let component: PopularResultComponent;
  let fixture: ComponentFixture<PopularResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
