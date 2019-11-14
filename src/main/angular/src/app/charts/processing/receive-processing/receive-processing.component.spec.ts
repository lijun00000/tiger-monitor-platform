import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiveProcessingComponent } from './receive-processing.component';

describe('ReceiveProcessingComponent', () => {
  let component: ReceiveProcessingComponent;
  let fixture: ComponentFixture<ReceiveProcessingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiveProcessingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiveProcessingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
