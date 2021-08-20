import { TestBed } from '@angular/core/testing';

import { VFieldsService } from './v-fields.service';

describe('VFieldsService', () => {
  let service: VFieldsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VFieldsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
