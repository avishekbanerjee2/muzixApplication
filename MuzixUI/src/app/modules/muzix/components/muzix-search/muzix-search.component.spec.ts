import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MuzixSearchComponent } from './muzix-search.component';

describe('MuzixSearchComponent', () => {
  let component: MuzixSearchComponent;
  let fixture: ComponentFixture<MuzixSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MuzixSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MuzixSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
