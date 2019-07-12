import { TestBed } from '@angular/core/testing';

import { ProductRoutingHttpService } from './product-routing-http.service';

describe('ProductRoutingHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductRoutingHttpService = TestBed.get(ProductRoutingHttpService);
    expect(service).toBeTruthy();
  });
});
