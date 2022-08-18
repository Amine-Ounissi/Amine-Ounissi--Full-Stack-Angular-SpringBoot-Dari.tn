import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservedetailsComponent } from './reservedetails.component';

describe('ReservedetailsComponent', () => {
  let component: ReservedetailsComponent;
  let fixture: ComponentFixture<ReservedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservedetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
