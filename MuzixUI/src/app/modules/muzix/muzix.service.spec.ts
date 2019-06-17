import { TestBed, inject } from '@angular/core/testing';

import { MuzixService } from './muzix.service';

describe('MuzixService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MuzixService]
    });
  });

  it('should be created', inject([MuzixService], (service: MuzixService) => {
    expect(service).toBeTruthy();
  }));
});
