import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginUpComponent } from './login-up.component';

describe('LoginUpComponent', () => {
  let component: LoginUpComponent;
  let fixture: ComponentFixture<LoginUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginUpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
