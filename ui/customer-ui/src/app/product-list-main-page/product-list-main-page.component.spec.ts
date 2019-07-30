import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListMainPageComponent } from './product-list-main-page.component';

describe('ProductListMainPageComponent', () => {
  let component: ProductListMainPageComponent;
  let fixture: ComponentFixture<ProductListMainPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductListMainPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductListMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
