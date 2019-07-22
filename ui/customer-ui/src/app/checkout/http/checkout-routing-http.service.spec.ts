import { TestBed } from '@angular/core/testing';

import { CheckoutRoutingHttpService } from './checkout-routing-http.service';

describe('CheckoutRoutingHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CheckoutRoutingHttpService = TestBed.get(CheckoutRoutingHttpService);
    expect(service).toBeTruthy();
  });
});
