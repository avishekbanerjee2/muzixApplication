import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MuzixDialogComponent } from './muzix-dialog.component';

describe('MovieDialogComponent', () => {
  let component: MuzixDialogComponent;
  let fixture: ComponentFixture<MuzixDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MuzixDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MuzixDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
