import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListMainResultComponent } from './product-list-main-result.component';

describe('ProductListMainResultComponent', () => {
  let component: ProductListMainResultComponent;
  let fixture: ComponentFixture<ProductListMainResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductListMainResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductListMainResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
