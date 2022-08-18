import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudAnnouncementComponent } from './crud-announcement.component';

describe('CrudAnnouncementComponent', () => {
  let component: CrudAnnouncementComponent;
  let fixture: ComponentFixture<CrudAnnouncementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudAnnouncementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudAnnouncementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
