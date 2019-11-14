import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SendProcessingComponent } from './send-processing.component';

describe('SendProcessingComponent', () => {
  let component: SendProcessingComponent;
  let fixture: ComponentFixture<SendProcessingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SendProcessingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SendProcessingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
