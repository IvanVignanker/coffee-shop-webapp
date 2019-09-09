import { TestBed } from '@angular/core/testing';

import { ProductListRoutingHttpService } from './product-list-routing-http.service';

describe('ProductListRoutingHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductListRoutingHttpService = TestBed.get(ProductListRoutingHttpService);
    expect(service).toBeTruthy();
  });
});
