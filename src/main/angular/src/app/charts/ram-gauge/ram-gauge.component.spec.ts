import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RamGaugeComponent } from './ram-gauge.component';

describe('RamGaugeComponent', () => {
  let component: RamGaugeComponent;
  let fixture: ComponentFixture<RamGaugeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RamGaugeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RamGaugeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
